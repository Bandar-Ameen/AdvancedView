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

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.google.gson.Gson;

import java.util.Map;

/**
 * ProteusContextWrapper
 * <p>
 * A wrapper for {@link ProteusContext} that simply delegates all of its calls to
 * another ProteusContext. Can be subclassed to modify or to add new behavior
 * without changing the original ProteusContext.
 * </p>
 *
 * @author adityasharat
 */

public class ProteusContextWrapper extends ProteusContext {
  ProteusContextWrapper(Context base, @Nullable ProteusLayoutInflater.Callback callback, ViewGroup con, ProteusManager proteusManager, String[] dataURL, getmessage_status masss, FragmentManager fm, AbstractFragment mFragment, DrawerLayout drawer, AppCompatActivity ActvityAlltv, String Stringdata, String StringrootLayout, String Stringlayouts, String Stringstyles, Layout mroot, ObjectValue d, Gson cx, ProteusResources resources, StatuseLayout statuse, boolean check, Layout layot, ObjectValue datobj, ProteusLayoutInflater.ImageLoader im,ObjectValue daturce) {
    super(base, callback, con, proteusManager, dataURL, masss, fm, mFragment, drawer, ActvityAlltv, Stringdata, StringrootLayout, Stringlayouts, Stringstyles, mroot, d, cx, resources, statuse, check, layot, datobj, im,daturce);
  }





  /*ProteusContextWrapper(Context base, @Nullable ProteusLayoutInflater.Callback callback, ViewGroup con, String[] dataURL, getmessage_status masss, FragmentManager fm, AbstractFragment mFragment, DrawerLayout drawer, AppCompatActivity ActvityAlltv, Proteus protusee, String Stringdata, String StringrootLayout, String Stringlayouts, String Stringstyles, Map<String, ViewTypeParser> parsers, FunctionManager functionManager, ALLEventManger eventMangeer) {
    super(base, callback, con, dataURL, masss, fm, mFragment, drawer, ActvityAlltv, protusee, Stringdata, StringrootLayout, Stringlayouts, Stringstyles, parsers, functionManager, eventMangeer);
  }*/

  /*public ProteusContextWrapper(ProteusContext context) {
    super(context, context.getProteusResources(), context.getLoader(), context.getCallback(),context.getContainerrb(),context.getProteusManagerrb(),context.getDataURLl(),context.getMassss(),context.getFrgmentMangers(),context.getmFragmenttv(),context.getmDrawerr(),context.getActvityAllt(),context.getStringdata(),context.getStringrootLayout(),context.getStringlayouts(),context.getStringstyles(),context.getRootLayout(),context.getData(),context.getParsers(),null,null,context.getFunctionManager(),context.getEventMangee(),context.getJson());
  }*/
}
