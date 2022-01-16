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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Java class representing an array of JSON values
 * 
 * @author David Ullrich <david.ullrich@d-coding.de>
 * @since  1.0
 */
public class JSONArray extends JSONValue implements List<JSONValue> {
  private List<JSONValue> values;
  
  public JSONArray() {
    values = new ArrayList<JSONValue>();
  }
  
  public JSONArray(Collection<? extends JSONValue> values) {
    this();
    addAll(values);
  }

  @Override
  public void add(int index, JSONValue element) {
    values.add(index, element);
  }

  @Override
  public boolean add(JSONValue e) {
    return values.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends JSONValue> c) {
    return values.addAll(c);
  }

  @Override
  public boolean addAll(int index, Collection<? extends JSONValue> c) {
    return values.addAll(index, c);
  }

  @Override
  public void clear() {
    values.clear();
  }

  @Override
  public boolean contains(Object o) {
    return values.contains(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return values.containsAll(c);
  }

  @Override
  public JSONValue get(int index) {
    return values.get(index);
  }
    
  @SuppressWarnings("unchecked")
  public <T extends JSONValue> T getAs(int index) {
    return (T) values.get(index);
  }

  @Override
  public int indexOf(Object o) {
    return values.indexOf(o);
  }

  @Override
  public boolean isEmpty() {
    return values.isEmpty();
  }

  @Override
  public Iterator<JSONValue> iterator() {
    return values.iterator();
  }

  @Override
  public int lastIndexOf(Object o) {
    return values.lastIndexOf(o);
  }

  @Override
  public ListIterator<JSONValue> listIterator() {
    return values.listIterator();
  }

  @Override
  public ListIterator<JSONValue> listIterator(int index) {
    return values.listIterator(index);
  }

  @Override
  public JSONValue remove(int index) {
    return values.remove(index);
  }

  @Override
  public boolean remove(Object o) {
    return values.remove(o);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return values.removeAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return values.retainAll(c);
  }

  @Override
  public JSONValue set(int index, JSONValue element) {
    return values.set(index, element);
  }

  @Override
  public int size() {
    return values.size();
  }

  @Override
  public List<JSONValue> subList(int fromIndex, int toIndex) {
    return values.subList(fromIndex, toIndex);
  }

  @Override
  public Object[] toArray() {
    return values.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return values.toArray(a);
  }
}
