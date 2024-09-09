package com.astooltech.advancedview.finaldemo.opengraphview;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout;
import com.astooltech.advancedview.proteus.parser.custom.WatingLayoutProtuse;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.finaldemo.fragments.AdvancedWebView;
import com.astooltech.advancedview.finaldemo.fragments.ProteusWebView;
import com.astooltech.advancedview.finaldemo.opengraphview.network.model.OGData;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Executable;


public class OpenGraphViewProtouseParser<T extends OpenGraphView> extends ViewTypeParser<T> {


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable MaterialRippleLayout parent, int dataIndex) {
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
        return "UrlView";
    }

    @Override
    public void BordcastRecever(String Broad) {
        super.BordcastRecever(Broad);
        try {
            if (getview != null) {

                getview.getViewManager().getActionEventView().sendEvent(null, 7000, Broad);
            }
        }catch (Exception ex){

        }
    }

    @Override
    public void ReceveSearch(String Broad, String viewID) {
        super.ReceveSearch(Broad, viewID);
        if(Broad.equals("0")) {
            if (getview != null) {
                getview.getViewManager().getActionEventView().sendEvent(null, 178000, Broad);
            }
        }else{
            if (getview != null) {
                String getse = getview.getAsView().getTag(com.astooltech.advancedview.R.id.tag3).toString();

                if (viewID.equals(getse)) {
                    getview.getViewManager().getActionEventView().sendEvent(null, 78000, Broad);
                }
            }


        }
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    private static ProteusView getview;
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {
        getview=new OpenGraphViewProtouse(context);
        return getview;
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);

    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(typoper==20){
            if(getview!=null){
                try {
                    OpenGraphViewProtouse qww = (OpenGraphViewProtouse) getview;
                    if (qww.hasFocus()) {
                    /* if (qww.canGoBack()) {

                         qww.getViewManager().getContext().getProteusManagerrb().notifySuccessOnBack("1", "1");

                     } else {
                         qww.getViewManager().getContext().getProteusManagerrb().notifySuccessOnBack("0", "0");
                     }*/
                    }
                }catch (Exception ex){

                }
            }
        }else {
            if (view instanceof OpenGraphViewProtouse) {
                SetGetFindWebView((OpenGraphViewProtouse) view, data, typoper);
            }
        }
    }
    private static void SetGetFindWebView(OpenGraphViewProtouse dt, DataValueSelect datb, int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

//dt.getViewManager().getLayout().type.getViewManager().getContext().getProteusResources().getParsers().getParser()
                String IDDdat = dt.getTag(com.astooltech.advancedview.R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                            // datb.setDataGet(String.valueOf(dt.isChecked()));

                        }else   if(datb.getTypselect().equals("1")) {
                            dt.setVisibility(View.VISIBLE);
                        }
                        else   if(datb.getTypselect().equals("2")) {
                            dt.setVisibility(View.GONE);
                        }
                        else   if(datb.getTypselect().equals("3")) {
                            dt.setEnabled(false);
                        }

                        else   if(datb.getTypselect().equals("4")) {
                            dt.setEnabled(true);
                        }
                        else   if(datb.getTypselect().equals("5")) {
                            String d=datb.getDataGet();
                            dt.loadFrom(d);
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }


    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("proper", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T t, Value value) {
               final OpenGraphViewProtouse datva=(OpenGraphViewProtouse)t;
                String loadurl=value.getAsObject().getAsString("Url_Address");
                String loadurlc=value.getAsObject().getAsString("Url_BgColor");
                String loadurlcc=value.getAsObject().getAsString("Url_StrokeColor");
                datva.separateImage(true);
                datva.loadFrom(loadurl);
              try {
                  int radia = value.getAsObject().getAsInteger("Url_Radius");
                  int radiaa = value.getAsObject().getAsInteger("Url_ImagePosition");

                 /* datva.setBgColor(ParseHelper.parseColor("#" + loadurlc));
                //  datva.setCornerRadius(Float.valueOf(String.valueOf(radia)));
                  datva.setStrokeColor(ParseHelper.parseColor("#" + loadurlcc));
                  if (radiaa == 0) {
                      datva.setImagePosition(OpenGraphViewProtouse.IMAGE_POSITION.LEFT);
                  } else {
                      datva.setImagePosition(OpenGraphViewProtouse.IMAGE_POSITION.RIGHT);
                  }*/

                /*  datva.setOnLoadListener(new OnLoadListener() {
                      @Override
                      public void onLoadStart() {
                          super.onLoadStart();
                          if (datva.getRootView() instanceof WatingLayoutProtuse) {
                              WatingLayoutProtuse ree = (WatingLayoutProtuse) datva.getRootView();
                              ree.startWating();
                          }
                      }

                      @Override
                      public void onLoadFinish() {
                          super.onLoadFinish();
                          if (datva.getRootView() instanceof WatingLayoutProtuse) {
                              WatingLayoutProtuse ree = (WatingLayoutProtuse) datva.getRootView();
                              ree.Stopwa();
                          }
                      }

                      @Override
                      public void onLoadError(Throwable e) {
                          super.onLoadError(e);
                          if (datva.getRootView() instanceof WatingLayoutProtuse) {
                              WatingLayoutProtuse ree = (WatingLayoutProtuse) datva.getRootView();
                              ree.showError(e.getMessage());
                          }
                      }

                  });*/
              }catch (Exception ex){
                  Log.e("dddd",ex.getMessage());
              }

            }

            @Override
            public void handleResource(T t, Resource resource) {

            }

            @Override
            public void handleAttributeResource(T t, AttributeResource attributeResource) {

            }

            @Override
            public void handleStyleResource(T t, StyleResource styleResource) {

            }
        });
}
}