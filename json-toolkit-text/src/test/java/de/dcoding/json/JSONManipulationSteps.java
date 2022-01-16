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

import io.cucumber.java.en.Given;

/**
 * Step definitions for creating and manipulating JSON values
 *
 * @author David Ullrich <david.ullrich@ovsoftware.de>
 * @since  1.0
 */
public class JSONManipulationSteps {
  @Given("^we have a JSON true$")
  public void weHaveAJSONTrue() throws Throwable {
    JSONValue jsonValue = new JSONTrue();
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we have a JSON false$")
  public void weHaveAJSONFalse() throws Throwable {
    JSONValue jsonValue = new JSONFalse();
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we have a JSON null$")
  public void weHaveAJSONNull() throws Throwable {
    JSONValue jsonValue = new JSONNull();
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we have the JSON number (.+)$")
  public void weHaveAJSONNumber(String value) throws Throwable {
    JSONValue jsonValue = new JSONNumber(value);
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we have the JSON string \"(.*)\"$")
  public void weHaveAJSONString(String value) throws Throwable {
    JSONValue jsonValue = new JSONString(value);
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we have a JSON object$")
  public void weHaveAJSONObject() throws Throwable {
    JSONValue jsonValue = new JSONObject();
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we have a JSON array$")
  public void weHaveAJSONArray() throws Throwable {
    JSONValue jsonValue = new JSONArray();
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we set the property \"([^\"]*)\" to value (\\d+)$")
  public void weSetThePropertyToValue(String property, Integer value) throws Throwable {
    JSONNumber numberValue = new JSONNumber(value.toString());
    JSONObject jsonObject = (JSONObject) JSONSteps.getJSONValue();
    jsonObject.put(property, numberValue);
  }

  @Given("^we set the property \"([^\"]*)\" to value \"([^\"]*)\"$")
  public void weSetThePropertyToValue(String property, String value) throws Throwable {
    JSONString stringValue = new JSONString(value);
    JSONObject jsonObject = (JSONObject) JSONSteps.getJSONValue();
    jsonObject.put(property, stringValue);
  }

  @Given("^we add the number (\\d+)$")
  public void weAddTheNumber(Integer value) throws Throwable {
    JSONNumber jsonNumber = new JSONNumber(value.toString());
    JSONArray jsonArray = (JSONArray) JSONSteps.getJSONValue();
    jsonArray.add(jsonNumber);
  }

  @Given("^we set the property \"([^\"]*)\" to an empty JSON object$")
  public void weSetThePropertyToAnEmptyJSONObject(String value) throws Throwable {
    JSONObject jsonObject = (JSONObject) JSONSteps.getJSONValue();
    jsonObject.put(value, new JSONObject());
  }

  @Given("^we set the property \"([^\"]*)\" to an empty JSON array$")
  public void weSetThePropertyToAnEmptyJSONArray(String value) throws Throwable {
    JSONObject jsonObject = (JSONObject) JSONSteps.getJSONValue();
    jsonObject.put(value, new JSONArray());
  }

  @Given("^we add an empty JSON object$")
  public void weAddAnEmptyJSONObject() throws Throwable {
    JSONArray jsonArray = (JSONArray) JSONSteps.getJSONValue();
    jsonArray.add(new JSONObject());
  }

  @Given("^we have a JSON string representing the code point \"([^\"]*)\"$")
  public void weHaveAJSONStringRepresentingTheCodePoint(String codePoint) throws Throwable {
    String hexCode = codePoint.substring(2);
    Character character = (char) Integer.parseInt(hexCode, 16);
    JSONValue jsonValue = new JSONString(character.toString());
    JSONSteps.setJSONValue(jsonValue);
  }

  @Given("^we add an empty JSON array$")
  public void weAddAnEmptyJSONArray() throws Throwable {
    JSONArray jsonArray = (JSONArray) JSONSteps.getJSONValue();
    jsonArray.add(new JSONArray());
  }
}