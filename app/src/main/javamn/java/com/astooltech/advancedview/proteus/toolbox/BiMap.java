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

package com.astooltech.advancedview.proteus.toolbox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * BiMap
 *
 * @author adityasharat
 */

public interface BiMap<K, V> {

  @Nullable
  V put(@Nullable K key, @Nullable V value);

  @Nullable
  V put(@Nullable K key, @Nullable V value, boolean force);

  @Nullable
  V getValue(@NonNull K key);

  @Nullable
  K getKey(@NonNull V value);

  void putAll(@NonNull Map<? extends K, ? extends V> map);

  @NonNull
  Set<V> values();

  @NonNull
  BiMap<V, K> inverse();
}
