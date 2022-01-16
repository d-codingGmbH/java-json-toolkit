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

import java.util.Map.Entry;

/**
 * JSON Formatter to convert a JSONValue into a formatted String
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class JSONFormatter {
  private static final String STRING_SPACE = " ";
  private static final String STRING_OBJECT_START = "{";
  private static final String STRING_OBJECT_END = "}";
  private static final String STRING_MEMBER_SEPARATOR = ",";
  private static final String STRING_NAME_VALUE_SEPARATOR = ":";
  private static final String STRING_ARRAY_START = "[";
  private static final String STRING_ARRAY_END = "]";
  private static final String STRING_ELEMENT_SEPARATOR = ",";

  private JSONFormatterSettings settings;
  private String currentIndention = "";

  public JSONFormatter() {
    this(new JSONFormatterSettings());
  }

  public JSONFormatter(JSONFormatterSettings settings) {
    setSettings(settings);
  }

  public String toString(JSONValue value) {
    if (value == null) {
      return null;
    } else {
      if (value instanceof JSONObject) {
        return toString((JSONObject) value);
      } else if (value instanceof JSONArray) {
        return toString((JSONArray) value);
      } else {
        return value.toString();
      }
    }
  }

  private String toString(JSONObject object) {
    boolean isEmptyObject = (object.size() == 0);
    StringBuilder builder = new StringBuilder((object.size() << 1) + 1);
    
    builder.append(STRING_OBJECT_START);
    appendStartOfObject(builder, isEmptyObject);
    increaseIndention();
    
    appendObjectMembers(builder, object);

    decreaseIndention();
    appendEndOfObject(builder, isEmptyObject);
    builder.append(STRING_OBJECT_END);

    return builder.toString();
  }

  private String toString(JSONArray array) {
    boolean isEmptyArray = (array.size() == 0);
    StringBuilder builder = new StringBuilder((array.size() << 1) + 1);

    builder.append(STRING_ARRAY_START);
    appendStartOfArray(builder, isEmptyArray);
    increaseIndention();

    appendArrayElements(builder, array);
    
    decreaseIndention();
    appendEndOfArray(builder, isEmptyArray);
    builder.append(STRING_ARRAY_END);

    return builder.toString();
  }

  private void increaseIndention() {
    currentIndention += settings.getIndentionString();
  }

  private void decreaseIndention() {
    String configuredIndention = settings.getIndentionString();
    currentIndention = currentIndention.substring(configuredIndention.length());
  }

  private void appendStartOfObject(StringBuilder builder, boolean isEmptyObject) {
    if (settings.isAddNewlineAfterObjectBegin()) {
      builder.append(settings.getNewlineString());
    } else if (settings.isAddSpaceAfterObjectBegin() && !(settings.isAddNewlineBeforeObjectEnd() && isEmptyObject)) {
      builder.append(STRING_SPACE);
    }
  }

  private void appendObjectMembers(StringBuilder builder, JSONObject object) {
    boolean isFirstMember = true;
    String indentionString = settings.getIndentionString();
    int indentionStringLength = indentionString.length();

    for (Entry<String, JSONValue> member : object.entrySet()) {
      if (!isFirstMember) {
        appendMembersSeparator(builder);
      }

      if ((indentionStringLength > 0) && isIndentionRequiredInObject(isFirstMember)) {
        builder.append(currentIndention);
      }

      appendMember(builder, member);

      isFirstMember = false;
    }
  }

  private void appendMember(StringBuilder builder, Entry<String, JSONValue> member) {
    String entryNameAsString = String.format("\"%s\"", member.getKey());
    builder.append(entryNameAsString);
    
    appendNameValueSeparator(builder);
    
    String entryValueAsString = toString(member.getValue());
    builder.append(entryValueAsString);
  }

  private void appendMembersSeparator(StringBuilder builder) {
    if (settings.isAddSpaceBeforeMemberSeparator()) {
      builder.append(STRING_SPACE);
    }

    builder.append(STRING_MEMBER_SEPARATOR);

    if (settings.isAddNewlineAfterMemberSeparator()) {
      builder.append(settings.getNewlineString());
    } else if (settings.isAddSpaceAfterMemberSeparator()) {
      builder.append(STRING_SPACE);
    }
  }

  private void appendNameValueSeparator(StringBuilder builder) {
    if (settings.isAddSpaceBeforeNameValueSeparator()) {
      builder.append(STRING_SPACE);
    }

    builder.append(STRING_NAME_VALUE_SEPARATOR);

    if (settings.isAddSpaceAfterNameValueSeparator()) {
      builder.append(STRING_SPACE);
    }
  }

  private boolean isIndentionRequiredInObject(boolean isFirstMember) {
    return ((isFirstMember && settings.isAddNewlineAfterObjectBegin()) || (!isFirstMember && settings.isAddNewlineAfterMemberSeparator()));
  }

  private void appendEndOfObject(StringBuilder builder, boolean isEmptyObject) {
    if (settings.isAddNewlineBeforeObjectEnd() && !(settings.isAddNewlineAfterObjectBegin() && isEmptyObject)) {
      builder.append(settings.getNewlineString());
      builder.append(currentIndention);
    } else if ((settings.isAddNewlineBeforeObjectEnd() || settings.isAddNewlineAfterObjectBegin()) && isEmptyObject) {
      builder.append(currentIndention);
    } else if (settings.isAddSpaceBeforeObjectEnd() && !((settings.isAddNewlineAfterObjectBegin() || settings.isAddSpaceAfterObjectBegin()) && isEmptyObject)) {
      builder.append(STRING_SPACE);
    }
  }

  private void appendStartOfArray(StringBuilder builder, boolean isEmptyArray) {
    if (settings.isAddNewlineAfterArrayBegin()) {
      builder.append(settings.getNewlineString());
    } else if (settings.isAddSpaceAfterArrayBegin() && !(settings.isAddNewlineBeforeArrayEnd() && isEmptyArray)) {
      builder.append(STRING_SPACE);
    }
  }

  private void appendArrayElements(StringBuilder builder, JSONArray array) {
    boolean isFirstElement = true;
    String indentionString = settings.getIndentionString();
    int indentionStringLength = indentionString.length();

    for (JSONValue element : array) {
      if (!isFirstElement) {
        appendElementsSeparator(builder);
      }

      if ((indentionStringLength > 0) && isIndentionRequiredInArray(isFirstElement)) {
        builder.append(currentIndention);
      }

      appendElement(builder, element);

      isFirstElement = false;
    }
  }

  private void appendElement(StringBuilder builder, JSONValue element) {
    String elementAsString = toString(element);
    builder.append(elementAsString);
  }

  private void appendElementsSeparator(StringBuilder builder) {
    if (settings.isAddSpaceBeforeValueSeparator()) {
      builder.append(STRING_SPACE);
    }

    builder.append(STRING_ELEMENT_SEPARATOR);

    if (settings.isAddNewlineAfterValueSeparator()) {
      builder.append(settings.getNewlineString());
    } else if (settings.isAddSpaceAfterValueSeparator()) {
      builder.append(STRING_SPACE);
    }
  }

  private boolean isIndentionRequiredInArray(boolean firstElement) {
    return (firstElement && settings.isAddNewlineAfterArrayBegin()) || (!firstElement && settings.isAddNewlineAfterValueSeparator());
  }

  private void appendEndOfArray(StringBuilder builder, boolean isEmptyArray) {
    if (settings.isAddNewlineBeforeArrayEnd() && !(settings.isAddNewlineAfterArrayBegin() && isEmptyArray)) {
      builder.append(settings.getNewlineString());
      builder.append(currentIndention);
    } else if ((settings.isAddNewlineBeforeArrayEnd() || settings.isAddNewlineAfterArrayBegin()) && isEmptyArray) {
      builder.append(currentIndention);
    } else if (settings.isAddSpaceBeforeArrayEnd() && !((settings.isAddNewlineAfterArrayBegin() || settings.isAddSpaceAfterArrayBegin()) && isEmptyArray)) {
      builder.append(STRING_SPACE);
    }
  }

  public JSONFormatterSettings getSettings() {
    return settings;
  }

  public void setSettings(JSONFormatterSettings value) {
    if (value == null) {
      throw new IllegalArgumentException();
    }

    settings = value;
  }
}
