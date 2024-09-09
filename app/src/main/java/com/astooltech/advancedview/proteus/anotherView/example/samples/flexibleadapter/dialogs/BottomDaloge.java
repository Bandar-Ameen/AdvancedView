package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dialogs;


import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListPopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.LayoutManager;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.StyleManager;
import com.astooltech.advancedview.proteus.Styles;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.demo.MyReceiver;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.demo.api.loadfirstly;
import com.astooltech.advancedview.proteus.demo.api.notfi_refresh_data;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.parser.message_box;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BottomDaloge extends BottomSheetDialogFragment implements  ProteusManager.Listener,getmessage_status, notfi_refresh_data,loadfirstly
         {

public static final String TAG = BottomDaloge.class.getSimpleName();
public static final String ARG_LAYOUT = "layout";
       // private ProteusManager proteusManager;
        private  boolean checknull=false;
        private boolean chh=false;
        private  String[] dataURL;
        private Handler handler;
        private View vew;
        private ProteusLayoutInflater layoutInflater;
            private      BottomSheetDialog  mBottomSheetDialog;
        private  String nameanfil;
                 private  String nameanfild;
                 private ListPopupWindow mPopupItemType;
                 private ListPopupWindow mPopupReference;
                 private AbstractFragment mFragmentt;
                private DrawerLayout mDrawerr;
/*private BottomSheetDialog mBottomSheetDialog;
private ArrayAdapter mAdapterItemType;
private ArrayAdapter mAdapterReference;
private ListPopupWindow mPopupItemType;
private ListPopupWindow mPopupReference;
private int mItemType = 0, mReferencePosition = -1, mChildPosition = 0;
*/
public BottomDaloge(View vew) {
     this.vew=vew;
     this.chh=true;
        }

                 public static BottomDaloge newInstance(AbstractFragment mFragmentt, DrawerLayout mDrawerr,getmessage_status massssv,String nameanfildd) {
                         BottomDaloge bottomSheetFragment = new BottomDaloge(mFragmentt,mDrawerr,massssv,nameanfildd);
                   //  this.mBottomSheetDialog=bottomSheetFragment;
                         //if (fragment != null) bottomSheetFragment.setTargetFragment(fragment, 0);
                         return bottomSheetFragment;
                 }
                 public BottomDaloge(AbstractFragment mFragmentt, DrawerLayout mDrawerr,getmessage_status massssv,String nameanfildd) {
                         dataURL=new String[]{"dfd","Dfdf"};
                         this.mFragmentt=mFragmentt;
                         this.mDrawerr=mDrawerr;
                         this.massss=massssv;
                         this.nameanfild=nameanfildd;
                 }



                 private ObjectValue dataa;
                 private  Layout layoutt;
                 private       String[] dataURLl;
                private message_box messs;
                 private getmessage_status massss;
                private Styles styless;
               private AppCompatActivity Activ;
               //  protected ProteusLayoutInflater.ImageLoader loaderr;
                private Map<String, Layout> layoutss;
               private ViewGroup containerr;
                 protected MyReceiver tre;
                 private StyleManager styleManager = new StyleManager() {

                         @Nullable
                         @Override
                         protected Styles getStyles() {
                                 return styless;
                         }
                 };
                 private LayoutManager layoutManager = new LayoutManager() {

                         @Nullable
                         @Override
                         protected Map<String, Layout> getLayouts() {
                                 return layoutss;
                         }
                 };    ArrayList<String> mydatt=new ArrayList<>();

                 public Map<String,Layout> getlayoutfromString(String dataa) throws JSONException {
                         // Log.i("ee", "ERROR: " +"sdsdddddddddd");
                         ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(getContext());
                         Gson gsonn = new GsonBuilder()
                                 .registerTypeAdapterFactory(adapter)
                                 .create();
                         Type type = new TypeToken<Value>() {

                         }.getType();
                         ObjectValue tempp = gsonn.fromJson(dataa, type);

                         HashMap<String,Layout> iio=new HashMap<>();
                         Iterator<Map.Entry<String, Value>> vv = tempp.entrySet().iterator();
                         while (vv.hasNext()) {
                                 try {
                                         Map.Entry<String, Value> ddertt = vv.next();
                                         iio.put(ddertt.getKey(), ddertt.getValue().getAsLayout());
                                         //  Log.i("ee", "ERROR: " + "sdsdddddddddd" + String.valueOf(ddertt.getValue().isLayout()));
                                 }catch (Exception ex){
                                         Log.i(getClass().getName(), "ERROR: " + ex.getMessage());
                                 }
                         }


                         return iio;
                 }
public static BottomDaloge newInstance(View v) {
        BottomDaloge bottomSheetFragment = new BottomDaloge(v);

        //if (fragment != null) bottomSheetFragment.setTargetFragment(fragment, 0);
        return bottomSheetFragment;
        }


                 private Gson gson;
                 private loadfirstly loadfirst;
public void mmshow(String typActivity){



        String ffg="{#ddd#:{#type#:#LinearLayout#}}";
        ffg=  ffg.replace('#','"');

        mydatt.add("{}");
        mydatt.add(typActivity);
        mydatt.add(ffg);
        mydatt.add("{}");

       /* proteusManager = new ProteusManager(getContext(), getActivity());
        proteusManager.addListener(this);*/
        loadfirst=this;


      /*  ProteusContext context = proteusManager.getProteus().createContextBuilder(getContext())
                .setLayoutManager(layoutManager)//.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
           .Setcontainerr(containerr).SetdataURLl(dataURLl)
                .setFrgmentMangers(getActivity().getSupportFragmentManager())
                .setmDrawerr(mDrawerr)
                .setMassss(massss)
                .setmFragmenttv(mFragmentt)
               // .SetproteusManagerrb(proteusManager).SetActivitys(Activ)
                .setStyleManager(styleManager).build();

        layoutInflater=context.getInflater();
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        loadfirst.loadfist("h");
                        //new AsyncTaskRunner().execute();
                }
        },200);*/
}
private OnParameterSelectedListener getListener() {
        //Setting the listener
        OnParameterSelectedListener listener = (OnParameterSelectedListener) getTargetFragment();
        if (listener == null && getActivity() instanceof OnParameterSelectedListener) {
        listener = (OnParameterSelectedListener) getActivity();
        }
        return listener;
        }


        public void  ggerrt(){



        }
                 public void onloadd(){




                        // dataa = proteusManager.getData();
                         // setmydatt();

                         try {
                                 Map<String, Layout> yt = getlayoutfromString(mydatt.get(1));
                                 int cx = 0;
                                 for (Map.Entry<String, Layout> tu : yt.entrySet()) {

                                         cx = cx + 1;
                                         if (cx == 1) {
                                                 layoutt = tu.getValue();
                                         }
                                         if(tu.getKey().startsWith("Main")){
                                                 layoutt=tu.getValue();
                                         }
                                 }
                                 //  layout =//proteusManager.getRootLayout();
                                 layoutss = yt;// proteusManager.getLayouts();
                         }catch (Exception ex){


                         }
                       //  styless = proteusManager.getStyles();

                         // setmydatt();


                       /*  layoutt =proteusManager.getRootLayout();
                         layoutss = proteusManager.getLayouts();
                         styless = proteusManager.getStyles();*/
                         // skeletonViewGroup.stopShimmer();
                       //  setdata();
                         render();
                         //  setdata();

                 }
                 public void refreshallviews(){
                         //  proteusManager.removeListener(this);
                         onloadd();
                 }
                 public void refreshallviewss(){
                      /*   proteusManager.removeListener(this);
                         proteusManager.addListener(this);*/
                         new Handler().postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                         loadfirst.loadfist("h");
                                         //new AsyncTaskRunner().execute();
                                 }
                         },200);
                         //  onloadd();
                 }
                 void render() {

                         // remove the current view
                         //  container.removeAllViews();

                         // Inflate a new view using proteus
                         long start = System.currentTimeMillis();
                       ProteusView  view = layoutInflater.inflate(layoutt, dataa, containerr, 0);
                       //  System.out.println("inflate time: " + (System.currentTimeMillis() - start));

                         // Add the inflated view to the container
                         containerr.addView(view.getAsView());
                         createPopUps();
                         this.mBottomSheetDialog.show();
                       //  box.hideAll();
                         //  mlayout.hideOverlay();
                         //showalertonly("hh");
                         //  skeletonViewGroup.stopShimmer();

                         // dd.dismiss();
                 }
@NonNull
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog  mBottomSheetDialog = new   BottomSheetDialog(getActivity(), R.style.AppTheme_BottomSheetDialog);

     if(!this.chh){
        containerr = (ViewGroup) mBottomSheetDialog.getWindow().getDecorView();

        mmshow(this.nameanfild);
    }else {
         mBottomSheetDialog.setContentView(vew);
     }
      //  mBottomSheetDialog.setContentView(vew);
       /* mBottomSheetDialog.findViewById(R.id.select_item_type).setOnClickListener(this);
        mBottomSheetDialog.findViewById(R.id.select_item_type).setOnTouchListener(new SimpleOnTouchListener(getContext()));
        mBottomSheetDialog.findViewById(R.id.select_reference_button).setOnClickListener(this);
        mBottomSheetDialog.findViewById(R.id.select_reference_button).setOnTouchListener(new SimpleOnTouchListener(getContext()));
        mBottomSheetDialog.findViewById(R.id.new_item).setOnClickListener(this);
       */

        return mBottomSheetDialog;
        }

private void createPopUps() {
        //Create the Adapter

        //Setting up the popups
        Log.d(TAG, "Setting up the Popups");
        //Item Type
        mPopupItemType = new ListPopupWindow(getContext());
      //  mPopupItemType.setAnchorView(mBottomSheetDialog.findViewById(R.id.select_item_type));
        mPopupItemType.setModal(true);
        mPopupItemType.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        mPopupItemType.setAnimationStyle(android.R.style.Animation_Dialog);
     //   mPopupItemType.setAdapter(mAdapterItemType);
        mPopupItemType.setVerticalOffset(-100);

        //Header Reference
        mPopupReference = new ListPopupWindow(getContext());
      //  mPopupReference.setAnchorView(mBottomSheetDialog.findViewById(R.id.select_reference_button));
        mPopupReference.setModal(true);
        mPopupReference.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        mPopupReference.setAnimationStyle(android.R.style.Animation_Dialog);
       // mPopupReference.setAdapter(mAdapterReference);
        mPopupReference.setVerticalOffset(-100);

        mPopupReference.setHeight(getResources().getDimensionPixelSize(R.dimen.popup_max_height));


}

                 @Override
                 public void onLoad() {
                         refreshallviews();
                 }

             @Override
             public void onbackpress(String a1, String a2) {

             }

             @Override
                 public void onError(@NonNull Object e) {

                 }

                 @Override
                 public void showmessage(String message, int typ, String keyname) {

                 }

                 @Override
                 public void change_data(String nameAdapter, int typ, ObjectValue dataupdate) {

                 }

                 @Override
                 public void loadfist(Object ob) {

    //proteusManager.load(mydatt);
                 }
         }

