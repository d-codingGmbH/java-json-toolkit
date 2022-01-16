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

/**
 * Abstract base class for different parser implementations
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public abstract class Parser<T> {
  /**
   * Returns a tokenizer implementation which is used by the parsing process.
   * 
   * @param input The input string that will be parsed
   * @return The tokenizer instance
   */
  protected abstract Iterator<? extends Token> getTokenizer(String input);
  
  /**
   * Parse the given input into an object defined by concrete implementation of class.
   * 
   * @param input The input string that will be parsed
   * @return The parsed object
   * @throws ParserException
   */
  public abstract T parse(String input) throws ParserException;
}
