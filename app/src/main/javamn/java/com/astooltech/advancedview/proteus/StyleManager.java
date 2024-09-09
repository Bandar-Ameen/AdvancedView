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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.chat.commons.Style;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.util.Iterator;
import java.util.Map;

/**
 * StyleManager
 *
 * @author adityasharat
 */
public abstract class StyleManager {
  @Nullable
  protected abstract Styles getStyles();

  @Nullable
  public Map<String, Value> get(@NonNull String name) {
    return null != getStyles() ? getStyles().get(name) : null;
  }

  public Styles getallStyles(){

    return  getStyles();
  }

}
