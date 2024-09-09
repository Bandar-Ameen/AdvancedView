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
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;

/**
 * ProteusViewHolder.
 *
 * @author adityasharat
 */
class ProteusViewHolder extends RecyclerView.ViewHolder   {

  @NonNull
  final ProteusContext context;

  @NonNull
  public final ProteusView view;

  ProteusViewHolder(@NonNull ProteusView view) {

    super(view.getAsView());


    this.view = view;
    this.context = view.getViewManager().getContext();

   /* com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(this.view.getAsView())
            .rippleOverlay(true).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(true).create();
*/
  }


}
