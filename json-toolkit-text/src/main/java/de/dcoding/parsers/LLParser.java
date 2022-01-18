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

package de.dcoding.parsers;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Abstract base class for LL parser implementations
 * 
 * @since  1.0
 */
public abstract class LLParser<T> extends Parser<T> {
  private LinkedList<Token> tokens;
  /**
   * The lookahead tokens that are used by the parsing process.
   */
  protected Token[] lookahead;

  /**
   * Constructs a new LLParser instance with a specified lookahead size.
   * 
   * @param lookahead The size of the lookahead that will be used for the LL parser
   */
  protected LLParser(int lookahead) {
    this.lookahead = new Token[lookahead];
  }

  /**
   * Parse the given input into an object defined by concrete implementation of class.
   * 
   * @param input The input string that will be parsed
   * @return The parsed object
   * @throws ParserException If parsing malformed data
   */
  @Override
  public T parse(String input) throws ParserException {
    initializeTokens(input);
    
    return processStartSymbol();
  }

  private void initializeTokens(String input) throws ParserException {
    Iterator<? extends Token> tokenizer = getTokenizer(input);
    tokens = new LinkedList<Token>();

    while (tokenizer.hasNext()) {
      Token token = tokenizer.next();
      
      if (isRelevantToken(token)) {
        tokens.add(token);
      }
    }

    updateLookahead();
  }

  /**
   * Evaluates if a specified token is relevant for the parsing process.
   * 
   * @param token The token which is to be evaluated
   * @return If the token is relevant or can be ignored
   * @throws ParserException If token is indicating an error state
   */
  protected abstract boolean isRelevantToken(Token token) throws ParserException;

  private void updateLookahead() {
    int tokensSize = tokens.size();

    for (int i = 0, j = lookahead.length; i < j; i++) {
      if (i < tokensSize) {
        lookahead[i] = tokens.get(i);
      } else {
        lookahead[i] = null;
      }
    }
  }

  /**
   * Updates internal data structures while iterating over tokens.
   */
  protected void nextToken() {
    tokens.pop();
    updateLookahead();
  }

  /**
   * The start of the parsing process by a concrete implementation.
   * 
   * @return The parsed object
   * @throws ParserException If processing malformed data
   */
  protected abstract T processStartSymbol() throws ParserException;
}
