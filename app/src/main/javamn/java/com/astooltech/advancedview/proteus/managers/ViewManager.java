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

package com.astooltech.advancedview.proteus.managers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.BoundAttribute;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewManager
 *
 * @author aditya.sharat
 */
public class ViewManager implements ProteusView.Manager {

  @NonNull
  protected final ProteusContext context;

 ProteusView.Manager.ActionEventView  actionn;
    ProteusView.Manager.ActionEventViewForUto  actionnt;
    GenericStatusLayout statlay;
  @NonNull
  protected final View view;

  @NonNull
  protected final Layout layout;

  @NonNull
  protected final DataContext dataContext;

  @NonNull
  protected final ViewTypeParser parser;

  @Nullable
  protected final List<BoundAttribute> boundAttributes;

  @Nullable
  protected Object extras;

  public ViewManager(@NonNull ProteusContext context, @NonNull ViewTypeParser parser,
                     @NonNull View view, @NonNull Layout layout, @NonNull DataContext dataContext) {
    this.context = context;
    this.parser = parser;
    this.view = view;
    this.layout = layout;
    this.dataContext = dataContext;


    if (null != layout.attributes) {
      List<BoundAttribute> boundAttributes = new ArrayList<>();
      for (Layout.Attribute attribute : layout.attributes) {
        if (attribute.value.isBinding()) {
          boundAttributes.add(new BoundAttribute(attribute.id, attribute.value.getAsBinding()));
        }
      }
      if (boundAttributes.size() > 0) {
        this.boundAttributes = boundAttributes;
      } else {
        this.boundAttributes = null;
      }
    } else {
      this.boundAttributes = null;
    }

      if(Statuselayout()==null) {
          GenericStatusLayout deer=new GenericStatusLayout(view.getContext());
          SetGenericStatusLayout(deer,1);

      }
  }

  @Override
  public void update(@Nullable ObjectValue data) {
    // update the data context so all child views can refer to new data
    if (data != null) {
      updateDataContext(data);
    }

    // update the bound attributes of this view
    if (this.boundAttributes != null) {
      for (BoundAttribute boundAttribute : this.boundAttributes) {
        this.handleBinding(boundAttribute);
      }
    }
  }

  @Override
  public ActionEventView getActionEventView() {
    return actionn;
  }

    @Override
    public ActionEventViewForUto getActionEventViewAuto() {
        return actionnt;
    }
    @Override
    public void setActionEventViewAuto(@NonNull ActionEventViewForUto actionEventView) {
        actionnt=actionEventView;
    }
    @Override
  public void setActionEventView(@NonNull ActionEventView actionEventView) {

    actionn=actionEventView;
    //this.parser.parent.
    //  this.setActionEventView(actionEventView);
  }



    @Override
  public void GetData(@Nullable ProteusView dataview, @Nullable ObjectValue data, int typ, String anotherdata) {
  // context.getCallback().onEventTage("g","f",data.get("0"),dataview);
  }

  @Override
  public void SetData(@Nullable ProteusView dataview, @Nullable ObjectValue data, int typ, String anotherdata) {

  }

  @Override
  public void refreshData(@Nullable ProteusView dataview, @Nullable ObjectValue data, int typ, String anotherdata) {

  }

  @Nullable
  @Override
  public View findViewById(@NonNull String id) {
    return view.findViewById(context.getInflater().getUniqueViewId(id));
  }

  @NonNull
  @Override
  public ProteusContext getContext() {
    return this.context;
  }

    @Override
    public GenericStatusLayout Statuselayout() {

      return statlay;
    }

    @Override
    public void SetGenericStatusLayout(GenericStatusLayout sta, int typ) {
        statlay=sta;
        //statlay.attachTo(this.view);
    }

    @NonNull
  @Override
  public Layout getLayout() {
    return this.layout;
  }

  @NonNull
  public DataContext getDataContext() {
    return dataContext;
  }

  @Nullable
  @Override
  public Object getExtras() {
    return this.extras;
  }

  @Override
  public void setExtras(@Nullable Object extras) {
    this.extras = extras;
  }

  private void updateDataContext(ObjectValue data) {
    if (dataContext.hasOwnProperties()) {
      dataContext.update(context, data);
    } else {
      dataContext.setData(data);
    }
  }

  private void handleBinding(BoundAttribute boundAttribute) {
    //noinspection unchecked
    parser.handleAttribute(view, boundAttribute.attributeId, boundAttribute.binding);
  }
}
