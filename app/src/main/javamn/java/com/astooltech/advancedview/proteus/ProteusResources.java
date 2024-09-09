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

import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.util.Map;

/**
 * ProteusResources
 *
 * @author adityasharat
 */

public class ProteusResources {

  @NonNull
  private final Map<String, ViewTypeParser> parsers;

  @Nullable
  private final LayoutManager layoutManager;

  @NonNull
  private final FunctionManager functionManager;

  @Nullable
  private final StyleManager styleManager;
  private final ALLEventManger eventMangee;

  ProteusResources(@NonNull Map<String, ViewTypeParser> parsers, @Nullable LayoutManager layoutManager,
                   @NonNull FunctionManager functionManager, @Nullable StyleManager styleManager,ALLEventManger eventMangeer) {
    this.parsers = parsers;
    this.layoutManager = layoutManager;
    this.functionManager = functionManager;
    this.styleManager = styleManager;
    this.eventMangee=eventMangeer;
  }

  @NonNull
  public FunctionManager getFunctionManager() {
    return this.functionManager;
  }
  @NonNull
  public ALLEventManger getALLEventManger() {
    return this.eventMangee;
  }
  @NonNull
  public ALLEvent getALLEvent(String name) {
    return eventMangee.get(name);
  }
  @NonNull
  public Function getFunction(@NonNull String name) {
    return functionManager.get(name);
  }

  @Nullable
  public Layout getLayout(@NonNull String name) {
    return null != layoutManager ? layoutManager.get(name) : null;
  }
  @Nullable
  public void addlayout(ObjectValue valueadd) {

    if(layoutManager!=null){
      layoutManager.add(valueadd);
    }

  }
  public Map<String, Layout> GetLayouts(){

    return  layoutManager.getLayouts();
  }
  public Styles getStyles(){

    return  styleManager.getallStyles();
  }

  @NonNull
  public Map<String, ViewTypeParser> getParsers() {
    return parsers;
  }

  @Nullable
  public Map<String, Value> getStyle(String name) {
    return null != styleManager ? styleManager.get(name) : null;
  }
}
