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
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */

public class JSON {
  private static Parser<JSONValue> parser = null;
  private static JSONFormatter formatter = null;

  public static Parser<JSONValue> getParser() {
    if (parser == null) {
      parser = new JSONLLParser();
    }

    return parser;
  }

  public static void setParser(Parser<JSONValue> value) {
    parser = value;
  }

  public static JSONFormatter getFormatter() {
    if (formatter == null) {
      formatter = new JSONFormatter();
    }

    return formatter;
  }

  public static void setFormatter(JSONFormatter value) {
    formatter = value;
  }

  public static JSONValue decode(String text) throws ParserException {
    Parser<JSONValue> parser = getParser();
    return decode(text, parser);
  }

  public static JSONValue decode(String text, Parser<JSONValue> parser) throws ParserException {
    if (parser == null) {
      throw new IllegalArgumentException();
    }

    JSONValue value = parser.parse(text);
    return value;
  }

  public static String encode(JSONValue value) {
    JSONFormatter formatter = getFormatter();
    return encode(value, formatter);
  }

  public static String encode(JSONValue value, JSONFormatter formatter) {
    String result = formatter.toString(value);
    return result;
  }
}
