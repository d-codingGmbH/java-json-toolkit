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

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.dcoding.json.tokens.*;
import de.dcoding.parsers.ErrorToken;
import de.dcoding.parsers.Token;

/**
 * Tokenizer for use in JSON parsers
 * 
 * @since  1.0
 */
public class JSONTokenizer implements Iterator<Token> {
  private boolean erroneous;
  private String input;
  private int position;
  
  private static final String TRUE_PATTERN = "true";
  private static final String FALSE_PATTERN = "false";
  private static final String NULL_PATTERN = "null";
  private static final String BEGIN_OBJECT_PATTERN = "\\{";
  private static final String END_OBJECT_PATTERN = "\\}";
  private static final String VALUE_SEPARATOR_PATTERN = ",";
  private static final String NAME_SEPARATOR_PATTERN = ":";
  private static final String BEGIN_ARRAY_PATTERN = "\\[";
  private static final String END_ARRAY_PATTERN = "\\]";
  private static final Pattern WHITESPACE_PATTERN = Pattern.compile("[\\r\\n\\t ]+");
  private static final Pattern NUMBER_PATTERN = Pattern.compile("-?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?");
  private static final Pattern STRING_PATTERN = Pattern.compile("\"([\\x20\\x21\\u0023-\\u005b\\u005d-\\x{10ffff}]|\\\\([bfnrt\\u0022\\u005c\\u002f]|u[0-9a-fA-F]{4}))*\"");
  
  /**
   * Constructs a new tokenizer implementation for textual JSON representations.
   * 
   * @param input The textual JSON representation
   */
  public JSONTokenizer(String input) {
    setInput(input);
  }

  private void setInput(String input) {
    this.input = input;
    position = 0;
  }

  /**
   * Returns if there is at least one more token or if the end of the input is reached.
   * 
   * @return If there is at least one more token
   */
  @Override
  public boolean hasNext() {
    return (!(erroneous || (input.length() == 0)));
  }

  /**
   * Returns the next token instance.
   * 
   * @return The next token instance
   */
  @Override
  public Token next() {
    Token token = null;
    
    if (input.matches(String.format("(?s)%s.*", WHITESPACE_PATTERN.pattern()))) {
      Matcher matcher = WHITESPACE_PATTERN.matcher(input);
      matcher.find();
      token = new JSONWhitespaceToken(position);
      input = input.substring(matcher.end());
      position += matcher.end();
    } else if (input.matches(String.format("(?s)%s.*", TRUE_PATTERN))) {
      token = new JSONTrueToken(position);
      input = input.substring(4);
      position += 4;
    } else if (input.matches(String.format("(?s)%s.*", FALSE_PATTERN))) {
      token = new JSONFalseToken(position);
      input = input.substring(5);
      position += 5;
    } else if (input.matches(String.format("(?s)%s.*", NULL_PATTERN))) {
      token = new JSONNullToken(position);
      input = input.substring(4);
      position += 4;
    } else if (input.matches(String.format("(?s)%s.*", NUMBER_PATTERN.pattern()))) {
      Matcher matcher = NUMBER_PATTERN.matcher(input);
      matcher.find();
      String value = matcher.group();
      token = new JSONNumberToken(position, value);
      input = input.substring(matcher.end());
      position += matcher.end();
    } else if (input.matches(String.format("(?s)%s.*", STRING_PATTERN.pattern()))) {
      Matcher matcher = STRING_PATTERN.matcher(input);
      matcher.find();
      String value = matcher.group();
      token = new JSONStringToken(position, value);
      input = input.substring(matcher.end());
      position += matcher.end();
    } else if (input.matches(String.format("(?s)%s.*", BEGIN_OBJECT_PATTERN))) {
      token = new JSONBeginObjectToken(position);
      input = input.substring(1);
      position++;
    } else if (input.matches(String.format("(?s)%s.*", END_OBJECT_PATTERN))) {
      token = new JSONEndObjectToken(position);
      input = input.substring(1);
      position++;
    } else if (input.matches(String.format("(?s)%s.*", VALUE_SEPARATOR_PATTERN))) {
      token = new JSONValueSeparatorToken(position);
      input = input.substring(1);
      position++;
    } else if (input.matches(String.format("(?s)%s.*", NAME_SEPARATOR_PATTERN))) {
      token = new JSONNameSeparatorToken(position);
      input = input.substring(1);
      position++;
    } else if (input.matches(String.format("(?s)%s.*", BEGIN_ARRAY_PATTERN))) {
      token = new JSONBeginArrayToken(position);
      input = input.substring(1);
      position++;
    } else if (input.matches(String.format("(?s)%s.*", END_ARRAY_PATTERN))) {
      token = new JSONEndArrayToken(position);
      input = input.substring(1);
      position++;
    }
    
    if (token == null) {
      erroneous = true;
      token = new ErrorToken(position);
    }

    return token;
  }

  /**
   * Would remove the current token instance from the underlying collection.
   * It is not supported by the current implementation.
   * 
   * @throws UnsupportedOperationException The method is not supported
   */
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
