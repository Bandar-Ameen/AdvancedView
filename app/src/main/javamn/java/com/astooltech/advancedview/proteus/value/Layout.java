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

package com.astooltech.advancedview.proteus.value;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.toolbox.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Layout
 *
 * @author aditya.sharat
 */

public class Layout extends Value {

  @NonNull
  public final String type;

  @Nullable
  public final List<Attribute> attributes;

  @Nullable
  public final Map<String, Value> data;

  @Nullable
  public final ObjectValue extras;

  public Layout(@NonNull String type, @Nullable List<Attribute> attributes, @Nullable Map<String, Value> data, @Nullable ObjectValue extras) {
    this.type = type;
    this.attributes = attributes;
    this.data = data;
    this.extras = extras;
  }

  @Override
  public Layout copy() {
    List<Attribute> attributes = null;
    if (this.attributes != null) {
      attributes = new ArrayList<>(this.attributes.size());
      for (Attribute attribute : this.attributes) {
        attributes.add(attribute.copy());
      }
    }

    return new Layout(type, attributes, data, extras);
  }

  public Layout merge(Layout include) {

    List<Attribute> attributes = null;
    if (this.attributes != null) {
      attributes = new ArrayList<>(this.attributes.size());
      attributes.addAll(this.attributes);
    }
    if (include.attributes != null) {
      if (attributes == null) {
        attributes = new ArrayList<>(include.attributes.size());
      }
      attributes.addAll(include.attributes);
    }

    Map<String, Value> data = null;
    if (this.data != null) {
      data = this.data;
    }
    if (include.data != null) {
      if (data == null) {
        data = new LinkedHashMap<>(include.data.size());
      }
      data.putAll(include.data);
    }

    ObjectValue extras = new ObjectValue();
    if (this.extras != null) {
      extras = Utils.addAllEntries(extras, this.extras);
    }
    if (include.extras != null) {
      if (extras == null) {
        extras = new ObjectValue();
      }
      Utils.addAllEntries(extras, include.extras);
    }

    return new Layout(type, attributes, data, extras);
  }

  /**
   * Attribute
   *
   * @author aditya.sharat
   */
  public static class Attribute {

    public final int id;
    public final Value value;
    public final String keyname;
    public Attribute(int id, Value value,String keyname) {
      this.id = id;
      this.value = value;
      this.keyname=keyname;
    }

    protected Attribute copy() {
      return new Attribute(id, value.copy(),keyname);
    }
  }
}
