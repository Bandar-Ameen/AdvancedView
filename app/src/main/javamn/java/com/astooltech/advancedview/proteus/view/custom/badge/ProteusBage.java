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

package com.astooltech.advancedview.proteus.view.custom.badge;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;

/**
 * Button
 *
 * @author aditya.sharat
 */
public class ProteusBage extends BadgeView implements ProteusView {

  Manager viewManager;

  public ProteusBage(Context context) {
    super(context);
  }



  @Override
  public Manager getViewManager() {
    return viewManager;
  }

  @Override
  public void setViewManager(@NonNull Manager manager) {
    this.viewManager = manager;
  }

  @NonNull
  @Override
  public View getAsView() {
    return this;
  }
}
