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
 * Parser exception for unexpected parser states
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class ParserException extends Exception {
  private static final long serialVersionUID = 3114350180910900145L;

  /**
   * Constructs a new exception with {@code null} as its message. The cause is not initialized, 
   * and may subsequently be initialized by a call to {@link #initCause}.
   */
  public ParserException() {
    super();
  }
  
  /**
   * Constructs a new exception with the specified message. The cause is not initialized, 
   * and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param message The message. It retrievable by the {@link #getMessage()} method.
   */
  public ParserException(String message) {
    super(message);
  }

  /**
   * Constructs a new exception with the specified cause and a message of
   * <tt>(cause==null ? null : cause.toString())</tt>.
   * 
   * @param cause The cause of the exception (which is retrievable by the {@link #getCause()} method).
   */
  public ParserException(Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a new exception with the specified message and cause.
   * 
   * @param message The message. It retrievable by the {@link #getMessage()}
   *                method.
   * @param cause The cause of the exception (which is retrievable by the {@link #getCause()} method).
   */
  public ParserException(String message, Throwable cause) {
    super(message, cause);
  }
  
  /**
   * Constructs a new exception with the specified detail message, cause, suppression enabled or disabled, 
   * and writable stack trace enabled or disabled.
   *
   * @param message The message. It retrievable by the {@link #getMessage()} method.
   * @param cause The cause of the exception (which is retrievable by the {@link #getCause()} method).
   * @param enableSuppression Whether or not suppression is enabled or disabled
   * @param writableStackTrace Whether or not the stack trace should be writable
   */
  public ParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
