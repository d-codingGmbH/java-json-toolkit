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

/**
 * Data class bundling all formatter settings
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class JSONFormatterSettings {
  public static final boolean DEFAULT_ADD_NEWLINE_AFTER_OBJECT_BEGIN = false;
  public static final boolean DEFAULT_ADD_SPACE_AFTER_OBJECT_BEGIN = false;
  public static final boolean DEFAULT_ADD_NEWLINE_BEFORE_OBJECT_END = false;
  public static final boolean DEFAULT_ADD_SPACE_BEFORE_OBJECT_END = false;
  public static final boolean DEFAULT_ADD_SPACE_BEFORE_NAME_VALUE_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_SPACE_AFTER_NAME_VALUE_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_SPACE_BEFORE_MEMBER_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_NEWLINE_AFTER_MEMBER_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_SPACE_AFTER_MEMBER_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_NEWLINE_AFTER_ARRAY_BEGIN = false;
  public static final boolean DEFAULT_ADD_SPACE_AFTER_ARRAY_BEGIN = false;
  public static final boolean DEFAULT_ADD_NEWLINE_BEFORE_ARRAY_END = false;
  public static final boolean DEFAULT_ADD_SPACE_BEFORE_ARRAY_END = false;
  public static final boolean DEFAULT_ADD_NEWLINE_AFTER_VALUE_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_SPACE_BEFORE_VALUE_SEPARATOR = false;
  public static final boolean DEFAULT_ADD_SPACE_AFTER_VALUE_SEPARATOR = false;
  public static final String DEFAULT_NEWLINE_STRING = "\n";
  public static final String DEFAULT_INDENTION_STRING = "  ";
  
  private boolean addNewlineAfterObjectBegin;
  private boolean addSpaceAfterObjectBegin;
  private boolean addNewlineBeforeObjectEnd;
  private boolean addSpaceBeforeObjectEnd;
  private boolean addSpaceBeforeNameValueSeparator;
  private boolean addSpaceAfterNameValueSeparator;
  private boolean addSpaceBeforeMemberSeparator;
  private boolean addNewlineAfterMemberSeparator;
  private boolean addSpaceAfterMemberSeparator;
  private boolean addNewlineAfterArrayBegin;
  private boolean addSpaceAfterArrayBegin;
  private boolean addNewlineBeforeArrayEnd;
  private boolean addSpaceBeforeArrayEnd;
  private boolean addSpaceBeforeValueSeparator;
  private boolean addNewlineAfterValueSeparator;
  private boolean addSpaceAfterValueSeparator;
  private String newlineString;
  private String indentationString;
  
  public JSONFormatterSettings() {
    setAddNewlineAfterObjectBegin(DEFAULT_ADD_NEWLINE_AFTER_OBJECT_BEGIN);
    setAddSpaceAfterObjectBegin(DEFAULT_ADD_SPACE_AFTER_OBJECT_BEGIN);
    setAddNewlineBeforeObjectEnd(DEFAULT_ADD_NEWLINE_BEFORE_OBJECT_END);
    setAddSpaceBeforeObjectEnd(DEFAULT_ADD_SPACE_BEFORE_OBJECT_END);
    setAddSpaceBeforeNameValueSeparator(DEFAULT_ADD_SPACE_BEFORE_NAME_VALUE_SEPARATOR);
    setAddSpaceAfterNameValueSeparator(DEFAULT_ADD_SPACE_AFTER_NAME_VALUE_SEPARATOR);
    setAddSpaceBeforeMemberSeparator(DEFAULT_ADD_SPACE_BEFORE_MEMBER_SEPARATOR);
    setAddNewlineAfterMemberSeparator(DEFAULT_ADD_NEWLINE_AFTER_MEMBER_SEPARATOR);
    setAddSpaceAfterMemberSeparator(DEFAULT_ADD_SPACE_AFTER_MEMBER_SEPARATOR);
    setAddNewlineAfterArrayBegin(DEFAULT_ADD_NEWLINE_AFTER_ARRAY_BEGIN);
    setAddSpaceAfterArrayBegin(DEFAULT_ADD_SPACE_AFTER_ARRAY_BEGIN);
    setAddNewlineBeforeArrayEnd(DEFAULT_ADD_NEWLINE_BEFORE_ARRAY_END);
    setAddSpaceBeforeArrayEnd(DEFAULT_ADD_SPACE_BEFORE_ARRAY_END);
    setAddSpaceBeforeValueSeparator(DEFAULT_ADD_SPACE_BEFORE_VALUE_SEPARATOR);
    setAddNewlineAfterValueSeparator(DEFAULT_ADD_NEWLINE_AFTER_VALUE_SEPARATOR);
    setAddSpaceAfterValueSeparator(DEFAULT_ADD_SPACE_AFTER_VALUE_SEPARATOR);
    setNewlineString(DEFAULT_NEWLINE_STRING);
    setIndentionString(DEFAULT_INDENTION_STRING);
  }

  public boolean isAddNewlineAfterObjectBegin() {
    return addNewlineAfterObjectBegin;
  }

  public void setAddNewlineAfterObjectBegin(boolean value) {
    addNewlineAfterObjectBegin = value;
  }
  
  public boolean isAddSpaceAfterObjectBegin() {
    return addSpaceAfterObjectBegin;
  }

  public void setAddSpaceAfterObjectBegin(boolean value) {
    addSpaceAfterObjectBegin = value;
  }

  public boolean isAddNewlineBeforeObjectEnd() {
    return addNewlineBeforeObjectEnd;
  }
  
  public void setAddNewlineBeforeObjectEnd(boolean value) {
    addNewlineBeforeObjectEnd = value;
  }

  public boolean isAddSpaceBeforeObjectEnd() {
    return addSpaceBeforeObjectEnd;
  }
  
  public void setAddSpaceBeforeObjectEnd(boolean value) {
    addSpaceBeforeObjectEnd = value;
  }

  public boolean isAddSpaceBeforeNameValueSeparator() {
    return addSpaceBeforeNameValueSeparator;
  }
  
  public void setAddSpaceBeforeNameValueSeparator(boolean value) {
    addSpaceBeforeNameValueSeparator = value;
  }

  public boolean isAddSpaceAfterNameValueSeparator() {
    return addSpaceAfterNameValueSeparator;
  }
  
  public void setAddSpaceAfterNameValueSeparator(boolean value) {
    addSpaceAfterNameValueSeparator = value;
  }

  public boolean isAddSpaceBeforeMemberSeparator() {
    return addSpaceBeforeMemberSeparator;
  }
  
  public void setAddSpaceBeforeMemberSeparator(boolean value) {
    addSpaceBeforeMemberSeparator = value;
  }
  
  public boolean isAddNewlineAfterMemberSeparator() {
    return addNewlineAfterMemberSeparator;
  }
  
  public void setAddNewlineAfterMemberSeparator(boolean value) {
    addNewlineAfterMemberSeparator = value;
  }

  public boolean isAddSpaceAfterMemberSeparator() {
    return addSpaceAfterMemberSeparator;
  }
  
  public void setAddSpaceAfterMemberSeparator(boolean value) {
    addSpaceAfterMemberSeparator = value;
  }
  
  public boolean isAddNewlineAfterArrayBegin() {
    return addNewlineAfterArrayBegin;
  }
  
  public void setAddNewlineAfterArrayBegin(boolean value) {
    addNewlineAfterArrayBegin = value;
  }
 
  public boolean isAddSpaceAfterArrayBegin() {
    return addSpaceAfterArrayBegin;
  }
  
  public void setAddSpaceAfterArrayBegin(boolean value) {
    addSpaceAfterArrayBegin = value;
  }
  
  public boolean isAddNewlineBeforeArrayEnd() {
    return addNewlineBeforeArrayEnd;
  }
  
  public void setAddNewlineBeforeArrayEnd(boolean value) {
    addNewlineBeforeArrayEnd = value;
  }
  
  public boolean isAddSpaceBeforeArrayEnd() {
    return addSpaceBeforeArrayEnd;
  }
  
  public void setAddSpaceBeforeArrayEnd(boolean value) {
    addSpaceBeforeArrayEnd = value;
  }
  
  public boolean isAddSpaceBeforeValueSeparator() {
    return addSpaceBeforeValueSeparator;
  }
  
  public void setAddSpaceBeforeValueSeparator(boolean value) {
    addSpaceBeforeValueSeparator = value;
  }
  
  public boolean isAddNewlineAfterValueSeparator() {
    return addNewlineAfterValueSeparator;
  }
  
  public void setAddNewlineAfterValueSeparator(boolean value) {
    addNewlineAfterValueSeparator = value;
  }
  
  public boolean isAddSpaceAfterValueSeparator() {
    return addSpaceAfterValueSeparator;
  }
  
  public void setAddSpaceAfterValueSeparator(boolean value) {
    addSpaceAfterValueSeparator = value;
  }
  
  public String getNewlineString() {
    return newlineString;
  }
  
  public void setNewlineString(String value) {
    if (value != null) {
      if (value.matches("^\\r?\\n$")) {
        newlineString = value;
      }
    }
  }
  
  public String getIndentionString() {
    return indentationString;
  }

  public void setIndentionString(String value) {
    if (value != null) {
      if (value.matches("^([ ]*|\\t*)$")) {
        indentationString = value;
      }
    }
  }
}
