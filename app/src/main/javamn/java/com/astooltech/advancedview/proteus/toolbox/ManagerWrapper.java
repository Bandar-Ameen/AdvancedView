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

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;

/**
 * ManagerWrapper
 * <p>
 * Proxies the implementation of {@link ProteusView.Manager} that simply delegates
 * all of its calls to another Manager. Can be subclassed to modify or to add new behavior
 * without changing the original Manager.
 * </p>
 *
 * @author adityasharat
 */
public class ManagerWrapper implements ProteusView.Manager {

  private final ProteusView.Manager base;

  public ManagerWrapper(ProteusView.Manager base) {
    this.base = base;
  }

  @Override
  public void update(@Nullable ObjectValue data) {
    base.update(data);
  }

  @Override
  public void GetData(@Nullable ProteusView dataview, @Nullable ObjectValue data, int typ, String anotherdata) {



  // base.getContext().getInflater().getParse.getCallback().onEventTage("g","f",data.get("0"),dataview);
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
    return base.findViewById(id);
  }

  @NonNull
  @Override
  public ProteusContext getContext() {
    return base.getContext();
  }

  @Override
  public GenericStatusLayout Statuselayout() {
    return base.Statuselayout();
  }

  @Override
  public void SetGenericStatusLayout(GenericStatusLayout sta, int typ) {
    base.SetGenericStatusLayout(sta,typ);
  }

  @NonNull
  @Override
  public Layout getLayout() {
    return base.getLayout();
  }

  @NonNull
  @Override
  public DataContext getDataContext() {
    return base.getDataContext();
  }

  @Nullable
  @Override
  public Object getExtras() {
    return base.getExtras();
  }

  @Override
  public void setExtras(@Nullable Object extras) {
    base.setExtras(extras);
  }

  @Override
  public ActionEventView getActionEventView() {
    return base.getActionEventView();
  }

  @Override
  public void setActionEventView(@NonNull ActionEventView actionEventView) {
base.setActionEventView(actionEventView);
  }
  @Override
  public void setActionEventViewAuto(@NonNull ActionEventViewForUto actionEventView) {
base.setActionEventViewAuto(actionEventView);
  }

  @Override
  public ActionEventViewForUto getActionEventViewAuto() {
    return base.getActionEventViewAuto();// actionnt;
  }
  public ProteusView.Manager getBaseManager() {
    return base;
  }
}
