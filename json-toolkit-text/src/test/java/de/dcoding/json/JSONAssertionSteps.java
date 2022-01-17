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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;

/**
 * Step definitions for JSON tests
 *
 * @author David Ullrich <david.ullrich@ovsoftware.de>
 * @since  1.0
 */
public class JSONAssertionSteps {
  @Then("^we expect a null$")
  public void weExpectANull() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertNull("Null expected but value found", jsonValue);
  }

  @Then("^we expect a JSONTrue$")
  public void weExpectAJSONTrue() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONTrue", jsonValue instanceof JSONTrue);
  }

  @Then("^we expect a JSONFalse$")
  public void weExpectAJSONFalse() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONFalse", jsonValue instanceof JSONFalse);
  }

  @Then("^we expect a JSONNull$")
  public void weExpectAJSONNull() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONNull", jsonValue instanceof JSONNull);
  }

  @Then("^we expect a JSONString$")
  public void weExpectAJSONString() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONString", jsonValue instanceof JSONString);
  }

  @Then("^we expect a JSONNumber$")
  public void weExpectAJSONNumber() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONNumber", jsonValue instanceof JSONNumber);
  }

  @Then("^we expect a JSONObject$")
  public void weExpectAJSONObject() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONObject", jsonValue instanceof JSONObject);
  }

  @Then("^we expect (\\d+) members$")
  public void weExpectMembers(int expected) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONObject casted = (JSONObject) jsonValue;

    assertEquals("Unexpected count of members", expected, casted.size());
  }

  @Then("^we expect a JSONArray$")
  public void weExpectAJSONArray() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    assertTrue("Not a JSONArray", jsonValue instanceof JSONArray);
  }

  @Then("^we expect (\\d+) elements$")
  public void weExpectElements(int expected) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONArray casted = (JSONArray) jsonValue;

    assertEquals("Unexpected count of elements", expected, casted.size());
  }

  @Then("^we expect the member \"([^\"]*)\" exists$")
  public void weExpectTheMemberExists(String name) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONObject casted = (JSONObject) jsonValue;

    assertTrue("Member not found", casted.containsKey(name));
  }

  @Then("^we expect the member \"([^\"]*)\" is a JSONString$")
  public void weExpectTheMemberIsAJSONString(String name) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONObject casted = (JSONObject) jsonValue;
    JSONValue member = casted.get(name);

    assertTrue("Not a JSONString", member instanceof JSONString);
  }

  @Then("^we expect the member \"([^\"]*)\" is a JSONObject$")
  public void weExpectTheMemberIsAJSONObject(String name) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONObject casted = (JSONObject) jsonValue;
    JSONValue member = casted.get(name);

    assertTrue("Not a JSONObject", member instanceof JSONObject);
  }

  @Then("^we expect the member \"([^\"]*)\" is a JSONArray$")
  public void weExpectTheMemberIsAJSONArray(String name) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONObject casted = (JSONObject) jsonValue;
    JSONValue member = casted.get(name);

    assertTrue("Not a JSONArray", member instanceof JSONArray);
  }

  @Then("^we expect the value (\\d+) is a JSONString$")
  public void weExpectTheValueIsAJSONString(int oneBasedIndex) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONString", value instanceof JSONString);
  }

  @Then("^we expect the value (\\d+) is a JSONNumber$")
  public void weExpectTheValueIsAJSONNumber(int oneBasedIndex) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONNumber", value instanceof JSONNumber);
  }

  @Then("^we expect the value (\\d+) is a JSONObject$")
  public void weExpectTheValueIsAJSONObject(int oneBasedIndex) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONObject", value instanceof JSONObject);
  }

  @Then("^we expect the value (\\d+) is a JSONArray$")
  public void weExpectTheValueIsAJSONArray(int oneBasedIndex) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONArray casted = (JSONArray) jsonValue;
    JSONValue value = casted.get(oneBasedIndex - 1);

    assertTrue("Not a JSONArray", value instanceof JSONArray);
  }

  @Then("^it should have the length of (\\d+)$")
  public void havingTheLengthOf(int value) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONString casted = (JSONString) jsonValue;

    assertEquals(value, casted.getValue().length());
  }

  @Then("^we expect \"((?:[^\"]|\\\")*)\"$")
  public void weExpect(String value) throws Throwable {
    String stringValue = JSONSteps.getStringValue();
    assertEquals(value, stringValue);
  }

  @Then("^we expect$")
  public void weExpectMultiline(String value) throws Throwable {
    String stringValue = JSONSteps.getStringValue();
    assertEquals(value, stringValue);
  }

  @Then("^we expect the length (\\d+)$")
  public void weExpectTheLength(int value) throws Throwable {
    String stringValue = JSONSteps.getStringValue();
    String message = String.format("The string is: %s", stringValue);
    assertEquals(message, value, stringValue.length());
  }

  @Then("^we expect the exception to be of type (.+Exception)$")
  public void weExpectAnException(String expectedException) throws Throwable {
    List<Exception> exceptions = JSONSteps.getExceptions();
    assertNotNull("No exception was thrown", exceptions);
    assertFalse("No exception was thrown", exceptions.isEmpty());

    Exception exception = exceptions.get(0);
    String exceptionName = exception.getClass().getSimpleName();
    assertEquals("Wrong type of exception was thrown", expectedException, exceptionName);
  }

  @Then("^we expect access as (Integer|Floating Point) to be not null$")
  public void weExpectAccessAsTypeToBeNotNull(String numberType) throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    JSONNumber jsonNumber = (JSONNumber)jsonValue;

    String assertionErrorMessage;
    switch (numberType) {
      case "Integer":
        assertionErrorMessage = String.format("Integer value expected, but not found: \"%s\"", jsonNumber.getValue());
        assertTrue(assertionErrorMessage, jsonNumber.isInteger());
        assertNotNull(assertionErrorMessage, jsonNumber.getIntegerValue());
        
        assertionErrorMessage = String.format("Floating point value not expected, but found: \"%s\"", jsonNumber.getValue());
        assertFalse(assertionErrorMessage, jsonNumber.isFloatingPoint());
        assertNull(assertionErrorMessage, jsonNumber.getFloatingPointValue());
        break;
      case "Floating Point":
        assertionErrorMessage = String.format("Floating point value expected, but not found: \"%s\"", jsonNumber.getValue());
        assertTrue(assertionErrorMessage, jsonNumber.isFloatingPoint());
        assertNotNull(assertionErrorMessage, jsonNumber.getFloatingPointValue());

        assertionErrorMessage = String.format("Integer value not expected, but found: \"%s\"", jsonNumber.getValue());
        assertFalse(assertionErrorMessage, jsonNumber.isInteger());
        assertNull(assertionErrorMessage, jsonNumber.getIntegerValue());
        break;
    }
  }
}
