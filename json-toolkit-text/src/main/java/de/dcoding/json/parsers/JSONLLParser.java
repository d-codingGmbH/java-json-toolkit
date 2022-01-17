/*
 * Copyright (C) 2022 d-coding GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.dcoding.json.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.dcoding.json.*;
import de.dcoding.json.tokens.*;
import de.dcoding.parsers.*;

/**
 * Implementation of an LL parser for parsing a JSON string representation to objects
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class JSONLLParser extends LLParser<JSONValue> {
  private static final Pattern UNICODE_PATTERN = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
  
  /**
   * Constructs a new instance of a {@link LLParser} for {@link JSONValue}s with a lookahead of 1.
   */
  public JSONLLParser() {
    super(1);
  }
  
  /**
   * Parse the given input into a {@link JSONValue} instance.
   * 
   * @param input The input string that will be parsed
   * @return The parsed object
   * @throws ParserException
   */
  @Override
  public JSONValue parse(String input) throws ParserException {
    if ((input == null) || input.matches("^\\s*$")) {
      return null;
    } else {
      return super.parse(input);
    }
  }

  /**
   * Returns a {@link JSONTokenizer} instance which is used by the parsing process.
   * 
   * @param input The input string that will be parsed
   * @return The tokenizer instance
   */
  @Override
  protected JSONTokenizer getTokenizer(String input) {
    return new JSONTokenizer(input);
  }
  
  /**
   * Evaluates if a specified token is relevant for the parsing process.
   * 
   * @param token The token which is to be evaluated
   * @return If the token is relevant or can be ignored
   * @throws ParserException
   */
  @Override
  protected boolean isRelevantToken(Token token) throws ParserException {
    if (token instanceof ErrorToken) {
      String message = String.format("Illegal character at position: %d", ((ErrorToken)token).at());
      throw new ParserException(message);
    }
    
    return !(token instanceof JSONWhitespaceToken);
  }

  /**
   * The start of the parsing process.
   * 
   * @return The parsed object
   * @throws ParserException
   */
  @Override
  protected JSONValue processStartSymbol() throws ParserException {
    return processValue();
  }

  private JSONValue processObject() throws ParserException {
    JSONObject object = new JSONObject();
    
    nextToken();
    processRestOfObject(object);
    
    return object;
  }

  private void processRestOfObject(JSONObject object) throws ParserException {
    Token lookaheadZero = lookahead[0];
    
    if (lookaheadZero instanceof JSONEndObjectToken) {
      nextToken();
    } else if (lookaheadZero instanceof JSONStringToken) {
      processMember(object);
      processMembers(object);
      nextToken();
    } else {
      String message = String.format("Unexpected token found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
  }
  
  private void processMembers(JSONObject object) throws ParserException {
    Token lookaheadZero = lookahead[0];
    
    if (lookaheadZero instanceof JSONValueSeparatorToken) {
      nextToken();
      processMember(object);
      processMembers(object);
    } else if (!(lookaheadZero instanceof JSONEndObjectToken)) {
      String message = String.format("Expected token: JSONEndObjectToken. Found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
  }

  private void processMember(JSONObject object) throws ParserException {
    Token lookaheadZero = lookahead[0];
    if (!(lookaheadZero instanceof JSONStringToken)) {
      String message = String.format("Expected token: JSONStringToken. Found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
    String key = unescapeString(((JSONStringToken)lookahead[0]).getValue());
    
    nextToken();
    lookaheadZero = lookahead[0];
    if (!(lookaheadZero instanceof JSONNameSeparatorToken)) {
      String message = String.format("Expected token: JSONNameSeparatorToken. Found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
    
    nextToken();
    JSONValue value = processValue();
    
    object.put(key, value);
  }

  private JSONArray processArray() throws ParserException {
    JSONArray array = new JSONArray();
    
    nextToken();
    processRestOfArray(array);
    
    return array;
  }
  
  private void processRestOfArray(JSONArray array) throws ParserException {
    Token lookaheadZero = lookahead[0];
    
    if (lookaheadZero instanceof JSONEndArrayToken) {
      nextToken();
    } else if ((lookaheadZero instanceof JSONBeginObjectToken)
            || (lookaheadZero instanceof JSONBeginArrayToken)
            || (lookaheadZero instanceof JSONTrueToken)
            || (lookaheadZero instanceof JSONFalseToken)
            || (lookaheadZero instanceof JSONNullToken)
            || (lookaheadZero instanceof JSONStringToken)
            || (lookaheadZero instanceof JSONNumberToken)) {
      JSONValue value = processValue();
      array.add(value);
      processValues(array);
      nextToken();
    } else {
      String message = String.format("Unexpected token found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
  }
  
  private void processValues(JSONArray array) throws ParserException {
    Token lookaheadZero = lookahead[0];

    if (lookaheadZero instanceof JSONValueSeparatorToken) {
      nextToken();
      JSONValue value = processValue();
      array.add(value);
      processValues(array);
    } else if (!(lookaheadZero instanceof JSONEndArrayToken)) {
      String message = String.format("Expected token: JSONEndArrayToken. Found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
  }

  private JSONValue processValue() throws ParserException {
    Token lookaheadZero = lookahead[0];

    if (lookaheadZero instanceof JSONBeginObjectToken) {
      return processObject();
    } else if (lookaheadZero instanceof JSONBeginArrayToken) {
      return processArray();
    } else if (lookaheadZero instanceof JSONTrueToken) {
      nextToken();
      return new JSONTrue();
    } else if (lookaheadZero instanceof JSONFalseToken) {
      nextToken();
      return new JSONFalse();
    } else if (lookaheadZero instanceof JSONNullToken) {
      nextToken();
      return new JSONNull();
    } else if (lookaheadZero instanceof JSONStringToken) {
      String value = unescapeString(((JSONStringToken)lookaheadZero).getValue());
      nextToken();
      return new JSONString(value);
    } else if (lookaheadZero instanceof JSONNumberToken) {
      String value = ((JSONNumberToken)lookaheadZero).getValue();
      nextToken();
      return new JSONNumber(value);
    } else {
      String message = String.format("Unexpected token found: %s", lookaheadZero.getClass().getSimpleName());
      throw new ParserException(message);
    }
  }
  
  private String unescapeString(String value) {
    String unquoted = unquoteString(value);
    String replaced = unquoted.replace("\\\"", "\"");
    replaced = replaced.replace("\\\\", "\\");
    replaced = replaced.replace("\\/", "/");
    replaced = replaced.replace("\\b", "\b");
    replaced = replaced.replace("\\f", "\f");
    replaced = replaced.replace("\\n", "\n");
    replaced = replaced.replace("\\r", "\r");
    replaced = replaced.replace("\\t", "\t");
    
    Matcher matcher = UNICODE_PATTERN.matcher(replaced);
    StringBuffer stringBuffer = new StringBuffer(replaced.length());
    
    while (matcher.find()) {
      String codepointString = matcher.group(1);
      Integer codePoint = Integer.parseInt(codepointString, 16);
      char[] chars = Character.toChars(codePoint);
      matcher.appendReplacement(stringBuffer,  new String(chars));
    }
    
    matcher.appendTail(stringBuffer);
    
    return stringBuffer.toString();
  }
  
  private String unquoteString(String value) {
    int length = value.length() - 1;
    return value.substring(1, length);
  }
}
