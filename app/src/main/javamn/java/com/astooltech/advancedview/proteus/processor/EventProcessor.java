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

package com.astooltech.advancedview.proteus.processor;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

/**
 * EventProcessor
 * <p>
 * <p>
 * Use this Attribute Processor to get event callbacks
 * on the {@link com.astooltech.advancedview.proteus.ProteusLayoutInflater.Callback#onEvent(String, Value, ProteusView)}
 * </p>
 *
 * @author adityasharat
 */

public abstract class EventProcessor<T extends View> extends AttributeProcessor<T> {

  @Override
  public void handleValue(T view, Value value) {
    setOnEventListener(view, value);
  }

  @Override
  public void handleResource(T view, Resource resource) {
    setOnEventListener(view, resource);
  }

  @Override
  public void handleAttributeResource(T view, AttributeResource attribute) {
    setOnEventListener(view, attribute);
  }

  @Override
  public void handleStyleResource(T view, StyleResource style) {
    setOnEventListener(view, style);
  }

  public abstract void setOnEventListener(T view, Value value);

  /**
   * @param event
   * @param value
   * @param view
   */
  public void trigger(boolean withtage,String Tagv,String event, Value value, ProteusView view) {


    ProteusLayoutInflater.Callback callback = view.getViewManager().getContext().getCallback();
    if (null != callback) {
      if(!withtage) {
        callback.onEvent(event, value, view);
      }else
      {
        callback.onEventTage(Tagv,event, value, view);
      }
    }
  }

  private void getallvoigroup(View v,int x){
    x=x+1;
    Log.i(x+"ViewOnlfff",v.getClass().getName());
   if(v instanceof TextInputLayoutB){


     TextInputLayoutB eer=(TextInputLayoutB)v;
     Log.i("wwwww",eer.getEditText().getText().toString());
   }

    if(v instanceof ViewGroup) {
      ViewGroup t=(ViewGroup)((ViewGroup) v);

      for (int cx = 0; cx < t.getChildCount(); cx++) {


        getallvoigroup(t.getChildAt(cx),x);

      }


    }else {

     // Log.i(x+"ViewOnly",v.getClass().getName()+"@@");
    }

  }
  public void triggerv(ProteusView view,Value v) {

    String eew=v.getAsObject().get("Event_Type").getAsString();

    Gson g=new Gson();


   // Log.i("bbn",g.toJson());
 //   ProteusView dff=view.getViewManager().getContext().getInflater().inflate(eew,new ObjectValue());
  //  DalogeFragment tr=new DalogeFragment(dff);
  //  tr.show(view.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
   try {
     view.getViewManager().getContext().getAllEven(eew).call(view.getAsView().getContext(), view.getViewManager().getContext().getActvityAllt(), v, 0,view,view.getViewManager().getDataContext().getData());
   }catch (Exception ex){

   }
  /*  if(view.getViewManager().getContext().getActvityAllt().hasWindowFocus()) {
      Log.i("ffg", String.valueOf(view.getViewManager().getContext().getActvityAllt().hasWindowFocus()));
      View sse = view.getViewManager().getContext().getActvityAllt().getWindow().getDecorView().getRootView();
      Log.i("ffg", sse.getClass().getName());
      getallvoigroup(sse,0);
    }else {
      Log.i("ffg", String.valueOf(view.getViewManager().getContext().getActvityAllt().hasWindowFocus()));
      View sse = view.getViewManager().getContext().getActvityAllt().getWindow().getDecorView();//.getWindow().getDecorView().findFocus();//.getCurrentFocus();//.getDecorView().getRootView();
      Log.i("ffg", sse.getClass().getName());
      getallvoigroup(sse,0);

    }*/
 try {

 }catch (Exception ex){

   Log.i("ffg",ex.getMessage());
 }
    //view.getViewManager().getContext().getBaseContext().


  }

  public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view) {
    ProteusLayoutInflater.Callback callback = view.getViewManager().getContext().getCallback();

    callback.onEventAdapter(typ,Tagv, event, value, view);


  }
  public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view,EventProcessor proces,String[] somedsta) {
    ProteusLayoutInflater.Callback callback = view.getViewManager().getContext().getCallback();

    callback.onEventAdapter(typ,Tagv, event, value, view,proces,withtage,somedsta);


  }
}
