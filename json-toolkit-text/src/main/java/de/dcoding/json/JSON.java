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

package de.dcoding.json;

import de.dcoding.json.parsers.JSONLLParser;
import de.dcoding.parsers.Parser;
import de.dcoding.parsers.ParserException;

/**
 * Helper class for static convenience methods
 * 
 * @since  1.0
 */
public class JSON {
  private static Parser<JSONValue> parser = null;
  private static JSONFormatter formatter = null;

  /**
   * Returns a default {@link Parser} implementation for parsing {@link JSONValue}s.
   * The instance can be set with {@link #setParser(Parser)}. If not parser is set
   * an instance of {@link JSONLLParser} is initialized and used.
   * 
   * @return The default parser
   */
  public static Parser<JSONValue> getParser() {
    if (parser == null) {
      parser = new JSONLLParser();
    }

    return parser;
  }

  /**
   * Saves the specified {@link Parser} implementation as the parser to use.
   * A value of {@code null} is permitted and drops the currently initialized instance.
   * 
   * @param value The default parser
   */
  public static void setParser(Parser<JSONValue> value) {
    parser = value;
  }

  /**
   * Returns the default formatter. If no default formatter is configured via
   * {@link #setFormatter(JSONFormatter)} a new {@link JSONFormatter} instance with
   * default settings is initialized.
   * 
   * @return The default formatter
   */
  public static JSONFormatter getFormatter() {
    if (formatter == null) {
      formatter = new JSONFormatter();
    }

    return formatter;
  }

  /**
   * Stores a {@link JSONFormatter} instance as the default formatter.
   * A value of {@code null} is permitted and drops the currently initialized instance.
   * 
   * @param value The default formatter
   */
  public static void setFormatter(JSONFormatter value) {
    formatter = value;
  }

  /**
   * Converts a textual representation of a JSON value into an instance of {@link JSONValue}
   * using the default parser. To initialize a default parser {@link #setParser(Parser)} can be used.
   * 
   * @param text The textual representation
   * @return The parsed {@link JSONValue}
   * @throws ParserException Exception while parsing the textual representation
   */
  public static JSONValue decode(String text) throws ParserException {
    Parser<JSONValue> parser = getParser();
    return decode(text, parser);
  }

  /**
   * Converts a textual representation of a JSON value into an instance of {@link JSONValue}
   * using the specified {@link Parser} implementation.
   * 
   * @param text The textual representation
   * @param parser The parser to use
   * @return The parsed {@link JSONValue}
   * @throws ParserException Exception while parsing the textual representation
   */
  public static JSONValue decode(String text, Parser<JSONValue> parser) throws ParserException {
    if (parser == null) {
      throw new IllegalArgumentException();
    }

    JSONValue value = parser.parse(text);
    return value;
  }

  /**
   * Converts an instance of a {@link JSONValue} as text using the default {@link JSONFormatter} instance.
   * To initialize a the default formatter {@link #setFormatter(JSONFormatter)} can be used.
   * 
   * @param value The {@link JSONValue} instance to be formatted as text
   * @return The textual representation
   */
  public static String encode(JSONValue value) {
    JSONFormatter formatter = getFormatter();
    return encode(value, formatter);
  }

  /**
   * Converts an instance of a {@link JSONValue} as text using the specified {@link JSONFormatter}.
   * 
   * @param value The {@link JSONValue} instance to be formatted as text
   * @param formatter The {@link JSONFormatter} to use
   * @return The textual representation
   */
  public static String encode(JSONValue value, JSONFormatter formatter) {
    String result = formatter.toString(value);
    return result;
  }
}
