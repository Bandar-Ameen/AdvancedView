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

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.ObjectValue;

/**
 * @author adityasharat
 */
public class ProteusLinearLayoutManager extends LinearLayoutManager {

  private static final String ATTRIBUTE_ORIENTATION = "orientation";
  private static final String ATTRIBUTE_REVERSE_LAYOUT = "reverse";

  public static final LayoutManagerBuilder<ProteusLinearLayoutManager> BUILDER = new LayoutManagerBuilder<ProteusLinearLayoutManager>() {

    @NonNull
    @Override
    public ProteusLinearLayoutManager create(@NonNull ProteusRecyclerView view, @NonNull ObjectValue config) {
      String typev="vo";
      String space="10";
      String showPrograss="no";
        String apigetdata="no";
        String apimehod="no";
        String apibody="no";
        String showPrograssn="no";
try {
  typev = config.getAsObject().getAsString("orientation");//oritation
  space = config.getAsObject().getAsString("space");//oritation
    showPrograss = config.getAsObject().getAsString(Attributes.View.Recycle_prograss);//oritation
    apigetdata = config.getAsObject().getAsString(Attributes.View.APIURL);//oritation
    apimehod = config.getAsObject().getAsString(Attributes.View.APIMethod);//oritation
    apibody = config.getAsObject().getAsString(Attributes.View.APIRequestbody);//oritation
    showPrograssn = config.getAsObject().getAsString(Attributes.View.Recyle_usePrograss);//oritation


view.setTag(R.id.scrollPrograss,showPrograss);
    view.setTag(R.id.Recleapi_url,apigetdata);
    view.setTag(R.id.Recleapi_Method,apimehod);
    view.setTag(R.id.Recleapi_body,apibody);
    view.setTag(R.id.Recleapi_use,showPrograssn);

}catch (Exception ex){



}
      assert typev != null;

     String hh=typev.toUpperCase().substring(0,1);
      int orientation=0;
      int dicrol=0;
      Log.i("Proteus", hh );
if(hh.equals("H")){

  orientation = config.getAsInteger(ATTRIBUTE_ORIENTATION, LinearLayoutManager.HORIZONTAL);
  dicrol=DividerItemDecoration.HORIZONTAL;
}else{
  orientation = config.getAsInteger(ATTRIBUTE_ORIENTATION, LinearLayoutManager.VERTICAL);
  dicrol= DividerItemDecoration.VERTICAL;
}
      GradientDrawable j=new GradientDrawable(GradientDrawable.Orientation.BR_TL,new int[]{0xfff7f7f7,0xfff7f7f7});
try {
  j.setSize(Integer.parseInt(space), Integer.parseInt(space));
}catch (Exception ex){

  j.setSize(20, 20);
}
      DividerItemDecoration nn=new DividerItemDecoration(view.getContext(),dicrol);
      nn.setDrawable(j);
      view.addItemDecoration(nn);
     //view.addItemDecoration(new GridSpacingItemDecoration());

      Log.i("Proteus", typev );//.getAsObject().toString());

      boolean reverseLayout = config.getAsBoolean(ATTRIBUTE_REVERSE_LAYOUT, false);

      return new ProteusLinearLayoutManager(view.getContext(), orientation, reverseLayout);
    }
  };

  public ProteusLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
    super(context, orientation, reverseLayout);
  }
}
