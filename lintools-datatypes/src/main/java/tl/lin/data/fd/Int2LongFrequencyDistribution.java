/*
 * Lintools: tools by @lintool
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package tl.lin.data.fd;

import org.apache.hadoop.io.Writable;

import tl.lin.data.pair.PairOfIntLong;

/**
 * A frequency distribution where events are ints and counts are longs.
 */
public interface Int2LongFrequencyDistribution extends SortableEntries<PairOfIntLong>, Writable {

  /**
   * Increments the count of an event {@code key}.
   */
  public void increment(int key);

  /**
   * Increments the count of an event {@code key} by {@code cnt}.
   */
  public void increment(int key, long cnt);

  /**
   * Decrements the count of an event {@code key}.
   */
  public void decrement(int key);

  /**
   * Decrements the count of a particular event {@code key} by {@code cnt}.
   */
  public void decrement(int key, long cnt);

  /**
   * Returns {@code true} if {@code key} exists in this object.
   */
  public boolean contains(int key);

  /**
   * Returns the count of a particular event {@code key}.
   */
  public long get(int key);

  /**
   * Computes the relative frequency of a particular event {@code key}. That is,
   * {@code f(key) / SUM_i f(key_i)}.
   */
  public double computeRelativeFrequency(int key);

  /**
   * Computes the log (base e) of the relative frequency of a particular event {@code key}.
   */
  public double computeLogRelativeFrequency(int key);

  /**
   * Sets the count of a particular event {@code key} to {@code cnt}.
   */
  public long set(int key, long cnt);

  /**
   * Removes the count of a particular event {@code key}.
   */
  public long remove(int k);

  /**
   * Removes all events.
   */
  public void clear();

  /**
   * Returns number of distinct events observed. Note that if an event is observed and then its
   * count subsequently removed, the event will not be included in this count.
   */
  public int getNumberOfEvents();

  /**
   * Returns the sum of counts of all observed events. That is, {@code SUM_i f(key_i)}.
   */
  public long getSumOfCounts();
}
