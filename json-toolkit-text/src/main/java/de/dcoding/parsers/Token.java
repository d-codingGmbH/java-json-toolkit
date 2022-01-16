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

package de.dcoding.parsers;

/**
 * Abstract base class for tokens
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public abstract class Token extends Symbol {
  private int position;
  
  /**
   * Constructs a new token and sets the start position.
   * 
   * @param position The start position of the token in the input data
   */
  protected Token(int position) {
    setPosition(position);
  }
  
  /**
   * A more natural alternative to {@link #getPosition()}.
   * 
   * @return The start position of the token in the input data
   */
  public int at() {
    return position;
  }
  
  /**
   * Getter for the start position of the token in the input data
   * 
   * @return The start position of the token in the input data
   */
  public int getPosition() {
    return position;
  }
  
  private void setPosition(int position) {
    if (position < 0) {
      throw new IllegalArgumentException();
    }
    
    this.position = position;
  }
}
