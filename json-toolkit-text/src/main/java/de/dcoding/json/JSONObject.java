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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Java class representing a JSON object
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class JSONObject extends JSONValue implements Map<String, JSONValue> {
  private Map<String, JSONValue> members;
  
  /**
   * Constructs a new instance.
   */
  public JSONObject() {
    members = new LinkedHashMap<String, JSONValue>();
  }

  /**
   * Retrieves the number of members.
   * 
   * @return The number of members
   */
  @Override
  public int size() {
    return members.size();
  }

  /**
   * Indicates if it is an empty object.
   * 
   * @return Indication if object is empty
   */
  @Override
  public boolean isEmpty() {
    return members.isEmpty();
  }

  /**
   * Indicates if the specified name is defined in the object as a member.
   * 
   * @return Indication if the name is known
   */
  @Override
  public boolean containsKey(Object key) {
    return members.containsKey(key);
  }

  /**
   * Indicates if the specified value is a member of the object.
   * 
   * @return Indication if the value is a member
   */
  @Override
  public boolean containsValue(Object value) {
    return members.containsValue(value);
  }

  /**
   * Returns the value that is known by the specified name.
   * 
   * @param key The name of the member
   * @return The value
   */
  @Override
  public JSONValue get(Object key) {
    return members.get(key);
  }

  /**
   * Returns the value that is known by the specified name as an instance
   * of the specified type parameter.
   * 
   * @param <T> The type of the member value
   * @param key The name of the member
   * @return The typed value
   */
  @SuppressWarnings("unchecked")
  public <T extends JSONValue> T getAs(Object key) {
    return (T) members.get(key);
  }

  /**
   * Sets the specified value as a member of the object with the specified name.
   * 
   * @param key The name of the member
   * @param value The value of the member
   * @return The value associated with the name
   */
  @Override
  public JSONValue put(String key, JSONValue value) {
    return members.put(key, value);
  }

  /**
   * Removes the member with the specified name from the object.
   * Unknown member names are permitted and will return a {@code null}.
   * 
   * @param key The name of the member
   * @return The value assiocated with the name
   */
  @Override
  public JSONValue remove(Object key) {
    return members.remove(key);
  }

  /**
   * Adds all name value pairs in the specified map as members of the object.
   * 
   * @param m Name value mappings to be set
   */
  @Override
  public void putAll(Map<? extends String, ? extends JSONValue> m) {
    members.putAll(m);
  }

  /**
   * Removes all members from the object.
   */
  @Override
  public void clear() {
    members.clear();
  }

  /**
   * Returns a set of all defined member names.
   * 
   * @return The set of member names
   */
  @Override
  public Set<String> keySet() {
    return members.keySet();
  }

  /**
   * Returns a collection of all known member values.
   * 
   * @return The collection of member values
   */
  @Override
  public Collection<JSONValue> values() {
    return members.values();
  }

  /**
   * Returns a set of name value mappings of all members in the object.
   * 
   * @return The set of name value mappings
   */
  @Override
  public Set<java.util.Map.Entry<String, JSONValue>> entrySet() {
    return members.entrySet();
  }
}
