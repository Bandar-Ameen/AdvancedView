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

package com.astooltech.advancedview.proteus.v7.widget;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;

/**
 * ProteusCardView
 *
 * @author adityasharat
 */

public class ProteusCardView extends CardView implements ProteusView {

  private Manager manager;

  public ProteusCardView(ProteusContext context) {
    super(context);
  }

  @Override
  public Manager getViewManager() {
    return manager;
  }

  @Override
  public void setViewManager(@NonNull Manager manager) {
    this.manager = manager;
  }

  @NonNull
  @Override
  public View getAsView() {

  /* ProteusLinearLayout bbb=new ProteusLinearLayout( this.getViewManager().getContext());

    ViewGroup.LayoutParams gg=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
    SkeletonViewGroup jjj=new SkeletonViewGroup( this.getViewManager().getContext());

    ArrayList<SkeletonModel> kk=new ArrayList<>();




            kk.add(new SkeletonModelBuilder().setChildView(this).setCustomHeight(ConverterUnitUtil.dpToPx(
          this.getViewManager().getContext(),500f
    )).setCustomWidth( ConverterUnitUtil.dpToPx(this.getViewManager().getContext(),500f)).build());
    jjj.setSkeletonModels(kk);
    bbb.addView(jjj,gg);
*/
    return this;
  }
}
