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
 * Java class representing a textual JSON value
 * 
 * @since  1.0
 */
public class JSONString extends JSONPrimitiveValue<String> {
  private String value;
  
  /**
   * Constructs a new instance with the specified concrete string value.
   * 
   * @param value The string value
   */
  public JSONString(String value) {
    setValue(value);
  }
  
  /**
   * Returns the string value.
   * 
   * @return The string value
   */
  @Override
  public String getValue() {
    return value;
  }
  
  private void setValue(String value) {
    this.value = value;
  }

  /**
   * Indicates whether the specified object is equal to this instance.
   * Two {@link JSONString} instances are equal if their string values are
   * equal. Otherwise they are not equal.
   * 
   * @param obj The object to be compared to
   * @return Indication if the specified object is considered to be equal
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof JSONString) {
      JSONString castedObj = (JSONString)obj;

      if ((value != null) && (castedObj.value != null)) {
        return value.equals(castedObj.value);
      } else if ((value != null) || (castedObj.value != null)) {
        return false;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  /**
   * Converts the string value into a JSON conformant textual representation.
   * Special characters are automatically escaped.
   * 
   * @return The string representation
   */
  @Override
  public String toString() {
    char[] preEscapingCharacters = getValue().toCharArray();
    StringBuilder builder = new StringBuilder(preEscapingCharacters.length);
    
    builder.append("\"");

    for (int i = 0, j = preEscapingCharacters.length; i < j; i++) {
      int preEscapingCodePoint = Character.codePointAt(preEscapingCharacters, i);
      switch (preEscapingCodePoint) {
        case 0x22:
          builder.append("\\\"");
          break;
        case 0x5C:
          builder.append("\\\\");
          break;
        case 0x08:
          builder.append("\\b");
          break;
        case 0x0C:
          builder.append("\\f");
          break;
        case 0x0A:
          builder.append("\\n");
          break;
        case 0x0D:
          builder.append("\\r");
          break;
        case 0x09:
          builder.append("\\t");
          break;
        default:
          if (preEscapingCodePoint < 0x20) {
            builder.append(String.format("\\u%4X", preEscapingCodePoint));
          } else {
            builder.append(preEscapingCharacters[i]);
          }
      }
    }

    builder.append("\"");
    
    return builder.toString();
  }
}
