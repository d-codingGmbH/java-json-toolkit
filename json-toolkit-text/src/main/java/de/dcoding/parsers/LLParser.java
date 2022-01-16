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
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public abstract class LLParser<T> extends Parser<T> {
  private LinkedList<Token> tokens;
  protected Token[] lookahead;

  protected LLParser(int lookahead) {
    this.lookahead = new Token[lookahead];
  }

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

  protected void nextToken() {
    tokens.pop();
    updateLookahead();
  }

  protected abstract T processStartSymbol() throws ParserException;
}
