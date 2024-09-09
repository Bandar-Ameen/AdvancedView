
package com.astooltech.advancedview.proteus.parser.custom;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.example.samples.HiderWithbody;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.ScrollHederItems;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.bodyHedaer;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentEndlessScrolling;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentInstagramHeaders;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentOverall;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentStaggeredLayout;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.customefragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItemCustome;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.SlidingTabLayout;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.CustomTabEntity;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.OnTabSelectListener;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.entity.TabEntity;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.TabModel;
import com.astooltech.advancedview.proteus.parser.adapterskit.SectionedListFragment;
import com.astooltech.advancedview.proteus.parser.adapterskit.mfrg;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.AgentWebFragment;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;

import com.astooltech.advancedview.proteus.tableview.tableviewsample.MainFragment;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v4.view.ProteusViewPager;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Binding;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.ProtouseCommonTabLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSegementLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSlidingTabLayout;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by kiran.kumar on 12/05/14.
 */
public class finalTableLayoutParser<T extends LinearLayout> extends ViewTypeParser<T> {


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
        return "TabLayoutView";
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
        return new ProteusLinearLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor(Attributes.LinearLayout.Orientation, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }
            }
        });

        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });
        addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if(value.equals("1")) {

                    view.bringToFront();
                    view.invalidate();
                }

            }
        });

        addAttributeProcessor(Attributes.View.tabcontenta, new AttributeProcessor<T>() {

            private void cxc(ViewGroup dfdf,View v,View header,String TitleViewID,String Continer){
                for (int xxc = 0; xxc < dfdf.getChildCount(); xxc++) {

                    //  Log.e("ttrrr", "ggggggggggg");
                    if(dfdf.getChildAt(xxc) instanceof  ViewGroup){
                        ViewGroup j=(ViewGroup) dfdf.getChildAt(xxc);
                        boolean check=false;
                        try{
                            if(j.getTag(R.id.tag3)!=null) {
                                if (j.getTag(R.id.tag3).toString().equals(TitleViewID)) {
                                    check = true;

                                    j.addView(header);

                                }else     if (j.getTag(R.id.tag3).toString().equals(Continer)) {
                                    check = true;

                                    j.addView(v);

                                }
                            }
                        }catch (Exception ex){

                        }

                        cxc(j, v,header,TitleViewID,Continer);

                    }

                }

            }
            @Override
            public void handleBinding(T view, Binding value) {

                //  handleDataBoundChildren(view, value);
            }

            @Override
            public void handleValue(final T view, final Value value) {
                String type=value.getAsObject().get("Content_Type").toString();
                final Layout fragm=value.getAsObject().get("Content_Fragment").getAsLayout();
                String viewhefer=value.getAsObject().get("Header_ID").toString();
                String BodyID=value.getAsObject().get("Body_ID").toString();
                Layout mpager=value.getAsObject().get("Content_Pager").getAsLayout();
                ObjectValue objvall=null;
                try{
                    objvall=value.getAsObject().get("Content_Setting").getAsObject();
                }catch (Exception ex){

                }

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

                    ProtouseSegementLayout mTabLayout_3=(ProtouseSegementLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();
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
                    // view.addView(mTabLayout_3);
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
                            AgentWebFragment ttv= AgentWebFragment.getInstance(y);
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

                        else  if(tempp.get(xxc).getContentType().equals("llh")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            MainFragment ttvv=new MainFragment();

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
                        else if(tempp.get(xxc).getContentType().equals("main3")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            Array cxm= tempp.get(xxc).getAnotherval().getAsArray();
                            int rowcolumn=2;
                            //List<HiderWithbody>
                            List<HiderWithbody> ui=new ArrayList<>();
                            ScrollHederItems ki=new ScrollHederItems();
                            for (int ii = 0; ii < cxm.size(); ii++) {
                                if(ii==0) {
                                    ObjectValue obj = cxm.get(ii).getAsObject().getAsObject("Scroll_Header");
                                    String getval1=obj.getAsObject().getAsString("TitleA");
                                    String getval1d=obj.getAsObject().getAsString("TitleB");
                                    rowcolumn=obj.getAsObject().getAsInteger("Rowc");
                                    ki.setScrolitemtit(getval1);
                                    ki.setSrolitem(getval1d);
                                }
                                String x=  cxm.get(ii).getAsObject().getAsString("group_Title");
                                HiderWithbody b=new HiderWithbody();
                                b.setHiderGroup(ii);
                                b.setOrder(ii);
                                b.setHedrgropName(x);
                                b.setScrollHeder(ki);
                                Array cxmk= cxm.get(ii).getAsObject().getAsArray("body_group");
                                List<bodyHedaer> der=new ArrayList<>();
                                for (int iix = 0; iix < cxmk.size(); iix++) {
                                    bodyHedaer rm=new bodyHedaer();
                                    String getval1= cxmk.get(iix).getAsObject().getAsString("TitleA");
                                    String getval1d=cxmk.get(iix).getAsObject().getAsString("TitleB");
                                    rm.setAnother(getval1);
                                    rm.setBodytitle(getval1d);
                                    der.add(rm);
                                }
                                b.setBodydata(der);
                                ui.add(b);
                            }

                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(rowcolumn,ui,0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

                        }
                        else if(tempp.get(xxc).getContentType().equals("main4")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            ObjectValue cxm= tempp.get(xxc).getAnotherval().getAsObject();//.getAsArray();
                            int rowcolumn=2;
                            rowcolumn=cxm.getAsObject().getAsInteger("Rowc");
                            Value getrowdata=cxm.getAsObject().getAsObject("row_data");
                            //List<HiderWithbody>


                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(rowcolumn,getrowdata,((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

                        }
                        else  if(tempp.get(xxc).getContentType().equals("bb")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            //  Sectione DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());
                            //                                   dListFragment ttvv=new SectionedListFragment();
                            DatabaseService.getInstance().createEndlessDatabase(10);//(ProteusLinearLayout) view).getAsView().getContext());

                            FragmentEndlessScrolling mFragment = FragmentEndlessScrolling.newInstance(2);


                            //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                            mFragments.add(mFragment);//.add(new SectionedListFragment());

                            mFragment.setfill();
                        }

                        else  if(tempp.get(xxc).getContentType().equals("main2")) {

                            DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(2); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
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
                            AbstractFragment mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(),0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                            mFragments.add(mFragment);
                                  /* DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                                   AbstractFragment                  mFragment = FragmentOverall.newInstance(2,0,null, DatabaseService.getInstance().getDatabaseList()); // mFragment = FragmentOverall.newInstance(2,0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                                   mFragments.add(mFragment);*/

                        }else {
//ProteusView vv=((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(,,null,0);
                            AbstractFragment fg= customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                            mFragments.add(fg);
                        }





                    }
                    int ID=0;
                    Layout mpagerv=value.getAsObject().get("mchild").getAsLayout();
                    View pagerx=((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpagerv,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
                    cxc((ViewGroup)pagerx,pager,mTabLayout_3,viewhefer,BodyID);
                    view.addView(pagerx);
                    mTabLayout_3.setTabData(TilteData,((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),pager.getId(),mFragments);
                    DataValueSelect g=new DataValueSelect();
                    g.setChecknull(false);
                    g.setIdexid(0);
                    g.setTypselect("0");
                    g.setUnitName("g");
                    g.setCustomevalue(objvall);
                    mTabLayout_3.getViewManager().getContext().getParser(mTabLayout_3.getViewManager().getLayout().type).GetAndSetData(mTabLayout_3,g,105,null,"0");

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

                    /*Layout mpagerv=value.getAsObject().get("mchild").getAsLayout();
                    View pagerx=((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpagerv, new ObjectValue()).getAsView();
                    cxc((ViewGroup)pagerx,pager);
                    view.addView(pagerx);*/
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

                            AbstractFragment d   = FragmentInstagramHeaders.newInstance();
                            mFragments.add(d);
                        }
                        else  if(tempp.get(xxc).getContentType().equals("webb")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            y.putString("data",main_body[0]);
                            AgentWebFragment ttv= AgentWebFragment.getInstance(y);
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

                        else  if(tempp.get(xxc).getContentType().equals("llh")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            MainFragment ttvv=new MainFragment();

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

                            FragmentEndlessScrolling mFragment = FragmentEndlessScrolling.newInstance(2);


                            //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                            mFragments.add(mFragment);//.add(new SectionedListFragment());

                            mFragment.setfill();
                        }
                        else if(tempp.get(xxc).getContentType().equals("main3")) {
                            Array cxm= tempp.get(xxc).getAnotherval().getAsArray();
                            int rowcolumn=2;
                            //List<HiderWithbody>
                            List<HiderWithbody> ui=new ArrayList<>();
                            ScrollHederItems ki=new ScrollHederItems();
                            for (int ii = 0; ii < cxm.size(); ii++) {
                                if(ii==0) {
                                    ObjectValue obj = cxm.get(ii).getAsObject().getAsObject("Scroll_Header");
                                    String getval1=obj.getAsObject().getAsString("TitleA");
                                    String getval1d=obj.getAsObject().getAsString("TitleB");
                                    rowcolumn=obj.getAsObject().getAsInteger("Rowc");
                                    ki.setScrolitemtit(getval1);
                                    ki.setSrolitem(getval1d);
                                }
                                String x=  cxm.get(ii).getAsObject().getAsString("group_Title");
                                HiderWithbody b=new HiderWithbody();
                                b.setHiderGroup(ii);
                                b.setOrder(ii);
                                b.setHedrgropName(x);
                                b.setScrollHeder(ki);
                                Array cxmk= cxm.get(ii).getAsObject().getAsArray("body_group");
                                List<bodyHedaer> der=new ArrayList<>();
                                for (int iix = 0; iix < cxmk.size(); iix++) {
                                    bodyHedaer rm=new bodyHedaer();
                                    String getval1= cxmk.get(iix).getAsObject().getAsString("TitleA");
                                    String getval1d=cxmk.get(iix).getAsObject().getAsString("TitleB");
                                    rm.setAnother(getval1);
                                    rm.setBodytitle(getval1d);
                                    der.add(rm);
                                }
                                b.setBodydata(der);
                                ui.add(b);
                            }

                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(rowcolumn,ui,0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);


                        }
                        else if(tempp.get(xxc).getContentType().equals("main4")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            ObjectValue cxm= tempp.get(xxc).getAnotherval().getAsObject();//.getAsArray();
                            int rowcolumn=2;
                            rowcolumn=cxm.getAsObject().getAsInteger("Rowc");
                            Value getrowdata=cxm.getAsObject().getAsObject("row_data");
                            //List<HiderWithbody>


                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(rowcolumn,getrowdata,((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

                        }
                        else  if(tempp.get(xxc).getContentType().equals("main2")) {

                            DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(2); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
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
                            AbstractFragment mFragment = FragmentOverall.newInstance(tempp.get(xxc).getContentMainCount(),0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                            mFragments.add(mFragment);
                                  /* DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                                   AbstractFragment                  mFragment = FragmentOverall.newInstance(2,0,null, DatabaseService.getInstance().getDatabaseList()); // mFragment = FragmentOverall.newInstance(2,0,null, createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk));
                                   mFragments.add(mFragment);*/

                        }else {
                            AbstractFragment fg= customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                            mFragments.add(fg);


                            /*Fragment fg=new fragmentexam(tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),null);

                            mFragments.add(fg);*/
                        }





                    }
                    ProteusViewPager eer=(ProteusViewPager) pager;
                    MyPagerAdapter    mAdapter = new MyPagerAdapter(((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),mFragments,TilteData);
                    eer.setAdapter(mAdapter);

                    final ProteusViewPager eerr=eer;
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

                    DataValueSelect g=new DataValueSelect();
                    g.setChecknull(false);
                    g.setIdexid(0);
                    g.setTypselect("0");
                    g.setUnitName("g");
                    g.setCustomevalue(objvall);
                    mTabLayout_3.getViewManager().getContext().getParser(mTabLayout_3.getViewManager().getLayout().type).GetAndSetData(mTabLayout_3,g,105,null,"0");

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
                    // view.addView(mTabLayout_3);

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
                            AbstractFragment d   = FragmentInstagramHeaders.newInstance();
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

                        else  if(tempp.get(xxc).getContentType().equals("llh")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            MainFragment ttvv=new MainFragment();

                            //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                            mFragments.add(ttvv);//.add(new SectionedListFragment());

                        }
                        else if(tempp.get(xxc).getContentType().equals("main3")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            Array cxm= tempp.get(xxc).getAnotherval().getAsArray();
                            int rowcolumn=2;
                            //List<HiderWithbody>
                            List<HiderWithbody> ui=new ArrayList<>();
                            ScrollHederItems ki=new ScrollHederItems();
                            for (int ii = 0; ii < cxm.size(); ii++) {
                                if(ii==0) {
                                    ObjectValue obj = cxm.get(ii).getAsObject().getAsObject("Scroll_Header");
                                    String getval1=obj.getAsObject().getAsString("TitleA");
                                    String getval1d=obj.getAsObject().getAsString("TitleB");
                                    rowcolumn=obj.getAsObject().getAsInteger("Rowc");
                                    ki.setScrolitemtit(getval1);
                                    ki.setSrolitem(getval1d);
                                }
                                String x=  cxm.get(ii).getAsObject().getAsString("group_Title");
                                HiderWithbody b=new HiderWithbody();
                                b.setHiderGroup(ii);
                                b.setOrder(ii);
                                b.setHedrgropName(x);
                                b.setScrollHeder(ki);
                                Array cxmk= cxm.get(ii).getAsObject().getAsArray("body_group");
                                List<bodyHedaer> der=new ArrayList<>();
                                for (int iix = 0; iix < cxmk.size(); iix++) {
                                    bodyHedaer rm=new bodyHedaer();
                                    String getval1= cxmk.get(iix).getAsObject().getAsString("TitleA");
                                    String getval1d=cxmk.get(iix).getAsObject().getAsString("TitleB");
                                    rm.setAnother(getval1);
                                    rm.setBodytitle(getval1d);
                                    der.add(rm);
                                }
                                b.setBodydata(der);
                                ui.add(b);
                            }

                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(rowcolumn,ui,0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

                        }
                        else if(tempp.get(xxc).getContentType().equals("main4")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            ObjectValue cxm= tempp.get(xxc).getAnotherval().getAsObject();//.getAsArray();
                            int rowcolumn=2;
                            rowcolumn=cxm.getAsObject().getAsInteger("Rowc");
                            Value getrowdata=cxm.getAsObject().getAsObject("row_data");
                            //List<HiderWithbody>


                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(rowcolumn,getrowdata,((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

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
                            AbstractFragment ttvv= FragmentEndlessScrolling.newInstance(1,((ProteusLinearLayout) view),main_body[0]);

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

                            AbstractFragment mFragment = FragmentEndlessScrolling.newInstance(2);


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
                            AbstractFragment d   = FragmentStaggeredLayout.newInstance(tempp.get(xxc).getContentMainCount(),createOverallDatabase(((ProteusLinearLayout) view).getAsView().getResources(), mmnbbk)); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);

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
                               /* Fragment fg = new fragmentexam(tempp.get(xxc).getContentView(), ((ProteusLinearLayout) view).getViewManager().getContext().getInflater(), null);

                                mFragments.add(fg);*/

                                AbstractFragment fg= customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                                mFragments.add(fg);
                            }else{

                                AbstractFragment fg= customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                                mFragments.add(fg);
                               /* Fragment fg = new fragmentexam(tempp.get(xxc).getLay(), ((ProteusLinearLayout) view).getViewManager().getContext().getInflater(), null);

                                mFragments.add(fg);*/
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

                    Layout mpagerv=value.getAsObject().get("mchild").getAsLayout();
                    View pagerx=((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(mpagerv,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
                    cxc((ViewGroup)pagerx,pager,mTabLayout_3,viewhefer,BodyID);
                    view.addView(pagerx);
                    //mTabLayout_3.setTabData(TilteData,((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),pager.getId(),mFragments);
                    mTabLayout_3.setTabData(mTabEntities,((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),pager.getId(),mFragments);
                    mTabLayout_3.showMsg(0, 52);
                    mTabLayout_3.showDot(1);
                    DataValueSelect g=new DataValueSelect();
                    g.setChecknull(false);
                    g.setIdexid(0);
                    g.setTypselect("0");
                    g.setUnitName("g");
                    g.setCustomevalue(objvall);
                    mTabLayout_3.getViewManager().getContext().getParser(mTabLayout_3.getViewManager().getLayout().type).GetAndSetData(mTabLayout_3,g,105,null,"0");


                    mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
                        @Override
                        public void onTabSelect(int position) {
                            //  pager.setCurrentItem(position);
                        }

                        @Override
                        public void onTabReselect(int position) {
                            /*Random mRandom = new Random();
                            if (position == 0) {
                                mTabLayout_3.showMsg(0, mRandom.nextInt(100) + 1);
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                            }*/
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


                    //  view.addView(pager);
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

        addAttributeProcessor(Attributes.View.tabcontent, new AttributeProcessor<T>() {
            @Override
            public void handleBinding(T view, Binding value) {

              //  handleDataBoundChildren(view, value);
            }

            @Override
            public void handleValue(final T view, final Value value) {
                String type=value.getAsObject().get("Content_Type").toString();
                final Layout fragm=value.getAsObject().get("Content_Fragment").getAsLayout();
                Layout mpager=value.getAsObject().get("Content_Pager").getAsLayout();
ObjectValue objvall=null;
try{
    objvall=value.getAsObject().get("Content_Setting").getAsObject();
}catch (Exception ex){

}

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

                   ProtouseSegementLayout mTabLayout_3=(ProtouseSegementLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();
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

                        else  if(tempp.get(xxc).getContentType().equals("llh")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            MainFragment ttvv=new MainFragment();

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
                        else if(tempp.get(xxc).getContentType().equals("main3")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            Array cxm= tempp.get(xxc).getAnotherval().getAsArray();
                            int rowcolumn=2;
                            //List<HiderWithbody>
                            List<   HiderWithbody> ui=new ArrayList<>();
                            ScrollHederItems ki=new ScrollHederItems();
                            for (int ii = 0; ii < cxm.size(); ii++) {
                                if(ii==0) {
                                    ObjectValue obj = cxm.get(ii).getAsObject().getAsObject("Scroll_Header");
                                    String getval1=obj.getAsObject().getAsString("TitleA");
                                    String getval1d=obj.getAsObject().getAsString("TitleB");
                                    rowcolumn=obj.getAsObject().getAsInteger("Rowc");
                                    ki.setScrolitemtit(getval1);
                                    ki.setSrolitem(getval1d);
                                }
                                String x=  cxm.get(ii).getAsObject().getAsString("group_Title");
                                HiderWithbody b=new HiderWithbody();
                                b.setHiderGroup(ii);
                                b.setOrder(ii);
                                b.setHedrgropName(x);
                                b.setScrollHeder(ki);
                                Array cxmk= cxm.get(ii).getAsObject().getAsArray("body_group");
                                List<bodyHedaer> der=new ArrayList<>();
                                for (int iix = 0; iix < cxmk.size(); iix++) {
                                    bodyHedaer rm=new bodyHedaer();
                                    String getval1= cxmk.get(iix).getAsObject().getAsString("TitleA");
                                    String getval1d=cxmk.get(iix).getAsObject().getAsString("TitleB");
                                    rm.setAnother(getval1);
                                    rm.setBodytitle(getval1d);
                                    der.add(rm);
                                }
                                b.setBodydata(der);
                                ui.add(b);
                            }

                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment  d   = FragmentStaggeredLayout.newInstance(rowcolumn,ui,0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

                        }
                        else if(tempp.get(xxc).getContentType().equals("main4")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                         ObjectValue cxm= tempp.get(xxc).getAnotherval().getAsObject();//.getAsArray();
                            int rowcolumn=2;
                            rowcolumn=cxm.getAsObject().getAsInteger("Rowc");
                            Value getrowdata=cxm.getAsObject().getAsObject("row_data");
                            //List<HiderWithbody>


                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment  d   = FragmentStaggeredLayout.newInstance(rowcolumn,getrowdata,((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

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
//ProteusView vv=((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(,,null,0);
                            AbstractFragment fg=customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                            mFragments.add(fg);
                        }





                    }

                    mTabLayout_3.setTabData(TilteData,((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),pager.getId(),mFragments);
                    DataValueSelect g=new DataValueSelect();
                    g.setChecknull(false);
                    g.setIdexid(0);
                    g.setTypselect("0");
                    g.setUnitName("g");
                    g.setCustomevalue(objvall);
                    mTabLayout_3.getViewManager().getContext().getParser(mTabLayout_3.getViewManager().getLayout().type).GetAndSetData(mTabLayout_3,g,105,null,"0");

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

                        else  if(tempp.get(xxc).getContentType().equals("llh")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            MainFragment ttvv=new MainFragment();

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
                        else if(tempp.get(xxc).getContentType().equals("main3")) {
                            Array cxm= tempp.get(xxc).getAnotherval().getAsArray();
                            int rowcolumn=2;
                            //List<HiderWithbody>
                            List<   HiderWithbody> ui=new ArrayList<>();
                            ScrollHederItems ki=new ScrollHederItems();
                            for (int ii = 0; ii < cxm.size(); ii++) {
                                if(ii==0) {
                                    ObjectValue obj = cxm.get(ii).getAsObject().getAsObject("Scroll_Header");
                                    String getval1=obj.getAsObject().getAsString("TitleA");
                                    String getval1d=obj.getAsObject().getAsString("TitleB");
                                    rowcolumn=obj.getAsObject().getAsInteger("Rowc");
                                    ki.setScrolitemtit(getval1);
                                    ki.setSrolitem(getval1d);
                                }
                                String x=  cxm.get(ii).getAsObject().getAsString("group_Title");
                                HiderWithbody b=new HiderWithbody();
                                b.setHiderGroup(ii);
                                b.setOrder(ii);
                                b.setHedrgropName(x);
                                b.setScrollHeder(ki);
                                Array cxmk= cxm.get(ii).getAsObject().getAsArray("body_group");
                                List<bodyHedaer> der=new ArrayList<>();
                                for (int iix = 0; iix < cxmk.size(); iix++) {
                                    bodyHedaer rm=new bodyHedaer();
                                    String getval1= cxmk.get(iix).getAsObject().getAsString("TitleA");
                                    String getval1d=cxmk.get(iix).getAsObject().getAsString("TitleB");
                                    rm.setAnother(getval1);
                                    rm.setBodytitle(getval1d);
                                    der.add(rm);
                                }
                                b.setBodydata(der);
                                ui.add(b);
                            }

                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment  d   = FragmentStaggeredLayout.newInstance(rowcolumn,ui,0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);


                        }
                        else if(tempp.get(xxc).getContentType().equals("main4")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            ObjectValue cxm= tempp.get(xxc).getAnotherval().getAsObject();//.getAsArray();
                            int rowcolumn=2;
                            rowcolumn=cxm.getAsObject().getAsInteger("Rowc");
                            Value getrowdata=cxm.getAsObject().getAsObject("row_data");
                            //List<HiderWithbody>


                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment  d   = FragmentStaggeredLayout.newInstance(rowcolumn,getrowdata,((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

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
                            AbstractFragment fg=customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                            mFragments.add(fg);


                            /*Fragment fg=new fragmentexam(tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),null);

                            mFragments.add(fg);*/
                        }





                    }
                    ProteusViewPager eer=(ProteusViewPager) pager;
                    MyPagerAdapter    mAdapter = new MyPagerAdapter(((ProteusLinearLayout) view).getViewManager().getContext().getFrgmentMangers(),mFragments,TilteData);
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

                    DataValueSelect g=new DataValueSelect();
                    g.setChecknull(false);
                    g.setIdexid(0);
                    g.setTypselect("0");
                    g.setUnitName("g");
                    g.setCustomevalue(objvall);
                    mTabLayout_3.getViewManager().getContext().getParser(mTabLayout_3.getViewManager().getLayout().type).GetAndSetData(mTabLayout_3,g,105,null,"0");

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

                        else  if(tempp.get(xxc).getContentType().equals("llh")) {
                            //DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            Bundle y=new Bundle();
                                    /*tring main_body[]=tempp.get(xxc).getContentMain().split("#");
                                    y.putString("data",main_body[0]);*/
                            String main_body[]=tempp.get(xxc).getContentMain().split("#");
                            MainFragment ttvv=new MainFragment();

                            //  AbstractFragment  dd   = FragmentInstagramHeaders.newInstance();
                            mFragments.add(ttvv);//.add(new SectionedListFragment());

                        }
                        else if(tempp.get(xxc).getContentType().equals("main3")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            Array cxm= tempp.get(xxc).getAnotherval().getAsArray();
                            int rowcolumn=2;
                            //List<HiderWithbody>
                            List<   HiderWithbody> ui=new ArrayList<>();
                            ScrollHederItems ki=new ScrollHederItems();
                            for (int ii = 0; ii < cxm.size(); ii++) {
                                if(ii==0) {
                                    ObjectValue obj = cxm.get(ii).getAsObject().getAsObject("Scroll_Header");
                                    String getval1=obj.getAsObject().getAsString("TitleA");
                                    String getval1d=obj.getAsObject().getAsString("TitleB");
                                    rowcolumn=obj.getAsObject().getAsInteger("Rowc");
                                    ki.setScrolitemtit(getval1);
                                    ki.setSrolitem(getval1d);
                                }
                                String x=  cxm.get(ii).getAsObject().getAsString("group_Title");
                                HiderWithbody b=new HiderWithbody();
                                b.setHiderGroup(ii);
                                b.setOrder(ii);
                                b.setHedrgropName(x);
                                b.setScrollHeder(ki);
                                Array cxmk= cxm.get(ii).getAsObject().getAsArray("body_group");
                                List<bodyHedaer> der=new ArrayList<>();
                                for (int iix = 0; iix < cxmk.size(); iix++) {
                                    bodyHedaer rm=new bodyHedaer();
                                    String getval1= cxmk.get(iix).getAsObject().getAsString("TitleA");
                                    String getval1d=cxmk.get(iix).getAsObject().getAsString("TitleB");
                                    rm.setAnother(getval1);
                                    rm.setBodytitle(getval1d);
                                    der.add(rm);
                                }
                                b.setBodydata(der);
                                ui.add(b);
                            }

                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment  d   = FragmentStaggeredLayout.newInstance(rowcolumn,ui,0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

                        }
                        else if(tempp.get(xxc).getContentType().equals("main4")) {
                            //  DatabaseService.getInstance().createOverallDatabase(((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());

                            ObjectValue cxm= tempp.get(xxc).getAnotherval().getAsObject();//.getAsArray();
                            int rowcolumn=2;
                            rowcolumn=cxm.getAsObject().getAsInteger("Rowc");
                            Value getrowdata=cxm.getAsObject().getAsObject("row_data");
                            //List<HiderWithbody>


                            //  DatabaseService.getInstance().createStaggeredDatabase(((ProteusLinearLayout) view).getAsView().getContext());

                            // FragmentStaggeredLayout.newInstance()
                            // DatabaseService.getInstance().createStaggeredDatabase((ProteusLinearLayout) view).getAsView().getContext().getApplicationContext().getResources());
                            AbstractFragment  d   = FragmentStaggeredLayout.newInstance(rowcolumn,getrowdata,((ProteusLinearLayout) view).getViewManager().getContext().getInflater(),0); //FragmentExpandableMultiLevel.newInstance(2); //FragmentAsyncFilter.newInstance(true);
                            mFragments.add(d);

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
                               /* Fragment fg = new fragmentexam(tempp.get(xxc).getContentView(), ((ProteusLinearLayout) view).getViewManager().getContext().getInflater(), null);

                                mFragments.add(fg);*/

                                AbstractFragment fg=customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                                mFragments.add(fg);
                            }else{

                                AbstractFragment fg=customefragment.newInstance(true,((ProteusLinearLayout) view).getViewManager(),tempp.get(xxc).getContentView(),((ProteusLinearLayout) view).getViewManager().getContext().getData());

                                mFragments.add(fg);
                               /* Fragment fg = new fragmentexam(tempp.get(xxc).getLay(), ((ProteusLinearLayout) view).getViewManager().getContext().getInflater(), null);

                                mFragments.add(fg);*/
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
                    mTabLayout_3.showMsg(0, 52);
                    mTabLayout_3.showDot(1);
                    DataValueSelect g=new DataValueSelect();
                    g.setChecknull(false);
                    g.setIdexid(0);
                    g.setTypselect("0");
                    g.setUnitName("g");
                    g.setCustomevalue(objvall);
                    mTabLayout_3.getViewManager().getContext().getParser(mTabLayout_3.getViewManager().getLayout().type).GetAndSetData(mTabLayout_3,g,105,null,"0");


                    mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
                        @Override
                        public void onTabSelect(int position) {
                            //  pager.setCurrentItem(position);
                        }

                        @Override
                        public void onTabReselect(int position) {
                            /*Random mRandom = new Random();
                            if (position == 0) {
                                mTabLayout_3.showMsg(0, mRandom.nextInt(100) + 1);
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                            }*/
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


        addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerDrawable(drawable);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerPadding((int) dimension);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.ShowDividers, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    int dividerMode = ParseHelper.parseDividerMode(value);
                    // noinspection ResourceType
                    view.setShowDividers(dividerMode);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {
                view.setWeightSum(ParseHelper.parseFloat(value));
            }
        });
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
