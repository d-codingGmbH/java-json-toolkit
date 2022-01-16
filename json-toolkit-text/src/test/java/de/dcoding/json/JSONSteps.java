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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import de.dcoding.json.parsers.JSONLLParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for JSON tests
 * 
 * SHOULD be split into group of steps by domain function
 *
 * @author David Ullrich <david.ullrich@ovsoftware.de>
 * @since  1.0
 */
public class JSONSteps {
  private JSONValue jsonValue;
  private String stringValue;
  private boolean addSpaceAfterObjectBegin;
  private boolean addSpaceBeforeObjectEnd;
  private boolean addSpaceBeforeNameValueSeparator;
  private boolean addSpaceAfterNameValueSeparator;
  private boolean addSpaceBeforeMemberSeparator;
  private boolean addSpaceAfterMemberSeparator;
  private boolean addNewlineAfterObjectBegin;
  private boolean addNewlineBeforeObjectEnd;
  private boolean addNewlineAfterMemberSeparator;
  private boolean addSpaceAfterArrayBegin;
  private boolean addSpaceBeforeArrayEnd;
  private boolean addSpaceBeforeValueSeparator;
  private boolean addSpaceAfterValueSeparator;
  private boolean addNewlineAfterArrayBegin;
  private boolean addNewlineBeforeArrayEnd;
  private boolean addNewlineAfterValueSeparator;
  private String newlineString;
  private String indentionString;

  @Given("^the String \"(.*)\"$")
  public void theString(String value) throws Throwable {
    stringValue = value;
  }

  @Given("^a String containing the escaped character (quotation mark|reverse solidus|solidus|backspace|form feed|line feed|carriage return|character tabulation|upper case code point|lower case code point)$")
  public void aStringContainingTheEscapedCharacterQuotationMark(String character) throws Throwable {
    switch (character) {
      case "quotation mark":
        stringValue = String.format("\"special char: %s\"", "\\\"");
        break;
      case "reverse solidus":
        stringValue = String.format("\"special char: %s\"", "\\\\");
        break;
      case "solidus":
        stringValue = String.format("\"special char: %s\"", "\\/");
        break;
      case "backspace":
        stringValue = String.format("\"special char: %s\"", "\\b");
        break;
      case "form feed":
        stringValue = String.format("\"special char: %s\"", "\\f");
        break;
      case "line feed":
        stringValue = String.format("\"special char: %s\"", "\\n");
        break;
      case "carriage return":
        stringValue = String.format("\"special char: %s\"", "\\r");
        break;
      case "character tabulation":
        stringValue = String.format("\"special char: %s\"", "\\t");
        break;
      case "upper case code point":
        stringValue = String.format("\"special char: %s\"", "\\u002F");
        break;
      case "lower case code point":
        stringValue = String.format("\"special char: %s\"", "\\u002f");
        break;
    }
  }

  @Given("^we have a JSON true$")
  public void weHaveAJSONTrue() throws Throwable {
    jsonValue = new JSONTrue();
  }

  @Given("^we have a JSON false$")
  public void weHaveAJSONFalse() throws Throwable {
    jsonValue = new JSONFalse();
  }

  @Given("^we have a JSON null$")
  public void weHaveAJSONNull() throws Throwable {
    jsonValue = new JSONNull();
  }

  @Given("^we have the JSON number (.+)$")
  public void weHaveAJSONNumber(String value) throws Throwable {
    jsonValue = new JSONNumber(value);
  }

  @Given("^we have the JSON string \"(.*)\"$")
  public void weHaveAJSONString(String value) throws Throwable {
    jsonValue = new JSONString(value);
  }

  @Given("^we have a JSON object$")
  public void weHaveAJSONObject() throws Throwable {
    jsonValue = new JSONObject();
  }

  @Given("^we have a JSON array$")
  public void weHaveAJSONArray() throws Throwable {
    jsonValue = new JSONArray();
  }

  @Given("^we set the property \"([^\"]*)\" to value (\\d+)$")
  public void we_add_set_the_property_to_value(String property, Integer value) throws Throwable {
    JSONNumber numberValue = new JSONNumber(value.toString());
    ((JSONObject) jsonValue).put(property, numberValue);
  }

  @Given("^we set the property \"([^\"]*)\" to value \"([^\"]*)\"$")
  public void we_add_set_the_property_to_value(String property, String value) throws Throwable {
    JSONString stringValue = new JSONString(value);
    ((JSONObject) jsonValue).put(property, stringValue);
  }

  @Given("^we add the number (\\d+)$")
  public void weAddTheNumber(Integer value) throws Throwable {
    JSONNumber jsonNumber = new JSONNumber(value.toString());
    ((JSONArray) jsonValue).add(jsonNumber);
  }

  @Given("^we set the property \"([^\"]*)\" to an empty JSON object$")
  public void weSetThePropertyToAnEmptyJSONObject(String value) throws Throwable {
    ((JSONObject) jsonValue).put(value, new JSONObject());
  }

  @Given("^we set the property \"([^\"]*)\" to an empty JSON array$")
  public void weSetThePropertyToAnEmptyJSONArray(String value) throws Throwable {
    ((JSONObject) jsonValue).put(value, new JSONArray());
  }

  @Given("^we add an empty JSON object$")
  public void weAddAnEmptyJSONObject() throws Throwable {
    ((JSONArray) jsonValue).add(new JSONObject());
  }

  @Given("^we have a JSON string representing the code point \"([^\"]*)\"$")
  public void weHaveAJSONStringRepresentingTheCodePoint(String codePoint) throws Throwable {
    String hexCode = codePoint.substring(2);
    Character character = (char) Integer.parseInt(hexCode, 16);
    jsonValue = new JSONString(character.toString());
  }

  @Given("^we add an empty JSON array$")
  public void weAddAnEmptyJSONArray() throws Throwable {
    ((JSONArray) jsonValue).add(new JSONArray());
  }

  @Given("^we add space after object begin$")
  public void weAddSpaceAfterObjectBegin() throws Throwable {
    addSpaceAfterObjectBegin = true;
  }

  @Given("^we add space before object end$")
  public void weAddSpaceBeforeObjectEnd() throws Throwable {
    addSpaceBeforeObjectEnd = true;
  }

  @Given("^we add space before name value separator$")
  public void weAddSpaceBeforeNameValueSeparator() throws Throwable {
    addSpaceBeforeNameValueSeparator = true;
  }

  @Given("^we add space after name value separator$")
  public void weAddSpaceAfterNameValueSeparator() throws Throwable {
    addSpaceAfterNameValueSeparator = true;
  }

  @Given("^we add space before member separator$")
  public void weAddSpaceBeforeMemberSeparator() throws Throwable {
    addSpaceBeforeMemberSeparator = true;
  }

  @Given("^we add space after member separator$")
  public void weAddSpaceAfterMemberSeparator() throws Throwable {
    addSpaceAfterMemberSeparator = true;
  }

  @Given("^we add newline after object begin$")
  public void weAddNewlineAfterObjectBegin() throws Throwable {
    addNewlineAfterObjectBegin = true;
  }

  @Given("^we add newline before object end$")
  public void weAddNewlineBeforeObjectEnd() throws Throwable {
    addNewlineBeforeObjectEnd = true;
  }

  @Given("^we add space after array begin$")
  public void weAddSpaceAfterArrayBegin() throws Throwable {
    addSpaceAfterArrayBegin = true;
  }

  @Given("^we add space before array end$")
  public void weAddSpaceBeforeArrayEnd() throws Throwable {
    addSpaceBeforeArrayEnd = true;
  }

  @Given("^we add space before value separator$")
  public void weAddSpaceBeforeValueSeparator() throws Throwable {
    addSpaceBeforeValueSeparator = true;
  }

  @Given("^we add space after value separator$")
  public void weAddSpaceAfterValueSeparator() throws Throwable {
    addSpaceAfterValueSeparator = true;
  }

  @Given("^we add newline after array begin$")
  public void weAddNewlineAfterArrayBegin() throws Throwable {
    addNewlineAfterArrayBegin = true;
  }

  @Given("^we add newline before array end$")
  public void weAddNewlineBeforeArrayEnd() throws Throwable {
    addNewlineBeforeArrayEnd = true;
  }

  @Given("^we add newline after value separator$")
  public void weAddNewlineAfterValueSeparator() throws Throwable {
    addNewlineAfterValueSeparator = true;
  }

  @Given("^we set indention to (\\d+) spaces$")
  public void weSetIndentionToSpaces(int arg1) throws Throwable {
    if (arg1 < 0) {
      throw new IllegalArgumentException();
    }

    indentionString = getSpaces(arg1);
  }

  private String getSpaces(int count) {
    if (count == 0) {
      return "";
    } else if (count == 1) {
      return " ";
    } else if ((count % 2) == 0) {
      String part = getSpaces(count >> 1);
      return part + part;
    } else {
      return getSpaces(count - 1) + " ";
    }
  }

  @Given("^we add newline after member separator$")
  public void weAddNewlineAfterMemberSeparator() throws Throwable {
    addNewlineAfterMemberSeparator = true;
  }

  @Given("^we set newline to illegal string$")
  public void weSetNewlineToIllegalString() throws Throwable {
    newlineString = "foo";
  }

  @Given("^we set indention to illegal string$")
  public void weSetIndentionToIllegalString() throws Throwable {
    indentionString = "foo";
  }

  @When("^we parse it$")
  public void weParseIt() throws Throwable {
    JSONLLParser parser = new JSONLLParser();
    jsonValue = parser.parse(stringValue);
  }

  @When("^we convert it to a String$")
  public void weConvertItToAString() throws Throwable {
    stringValue = jsonValue.toString();
  }

  @When("^we convert it to a formatted String$")
  public void weConvertItToAFormattedString() throws Throwable {
    JSONFormatter formatter = new JSONFormatter();
    JSONFormatterSettings settings = formatter.getSettings();

    settings.setAddNewlineAfterObjectBegin(addNewlineAfterObjectBegin);
    settings.setAddSpaceAfterObjectBegin(addSpaceAfterObjectBegin);
    settings.setAddNewlineBeforeObjectEnd(addNewlineBeforeObjectEnd);
    settings.setAddSpaceBeforeObjectEnd(addSpaceBeforeObjectEnd);
    settings.setAddSpaceBeforeNameValueSeparator(addSpaceBeforeNameValueSeparator);
    settings.setAddSpaceAfterNameValueSeparator(addSpaceAfterNameValueSeparator);
    settings.setAddSpaceBeforeMemberSeparator(addSpaceBeforeMemberSeparator);
    settings.setAddNewlineAfterMemberSeparator(addNewlineAfterMemberSeparator);
    settings.setAddSpaceAfterMemberSeparator(addSpaceAfterMemberSeparator);
    settings.setAddNewlineAfterArrayBegin(addNewlineAfterArrayBegin);
    settings.setAddSpaceAfterArrayBegin(addSpaceAfterArrayBegin);
    settings.setAddNewlineBeforeArrayEnd(addNewlineBeforeArrayEnd);
    settings.setAddSpaceBeforeArrayEnd(addSpaceBeforeArrayEnd);
    settings.setAddSpaceBeforeValueSeparator(addSpaceBeforeValueSeparator);
    settings.setAddNewlineAfterValueSeparator(addNewlineAfterValueSeparator);
    settings.setAddSpaceAfterValueSeparator(addSpaceAfterValueSeparator);
    settings.setNewlineString(newlineString);
    settings.setIndentionString(indentionString);

    stringValue = formatter.toString(jsonValue);
  }

  @Then("^we expect a null$")
  public void weExpectANull() throws Throwable {
    assertNull("Null expected but value found", jsonValue);
  }

  @Then("^we expect a JSONTrue$")
  public void weExpectAJSONTrue() throws Throwable {
    assertTrue("Not a JSONTrue", jsonValue instanceof JSONTrue);
  }

  @Then("^we expect a JSONFalse$")
  public void weExpectAJSONFalse() throws Throwable {
    assertTrue("Not a JSONFalse", jsonValue instanceof JSONFalse);
  }

  @Then("^we expect a JSONNull$")
  public void weExpectAJSONNull() throws Throwable {
    assertTrue("Not a JSONNull", jsonValue instanceof JSONNull);
  }

  @Then("^we expect a JSONString$")
  public void weExpectAJSONString() throws Throwable {
    assertTrue("Not a JSONString", jsonValue instanceof JSONString);
  }

  @Then("^we expect a JSONNumber$")
  public void weExpectAJSONNumber() throws Throwable {
    assertTrue("Not a JSONNumber", jsonValue instanceof JSONNumber);
  }

  @Then("^we expect a JSONObject$")
  public void weExpectAJSONObject() throws Throwable {
    assertTrue("Not a JSONObject", jsonValue instanceof JSONObject);
  }

  @Then("^we expect (\\d+) members$")
  public void weExpectMembers(int expected) throws Throwable {
    JSONObject casted = (JSONObject) jsonValue;

    assertEquals("Unexpected count of members", expected, casted.size());
  }

  @Then("^we expect a JSONArray$")
  public void weExpectAJSONArray() throws Throwable {
    assertTrue("Not a JSONArray", jsonValue instanceof JSONArray);
  }

  @Then("^we expect (\\d+) elements$")
  public void weExpectElements(int expected) throws Throwable {
    JSONArray casted = (JSONArray) jsonValue;

    assertEquals("Unexpected count of elements", expected, casted.size());
  }

  @Then("^we expect the member \"([^\"]*)\" exists$")
  public void weExpectTheMemberExists(String name) throws Throwable {
    JSONObject casted = (JSONObject) jsonValue;

    assertTrue("Member not found", casted.containsKey(name));
  }

  @Then("^we expect the member \"([^\"]*)\" is a JSONString$")
  public void weExpectTheMemberIsAJSONString(String name) throws Throwable {
    JSONObject casted = (JSONObject) jsonValue;
    JSONValue member = casted.get(name);

    assertTrue("Not a JSONString", member instanceof JSONString);
  }

  @Then("^we expect the member \"([^\"]*)\" is a JSONObject$")
  public void weExpectTheMemberIsAJSONObject(String name) throws Throwable {
    JSONObject casted = (JSONObject) jsonValue;
    JSONValue member = casted.get(name);

    assertTrue("Not a JSONObject", member instanceof JSONObject);
  }

  @Then("^we expect the member \"([^\"]*)\" is a JSONArray$")
  public void weExpectTheMemberIsAJSONArray(String name) throws Throwable {
    JSONObject casted = (JSONObject) jsonValue;
    JSONValue member = casted.get(name);

    assertTrue("Not a JSONArray", member instanceof JSONArray);
  }

  @Then("^we expect the value (\\d+) is a JSONString$")
  public void weExpectTheValueIsAJSONString(int oneBasedIndex) throws Throwable {
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONString", value instanceof JSONString);
  }

  @Then("^we expect the value (\\d+) is a JSONNumber$")
  public void weExpectTheValueIsAJSONNumber(int oneBasedIndex) throws Throwable {
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONNumber", value instanceof JSONNumber);
  }

  @Then("^we expect the value (\\d+) is a JSONObject$")
  public void weExpectTheValueIsAJSONObject(int oneBasedIndex) throws Throwable {
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONObject", value instanceof JSONObject);
  }

  @Then("^we expect the value (\\d+) is a JSONArray$")
  public void weExpectTheValueIsAJSONArray(int oneBasedIndex) throws Throwable {
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONArray", value instanceof JSONArray);
  }

  @Then("^it should have the length of (\\d+)$")
  public void havingTheLengthOf(int value) throws Throwable {
    JSONString casted = (JSONString) jsonValue;

    assertEquals(value, casted.getValue().length());
  }

  @Then("^we expect \"((?:[^\"]|\\\")*)\"$")
  public void weExpect(String value) throws Throwable {
    assertEquals(value, stringValue);
  }

  @Then("^we expect$")
  public void weExpectMultiline(String value) throws Throwable {
    assertEquals(value, stringValue);
  }

  @Then("^we expect the length (\\d+)$")
  public void weExpectTheLength(int value) throws Throwable {
    String message = String.format("The string is: %s", stringValue);
    assertEquals(message, value, stringValue.length());
  }
}
