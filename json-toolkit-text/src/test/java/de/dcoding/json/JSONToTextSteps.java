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
import io.cucumber.java.en.When;

/**
 * Step definitions for converting JSON values to possibly formatted text
 *
 * @since  1.0
 */
public class JSONToTextSteps {
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
  public void weSetIndentionToSpaces(int count) throws Throwable {
    if (count < 0) {
      throw new IllegalArgumentException();
    }

    indentionString = getSpaces(count);
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

  @When("^we encode it$")
  public void weEncodeIt() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    String stringValue = JSON.encode(jsonValue);
    JSONSteps.setStringValue(stringValue);
  }

  @When("^we convert it to a String$")
  public void weConvertItToAString() throws Throwable {
    JSONValue jsonValue = JSONSteps.getJSONValue();
    String stringValue = jsonValue.toString();
    JSONSteps.setStringValue(stringValue);
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

    JSONValue jsonValue = JSONSteps.getJSONValue();
    String stringValue = formatter.toString(jsonValue);
    JSONSteps.setStringValue(stringValue);
  }
}
