package com.astooltech.advancedview.proteus.view.custom;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.SlidingTabLayout;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.utils.UnreadMsgUtils;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.ArrayList;
import java.util.List;

import static com.astooltech.advancedview.proteus.anotherView.viewSlider.widget.JToolbar.dp2px;


public class ProtouseSlidingTabLayoutParser<T extends SlidingTabLayout> extends ViewTypeParser<T> {


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
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
        return "SlidderLayout";
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
        return new ProtouseSlidingTabLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);

        if(typoper==105){
            try {
                if(view instanceof ProtouseSlidingTabLayout) {
                    ProtouseSlidingTabLayout k=(ProtouseSlidingTabLayout)view;
                    ObjectValue obj = data.getCustomevalue().getAsObject();//.getAsObject("Common_Msg");
                    Array getmsgmar = obj.getAsArray("Setting_Msg");
                    for (int xxc = 0; xxc < getmsgmar.size(); xxc++) {

                        int leftpading = getmsgmar.get(xxc).getAsObject().getAsInteger("LeftPadding");
                        int buttom = getmsgmar.get(xxc).getAsObject().getAsInteger("BottomPadding");
                        int buttomn = getmsgmar.get(xxc).getAsObject().getAsInteger("Size_Msg");
                        int buttomnk = getmsgmar.get(xxc).getAsObject().getAsInteger("Index_Msg");
                        k.setMsgMargin(buttomnk, leftpading, buttom);
                        try {
                            UnreadMsgUtils.setSize(k.getMsgView(buttomnk), dp2px(Float.valueOf(String.valueOf(buttomn))));
                        } catch (Exception ex) {

                        }
                    }
                }
            }catch (Exception ex){
                Log.e("gggfffff",ex.getMessage());
            }
        }else {
            if (view instanceof ProtouseSlidingTabLayout) {
                ProtouseSlidingTabLayout wwq = (ProtouseSlidingTabLayout) view;
                String IDDdat = view.getAsView().getTag(R.id.tag3).toString();
                if (IDDdat.equals(data.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if (data.getTypselect().equals("0")) {
                            // datb.setDataGet(dt.getText().toString());
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                        } else if (data.getTypselect().equals("1")) {
                            wwq.setVisibility(View.VISIBLE);
                        } else if (data.getTypselect().equals("2")) {
                            wwq.setVisibility(View.GONE);
                        } else if (data.getTypselect().equals("3")) {
                            wwq.setEnabled(false);
                        } else if (data.getTypselect().equals("4")) {
                            wwq.setEnabled(true);
                        } else if (data.getTypselect().equals("15")) {
                            int get = data.getCustomevalue().getAsObject().getAsInteger("Tab_Id");
                            int gett = data.getCustomevalue().getAsObject().getAsInteger("Tab_count");
                            wwq.showMsg(get, gett);


                        }
                    }
                }
                // Value ert=   data.getCustomevalue()

            }
        }
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("Common_data", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
                int get=value.getAsObject().get("Common_UnderLine").getAsInt();
                int gevt=value.getAsObject().get("Common_UnderLineH").getAsInt();
                int gevtv=value.getAsObject().get("Common_UnderLineGravity").getAsInt();
                int iconM=value.getAsObject().get("Common_UnderLineIconMargin").getAsInt();
                String colun=value.getAsObject().get("Common_UnderLineColor").getAsString();
                String colunn=value.getAsObject().get("Common_UnderLineTextColor").getAsString();
                String colunnv=value.getAsObject().get("Common_UnderLineSelectTextColor").getAsString();


                if(gevtv==1) {
                    view.setIndicatorGravity(gevtv);
                }

                view.setUnderlineGravity(get);
                view.setUnderlineColor(ParseHelper.parseColor(colun));
                view.setTextUnselectColor(ParseHelper.parseColor(colunn));
                view.setUnderlineHeight(Float.valueOf(gevt));//.setTextUnselectColor(ParseHelper.parseColor(colunn));
                view.setTextSelectColor(ParseHelper.parseColor(colunnv));

                //  view.setIconMargin(iconM);


            }

            @Override
            public void handleResource(T view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(T view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(T view, StyleResource style) {

            }
        });
        addAttributeProcessor("y", new StringAttributeProcessor<T>() {
            @Override
            public void setString(final T view, String value) {

                view.setIndicatorColor(R.color.red_A100);//="#ffffff"

                view.setTextSelectColor(R.color.green_800);
                view.setTextUnselectColor(R.color.yellow_400);
                // view.setTabData(mTitles);
                //  view.showDot(2);
              //  view.setindectocolor(R.color.material_color_brown_A100);
                String IDDdat = "6";
                final  String  nametage="6";
                final ArrayList<Fragment> mFragments = new ArrayList<>();

                final String[] mTitles_3 = {"首页", "消息", "联系人", "更多"};
                ProteusView.Manager.ActionEventView Act = new ProteusView.Manager.ActionEventView() {
                    @Override
                    public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

                    }

                    @Override
                    public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {

                    }

                    @Override
                    public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                    }

                    @Override
                    public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {
                        ProtouseSlidingTabLayout dd=(ProtouseSlidingTabLayout) view;
                        String IDDdat = "6";//vm.getAsView().getTag(R.id.tag3).toString();
                        //  Log.i("888877","jhjhjhjhjhjhjhjh");
                        if(nametage.equals(IDDdat)) {

                            //  final ProtouseSegementLayout mTabLayout_3=(ProtouseSegementLayout)((ProteusViewPager) dd).getViewManager().getContext().getInflater().inflate("mlov", new ObjectValue()).getAsView();

                            //  Log.i("00099","mmmmnnnnn"+dd.getViewManager().findViewById("mlove").getId());
                          /*  for (String title : mTitles_3) {
                                mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + title));
                            }
                            view.setTabData(mTitles_3,mfrag,((ProtouseSegementLayout) vm).getId(),mFragments);
*/
                            //adapter.notifyDataSetChanged();
                        }
                    }
                };


                if (((ProtouseSlidingTabLayout) view).getViewManager().getActionEventView() == null) {
                    ((ProtouseSlidingTabLayout) view).getViewManager().setActionEventView(Act);
                    //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

                }
                final String[] ggg = new String[]{"0"};
                final EventProcessor uuip = new EventProcessor() {
                    @Override
                    public void setOnEventListener(View view, Value value) {

                    }
                };


                // uuip.triggerAdapter(150, true, "6", "6", null, (ProteusView) view, uuip, ggg);

                // drt.bindViewPager(view);


                //  final String[] mTitles = {"name", "address","dfdf","rtrtrt"};


            /*  view.setOnTabSelectListener(new OnTabSelectListener() {
    @Override
    public void onTabSelect(int position) {


        Toast.makeText(view.getContext(),mTitles[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(view.getContext(),mTitles[position],Toast.LENGTH_LONG).show();
    }


});*/

                // view.setCurrentTab(3);
            }
        });

    }
}
