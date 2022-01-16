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
  
  public JSONObject() {
    members = new LinkedHashMap<String, JSONValue>();
  }

  @Override
  public int size() {
    return members.size();
  }

  @Override
  public boolean isEmpty() {
    return members.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return members.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return members.containsValue(value);
  }

  @Override
  public JSONValue get(Object key) {
    return members.get(key);
  }

  @SuppressWarnings("unchecked")
  public <T extends JSONValue> T getAs(Object key) {
    return (T) members.get(key);
  }

  @Override
  public JSONValue put(String key, JSONValue value) {
    return members.put(key, value);
  }

  @Override
  public JSONValue remove(Object key) {
    return members.remove(key);
  }

  @Override
  public void putAll(Map<? extends String, ? extends JSONValue> m) {
    members.putAll(m);
  }

  @Override
  public void clear() {
    members.clear();
  }

  @Override
  public Set<String> keySet() {
    return members.keySet();
  }

  @Override
  public Collection<JSONValue> values() {
    return members.values();
  }

  @Override
  public Set<java.util.Map.Entry<String, JSONValue>> entrySet() {
    return members.entrySet();
  }
}
