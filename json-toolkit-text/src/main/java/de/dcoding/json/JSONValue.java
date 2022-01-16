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
 * Abstract base class for JSON values
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public abstract class JSONValue {
  /**
   * Converts a JSON value into its textual representation by using a default
   * {@link JSONFormatter}.
   * 
   * @return The string representation
   */
  @Override
  public String toString() {
    JSONFormatter formatter = new JSONFormatter();
    
    return toString(formatter);
  }

  /**
   * Converts a JSON value into its textual representation by using the specified
   * {@link JSONFormatter} instance
   * 
   * @param formatter The formatter
   * @return The string representation
   */
  public String toString(JSONFormatter formatter) {
    if (formatter == null) {
      throw new IllegalArgumentException();
    }

    return formatter.toString(this);
  }
}
