/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus;

import android.os.Parcelable;

/**
 * SimpleIdGenerator
 * <p>
 * Simulates the R class. Useful to given unique ID for use in {@link android.view.View#setId(int)} method.
 * An ID which doesn't conflict with aapt's ID is ensured. Please ensure that all dynamic ID call go through
 * this class to ensure uniqueness with other dynamic IDs.
 * </p>
 *
 * @author aditya.sharat
 */
public interface IdGenerator extends Parcelable {
  /**
   * Generates and returns a unique id, for the given key.
   * If key exists, returns old value.
   * Ensure that all
   *
   * @param id the value for which the ID is returns.
   * @return a unique ID integer for use with {@link android.view.View#setId(int)}.
   */
  int getUnique(String id);
}
