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

package de.dcoding.json.tokens;

import de.dcoding.parsers.ValuedToken;

/**
 * Abstract base class of a token containing a value
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public abstract class ValuedJSONToken<T> extends JSONToken implements ValuedToken<T> {
  private T value;
  
  /**
   * Constructs a new instance of the token with the specified start position and value.
   * The value is retrievable with {@link #getValue()}
   * 
   * @param position The start position of the token in the input data
   * @param value The value associated with the token
   */
  protected ValuedJSONToken(int position, T value) {
    super(position);
    setValue(value);
  }
  
  /**
   * Returns the value that is associated with this token.
   * 
   * @return The value associated to this token instance
   */
  @Override
  public T getValue() {
    return value;
  }
  
  private void setValue(T value) {
    this.value = value;
  }
}
