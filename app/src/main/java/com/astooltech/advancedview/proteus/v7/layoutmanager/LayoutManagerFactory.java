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

package com.astooltech.advancedview.proteus.v7.layoutmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.HashMap;
import java.util.Map;

/**
 * LayoutManagerFactory
 *
 * @author adityasharat
 */
public class LayoutManagerFactory {

  private Map<String, LayoutManagerBuilder> builders = new HashMap<>();

  public void register(@NonNull String type, @NonNull LayoutManagerBuilder builder) {
    builders.put(type, builder);
  }

  @Nullable
  public LayoutManagerBuilder remove(@NonNull String type) {
    return builders.remove(type);
  }

  public RecyclerView.LayoutManager create(@NonNull String type, @NonNull ProteusRecyclerView view, @NonNull ObjectValue config) {
   // LinearLayoutManager b=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
    return  builders.get(type).create(view, config);
  }

}
