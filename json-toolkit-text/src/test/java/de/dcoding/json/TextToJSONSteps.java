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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Step definitions for converting text to JSON values
 *
 * @author David Ullrich <david.ullrich@ovsoftware.de>
 * @since  1.0
 */
public class TextToJSONSteps {
  @Given("^the String \"(.*)\"$")
  public void theString(String value) throws Throwable {
    JSONSteps.setStringValue(value);
  }

  @Given("^a String containing the escaped character (quotation mark|reverse solidus|solidus|backspace|form feed|line feed|carriage return|character tabulation|upper case code point|lower case code point)$")
  public void aStringContainingTheEscapedCharacterQuotationMark(String character) throws Throwable {
    String text = null;

    switch (character) {
      case "quotation mark":
        text = String.format("\"special char: %s\"", "\\\"");
        break;
      case "reverse solidus":
        text = String.format("\"special char: %s\"", "\\\\");
        break;
      case "solidus":
        text = String.format("\"special char: %s\"", "\\/");
        break;
      case "backspace":
        text = String.format("\"special char: %s\"", "\\b");
        break;
      case "form feed":
        text = String.format("\"special char: %s\"", "\\f");
        break;
      case "line feed":
        text = String.format("\"special char: %s\"", "\\n");
        break;
      case "carriage return":
        text = String.format("\"special char: %s\"", "\\r");
        break;
      case "character tabulation":
        text = String.format("\"special char: %s\"", "\\t");
        break;
      case "upper case code point":
        text = String.format("\"special char: %s\"", "\\u002F");
        break;
      case "lower case code point":
        text = String.format("\"special char: %s\"", "\\u002f");
        break;
    }

    if (text != null) {
      JSONSteps.setStringValue(text);
    }
  }

  @When("^we parse it$")
  public void weParseIt() throws Throwable {
    JSONLLParser parser = new JSONLLParser();
    String stringValue = JSONSteps.getStringValue();
    JSONValue jsonValue = parser.parse(stringValue);
    JSONSteps.setJSONValue(jsonValue);
  }

  @When("^we decode it$")
  public void weDecodeIt() throws Throwable {
    String stringValue = JSONSteps.getStringValue();
    JSONValue jsonValue = JSON.decode(stringValue);
    JSONSteps.setJSONValue(jsonValue);
  }
}
