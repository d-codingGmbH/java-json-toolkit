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
 * Java class representing a numerical JSON value
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class JSONNumber extends JSONPrimitiveValue<String> {
  private String stringValue;
  private Long longValue;
  private Double doubleValue;
  
  /**
   * Constructs a new instance with the specified string representation
   * of the associated number.
   * 
   * @param value The string representing the number
   * @throws IllegalArgumentException if the specified string is not an integer and
   *         not a floating point value
   */
  public JSONNumber(String value) {
    setValue(value);

    if (!isInteger() && !isFloatingPoint()) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns the string representing the associated number.
   * 
   * @return The string representing the number
   */
  @Override
  public String getValue() {
    return stringValue;
  }

  private void setValue(String value) {
    if (value == null) {
      throw new IllegalArgumentException();
    }

    this.stringValue = value;
    tryParseAsInteger(value);
    tryParseAsFloatingPoint(value);
  }

  private void tryParseAsInteger(String value) {
    try {
      longValue = Long.parseLong(value);
    } catch (NumberFormatException e) {
      longValue = null;
    }
  }

  private void tryParseAsFloatingPoint(String value) {
    if (!isInteger()) {
      try {
        doubleValue = Double.parseDouble(value);
      } catch (NumberFormatException e) {
        doubleValue = null;
      }
    } else {
      doubleValue = null;
    }
  }

  /**
   * Indicates if the associated number value is an integer.
   * 
   * @since 1.0.3
   * @return {@code true} if integer, other {@code false}
   */
  public boolean isInteger() {
    return (longValue != null);
  }

  /**
   * Returns the associated number as an {@link Long}, {@code null} if number
   * is floating point. 
   * 
   * @since 1.0.3
   * @return The integer value
   */
  public Long getIntegerValue() {
    return longValue;
  }

  /**
   * Indicates if the associated number value is a floating point.
   * 
   * @since 1.0.3
   * @return {@code true} if integer, other {@code false}
   */
  public boolean isFloatingPoint() {
    return (doubleValue != null);
  }

  /**
   * Returns the associated number as an {@link Double}, {@code null} if number
   * is integer. 
   * 
   * @since 1.0.3
   * @return The floating point value
   */
  public Double getFloatingPointValue() {
    return doubleValue;
  }
}
