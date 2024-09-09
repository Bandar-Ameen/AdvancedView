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

package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.HashMap;
import java.util.Map;

/**
 * RecyclerViewAdapterFactory.
 *
 * @author adityasharat
 */
public class RecyclerViewAdapterFactory {

  private Map<String, ProteusRecyclerViewAdapter.Builder> adapters = new HashMap<>();

  public void register(@NonNull String type, @NonNull ProteusRecyclerViewAdapter.Builder builder) {
    adapters.put(type, builder);
  }

  @Nullable
  public ProteusRecyclerViewAdapter.Builder remove(@NonNull String type) {
    return adapters.remove(type);
  }

  public ProteusRecyclerViewAdapter create(@NonNull String type, @NonNull ProteusRecyclerView view, @NonNull ObjectValue config) {
    return adapters.get(type).create(view, config);
  }
}
