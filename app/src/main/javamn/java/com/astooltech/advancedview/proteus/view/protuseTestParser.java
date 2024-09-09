package com.astooltech.advancedview.proteus.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;


public class protuseTestParser<T extends LodaingLayout> extends ViewTypeParser<T> {


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable MaterialRippleLayout parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }



    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }

    @NonNull
    @Override
    public String getType() {
        return "LayoutStatus";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {


        return new protuseTest(context);


    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
       if(view instanceof  protuseTest) {

           protuseTest dd=(protuseTest)view;
           SetGetFindTextInputLayoutEditTextB(dd,data,typoper);
       }
    }
    private static void SetGetFindTextInputLayoutEditTextB( protuseTest dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                           // datb.setDataGet(dt.getText().toString());
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

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
                          // dt.sh
                           dt.hideOverlay(Integer.parseInt(d));

                        }
                        else   if(datb.getTypselect().equals("6")) {
                           dt.hideLoading();
                           dt.hideError();


                        }
                        else   if(datb.getTypselect().equals("7")) {
                            String d=datb.getDataGet();
                            dt.showOverlay(Integer.parseInt(d));



                        }
                    }
                }

            }

        }
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("Setting", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T t, final Value value) {

                ObjectValue whenloadFinishh = null;
                String message="Now Loading";
try {
    whenloadFinishh = value.getAsObject().get("CustomView").getAsObject();
}catch (Exception ex){

}

                try {
                    message = value.getAsObject().get("Message").getAsString();
                }catch (Exception ex){

                }
                final String evn1="";
              final   protuseTest view=(protuseTest)t;
                StatuseLayout f=new StatuseLayout() {
                    @Override
                    public void loadfinshed() {
                      try {
                          ObjectValue whenloadFinishh = value.getAsObject().get("When_Finish").getAsObject();
                          String Eventname = whenloadFinishh.getAsString("Event_Type");
                          Value whenloadFinish = whenloadFinishh.get("Event_Finish");
                          view.getViewManager().getContext().getAllEven(Eventname).call(view.getAsView().getContext(), view.getViewManager().getContext().getActvityAllt(), whenloadFinish, 0, view, view.getViewManager().getDataContext().getData());
                      }catch (Exception ex){

                      }
                    }

                    @Override
                    public void onerror(String mess, Object ob) {
                        try {
                            ObjectValue whenloadFinishh = value.getAsObject().get("When_Error").getAsObject();
                            String Eventname = whenloadFinishh.getAsString("Event_Type");
                            Value whenloadFinish = whenloadFinishh.get("Event_Error");
                            view.getViewManager().getContext().getAllEven(Eventname).call(view.getAsView().getContext(), view.getViewManager().getContext().getActvityAllt(), whenloadFinish, 0, view, view.getViewManager().getDataContext().getData());
                        }catch (Exception ex){

                        }
                    }

                    @Override
                    public void OnRetray() {
                        try {
                            ObjectValue whenloadFinishh = value.getAsObject().get("When_Retry").getAsObject();
                            String Eventname = whenloadFinishh.getAsString("Event_Type");
                            Value whenloadFinish = whenloadFinishh.get("Event_Retry");
                            view.getViewManager().getContext().getAllEven(Eventname).call(view.getAsView().getContext(), view.getViewManager().getContext().getActvityAllt(), whenloadFinish, 0, view, view.getViewManager().getDataContext().getData());
                        }catch (Exception ex){

                        }
                    }
                };

                if(whenloadFinishh!=null) {
                    try {
                        final View loding = ((protuseTest) t).getViewManager().getContext().getInflater().inflate(whenloadFinishh.get("LoadingLayer").getAsLayout(), view.getViewManager().getDataContext().getData()).getAsView();
                        final View lodinggg = ((protuseTest) t).getViewManager().getContext().getInflater().inflate(whenloadFinishh.get("ErrorLayer").getAsLayout(), view.getViewManager().getDataContext().getData()).getAsView();
                        final View lodingg = ((protuseTest) t).getViewManager().getContext().getInflater().inflate(whenloadFinishh.get("EmptyLayer").getAsLayout(), view.getViewManager().getDataContext().getData()).getAsView();

                        t.setLayerCreator(new GenericStatusLayout.ILayerCreator() {
                            @Override
                            public View createLoadingLayer() {
                                return loding;
                            }

                            @Override
                            public View createEmptyLayer() {
                                return lodingg;
                            }

                            @Override
                            public View createErrorLayer() {
                                return lodinggg;
                            }
                        });
                    }catch (Exception ex){

                    }
                }
                t.setShowlogin(f);
                t.setMessagess(message);
                t.showLoading();
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