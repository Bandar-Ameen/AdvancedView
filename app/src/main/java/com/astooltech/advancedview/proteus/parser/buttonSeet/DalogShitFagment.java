package com.astooltech.advancedview.proteus.parser.buttonSeet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentEndlessScrolling;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentInstagramHeaders;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentOverall;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentStaggeredLayout;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItemCustome;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.SlidingTabLayout;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.CustomTabEntity;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.OnTabSelectListener;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.entity.TabEntity;
import com.astooltech.advancedview.proteus.demo.api.fragmentexam;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.TabModel;
import com.astooltech.advancedview.proteus.parser.adapterskit.SectionedListFragment;
import com.astooltech.advancedview.proteus.parser.adapterskit.mfrg;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.AgentWebFragment;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.v4.view.ProteusViewPager;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseCommonTabLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSegementLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSlidingTabLayout;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DalogShitFagment extends  ViewPagerBottomSheetDialogFragment {

    private Value val;
    private ProteusLinearLayout lk;
   public DalogShitFagment(Value vall,ProteusLinearLayout layy){
       this.val=vall;
       this.lk=layy;
   }
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        loadfragment(val,lk,getParentFragmentManager());

        dialog.setContentView(lk.getAsView());
//getChildFragmentManager()
    }

    public void loadfragment(Value value, ProteusLinearLayout view, FragmentManager man){
        String type=value.getAsObject().get("Content_Type").toString();
        final Layout fragm=value.getAsObject().get("Content_Fragment").getAsLayout();
        Layout mpager=value.getAsObject().get("Content_Pager").getAsLayout();

        Array contsllview=   value.getAsObject().get("Content_Data").getAsArray();

        final  String color[]=value.getAsObject().get("Content_Color").toString().split("#");
        char r='"';
        int start=0;
        int startcoun=0;
        boolean checkkv=false;
        List<TabModel> temppx=new ArrayList<>();
              /*  Iterator<Map.Entry<String, Value>> vv = contsllview.entrySet().iterator();
                while (vv.hasNext()) {
                    Map.Entry<String, Value> ddert = vv.next();
*/
        Iterator<Value> ert=    contsllview.iterator();
        while (ert.hasNext()) {
            Value ddertc = ert.next();
            String tit=  ddertc.getAsObject().getAsString("ContentTitle");

            String colc=  ddertc.getAsObject().getAsString("ContentColor");
            String mainn=  ddertc.getAsObject().getAsString("ContentMain");
            Layout imgeselect=  ddertc.getAsObject().getAsLayout("ImageSelect");
            ProteusView yy=     ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(imgeselect, null);
            boolean trq= ddertc.getAsObject().getAsBoolean("Content_Select_Start");
            if(!checkkv){
                if(trq){
                    start=startcoun;
                }
            }
            startcoun=startcoun+1;
            Drawable unss=  yy.getAsView().getBackground();

            Layout ImageUnSelect=  ddertc.getAsObject().getAsLayout("ImageUnSelect");

            ProteusView y=     ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(ImageUnSelect, null);

            Drawable uns=  y.getAsView().getBackground();

            int ContentMainCount=  ddertc.getAsObject().getAsInteger("ContentMainCount");
            String ContentView=  ddertc.getAsObject().getAsString("ContentView");
            String ContentType=  ddertc.getAsObject().getAsString("ContentType");

            Layout ImageUnSelectf=null;
            if(ContentType.equals("0")){
                ImageUnSelectf=  ddertc.getAsObject().getAsLayout("ContentView");


            }



            TabModel wwe=new TabModel(tit,colc,mainn,unss,uns,ContentMainCount,ContentView,ContentType, ImageUnSelectf);
            try{
                Value ContentViewB=  ddertc.getAsObject().get("ContentViewB");
                wwe.setAnotherval(ContentViewB);
            }catch (Exception ex){

            }
            temppx.add(wwe);
        }

        // }


            /* String df[]=new String[]{String.valueOf(r)};
             String resul=String.format(contsllview,df);
                Gson vb=new Gson();
                Type typev = new TypeToken<List<TabModel>>() {

                }.getType();*/
        final    List<TabModel> tempp = temppx;




        //final String viewda[]=value.getAsObject().get("Content_View").toString().split("#");

        if(type.equals("1")){

            final ProtouseSegementLayout mTabLayout_3=(ProtouseSegementLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();
            //   final ProtouseCommonTabLayout mTabLayout_4=(ProtouseCommonTabLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();

            mTabLayout_3.setIndicatorColor(ParseHelper.parseColor("#"+color[0]));//="#ffffff"
            mTabLayout_3.setTextSelectColor(ParseHelper.parseColor("#"+color[1]));
            mTabLayout_3.setTextUnselectColor(ParseHelper.parseColor("#"+color[2]));
            mTabLayout_3.setIndicatorCornerRadius(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));
            //  mTabLayout_3.SetStrock(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));
            mTabLayout_3.SetStrock(ParseHelper.parseColor("#"+color[5]));

            // view.setTabData(mTitles);
            //  view.showDot(2);
            mTabLayout_3.setindectocolor(ParseHelper.parseColor("#"+color[3]));
            mTabLayout_3.setindectocolord(ParseHelper.parseColor("#"+color[4]));
            final ArrayList<Fragment> mFragments = new ArrayList<>();
            final  int selectpostion=start;
            // mTabLayout_3.setTabData(mTitles_3);
            view.addView(mTabLayout_3);
            final View pager=(View)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpager, new ObjectValue()).getAsView();

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
                public List<AbstractFlexibleItem> createOverallDatabase(Resources resources, List<ProteusView> itt) {

                    List<AbstractFlexibleItem> mItems = new ArrayList<>();
                    // databaseType = DatabaseType.OVERALL;
                    //  mItems.clear();

                    for (int cx = 0; cx < itt.size(); cx++) {
                        // mItems.add(itt.get(cx));

                        mItems.add(new OverallItem(R.id.nav_selection_modes, resources.getString(R.string.selection_modes)).withView(itt.get(cx).getAsView()).withcheck(false)
                                .withDescription(resources.getString(R.string.selection_modes_description))
                                .withIcon(resources.getDrawable(R.drawable.ic_select_all_grey600_24dp)));
                    }

                    return  mItems;
                }
                @Override
                public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {


                }
            };

            // ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
            String TilteData[]= new String[tempp.size()];

            //value.getAsObject().get("Content_Title").toString().split("#");
            for (int xxc = 0; xxc < tempp.size(); xxc++) {
                TilteData[xxc]=tempp.get(xxc).getContentTitle();
                if(tempp.get(xxc).getContentType().equals("main1")) {
                    DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                    AbstractFragment d   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(d);
                }
                else  if(tempp.get(xxc).getContentType().equals("webb")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    y.putString("data",main_body[0]);
                    AgentWebFragment ttv=AgentWebFragment.getInstance(y);
                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttv);
                }
                else  if(tempp.get(xxc).getContentType().equals("aa")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    SectionedListFragment ttvv=new SectionedListFragment(((ProteusLinearLayout) view),main_body[0]);

                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());

                }


                else  if(tempp.get(xxc).getContentType().equals("dd")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    AbstractFragment ttvv= FragmentEndlessScrolling.newInstance(1,((ProteusLinearLayout) view),main_body[0]);

                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());

                }

                else  if(tempp.get(xxc).getContentType().equals("bb")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    //  Sectione DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());
                    //                                   dListFragment ttvv=new SectionedListFragment();
                    DatabaseService.getInstance().createEndlessDatabase(10);//(ProteusLinearLayout) view).getAsView().getContext());

                    FragmentEndlessScrolling    mFragment = FragmentEndlessScrolling.newInstance(2);


                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(mFragment);//.add(new SectionedListFragment());

                    mFragment.setfill();
                }

                else  if(tempp.get(xxc).getContentType().equals("main2")) {

                    DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                    // FragmentStaggeredLayout.newInstance()
                    // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    AbstractFragment  d   = FragmentStaggeredLayout.newInstance(2); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                    mFragments.add(d);
                }else if(tempp.get(xxc).getContentType().equals("main")){

                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    List<AbstractFlexibleItem> gx = new ArrayList<>();

                    //OverallItemCustome ghhm = new OverallItemCustome("0", "0", vieww.getViewManager().getLayout(), layoutInflater);
                    List<OverallItemCustome> mmnbb=new ArrayList<>();
                    List<ProteusView> mmnbbk=new ArrayList<>();
                    // gx.add(ghm);
                    for (int cx = 0; cx < main_body.length; cx++) {
                        ProteusView viewwx = ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(main_body[cx], null);
                        Layout vx=  new Layout(viewwx.getViewManager().getLayout().type, viewwx.getViewManager().getLayout().attributes, null, viewwx.getViewManager().getLayout().extras);
                        mmnbbk.add(viewwx);
                        OverallItemCustome ghhk = new OverallItemCustome(cx, "h","0", vx, ((ProteusLinearLayout) view).getViewManager().getContext().getInflater());
                        mmnbb.add(ghhk);
                        gx.add(ghhk);
                    }
                    AbstractFragment    mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(),0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                    mFragments.add(mFragment);
                                  /* DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                                   AbstractFragment                  mFragment = FragmentOverall.newInstance(2,0,null, DatabaseService.getInstance().getDatabaseList()); // mFragment = FragmentOverall.newInstance(2,0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                                   mFragments.add(mFragment);*/

                }else {

                    Fragment fg=new fragmentexam(tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),null);

                    mFragments.add(fg);
                }





            }

            mTabLayout_3.setTabData(TilteData,((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),pager.getId(),mFragments);

            mTabLayout_3.setCurrentTab(selectpostion);
            //mTabLayout_3.s(selectpostion);


                           /* mTabLayout_3.showMsg(0, 55);


                            mTabLayout_3.setMsgMargin(1, -5, 5);

                            //设置未读消息红点

                            MsgView rtv_2_2 = mTabLayout_3.getMsgView(0);
                            if (rtv_2_2 != null) {
                                UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f));
                            }
*/
            view.addView(pager);
            if (mTabLayout_3.getViewManager().getActionEventView() == null) {
                mTabLayout_3.getViewManager().setActionEventView(Act);
                //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

            }
            final String[] ggg = new String[]{"0"};
            final EventProcessor uuip = new EventProcessor() {
                @Override
                public void setOnEventListener(View view, Value value) {

                }
            };


            //  uuip.triggerAdapter(150, true, "3", "3", null, (ProteusView) mTabLayout_3, uuip, ggg);



        }else
        if(type.equals("3")){

            final ProtouseSlidingTabLayout mTabLayout_3=(ProtouseSlidingTabLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();
            //   final ProtouseCommonTabLayout mTabLayout_4=(ProtouseCommonTabLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();

            mTabLayout_3.setIndicatorColor(ParseHelper.parseColor("#"+color[0]));//="#ffffff"
            mTabLayout_3.setTextSelectColor(ParseHelper.parseColor("#"+color[1]));
            mTabLayout_3.setTextUnselectColor(ParseHelper.parseColor("#"+color[2]));
            mTabLayout_3.setIndicatorCornerRadius(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));

            mTabLayout_3.setindectocolor(ParseHelper.parseColor("#"+color[3]));
            mTabLayout_3.setindectocolord(ParseHelper.parseColor("#"+color[4]));
            //  mTabLayout_3.SetStrock(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));
            //  mTabLayout_3.SetStrock(ParseHelper.parseColor("#"+color[5]));
            try {

                String  ddm=value.getAsObject().get("Content_Style").toString();

                int  ddmm=Integer.parseInt(value.getAsObject().get("Content_margin").toString());
                mTabLayout_3.setIndicatorMargin(ddmm,ddmm,ddmm,ddmm);
                if(ddm.equals("2")){

                    mTabLayout_3.setIndicatorStyle(SlidingTabLayout.STYLE_BLOCK);
                }else    if(ddm.equals("1")){

                    mTabLayout_3.setIndicatorStyle(SlidingTabLayout.STYLE_TRIANGLE);
                }else {
                    mTabLayout_3.setIndicatorStyle(SlidingTabLayout.STYLE_NORMAL);
                }
                //  mTabLayout_3.setIndicatorCornerRadius(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));

                //  mTabLayout_3.setIndicatorCornerRadius(Integer.parseInt(color[color.length - 1]));
                // mTabLayout_3.setDividerColor(ParseHelper.parseColor("#"+color[3]));


            }catch (Exception ex){

            }
            // view.setTabData(mTitles);
            //  view.showDot(2);
            //mTabLayout_3.setindectocolor(ParseHelper.parseColor("#"+color[3]));
            //mTabLayout_3.setindectocolord(ParseHelper.parseColor("#"+color[4]));
            final ArrayList<Fragment> mFragments = new ArrayList<>();
            final  int selectpostion=start;
            // mTabLayout_3.setTabData(mTitles_3);
            view.addView(mTabLayout_3);
            final View pager=(View)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpager, new ObjectValue()).getAsView();

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

                    // ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

                }
            };


            String TilteData[]= new String[tempp.size()];

            //value.getAsObject().get("Content_Title").toString().split("#");
            for (int xxc = 0; xxc < tempp.size(); xxc++) {
                TilteData[xxc]=tempp.get(xxc).getContentTitle();
                if(tempp.get(xxc).getContentType().equals("main1")) {
                    DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                    AbstractFragment  d   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(d);
                }
                else  if(tempp.get(xxc).getContentType().equals("webb")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    y.putString("data",main_body[0]);
                    AgentWebFragment ttv=AgentWebFragment.getInstance(y);
                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttv);
                }
                else  if(tempp.get(xxc).getContentType().equals("aa")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    SectionedListFragment ttvv=new SectionedListFragment(((ProteusLinearLayout) view),main_body[0]);

                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());

                }


                else  if(tempp.get(xxc).getContentType().equals("dd")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    AbstractFragment ttvv=FragmentEndlessScrolling.newInstance(1,((ProteusLinearLayout) view),main_body[0]);

                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());

                }

                else  if(tempp.get(xxc).getContentType().equals("bb")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    //  Sectione DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());
                    //                                   dListFragment ttvv=new SectionedListFragment();
                    DatabaseService.getInstance().createEndlessDatabase(10);//(ProteusLinearLayout) view).getAsView().getContext());

                    FragmentEndlessScrolling    mFragment = FragmentEndlessScrolling.newInstance(2);


                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(mFragment);//.add(new SectionedListFragment());

                    mFragment.setfill();
                }

                else  if(tempp.get(xxc).getContentType().equals("main2")) {

                    DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                    // FragmentStaggeredLayout.newInstance()
                    // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    AbstractFragment  d   = FragmentStaggeredLayout.newInstance(2); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                    mFragments.add(d);
                }else if(tempp.get(xxc).getContentType().equals("main")){

                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    List<AbstractFlexibleItem> gx = new ArrayList<>();

                    //OverallItemCustome ghhm = new OverallItemCustome("0", "0", vieww.getViewManager().getLayout(), layoutInflater);
                    List<OverallItemCustome> mmnbb=new ArrayList<>();
                    List<ProteusView> mmnbbk=new ArrayList<>();
                    // gx.add(ghm);
                    for (int cx = 0; cx < main_body.length; cx++) {
                        ProteusView viewwx = ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(main_body[cx], null);
                        Layout vx=  new Layout(viewwx.getViewManager().getLayout().type, viewwx.getViewManager().getLayout().attributes, null, viewwx.getViewManager().getLayout().extras);
                        mmnbbk.add(viewwx);
                        OverallItemCustome ghhk = new OverallItemCustome(cx, "h","0", vx, ((ProteusLinearLayout) view).getViewManager().getContext().getInflater());
                        mmnbb.add(ghhk);
                        gx.add(ghhk);
                    }
                    AbstractFragment    mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(),0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                    mFragments.add(mFragment);
                                  /* DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                                   AbstractFragment                  mFragment = FragmentOverall.newInstance(2,0,null, DatabaseService.getInstance().getDatabaseList()); // mFragment = FragmentOverall.newInstance(2,0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                                   mFragments.add(mFragment);*/

                }else {

                    Fragment fg=new fragmentexam(tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),null);

                    mFragments.add(fg);
                }





            }
            ProteusViewPager eer=(ProteusViewPager) pager;
            BottomSheetUtils.setupViewPager(eer);
            MyPagerAdapter mAdapter = new MyPagerAdapter(man,mFragments,TilteData);
            eer.setAdapter(mAdapter);

            final  ProteusViewPager eerr=eer;
            mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
                @Override
                public void onTabSelect(int position) {

                    eerr.setCurrentItem(position);
                }

                @Override
                public void onTabReselect(int position) {
                }
            });

            eerr.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    mTabLayout_3.setCurrentTab(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            //   mTabLayout_3.asetTabData(TilteData,mfrag,pager.getId(),mFragments);
            mTabLayout_3.setViewPager((ProteusViewPager) pager);
            mTabLayout_3.setCurrentTab(selectpostion);
            //mTabLayout_3.s(selectpostion);


                           /* mTabLayout_3.showMsg(0, 55);


                            mTabLayout_3.setMsgMargin(1, -5, 5);

                            //设置未读消息红点

                            MsgView rtv_2_2 = mTabLayout_3.getMsgView(0);
                            if (rtv_2_2 != null) {
                                UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f));
                            }
*/
            view.addView((ProteusViewPager) pager);
            ((ProteusViewPager) pager).invalidate();
            if (mTabLayout_3.getViewManager().getActionEventView() == null) {
                mTabLayout_3.getViewManager().setActionEventView(Act);
                //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

            }
            final String[] ggg = new String[]{"0"};
            final EventProcessor uuip = new EventProcessor() {
                @Override
                public void setOnEventListener(View view, Value value) {

                }
            };


            //   uuip.triggerAdapter(150, true, "3", "3", null, (ProteusView) mTabLayout_3, uuip, ggg);



        }

        else{

            // final ProtouseSegementLayout mTabLayout_3=(ProtouseSegementLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();
            final ProtouseCommonTabLayout mTabLayout_3=(ProtouseCommonTabLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();

            mTabLayout_3.setIndicatorColor(ParseHelper.parseColor("#"+color[0]));//="#ffffff"
            mTabLayout_3.setTextSelectColor(ParseHelper.parseColor("#"+color[1]));
            mTabLayout_3.setTextUnselectColor(ParseHelper.parseColor("#"+color[2]));
            mTabLayout_3.setIndicatorCornerRadius(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));
            //  mTabLayout_3.SetStrock(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));
            // mTabLayout_3.SetStrock(ParseHelper.parseColor("#"+color[5]));

            // view.setTabData(mTitles);
            //  view.showDot(2);
            // mTabLayout_3.setindectocolor(ParseHelper.parseColor("#"+color[3]));
            // mTabLayout_3.setindectocolord(ParseHelper.parseColor("#"+color[4]));
            final ArrayList<Fragment> mFragments = new ArrayList<>();
            //  final  int selectpostion=selectpostion;//value.getAsObject().get("Content_Select_Start").getAsInt();
            // mTabLayout_3.setTabData(mTitles_3);
            view.addView(mTabLayout_3);

            final View pager=(View)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpager, new ObjectValue()).getAsView();

            //final ProteusViewPager pager=(ProteusViewPager)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpager, new ObjectValue()).getAsView();
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
                public List<AbstractFlexibleItem> createOverallDatabase(Resources resources, List<ProteusView> itt) {

                    List<AbstractFlexibleItem> mItems = new ArrayList<>();
                    // databaseType = DatabaseType.OVERALL;
                    //  mItems.clear();

                    for (int cx = 0; cx < itt.size(); cx++) {
                        // mItems.add(itt.get(cx));

                        mItems.add(new OverallItem(R.id.nav_selection_modes, resources.getString(R.string.selection_modes)).withView(itt.get(cx).getAsView()).withcheck(false)
                                .withDescription(resources.getString(R.string.selection_modes_description))
                                .withIcon(resources.getDrawable(R.drawable.ic_select_all_grey600_24dp)));
                    }

                    return  mItems;
                }
                @Override
                public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {


                }
            };

            // ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
            String TilteData[]= new String[tempp.size()];
            Drawable[] selct=new Drawable[tempp.size()];
            Drawable[] unselct=new Drawable[tempp.size()];
            //value.getAsObject().get("Content_Title").toString().split("#");
            for (int xxc = 0; xxc < tempp.size(); xxc++) {
                TilteData[xxc]=tempp.get(xxc).getContentTitle();

                // ProteusView yy=     ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(tempp.get(xxc).getImageUnselect(), null);
                unselct[xxc]= tempp.get(xxc).getImageUnselect(); //yy.getAsView().getBackground();
                //ProteusView y=     ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(tempp.get(xxc).getImagSelect(), null);
                selct[xxc]=tempp.get(xxc).getImagSelect();  //y.getAsView().getBackground();

                if(tempp.get(xxc).getContentType().equals("main1")) {
                    DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    AbstractFragment  d   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(d);
                }
                else  if(tempp.get(xxc).getContentType().equals("aa")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                                   /* Bundle y=new Bundle();
                                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    SectionedListFragment ttvv=new SectionedListFragment(((ProteusLinearLayout) view),main_body[0]);


                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());
                }

                else  if(tempp.get(xxc).getContentType().equals("ff")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                                   /* Bundle y=new Bundle();
                                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    //String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    mfrg ttvv=new mfrg();//SectionedListFragment(((ProteusLinearLayout) view),main_body[0]);


                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());
                }

                else  if(tempp.get(xxc).getContentType().equals("dd")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    //   Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    AbstractFragment ttvv=FragmentEndlessScrolling.newInstance(1,((ProteusLinearLayout) view),main_body[0]);

                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(ttvv);//.add(new SectionedListFragment());

                }
                else  if(tempp.get(xxc).getContentType().equals("bb")) {
                    //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                    // Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                    //  Sectione DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());
                    //                                   dListFragment ttvv=new SectionedListFragment();
                    DatabaseService.getInstance().createEndlessDatabase(10);//(ProteusLinearLayout) view).getAsView().getContext());

                    AbstractFragment    mFragment = FragmentEndlessScrolling.newInstance(2);


                    //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                    mFragments.add(mFragment);//.add(new SectionedListFragment());

                }
                else if(tempp.get(xxc).getContentType().equals("main2")) {
                    //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    List<AbstractFlexibleItem> gx = new ArrayList<>();

                    //OverallItemCustome ghhm = new OverallItemCustome("0", "0", vieww.getViewManager().getLayout(), layoutInflater);
                    List<OverallItemCustome> mmnbb=new ArrayList<>();
                    List<ProteusView> mmnbbk=new ArrayList<>();
                    // gx.add(ghm);
                    for (int cx = 0; cx < main_body.length; cx++) {
                        ProteusView viewwx = ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(main_body[cx], null);
                        Layout vx=  new Layout(viewwx.getViewManager().getLayout().type, viewwx.getViewManager().getLayout().attributes, null, viewwx.getViewManager().getLayout().extras);
                        mmnbbk.add(viewwx);
                        OverallItemCustome ghhk = new OverallItemCustome(cx, "h","0", vx, ((ProteusLinearLayout) view).getViewManager().getContext().getInflater());
                        mmnbb.add(ghhk);
                        gx.add(ghhk);
                    }
                    AbstractFragment  d   = FragmentStaggeredLayout.newInstance(tempp.get(xxc).getContentMainCount(),createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk)); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);

                    // AbstractFragment    mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(),0,null, );

                    mFragments.add(d);
                }else


                if(tempp.get(xxc).getContentType().equals("main")){

                    String main_body[]=tempp.get(xxc).getContentMain().split("#");
                    List<AbstractFlexibleItem> gx = new ArrayList<>();

                    //OverallItemCustome ghhm = new OverallItemCustome("0", "0", vieww.getViewManager().getLayout(), layoutInflater);
                    List<OverallItemCustome> mmnbb=new ArrayList<>();
                    List<ProteusView> mmnbbk=new ArrayList<>();
                    // gx.add(ghm);
                    String no="0";
                    for (int cx = 0; cx < main_body.length; cx++) {

                        String cs=  main_body[cx].substring(main_body[cx].length()-1);

                        if(cs.equals("=")) {
                            no=main_body[cx].substring(0,main_body[cx].length()-1);
                        }else {
                            ProteusView viewwx = ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(main_body[cx], null);
                            Layout vx = new Layout(viewwx.getViewManager().getLayout().type, viewwx.getViewManager().getLayout().attributes, null, viewwx.getViewManager().getLayout().extras);

                            mmnbbk.add(viewwx);
                            OverallItemCustome ghhk = new OverallItemCustome(cx, "h", "0", vx, ((ProteusLinearLayout) view).getViewManager().getContext().getInflater());
                            mmnbb.add(ghhk);
                            gx.add(ghhk);

                        }
                    }

                    if(no.equals("0")) {
                        // ProteusView viewwx = ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(main_body[0], null);
                        // Layout vx = new Layout(viewwx.getViewManager().getLayout().type, viewwx.getViewManager().getLayout().attributes, null, viewwx.getViewManager().getLayout().extras);

                        AbstractFragment mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(), 0, null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));

                        mFragments.add(mFragment);
                    }else{
                        ProteusView viewwx = ((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(no, null);
                        Layout vx = new Layout(viewwx.getViewManager().getLayout().type, viewwx.getViewManager().getLayout().attributes, null, viewwx.getViewManager().getLayout().extras);

                        AbstractFragment mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(), 0, null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk), viewwx.getViewManager().getContext().getInflater(), vx);

                        mFragments.add(mFragment);
                    }

                }else {
                    if(tempp.get(xxc).getLay()==null) {

                        //  Layout df=((ProteusLinearLayout) view).getViewManager().getContext().getLayout()
                        Fragment fg = new fragmentexam(tempp.get(xxc).getContentView(), ((ProteusLinearLayout) view).getViewManager().getContext().getInflater(), null);

                        mFragments.add(fg);
                    }else{
                        Fragment fg = new fragmentexam(tempp.get(xxc).getLay(), ((ProteusLinearLayout) view).getViewManager().getContext().getInflater(), null);

                        mFragments.add(fg);
                    }
                }





            }


            //   String[] mTitles = {"首页", "消息", "联系人", "更多"};
            int[] mIconUnselectIds = {
                    R.drawable.tab_home_unselect, R.drawable.tab_speech_unselect,
                    R.drawable.tab_contact_unselect, R.drawable.tab_more_unselect};
            int[] mIconSelectIds = {
                    R.drawable.tab_home_select, R.drawable.tab_speech_select,
                    R.drawable.tab_contact_select, R.drawable.tab_more_select};

            ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();



            for (int i = 0; i < TilteData.length; i++) {
                mTabEntities.add(new TabEntity(TilteData[i], mIconSelectIds[0], mIconUnselectIds[0],1,selct[i],unselct[i]));
            }
            //  pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
            //pager.setAdapter(new MyPagerAdapter(mfrag,mFragments,TilteData));
            // mTabLayout_3.setTabData(mTabEntities);

            // mTabLayout_3.setTabData(mTabEntities, mfrag, R.id.fl_change, mFragments2);
            mTabLayout_3.setTabData(mTabEntities,((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),pager.getId(),mFragments);



            mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
                @Override
                public void onTabSelect(int position) {
                    //  pager.setCurrentItem(position);
                }

                @Override
                public void onTabReselect(int position) {
                    Random mRandom = new Random();
                    if (position == 0) {
                        mTabLayout_3.showMsg(0, mRandom.nextInt(100) + 1);
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                    }
                }
            });
            // mTabLayout_3.setCurrentTab(selectpostion);
            //mTabLayout_3.s(selectpostion);


                           /* mTabLayout_3.showMsg(0, 55);


                            mTabLayout_3.setMsgMargin(1, -5, 5);

                            //设置未读消息红点

                            MsgView rtv_2_2 = mTabLayout_3.getMsgView(0);
                            if (rtv_2_2 != null) {
                                UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f));
                            }
*/

            view.addView(pager);
            if (mTabLayout_3.getViewManager().getActionEventView() == null) {
                mTabLayout_3.getViewManager().setActionEventView(Act);
                //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

            }
            final String[] ggg = new String[]{"0"};
            final EventProcessor uuip = new EventProcessor() {
                @Override
                public void setOnEventListener(View view, Value value) {

                }
            };


            //    uuip.triggerAdapter(150, true, "3", "3", null, (ProteusView) mTabLayout_3, uuip, ggg);



        }






    }
    public List<AbstractFlexibleItem> createOverallDatabase(Resources resources, List<ProteusView> itt) {

        List<AbstractFlexibleItem> mItems = new ArrayList<>();
        // databaseType = DatabaseType.OVERALL;
        //  mItems.clear();

        for (int cx = 0; cx < itt.size(); cx++) {
            // mItems.add(itt.get(cx));

            mItems.add(new OverallItem(R.id.nav_selection_modes, resources.getString(R.string.selection_modes)).withView(itt.get(cx).getAsView()).withcheck(false)
                    .withDescription(resources.getString(R.string.selection_modes_description))
                    .withIcon(resources.getDrawable(R.drawable.ic_select_all_grey600_24dp)));
        }

        return  mItems;
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> mFragments = new ArrayList<>();
        private  String[] mTitles_3;
        // private  = {"首页", "消息", "联系人", "更多"};
        public MyPagerAdapter(FragmentManager fm,ArrayList<Fragment> d,String[] mTitles_33) {
            super(fm);
            mFragments=d;
            mTitles_3=mTitles_33;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles_3[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
