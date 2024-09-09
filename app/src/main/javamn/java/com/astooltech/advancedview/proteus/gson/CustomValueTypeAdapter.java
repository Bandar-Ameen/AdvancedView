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

package com.astooltech.advancedview.proteus.gson;

import com.google.gson.TypeAdapter;
import com.astooltech.advancedview.proteus.value.Value;

/**
 * CustomValueTypeAdapter
 *
 * @author adityasharat
 */
public abstract class CustomValueTypeAdapter<V extends Value> extends TypeAdapter<V> {

  public final int type;

  protected CustomValueTypeAdapter(int type) {
    this.type = type;
  }

}
