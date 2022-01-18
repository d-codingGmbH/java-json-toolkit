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
 * Abstract java base class for primitive JSON values
 * 
 * @since  1.0
 */
public abstract class JSONPrimitiveValue<T> extends JSONValue {
  /**
   * Returns the concrete value.
   * 
   * @return The value
   */
  public abstract T getValue();
  
  /**
   * Returns the string representation of the concrete value.
   * 
   * @return The string representation of the value
   */
  @Override
  public String toString() {
    return getValue().toString();
  }
}
