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
 * @since  1.0
 */
public class JSONArray extends JSONValue implements List<JSONValue> {
  private List<JSONValue> values;
  
  /**
   * Constructs a new instance of an array of JSON values
   */
  public JSONArray() {
    values = new ArrayList<JSONValue>();
  }
  
  /**
   * Constructs a new instance of an array of JSON values.
   * The specified collection of values are added.
   * 
   * @param values The collection of values
   */
  public JSONArray(Collection<? extends JSONValue> values) {
    this();
    addAll(values);
  }

  /**
   * Inserts the specified element at the specified position.
   * 
   * @param index Position at which the element is to be inserted
   * @param element The element to insert
   */
  @Override
  public void add(int index, JSONValue element) {
    values.add(index, element);
  }

  /**
   * Appends the specified {@link JSONValue} as an element at the end of the array.
   * 
   * @param e The element to append
   */
  @Override
  public boolean add(JSONValue e) {
    return values.add(e);
  }

  /**
   * Appends a collection of {@link JSONValue} as elements to the end of the array.
   * 
   * @param c The collection of elements
   * @return {@code true} if the array is changed, otherwise {@code false}
   */
  @Override
  public boolean addAll(Collection<? extends JSONValue> c) {
    return values.addAll(c);
  }

  /**
   * Inserts a collection of {@link JSONValue} as elements at the specified position.
   * 
   * @param index Position at which the elements are to be inserted
   * @param c The collection of elements
   * @return {@code true} if the array is changed, otherwise {@code false}
   */
  @Override
  public boolean addAll(int index, Collection<? extends JSONValue> c) {
    return values.addAll(index, c);
  }

  /**
   * Removes all elements from the array.
   */
  @Override
  public void clear() {
    values.clear();
  }

  /**
   * Indicates if the specified value is already an element of the array.
   * 
   * @param o The value to lookup
   */
  @Override
  public boolean contains(Object o) {
    return values.contains(o);
  }

  /**
   * Indicates if all values in the specified collection are elements of the array.
   * 
   * @param c The values to lookup
   * @return {@code true} if all values are elements, otherwise {@code false}
   */
  @Override
  public boolean containsAll(Collection<?> c) {
    return values.containsAll(c);
  }

  /**
   * Returns the element at the specified position.
   * 
   * @param index The position of the element to retrieve
   * @return The value at the position
   * @throws IndexOutOfBoundsException If the index is out of range (index &lt; 0 || index &gt; size())
   */
  @Override
  public JSONValue get(int index) {
    return values.get(index);
  }
  
  /**
   * Returns the element at the specified position as an instance
   * of the specified type parameter.
   * 
   * @param <T> The type of the element
   * @param index The position of the element to retrieve
   * @return The typed value
   * @throws IndexOutOfBoundsException If the index is out of range (index &lt; 0 || index &gt; size())
   */
  @SuppressWarnings("unchecked")
  public <T extends JSONValue> T getAs(int index) {
    return (T) values.get(index);
  }

  /**
   * Retrieves the position of the first occurrence of the specified value in this array,
   * or -1 if the value is not an element.
   * 
   * @param o The value to lookup
   * @return The position of the first occurrence or -1
   * @throws ClassCastException If the specified value is not a {@link JSONValue} instance
   */
  @Override
  public int indexOf(Object o) {
    return values.indexOf(o);
  }

  /**
   * Indicates if the array is empty.
   * 
   * @return {@code true} if the array contains no elements, otherwise {@code false}
   */
  @Override
  public boolean isEmpty() {
    return values.isEmpty();
  }

  /**
   * Returns an iterator over the elements of the array in proper ordering.
   * 
   * @return An iterator over the elements of the array.
   */
  @Override
  public Iterator<JSONValue> iterator() {
    return values.iterator();
  }

  /**
   * Retrieves the position of the last occurrence of the specified value in this array,
   * or -1 if the value is not an element.
   * 
   * @param o The value to lookup
   * @return The position of the last occurrence or -1
   * @throws ClassCastException If the specified value is not a {@link JSONValue} instance
   */
  @Override
  public int lastIndexOf(Object o) {
    return values.lastIndexOf(o);
  }

  /**
   * Returns a {@link ListIterator} over the elements of the array in proper ordering.
   * 
   * @return A list iterator over the elements of the array.
   */
  @Override
  public ListIterator<JSONValue> listIterator() {
    return values.listIterator();
  }

  /**
   * Returns a {@link ListIterator} over the elements of the array in proper ordering
   * starting at the specified position.
   * 
   * @param index The starting position
   * @return A list iterator over the elements of the array.
   * @throws IndexOutOfBoundsException If the index is out of range (index &lt; 0 || index &gt; size())
   */
  @Override
  public ListIterator<JSONValue> listIterator(int index) {
    return values.listIterator(index);
  }

  /**
   * Removes the element at the specified position from the array.
   * 
   * @param index The position of the element to be removed
   * @return The removed element
   * @throws IndexOutOfBoundsException If the index is out of range (index &lt; 0 || index &gt; size())
   */
  @Override
  public JSONValue remove(int index) {
    return values.remove(index);
  }

  /**
   * Removes the first occurrence of the specified value from this array.
   * If the value is not an element, the array is unchanged.
   * 
   * @param o The value to remove
   * @return {@code true} if the array has changed, otherwise {@code false}
   * @throws ClassCastException If the specified value is not a {@link JSONValue} instance
   */
  @Override
  public boolean remove(Object o) {
    return values.remove(o);
  }

  /**
   * Removes all the values in the specified collection from the array.
   * If none of the values are elements, the array is unchanged.
   * 
   * @param c The collection of values to remove
   * @return {@code true} if the array has changed, otherwise {@code false}
   * @throws ClassCastException If the specified value is not a {@link JSONValue} instance
   */
  @Override
  public boolean removeAll(Collection<?> c) {
    return values.removeAll(c);
  }

  /**
   * Removes all elements of the array that are not in the specified collection.
   * If none of the values are elements, the array is unchanged.
   * 
   * @param c The collection of values to retain
   * @return {@code true} if the array has changed, otherwise {@code false}
   * @throws ClassCastException If the specified value is not a {@link JSONValue} instance
   */
  @Override
  public boolean retainAll(Collection<?> c) {
    return values.retainAll(c);
  }

  /**
   * Stores the specified {@link JSONValue} as an element in the array at the specified position.
   * 
   * @param index The position of the element to be set
   * @param element The element to be set
   * @throws IndexOutOfBoundsException If the index is out of range (index &lt; 0 || index &gt; size())
   */
  @Override
  public JSONValue set(int index, JSONValue element) {
    return values.set(index, element);
  }

  /**
   * Returns the number of array elements.
   * 
   * @return The number of elements
   */
  @Override
  public int size() {
    return values.size();
  }

  /**
   * Creates a sublist from the specified start position (inclusive) to the specified
   * end position (exclusive).
   * 
   * @param fromIndex Inclusive start position
   * @param toIndex Exclusive end position
   * @return The created list of elements
   * @throws IndexOutOfBoundsException If the fromIndex or toIndex is out of range
   *         (fromIndex &lt; 0 || fromIndex &gt; toIndex || toIndex &gt; size())
   */
  @Override
  public List<JSONValue> subList(int fromIndex, int toIndex) {
    return values.subList(fromIndex, toIndex);
  }

  /**
   * Returns an array containing all of the elements in this list in proper
   * ordering. This class contains no reference to the returned array.
   *
   * @return An array containing all of the elements in proper ordering
   */
  @Override
  public Object[] toArray() {
    return values.toArray();
  }

  /**
   * Returns a typed array containing all of the elements in this list in proper
   * ordering. This class contains no reference to the returned array.
   *
   * @return An array containing all of the elements in proper ordering
   * @throws ArrayStoreException If the runtime type of the specified array
   *         is not a supertype of the runtime type of every element in
   *         this array
   * @throws NullPointerException If the specified array is null
   */
  @Override
  public <T> T[] toArray(T[] a) {
    return values.toArray(a);
  }
}
