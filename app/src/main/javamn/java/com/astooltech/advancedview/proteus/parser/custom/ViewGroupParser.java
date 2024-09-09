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

package com.astooltech.advancedview.proteus.parser.custom;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.autoimageslider.Transformations.PopTransformation;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.retrofiturlmanager.NetWorkManager;
import com.astooltech.advancedview.proteus.retrofiturlmanager.RetrofitUrlManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.demo.api.fragmentexam;
import com.astooltech.advancedview.proteus.design.widget.ProteusBottomNavigationView;
import com.astooltech.advancedview.proteus.design.widget.protousToolBarView;
import com.astooltech.advancedview.proteus.exceptions.ProteusInflateException;
import com.astooltech.advancedview.proteus.managers.ViewGroupManager;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Binding;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.NestedBinding;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusAspectRatioFrameLayout;
import com.astooltech.advancedview.proteus.view.ProteusButton;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.io.IOException;
import java.util.Iterator;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;

import static com.astooltech.advancedview.proteus.retrofiturlmanager.api.Api.DOUBAN_DOMAIN_NAME;

public class ViewGroupParser<T extends ViewGroup> extends ViewTypeParser<T> {

  private static final String LAYOUT_MODE_CLIP_BOUNDS = "clipBounds";
  private static final String LAYOUT_MODE_OPTICAL_BOUNDS = "opticalBounds";
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                              @Nullable MaterialRippleLayout  parent, int dataIndex) {
    return new ProteusRappleLayout(context);
  }
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
    return new TextInputLayoutB(context);
  }
  @NonNull
  @Override
  public String getType() {
    return "ViewGroup";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "View";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusAspectRatioFrameLayout(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);

  }

  @Override
  public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
    super.GetAndSetData(view, data, typoper, anotherdat, viewname);
   try {
     if (view instanceof ProteusAspectRatioFrameLayout) {
       if (data.getTypselect().equals("10")) {
         ProteusAspectRatioFrameLayout ss = (ProteusAspectRatioFrameLayout) view;
         String IDDdat = ss.getTag(R.id.tag3).toString();
         if (IDDdat.equals(data.getIDUnit())) {
           {
             // ProteusView vieww = view.getViewManager().getContext().getInflater().inflate(data.getDataGet(), new ObjectValue());
             fragmentexam fmn = new fragmentexam(data.getDataGet(), view.getViewManager().getContext().getInflater(), null);
             FragmentTransaction ddb = view.getViewManager().getContext().getFrgmentMangers().beginTransaction();
             ddb.add(ss.getId(), fmn);
             ddb.commit();

           }
         }
       }

     }
   }catch (Exception ex){

   }
  }

  @NonNull
  @Override
  public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout,
                                               @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable ViewGroup parent,
                                               int dataIndex) {
    DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
    return new ViewGroupManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
  }

  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor(Attributes.ViewGroup.ClipChildren, new BooleanAttributeProcessor<T>() {
      @Override
      public void setBoolean(T view, boolean value) {
        view.setClipChildren(value);
      }
    });

    addAttributeProcessor(Attributes.ViewGroup.ClipToPadding, new BooleanAttributeProcessor<T>() {
      @Override
      public void setBoolean(T view, boolean value) {
        view.setClipToPadding(value);
      }
    });

    addAttributeProcessor(Attributes.ViewGroup.LayoutMode, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
          if (LAYOUT_MODE_CLIP_BOUNDS.equals(value)) {

            view.setLayoutMode(ViewGroup.LAYOUT_MODE_CLIP_BOUNDS);
          } else if (LAYOUT_MODE_OPTICAL_BOUNDS.equals(value)) {
            view.setLayoutMode(ViewGroup.LAYOUT_MODE_OPTICAL_BOUNDS);
          }
        }
      }
    });

    addAttributeProcessor(Attributes.ViewGroup.SplitMotionEvents, new BooleanAttributeProcessor<T>() {
      @Override
      public void setBoolean(T view, boolean value) {
        view.setMotionEventSplittingEnabled(value);
      }
    });

    addAttributeProcessor(Attributes.ViewGroup.Children, new AttributeProcessor<T>() {
      @Override
      public void handleBinding(T view, Binding value) {
       // Log.i("No", "Nooooooo1uuuuuuuuu");
        handleDataBoundChildren(view, value);
      }

      @Override
      public void handleValue(T view, Value value) {
        handleChildren(view, value);
      }

      @Override
      public void handleResource(T view, Resource resource) {
        throw new IllegalArgumentException("children cannot be a resource");
      }

      @Override
      public void handleAttributeResource(T view, AttributeResource attribute) {
        throw new IllegalArgumentException("children cannot be a resource");
      }

      @Override
      public void handleStyleResource(T view, StyleResource style) {
        throw new IllegalArgumentException("children cannot be a style attribute");
      }
    });
  }

  @Override
  public boolean handleChildren(T view, Value children) {
  /* try {
     ProteusView proteusView = ((ProteusView) view);
     new handelview(proteusView, children).execute();
   }catch (Exception ex){

   }*/
     try {
     ProteusView proteusView = ((ProteusView) view);
     ProteusView.Manager viewManager = proteusView.getViewManager();
     ProteusLayoutInflater layoutInflater = viewManager.getContext().getInflater();
     ObjectValue data = viewManager.getDataContext().getData();
     int dataIndex = viewManager.getDataContext().getIndex();

     if (children.isArray()) {
       ProteusView child;
       Iterator<Value> iterator = children.getAsArray().iterator();
       Value element;
       while (iterator.hasNext()) {
         element = iterator.next();
         if (!element.isLayout()) {
           throw new ProteusInflateException("attribute  'children' must be an array of 'Layout' objects");
         }
         child = layoutInflater.inflate(element.getAsLayout(), data, view, dataIndex);
         addView(proteusView, child);
       }
     }
   }catch (Exception ex){

    Log.e("Exfinal",ex.getMessage());
  }
    return true;
  }

  protected void handleDataBoundChildren(T view, Binding value) {
try {
  ProteusView parent = ((ProteusView) view);
  ViewGroupManager manager = (ViewGroupManager) parent.getViewManager();
  DataContext dataContext = manager.getDataContext();
  ObjectValue config = ((NestedBinding) value).getValue().getAsObject();

  Binding collection = config.getAsBinding(ProteusConstants.COLLECTION);
  Layout layout = config.getAsLayout(ProteusConstants.LAYOUT);

  manager.hasDataBoundChildren = true;

  if (null == layout || null == collection) {
    throw new ProteusInflateException("'collection' and 'layout' are mandatory for attribute:'children'");
  }

  Value dataset = collection.getAsBinding().evaluate(view.getContext(), dataContext.getData(), dataContext.getIndex());
  if (dataset.isNull()) {
    return;
  }

  if (!dataset.isArray()) {
    throw new ProteusInflateException("'collection' in attribute:'children' must be NULL or Array");
  }

  int length = dataset.getAsArray().size();
  int count = view.getChildCount();
  ObjectValue data = dataContext.getData();
  ProteusLayoutInflater inflater = manager.getContext().getInflater();
  ProteusView child;
  View temp;

  if (count > length) {
    while (count > length) {
      count--;
      view.removeViewAt(count);
    }
  }

  for (int index = 0; index < length; index++) {
    if (index < count) {
      temp = view.getChildAt(index);
      if (temp instanceof ProteusView) {
        ((ProteusView) temp).getViewManager().update(data);
      }
    } else {
      //noinspection ConstantConditions : We want to throw an exception if the layout is null
      child = inflater.inflate(layout, data, view, index);
      addView(parent, child);
    }
  }
}catch (Exception ex){

  Log.e("Exfinal",ex.getMessage());
}
  }

  @Override
  public boolean addView(ProteusView parent, ProteusView view) {
    try {

      if(parent instanceof  protousToolBarView){
        protousToolBarView  mmtorr =(protousToolBarView)parent;
        if(view instanceof ProteusButton) {
          final ProteusButton fff = (ProteusButton) view;


          mmtorr.getMenu().add(fff.getText()).setIcon(fff.getBackground());
          mmtorr.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
              fff.callOnClick();
              return true;
            }
          });

        }
        return true;
      }else


      if(parent instanceof ProteusBottomNavigationView)
      {
        ProteusBottomNavigationView  mmtorr =(ProteusBottomNavigationView)parent;
       if(view instanceof ProteusButton) {
         final ProteusButton fff=(ProteusButton)view;


         mmtorr.getMenu().add(fff.getText()).setIcon(fff.getBackground());
        mmtorr.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          //  Log.i("677788888",item.getTitle().toString());
            fff.callOnClick();
            return true;
          }
        });
         /*mmtorr.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
           @Override
           public void onNavigationItemReselected(@NonNull MenuItem item) {
             Log.i("6777",item.getTitle().toString());
           }
         });*/
         /* mmtorr.setOnNavigationItemReselectedListener(new MenuItem.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem menuItem) {


             return true;
           }
         });*/
       }
        return true;
      }/*else
      if(parent.getClass().getName().equals("com.astooltech.advancedview.proteus.design.widget.ProteusTabLayout")){
      //  Log.i("99999vvvv",view.getClass().getName());
        TabLayout.Tab vv=((ProteusTabLayout)parent).newTab();

        //vv.view.autofill(AutofillValue.forToggle(true));
        // TabLayout.Tab bb=((ProteusTabLayout)parent).newTab();
       // bb.setText("iiooo");
      //vv.setText("yyy");
        //vv.setText("ffffffffffff");
        vv.setCustomView(view.getAsView());
       ((ProteusTabLayout) parent).addTab(vv);
        //((ProteusTabLayout) parent).addTab(bb);


        return true;
      }*/
     else if (parent instanceof ViewGroup) {
        ((ViewGroup) parent).addView(view.getAsView());
        return true;
      } else if (parent instanceof ViewPager) {
        Log.i("99999vvvv",parent.getClass().getName());
      }
      return false;
    }catch (Exception ex){
      Log.i("99999",parent.getClass().getName());
      return  false;
    }
  }
}
