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
  private static final boolean DEFAULT_ADD_NEWLINE_AFTER_OBJECT_BEGIN = false;
  private static final boolean DEFAULT_ADD_SPACE_AFTER_OBJECT_BEGIN = false;
  private static final boolean DEFAULT_ADD_NEWLINE_BEFORE_OBJECT_END = false;
  private static final boolean DEFAULT_ADD_SPACE_BEFORE_OBJECT_END = false;
  private static final boolean DEFAULT_ADD_SPACE_BEFORE_NAME_VALUE_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_SPACE_AFTER_NAME_VALUE_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_SPACE_BEFORE_MEMBER_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_NEWLINE_AFTER_MEMBER_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_SPACE_AFTER_MEMBER_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_NEWLINE_AFTER_ARRAY_BEGIN = false;
  private static final boolean DEFAULT_ADD_SPACE_AFTER_ARRAY_BEGIN = false;
  private static final boolean DEFAULT_ADD_NEWLINE_BEFORE_ARRAY_END = false;
  private static final boolean DEFAULT_ADD_SPACE_BEFORE_ARRAY_END = false;
  private static final boolean DEFAULT_ADD_NEWLINE_AFTER_VALUE_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_SPACE_BEFORE_VALUE_SEPARATOR = false;
  private static final boolean DEFAULT_ADD_SPACE_AFTER_VALUE_SEPARATOR = false;
  private static final String DEFAULT_NEWLINE_STRING = "\n";
  private static final String DEFAULT_INDENTION_STRING = "  ";
  
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
  private String indentionString;
  
  /**
   * Constructs a new instance with the default settings applied.
   */
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

  /**
   * Indicates if a new line inserted after the beginning of an object.
   * 
   * @return {@code true} if new lines are to be added, {@code false} otherwise
   */
  public boolean isAddNewlineAfterObjectBegin() {
    return addNewlineAfterObjectBegin;
  }

  /**
   * Configures if a new line inserted after the beginning of an object.
   * 
   * @param value {@code true} if new lines are to be added, {@code false} otherwise
   */
  public void setAddNewlineAfterObjectBegin(boolean value) {
    addNewlineAfterObjectBegin = value;
  }
  
  /**
   * Indicates if a space is to be added after the beginning of an object.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceAfterObjectBegin() {
    return addSpaceAfterObjectBegin;
  }

  /**
   * Configures if a space is to be added after the beginning of an object.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceAfterObjectBegin(boolean value) {
    addSpaceAfterObjectBegin = value;
  }

  /**
   * Indicates if a new line is to be added before the end of an object.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddNewlineBeforeObjectEnd() {
    return addNewlineBeforeObjectEnd;
  }
  
  /**
   * Configures if a new line is to be added before the end of an object.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddNewlineBeforeObjectEnd(boolean value) {
    addNewlineBeforeObjectEnd = value;
  }

  /**
   * Indicates if a space is to be added before the end of an object.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceBeforeObjectEnd() {
    return addSpaceBeforeObjectEnd;
  }
  
  /**
   * Configures if a space is to be added before the end of an object.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceBeforeObjectEnd(boolean value) {
    addSpaceBeforeObjectEnd = value;
  }

  /**
   * Indicates if a space is to be added before a name value separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceBeforeNameValueSeparator() {
    return addSpaceBeforeNameValueSeparator;
  }
  
  /**
   * Configures if a space is to be added before a name value separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceBeforeNameValueSeparator(boolean value) {
    addSpaceBeforeNameValueSeparator = value;
  }

  /**
   * Indicates if a space is to be added after a name value separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceAfterNameValueSeparator() {
    return addSpaceAfterNameValueSeparator;
  }
  
  /**
   * Configures if a space is to be added after a name value separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceAfterNameValueSeparator(boolean value) {
    addSpaceAfterNameValueSeparator = value;
  }

  /**
   * Indicates if a space is to be added before a member separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceBeforeMemberSeparator() {
    return addSpaceBeforeMemberSeparator;
  }
  
  /**
   * Configures if a space is to be added before a member separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceBeforeMemberSeparator(boolean value) {
    addSpaceBeforeMemberSeparator = value;
  }
  
  /**
   * Indicates if a new line is to be added after a member separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddNewlineAfterMemberSeparator() {
    return addNewlineAfterMemberSeparator;
  }
  
  /**
   * Configures if a new line is to be added after a member separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddNewlineAfterMemberSeparator(boolean value) {
    addNewlineAfterMemberSeparator = value;
  }

  /**
   * Indicates if a space is to be added after a member separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceAfterMemberSeparator() {
    return addSpaceAfterMemberSeparator;
  }
  
  /**
   * Configures if a space is to be added after a member separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceAfterMemberSeparator(boolean value) {
    addSpaceAfterMemberSeparator = value;
  }
  
  /**
   * Indicates if a new line is to be added after the beginning of an array.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddNewlineAfterArrayBegin() {
    return addNewlineAfterArrayBegin;
  }
  
  /**
   * Configures if a new line is to be added after the beginning of an array.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddNewlineAfterArrayBegin(boolean value) {
    addNewlineAfterArrayBegin = value;
  }
 
  /**
   * Indicates if a space is to be added after the beginning of an array.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceAfterArrayBegin() {
    return addSpaceAfterArrayBegin;
  }
  
  /**
   * Configures if a space is to be added after the beginning of an array.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceAfterArrayBegin(boolean value) {
    addSpaceAfterArrayBegin = value;
  }
  
  /**
   * Indicates if a new line is to be added before the end of an array.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddNewlineBeforeArrayEnd() {
    return addNewlineBeforeArrayEnd;
  }
  
  /**
   * Configures if a new line is to be added before the end of an array.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddNewlineBeforeArrayEnd(boolean value) {
    addNewlineBeforeArrayEnd = value;
  }
  
  /**
   * Indicates if a space is to be added before the end of an array.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceBeforeArrayEnd() {
    return addSpaceBeforeArrayEnd;
  }
  
  /**
   * Configures if a space is to be added before the end of an array.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceBeforeArrayEnd(boolean value) {
    addSpaceBeforeArrayEnd = value;
  }
  
  /**
   * Indicates if a space is to be added before a value separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceBeforeValueSeparator() {
    return addSpaceBeforeValueSeparator;
  }
  
  /**
   * Configures if a space is to be added before a value separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceBeforeValueSeparator(boolean value) {
    addSpaceBeforeValueSeparator = value;
  }
  
  /**
   * Indicates if a new line is to be added after a value separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddNewlineAfterValueSeparator() {
    return addNewlineAfterValueSeparator;
  }
  
  /**
   * Configures if a new line is to be added after a value separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddNewlineAfterValueSeparator(boolean value) {
    addNewlineAfterValueSeparator = value;
  }
  
  /**
   * Indicates if a space is to be added after a value separator.
   * 
   * @return {@code true} if it is to be added, otherwise {@code false}
   */
  public boolean isAddSpaceAfterValueSeparator() {
    return addSpaceAfterValueSeparator;
  }
  
  /**
   * Configures if a space is to be added after a value separator.
   * 
   * @param value {@code true} if it is to be added, otherwise {@code false}
   */
  public void setAddSpaceAfterValueSeparator(boolean value) {
    addSpaceAfterValueSeparator = value;
  }
  
  /**
   * Returns the configured new line string.
   * 
   * @return The new line string
   */
  public String getNewlineString() {
    return newlineString;
  }
  
  /**
   * Configures the new line string. Permitted are "\\r\\n" or "\\n".
   * 
   * @param value The new line string
   */
  public void setNewlineString(String value) {
    if (value != null) {
      if (value.matches("^\\r?\\n$")) {
        newlineString = value;
      }
    }
  }
  
  /**
   * Returns the configured indention string.
   * 
   * @return The indention string
   */
  public String getIndentionString() {
    return indentionString;
  }

  /**
   * Configures the indention string. Multiple spaces or multiple tab characters are allowed.
   * 
   * @param value The indention string
   */
  public void setIndentionString(String value) {
    if (value != null) {
      if (value.matches("^([ ]*|\\t*)$")) {
        indentionString = value;
      }
    }
  }
}
