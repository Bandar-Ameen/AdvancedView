package com.astooltech.advancedview.proteus;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.astooltech.advancedview.finaldemo.fragments.BottomShitDcustomefragment;
import com.astooltech.advancedview.finaldemo.fragments.customshit;
import com.astooltech.advancedview.inlineactivityresult.InlineActivityResult;
import com.astooltech.advancedview.inlineactivityresult.callbacks.ActivityResultListener;
import com.astooltech.advancedview.inlineactivityresult.request.RequestFabric;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.BottomShitDaloge;
import com.astooltech.advancedview.proteus.chatview.data.Message;
import com.astooltech.advancedview.proteus.chatview.widget.prtouseChatviews;
import com.astooltech.advancedview.proteus.parser.CustomStringRequest;
import com.astooltech.advancedview.proteus.parser.Utility;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadListenerAdapter;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadNotifier;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadSubmitterImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadTask;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Downloader;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Extra;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.v7.widget.datafiltermo;
import com.astooltech.advancedview.proteus.value.Binding;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.flexAdapterrrr;
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
import com.astooltech.advancedview.proteus.demo.ProtouseNewActivity;
import com.astooltech.advancedview.proteus.demo.api.DalogeFragment;
import com.astooltech.advancedview.proteus.demo.api.fragmentexam;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.TabModel;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.parser.adapterskit.SectionedListFragment;
import com.astooltech.advancedview.proteus.parser.adapterskit.ShitDailogeFragments;
import com.astooltech.advancedview.proteus.parser.adapterskit.mfrg;
import com.astooltech.advancedview.proteus.parser.cookiebar.CookieBar;
import com.astooltech.advancedview.proteus.parser.cookiebar.CookieBarDismissListener;
import com.astooltech.advancedview.proteus.parser.cookiebar.OnActionClickListener;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.AgentWebFragment;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.CustomeWeb;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.Action;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentActionFragment;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWebPermissions;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWebUtils;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.Result;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.RxActivityResult;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v4.view.ProteusViewPager;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.v7.widget.AutoCompleteTextViewB;
import com.astooltech.advancedview.proteus.v7.widget.SpainnerViewB;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusButton;
import com.astooltech.advancedview.proteus.view.ProteusImageView;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusProgressBar;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusTextView;
import com.astooltech.advancedview.proteus.view.ProteusWebView;
import com.astooltech.advancedview.proteus.view.PrototoseSwiperView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.ProtouseCommonTabLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSegementLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSlidingTabLayout;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.ProtouseSwitchButton;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.ReadMoreTextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;

import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;
import static com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentActionFragment.start;
import static com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl.TAG;
import static com.astooltech.advancedview.proteus.value.Binding.BINDING_PATTERN;
import static com.astooltech.advancedview.proteus.value.Binding.BINDING_PATTERNN;
import static com.astooltech.advancedview.proteus.value.Binding.FUNCTION_ARGS_DELIMITER;

public abstract class ALLEvent {

    public static final ALLEvent OpenActivityhidlibbx = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                String eew =  data.getAsObject().get("Name").getAsString();
                String eeww =  data.getAsObject().get("Namee").getAsString();
                v.getViewManager().getContext().getParser("LinearLayoutAna").GetAndSetData(v,null,Integer.parseInt(eeww),null,eew);

            }catch (Exception ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "hid";
        }
    };


    public static final ALLEvent OpenActivityyx = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                String eew =  data.getAsObject().get("Name").getAsString();
                String ValueActivi="0";
                try {
                    ValueActivi = data.getAsObject().get("Value_Activity").getAsString();

                }catch (Exception ex){

                }
                // Log.e("777", eew);
                Class<?> tclas = Class.forName(eew);
                Intent intent = new Intent(context, tclas);
                intent.putExtra("data", ValueActivi);

                //  intent.putExtra("data", dv);
                ActivityOptions op=ActivityOptions.makeCustomAnimation(context, com.astooltech.advancedview.R.anim.fade_in, com.astooltech.advancedview.R.anim.fade_out);
                // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                //views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                context.startActivity(intent,op.toBundle());
            }catch (ClassNotFoundException ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Activity2";
        }
    };
    public static final ALLEvent OpenActivityhidlibc = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                String eew =  data.getAsObject().get("Name").getAsString();
                // String eeww =  data.getAsObject().get("Namee").getAsString();
                int IDcona1=v.getViewManager().findViewById(eew).getId();//v.getAsView().getContext().getResources().getIdentifier(eew,"id",v.getAsView().getContext().getPackageName());
                android.util.Log.e("yyyyy","bbbv"+IDcona1);
              /*  AbstractFragment fg= com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.customefragment.newInstance(true,v.getViewManager(),eew,v.getViewManager().getContext().getData());
              //  v.getViewManager().getContext().getParser("LinearLayoutAna").GetAndSetData(v,null,Integer.parseInt(eeww),null,eew);
                FragmentManager fragmentManager =act. getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.recycler_view_container, fg).commit();
          */

            }catch (Exception ex){
                android.util.Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Fragment_from";
        }
    };

    public static Fragment getFragmentFromClassName(String fragmentClassName,String methodname,Bundle bu) {
        try {
            // Use Class.forName to load the class dynamically
            Class<?> clazz = Class.forName(fragmentClassName);

            // Ensure the class is a subclass of Fragment
            if (Fragment.class.isAssignableFrom(clazz)) {
                // Create a new instance of the fragment
                try {

if(methodname.equals("0")) {
    return (Fragment) clazz.getDeclaredConstructor().newInstance();

}else{
    Method getInstanceMethod = clazz.getDeclaredMethod(methodname, Bundle.class);

    // Invoke the getInstance method and pass the bundle as a parameter
    return (Fragment) getInstanceMethod.invoke(null, bu);
}


                }catch(Exception ex){

                }
            } else {
               Log.e("openfragm","The class is not a Fragment subclass.");
            }
        } catch (ClassNotFoundException e) {

            Log.e("openfragm",e.getMessage()+"The class is not a Fragment subclass.");
            // Handle the exception if the class is not found
        }
        return null; // Return null if the fragment couldn't be loaded
    }
    public static final ALLEvent Allevtshittx = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            String eew=data.getAsObject().get("Name").getAsString();

            //  Value val=data.getAsObject().get("dff");
            StatuseLayout fd=new StatuseLayout() {
                @Override
                public void loadfinshed() {

                }

                @Override
                public void onerror(String s, Object o) {

                }

                @Override
                public void OnRetray() {

                }
            };
            //  v.getViewManager().getContext().getl
            customshit re=customshit.newInstance(false,v.getViewManager().getContext().getmDrawerr(),fd,v.getViewManager().getContext().getmFragmenttv(),v.getViewManager(),eew);//.show(getFragmentManager(),"kjhhg");
            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);

            // v.getViewManager().getContext().getResources().get

         /*   ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),new ObjectValue()):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());
         /*   AbstractFragment mFragment=null;
            if (mFragment == null) {
                mFragment = com.astooltech.advancedview.finaldemo.FragmentOverall.newInstance(2);
            }
            FragmentManager fragmentManager = v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.recycler_view_container
                    ).commit();*/
            // mFragment.

            //ProteusLinearLayout dderr=(ProteusLinearLayout)dff;
           /* SpringBackBottomSheetDialog fff=new SpringBackBottomSheetDialog(v.getViewManager().getContext());

            fff.setContentView(dff.getAsView());
            fff.addSpringBackDisLimit(-1);
            fff.show();*/
            // ShitDailogeFragments tr=new ShitDailogeFragments(dff);
          /*  BottomShitDaloge re=BottomShitDaloge.newInstance(false,dff);//.show(getFragmentManager(),"kjhhg");
            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),BottomShitDaloge.TAG);

*/
            // tr.setCancelable(false);
            //  tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),data.getAsObject().get("Name").toString());

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowShitDialogk";
        }
    };

    public static final ALLEvent OpenActivityym = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                String eew =  data.getAsObject().get("Name").getAsString();
                String ValueActivi="0";
                try {
                    ValueActivi = data.getAsObject().get("Value_Activity").getAsString();

                }catch (Exception ex){

                }
                // Log.e("777", eew);
                Class<?> tclas = Class.forName(eew);
                Intent intent = new Intent(context, tclas);
                intent.putExtra("data", ValueActivi);

                //  intent.putExtra("data", dv);
                ActivityOptions op=ActivityOptions.makeCustomAnimation(context, com.astooltech.advancedview.R.anim.fade_in, com.astooltech.advancedview.R.anim.fade_out);
                // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                //views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                context.startActivity(intent,op.toBundle());
            }catch (ClassNotFoundException ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Activity2";
        }
    };
    public static final ALLEvent Updatekmm = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            v.getViewManager().Statuselayout().attachTo(v.getAsView());
            v.getViewManager().Statuselayout().showLoading();
            //   tr.show(act.getSupportFragmentManager(),"bbnnn",);
            //  showStandardNotification("hh",context);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Project";
        }
    };

    public static final ALLEvent Allev = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "noop";
        }
    };

    public static final ALLEvent Update = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {

            String eew =data.getAsObject().get("RootUI").getAsString();
            String eeww =data.getAsObject().get("LayoutUI").getAsString();
            String eewwx =data.getAsObject().get("StyleUI").getAsString();
            String dataui =data.getAsObject().get("DataUI").getAsString();
            v.getViewManager().getContext().Update(eew,eeww,eewwx,dataui);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Update_UI";
        }
    };

    public  static datafiltermo getdatfilter(AppCompatActivity act, Value data,  ProteusView v,   Value... arguments){

        datafiltermo t=new datafiltermo();

            int a1=0;
            int a2=0;
            String seach="";
            boolean usesearch=false;
            try{

                a1=arguments[0].getAsInt();
                a2=arguments[1].getAsInt();
                seach=arguments[2].getAsString();
                usesearch=arguments[3].getAsBoolean();
            }catch (Exception ex){

            }

            List<DataValueSelect> tu= datr(data,act,a1,a2,seach);
            boolean checkks=checknul(tu);
            boolean useVolley=false;
            try
            {
                useVolley=data.getAsObject().getAsBoolean("Use_Volley");
            }catch (Exception ex){

            }
            final   boolean useVolleyy=useVolley;
            if(!checkks) {
                Value er = datr(data, tu,v);
                ObjectValue are=new ObjectValue();
                try {
                    ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                    v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                    are=    data.getAsObject().getAsObject("After_Process");
                }catch (Exception ex){

                }

                t.setAfterproces(are);
                t.setData(er);
                t.setUseVolleyy(useVolley);
                //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);
                //   Log.i("666","ddddddvvvvvvvvvxxxx");
               // new AsyncTaskRunnervForRecycle(er, v, are,Actviw,changeval,useVolleyy,usesearch).execute();

            }
return t;
        }



    public static final ALLEvent  Alleev= new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {


        }

        @Override
        public String getName() {
            return "noopp";
        }

    };
    public static final ALLEvent  DataFrom= new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {

            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView().getRootView();
            for(Fragment f:act.getSupportFragmentManager().getFragments()){

                if(f instanceof DialogFragment) {

                    DialogFragment er=(DialogFragment)f;

                    getallvoigroup(er.getDialog().getWindow().getDecorView(),0);

                }
            }




            //(sse,0);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

            int a1=0;
            int a2=0;
            String seach="";
            boolean usesearch=false;
            try{

                a1=arguments[0].getAsInt();
                a2=arguments[1].getAsInt();
                seach=arguments[2].getAsString();
                usesearch=arguments[3].getAsBoolean();
            }catch (Exception ex){

            }

            List<DataValueSelect> tu= datr(data,act,a1,a2,seach);
            boolean checkks=checknul(tu);
            boolean useVolley=false;
            try
            {
                useVolley=data.getAsObject().getAsBoolean("Use_Volley");
            }catch (Exception ex){

            }
            final   boolean useVolleyy=useVolley;
            if(!checkks) {
                Value er = datr(data, tu,v);
                ObjectValue are=new ObjectValue();
                try {
                    ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                    v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                    are=    data.getAsObject().getAsObject("After_Process");
                }catch (Exception ex){

                }
                //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);
                //   Log.i("666","ddddddvvvvvvvvvxxxx");
                new AsyncTaskRunnervForRecycle(er, v, are,Actviw,changeval,useVolleyy,usesearch).execute();

            }

        }

        @Override
        public String getName() {
            return "Data_From";
        }
    };

    public static final ALLEvent ResponFromURL = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                if (dataIndex == 2) {
                    // Log.e("aaaaaa", "eerrrr");
                    //Bandar
                    Object ww = v.getAsView().getTag(R.id.ErrorM);//.getExtras();//.getAsObject().getAsObject("Error_Message");//getLayout().extras.getAsObject("Error_Message");
                    if (ww != null) {
                        Value vall = (Value) ww;
                        // Log.e("aaaaaa", "eerrrr");
                        //Gson g=new Gson();
                        // Log.e(":ttt",g.toJson(vall));
                        v.getViewManager().getContext().getAllEven("ShowCookie").call(context, act, vall, 5, v, arguments);
                        // Log.e("aaaaaa", "eerrrr");
                    }
                }
                if (dataIndex == 1) {
                    //Bandar
                    Object ww = v.getAsView().getTag(R.id.SuccessM);//.getExtras();//.getAsObject().getAsObject("Error_Message");//getLayout().extras.getAsObject("Error_Message");
                    if (ww != null) {
                        Value vall = (Value) ww;
                        v.getViewManager().getContext().getAllEven("ShowCookie").call(context, act, vall, 5, v, arguments);
                    }
                }

            /*else {
                if (arguments[0].getAsObject().getAsInteger("show_as_messagekeytyp") == 0) {

                    if (arguments[0].getAsObject().getAsString("show_as_message").equals("1")) {
                        //showMessage

                        String getmes = arguments[0].getAsObject().getAsString("show_as_messagetext");
                        // Gson gh=new Gson();
                        v.getViewManager().getContext().getMassss().showmessage(getmes, 1, "0");
                    }


                } else if (arguments[0].getAsObject().getAsInteger("show_as_messagekeytyp") == 2) {


                    //fromofline
                } else {
                    String getmes = arguments[0].getAsObject().getAsString("show_as_messagetext");
                    v.getViewManager().getContext().getMassss().showmessage(getmes, 1, "0");
                    Gson gh = new Gson();
                    Log.i("788", getmes);
                }



            }*/
                //(sse,0);
            }catch (Exception ex){

                Log.e("aaaaaa",ex.getMessage());
            }
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Response";
        }
    };
    public static final ALLEvent Alleevv = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {

            View sse = act.getWindow().getDecorView().getRootView();
            getallvoigroupd(sse,0);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "nooppx";
        }
    };



    public static final ALLEvent OpenDrawer = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {

            v.getViewManager().getContext().getmDrawerr().open();

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Drawer";
        }
    };
    private Value addvalueto(String name,String dataAc,boolean tolbar,boolean draw){
        ObjectValue ob=new ObjectValue();
        ob.add("Name",new Primitive(name));
        ob.add("Value_Activity",new Primitive(dataAc));
        ob.add("Show_Toolbar",new Primitive(tolbar));
        ob.add("Show_Drawer",new Primitive(draw));
        ObjectValue s=new ObjectValue();
        s.add("s",ob);

        return    s.get("s");


    }
    public static final ALLEvent OpenActivity = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                String startwith=data.getAsObject().get("Name").getAsString();
                String eew="0";
                if(startwith.startsWith("@")){
                    eew=startwith.substring(1,startwith.length());
                }else {
                    eew =context.getPackageName() + "." + data.getAsObject().get("Name").getAsString();
                }
                String ValueActivi="0";
                try {
                    ValueActivi = data.getAsObject().get("Value_Activity").getAsString();

                }catch (Exception ex){

                }

                boolean showToolbar=false;
                boolean showDrae=false;

                try
                {
                    showToolbar=data.getAsObject().getAsBoolean("Show_Toolbar");
                    showDrae=data.getAsObject().getAsBoolean("Show_Drawer");
                }catch (Exception ex){

                }
                // Log.e("777", eew);
                Class<?> tclas = Class.forName(eew);
                Intent intent = new Intent(context, tclas);
                intent.putExtra("data", ValueActivi);
                if(showDrae){
                    intent.putExtra("Drawer", "1");

                }else {
                    intent.putExtra("Drawer", "0");
                }
                if(showToolbar){
                    intent.putExtra("Toolbar", "1");

                }else {
                    intent.putExtra("Toolbar", "0");
                }
                //  intent.putExtra("data", dv);
                ActivityOptions op=ActivityOptions.makeCustomAnimation(context,R.anim.fade_in,R.anim.fade_out);
                // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                //views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                context.startActivity(intent,op.toBundle());
            }catch (ClassNotFoundException ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Activity";
        }
    };

    public static final ALLEvent OpenActivityff = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                String eew = context.getPackageName() + "." + data.getAsObject().get("Name").getAsString();
                String ValueActivi="0";
                try {
                    ValueActivi = data.getAsObject().get("Value_Activity").getAsString();

                }catch (Exception ex){

                }

                boolean showToolbar=false;
                boolean showDrae=false;

                try
                {
                    showToolbar=data.getAsObject().getAsBoolean("Show_Toolbar");
                    showDrae=data.getAsObject().getAsBoolean("Show_Drawer");
                }catch (Exception ex){

                }
                // Log.e("777", eew);
                Class<?> tclas = Class.forName(eew);
                Intent intent = new Intent(context, tclas);
                intent.putExtra("data", ValueActivi);
                if(showDrae){
                    intent.putExtra("Drawer", "1");

                }else {
                    intent.putExtra("Drawer", "0");
                }
                if(showToolbar){
                    intent.putExtra("Toolbar", "1");

                }else {
                    intent.putExtra("Toolbar", "0");
                }
                //  intent.putExtra("data", dv);
                ActivityOptions op=ActivityOptions.makeCustomAnimation(context,R.anim.fade_in,R.anim.fade_out);
                // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                //views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                context.startActivity(intent,op.toBundle());
            }catch (ClassNotFoundException ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Activity";
        }
    };
    public static final ALLEvent OpenActivityFromUrl = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                Log.i("777mmm","jjjjjjjjjjjjjjjjjjjjjj@@");
                String Activityname="0";
                try{
                    Activityname=  data.getAsObject().getAsString("Name_Activity");
                }catch (Exception  ex){

                }

                List<DataValueSelect> tu= datr(data,act,0,0,"0");
                Log.i("777mmmxx","jjjjjjjjjjjjjjjjjjjjjj");
                //Log.i("gggg","h"+tu.size());
               /* ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
                List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);
                for(ViewGroup f:rehh) {
                    SerachNullValue(f, tu);
                }*/
                boolean checkks=false;

                boolean useVolley=false;

                boolean showToolbar=false;
                boolean showDrae=false;

                try
                {
                    showToolbar=data.getAsObject().getAsBoolean("Show_Toolbar");
                    showDrae=data.getAsObject().getAsBoolean("Show_Drawer");
                }catch (Exception ex){

                }
                try
                {
                    useVolley=data.getAsObject().getAsBoolean("Use_Volley");
                }catch (Exception ex){

                }
                if(!checkks) {
                    Log.i("777mmm","jjjjjjjjjjjjjjjjjjjjjj");
                    Value er = datr(data, tu,v);
                    Log.i("777mmm","jjjjjjjjjjjjjjjjjjjjjjiiiiiiiiiiiiiiiii");

                    Gson n=new Gson();
                    Log.i("777mmm",n.toJson(er));

                    ObjectValue are=new ObjectValue();
                    try {
                        ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                        v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                        are=    data.getAsObject().getAsObject("After_Process");
                    }catch (Exception ex){
                        Log.i("777mmmTT",n.toJson(er));
                    }
                    //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);

                    new AsyncTaskRunnervFromUrl(er, v, are,useVolley,showToolbar,showDrae,Activityname).execute();

                }








            }catch (Exception ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Activity_From_Url";
        }
    };


    public static final ALLEvent DownloadFile = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {
                //DownloadSubmitterImpl.submit(null);(context,12);


                String valuue=data.getAsObject().getAsString("Download_Url");
                String valuues=data.getAsObject().getAsString("Download_Urltyp");

                String typ=valuues;
                if(typ.equals("1")) {
                    // final long begin = SystemClock.elapsedRealtime();
                    DownloadTask gg=  DownloadImpl.with(context)
                            .url(valuue).getDownloadTask();
                    DownloadImpl.getInstance(context).enqueue(gg);
                    //  DownloadSubmitterImpl.getInstance().submit0(downloadTask);

            /*.enqueue(new DownloadListenerAdapter() {
                @Override
                public void onProgress(String url, long downloaded, long length, long usedTime) {
                    super.onProgress(url, downloaded, length, usedTime);
//                        Log.i(TAG, " progress:" + downloaded + " url:" + url);
                }

                @Override
                public boolean onResult(Throwable throwable, Uri path, String url, Extra extra) {
                    Gson g = new Gson();
                    //String resyyy = g.toJson(url);
                  //  String resyyyx = g.toJson(path);
                   // Log.e("uuuuuuu", resyyy);
                   // Log.e("uuuuuuu", resyyyx);
                   // Log.i(TAG, " path:" + path + " url:" + url + " length:" + path.getPath());
                    //   Log.i(TAG, " DownloadImpl time:" + (SystemClock.elapsedRealtime() - begin) + " length:" + new File(path.getPath()).length());

                    return super.onResult(throwable, path, url, extra);
                }
            });*/

                }else {
                    File dir = com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Runtime.getInstance().getDir(context);
                    // NotificationCompat.Builder noti=new NotificationCompat.Builder(view.)

                    DownloadTask gg=   DownloadImpl.getInstance(context)
                            .url(valuue)//"http://shouji.360tpcdn.com/170918/93d1695d87df5a0c0002058afc0361f1/com.ss.android.article.news_636.apk")
                            .target(dir)//new File(getExternalCacheDir() + "/download/" + "public" + "/" + "com.ss.android.article.news_636.apk"), this.getPackageName() + ".SampleFileProvider")//自定义路径需指定目录和authority(FileContentProvide),需要相对应匹配才能启动通知，和自动打开文件
                            .setUniquePath(false)//是否唯一路径
                            .setForceDownload(true)//不管网络类型
                            .setRetry(4)//下载异常，自动重试,最多重试4次
                            .setBlockMaxTime(60000L) //以8KB位单位，默认60s ，如果60s内无法从网络流中读满8KB数据，则抛出异常 。
                            .setConnectTimeOut(10000L)//连接10超时
                            .addHeader("xx", "cookie")//添加请求头
                            .setDownloadTimeOut(Long.MAX_VALUE)//下载最大时长
                            .setOpenBreakPointDownload(true)//打开断点续传
                            .setParallelDownload(true)//打开多线程下载
                            // .autoOpenWithMD5("93d1695d87df5a0c0002058afc0361f1")//校验md5通过后自动打开该文件,校验失败会回调异常
//                .autoOpenIgnoreMD5()
//                .closeAutoOpen()
                            .quickProgress().getDownloadTask();//快速连续回调进度，默认1.2s回调一次


                    DownloadImpl.getInstance(context).enqueue(gg);
           /* .enqueue(new DownloadListenerAdapter() {
                @Override
                public void onStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength, Extra extra) {
                    super.onStart(url, userAgent, contentDisposition, mimetype, contentLength, extra);
                }

                @MainThread //加上该注解，自动回调到主线程
                @Override
                public void onProgress(String url, long downloaded, long length, long usedTime) {
                    super.onProgress(url, downloaded, length, usedTime);
                    Log.i(TAG, " progress:" + downloaded + " url:" + url);
                }

                @Override
                public boolean onResult(Throwable throwable, Uri path, String url, Extra extra) {
                    Gson g = new Gson();
                    //String resyyy = g.toJson(url);
                   // String resyyyx = g.toJson(path);
                    //Log.e("uuuuuuu", resyyy);
                  //  Log.e("uuuuuuu", resyyyx);
                    //Log.i(TAG, " path:" + path + " url:" + url + " length:" + path.getPath());
                    //   Log.i(TAG, " DownloadImpl time:" + (SystemClock.elapsedRealtime() - begin) + " length:" + new File(path.getPath()).length());

                    // String md5 =com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Runtime.getInstance().md5(new File(path.getPath()));
                    // Log.i(TAG, " path:" + path + " url:" + url + " length:" + new File(path.getPath()).length() + " md5:" + md5 + " extra.getFileMD5:" + extra.getFileMD5());
                    return super.onResult(throwable, path, url, extra);
                }
            });*/


                }

            }catch (Exception ex){
                Log.e("7779999" +
                        "" +
                        "", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "DownLoad_File";
        }
    };
    public static final ALLEvent OpenActivityFromString = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {

                String eew = "0";
                try {
                    try {
                        String startwith = data.getAsObject().get("Name").getAsString();

                        if (startwith.startsWith("@")) {
                            eew = startwith.substring(1, startwith.length());
                        } else {
                            eew = context.getPackageName() + "." + data.getAsObject().get("Name").getAsString();
                        }
                    }catch (Exception ex){
                        eew = context.getPackageName() + "." + "proteus.demo.ProtouseNewActivity";

                    }
                    String ValueActivi="0";
                    try {
                        ValueActivi = data.getAsObject().get("Value_Activity").getAsString();

                    }catch (Exception ex){

                        try {
                            ValueActivi = data.getAsObject().get("Activity_Data").getAsString();

                        }catch (Exception exe){

                        }

                    }

                    boolean showToolbar=false;
                    boolean showDrae=false;

                    try
                    {
                        showToolbar=data.getAsObject().getAsBoolean("Show_Toolbar");
                        showDrae=data.getAsObject().getAsBoolean("Show_Drawer");
                    }catch (Exception ex){

                    }
                    // Log.e("777", eew);
                    Class<?> tclas = Class.forName(eew);
                    Intent intent = new Intent(context, tclas);
                    intent.putExtra("data", ValueActivi);
                    if(showDrae){
                        intent.putExtra("Drawer", "1");

                    }else {
                        intent.putExtra("Drawer", "0");
                    }
                    if(showToolbar){
                        intent.putExtra("Toolbar", "1");

                    }else {
                        intent.putExtra("Toolbar", "0");
                    }
                    //  intent.putExtra("data", dv);
                    ActivityOptions op=ActivityOptions.makeCustomAnimation(context,R.anim.fade_in,R.anim.fade_out);
                    // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                    //views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                    context.startActivity(intent,op.toBundle());
                }catch (ClassNotFoundException ex){
                    Log.e("777", ex.getMessage());
                }
/*String valuue=data.getAsObject().getAsString("Activity_Data");




                Intent intent = new Intent(v.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data", valuue);
                ActivityOptions op=ActivityOptions.makeCustomAnimation(context,R.anim.fade_in,R.anim.fade_out);
                v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());

*/




            }catch (Exception ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Activity_From_String";
        }
    };

    public static final ALLEvent OpenActivityFromStringOpen = new ALLEvent(){
        private List<String> checkNeedPermission(AppCompatActivity act) {

            List<String> deniedPermissions = new ArrayList<>();

            if (!AgentWebUtils.hasPermission(act, AgentWebPermissions.CAMERA)) {
                deniedPermissions.add(AgentWebPermissions.CAMERA[0]);
            }
            if (!AgentWebUtils.hasPermission(act, AgentWebPermissions.STORAGE)) {
                deniedPermissions.addAll(Arrays.asList(AgentWebPermissions.STORAGE));
            }
            return deniedPermissions;
        }
        private void myMethod(com.astooltech.advancedview.inlineactivityresult.request.Request request,  final ProteusView v, final int getw ) {
            new InlineActivityResult(v.getViewManager().getContext().getActvityAllt())
                    .startForResult(request, new ActivityResultListener() {

                        @Override
                        public void onSuccess(com.astooltech.advancedview.inlineactivityresult.Result result) {
                            //Uri extras = result.getData().getData();//.getData().getExtras();

                            //int resultCode = result.getRequestCode();//.resultCode();


                            // Uri contentURI = ;
                            try {
                                Bitmap bitmap =getw==0? MediaStore.Images.Media.getBitmap(v.getViewManager().getContext().getActvityAllt().getContentResolver(), result.getData().getData()):(Bitmap)result.getData().getExtras().get("data");
                                ByteArrayOutputStream ary = new ByteArrayOutputStream();
                                // Log.e("7799",contentURI.getPath());
                                // BitmapDrawable b = (BitmapDrawable) dt.getBackground();
                                // Bitmap bb = b.getBitmap();
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ary);

                                String res = Base64.encodeToString(ary.toByteArray(), Base64.DEFAULT);
                                Value eeerk = new Primitive(res);
                                v.getViewManager().getContext().getAllEven("Set_Data_Only").call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), v.getViewManager().getContext().getData(), 10, v, eeerk, eeerk);

                            } catch (Exception e) {
                                Log.e("77", e.getMessage());
                                //Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailed(com.astooltech.advancedview.inlineactivityresult.Result result) {

                        }
                    });
        }

        private byte[] getbyt(InputStream in)  {

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

            try {
                int buff = 1024;
                byte[] buffv = new byte[buff];
                int len = 0;
                while ((len = in.read(buffv)) != -1) {
                    byteArrayOutputStream.write(buffv, 0, len);


                }
            }catch (Exception ex){

                Log.i("77",ex.getMessage());
            }
            return  byteArrayOutputStream.toByteArray();
        }
        @NonNull
        @Override
        public void call(final Context context, final AppCompatActivity act, final Value data, int dataIndex, final ProteusView v, Value... arguments) throws Exception {
            try {

                // String valuue=data.getAsObject().getAsString("Activity_Data");
                final int FROM_INTENTION_CODE = 21;
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(context);
                        pictureDialog.setTitle("الرجاء الاختيار");
                        String[] pictureDialogItems = {"الاستيديو", "الكاميراء"};
                        pictureDialog.setItems(pictureDialogItems,
                                new DialogInterface.OnClickListener() {
                                    @SuppressLint("CheckResult")
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Action mAction = new Action();
                                        List<String> deniedPermissions = null;
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !(deniedPermissions = checkNeedPermission(act)).isEmpty()) {
                                            mAction.setAction(Action.ACTION_PERMISSION);
                                            mAction.setPermissions(deniedPermissions.toArray(new String[]{}));
                                            mAction.setFromIntention(FROM_INTENTION_CODE >> 3);
                                            mAction.setPermissionListener(new AgentActionFragment.PermissionListener() {

                                                @Override
                                                public void onRequestPermissionsResult(@NonNull String[] permissions, @NonNull int[] grantResults, Bundle extras) {

                                                    // boolean tag = true;
                                                    // tag = AgentWebUtils.hasPermission(ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteusActivity(), Arrays.asList(permissions)) ? true : false;
                                                    // permissionResult(tag, extras.getInt(KEY_FROM_INTENTION));

                                                }
                                            });
                                            start(act, mAction);
                                        } else {
                                            int typ=1;
                                            Intent galleryIntent =which==0? new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI):new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                            final int getw=which;
                                            PendingIntent pendingIntent = PendingIntent.getActivity(v.getAsView().getContext(), 0, galleryIntent, 0);

                                            com.astooltech.advancedview.inlineactivityresult.request.Request request = RequestFabric.create(pendingIntent.getIntentSender(), null, 0, 0, 0, null);

                                            myMethod(request,v,getw);

                                        }

                                    }
                                });
                        pictureDialog.show();
                    }
                });


              /*  Intent intent = new Intent(v.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data", valuue);
                v.getViewManager().getContext().getActvityAllt().startActivity(intent);*/






            }catch (Exception ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Select_File";
        }
    };


    private static void getallvoigroupd(View v,int x){
        x=x+1;
        //   Log.i(x+"ViewOnlfff","@"+v.getId());
        if(v instanceof TextInputLayoutB){


            TextInputLayoutB eer=(TextInputLayoutB)v;
            // Log.i("wwwww",eer.getEditText().getText().toString());
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

    private static void getallvoigroup(View v,int x){
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
    private static void SetGetFindTextInputLayout(TextInputLayoutB  dt,DataValueSelect datb,int typoper){
        if(typoper==1){
            boolean typActionname =Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {
                EditText ccc = dt.getEditText();
                assert ccc != null;
                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    if(datb.getTypselect().equals("0")) {
                        if (ccc.getText().toString().equals("")) {
                            try {
                                // Log.i("ProteusEventWithTag11", "iiiiiiiiiiimm" + "@@@@@@");
                                String cvv = String.valueOf(dt.getTag(R.id.otagOnerrortext));
                                ccc.setError(cvv);
                                dt.setHelperText(cvv);
                                dt.setErrorEnabled(true);
                                datb.setChecknull(true);
                                // checknull = true;
                            } catch (Exception ex) {

                                //  Log.i("ProteusEventWithTag11", ex.getMessage() + "@@@@@@");
                                //  return;
                            }

                        } else {
                            //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiikk" + "@@@@@@");
                            dt.setHelperTextEnabled(false);
                            dt.setHelperText("");
                            dt.setError("");
                            dt.setErrorEnabled(false);
                            // Log.i("ProteusEventWithTag11", "iiiiiiiiiiipp" + "@@@@@@");
                            datb.setDataGet(ccc.getText().toString());
                            //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiiuuuu" + "@@@@@@");
                                           /* resultData c = new resultData(cx, ccc.getText().toString(),"@"+IDDdat+"@");
                                            // unit_model c = new unit_model(cx, ccc.getText().toString() + " " + ccc.getId());
                                            allunit.add(c);*/
                        }

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
                        dt.getEditText().setText(datb.getDataGet());
                    }

                }

            }

        }


    }

    private static void SetGetFindTextInputLayouEdit(TextInputEditText  dt,DataValueSelect datb,int typoper){
        if(typoper==1){
            boolean typActionname =Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    if(datb.getTypselect().equals("0")) {
                        if (dt.getText().toString().equals("")) {
                            try {
                                // Log.i("ProteusEventWithTag11", "iiiiiiiiiiimm" + "@@@@@@");
                                // String cvv = String.valueOf(dt.getTag(R.id.otagOnerrortext));
                                String cvv = String.valueOf(dt.getTag(R.id.otagOnerrortext));
                                dt.setError(cvv);

                                datb.setChecknull(true);
                                // checknull = true;
                            } catch (Exception ex) {

                                //  Log.i("ProteusEventWithTag11", ex.getMessage() + "@@@@@@");
                                //  return;
                            }

                        } else {
                            //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiikk" + "@@@@@@");
                            datb.setDataGet(dt.getText().toString());
                            //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiiuuuu" + "@@@@@@");
                                           /* resultData c = new resultData(cx, ccc.getText().toString(),"@"+IDDdat+"@");
                                            // unit_model c = new unit_model(cx, ccc.getText().toString() + " " + ccc.getId());
                                            allunit.add(c);*/
                        }


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
                        dt.setText(datb.getDataGet());
                    }
                }

            }

        }


    }


    private static void SetGetFindTextInputLayoutRdio( ProteusRadioButtonGroup  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true;//Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {



                        if(datb.getTypselect().equals("0")) {
                            int xzc = dt.getCheckedRadioButtonId();
                            RadioButton ccv = (RadioButton) dt.findViewById(xzc);
                            String IDDdatx = ccv.getTag(R.id.tag3).toString();
                            datb.setDataGet(IDDdatx);
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
                            for (int cxx = 0; cxx < dt.getChildCount(); cxx++) {
                                try {
                                    RadioButton ccv = (RadioButton) dt.getChildAt(cxx);
                                    String IDDdatxx = ccv.getTag(R.id.tag3).toString();
                                    String getdat = datb.getDataGet();
                                    if (IDDdatxx.equals(getdat)) {

                                        ccv.setChecked(true);
                                    }
                                }catch (Exception ex){

                                }
                            }

                        }


                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static void SetGetFindTextInputLayoutRdiogroup( RadioGroup  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true;//Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        if(datb.getTypselect().equals("0")) {
                            int xzc = dt.getCheckedRadioButtonId();
                            RadioButton ccv = (RadioButton) dt.findViewById(xzc);
                            String IDDdatx = ccv.getTag(R.id.tag3).toString();
                            datb.setDataGet(IDDdatx);


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
                            try {

                                for (int cxx = 0; cxx < dt.getChildCount(); cxx++) {
                                    try {
                                        // Log.i("ProteusEventWithTag", "hhhhh");

                                        RadioButton zx = (RadioButton) dt.getChildAt(cxx);

                                        String IDDdatm = zx.getTag(R.id.tag3).toString();
                                        if (IDDdatm.equals(d)) {

                                            zx.setChecked(true);


                                        }
                                    } catch (Exception ex) {
                                        Log.i("ProteusEventWithTag", "hhhhhvvvvvv");
                                    }
                                }
                            }catch (Exception e){

                            }
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }
    private static void SetGetFindTextInputLayoutEditText( EditText  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(R.id.tag3).toString();
                if(IDDdat!=null) {

                    if (IDDdat.equals(datb.getIDUnit())) {
                        {
                            //  dat.get(cxx).setDataGet();
                            if (datb.getTypselect().equals("0")) {
                                datb.setDataGet(dt.getText().toString());
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                            } else if (datb.getTypselect().equals("1")) {
                                dt.setVisibility(View.VISIBLE);
                            } else if (datb.getTypselect().equals("2")) {
                                dt.setVisibility(View.GONE);
                            } else if (datb.getTypselect().equals("3")) {
                                dt.setEnabled(false);
                            } else if (datb.getTypselect().equals("4")) {
                                dt.setEnabled(true);
                            } else if (datb.getTypselect().equals("5")) {
                                String d = datb.getDataGet();
                                dt.setText(d);

                            }
                        }
                    }
                }
            }

        }
    }

    private static void SetGetFindTextInputLayoutEditTextCheckBox( CheckBox  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("1")) {
                            String typview="0";
                            try {
                                typview= datb.getUnitName();
                            }catch (Exception ex){

                            }

                            if(typview.equals("0")) {
                                datb.setDataGet(String.valueOf(dt.isChecked()));
                            }else{

                                if(dt.isChecked()){
                                    datb.setDataGet("1");
                                }else{
                                    datb.setDataGet("0");
                                }

                            }
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
                            String d=datb.getDataGet().toLowerCase();
                            if(d.startsWith("f")) {
                                dt.setChecked(false);
                            }else  if(d.startsWith("0")) {
                                dt.setChecked(false);
                            }else {
                                dt.setChecked(true);
                            }
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static void SetGetFindTextInputLayoutEditTextCheckBoxSwi( ProtouseSwitchButton  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            String typview="0";
                            try {
                                typview= datb.getUnitName();
                            }catch (Exception ex){

                            }

                            if(typview.equals("0")) {
                                datb.setDataGet(String.valueOf(dt.isChecked()));
                            }else {

                                if (dt.isChecked()) {
                                    datb.setDataGet("1");
                                } else {
                                    datb.setDataGet("0");
                                }
                            }

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
                            String d=datb.getDataGet().toLowerCase();
                            if(d.startsWith("f")) {
                                dt.setChecked(false);
                            }else  if(d.startsWith("0")) {
                                dt.setChecked(false);
                            }else {
                                dt.setChecked(true);
                            }
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static   Drawable convertBitmapToDrawable(Bitmap original, Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = original.getWidth();
        int height = original.getHeight();

        float scaleWidth = displayMetrics.scaledDensity;
        float scaleHeight = displayMetrics.scaledDensity;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        Bitmap resizedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true);

        return new BitmapDrawable(context.getResources(), resizedBitmap);
    }

    private static void SetGetFindWebVieww( CustomeWeb  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            //   dt.reload();
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
                            String d=datb.getDataGet().toLowerCase();
                            //   dt.cre.loadUrl("javascript:" + d);
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static void SetGetFindWebView( ProteusWebView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

//dt.getViewManager().getLayout().type.getViewManager().getContext().getProteusResources().getParsers().getParser()
                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            dt.reload();
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
                            dt.loadUrl("javascript:" + d);
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static void SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmor( ReadMoreTextView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(dt.getText().toString());


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
                        }     else   if(datb.getTypselect().equals("5")) {
                            String d=datb.getDataGet();
                            dt.setText(d);

                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static void SetImage(ProteusImageView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                            try {
                                ByteArrayOutputStream ary = new ByteArrayOutputStream();

                                BitmapDrawable b = (BitmapDrawable) dt.getBackground();
                                Bitmap bb = b.getBitmap();
                                bb.compress(Bitmap.CompressFormat.JPEG, 100, ary);

                                String res = Base64.encodeToString(ary.toByteArray(), Base64.DEFAULT);

                                datb.setDataGet(res);
                            }catch (Exception ex){

                            }

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
                        }     else   if(datb.getTypselect().equals("5")) {
                            String d=datb.getDataGet();
                            try {

                                byte[] bbb=Base64.decode(d,0);
                                //   ByteArrayOutputStream ary = new ByteArrayOutputStream();
                                Drawable dk=   convertBitmapToDrawable(BitmapFactory.decodeByteArray(bbb,0,bbb.length),dt.getContext());
                                dt.setBackground(dk);
                            }catch (Exception ex){

                            }


                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }

    private static void SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmorTextView( ProteusTextView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(dt.getText().toString());
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

                    }
                }

            }

        }
    }


    private static void SetGetFindTSppiner(SpainnerViewB  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                            /// dt.set
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


                            //  dt.getSelectedItem();
                            flexAdapterrrr tur=( flexAdapterrrr) dt.getAdapter();
                            int postin=  tur.getallItemPostionByname(d);

                            dt.setSelection(postin);
                        }

                    }
                }

            }

        }
    }

    private static void SetGetFindTSppinerSweep(PrototoseSwiperView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                            /// dt.set
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


                            //  dt.getSelectedItem();
                          /*  flexAdapterrrr tur=( flexAdapterrrr) dt.getAdapter();
                            int postin=  tur.getallItemPostionByname(d);
*/
                            dt.setRefreshing(false);
                        }

                    }
                }

            }

        }
    }



    private static void SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmorTextViewAuto( AutoCompleteTextViewB  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(dt.getText().toString());
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
                            dt.setText(d);

                        }

                    }
                }

            }

        }
    }


    private static void SetGetFindTextInputLayoutEditTextB( ProteusButton dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(dt.getText().toString());
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
                            dt.setText(d);

                        }
                    }
                }

            }

        }
    }


    private static void prograssbarr(ProteusProgressBar dt,DataValueSelect datb ){


        String IDDdat = dt.getTag(R.id.tag3).toString();
        if (IDDdat.equals(datb.getIDUnit())) {
            {


                //  dat.get(cxx).setDataGet();
                if(datb.getTypselect().equals("1")) {
                    dt.setVisibility(View.VISIBLE);
                }
                else   if(datb.getTypselect().equals("2")) {
                    dt.setVisibility(View.GONE);
                }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

            }
        }


        ;
        //  String IDDdat = zxb.getTag(R.id.tag3).toString();
                   /* if(IDDdat.equals(nameprograss)){

                        if(visabl.equals("1")) {
                            //  Log.i("ProteusEventWithTag", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+visabl);

                            zxb.setVisibility(View.VISIBLE);
                        }else {
*/

        //  }}



    }



    public void showbutton(){


    }
    private static   void  SerachNullValue(ViewGroup v, List<DataValueSelect> dat){

        try {
            String nam = " ";
            for (int cx = 0; cx < v.getChildCount(); cx++) {

                if(v.getChildAt(cx) instanceof ProteusView){

                    ProteusView zx = (ProteusView) v.getChildAt(cx);
                    for (int cxx = 0; cxx < dat.size(); cxx++) {


                        try {

                            zx.getViewManager().getContext().getParser(zx.getViewManager().getLayout().type).GetAndSetData(zx,dat.get(cxx),1,null,"0");

                        } catch (Exception ex) {
                            Log.i("ProteusEventWithTag33", ex.getMessage() + "@@@@@@@@@@@@@@@@@");
                        }


                    }
                }



                if (v.getChildAt(cx) instanceof ViewGroup) {


                    try {
                        ViewGroup zxm = (ViewGroup) v.getChildAt(cx);
                        SerachNullValue(zxm, dat);
                        //  Log.i("ProteusEventWithTag55", zxm.getTag(R.id.tag3).toString() + "@@@" + v.getChildAt(cx).getClass().getName());
                    } catch (Exception ex) {

                    }

                }




            }
        }catch (Exception ex){
            // Log.e("dddddd7777",ex.getMessage());
        }
    }

    private static   void  GetValueFromView(ViewGroup v, List<DataValueSelect> dat,int type){

        try {
            String nam = " ";
            for (int cx = 0; cx < v.getChildCount(); cx++) {

                if(v.getChildAt(cx) instanceof ProteusView){

                    ProteusView zx = (ProteusView) v.getChildAt(cx);
                    for (int cxx = 0; cxx < dat.size(); cxx++) {
                        if(!dat.get(cxx).getIDUnit().equals("0")) {

                            try {

                                zx.getViewManager().getContext().getParser(zx.getViewManager().getLayout().type).GetAndSetData(zx, dat.get(cxx), type, null, "0");

                            } catch (Exception ex) {
                                Log.i("ProteWith", ex.getMessage() + "@@@@@@@@@@@@@@@@@");
                            }
                        }

                    }
                }



                if (v.getChildAt(cx) instanceof ViewGroup) {


                    try {
                        ViewGroup zxm = (ViewGroup) v.getChildAt(cx);
                        GetValueFromView(zxm, dat,type);
                        //  Log.i("ProteusEventWithTag55", zxm.getTag(R.id.tag3).toString() + "@@@" + v.getChildAt(cx).getClass().getName());
                    } catch (Exception ex) {

                    }

                }




            }
        }catch (Exception ex){
            // Log.e("dddddd7777",ex.getMessage());
        }
    }


    public static final ALLEvent Allevt = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            String eew=data.getAsObject().get("Name").toString();//.getAsString();
            ObjectValue cx=null;
            Array getas=null;
            try {
                try {
                    getas = data.getAsObject().get("Set_Data").getAsArray();
                }catch (Exception ex){

                }
                cx = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
            }catch (Exception ex){

            }
            if(cx==null){
                cx=new ObjectValue();
            }

            ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            int sssd=0; boolean pressok=false; DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {
                    //  Log.e("Cancell","ggggggggggggggmmmmmmm");
                }

                @Override
                public void dismiss() {
                    //Log.e("dismisss","ggggggggggggggyyyy");
                }
            };

            DalogeFragment tr=new DalogeFragment(dff,iio,sssd,pressok);



            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
            //  tr.getDialog().setOnDismissListener(aassd);
            //tr.getDialog().setOnCancelListener(yyy);

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowDialog";
        }
    };


    public static final ALLEvent ShowMessageOnly = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            String eew=arguments[0].getAsString();//.get("Name").toString();//.getAsString();

            String typ=arguments[1].getAsString();
            showmess(eew,typ,v,act);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowMessageOnly";
        }
    };
    private static ObjectValue ObjectValuex(String color,ProteusView v){
        String baccol=color=="0"?"#3b7A57":"@color/blue_A200";
        String typ="LinearLayout";


        String data="{\n" +
                "$$Event_Type$$:$$ShowCookie$$,\n" +
                "$$Name$$:$$MM$$,\n" +
                "$$M$$:$$1$$,\n" +
                "$$T$$:$$1$$,\n" +
                "$$Title$$:$$ggggg $$,\n" +
                "$$Message$$:$$  dhdhdhbdhdhdjdjudhdhdhdhdytt dhdhdhhdhdhdhdhh$$,\n" +
                "$$ColorA$$:$$ffffff$$,\n" +
                "$$ColorB$$:$$ffffff$$,\n" +
                "$$ColorC$$:$$d3212d$$,\n" +
                "$$Locations$$:$$b$$,\n" +
                "$$Duration$$:5000,\n" +
                "$$Anim_Type$$:0,\n" +
                "$$AutoDismiss$$:true,\n" +
                "$$SweepDismiss$$:true,\n" +
                "$$Custome_View$$:{\n" +
                "    $$type$$: $$CardView$$,\n" +
                "    $$orientation$$: $$vertical$$,\n" +
                "    $$layout_width$$: $$match_parent$$,\n" +
                "    $$layout_height$$: $$wrap_content$$,\n" +
                "  $$background$$:$$@drawable/blue_btn_bkg$$,\n" +
                "  $$layout_margin$$:$$5dp$$,\n" +
                "    $$children$$: [{\n" +
                "\n" +
                "    $$type$$: $$LinearLayout$$,\n" +
                "      $$layout_width$$: $$match_parent$$,\n" +
                "      $$layout_height$$: $$wrap_content$$,\n" +
                "      $$gravity$$: $$right$$,\n" +
                "      $$focusable$$:false,\n" +
                "      $$background$$:$$"+baccol+"$$,\n" +
                "      $$orientation$$: $$vertical$$,\n" +
                "      $$children$$:[\n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "      {\n" +
                "                  $$type$$: $$ImageView$$,\n" +
                "                  $$layout_width$$: $$50dp$$,\n" +
                "                  $$layout_height$$: $$50dp$$,\n" +
                "                  $$layout_gravity$$: $$center$$,\n" +
                "                  $$background$$:$$@drawableFont/fa_wrench_solid/1/40/#ffffff$$\n" +
                "},\n" +
                "{\n" +
                "        $$type$$: $$TextView$$,\n" +
                "        $$layout_width$$: $$match_parent$$,\n" +
                "        $$layout_height$$: $$wrap_content$$,\n" +
                "        $$layout_marginTop$$: $$10dp$$,\n" +
                "        $$gravity$$: $$center$$,\n" +
                "        $$textColor$$: $$@color/white$$,\n" +
                "        $$textSize$$: $$18sp$$,\n" +
                "        $$text$$: $$@{Message[0].Message}$$\n" +
                "}\n" +
                "]\n" +
                "}]\n" +
                "}\n" +
                "}";

        data=data.replace("$$","\"");
        Gson gd=v.getViewManager().getContext().getJson();
        Type type = new TypeToken<Value>() {

        }.getType();
        ObjectValue tempp = gd.fromJson(data, type);
//Layout lay=new Layout("CardView",);
        return tempp.getAsObject("Custome_View");
    /*ggg.add("Title",new  Primitive(eew+"fffffffff"));

    mymessage.add(ggg);
    ObjectValue gggc=new ObjectValue();

    gggc.add("Me",mymessage);*/

    }


    private  static void showmess(String mess,String typ,ProteusView v, final AppCompatActivity iioo){
        String titevd="b";
        int dourationv=0;
        int toanimatin1=0;
        int toanimatin2=0;
        int toanimatou1=0;
        int toanimatou2=0;
        if(dourationv==0){
            toanimatin1=R.anim.slide_in_from_top;
            toanimatin2=R.anim.slide_in_from_bottom;
            toanimatou1=R.anim.slide_out_to_top;
            toanimatou2=R.anim.slide_out_to_bottom;
        }
        if(dourationv==1){
            toanimatin2=R.anim.slide_in_from_top;
            toanimatin1=R.anim.slide_in_from_bottom;
            toanimatou2=R.anim.slide_out_to_top;
            toanimatou1=R.anim.slide_out_to_bottom;
        }

        if(dourationv==2){
            toanimatin1=R.anim.fab_slide_in_from_left;
            toanimatin2=R.anim.fab_slide_in_from_right;
            toanimatou1=R.anim.fab_slide_out_to_left;
            toanimatou2=R.anim.fab_slide_out_to_right;
        }
        if(dourationv==3){
            toanimatin2=R.anim.fab_slide_in_from_left;
            toanimatin1=R.anim.fab_slide_in_from_right;
            toanimatou2=R.anim.fab_slide_out_to_left;
            toanimatou1=R.anim.fab_slide_out_to_right;
        }
        Layout lll=ObjectValuex(typ,v).getAsLayout();

        Array mymessage=new Array();
        ObjectValue ggg=new ObjectValue();
        ggg.add("Message",new  Primitive(mess));
        ggg.add("Title",new  Primitive(mess+"fffffffff"));

        mymessage.add(ggg);
        ObjectValue gggc=new ObjectValue();

        gggc.add("Message",mymessage);
        ProteusView dffk = v.getViewManager().getContext().getInflater().inflate(lll, gggc);//:v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());
        //  final AppCompatActivity iioo=act;
        // final View eey=dffk.getAsView();

        CookieBar.build(iioo)
                .setCustomView(dffk.getAsView())
                .setCustomViewInitializer(new CookieBar.CustomViewInitializer() {
                    @Override
                    public void initView(View view) {

                    }
                })
                .setAction("Close", new OnActionClickListener() {
                    @Override
                    public void onClick() {
                        CookieBar.dismiss(iioo);
                    }
                })
                .setTitle("hjhjh")
                .setMessage("fgff")
                .setSwipeToDismiss(true).setEnableAutoDismiss(true)


                .setAnimationIn(toanimatin1, toanimatin2).setAnimationOut(toanimatou1, toanimatou2)

                .setDuration(5000).setCookiePosition(titevd.toLowerCase().startsWith("b") ? CookieBar.BOTTOM : CookieBar.TOP)
                .show();


    }
    public static final ALLEvent AllevtShowCokies = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {

            try {
                String eew = data.getAsObject().get("Name").getAsString().toString();//.getAsString();
                if(eew.startsWith("MM")){

                    ObjectValue ggg=new ObjectValue();



                    String eeww = data.getAsObject().get("M").getAsString().toString();
                    Value a1=new  Primitive(eeww);
                    String eewww = data.getAsObject().get("T").getAsString().toString();
                    Value a11=new  Primitive(eewww);
                    v.getViewManager().getContext().getAllEven("ShowMessageOnly").call(v.getAsView().getContext(),v.getViewManager().getContext().getActvityAllt(),data,0,v,a1,a11);

                }else {
                    Layout lll = null;
                    boolean Autodismis = false;
                    boolean Sweepdismiss = false;
                    try {

                        Autodismis = data.getAsObject().getAsBoolean("AutoDismiss");
                        Sweepdismiss = data.getAsObject().getAsBoolean("SweepDismiss");
                        lll = data.getAsObject().getAsLayout("Custome_View");
                    } catch (Exception ex) {

                    }

                    String tit = data.getAsObject().get("Title").getAsString().toString();
                    String tite = data.getAsObject().get("Message").getAsString().toString();
                    String titev = data.getAsObject().get("ColorA").getAsString().toString();
                    String colb = data.getAsObject().get("ColorB").getAsString().toString();
                    String cold = data.getAsObject().get("ColorC").getAsString().toString();
                    int douration = data.getAsObject().get("Duration").getAsInt();

                    int dourationv = data.getAsObject().get("Anim_Type").getAsInt();
                    String titevd = data.getAsObject().get("Locations").getAsString().toString();
                    Layout layy = data.getAsObject().getAsLayout("Icon");

                    ObjectValue cx=null;
                    Array getas=null;
                    try {
                        try {
                            getas = data.getAsObject().get("Set_Data").getAsArray();
                        }catch (Exception ex){

                        }
                        cx = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
                    }catch (Exception ex){

                    }
                    if(cx==null){
                        cx=new ObjectValue();
                    }

                    ProteusView dff = v.getViewManager().getContext().getInflater().inflate(layy, cx);//:v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());

                    int toanimatin1 = 0;
                    int toanimatin2 = 0;
                    int toanimatou1 = 0;
                    int toanimatou2 = 0;
                    if (dourationv == 0) {
                        toanimatin1 = R.anim.slide_in_from_top;
                        toanimatin2 = R.anim.slide_in_from_bottom;
                        toanimatou1 = R.anim.slide_out_to_top;
                        toanimatou2 = R.anim.slide_out_to_bottom;
                    }
                    if (dourationv == 1) {
                        toanimatin2 = R.anim.slide_in_from_top;
                        toanimatin1 = R.anim.slide_in_from_bottom;
                        toanimatou2 = R.anim.slide_out_to_top;
                        toanimatou1 = R.anim.slide_out_to_bottom;
                    }

                    if (dourationv == 2) {
                        toanimatin1 = R.anim.fab_slide_in_from_left;
                        toanimatin2 = R.anim.fab_slide_in_from_right;
                        toanimatou1 = R.anim.fab_slide_out_to_left;
                        toanimatou2 = R.anim.fab_slide_out_to_right;
                    }
                    if (dourationv == 3) {
                        toanimatin2 = R.anim.fab_slide_in_from_left;
                        toanimatin1 = R.anim.fab_slide_in_from_right;
                        toanimatou2 = R.anim.fab_slide_out_to_left;
                        toanimatou1 = R.anim.fab_slide_out_to_right;
                    }
                    if (lll == null) {
                        CookieBar.build(act)
                                .setTitle(tit)
                                .setTitleColor(ParseHelper.parseColor("#" + titev)).
                                setMessageColor(ParseHelper.parseColor("#" + colb))
                                .setMessage(tite).setBackgroundColor(ParseHelper.parseColor("#" + cold))
                                .setIcon(dff.getAsView().getBackground()).setSwipeToDismiss(Sweepdismiss).setEnableAutoDismiss(Autodismis)
                                .setAnimationIn(toanimatin1, toanimatin2).setAnimationOut(toanimatou1, toanimatou2)

                                .setDuration(douration).setCookiePosition(titevd.toLowerCase().startsWith("b") ? CookieBar.BOTTOM : CookieBar.TOP)
                                .setCookieListener(new CookieBarDismissListener() {

                                    @Override
                                    public void onDismiss(int dismissType) {
                                        String desc = "";
                                        switch (dismissType) {
                                            case DismissType.DURATION_COMPLETE:
                                                desc = "Cookie display duration completed";
                                                break;
                                            case DismissType.USER_DISMISS:
                                                desc = "Cookie dismissed by user";
                                                break;
                                            case DismissType.USER_ACTION_CLICK:
                                                desc = "Cookie dismissed by action click";
                                                break;
                                            case DismissType.PROGRAMMATIC_DISMISS:
                                                desc = "Cookie dismissed programmatically";
                                                break;
                                            case CookieBarDismissListener.DismissType.REPLACE_DISMISS:
                                                desc = "Replaced by new cookie";
                                                break;

                                        }


                                    }
                                })
                                .show();
                    } else {

                   /* Array mymessage = new Array();
                    ObjectValue ggg = new ObjectValue();
                 if (dataIndex==5) {
                    try {
                        String message = arguments[0].getAsString();
                        ggg.add("Message", new Primitive(message));
                        ggg.add("Title", new Primitive(eew + "fffffffff"));
                    }catch (Exception ex){

                    }
                 }
                    mymessage.add(ggg);

                   */
                        Array ew=new Array();
                        ObjectValue gggc = new ObjectValue();
                        //  arguments[0]
                        try {
                            gggc.add("Me", arguments[0]);
                        }catch (Exception ex){
                            gggc.add("Me",ew);
                        }
                        ProteusView dffk = v.getViewManager().getContext().getInflater().inflate(lll, gggc.getAsObject("Me"));//:v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());
                        final AppCompatActivity iioo = act;
                        // final View eey=dffk.getAsView();

                        CookieBar.build(iioo)
                                .setCustomView(dffk.getAsView())
                                .setCustomViewInitializer(new CookieBar.CustomViewInitializer() {
                                    @Override
                                    public void initView(View view) {

                                    }
                                })
                                .setAction("Close", new OnActionClickListener() {
                                    @Override
                                    public void onClick() {
                                        CookieBar.dismiss(iioo);
                                    }
                                })
                                .setTitle("hjhjh")
                                .setMessage("fgff")
                                .setSwipeToDismiss(Sweepdismiss).setEnableAutoDismiss(Autodismis)


                                .setAnimationIn(toanimatin1, toanimatin2).setAnimationOut(toanimatou1, toanimatou2)

                                .setDuration(douration).setCookiePosition(titevd.toLowerCase().startsWith("b") ? CookieBar.BOTTOM : CookieBar.TOP)
                                .show();


                    }
                }
            }catch (Exception ex){

                Log.e("ttt",ex.getMessage());
            }
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowCookie";
        }
    };
    public static final ALLEvent AllevtWithSetDatatwoshitstring = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();
            String  dff="0";
            try {
                dff = data.getAsObject().get("Name").getAsString();
            }catch(Exception ex){

            }


            ObjectValue da=null;
            Value  datab=null;
            try {
                if(dataIndex==5){

                    Value vm = arguments[1];

                    if(vm!=null){

                        da=vm.getAsObject();
                    }

                    datab=  data.getAsObject().get("on_select_item");
                    //for AutoCompleteTextViewB
                }else {
                    da = v.getViewManager().getDataContext().getData();
                }
            }catch(Exception ex){

            }
            try {
                datab=  data.getAsObject().get("get_set_to_view");

            }catch(Exception ex){


            }
            if(datab==null){

                datab=data;
            }
            ObjectValue cx=da;
            List<DataValueSelect> tu= datrbb(datab,act,0,0,da,"0",false);
            List<DataValueSelect> tub= datrbb(datab,act,0,0,da,"0",false);
            //Log.i("gggg","h"+tu.size());
            // ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



            Gson n=new Gson();
            Log.i("777",n.toJson(tu));
            for(ViewGroup f:rehh) {
                GetValueFromView(f, tub,2);
            }

            List<DataValueSelect>value=   getsetdata(tub,datab,v);
            Log.i("777888",n.toJson(value));


            int serach=0;
            boolean pressok=false;
            Gson g = new Gson();
            Log.e("ggggonlyxxx", "h" + g.toJson(tu));
            Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
            Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));

            //   Gson g = new Gson();

            //  Log.i("gggg","h"+g.toJson(tu));



            DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {

                    //Log.e("Cancell","ggggggggggggggmmmmmmm");

                }

                @Override
                public void dismiss() {
                    //  Log.e("dismisss","ggggggggggggggyyyy");
                }
            };

            boolean ch=true;
            if(da==null){
                ch=false;
            }
            BottomShitDaloge re=BottomShitDaloge.newInstance(ch,v.getViewManager(),dff, da,true);//.show(getFragmentManager(),"kjhhg");

            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
            ViewGroup ssep = re.getContiner();


            GetValueFromView(ssep, value,3);




        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Show_Shit_Dialog_With_Set_Data_two_from_string";
        }
    };
    public static final ALLEvent AllevtWithSetDatatwoshitstringfragmentname = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();
            String  dff="0";
            String  methodName="0";
            try {
                dff = data.getAsObject().get("Name").getAsString();
            }catch(Exception ex){

            }
            try {
                methodName= data.getAsObject().get("Methode_Name").getAsString();
            }catch(Exception ex){

            }

            ObjectValue da=null;
            Value  datab=null;
            try {
                if(dataIndex==5){

                    Value vm = arguments[1];

                    if(vm!=null){

                        da=vm.getAsObject();
                    }

                    datab=  data.getAsObject().get("on_select_item");
                    //for AutoCompleteTextViewB
                }else {
                    da = v.getViewManager().getDataContext().getData();
                }
            }catch(Exception ex){

            }
            try {
                datab=  data.getAsObject().get("get_set_to_view");

            }catch(Exception ex){


            }
            if(datab==null){

                datab=data;
            }
            ObjectValue cx=da;
            List<DataValueSelect> tu= datrbb(datab,act,0,0,da,"0",false);
            List<DataValueSelect> tub= datrbb(datab,act,0,0,da,"0",false);
            //Log.i("gggg","h"+tu.size());
            // ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



            Gson n=new Gson();
            Log.i("777",n.toJson(tu));
            for(ViewGroup f:rehh) {
                GetValueFromView(f, tub,2);
            }

            List<DataValueSelect>value=   getsetdata(tub,datab,v);
            Log.i("777888",n.toJson(value));


            int serach=0;
            boolean pressok=false;
            Gson g = new Gson();
            Log.e("ggggonlyxxx", "h" + g.toJson(tu));
            Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
            Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));

            //   Gson g = new Gson();

            //  Log.i("gggg","h"+g.toJson(tu));



            DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {

                    //Log.e("Cancell","ggggggggggggggmmmmmmm");

                }

                @Override
                public void dismiss() {
                    //  Log.e("dismisss","ggggggggggggggyyyy");
                }
            };

            boolean ch=true;
            if(da==null){
                ch=false;
            }
            Bundle args = new Bundle();
           for(DataValueSelect c:value){

               try{
               args.putString(c.getIDUnit(),c.getAnotherDatat().getAsString("GetData"));

               } catch (Exception ex) {

               }
           }



            Fragment nn=getFragmentFromClassName(dff, methodName,args);
            if(nn!=null) {
                BottomShitDcustomefragment re = BottomShitDcustomefragment.newInstance(nn);
                //   BottomShitDaloge re=BottomShitDaloge.newInstance(ch,v.getViewManager(),dff, da,true);//.show(getFragmentManager(),"kjhhg");

                // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                try {
                    ViewGroup ssep = (ViewGroup) re.getView();//.getContiner();


                    GetValueFromView(ssep, value, 3);
                } catch (Exception ex) {

                }
            }



        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Show_Shit_Dialog_With_Set_Data_two_from_name";
        }
    };

    public static final ALLEvent OpenShittyFromUrl = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v, Value... arguments) throws Exception {
            try {



                String  dff="0";
                try {
                    dff = data.getAsObject().get("Name").getAsString();
                }catch(Exception ex){

                }


                ObjectValue da=null;
                Value  datab=null;
                try {
                    if(dataIndex==5){

                        Value vm = arguments[1];

                        if(vm!=null){

                            da=vm.getAsObject();
                        }

                        datab=  data.getAsObject().get("on_select_item");
                        //for AutoCompleteTextViewB
                    }else {
                        da = v.getViewManager().getDataContext().getData();
                    }
                }catch(Exception ex){

                }
                try {
                    datab=  data.getAsObject().get("get_set_to_view");

                }catch(Exception ex){


                }
                if(datab==null){

                    datab=data;
                }
                ObjectValue cx=da;
                List<DataValueSelect> tuf= datrbb(datab,act,0,0,da,"0",false);
                List<DataValueSelect> tub= datrbb(datab,act,0,0,da,"0",false);
                //Log.i("gggg","h"+tu.size());
                // ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

                ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
                List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



                Gson n=new Gson();
                Log.i("777",n.toJson(tuf));
                for(ViewGroup f:rehh) {
                    GetValueFromView(f, tub,2);
                }

                List<DataValueSelect>value=   getsetdata(tub,datab,v);
                Log.i("777888",n.toJson(value));


                int serach=0;
                boolean pressok=false;
                Gson g = new Gson();
                Log.e("ggggonlyxxx", "h" + g.toJson(tuf));
                Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
                Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));












                Log.i("777mmm","jjjjjjjjjjjjjjjjjjjjjj@@");
                String Activityname="0";
                try{
                    Activityname=  "0";//data.getAsObject().getAsString("Name_Activity");
                }catch (Exception  ex){

                }

                List<DataValueSelect> tu= datr(data,act,0,0,"0");
                Log.i("777mmmxx","jjjjjjjjjjjjjjjjjjjjjj");
                //Log.i("gggg","h"+tu.size());
               /* ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
                List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);
                for(ViewGroup f:rehh) {
                    SerachNullValue(f, tu);
                }*/
                boolean checkks=false;

                boolean useVolley=true;

                boolean showToolbar=false;
                boolean showDrae=false;

                try
                {
                    showToolbar=data.getAsObject().getAsBoolean("Show_Toolbar");
                    showDrae=data.getAsObject().getAsBoolean("Show_Drawer");
                }catch (Exception ex){

                }
                try
                {

                    useVolley=data.getAsObject().getAsBoolean("Use_Volley");
                }catch (Exception ex){
                    Log.e("bbmmm","jjjjjjjjjjjjjjjjjjjjjjnnnnn");
                }
                if(!checkks) {
                    Log.i("777mmm","jjjjjjjjjjjjjjjjjjjjjj");
                    Value er = datr(data, tu,v);
                    Log.i("777mmm","jjjjjjjjjjjjjjjjjjjjjjiiiiiiiiiiiiiiiii");

                    Gson nn=new Gson();
                    Log.i("777mmm",nn.toJson(er));

                    ObjectValue are=new ObjectValue();
                    try {
                        ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                        v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                        are=    data.getAsObject().getAsObject("After_Process");
                    }catch (Exception ex){
                        Log.i("777mmmTT",nn.toJson(er));
                    }
                    //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);

                    new AsyncTaskRunnervFromUrlshit(er, v, are,useVolley,showToolbar,showDrae,Activityname,value,da).execute();

                }








            }catch (Exception ex){
                Log.e("777", ex.getMessage());
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Show_Shit_Dialog_With_Set_Data_two_from_url";
        }
    };

    public static final ALLEvent AllevtWithSetDatatwoshit = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();
            String  dff="0";
            try {
                dff = data.getAsObject().get("Name").getAsString();
            }catch(Exception ex){

            }


            ObjectValue da=null;
            Value  datab=null;
            try {
                if(dataIndex==5){

                    Value vm = arguments[1];

                    if(vm!=null){

                        da=vm.getAsObject();
                    }

                    datab=  data.getAsObject().get("on_select_item");
                    //for AutoCompleteTextViewB
                }else {
                    da = v.getViewManager().getDataContext().getData();
                }
            }catch(Exception ex){

            }
            try {
                datab=  data.getAsObject().get("get_set_to_view");

            }catch(Exception ex){


            }
            if(datab==null){

                datab=data;
            }
            ObjectValue cx=da;
            List<DataValueSelect> tu= datrbb(datab,act,0,0,da,"0",false);
            List<DataValueSelect> tub= datrbb(datab,act,0,0,da,"0",false);
            //Log.i("gggg","h"+tu.size());
            // ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



            Gson n=new Gson();
            Log.i("777",n.toJson(tu));
            for(ViewGroup f:rehh) {
                GetValueFromView(f, tub,2);
            }

            List<DataValueSelect>value=   getsetdata(tub,datab,v);
            Log.i("777888",n.toJson(value));


            int serach=0;
            boolean pressok=false;
            Gson g = new Gson();
            Log.e("ggggonlyxxx", "h" + g.toJson(tu));
            Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
            Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));

            //   Gson g = new Gson();

            //  Log.i("gggg","h"+g.toJson(tu));



            DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {

                    //Log.e("Cancell","ggggggggggggggmmmmmmm");

                }

                @Override
                public void dismiss() {
                    //  Log.e("dismisss","ggggggggggggggyyyy");
                }
            };

            boolean ch=true;
            if(da==null){
                ch=false;
            }
            BottomShitDaloge re=BottomShitDaloge.newInstance(ch,v.getViewManager(),dff, da,false);//.show(getFragmentManager(),"kjhhg");

            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
            ViewGroup ssep = re.getContiner();


            GetValueFromView(ssep, value,3);




        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Show_Shit_Dialog_With_Set_Data_two";
        }
    };

    public static final ALLEvent AllevtshitWithdat = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=;

            //  Value val=data.getAsObject().get("dff");
            String  dff=data.getAsObject().get("Name").getAsString();//.isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),new ObjectValue()):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());

            ObjectValue dataset=null;
            try{
                dataset=data.getAsObject().get("Data_Value").getAsObject();
            }catch (Exception ex){

            }


            boolean ch=true;
            if(dataset==null){
                ch=false;
            }
            BottomShitDaloge re=BottomShitDaloge.newInstance(ch,v.getViewManager(),dff,dataset,false);//.show(getFragmentManager(),"kjhhg");

            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
            // tr.setCancelable(false);
            // tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),data.getAsObject().get("Name").toString());

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowShitDialogSetData";
        }
    };


    public static final ALLEvent AllevtshitWithdatfromString = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=;

            //  Value val=data.getAsObject().get("dff");
            String  dff=data.getAsObject().get("Name").getAsString();//.isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),new ObjectValue()):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());

            ObjectValue dataset=null;
            try{
                dataset=data.getAsObject().get("Data_Value").getAsObject();
            }catch (Exception ex){
                ObjectValue cx=null;
                Array getas=null;
                try {
                    try {
                        getas = data.getAsObject().get("Set_Data").getAsArray();
                    }catch (Exception exk){

                    }
                    dataset = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
                }catch (Exception exm){

                }


            }


            boolean ch=true;
            if(dataset==null){
                ch=false;
            }
            BottomShitDaloge re=BottomShitDaloge.newInstance(ch,v.getViewManager(),dff,dataset,true);//.show(getFragmentManager(),"kjhhg");
            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
            // tr.setCancelable(false);
            // tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),data.getAsObject().get("Name").toString());

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowShitDialog_From_String";
        }
    };
    public static final ALLEvent Allevtshit = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            //  String eew=data.getAsObject().get("Name").getAsString();

            String  dff=data.getAsObject().get("Name").getAsString();//.isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),new ObjectValue()):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());

            ObjectValue dataset=null;
            try{
                dataset=data.getAsObject().get("Data_Value").getAsObject();
            }catch (Exception ex){

            }


            boolean ch=true;
            if(dataset==null){
                ch=false;
            }
            BottomShitDaloge re=BottomShitDaloge.newInstance(ch,v.getViewManager(),dff,dataset,false);//.show(getFragmentManager(),"kjhhg");
            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowShitDialog";
        }
    };
//



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


    private static void setallvalshoww(List<DataValueSelect> tu,ObjectValue datab){


        Iterator<Map.Entry<String, Value>> rr=   datab.entrySet().iterator();
        while (rr.hasNext()){
            Map.Entry<String, Value> valdat=rr.next();

            for(DataValueSelect f:tu) {
                //if(f.getDataGet().startsWith("#")) {
                if (f.getDataGet().equals(valdat.getKey())) {
                    String getdat = valdat.getValue().toString();

                    f.setDataGet(getdat);
                    // }
                }
            }

        }

    }
    private static void setallvalshow(List<DataValueSelect> tu,Value datab){


        Iterator<Map.Entry<String, Value>> rr=   datab.getAsObject().entrySet().iterator();
        while (rr.hasNext()){
            Map.Entry<String, Value> valdat=rr.next();

            for(DataValueSelect f:tu) {
                //if(f.getDataGet().startsWith("#")) {
                if (f.getDataGet().equals(valdat.getKey())) {
                    String getdat = valdat.getValue().toString();

                    f.setDataGet(getdat);
                    // }
                }
            }

        }

    }
    private void setPloyices(CustomStringRequest rrrr){
        rrrr.setRetryPolicy(new DefaultRetryPolicy(GlobalClass.time_out * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
    private static void setPloyicess(CustomStringRequest rrrr){
        rrrr.setRetryPolicy(new DefaultRetryPolicy(GlobalClass.time_out * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
    private static ObjectValue setallvalshokw(Value datab,Array ar){


        ObjectValue ob=new ObjectValue();
        try {
            Iterator<Map.Entry<String, Value>> rr = datab.getAsObject().entrySet().iterator();
            while (rr.hasNext()) {
                Map.Entry<String, Value> valdat = rr.next();

                ob.add(valdat.getKey(), valdat.getValue());


            }
            //  return ob;
        }catch (Exception ex){

        }

        //  ObjectValue obb=setallvalshow(v.getViewManager().getDataContext().getData());
        if(ar!=null) {
            // Array getas=data.getAsObject().get("Set_Data").getAsArray();
            ob.add("Set_Data", ar);
        }
        return  ob;
    }


    public static final ALLEvent AllevtWithSetDatab = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();




            Array getas = data.getAsObject().get("Set_Data").getAsArray();
            // Array getas=data.getAsObject().get("Get_Data_Froms").getAsArray();
            ObjectValue cx=null;
            try {
                cx = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
            }catch (Exception ex){

            }
            if(cx==null){
                cx=new ObjectValue();
            }

            try {
                //   Log.e("gggg","h"+ex.getMessage());

                // Log.e("gggg", "hhhhhm");
                List<DataValueSelect> tu = BeforprocessSetDataWith(getas, cx, false);
                Gson g = new Gson();

                Log.e("ggggonlyxxx", "h" + g.toJson(tu));
                Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
                Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));

                ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
                List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
                for (ViewGroup f : rehh) {
                    SerachNullValue(f, tu);
                }
            } catch (Exception ex) {
                //  Log.e("gggg", "h" + ex.getMessage());
            }





        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Set_Data_From_View_To_Vieww";
        }
    };


    public static final ALLEvent AllevtWithSetDatac = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();
            Array getas=data.getAsObject().get("Set_Data").getAsArray();
            ObjectValue cx=null;
            try {
                cx = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
            }catch (Exception ex){

            }
            if(cx==null){
                cx=new ObjectValue();
            }
//Log.e("7yy",eew);


            int serach=0;
            boolean pressok=false;
            ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            List<DataValueSelect> tu = Beforprocessk(getas);
            if(arguments.length!=0) {
                Value datab = arguments[0];
                setallvalshow(tu, datab);
            }
            //   Gson g = new Gson();

            //  Log.i("gggg","h"+g.toJson(tu));
            ViewGroup sse = (ViewGroup) dff.getAsView();

            SerachNullValue(sse, tu);
            DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {

                    //Log.e("Cancell","ggggggggggggggmmmmmmm");

                }

                @Override
                public void dismiss() {
                    //  Log.e("dismisss","ggggggggggggggyyyy");
                }
            };



        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "With_Set_Data";
        }
    };

    public static final ALLEvent AllevtWithSetData = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();




            Array getas=data.getAsObject().get("Set_Data").getAsArray();
            ObjectValue cx=null;
            try {
                cx = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
            }catch (Exception ex){

            }
            if(cx==null){
                cx=new ObjectValue();
            }

            int serach=0;
            boolean pressok=false;
            ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            List<DataValueSelect> tu = Beforprocessk(getas);
            if(arguments.length!=0) {
                Value datab = arguments[0];
                setallvalshow(tu, datab);
            }
            Gson g = new Gson();
            Log.e("ggggonlyxxx", "h" + g.toJson(tu));
            Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
            Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));

            //   Gson g = new Gson();

            //  Log.i("gggg","h"+g.toJson(tu));
            ViewGroup sse = (ViewGroup) dff.getAsView();

            SerachNullValue(sse, tu);
            DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {

                    //Log.e("Cancell","ggggggggggggggmmmmmmm");

                }

                @Override
                public void dismiss() {
                    //  Log.e("dismisss","ggggggggggggggyyyy");
                }
            };

            DalogeFragment tr=new DalogeFragment(dff,iio,serach,pressok);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),data.getAsObject().get("Name").toString());


        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Show_Dialog_With_Set_Data";
        }
    };
    public static final ALLEvent AllevtWithSetDatatwo = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            // String eew=data.getAsObject().get("Name").getAsString();

            ObjectValue da=null;
            Value  datab=null;
            try {
                if(dataIndex==5){

                    Value vm = arguments[1];

                    if(vm!=null){

                        da=vm.getAsObject();
                    }

                    datab=  data.getAsObject().get("on_select_item");
                    //for AutoCompleteTextViewB
                }else {
                    da = v.getViewManager().getDataContext().getData();
                }
            }catch(Exception ex){

            }
            try {
                datab=  data.getAsObject().get("get_set_to_view");

            }catch(Exception ex){


            }
            if(datab==null){

                datab=data;
            }
            ObjectValue cx=da;
            List<DataValueSelect> tu= datrbb(datab,act,0,0,da,"0",false);
            List<DataValueSelect> tub= datrbb(datab,act,0,0,da,"0",false);
            //Log.i("gggg","h"+tu.size());
            ProteusView dff=data.getAsObject().get("Name").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),cx);

            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



            Gson n=new Gson();
            Log.i("777",n.toJson(tu));
            for(ViewGroup f:rehh) {
                GetValueFromView(f, tub,2);
            }

            List<DataValueSelect>value=   getsetdata(tub,datab,v);
            Log.i("777888",n.toJson(value));
            ViewGroup ssep = (ViewGroup) dff.getAsView();


            GetValueFromView(ssep, value,3);

            int serach=0;
            boolean pressok=false;
            Gson g = new Gson();
            Log.e("ggggonlyxxx", "h" + g.toJson(tu));
            Log.e("ggggonlyxxxii", "h" + g.toJson(cx));
            Log.e("ggggonlyxxx", "h" + g.toJson(v.getViewManager().getDataContext().getData()));

            //   Gson g = new Gson();

            //  Log.i("gggg","h"+g.toJson(tu));



            DialogInterface iio=new DialogInterface() {
                @Override
                public void cancel() {

                    //Log.e("Cancell","ggggggggggggggmmmmmmm");

                }

                @Override
                public void dismiss() {
                    //  Log.e("dismisss","ggggggggggggggyyyy");
                }
            };

            DalogeFragment tr=new DalogeFragment(dff,iio,serach,pressok);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),data.getAsObject().get("Name").toString());


        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Show_Dialog_With_Set_Data_two";
        }
    };

    public static final ALLEvent AllevtWithSetrData = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            //  String eew=data.getAsObject().get("Name").getAsString();


            try {
                // Log.e("ggggmmmm","h");
                if(dataIndex==10){
                    try {
                        // Log.e("gggg","h");
                        String results=  arguments[0].getAsString();

                        //   Log.e("gggg",results);
                        Array getas = data.getAsObject().get("Set_Data").getAsArray();
                        // Log.e("gggg", "hhhhhm");
                        List<DataValueSelect> tu = BeforprocessSetDataWith(getas, null, false);
                        for(DataValueSelect fg:tu){
                            fg.setDataGet(fg.getDataGet().replace("#@",results));
                        }

                        Gson g = new Gson();

                        //Log.e("gggg", "h" + g.toJson(tu));
                        ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
                        List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
                        for (ViewGroup f : rehh) {
                            SerachNullValue(f, tu);
                        }
                    } catch (Exception ex) {
                        Log.e("gggg", "h" + ex.getMessage());
                    }

                }else {
                    // Log.e("gggg", "h");
                    if (arguments.length > 1) {


                        // Log.e("gggg", "hmmmm");
                        Array getas = arguments[0].getAsArray();
                        Value getasm = arguments[1];
                        Gson g = new Gson();

                        List<DataValueSelect> tu = BeforprocessSetDataWith(getas, getasm, true);
                        // Gson g = new Gson();

                        //    Log.i("gggg","h"+g.toJson(tu));
                        ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
                        List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
                        for (ViewGroup f : rehh) {
                            SerachNullValue(f, tu);
                        }


                    } else {
                        try {
                            //   Log.e("gggg","h"+ex.getMessage());
                            Array getas = data.getAsObject().get("Set_Data").getAsArray();
                            // Log.e("gggg", "hhhhhm");
                            List<DataValueSelect> tu = BeforprocessSetDataWith(getas, null, false);
                            Gson g = new Gson();

                            Log.e("ggggonly", "h" + g.toJson(tu));
                            ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
                            List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
                            for (ViewGroup f : rehh) {
                                SerachNullValue(f, tu);
                            }
                        } catch (Exception ex) {
                            //  Log.e("gggg", "h" + ex.getMessage());
                        }
                    }
                }
            }catch (Exception ex){
                Log.e("gggg", "h" + ex.getMessage());
            }
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Set_Data_Only";
        }
    };


    public static List<DataValueSelect> getsetvals(AppCompatActivity act,ObjectValue data,ObjectValue da,int tot,int tot2,String search){
        Value  datab=null;
        try {
            datab=  data.getAsObject().get("get_set_to_view");

        }catch(Exception ex){


        }
        if(datab==null){

            datab=data;
        }

        List<DataValueSelect> tu= datrbb(datab,act,tot,tot2,da,"0",false);
        List<DataValueSelect> tub= datrbb(datab,act,tot,tot2,da,"0",false);
        //Log.i("gggg","h"+tu.size());
        ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
        List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



        Gson n=new Gson();
        Log.i("777",n.toJson(tu));
        for(ViewGroup f:rehh) {
            GetValueFromView(f, tub,2);
        }
        return tub;

    }
    public static Value[] arguments (@NonNull String args, Context context, @NonNull FunctionManager manager,ObjectValue Da) {

        String[] tokens = FUNCTION_ARGS_DELIMITER.split(args);
        Value[] arguments = new Value[tokens.length];
        String token;
        Value resolved;
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i].trim();
            if(token.startsWith("#")){
              String c= token.substring(2,token.length()-1);//.replace('{',' ');
                resolved=getvalueFromStringquerys(Da,c);
            }
            else if (!token.isEmpty() && token.charAt(0) == '\'') {
                token = token.substring(1, token.length() - 1);
                resolved = new Primitive(token);
            } else {
                resolved = AttributeProcessor.staticPreCompile(new Primitive(token), context, manager);
            }
            arguments[i] = resolved != null ? resolved : new Primitive(token);
        }
        return  arguments;
    }
    public static Value getvalueFromStringquerys(ObjectValue tempp,String keyselect){
        try {

            Value resul=null;
            String[] resull=keyselect.split("\\.");
            for(int z=0;z<resull.length;z++){
                try {
                    if (resull[z].endsWith("]")) {
                        String resum = resull[z];
                        if (resul != null) {
                            try {


                                String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                int x = resum.length() - nanmm.length();

                                String nameonly = resum.substring(0, x);
                                String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                int getintt = Integer.parseInt(gett);
                                resul = resul.getAsObject().getAsArray(nameonly).get(getintt);

                            } catch (Exception ex) {

                            }
                        } else {
                            try {
                                String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                int x = resum.length() - nanmm.length();
                                String nameonly = resum.substring(0, x);
                                String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                int getintt = Integer.parseInt(gett);
                                resul = tempp.get(nameonly).getAsArray().get(getintt);
                            } catch (Exception ex) {

                            }
                        }
                    } else {
                        String resum = resull[z];
                        if (resul == null) {
                            ;
                            if (resum.endsWith("]")) {
                                try {
                                    String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                    int x = resum.length() - nanmm.length();
                                    String nameonly = resum.substring(0, x);
                                    String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                    int getintt = Integer.parseInt(gett);
                                    resul = tempp.get(nameonly).getAsArray().get(getintt);
                                } catch (Exception ex) {

                                }
                            } else {
                                //  String resulx = resum.substring(resum.indexOf("[") + 1, resum.indexOf("]"));
                                resul = tempp.get(resull[z]);
                            }
                        } else {
                            try {
                                if (resum.endsWith("]")) {
                                    try {
                                        String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                        int x = resum.length() - nanmm.length();
                                        String nameonly = resum.substring(0, x);
                                        String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                        int getintt = Integer.parseInt(gett);
                                        resul = resul.getAsObject().getAsArray(nameonly).get(getintt);
                                    } catch (Exception ex) {

                                    }
                                } else {
                                    //  String resulx = resum.substring(resum.indexOf("[") + 1, resum.indexOf("]"));
                                    if (resul.getAsObject().isPrimitive(resum)) {
                                        resul = resul.getAsObject().get(resum);
                                    } else {

                                        resul = resul.getAsObject().get(resum);
                                    }
                                }
                            } catch (Exception ex) {

                            }
                        }
                    }
                }catch (Exception ex){

                }
            }
            try {
                if(resul!=null) {
                    if (resul.isArray()) {
                        resul = resul.getAsArray();
                    }
                    if (resul.isObject()) {
                        resul = resul.getAsObject();
                    }
                    if (resul.isPrimitive()) {
                        resul = new Primitive(resul.toString());
                    }
                }else{
                    resul=tempp;
                }
            }catch (Exception ex){


            }

            return resul;
        }catch (Exception ex){
            Log.e("f555xxx",ex.getMessage());
        }


        Array er=new Array();
        return  er;
    }

    public static Value valuefromfunction(String value,ProteusView v,Value Dataa)  {

        Log.e("ffvvib","iiiiiiiiiiiibbbbbbbbbbbbbbbbbbbbbbbb");


        Matcher matcher = BINDING_PATTERNN.matcher(value);
        if (matcher.find()) {

          String namefunction=  matcher.group(1);

try {

    Value[] argumentsv = arguments(matcher.group(2), v.getAsView().getContext(), v.getViewManager().getContext().getFunctionManager(),Dataa.getAsObject());
    Value tr = v.getViewManager().getContext().getFunction(namefunction).call(v.getAsView().getContext(), Dataa, 0, argumentsv);
    return tr;
}catch (Exception er){
    Log.e("ffvvib","iiiiiiiiiiiibbbbbbbbbbbbbbbbbbbbbbbb"+er.getMessage());
    return new Primitive(value);
}

        } else {
            return null;
        }
    }
    public static final ALLEvent ChecknullT = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {




            ObjectValue da=null;
            Value  datab=null;
            try {
                if(dataIndex==5){

                    Value vm = arguments[1];

                    if(vm!=null){

                        da=vm.getAsObject();
                    }

                    datab=  data.getAsObject().get("on_select_item");
                    //for AutoCompleteTextViewB
                }else {
                    da = v.getViewManager().getDataContext().getData();
                }
            }catch(Exception ex){

            }
            try {
                datab=  data.getAsObject().get("get_set_to_view");

            }catch(Exception ex){


            }
            if(datab==null){

                datab=data;
            }
            List<DataValueSelect> tu= datrbb(datab,act,0,0,da,"0",false);
            List<DataValueSelect> tub= datrbb(datab,act,0,0,da,"0",false);
            //Log.i("gggg","h"+tu.size());
            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);



            Gson n=new Gson();
            Log.i("777",n.toJson(tu));
            for(ViewGroup f:rehh) {
                GetValueFromView(f, tub,2);
            }

            List<DataValueSelect>value=   getsetdata(tub,datab,v);
            Log.i("777888",n.toJson(value));


            for(ViewGroup f:rehh) {
                GetValueFromView(f, value,3);
            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Set_Data_From_View_To_View";
        }
    };

    public static String getBeforOrafetrEven(){


        return "Set_Data_From_View_To_View";
    }
    public static final ALLEvent Checknull = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {

            List<DataValueSelect> tu= datr(data,act,0,0,"0");
            //Log.i("gggg","h"+tu.size());

            boolean checkks=checknul(tu);
            if(!checkks) {
                Value er = datr(data, tu,v);


                Gson n=new Gson();
                Log.i("777",n.toJson(er));

                Array are=new Array();
                try {
                    ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                    v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                    are=    data.getAsObject().getAsArray("After_Process");
                }catch (Exception ex){

                }
                //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);

                new AsyncTaskRunnerv(er, v, are).execute();

            }
            //Gson sss=new Gson();
            //  Log.i("777",sss.toJson(we));
          /*  String eew=data.getAsObject().get("Name").getAsString();
            ProteusView dff=v.getViewManager().getContext().getInflater().inflate(eew,new ObjectValue());
            DalogeFragment tr=new DalogeFragment(dff);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
*/
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "CheckNull";
        }
    };
    public static final ALLEvent Allevtshitk = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            //  String eew=data.getAsObject().get("Name").getAsString();

            String  dff=data.getAsObject().get("Name").getAsString();//.isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsLayout(),new ObjectValue()):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Name").getAsString(),new ObjectValue());

            ObjectValue dataset=null;
            try{
                dataset=data.getAsObject().get("Data_Value").getAsObject();
            }catch (Exception ex){

            }


            boolean ch=true;
            if(dataset==null){
                ch=false;
            }
            com.astooltech.advancedview.finaldemo.fragments.BottomShitDaloge re= com.astooltech.advancedview.finaldemo.fragments.BottomShitDaloge.newInstance(ch,v.getViewManager(),dff,dataset,false);//.show(getFragmentManager(),"kjhhg");
            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
            re.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "ShowShitDialogkk";
        }
    };

    public static final ALLEvent SendAll = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, final AppCompatActivity act, final Value data, int dataIndex, final ProteusView v, Value... arguments) throws Exception {

            List<DataValueSelect> tu= datr(data,act,0,0,"0");
            //Log.i("gggg","h"+tu.size());
            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);
            for(ViewGroup f:rehh) {
                SerachNullValue(f, tu);
            }
            boolean checkks=checknul(tu);
            if(!checkks) {
                Value er = datr(data, tu,v);


                Gson n=new Gson();
                // Log.i("777",n.toJson(er));

                boolean showconfirm=false;
                ProteusView confirms=null;
                boolean useVolley=false;

                try
                {
                    useVolley=data.getAsObject().getAsBoolean("Use_Volley");
                }catch (Exception ex){

                }
                final   boolean useVolleyy=useVolley;
                try {
                    ObjectValue cx=null;
                    Array getas=null;
                    try {
                        try {
                            getas = data.getAsObject().get("Set_Data").getAsArray();
                        }catch (Exception ex){

                        }
                        cx = setallvalshokw(v.getViewManager().getDataContext().getData(), getas);
                    }catch (Exception ex){

                    }
                    if(cx==null){
                        cx=new ObjectValue();
                    }
                    confirms=data.getAsObject().get("Show_Confirm").isLayout()?v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Show_Confirm").getAsLayout(),cx):v.getViewManager().getContext().getInflater().inflate(data.getAsObject().get("Show_Confirm").getAsString(),cx);

                    // Layout ShowConfirm = data.getAsObject().getAsLayout("Show_Confirm");
                }catch (Exception ex){

                }
                ObjectValue are=new  ObjectValue();
                try {
                    //  Array ar = data.getAsObject().getAsArray("Before_Process");



                    //closedilogecancel
                    if( confirms==null) {

                        ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                        v.getViewManager().getContext().getAllEven( getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                        // v.getViewManager().getContext().getAllEven("Before_Process").call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);

                        are = data.getAsObject().getAsObject("After_Process");
                    }
                }catch (Exception ex){

                }
                final Value deri=data;
                final ProteusView ddf=v;
                final  Value qqq=er;
                int srearchh=0;
                boolean pressok=false;
                //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);
                DialogInterface iio=new DialogInterface() {

                    int ccc=0;
                    @Override
                    public void cancel() {
                        //   Log.e("Cancell","ggggggggggggggmmmmmmm");
                        Array aare=new Array();
                        try {
                            // v.getViewManager().getContext().getAllEven("Before_Process").call(v.getAsView().getContext(), act, qqq, 0, v);
                            // aare = data.getAsObject().getAsArray("After_Process");
                            ccc=1;
                        }catch (Exception ex){
//Log.e("ddddd",ex.getMessage());
                        }
                        //  new AsyncTaskRunnervFromUrlSaveTo(qqq, v, aare).execute();
                    }

                    @Override
                    public void dismiss() {
                        if(ccc==1) {
                            try {
                                // Array ar = data.getAsObject().getAsArray("Before_Process");
                                //  v.getViewManager().getContext().getAllEven("Before_Process").call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);
                                ObjectValue ar = data.getAsObject().getAsObject("Before_Process");

                                v.getViewManager().getContext().getAllEven( getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);


                            } catch (Exception ex) {

                            }
                            ObjectValue arex = new ObjectValue();
                            try {
                                arex  = data.getAsObject().getAsObject("After_Process");
                            } catch (Exception ex) {

                            }
                            new AsyncTaskRunnervFromUrlSaveTo(qqq, v, arex,useVolleyy).execute();
                            //  Log.e("dismisss", "ggggggggggggggyyyy");

                        }
                    }
                };
                if( confirms!=null) {

                    ViewGroup ssek = (ViewGroup) confirms.getAsView();
                    String nams="noooo";
                    List<Layout.Attribute> re=    confirms.getViewManager().getLayout().attributes;
                    Iterator<Layout.Attribute> w=re.iterator();
                    while (w.hasNext()){
                        Layout.Attribute q=w.next();
                        if(q.keyname.equals(Attributes.View.primarydata)){

                            nams=q.value.getAsString();
                        }

                    }

                    // SerachNullValue(ssek, tu);
                    DalogeFragment tr=new DalogeFragment(confirms,iio,srearchh,pressok);

                    tr.setCancelable(false);
                    //while ()
                    tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),nams);
                }
                try {
                    if(confirms!=null) {
                      /*  Handler bh=new Handler();
                        Runnable dds=new Runnable() {
                            @Override
                            public void run() {
                                if (srearchh == 1) {

                                }
                            }
                        };
                        bh.postDelayed(dds,5000);*/
                     /*   while (true) {
                            Thread.sleep(5000);
                            if (srearchh == 1) {

                                srearchh=0;
                                if (pressok) {
                                    try {
                                        Array ar = data.getAsObject().getAsArray("Before_Process");
                                        v.getViewManager().getContext().getAllEven("Before_Process").call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), ar, 0, v);
                                    }catch (Exception ex){

                                    }
                                        are = data.getAsObject().getAsArray("After_Process");
                                    new AsyncTaskRunnervFromUrlSaveTo(er, v, are).execute();


                                }
                                break;
                            }
                        }*/
                    }
                }catch (Exception ex){

                }
                if( confirms==null) {
                    new AsyncTaskRunnervFromUrlSaveTo(er, v, are,useVolley).execute();
                }

            }
            //Gson sss=new Gson();
            //  Log.i("777",sss.toJson(we));
          /*  String eew=data.getAsObject().get("Name").getAsString();
            ProteusView dff=v.getViewManager().getContext().getInflater().inflate(eew,new ObjectValue());
            DalogeFragment tr=new DalogeFragment(dff);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
*/
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "SendAll";
        }
    };


    private static boolean checknul(List<DataValueSelect> t){
        List<Boolean> dss=new ArrayList<>();
        Iterator<DataValueSelect> ert=t.iterator();
        while (ert.hasNext()){
            DataValueSelect ty=ert.next();

            if(ty.isChecknull()){
                dss.add(true);
            }

        }
        if(dss.size()==0){
            return false;
        }else {

            return  true;
        }
    }
    public static final ALLEvent AffterProcess = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {

            List<DataValueSelect> tu= Beforprocess(data);
            Gson g=new Gson();

            Log.i("gggg","h"+g.toJson(tu));
            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);
            for(ViewGroup f:rehh) {
                SerachNullValue(f, tu);
            }

            //   Value er=     datr(data,tu);
            //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);

            // new AsyncTaskRunnerv(er,v).execute();*/
            //Gson sss=new Gson();
            //  Log.i("777",sss.toJson(we));
          /*  String eew=data.getAsObject().get("Name").getAsString();
            ProteusView dff=v.getViewManager().getContext().getInflater().inflate(eew,new ObjectValue());
            DalogeFragment tr=new DalogeFragment(dff);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
*/
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "After_Process";
        }
    };
    public static final ALLEvent BeforProcess = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {

            List<DataValueSelect> tu= Beforprocess(data);

            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);
            for(ViewGroup f:rehh) {
                SerachNullValue(f, tu);
            }


        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Before_Process";
        }
    };

    public static final ALLEvent SetDataToview = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            if(dataIndex==0) {
                List<DataValueSelect> tu = BeforprocessSetData(arguments[0], arguments[1]);
                Gson g = new Gson();

                //  Log.i("gggg","h"+g.toJson(tu));
                ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
                List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
                for (ViewGroup f : rehh) {
                    SerachNullValue(f, tu);
                }
            }else {
                List<DataValueSelect> tu = Beforprocessk(arguments[0]);
                Gson g = new Gson();

                //  Log.i("gggg","h"+g.toJson(tu));
                ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
                List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
                for (ViewGroup f : rehh) {
                    SerachNullValue(f, tu);
                }

            }

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Set_Data";
        }
    };


    public static final ALLEvent OpenFragment = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {

            List<DataValueSelect> tu =new ArrayList<>(); //BeforprocessSetData(arguments[0], arguments[1]);
            DataValueSelect ttt=new DataValueSelect();
            String   wwe=  data.getAsObject().get("Fragment_Name").getAsString();
            String   wwey=  data.getAsObject().get("Fragment_Container").getAsString();
            ttt.setDataGet(wwe);
            ttt.setIDUnit(wwey);
            ttt.setTypselect("10");
            ttt.setIdexid(0);
            setvalue(data,ttt);
            tu.add(ttt);



            //  Log.i("gggg","h"+g.toJson(tu));
            ViewGroup sse = (ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup> rehh = closedilogee(act.getSupportFragmentManager(), sse);
            for (ViewGroup f : rehh) {
                SerachNullValue(f, tu);
            }

            //   Value er=     datr(data,tu);
            //    Map<String, List<hedaerOrQuary>> we=    getvaluuusHeder(er,1);

            // new AsyncTaskRunnerv(er,v).execute();*/
            //Gson sss=new Gson();
            //  Log.i("777",sss.toJson(we));
          /*  String eew=data.getAsObject().get("Name").getAsString();
            ProteusView dff=v.getViewManager().getContext().getInflater().inflate(eew,new ObjectValue());
            DalogeFragment tr=new DalogeFragment(dff);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
*/
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Open_Fragment";
        }
    };


    public static final ALLEvent findViewByID = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {


            String eew=data.getAsObject().get("Name").getAsString();
//int iid=act.getResources().getIdentifier(eew,"id",act.getPackageName());


            Toast.makeText(act.getApplicationContext(),v.getViewManager().findViewById(eew).getClass().getName(),Toast.LENGTH_LONG).show();
            /*List<DataValueSelect> tu= datr(data);
            Log.i("gggg","h"+tu.size());
            ViewGroup sse =(ViewGroup) act.getWindow().getDecorView();
            List<ViewGroup>  rehh=   closedilogee(act.getSupportFragmentManager(),sse);
            for(ViewGroup f:rehh) {
                SerachNullValue(act, f, tu);
            }*/
          /*  String eew=data.getAsObject().get("Name").getAsString();
            ProteusView dff=v.getViewManager().getContext().getInflater().inflate(eew,new ObjectValue());
            DalogeFragment tr=new DalogeFragment(dff);
            tr.setCancelable(false);
            tr.show(v.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(),eew);
*/
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "FindID";
        }
    };
    public static final ALLEvent snakbar= new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {


            String eew=data.getAsObject().get("message").getAsString();
//int iid=act.getResources().getIdentifier(eew,"id",act.getPackageName());
            Snackbar.make(act.getWindow().getDecorView() , eew, Snackbar.LENGTH_SHORT).show();

            // Toast.makeText(act.getApplicationContext(),v.getViewManager().findViewById(eew).getClass().getName(),Toast.LENGTH_LONG).show();

        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "Snackbar";
        }
    };


    private static String getdatafrom(String textt,AppCompatActivity act){


        SharedPreferences settings =act.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


    }

    private static void Befor_Process(Value f){

    }
    private static void After_Process(){

    }
    private static void finish_Process(){

    }
    private static void getvalueonly(DataValueSelect inn,List<DataValueSelect> datf,ObjectValue objval,ProteusView v,Value dag){

        boolean checkvalu=false;

        try {

            boolean checkfoundformat = false;
            String useformat = "index";
            String function = "0";
            try {
                useformat = objval.getAsObject().get("use_format").getAsString();
                if (useformat.toLowerCase().equals("true")) {
                    useformat = "format";
                    function = objval.getAsObject().get("key_Value").getAsString();
                } else if (useformat.toLowerCase().equals("false")) {
                    useformat = "index";
                } else if (useformat.toLowerCase().equals("function")) {
                    useformat = "function";
                    function = objval.getAsObject().get("key_Value").getAsString();
                } else if (useformat.toLowerCase().equals("format")) {
                    useformat = "format";
                    function = objval.getAsObject().get("key_Value").getAsString();
                } else {
                    useformat = "index";
                }
                checkfoundformat = true;


            } catch (Exception ex) {


            }
            if (useformat.equals("function")) {


                ObjectValue val = new ObjectValue();
                Iterator<Map.Entry<String, Value>> uuo = objval.entrySet().iterator();
                while (uuo.hasNext()) {
                    // Log.i("8888", "hjhjhjhjh");
                    Map.Entry<String, Value> qqe = uuo.next();
                    try {
                        if (qqe.getKey().toLowerCase().equals("view_id")) {
                            inn.setIDUnit(qqe.getValue().getAsString());
                            inn.setUnitName(qqe.getValue().getAsString());
                            val.add("ViewId", qqe.getValue());

                        } else if (qqe.getKey().toLowerCase().equals("view_type")) {
                            val.add("Type", qqe.getValue());
                            inn.setTypselect(qqe.getValue().getAsString());
                        } else if (qqe.getKey().toLowerCase().equals("index_id")) {
                            val.add("index_id", qqe.getValue());
                            inn.setIdexid(qqe.getValue().getAsInt());
                        } else {
                            val.add(qqe.getKey().toLowerCase(), qqe.getValue());

                        }
                    } catch (Exception ex) {
                        Log.e("excepvalue", ex.getMessage());
                    }

                }

                Value va = valuefromfunction(function, v, dag);
                if (va != null) {

                    val.add("GetData", va);
                } else {
                    val.add("GetData", new Primitive("not found function"));
                }
                inn.setAnotherDatat(val);

            }else
            if(useformat.equals("index")){

                int indexid=0;
                ObjectValue val = new ObjectValue();
                Iterator<Map.Entry<String, Value>> uuo = objval.entrySet().iterator();
                while (uuo.hasNext()) {
                    // Log.i("8888", "hjhjhjhjh");
                    Map.Entry<String, Value> qqe = uuo.next();
                    try {
                        if (qqe.getKey().toLowerCase().equals("view_id")) {
                            inn.setIDUnit(qqe.getValue().getAsString());
                            inn.setUnitName(qqe.getValue().getAsString());
                            val.add("ViewId", qqe.getValue());

                        } else if (qqe.getKey().toLowerCase().equals("view_type")) {
                            val.add("Type", qqe.getValue());
                            inn.setTypselect(qqe.getValue().getAsString());
                        } else if (qqe.getKey().toLowerCase().equals("index_id")) {
                            val.add("index_id", qqe.getValue());
                            indexid=qqe.getValue().getAsInt();
                            inn.setIdexid(qqe.getValue().getAsInt());
                        } else {
                            val.add(qqe.getKey().toLowerCase(), qqe.getValue());

                        }
                    } catch (Exception ex) {
                        Log.e("excepvalue", ex.getMessage());
                    }

                }
                Value ff=    datam(datf,indexid);
                val.add("GetData", ff);
                inn.setAnotherDatat(val);


            }else{


                ObjectValue val = new ObjectValue();
                Iterator<Map.Entry<String, Value>> uuo = objval.entrySet().iterator();
                while (uuo.hasNext()) {
                    // Log.i("8888", "hjhjhjhjh");
                    Map.Entry<String, Value> qqe = uuo.next();
                    try {
                        if (qqe.getKey().toLowerCase().equals("view_id")) {
                            inn.setIDUnit(qqe.getValue().getAsString());
                            inn.setUnitName(qqe.getValue().getAsString());
                            val.add("ViewId", qqe.getValue());

                        } else if (qqe.getKey().toLowerCase().equals("view_type")) {
                            val.add("Type", qqe.getValue());
                            inn.setTypselect(qqe.getValue().getAsString());
                        } else if (qqe.getKey().toLowerCase().equals("index_id")) {
                            val.add("index_id", qqe.getValue());
                            inn.setIdexid(qqe.getValue().getAsInt());
                        } else {
                            val.add(qqe.getKey().toLowerCase(), qqe.getValue());

                        }
                    } catch (Exception ex) {
                        Log.e("excepvalue", ex.getMessage());
                    }

                }
             Value ff=   new Primitive(String.format(function, datam(datf)));
                val.add("GetData", ff);
                inn.setAnotherDatat(val);
            }
        }catch(Exception ex){
            Log.e("ttt",ex.getMessage());
        }
    }
    private static Value DataValuegetsetdata(List<DataValueSelect> datval){
        Array ar=new Array();
        for(DataValueSelect i:datval){
            try {
                ObjectValue o = new ObjectValue();
                o.add("view_id", new Primitive(i.getIDUnit()));
                o.add("index_id", new Primitive(i.getIdexid()));
                o.add("view_type", new Primitive(i.getTypselect()));
               try {
                   o.add("get_data", i.getAnotherDatat());
               }catch(Exception ex){
                   Log.i("sssssmmmmm",ex.getMessage());
               }
                ar.add(o);
            }catch(Exception ex){
                Log.i("sssss",ex.getMessage());
}

        }

        ObjectValue oo=new ObjectValue();
        oo.add("data_from_view",ar);

        return oo;
    }
    private static List<DataValueSelect> getsetdata(List<DataValueSelect> datf,Value vv,ProteusView v){
        List<DataValueSelect> rr=new ArrayList<>();
        Value dataa= DataValuegetsetdata(datf);
        try {
            Array getasArryx = vv.getAsObject().getAsArray("Data_To_View");
            Iterator<Value> eerx = getasArryx.iterator();
            while (eerx.hasNext()) {
                Value erx = eerx.next();
                String getval = "";//erx.getAsObject().getAsString("View_Id");
                String ViewType = ""; //erx.getAsObject().getAsString("View_Type");

                DataValueSelect errr = new DataValueSelect();


                getvalueonly(errr, datf, erx.getAsObject(), v, dataa);

                rr.add(errr);
            }
        }catch(Exception ex){

Log.e("vxxc",ex.getMessage());
        }


        return rr;


    }


    private static List<DataValueSelect> datrbb(Value vv,AppCompatActivity act,int tot,int tot2,ObjectValue datvalu,String search,boolean usesearch){

        List<DataValueSelect> rr=new ArrayList<>();

        Array getasArryx=vv.getAsObject().getAsArray("Data_From_View");
        Iterator<Value> eerx=getasArryx.iterator();
        while (eerx.hasNext()) {
            Value erx = eerx.next();
            String getval = "";//erx.getAsObject().getAsString("View_Id");
            String ViewType =""; //erx.getAsObject().getAsString("View_Type");
            int indd = 0;//erx.getAsObject().getAsInteger("Index_ID");
            DataValueSelect errr = new DataValueSelect();
            ObjectValue obj=   new ObjectValue();
            Value constvalue=null;
            Value sorcekey=null;
            boolean usecustome=false;
            boolean usecustomefromsource=false;
            Iterator<Map.Entry<String, Value>> uuo = erx.getAsObject().entrySet().iterator();
            while (uuo.hasNext()) {
                // Log.i("8888", "hjhjhjhjh");
                Map.Entry<String, Value> qqe = uuo.next();
                try {
                    if (qqe.getKey().toLowerCase().equals("view_id")) {
                        getval = qqe.getValue().getAsString();
                    } else if (qqe.getKey().toLowerCase().equals("view_type")) {
                        ViewType = qqe.getValue().getAsString();
                    } else if (qqe.getKey().toLowerCase().equals("index_id")) {
                        indd = qqe.getValue().getAsInt();//.getAsString();
                    }
                    else if (qqe.getKey().toLowerCase().equals("use_const")) {
                        usecustome = qqe.getValue().getAsBoolean();//.getAsString();
                    }
                    else if (qqe.getKey().toLowerCase().equals("const_value")) {
                        constvalue = qqe.getValue();//.getAsString();
                    }else if (qqe.getKey().toLowerCase().equals("use_data_from_source")) {
                        usecustomefromsource = qqe.getValue().getAsBoolean();//.getAsString();
                    }
                    else if (qqe.getKey().toLowerCase().equals("source_key")) {
                        sorcekey = qqe.getValue();//.getAsString();
                    }


                    else {
                        obj.add(qqe.getKey().toLowerCase(), qqe.getValue());

                    }
                }catch (Exception ex){
                    Log.e("excepvalue", ex.getMessage());
                }

            }




            setvalue(erx,errr);
            if(ViewType.toLowerCase().equals("api_acess")){
                String kk=getdatafrom("acesstoken",act);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
                obj.add("GetData", new Primitive(kk));
                obj.add("ViewId", new Primitive("0"));
                obj.add("index_id",new Primitive(indd));
                obj.add("Type", new Primitive(ViewType));
            }
            else  if(ViewType.toLowerCase().equals("total_item")){
                String kk=String.valueOf(tot);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
                obj.add("GetData", new Primitive(kk));
                obj.add("ViewId", new Primitive("0"));
                obj.add("index_id",new Primitive(indd));
                obj.add("Type", new Primitive(ViewType));
            }
            else  if(ViewType.toLowerCase().equals("search_text")){
                String kk=search;
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
                obj.add("GetData", new Primitive(kk));
                obj.add("ViewId", new Primitive("0"));
                obj.add("index_id",new Primitive(indd));
                obj.add("Type", new Primitive(ViewType));
            }
            else  if(ViewType.toLowerCase().equals("total_item_all")){
                String kk=String.valueOf(tot2);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
                obj.add("GetData", new Primitive(kk));
                obj.add("ViewId", new Primitive("0"));
                obj.add("index_id",new Primitive(indd));
                obj.add("Type", new Primitive(ViewType));
            }
            else  if(ViewType.toLowerCase().equals("api_Refresh")){
                String kk=getdatafrom("refacesstoken",act);

                //String kk=String.valueOf(tot2);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
                obj.add("GetData", new Primitive(kk));
                obj.add("ViewId", new Primitive("0"));
                obj.add("index_id",new Primitive(indd));
                obj.add("Type", new Primitive(ViewType));
            }


            else  if(ViewType.toLowerCase().equals("id_device")){
                String kk= GlobalClass.UserAppID;///getdatafrom("acesstoken");
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
                obj.add("GetData", new Primitive(kk));
                obj.add("ViewId", new Primitive("0"));
                obj.add("index_id",new Primitive(indd));
                obj.add("Type", new Primitive(ViewType));

            }else {

                if(usecustome){

                    String vva=constvalue.getAsString();
                    errr.setIDUnit("0");
                    errr.setDataGet(vva);
                    errr.setIdexid(indd);
                    errr.setTypselect(ViewType);
                    obj.add("GetData", constvalue);
                    obj.add("ViewId", new Primitive("0"));
                    obj.add("index_id",new Primitive(indd));
                    obj.add("Type", new Primitive(ViewType));


                }else if(usecustomefromsource){

                    String vva=sorcekey.getAsString();
                    Value datvaluex=null;
                    if(datvalu!=null){

                        try {
                            datvaluex = datvalu.get(vva);
                        }catch(Exception ex){

                        }
                    }
                    if(datvaluex!=null){
                        obj.add("GetData", datvaluex);

                    }else{

                        obj.add("GetData", new Primitive("null value"));
                    }

                    obj.add("ViewId", new Primitive("0"));
                    obj.add("index_id",new Primitive(indd));
                    obj.add("Type", new Primitive(ViewType));

                    errr.setIDUnit("0");
                    errr.setDataGet(vva);
                    errr.setIdexid(indd);
                    errr.setTypselect(ViewType);
                }  else {




                    errr.setIDUnit(getval);
                    errr.setDataGet(getval);
                    errr.setIdexid(indd);
                    errr.setTypselect(ViewType);
                }
            }
            errr.setUnitName(ViewType);
            errr.setAnotherDatat(obj);
            rr.add(errr);
        }



        return rr;
    }
    private static List<DataValueSelect> datrbb(Array vv,AppCompatActivity act,int tot,int tot2){

        List<DataValueSelect> rr=new ArrayList<>();

        Array getasArryx=vv;//.getAsObject().getAsArray("Data_From_View");
        Iterator<Value> eerx=getasArryx.iterator();
        while (eerx.hasNext()) {
            Value erx = eerx.next();
            String getval = "";//erx.getAsObject().getAsString("View_Id");
            String ViewType =""; //erx.getAsObject().getAsString("View_Type");
            int indd = 0;//erx.getAsObject().getAsInteger("Index_ID");
            DataValueSelect errr = new DataValueSelect();
            ObjectValue obj=   new ObjectValue();
            Iterator<Map.Entry<String, Value>> uuo = erx.getAsObject().entrySet().iterator();
            while (uuo.hasNext()) {
                // Log.i("8888", "hjhjhjhjh");
                Map.Entry<String, Value> qqe = uuo.next();
                try {
                    if (qqe.getKey().toLowerCase().equals("view_id")) {
                        getval = qqe.getValue().getAsString();
                    } else if (qqe.getKey().toLowerCase().equals("view_type")) {
                        ViewType = qqe.getValue().getAsString();
                    } else if (qqe.getKey().toLowerCase().equals("index_id")) {
                        indd = qqe.getValue().getAsInt();//.getAsString();
                    } else {
                        obj.add(qqe.getKey().toLowerCase(), qqe.getValue());

                    }
                }catch (Exception ex){
                    Log.e("excepvalue", ex.getMessage());
                }

            }



            errr.setAnotherDatat(obj);
            setvalue(erx,errr);
            if(ViewType.toLowerCase().equals("api_acess")){
                String kk=getdatafrom("acesstoken",act);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
            }
            else  if(ViewType.toLowerCase().equals("total_item")){
                String kk=String.valueOf(tot);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
            }
            else  if(ViewType.toLowerCase().equals("total_item_all")){
                String kk=String.valueOf(tot2);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
            }
            else  if(ViewType.toLowerCase().equals("api_Refresh")){
                String kk=getdatafrom("refacesstoken",act);

                //String kk=String.valueOf(tot2);
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);
            }


            else  if(ViewType.toLowerCase().equals("id_device")){
                String kk= GlobalClass.UserAppID;///getdatafrom("acesstoken");
                errr.setIDUnit("0");
                errr.setDataGet(kk);
                errr.setIdexid(indd);

            }else {
                errr.setIDUnit(getval);
                errr.setDataGet(getval);
                errr.setIdexid(indd);
                errr.setTypselect(ViewType);
            }
            errr.setUnitName(ViewType);

            rr.add(errr);
        }



        return rr;
    }


    private static List<DataValueSelect> datr(Value vv,AppCompatActivity act,int tot,int tot2,String search){

        List<DataValueSelect> rr=new ArrayList<>();
        try {
            ObjectValue objj = new ObjectValue();
            boolean getasArry = vv.getAsObject().isArray("Sender_Data");
            if (getasArry) {
                Array arr = vv.getAsObject().getAsArray("Sender_Data");
                objj = arr.get(0).getAsObject();
            } else {

                objj = vv.getAsObject().getAsObject("Sender_Data");
            }
            rr = getsetvals(act, objj, null,tot,tot2,search);
        }catch(Exception ex){

            Log.e("fromgetdata",ex.getMessage());
        }

        return rr;
    }

    private static List<DataValueSelect> Beforprocess(Value vv){

        List<DataValueSelect> rr=new ArrayList<>();
        Array getasArry=vv.getAsArray();
        Iterator<Value> eer=getasArry.iterator();
        while (eer.hasNext()){
            Value er=eer.next();
            String getval = er.getAsObject().getAsString("View_Id");
            String ViewType = er.getAsObject().getAsString("Type_Process");
            String valueproces = er.getAsObject().getAsString("Value_Process");
            String valueprocesk = er.getAsObject().getAsString("View_Type");
            // int indd = er.getAsObject().getAsInteger("Index_ID");
            DataValueSelect errr = new DataValueSelect();
            setvalue(er,errr);
            errr.setIDUnit(getval);
            errr.setDataGet(getval);

            errr.setIdexid(0);
            errr.setUnitName(valueprocesk);

            errr.setTypselect(ViewType);
            rr.add(errr);

        }

        return rr;
    }
    private static List<DataValueSelect> Beforprocessk(Value vv){

        List<DataValueSelect> rr=new ArrayList<>();
        Array getasArry=vv.getAsArray();
        Iterator<Value> eer=getasArry.iterator();
        while (eer.hasNext()){
            Value er=eer.next();
            String getval = er.getAsObject().getAsString("View_Id");
            String ViewType = er.getAsObject().getAsString("Type_Process");
            String valueproces = er.getAsObject().getAsString("Value_Process");
            String valueprocesk = er.getAsObject().getAsString("View_Type");
            // int indd = er.getAsObject().getAsInteger("Index_ID");
            DataValueSelect errr = new DataValueSelect();

            errr.setIDUnit(getval);
            errr.setDataGet(valueproces);
            setvalue(er,errr);
            errr.setIdexid(0);
            errr.setAnotherDatat(new ObjectValue());
            errr.setUnitName(valueprocesk);
            errr.setTypselect(ViewType);
            rr.add(errr);

        }

        return rr;
    }
    private static void setvalue(Value v, DataValueSelect dat){
        try{
            Value c=   v.getAsObject().get("Custome_Value");
            dat.setCustomevalue(c);
        }catch (Exception ex){

        }
    }
    private static List<DataValueSelect> BeforprocessSetData(Value vv,Value datavalues){

        Value val=null;
        if(datavalues.isArray()){
            try {
                val = datavalues.getAsArray().get(0);
            }catch (Exception ex){

            }

        }else {
            val=datavalues;
        }
        List<DataValueSelect> rr=new ArrayList<>();
        Array getasArry=vv.getAsArray();
        Iterator<Value> eer=getasArry.iterator();
        while (eer.hasNext()){
            Value er=eer.next();
            String getval = er.getAsObject().getAsString("View_Id");
            String ViewType = er.getAsObject().getAsString("Type_Process");
            String valueproces = er.getAsObject().getAsString("Key_Process");
            String valueprocesk = er.getAsObject().getAsString("View_Type");
            // int indd = er.getAsObject().getAsInteger("Index_ID");
            DataValueSelect errr = new DataValueSelect();
            setvalue(er,errr);
            errr.setIDUnit(getval);

            try {

                if(val!=null) {
                    try {
                        String getvall = val.getAsObject().getAsString(valueproces);
                        errr.setDataGet(getvall);
                    }catch (Exception ex){

                    }
                }

            }catch (Exception ex){


            }
            errr.setIdexid(0);
            errr.setUnitName(valueprocesk);

            errr.setTypselect(ViewType);
            rr.add(errr);

        }

        return rr;
    }
    private static List<DataValueSelect> BeforprocessSetDataWith(Value vv,Value datavalues,boolean chh){


        List<DataValueSelect> rr=new ArrayList<>();

        Array getasArry=vv.getAsArray();
        if(chh) {
            Iterator<Value> eer=getasArry.iterator();
            while (eer.hasNext()){
                Value er=eer.next();
                String getval = er.getAsObject().getAsString("View_Id");
                String ViewType = er.getAsObject().getAsString("Type_Process");
                String valueproces = er.getAsObject().getAsString("Key_Process");
                //   Log.i("8888","hjhjhjhjh");
                String valueprocesk = er.getAsObject().getAsString("Value_Key");
                //  Log.i("8888","hjhjhjhjh");
                DataValueSelect errr = new DataValueSelect();
                setvalue(er,errr);
                try {
                    //  if (chh) {
                    assert datavalues != null;
                    Iterator<Map.Entry<String, Value>> uuo = datavalues.getAsObject().entrySet().iterator();
                    while (uuo.hasNext()) {
                        // Log.i("8888", "hjhjhjhjh");
                        Map.Entry<String, Value> qqe = uuo.next();
                        assert valueprocesk != null;
                        // Log.i("8888", "hjhjhjhjh");
                        if (valueprocesk.equals(qqe.getKey())) {
                            String getvall = qqe.getValue().getAsString();
                            errr.setDataGet(getvall);

                        }


                    }
                    // }
                }catch(Exception ec){

                    Log.i("oooo", ec.getMessage());
                }

                // int indd = er.getAsObject().getAsInteger("Index_ID");


                errr.setIDUnit(getval);


                errr.setIdexid(0);

                errr.setUnitName(valueproces);
                errr.setTypselect(ViewType);
                rr.add(errr);

            }
        }else{

            //   Array getasArry=vv.getAsArray();
            Iterator<Value> eer=getasArry.iterator();
            while (eer.hasNext()) {
                Value er = eer.next();
                String getval = er.getAsObject().getAsString("View_Id");
                String ViewType = er.getAsObject().getAsString("Type_Process");
                String valueproces = er.getAsObject().getAsString("Value_Process");
                //   Log.i("8888","hjhjhjhjh");
                String valueprocesk = er.getAsObject().getAsString("View_Type");
                //  Log.i("8888","hjhjhjhjh");
                DataValueSelect errr = new DataValueSelect();
                errr.setIDUnit(getval);
                setvalue(er,errr);
                errr.setDataGet(valueproces);
                errr.setUnitName(valueprocesk);
                errr.setIdexid(0);


                errr.setTypselect(ViewType);
                rr.add(errr);
            }
        }
        return rr;
    }

    private static Value datam(List<DataValueSelect>kmn,int indexid){
        boolean found=false;
        Value fo=null;
        for(DataValueSelect r:kmn){
            if(!found) {
                if (r.getIdexid() == indexid) {
                    fo=r.getAnotherDatat().get("GetData");
                }
            }
        }
        if(fo==null){

            fo=new Primitive("not found index");
        }
        return fo;
    }
    private static String[] datam(List<DataValueSelect>kmn){
        String []datresult=new String[kmn.size()];
        int iix=0;
        for (int cxx = 0; cxx < kmn.size(); cxx++) {


            //  if(iix==kmn.get(cxx).getIdexid()){
            try {
                String ik = kmn.get(cxx).getAnotherDatat().get("GetData").getAsString();
                datresult[cxx] = ik;
            }catch(Exception ex){

                Log.e("errfromv",ex.getMessage());
                datresult[cxx]=kmn.get(cxx).getDataGet();
            }


            //  }
         /*   if(kmn.get(cxx).isChecknull()& !checkknullm){

                //  Log.i("ProteusEventWithTag", kmn.get(cxx).getDataGet());
            }*/


            iix=iix+1;
            //Log.i("ProteusEventWithTag", allunit.get(cxx).getDataGet());
            //  Log.i("ProteusEventWithTag", allunit.get(cxx).getUnitName());
            // requestbody = requestbody.replace(allunit.get(cxx).getDataGet(), allunit.get(cxx).getUnitName());
        }
        Gson g=new Gson();
        Log.e("ffvv",g.toJson(datresult));
        return datresult;
    }
    private static Array getvalue(Array v,List<DataValueSelect>kmn,ProteusView vv,Value dataa)  {

        Array wwemn=new Array();

        Log.e("ffvvib","iiiiiiiiiiii");
        Iterator<Value> eerx=v.iterator();
        while (eerx.hasNext()) {
            Value erx = eerx.next();

            ObjectValue hederr = new ObjectValue();
            Iterator<Map.Entry<String, Value>> iider=    erx.getAsObject().entrySet().iterator();
            while (iider.hasNext()) {
                Map.Entry<String, Value> erxkicm = iider.next();
                if(erxkicm.getValue().isArray()){
                    Array fert=getvalue(erxkicm.getValue().getAsArray(),kmn,vv,dataa);
                    hederr.add(erxkicm.getKey(), fert);
                }else if(erxkicm.getValue().isPrimitive()) {


                    if (erxkicm.getKey().toLowerCase().equals("key_value")) {
                        String useformat="index";
                        String functin=null;
                        boolean checkfoundformat=false;
                        try {
                            useformat = erx.getAsObject().get("use_format").getAsString();
                            if(useformat.toLowerCase().equals("true")){
                                useformat="format";
                            } else if(useformat.toLowerCase().equals("false")){
                                useformat="index";
                            }
                            else if(useformat.toLowerCase().equals("function")){
                                useformat="function";
                            }
                            else if(useformat.toLowerCase().equals("format")){
                                useformat="format";
                            }else{
                                useformat="index";
                            }
                            checkfoundformat=true;

                            functin=erxkicm.getValue().getAsString();
                        }catch(Exception ex){


                        }
                        int innc=0;
                        try{
                            innc=    erx.getAsObject().get("index_id").getAsInt();
                        }catch(Exception ex){

                        }

                        if(useformat.toLowerCase().equals("function")) {
                            Log.e("vvvccc",functin);
                            try {
                                Value va = valuefromfunction(functin, vv, dataa);
                                if (va != null) {
                                    hederr.add(erxkicm.getKey(), va);
                                }
                            }catch (Exception ex){
                                Log.e("vvvcccll",ex.getMessage());
                                hederr.add(erxkicm.getKey(), datam(kmn, innc));
                            }

                        }else if(useformat.toLowerCase().equals("format")) {
                            hederr.add(erxkicm.getKey(), new Primitive(String.format(erxkicm.getValue().getAsString(), datam(kmn))));


                        }else{

                            hederr.add(erxkicm.getKey(), datam(kmn, innc));
                        }
                    } else {
                        hederr.add(erxkicm.getKey(), erxkicm.getValue());
                    }

                }else{
                    hederr.add(erxkicm.getKey(), erxkicm.getValue());

                }
            }
                  /*  String keyname=erxkic.getAsObject().e.getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");*/


                /*String valll = erx.getAsObject().getAsString("Key_Name");
                String value = erx.getAsObject().getAsString("Key_Value");
                String ViewType = erx.getAsObject().getAsString("Key_Type");
                hederr.add("Key_Name", new Primitive(valll));

                hederr.add("Key_Type", new Primitive(ViewType));*/
            wwemn.add(hederr);
        }
        return wwemn;
    }

    private static Value datr(Value vv,List<DataValueSelect>kmn,ProteusView v){

        Gson g = new Gson();

        Log.i("gggglove","h"+g.toJson(kmn));


        Value u=datrqq(vv,kmn,v);
        Log.i("gggglove","h"+g.toJson(u));
        return  u;

    }
    private static Value datrqq(Value vv,List<DataValueSelect>kmn,ProteusView v){
        ObjectValue hederr = new ObjectValue();
        //   List<DataValueSelect> rr=new ArrayList<>();
        Log.i("gggglovebbbbii", "hkkkkkkkkkkkkkkk");
        try {
            Value dataa = DataValuegetsetdata(kmn);
Gson hh=new Gson();

            Log.i("gggglovebbbbcc", hh.toJson(dataa));
            Iterator<Map.Entry<String, Value>> iiderm = vv.getAsObject().entrySet().iterator();
            while (iiderm.hasNext()) {
                Map.Entry<String, Value> erxkicm = iiderm.next();
                if (erxkicm.getValue().isArray()) {
                    try {
                        Log.i("gggglovebbbb", "hkkkkkkkkkkkkkkk");
                        Array tteru = getvalue(erxkicm.getValue().getAsArray(), kmn, v, dataa);
                        Log.i("gggglovebbbb", "hkkkkkkkkkkkkkkk");
                        hederr.add(erxkicm.getKey(), tteru);
                    } catch (Exception ex) {
                        Log.i("gggglove", "h" + ex.getMessage());
                    }
                    //  Value d = datrqq(tteru, kmn);

                } else {

                    hederr.add(erxkicm.getKey(), erxkicm.getValue());
                }

            }
            //  }

            // hedermk.get("API_Data").add(wdd);
            //   ObjectValue hedermk=new ObjectValue();

            //  Array wdd=hedermk.getAsArray("API_Data");
            //heder.add(wdd);


            // heder.add("Sender_Data",wwe);


        }catch(Exception ex){


            Log.i("gggglovebbbb", "h" + ex.getMessage());
        }
        return hederr;
    }
    private  static String urldata(String urldat,String typurl){

        //  String  = String.valueOf(v.getTag(R.id.tagApiurl));
        String resultss="no";
        try {
            if(urldat.startsWith("/")){
                String urll=GlobalClass.BseUrl2;
                int len=urll.length();
                String res=urll;
                if(urll.endsWith("/")){
                    res=urll.substring(0,len-1);
                }
                String resul[] = GlobalClass.getBaseURL(res+urldat);
                resultss= resul[0];
                resultss=resultss+"#"+resul[1];
            }
            else if(typurl.equals("Local")) {
                String resul[] = GlobalClass.getBaseURL(GlobalClass.BseUrl2);

                resultss= resul[0];
                resultss=resultss+"#"+resul[1];
            }else {

                String resul[] = GlobalClass.getBaseURL(urldat);

                resultss= resul[0];
                resultss=resultss+"#"+resul[1];
            }
        }catch (Exception ex){


        }
        return  resultss;
    }
    private static   void closediloge(FragmentManager ac, String dilogenam){

        List<Fragment> dder=ac.getFragments();
        if(dder!=null){
            for(Fragment f:dder){

                if(f instanceof DialogFragment) {
                    if (f.getTag().equals(dilogenam)) {
                        DialogFragment er=(DialogFragment)f;

                        er.getDialog().dismiss();
                    }
                }
            }

        }
    }

    private static   void closedilogecancel(FragmentManager ac, String dilogenam){
//Log.e("yyyy",dilogenam);
        List<Fragment> dder=ac.getFragments();
        if(dder!=null){
            for(Fragment f:dder){

                if(f instanceof DialogFragment) {
                    // Log.e("yyyy",f.getClass().getName()+"@"+f.getTag()+"@"+dilogenam);
                    if (f.getTag().equals(dilogenam)) {
                        //Log.e("yyyy",f.getClass().getName());
                        DialogFragment er=(DialogFragment)f;
                        er.getDialog().cancel();
                        // er.dismiss();
                    }
                }
            }

        }
    }
    public static void getallview(View cxx){
        if(cxx instanceof TextInputLayoutB){

            TextInputLayoutB ww=(TextInputLayoutB)cxx;
            ww.getEditText().setText("hghghghg");
        }
        else   if(cxx instanceof  ViewGroup) {
            ViewGroup v=(ViewGroup)cxx;
            for (int cx = 0; cx < v.getChildCount(); cx++) {

                if(v.getChildAt(cx) instanceof ViewGroup){
                    getallview(v.getChildAt(cx));
                }else {
                    // Log.e ("eeee",v.getChildAt(cx).getClass().getName());
                }
            }
        }

    }
    private static   List<ViewGroup> closedilogee(FragmentManager ac, ViewGroup df){
        List<ViewGroup> dddf=new ArrayList<>();
        List<Fragment> dder=ac.getFragments();
        if(dder!=null){
            for(Fragment f:dder){
                if(f instanceof BottomShitDaloge){

                    BottomShitDaloge er=(BottomShitDaloge)f;
                    ViewGroup v=(ViewGroup) er.getDialog().getWindow().getDecorView();
                    // getallview(v);
                    //  Log.e("0909",f.getClass().getName()+v.getChildCount());
                    dddf.add(v);
                }
                else if(f instanceof DialogFragment) {

                    DialogFragment er=(DialogFragment)f;
                    dddf.add((ViewGroup) er.getDialog().getWindow().getDecorView());

                }
            }

        }
        dddf.add(df);
        return dddf;
    }
    public static final ALLEvent Allevtclos = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            String eew=data.getAsObject().get("Name").getAsString();
            closediloge(act.getSupportFragmentManager(),eew);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "CloseDialog";
        }
    };
    public static final ALLEvent AllevtclosOk = new ALLEvent(){

        @NonNull
        @Override
        public void call(Context context,AppCompatActivity act, Value data, int dataIndex, ProteusView v,Value... arguments) throws Exception {
            String eew=data.getAsObject().get("Name").getAsString();
            closedilogecancel(act.getSupportFragmentManager(),eew);
        }

        @Override
        public void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v, IValuesData changeval, ProteusView.Manager.ActionEventViewForUto Actviw, Value... arguments) throws Exception {

        }

        @Override
        public String getName() {
            return "OkDialog";
        }
    };



    private static Map<String, List<hedaerOrQuary>>getvaluuusHeder(Value v,int typ){
        Map<String, List<hedaerOrQuary>> ert=new HashMap<>();

        Iterator<Map.Entry<String, Value>> eerxxx=v.getAsObject().entrySet().iterator();
        while (eerxxx.hasNext()) {
            Map.Entry<String, Value> erxk = eerxxx.next();

            Iterator<Value> eerxxxm=erxk.getValue().getAsArray().iterator();
            while (eerxxxm.hasNext()) {
                Value erxki = eerxxxm.next();

                List<hedaerOrQuary> hder=new ArrayList<>();

                //    List<hedaerOrQuary> hderc=new ArrayList<>();
                Iterator<Value> rqhder=erxki.getAsObject().getAsArray("Request_Header").iterator();
                while (rqhder.hasNext()) {
                    Value erxkic = rqhder.next();
                    HashMap<String,Object> mval=new HashMap<>();
                    Iterator<Map.Entry<String, Value>> iider=    erxkic.getAsObject().entrySet().iterator();
                    while (iider.hasNext()) {
                        Map.Entry<String, Value> erxkicm = iider.next();
                        if(erxkicm.getValue().isArray()) {
                            mval.put(erxkicm.getKey(), erxkicm.getValue());
                        }else  if(erxkicm.getValue().isPrimitive()) {
                            mval.put(erxkicm.getKey(), erxkicm.getValue().getAsString());
                        }
                    }
                  /*  String keyname=erxkic.getAsObject().e.getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");*/
                    hedaerOrQuary w=new hedaerOrQuary("no","no","no","no");
                    w.setDatvalue(mval);
/*
String keyname=erxkic.getAsObject().getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");
                    hedaerOrQuary w=new hedaerOrQuary(keyname,keynamed,keynamet,"no");
                   */
                    hder.add(w);
                    // Log.i("777",g.toJson(erxki));
                }
                ert.put("hdr",hder);


                List<hedaerOrQuary> hderm=new ArrayList<>();
                Iterator<Value> rqhderf=erxki.getAsObject().getAsArray("Request_Body").iterator();
                while (rqhderf.hasNext()) {
                    Value erxkic = rqhderf.next();
                    HashMap<String,Object> mval=new HashMap<>();
                    Iterator<Map.Entry<String, Value>> iider=    erxkic.getAsObject().entrySet().iterator();
                    while (iider.hasNext()) {
                        Map.Entry<String, Value> erxkicm = iider.next();
                        mval.put(erxkicm.getKey(), erxkicm.getValue());
                    /*  if(erxkicm.getValue().isArray()) {
                          mval.put(erxkicm.getKey(), erxkicm.getValue());
                      }else  if(erxkicm.getValue().isPrimitive()) {
                          mval.put(erxkicm.getKey(), erxkicm.getValue());
                      }*/
                    }
                  /*  String keyname=erxkic.getAsObject().e.getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");*/
                    hedaerOrQuary w=new hedaerOrQuary("no","no","no","no");
                    w.setDatvalue(mval);
                    hderm.add(w);
                    //Log.i("777",g.toJson(erxki));
                }
                ert.put("body",hderm);



                List<hedaerOrQuary> qur=new ArrayList<>();
                Iterator<Value> rqhderff=erxki.getAsObject().getAsArray("Request_Query").iterator();
                while (rqhderff.hasNext()) {
                    Value erxkic = rqhderff.next();

                    HashMap<String,Object> mval=new HashMap<>();
                    Iterator<Map.Entry<String, Value>> iider=    erxkic.getAsObject().entrySet().iterator();
                    while (iider.hasNext()) {
                        Map.Entry<String, Value> erxkicm = iider.next();
                        if(erxkicm.getValue().isArray()) {
                            mval.put(erxkicm.getKey(), erxkicm.getValue());
                        }else  if(erxkicm.getValue().isPrimitive()) {
                            mval.put(erxkicm.getKey(), erxkicm.getValue());
                        }
                    }
                  /*  String keyname=erxkic.getAsObject().e.getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");*/
                    hedaerOrQuary w=new hedaerOrQuary("no","no","no","no");
                    w.setDatvalue(mval);
                    qur.add(w);
                    //  Log.i("777",g.toJson(erxki));
                }
                ert.put("qur",qur);
                List<hedaerOrQuary> qurx=new ArrayList<>();
                Iterator<Value> rqhderffx=erxki.getAsObject().getAsArray("Response_Data").iterator();
                while (rqhderffx.hasNext()) {
                    Value erxkic = rqhderffx.next();
                    HashMap<String,Object> mval=new HashMap<>();
                    Iterator<Map.Entry<String, Value>> iider=    erxkic.getAsObject().entrySet().iterator();
                    while (iider.hasNext()) {
                        Map.Entry<String, Value> erxkicm = iider.next();
                        if(erxkicm.getValue().isArray()) {
                            mval.put(erxkicm.getKey(), erxkicm.getValue());
                        }else  if(erxkicm.getValue().isPrimitive()) {
                            mval.put(erxkicm.getKey(), erxkicm.getValue().getAsString());
                        }
                    }
                  /*  String keyname=erxkic.getAsObject().e.getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");*/
                    hedaerOrQuary w=new hedaerOrQuary("no","no","no","no");
                    w.setDatvalue(mval);
                  /*  String keyname=erxkic.getAsObject().getAsString("Key_Name");
                    String keynamed=erxkic.getAsObject().getAsString("Key_Value");

                    String keynamet=erxkic.getAsObject().getAsString("Key_Type");
                    hedaerOrQuary w=new hedaerOrQuary(keyname,keynamed,keynamet,"no");
*/
                    qurx.add(w);
                    //  Log.i("777",g.toJson(erxki));
                }
                ert.put("response",qurx);



                List<hedaerOrQuary> qurfin=new ArrayList<>();
                String urll=  erxki.getAsObject().getAsString("Final_url");
                String meth=  erxki.getAsObject().getAsString("Method_Type");

                hedaerOrQuary w=new hedaerOrQuary(urll,urll,urll,"0");
                qurfin.add(w);

                hedaerOrQuary ww=new hedaerOrQuary(meth,meth,meth,"1");
                qurfin.add(ww);
                ert.put("url",qurfin);

                //  Log.i("777",g.toJson(erxki));
            }

            /*if(erxk.getKey().equals("API_Data")){

                Iterator<Map.Entry<String, Value>> eerxxxm=erxk.getValue().getAsObject().entrySet().iterator();
                while (eerxxxm.hasNext()) {

                    Map.Entry<String, Value> erxkm = eerxxxm.next();
                    if(erxkm.getKey().equals("Request_Header")){
                        Iterator<Value> eerx=erxkm.getValue().getAsArray().iterator();
                        while (eerx.hasNext()) {
                            Value erx = eerx.next();
                           // hedaerOrQuary errtf=new hedaerOrQuary(erx.getAsObject().getAsString("Key_Name"),)
                        }
                    }

                    Log.i("777",g.toJson(erxkm.getValue()));
                }
            }*/
        }

        return  ert;
    }

    private static  boolean checkjson(String json){

        try{
            new JSONObject(json);
        }catch (JSONException ex){

            try{
                new JSONArray(json);
            }catch (JSONException ex1){
                return  false;

            }
        }
        return true;
    }
    class AsyncTaskRunnerv extends AsyncTask<String, String, String> {

        private Value  resp;
        private ProteusView views;
        boolean useoffline=false;
        Value afterprocess;
        AsyncTaskRunnerv(Value val, ProteusView viewss,Value afterprocesss) {



            this.resp=val;
            this.views=viewss;
            this.afterprocess=afterprocesss;


        }

        @Override
        protected String doInBackground(final String... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);
                Map<String,Object> hedermap=new HashMap<>();//Map<String, Object>();
                HashMap<String,String> quarymap=new HashMap<>();//HashMap<String, String>();
                String URL="no";
                String URL2="no";
                String Postmethod="no";
                String requestbody="nos";
                final String refresh="0";///params[3];
                List<hedaerOrQuary> responsee=new ArrayList<>();
                //final String without=params[4];
                //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);
                Map<String, List<hedaerOrQuary>> ertu=   new HashMap<>(); //getvaluuusHeder(resp,1);
                Iterator<Map.Entry<String, Value>> tdfdx=resp.getAsObject().entrySet().iterator();
                while (tdfdx.hasNext()) {
                    Map.Entry<String,Value> wr = tdfdx.next();
                    if(wr.getValue().isArray()){
                        if(wr.getKey().toLowerCase().equals("sender_data")){
                            ObjectValue objj=new ObjectValue();
                            if(wr.getValue().isArray()){
                                objj=wr.getValue().getAsArray().get(0).getAsObject();
                            }else{
                                objj=wr.getValue().getAsObject();

                            }

                            Iterator<Value> aru=objj.getAsArray("API_Data").iterator();
                            while (aru.hasNext()) {
                                Value wrk = aru.next();
//Request_Body

                                //Url
                                //Request_Query
                                //Type_Url
                                String urll=wrk.getAsObject().getAsString( "Url");
                                String meth=wrk.getAsObject().getAsString( "Type_Url");
                                Postmethod=wrk.getAsObject().getAsString( "Method_Type");

                                String urlll=urldata(urll,meth);

                                String[] datt=urlll.split("#");
                                URL=datt[0];
                                URL2=datt[1];


                                //  List<hedaerOrQuary> eru=    wr.getValue();

                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Header").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        hedermap.put(keynam, keynamm);

                                    }
                                }catch (Exception ex){

                                }
                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Query").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        quarymap.put(keynam, keynamm);

                                    }
                                }catch (Exception ex){

                                }
                                try {
                                    int cou=0;
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Body").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        cou=cou+1;
                                        if(cou==1) {
                                            // String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                            requestbody = wrkm.getAsObject().getAsString("Key_Value");
                                            //quarymap.put(keynam, keynamm);
                                        }
                                    }
                                }catch (Exception ex){

                                }

                                try {
                                    int cou=0;
                                    List<hedaerOrQuary> eru=new ArrayList<>();
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Response_Data").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();

                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String valuu = wrkm.getAsObject().getAsString("Key_Value");
                                        String valuuv = wrkm.getAsObject().getAsString("Key_Type");
                                        hedaerOrQuary stt=new hedaerOrQuary(keynam,valuu,valuuv,"0");
                                        eru.add(stt);
                                        //quarymap.put(keynam, keynamm);

                                    }
                                    responsee=eru;
                                }catch (Exception ex){

                                }



                                Gson ddd=new Gson();
                                // Log.i("yyy",ddd.toJson(wrk));
                                //  Iterator<Map.Entry<String, Value>> vu=wrk.getAsObject().entrySet().iterator();



                            }
                        }



                    }

                }


                final List<hedaerOrQuary> res=responsee;
                String contettyp="application/json; charset=UTF-8";
                String userAgentt="fromandroid";
                final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(URL).create(retrofit_dynimcic.class);
                RequestBody requestBodyBinary = null;

                requestBodyBinary = RequestBody.create(MediaType.parse(contettyp),requestbody);

                // sendreq(params[0],params[1],params[2]);
                Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL2,requestBodyBinary,hedermap,quarymap):Retrofitapi.GetMethod(URL,hedermap,quarymap);
                // Log.i("0000xx",params[12]);
                call.enqueue(new Callback<ResponseBody>() {

                    private void showmessage(String mes,int typ){


                        // String kk=mes; //response.errorBody().string();
                        String kk="";
                        if(!checkjson(mes)){
                            //String resa="m";
                            String vvc=mes.replace("\"","\\\"");
                            mes=vvc;
                            kk="\""+mes+"\"";
                        }else{
                            kk=mes;
                        }
                        String xv="\"Message\":"+kk+"";
                        String k="{Result:{"+xv+"}}";
                        // String kx="{\"Result\":{"+xv+"}}";
                        Gson g=views.getViewManager().getContext().getJson();
                        Type type = new TypeToken<Value>() {

                        }.getType();
                        ObjectValue tempp = g.fromJson(k, type);
                        try {
                            views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), tempp, typ, views, tempp);
                        }catch (Exception ex){

                        }
                    }
                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        try {
                            assert response.body() != null;
                            String responseKey="0";
                            String OflineKey="0";
                            String OflinevalueKey="0";
                            String RefeshKey="0";
                            String RefeshKeyasMessage="0";
                            String RefeshKeyasMessageKeyval="0";

                            Iterator<hedaerOrQuary> wff=res.iterator();
                            while (wff.hasNext()){
                                hedaerOrQuary ruo=wff.next();

                                if(ruo.getKeyType().toLowerCase().equals("select_key")){
                                    responseKey=ruo.getKeyValue();
                                }
                                if(ruo.getKeyType().toLowerCase().equals("offline_key")){
                                    OflinevalueKey=ruo.getKeyName();
                                    OflineKey=ruo.getKeyValue();
                                }
                                if(ruo.getKeyType().toLowerCase().equals("refresh_key")){
                                    RefeshKey=ruo.getKeyValue();
                                    //RefeshKey="1";
                                }
                                if(ruo.getKeyValue().toLowerCase().equals("show_as_message")){
                                    RefeshKeyasMessage=ruo.getKeyValue();
                                    //"1";
                                    RefeshKeyasMessageKeyval=ruo.getKeyName();
                                }
                            }
                            //   showResult(response.body().string(),protvv.getAsView());
                            //  String x="mydesin";

                            if(response.isSuccessful()) {

                                String kk= response.body().string();
                                // assert response.errorBody() != null;
                                try {
                                    //String responseKey = "0";//params[11];

                                    if(!responseKey.equals("0")) {
                                        JSONObject js = new JSONObject(kk);
                                        kk = js.get(responseKey).toString();
                                    }
                                }catch (Exception ex){

                                }
                                String k="{s1:"+kk+"}";
                                if(RefeshKey.equals("1")) {
                                    try {

                                        if(OflineKey.equals("1")) {
                                            String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            ScriptModel g = new ScriptModel(0, k, mng);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(views.getAsView().getContext());
                                            db_operations.insert(g);
                                        }
                                    }catch (Exception ex){

                                    }

                                }else {
                                }
                                Gson g=views.getViewManager().getContext().getJson();
                                Type type = new TypeToken<Value>() {

                                }.getType();
                                ObjectValue tempp = g.fromJson(k, type);
                                tempp.add("show_as_message",new Primitive(RefeshKeyasMessage));
                                tempp.add("show_as_messagekey",new Primitive(RefeshKeyasMessageKeyval));
                                tempp.add("show_as_messagekeytyp",new Primitive(0));
                                tempp.add("show_as_messagetext",new Primitive(RefeshKeyasMessage=="1"?"nomes":kk));
                                //  views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),1,views,new Primitive(t.getMessage()));
                                // views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);

                                //    Log.i("0000xx",k);
                                String   prograssnam="0";
                                try {
                                    //  prograssnam =anoth[0];//enabprograss
                                }catch (Exception ex){

                                }


                            }else{
                                try {
                                    assert response.errorBody() != null;


                                    String kk= response.errorBody().string();
                                    showmessage(kk,2);
                                }catch (IOException ex){

                                    //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                    //  even.sendEventA(null,6767,null);
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                    // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                }
                            }


                        } catch (Exception ex) {
                            //  even.sendEventA(null,6767,null);
                            //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                            // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                            // loadrefd();
                            // masss.showmessage(ex.getMessage());
                            // stoptimertask();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        //  stoptimertask();
                        try {

                            String respon=   t.getMessage();
                            views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                            String OflineKey = "0";
                            String OflinevalueKey = "0";
                            String responseKey="0";
                            String RefeshKey = "0";
                            String RefeshKeyasMessage = "0";
                            String RefeshKeyasMessageKeyval = "0";
                            String wwe = "0";
                            Iterator<hedaerOrQuary> wff = res.iterator();
                            while (wff.hasNext()){
                                hedaerOrQuary ruo=wff.next();

                                if(ruo.getKeyType().toLowerCase().equals("select_key")){
                                    responseKey=ruo.getKeyValue();
                                }
                                if(ruo.getKeyType().toLowerCase().equals("offline_key")){
                                    OflinevalueKey=ruo.getKeyName();
                                    OflineKey=ruo.getKeyValue();
                                }
                                if(ruo.getKeyType().toLowerCase().equals("refresh_key")){
                                    RefeshKey=ruo.getKeyValue();
                                    //RefeshKey="1";
                                }
                                if(ruo.getKeyValue().toLowerCase().equals("show_as_message")){
                                    RefeshKeyasMessage=ruo.getKeyValue();
                                    //"1";
                                    RefeshKeyasMessageKeyval=ruo.getKeyName();
                                }
                            }
                            // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
                            if (t.getMessage().startsWith("Unable to resolve host")) {
                                try {
                                    showmessage(GlobalClass.MessageErorr,2);
                                    if (OflineKey.equals("1")) {
                                        // String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                        // FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
                                        //if(uk.getItemCount()==0) {

               /* ScriptModel g = new ScriptModel(0, "no",  OflinevalueKey);
                DatabaseHelper db_operations;
                 db_operations = new DatabaseHelper(views.getAsView().getContext());
                 List<ScriptModel> x = db_operations.getAllNotes(g);
                String val = x.get(0).getContent();


                Gson gd=views.getViewManager().getContext().getJson();
                Type type = new TypeToken<Value>() {

                }.getType();
                ObjectValue tempp = gd.fromJson(val, type);
                tempp.add("show_as_message",new Primitive(RefeshKeyasMessage));
                tempp.add("show_as_messagekey",new Primitive(RefeshKeyasMessageKeyval));
                tempp.add("show_as_messagekeytyp",new Primitive(2));
                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),2,views,new Primitive(t.getMessage()));*/
                                        //  views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);

                                    } else {



                                        //   views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
                                        // uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
                                    }
                                } catch (Exception ex) {

                                    showmessage(ex.getMessage(),2);
            /*Gson gd=views.getViewManager().getContext().getJson();
            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = gd.fromJson("{}", type);
            tempp.add("show_as_message",new Primitive(RefeshKeyasMessage));
            tempp.add("show_as_messagekey",new Primitive(RefeshKeyasMessageKeyval));
            tempp.add("show_as_messagekeytyp",new Primitive(1));
            tempp.add("show_as_messagetext",new Primitive(ex.getMessage()));
            views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),2,views,new Primitive(ex.getMessage()));
            //   views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
*/

                                }

                            } else {

                                showmessage(t.getMessage(),2);
       /* String kj="0";
        try {
            //String responseKey = "0";//params[11];

            if(!responseKey.equals("0")) {
                JSONObject js = new JSONObject(respon);
                kj = js.get(responseKey).toString();
            }
        }catch (Exception ex){

        }
        String k="{s1:"+kj+"}";
        Gson gd=views.getViewManager().getContext().getJson();
        Type type = new TypeToken<Value>() {

        }.getType();
        ObjectValue tempp = gd.fromJson(k, type);
        tempp.add("show_as_message",new Primitive(RefeshKeyasMessage));
        tempp.add("show_as_messagekey",new Primitive(RefeshKeyasMessageKeyval));
        tempp.add("show_as_messagekeytyp",new Primitive(1));
        tempp.add("show_as_messagetext",new Primitive(kj));*/
                                //  views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
                                //   views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),2,views,new Primitive(t.getMessage()));



                                //  uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
                            }


                        }
                        catch (Exception ex) {

                        }
                    }
                });


            } catch (Exception ex) {

                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                //  loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return "";
        }
        private void showResult(String result, View c) {
            new AlertDialog.Builder(c.getContext())
                    .setMessage(result)
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

        @Override
        protected void onPostExecute(String result) {
            try {

            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(String... text) {
            // finalResult.setText(text[0]);

        }
    }


    class AsyncTaskRunnervFromUrl extends AsyncTask<String, String, String> {

        private Value  resp;
        private ProteusView views;
        boolean useoffline=false;
        Value afterprocess;
        private boolean usevolleys;
        private  boolean showtool;
        private boolean showdarwer;
        String keysname;
        private  String NameActivity;
        AsyncTaskRunnervFromUrl(Value val, ProteusView viewss,Value afterprocesss,boolean usevolleyss,boolean tol,boolean dra,String NameActivity) {



            this.resp=val;
            this.views=viewss;
            this.afterprocess=afterprocesss;
            this.usevolleys=usevolleyss;
            this.showdarwer=dra;
            this.showtool=tol;
            this.NameActivity=NameActivity;

        }
        private void showmessagea(String mes, int typ) {


            // String kk=mes; //response.errorBody().string();
            String kk = "";
            if (!checkjson(mes)) {
                mes = mes.replace("\"", "\\\"");
                //mes=mes.replace('"',' ');
                kk = "\"" + mes + "\"";
            } else {
                kk = mes;
            }
            //response.errorBody().string();
          /*  String xv = "\"Message\":" + kk + "";
            String k = "{Result:{" + xv + "}}";
            // String kx="{\"Result\":{"+xv+"}}";
            Gson g = views.getViewManager().getContext().getJson();
            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = g.fromJson(k, type);

            Log.e("uuuu",k);*/

            try {
                Value temppx= views.getViewManager().getContext().getvalueFromString(kk,keysname);
                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), temppx, typ, views, temppx);
            } catch (Exception ex) {
                Log.e("uuuukk",ex.getMessage());
            }
        }
        @Override
        protected String doInBackground(final String... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);
                Map<String, Object> hedermap = new HashMap<>();//Map<String, Object>();
                HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
                Map<String, String> hedermapVolley = new HashMap<>();//Map<String, Object>();
                // HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
                String URL = "no";
                String URL2 = "no";
                String Postmethod = "no";
                String requestbody = "nos";
                final String refresh = "0";///params[3];
                List<hedaerOrQuary> responsee = new ArrayList<>();
                //final String without=params[4];
                //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);
                Map<String, List<hedaerOrQuary>> ertu = new HashMap<>(); //getvaluuusHeder(resp,1);
                Iterator<Map.Entry<String, Value>> tdfdx = resp.getAsObject().entrySet().iterator();
                while (tdfdx.hasNext()) {
                    Map.Entry<String, Value> wr = tdfdx.next();
                    if (wr.getValue().isArray()) {
                        if (wr.getKey().toLowerCase().equals("sender_data")) {
                            Iterator<Value> aru = wr.getValue().getAsArray().get(0).getAsObject().getAsArray("API_Data").iterator();
                            while (aru.hasNext()) {
                                Value wrk = aru.next();
//Request_Body

                                //Url
                                //Request_Query
                                //Type_Url
                                String urll = wrk.getAsObject().getAsString("Url");
                                String meth = wrk.getAsObject().getAsString("Type_Url");
                                Postmethod = wrk.getAsObject().getAsString("Method_Type");

                                String urlll = urldata(urll, meth);

                                String[] datt = urlll.split("#");
                                URL = datt[0];
                                URL2 = datt[1];


                                //  List<hedaerOrQuary> eru=    wr.getValue();

                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Header").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        hedermap.put(keynam, keynamm);
                                        hedermapVolley.put(keynam,keynamm);
                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Query").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        quarymap.put(keynam, keynamm);

                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    int cou = 0;
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Body").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        cou = cou + 1;
                                        if (cou == 1) {
                                            // String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                            requestbody = wrkm.getAsObject().getAsString("Key_Value");
                                            //quarymap.put(keynam, keynamm);
                                        }
                                    }
                                } catch (Exception ex) {

                                }
                                List<hedaerOrQuary> eru = new ArrayList<>();
                                try {
                                    int cou = 0;

                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Response_Data").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();

                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String valuu = wrkm.getAsObject().getAsString("Key_Value");
                                        String valuuv = wrkm.getAsObject().getAsString("Key_Type");
                                        hedaerOrQuary stt = new hedaerOrQuary(keynam, valuu, valuuv, "0");
                                        eru.add(stt);
                                        //quarymap.put(keynam, keynamm);

                                    }

                                } catch (Exception ex) {
                                    Log.i("yyykm",ex.getMessage());
                                }

                                responsee = eru;

                                Gson ddd = new Gson();
                                // Log.i("yyy",ddd.toJson(wrk));
                                //  Iterator<Map.Entry<String, Value>> vu=wrk.getAsObject().entrySet().iterator();


                            }
                        }


                    }

                }


                final List<hedaerOrQuary> res = responsee;
                //    String contettyp = "application/json; charset=UTF-8";
                String userAgentt = "fromandroid";
                final String contettyp = "application/json; charset=UTF-8";
                final  String bodys=requestbody;
                final   Map<String, String> hedermapx =hedermapVolley; //new HashMap<>();//Map<String, Object>();
                final   Map<String, String> quert= quarymap;
                //  String userAgentt = "fromandroid";
                if(usevolleys){

                    //  public  void settreq(final String auth, final String usertyp, final String email){
                    // String BASE_URL = "http://192.168.1.101:80/api/astoolacount/login";

                    RequestQueue q= Volley.newRequestQueue(views.getAsView().getContext());
                    int typmethod=Request.Method.POST;
                    if(Postmethod.toLowerCase().startsWith("g")){
                        typmethod=Request.Method.GET;
                    }
                    if(Postmethod.toLowerCase().startsWith("d")){
                        typmethod=Request.Method.DELETE;
                    }
                    if(Postmethod.toLowerCase().startsWith("pu")){
                        typmethod=Request.Method.PUT;
                    }
                    if(Postmethod.toLowerCase().startsWith("pa")){
                        typmethod=Request.Method.PATCH;
                    }
                    if(Postmethod.toLowerCase().startsWith("h")){
                        typmethod=Request.Method.HEAD;
                    }
                    Log.i("myurl",URL + URL2);
                    CustomStringRequest rrrr=new CustomStringRequest(typmethod, URL + URL2, requestbody, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                assert response != null;
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Gson f=new Gson();
                                Log.i("trrrrrrbbbb",f.toJson(res));
                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                //   showResult(response.body().string(),protvv.getAsView());
                                //  String x="mydesin";
                                //    Log.i("0000xx",response.body().string());


                                String kk = response;//.body().string();
                                // assert response.errorBody() != null;
                                try {
                                    //String responseKey = "0";//params[11];

                                       /* if (!responseKey.equals("0")) {
                                            JSONObject js = new JSONObject(kk);
                                            kk = js.get(responseKey).toString();
                                        }*/
                                } catch (Exception ex) {

                                }
                                /// String k = "{s1:" + kk + "}";
                                if (RefeshKey.equals("1")) {
                                    try {

                                        if (OflineKey.equals("1")) {
                                            String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            ScriptModel g = new ScriptModel(0, kk, mng);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(views.getAsView().getContext());
                                            db_operations.insert(g);
                                        }
                                    } catch (Exception ex) {

                                    }

                                } else {
                                }
                                   /* Gson g = views.getViewManager().getContext().getJson();
                                    Type type = new TypeToken<Value>() {

                                    }.getType();*/
Log.i("trrrrrr","hhhhhhhhhhhhhhhhhhhhhhhhh");
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                Log.i("trrrrrr","hhhhhhhhhhhhhhhhhhhhhhhhh");
                                Value temppx = views.getViewManager().getContext().getvalueFromString(kk, keysname);
                                Log.i("trrrrrr","hhhhhhhhhhhhhhhhhhhhhhhhh");
                                String resul = temppx.getAsObject().getAsString("Result");


                                if(NameActivity.equals("0")) {

                                    //  intent.putExtra("data", dv);

                                    Intent intent = new Intent(views.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                                    // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.putExtra("data", resul);

                                    if (showdarwer) {
                                        intent.putExtra("Drawer", "1");

                                    } else {
                                        intent.putExtra("Drawer", "0");
                                    }
                                    if (showtool) {
                                        intent.putExtra("Toolbar", "1");

                                    } else {
                                        intent.putExtra("Toolbar", "0");
                                    }
                                    ActivityOptions op = ActivityOptions.makeCustomAnimation(views.getAsView().getContext(), R.anim.fade_in, R.anim.fade_out);
                                    // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                                    views.getViewManager().getContext().getActvityAllt().startActivity(intent, op.toBundle());
                                    String prograssnam = "0";
                                    try {
                                        //  prograssnam =anoth[0];//enabprograss
                                    } catch (Exception ex) {

                                    }
                                }else {
                                    Value fd=addvalueto("@"+NameActivity,resul,showtool,showdarwer);
                                    views.getViewManager().getContext().getAllEven("Open_Activity").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), fd, 0, views, fd);
                                }




                            } catch (Exception ex) {
                                //  even.sendEventA(null,6767,null);
                                //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji@@vvvv" + ex.getMessage());
                                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                // loadrefd();
                                // masss.showmessage(ex.getMessage());
                                // stoptimertask();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            try {

                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                if (OflineKey.equals("1")) {
                                    // String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                    // FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
                                    //if(uk.getItemCount()==0) {

                                    ScriptModel g = new ScriptModel(0, "no", OflinevalueKey);
                                    DatabaseHelper db_operations;
                                    db_operations = new DatabaseHelper(views.getAsView().getContext());
                                    List<ScriptModel> x = db_operations.getAllNotes(g);
                                    String val = x.get(0).getContent();


                                    // views.getViewManager().getContext().getAllEven("After_Process").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    Value temppx = views.getViewManager().getContext().getvalueFromString(val, keysname);
                                    String resul = temppx.getAsObject().getAsString("Result");
                                    //  intent.putExtra("data", dv);
                                    if (NameActivity.equals("0")) {
                                        Intent intent = new Intent(views.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);

                                        if (showdarwer) {
                                            intent.putExtra("Drawer", "1");

                                        } else {
                                            intent.putExtra("Drawer", "0");
                                        }
                                        if (showtool) {
                                            intent.putExtra("Toolbar", "1");

                                        } else {
                                            intent.putExtra("Toolbar", "0");
                                        }
                                        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.putExtra("data", resul);
                                        ActivityOptions op = ActivityOptions.makeCustomAnimation(views.getAsView().getContext(), R.anim.fade_in, R.anim.fade_out);
                                        // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                                        views.getViewManager().getContext().getActvityAllt().startActivity(intent, op.toBundle());
                                    }else {
                                        Value fd=addvalueto("@"+NameActivity,resul,showtool,showdarwer);
                                        views.getViewManager().getContext().getAllEven("Open_Activity").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), fd, 0, views, fd);
                                    }


                                }
                                showmessagea(error.getMessage(), 2);
                            }catch (Exception ex){

                            }
                        }
                    }){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            return hedermapx;
                        }

                        @Override
                        public String getBodyContentType() {
                            return contettyp;
                        }

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            return quert;
                        }
                    };
                    setPloyices(rrrr);
                    q.add(rrrr);
                    //}
                }else{
                    final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(URL).create(retrofit_dynimcic.class);
                    RequestBody requestBodyBinary = null;

                    requestBodyBinary = RequestBody.create(MediaType.parse(contettyp), requestbody);

                    // sendreq(params[0],params[1],params[2]);
                    Call<ResponseBody> call = Postmethod.toLowerCase().equals("post") ? Retrofitapi.PostMethod(URL2, requestBodyBinary, hedermap, quarymap) : Retrofitapi.GetMethod(URL, hedermap, quarymap);
                    // Log.i("0000xx",params[12]);
                    call.enqueue(new Callback<ResponseBody>() {

                        private void showmessage(String mes, int typ) {


                            // String kk=mes; //response.errorBody().string();
                            String kk = "";
                            if (!checkjson(mes)) {
                                mes = mes.replace("\"", "\\\"");
                                // mes=mes.replace('"',' ');
                                kk = "\"" + mes + "\"";
                            } else {
                                kk = mes;
                            }
                            String xv = "\"Message\":" + kk + "";
                            String k = "{Result:{" + xv + "}}";
                            // String kx="{\"Result\":{"+xv+"}}";
                            Gson g = views.getViewManager().getContext().getJson();
                            Type type = new TypeToken<Value>() {

                            }.getType();
                            ObjectValue tempp = g.fromJson(k, type);
                            try {
                                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), tempp, typ, views, tempp);
                            } catch (Exception ex) {

                            }
                        }

                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                            try {
                                assert response.body() != null;
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                //   showResult(response.body().string(),protvv.getAsView());
                                //  String x="mydesin";

                                if (response.isSuccessful()) {

                                    String kk = response.body().string();
                                    // assert response.errorBody() != null;
                               /* try {
                                    //String responseKey = "0";//params[11];

                                    if (!responseKey.equals("0")) {
                                        JSONObject js = new JSONObject(kk);
                                        kk = js.get(responseKey).toString();
                                    }
                                } catch (Exception ex) {

                                }*/
                                    String k = "{data:" + kk + "}";
                                    if (RefeshKey.equals("1")) {
                                        try {

                                            if (OflineKey.equals("1")) {
                                                String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                                ScriptModel g = new ScriptModel(0, k, mng);
                                                DatabaseHelper db_operations;
                                                db_operations = new DatabaseHelper(views.getAsView().getContext());
                                                db_operations.insert(g);
                                            }
                                        } catch (Exception ex) {

                                        }

                                    } else {
                                    }
                              /*  Gson g = views.getViewManager().getContext().getJson();
                                Type type = new TypeToken<Value>() {

                                }.getType();
                                ObjectValue tempp = g.fromJson(k, type);
                                tempp.add("show_as_message", new Primitive(RefeshKeyasMessage));
                                tempp.add("show_as_messagekey", new Primitive(RefeshKeyasMessageKeyval));
                                tempp.add("show_as_messagekeytyp", new Primitive(0));
                                tempp.add("show_as_messagetext", new Primitive(RefeshKeyasMessage == "1" ? "nomes" : kk));*/

                                    views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    Value temppx= views.getViewManager().getContext().getvalueFromString(k,keysname);
                                    String resul=temppx.getAsObject().getAsString("Result");
                                    //  intent.putExtra("data", dv);

                                    Intent intent = new Intent(views.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                                    if(showdarwer){
                                        intent.putExtra("Drawer", "1");

                                    }else {
                                        intent.putExtra("Drawer", "0");
                                    }
                                    if(showtool){
                                        intent.putExtra("Toolbar", "1");

                                    }else {
                                        intent.putExtra("Toolbar", "0");
                                    }

                                    // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.putExtra("data", resul);
                                    views.getViewManager().getContext().getActvityAllt().startActivity(intent);


                                    //    Log.i("0000xx",k);
                                    String prograssnam = "0";
                                    try {
                                        //  prograssnam =anoth[0];//enabprograss
                                    } catch (Exception ex) {

                                    }


                                } else {
                                    try {
                                        assert response.errorBody() != null;


                                        String kk = response.errorBody().string();
                                        showmessage(kk, 2);
                                    } catch (IOException ex) {

                                        //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                        //  even.sendEventA(null,6767,null);
                                        // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                        // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                    }
                                }


                            } catch (Exception ex) {
                                showmessage(ex.getMessage(), 2);
                                //  even.sendEventA(null,6767,null);
                                //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                // loadrefd();
                                // masss.showmessage(ex.getMessage());
                                // stoptimertask();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            //  stoptimertask();
                            try {

                                String respon = t.getMessage();
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String responseKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";
                                String wwe = "0";
                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
                                if (t.getMessage().startsWith("Unable to resolve host")) {
                                    try {

                                        if (OflineKey.equals("1")) {
                                            // String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            // FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
                                            //if(uk.getItemCount()==0) {

                                            ScriptModel g = new ScriptModel(0, "no", OflinevalueKey);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(views.getAsView().getContext());
                                            List<ScriptModel> x = db_operations.getAllNotes(g);
                                            String val = x.get(0).getContent();


                                            views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                            Value temppx= views.getViewManager().getContext().getvalueFromString(val,keysname);
                                            String resul=temppx.getAsObject().getAsString("Result");
                                            //  intent.putExtra("data", dv);

                                            Intent intent = new Intent(views.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                                            // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            intent.putExtra("data", resul);
                                            ActivityOptions op=ActivityOptions.makeCustomAnimation(views.getAsView().getContext(),R.anim.fade_in,R.anim.fade_out);
                                            // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                                            views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());

                                        } else {


                                        }
                                    } catch (Exception ex) {

                                    }
                                    showmessage(GlobalClass.MessageErorr, 2);
                                } else {

                                    showmessage(t.getMessage(), 2);

                                }


                            } catch (Exception ex) {

                            }
                        }
                    });
                }


            } catch (Exception ex) {

                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                //  loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return "";
        }
        private void showResult(String result, View c) {
            new AlertDialog.Builder(c.getContext())
                    .setMessage(result)
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

        @Override
        protected void onPostExecute(String result) {
            try {

            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(String... text) {
            // finalResult.setText(text[0]);

        }
    }

    class AsyncTaskRunnervFromUrlshit extends AsyncTask<String, String, String> {

        private Value  resp;
        private List<DataValueSelect> value;
        private ObjectValue  fd;
        private ProteusView views;
        boolean useoffline=false;
        Value afterprocess;
        private boolean usevolleys;
        private  boolean showtool;
        private boolean showdarwer;
        String keysname;
        private  String NameActivity;
        AsyncTaskRunnervFromUrlshit(Value val, ProteusView viewss,Value afterprocesss,boolean usevolleyss,boolean tol,boolean dra,String NameActivity,List<DataValueSelect> valuex,ObjectValue obk) {

this.fd=obk;
this.value=valuex;
            this.resp=val;
            this.views=viewss;
            this.afterprocess=afterprocesss;
            this.usevolleys=usevolleyss;
            this.showdarwer=dra;
            this.showtool=tol;
            this.NameActivity=NameActivity;

        }
        private void showmessagea(String mes, int typ) {


            // String kk=mes; //response.errorBody().string();
            String kk = "";
            if (!checkjson(mes)) {
                mes = mes.replace("\"", "\\\"");
                //mes=mes.replace('"',' ');
                kk = "\"" + mes + "\"";
            } else {
                kk = mes;
            }
            //response.errorBody().string();
          /*  String xv = "\"Message\":" + kk + "";
            String k = "{Result:{" + xv + "}}";
            // String kx="{\"Result\":{"+xv+"}}";
            Gson g = views.getViewManager().getContext().getJson();
            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = g.fromJson(k, type);

            Log.e("uuuu",k);*/

            try {
                Value temppx= views.getViewManager().getContext().getvalueFromString(kk,keysname);
                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), temppx, typ, views, temppx);
            } catch (Exception ex) {
                Log.e("uuuukk",ex.getMessage());
            }
        }
        @Override
        protected String doInBackground(final String... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);
                Map<String, Object> hedermap = new HashMap<>();//Map<String, Object>();
                HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
                Map<String, String> hedermapVolley = new HashMap<>();//Map<String, Object>();
                // HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
                String URL = "no";
                String URL2 = "no";
                String Postmethod = "no";
                String requestbody = "nos";
                final String refresh = "0";///params[3];
                List<hedaerOrQuary> responsee = new ArrayList<>();
                //final String without=params[4];
                //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);
                Map<String, List<hedaerOrQuary>> ertu = new HashMap<>(); //getvaluuusHeder(resp,1);
                Iterator<Map.Entry<String, Value>> tdfdx = resp.getAsObject().entrySet().iterator();
                while (tdfdx.hasNext()) {
                    Map.Entry<String, Value> wr = tdfdx.next();
                    if (wr.getValue().isArray()) {
                        if (wr.getKey().toLowerCase().equals("sender_data")) {
                            Iterator<Value> aru = wr.getValue().getAsArray().get(0).getAsObject().getAsArray("API_Data").iterator();
                            while (aru.hasNext()) {
                                Value wrk = aru.next();
//Request_Body

                                //Url
                                //Request_Query
                                //Type_Url
                                String urll = wrk.getAsObject().getAsString("Url");
                                String meth = wrk.getAsObject().getAsString("Type_Url");
                                Postmethod = wrk.getAsObject().getAsString("Method_Type");

                                String urlll = urldata(urll, meth);

                                String[] datt = urlll.split("#");
                                URL = datt[0];
                                URL2 = datt[1];


                                //  List<hedaerOrQuary> eru=    wr.getValue();

                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Header").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        hedermap.put(keynam, keynamm);
                                        hedermapVolley.put(keynam,keynamm);
                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Query").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        quarymap.put(keynam, keynamm);

                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    int cou = 0;
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Body").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        cou = cou + 1;
                                        if (cou == 1) {
                                            // String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                            requestbody = wrkm.getAsObject().getAsString("Key_Value");
                                            //quarymap.put(keynam, keynamm);
                                        }
                                    }
                                } catch (Exception ex) {

                                }
                                List<hedaerOrQuary> eru = new ArrayList<>();
                                try {
                                    int cou = 0;

                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Response_Data").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();

                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String valuu = wrkm.getAsObject().getAsString("Key_Value");
                                        String valuuv = wrkm.getAsObject().getAsString("Key_Type");
                                        hedaerOrQuary stt = new hedaerOrQuary(keynam, valuu, valuuv, "0");
                                        eru.add(stt);
                                        //quarymap.put(keynam, keynamm);

                                    }

                                } catch (Exception ex) {
                                    Log.i("yyykm",ex.getMessage());
                                }

                                responsee = eru;

                                Gson ddd = new Gson();
                                // Log.i("yyy",ddd.toJson(wrk));
                                //  Iterator<Map.Entry<String, Value>> vu=wrk.getAsObject().entrySet().iterator();


                            }
                        }


                    }

                }


                final List<hedaerOrQuary> res = responsee;
                //    String contettyp = "application/json; charset=UTF-8";
                String userAgentt = "fromandroid";
                final String contettyp = "application/json; charset=UTF-8";
                final  String bodys=requestbody;
                final   Map<String, String> hedermapx =hedermapVolley; //new HashMap<>();//Map<String, Object>();
                final   Map<String, String> quert= quarymap;
                //  String userAgentt = "fromandroid";
                if(usevolleys){

                    //  public  void settreq(final String auth, final String usertyp, final String email){
                    // String BASE_URL = "http://192.168.1.101:80/api/astoolacount/login";

                    RequestQueue q= Volley.newRequestQueue(views.getAsView().getContext());
                    int typmethod=Request.Method.POST;
                    if(Postmethod.toLowerCase().startsWith("g")){
                        typmethod=Request.Method.GET;
                    }
                    if(Postmethod.toLowerCase().startsWith("d")){
                        typmethod=Request.Method.DELETE;
                    }
                    if(Postmethod.toLowerCase().startsWith("pu")){
                        typmethod=Request.Method.PUT;
                    }
                    if(Postmethod.toLowerCase().startsWith("pa")){
                        typmethod=Request.Method.PATCH;
                    }
                    if(Postmethod.toLowerCase().startsWith("h")){
                        typmethod=Request.Method.HEAD;
                    }
                    Log.i("myurl",URL + URL2);
                    CustomStringRequest rrrr=new CustomStringRequest(typmethod, URL + URL2, requestbody, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                assert response != null;
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Gson f=new Gson();
                                Log.i("trrrrrrbbbb",f.toJson(res));
                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                //   showResult(response.body().string(),protvv.getAsView());
                                //  String x="mydesin";
                                //    Log.i("0000xx",response.body().string());


                                String kk = response;//.body().string();
                                // assert response.errorBody() != null;
                                try {
                                    //String responseKey = "0";//params[11];

                                       /* if (!responseKey.equals("0")) {
                                            JSONObject js = new JSONObject(kk);
                                            kk = js.get(responseKey).toString();
                                        }*/
                                } catch (Exception ex) {

                                }
                                /// String k = "{s1:" + kk + "}";
                                if (RefeshKey.equals("1")) {
                                    try {

                                        if (OflineKey.equals("1")) {
                                            String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            ScriptModel g = new ScriptModel(0, kk, mng);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(views.getAsView().getContext());
                                            db_operations.insert(g);
                                        }
                                    } catch (Exception ex) {

                                    }

                                } else {
                                }
                                   /* Gson g = views.getViewManager().getContext().getJson();
                                    Type type = new TypeToken<Value>() {

                                    }.getType();*/
                                Log.i("trrrrrr","hhhhhhhhhhhhhhhhhhhhhhhhh");
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                Log.i("trrrrrr","hhhhhhhhhhhhhhhhhhhhhhhhh");
                                Value temppx = views.getViewManager().getContext().getvalueFromString(kk, keysname);
                                Log.i("trrrrrr","ffxffxffx");
                                String resul = temppx.getAsObject().getAsString("Result");


                                if(NameActivity.equals("0")) {

                                    //  intent.putExtra("data", dv);





                                    BottomShitDaloge re=BottomShitDaloge.newInstance(false,views.getViewManager(),resul, fd,true);//.show(getFragmentManager(),"kjhhg");

                                    // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                                    re.show(views.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                                    ViewGroup ssep = re.getContiner();


                                    GetValueFromView(ssep, value,3);

                                   // ActivityOptions op = ActivityOptions.makeCustomAnimation(views.getAsView().getContext(), R.anim.fade_in, R.anim.fade_out);
                                   // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
                                   // views.getViewManager().getContext().getActvityAllt().startActivity(intent, op.toBundle());
                                    String prograssnam = "0";
                                    try {
                                        //  prograssnam =anoth[0];//enabprograss
                                    } catch (Exception ex) {

                                    }
                                }else {
                                    BottomShitDaloge re=BottomShitDaloge.newInstance(false,views.getViewManager(),resul, fd,true);//.show(getFragmentManager(),"kjhhg");
                                    Log.i("trrrrrr","opopopo");
                                    // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                                    re.show(views.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                                    ViewGroup ssep = re.getContiner();


                                    GetValueFromView(ssep, value,3);
                                }




                            } catch (Exception ex) {
                                //  even.sendEventA(null,6767,null);
                                //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji@@vvvv" + ex.getMessage());
                                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                // loadrefd();
                                // masss.showmessage(ex.getMessage());
                                // stoptimertask();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            try {

                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                if (OflineKey.equals("1")) {
                                    // String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                    // FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
                                    //if(uk.getItemCount()==0) {

                                    ScriptModel g = new ScriptModel(0, "no", OflinevalueKey);
                                    DatabaseHelper db_operations;
                                    db_operations = new DatabaseHelper(views.getAsView().getContext());
                                    List<ScriptModel> x = db_operations.getAllNotes(g);
                                    String val = x.get(0).getContent();


                                    // views.getViewManager().getContext().getAllEven("After_Process").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    Value temppx = views.getViewManager().getContext().getvalueFromString(val, keysname);
                                    String resul = temppx.getAsObject().getAsString("Result");
                                    //  intent.putExtra("data", dv);
                                    if (NameActivity.equals("0")) {

                                        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        BottomShitDaloge re=BottomShitDaloge.newInstance(false,views.getViewManager(),resul, fd,true);//.show(getFragmentManager(),"kjhhg");

                                        // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                                        re.show(views.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                                        ViewGroup ssep = re.getContiner();


                                        GetValueFromView(ssep, value,3);
                                    }else {
                                        BottomShitDaloge re=BottomShitDaloge.newInstance(false,views.getViewManager(),resul, fd,true);//.show(getFragmentManager(),"kjhhg");

                                        // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                                        re.show(views.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                                        ViewGroup ssep = re.getContiner();


                                        GetValueFromView(ssep, value,3);
                                    }


                                }
                                showmessagea(error.getMessage(), 2);
                            }catch (Exception ex){

                            }
                        }
                    }){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            return hedermapx;
                        }

                        @Override
                        public String getBodyContentType() {
                            return contettyp;
                        }

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            return quert;
                        }
                    };
                    setPloyices(rrrr);
                    q.add(rrrr);
                    //}
                }else{
                    final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(URL).create(retrofit_dynimcic.class);
                    RequestBody requestBodyBinary = null;

                    requestBodyBinary = RequestBody.create(MediaType.parse(contettyp), requestbody);

                    // sendreq(params[0],params[1],params[2]);
                    Call<ResponseBody> call = Postmethod.toLowerCase().equals("post") ? Retrofitapi.PostMethod(URL2, requestBodyBinary, hedermap, quarymap) : Retrofitapi.GetMethod(URL, hedermap, quarymap);
                    // Log.i("0000xx",params[12]);
                    call.enqueue(new Callback<ResponseBody>() {

                        private void showmessage(String mes, int typ) {


                            // String kk=mes; //response.errorBody().string();
                            String kk = "";
                            if (!checkjson(mes)) {
                                mes = mes.replace("\"", "\\\"");
                                // mes=mes.replace('"',' ');
                                kk = "\"" + mes + "\"";
                            } else {
                                kk = mes;
                            }
                            String xv = "\"Message\":" + kk + "";
                            String k = "{Result:{" + xv + "}}";
                            // String kx="{\"Result\":{"+xv+"}}";
                            Gson g = views.getViewManager().getContext().getJson();
                            Type type = new TypeToken<Value>() {

                            }.getType();
                            ObjectValue tempp = g.fromJson(k, type);
                            try {
                                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), tempp, typ, views, tempp);
                            } catch (Exception ex) {

                            }
                        }

                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                            try {
                                assert response.body() != null;
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                //   showResult(response.body().string(),protvv.getAsView());
                                //  String x="mydesin";

                                if (response.isSuccessful()) {

                                    String kk = response.body().string();
                                    // assert response.errorBody() != null;
                               /* try {
                                    //String responseKey = "0";//params[11];

                                    if (!responseKey.equals("0")) {
                                        JSONObject js = new JSONObject(kk);
                                        kk = js.get(responseKey).toString();
                                    }
                                } catch (Exception ex) {

                                }*/
                                    String k = "{data:" + kk + "}";
                                    if (RefeshKey.equals("1")) {
                                        try {

                                            if (OflineKey.equals("1")) {
                                                String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                                ScriptModel g = new ScriptModel(0, k, mng);
                                                DatabaseHelper db_operations;
                                                db_operations = new DatabaseHelper(views.getAsView().getContext());
                                                db_operations.insert(g);
                                            }
                                        } catch (Exception ex) {

                                        }

                                    } else {
                                    }
                              /*  Gson g = views.getViewManager().getContext().getJson();
                                Type type = new TypeToken<Value>() {

                                }.getType();
                                ObjectValue tempp = g.fromJson(k, type);
                                tempp.add("show_as_message", new Primitive(RefeshKeyasMessage));
                                tempp.add("show_as_messagekey", new Primitive(RefeshKeyasMessageKeyval));
                                tempp.add("show_as_messagekeytyp", new Primitive(0));
                                tempp.add("show_as_messagetext", new Primitive(RefeshKeyasMessage == "1" ? "nomes" : kk));*/

                                    views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    Value temppx= views.getViewManager().getContext().getvalueFromString(k,keysname);
                                    String resul=temppx.getAsObject().getAsString("Result");
                                    //  intent.putExtra("data", dv);



                                    // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    BottomShitDaloge re=BottomShitDaloge.newInstance(false,views.getViewManager(),resul, fd,true);//.show(getFragmentManager(),"kjhhg");

                                    // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                                    re.show(views.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                                    ViewGroup ssep = re.getContiner();

                                    //    Log.i("0000xx",k);
                                    String prograssnam = "0";
                                    try {
                                        //  prograssnam =anoth[0];//enabprograss
                                    } catch (Exception ex) {

                                    }


                                } else {
                                    try {
                                        assert response.errorBody() != null;


                                        String kk = response.errorBody().string();
                                        showmessage(kk, 2);
                                    } catch (IOException ex) {

                                        //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                        //  even.sendEventA(null,6767,null);
                                        // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                        // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                    }
                                }


                            } catch (Exception ex) {
                                showmessage(ex.getMessage(), 2);
                                //  even.sendEventA(null,6767,null);
                                //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                // loadrefd();
                                // masss.showmessage(ex.getMessage());
                                // stoptimertask();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            //  stoptimertask();
                            try {

                                String respon = t.getMessage();
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String responseKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";
                                String wwe = "0";
                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                        responseKey = ruo.getKeyValue();
                                        keysname=ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                        OflinevalueKey = ruo.getKeyName();
                                        OflineKey = ruo.getKeyValue();
                                    }
                                    if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                        RefeshKey = ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                        RefeshKeyasMessage = ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval = ruo.getKeyName();
                                    }
                                }
                                // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
                                if (t.getMessage().startsWith("Unable to resolve host")) {
                                    try {

                                        if (OflineKey.equals("1")) {
                                            // String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            // FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
                                            //if(uk.getItemCount()==0) {

                                            ScriptModel g = new ScriptModel(0, "no", OflinevalueKey);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(views.getAsView().getContext());
                                            List<ScriptModel> x = db_operations.getAllNotes(g);
                                            String val = x.get(0).getContent();


                                            views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                            Value temppx= views.getViewManager().getContext().getvalueFromString(val,keysname);
                                            String resul=temppx.getAsObject().getAsString("Result");
                                            //  intent.putExtra("data", dv);

                                            BottomShitDaloge re=BottomShitDaloge.newInstance(false,views.getViewManager(),resul, fd,true);//.show(getFragmentManager(),"kjhhg");

                                            // BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(com.astooltech.advancedview.R.layout.bottom_sheet_item_decoration, this);
                                            re.show(views.getViewManager().getContext().getActvityAllt().getSupportFragmentManager(), re.TAG);
                                            ViewGroup ssep = re.getContiner();

                                        } else {


                                        }
                                    } catch (Exception ex) {

                                    }
                                    showmessage(GlobalClass.MessageErorr, 2);
                                } else {

                                    showmessage(t.getMessage(), 2);

                                }


                            } catch (Exception ex) {

                            }
                        }
                    });
                }


            } catch (Exception ex) {

                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                //  loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return "";
        }
        private void showResult(String result, View c) {
            new AlertDialog.Builder(c.getContext())
                    .setMessage(result)
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

        @Override
        protected void onPostExecute(String result) {
            try {

            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(String... text) {
            // finalResult.setText(text[0]);

        }
    }


    class AsyncTaskRunnervForRecyclek extends AsyncTask<String, String, String> {
        private Value  resp;
        private ProteusView views;
        public AsyncTaskRunnervForRecyclek(){


        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }

  public  class AsyncTaskRunnervForRecycle extends AsyncTask<String, String, String> {

        private Value  resp;
        private ProteusView views;
        boolean useoffline=false;
        Value afterprocess;
        private IValuesData Ivdat;
        Value multiplc;
        boolean usemul=false;
        ProteusLayoutInflater inflatrx;
        Layout defults;
        private  ProteusView.Manager.ActionEventViewForUto Idata;
        private  String keysname;
        boolean usevolleys;
        private   boolean usesearch;
        AsyncTaskRunnervForRecycle(Value val, ProteusView viewss,Value afterprocesss,ProteusView.Manager.ActionEventViewForUto Idataa,IValuesData Ivdatt,  boolean usevolleyss,boolean usesearchh) {


            this.Idata=Idataa;
            this.Ivdat=Ivdatt;
            this.resp=val;
            this.views=viewss;
            this.afterprocess=afterprocesss;
            this.usevolleys=usevolleyss;
            this.usesearch=usesearchh;


        }

        private Value getvalueFromString(String datall,String keyselect){
            try {
                Array h = new Array();
                Gson g = views.getViewManager().getContext().getJson();
                Type type = new TypeToken<Value>() {

                }.getType();
                ObjectValue tempp = g.fromJson(datall, type);
           /* String[] resull=keyselect.split(".");
Value resul=null;*/

                Value er = tempp.getAsBinding(keyselect.replace('#', '@')).getAsObject();

                return er;
            }catch (Exception ex){
                Log.e("f555",ex.getMessage());
            }


            Array er=new Array();
            return  er;
        }
        private void showmessagea(String mes, int typ) {


            // String kk=mes; //response.errorBody().string();
            String kk = "";
            if (!checkjson(mes)) {
                mes = mes.replace("\"", "\\\"");
                //mes=mes.replace('"',' ');
                kk = "\"" + mes + "\"";
            } else {
                kk = mes;
            }
            //response.errorBody().string();
          /*  String xv = "\"Message\":" + kk + "";
            String k = "{Result:{" + xv + "}}";
            // String kx="{\"Result\":{"+xv+"}}";
            Gson g = views.getViewManager().getContext().getJson();
            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = g.fromJson(k, type);

            Log.e("uuuu",k);*/

            try {
                Value temppx= views.getViewManager().getContext().getvalueFromString(kk,keysname);
                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), temppx, typ, views, temppx);
            } catch (Exception ex) {
                Log.e("uuuukk",ex.getMessage());
            }
        }
        @Override
        protected String doInBackground(final String... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);
                Map<String, Object> hedermap = new HashMap<>();//Map<String, Object>();
                Map<String, String> hedermapVolley = new HashMap<>();//Map<String, Object>();
                HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
                String URL = "no";
                String URL2 = "no";
                String Postmethod = "no";
                String requestbody = "nos";
                final String refresh = "0";///params[3];
                List<hedaerOrQuary> responsee = new ArrayList<>();
                boolean UseCustomData = false;
                ObjectValue mCustomedata = new ObjectValue();
                //final String without=params[4];
                //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);
                Map<String, List<hedaerOrQuary>> ertu = new HashMap<>(); //getvaluuusHeder(resp,1);
                Iterator<Map.Entry<String, Value>> tdfdx = resp.getAsObject().entrySet().iterator();
                while (tdfdx.hasNext()) {
                    Map.Entry<String, Value> wr = tdfdx.next();
                    if (wr.getKey().toLowerCase().equals("custome_data")) {

                        UseCustomData = true;


                        if(wr.getValue().isArray()){
                            mCustomedata.add("Result", wr.getValue());
                        }else{
                          Value valm=  views.getViewManager().getContext().getDataFrom_DataLayout(wr.getValue().getAsString());
                           mCustomedata.add("Result",  valm);
                        }



                    }
                    if (wr.getKey().toLowerCase().equals("multiple_views")) {
                        usemul = true;
                        multiplc = wr.getValue();
                        Gson fyy = new Gson();


                        defults = wr.getValue().getAsObject().getAsLayout("Def_Views");//.getAsString("");
                        // defults=views.getViewManager().getContext().getLayout(defull);
                        inflatrx = views.getViewManager().getContext().getInflater();

                    }
if(!UseCustomData){
                    if (wr.getValue().isArray()) {
                        if (wr.getKey().toLowerCase().equals("sender_data")) {

                            Array arys=null;
                            if(this.usesearch){
                                arys= wr.getValue().getAsArray().get(0).getAsObject().getAsArray("API_Data_Search");

                            }else{

                                arys= wr.getValue().getAsArray().get(0).getAsObject().getAsArray("API_Data");
                            }

                            Iterator<Value> aru = arys.iterator();
                            while (aru.hasNext()) {
                                Value wrk = aru.next();
//Request_Body

                                //Url
                                //Request_Query
                                //Type_Url
                                String urll = wrk.getAsObject().getAsString("Url");
                                String meth = wrk.getAsObject().getAsString("Type_Url");
                                Postmethod = wrk.getAsObject().getAsString("Method_Type");

                                String urlll = urldata(urll, meth);

                                String[] datt = urlll.split("#");
                                URL = datt[0];
                                URL2 = datt[1];


                                //  List<hedaerOrQuary> eru=    wr.getValue();

                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Header").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        hedermap.put(keynam, keynamm);
                                        hedermapVolley.put(keynam, keynamm);

                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Query").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        quarymap.put(keynam, keynamm);

                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    int cou = 0;
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Body").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        cou = cou + 1;
                                        if (cou == 1) {
                                            // String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                            requestbody = wrkm.getAsObject().getAsString("Key_Value");
                                            //quarymap.put(keynam, keynamm);
                                        }
                                    }
                                } catch (Exception ex) {

                                }

                                try {
                                    int cou = 0;
                                    List<hedaerOrQuary> eru = new ArrayList<>();
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Response_Data").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();

                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String valuu = wrkm.getAsObject().getAsString("Key_Value");
                                        String valuuv = wrkm.getAsObject().getAsString("Key_Type");
                                        hedaerOrQuary stt = new hedaerOrQuary(keynam, valuu, valuuv, "0");
                                        eru.add(stt);
                                        //quarymap.put(keynam, keynamm);

                                    }
                                    responsee = eru;
                                } catch (Exception ex) {

                                }


                                //   Gson ddd=new Gson();
                                //  Log.i("yyy",ddd.toJson(wrk));
                                //  Iterator<Map.Entry<String, Value>> vu=wrk.getAsObject().entrySet().iterator();


                            }
                        }


                    }}

                }


                final List<hedaerOrQuary> res = responsee;
                final String contettyp = "application/json; charset=UTF-8";
                final String bodys = requestbody;
                final Map<String, String> hedermapx = hedermapVolley; //new HashMap<>();//Map<String, Object>();
                final Map<String, String> quert = quarymap;
                String userAgentt = "fromandroid";
                boolean checvollye = false;
                if (UseCustomData) {

                    // Value temppx = views.getViewManager().getContext().getvalueFromString(kk, keysname);
                    Gson y = new Gson();
                   // views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                    // Log.e("dddmmm", y.toJson(temppx));
                    Map<String, List<AbstractFlexibleItem>> r = getDataAllDataFromString(multiplc, mCustomedata, defults, inflatrx);
                    Ivdat.setDataAdvanced(r, 0);
                  try {
                      views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                  }catch (Exception ex){

                  }
                  }
                else{
                    if (usevolleys) {

                        //  public  void settreq(final String auth, final String usertyp, final String email){
                        // String BASE_URL = "http://192.168.1.101:80/api/astoolacount/login";

                        RequestQueue q = Volley.newRequestQueue(views.getAsView().getContext());
                        int typmethod = Request.Method.POST;
                        if (Postmethod.toLowerCase().startsWith("g")) {
                            typmethod = Request.Method.GET;
                        }
                        if (Postmethod.toLowerCase().startsWith("d")) {
                            typmethod = Request.Method.DELETE;
                        }
                        if (Postmethod.toLowerCase().startsWith("pu")) {
                            typmethod = Request.Method.PUT;
                        }
                        if (Postmethod.toLowerCase().startsWith("pa")) {
                            typmethod = Request.Method.PATCH;
                        }
                        if (Postmethod.toLowerCase().startsWith("h")) {
                            typmethod = Request.Method.HEAD;
                        }
                        CustomStringRequest rrrr = new CustomStringRequest(typmethod, URL + URL2, requestbody, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    assert response != null;
                                    String responseKey = "0";
                                    String OflineKey = "0";
                                    String OflinevalueKey = "0";
                                    String RefeshKey = "0";
                                    String RefeshKeyasMessage = "0";
                                    String RefeshKeyasMessageKeyval = "0";

                                    Iterator<hedaerOrQuary> wff = res.iterator();
                                    while (wff.hasNext()) {
                                        hedaerOrQuary ruo = wff.next();

                                        if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                            responseKey = ruo.getKeyValue();
                                            keysname = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                            OflinevalueKey = ruo.getKeyName();
                                            OflineKey = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                            RefeshKey = ruo.getKeyValue();
                                            //RefeshKey="1";
                                        }
                                        if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                            RefeshKeyasMessage = ruo.getKeyValue();
                                            //"1";
                                            RefeshKeyasMessageKeyval = ruo.getKeyName();
                                        }
                                    }
                                    //   showResult(response.body().string(),protvv.getAsView());
                                    //  String x="mydesin";
                                    //    Log.i("0000xx",response.body().string());


                                    String kk = response;//.body().string();
                                    // assert response.errorBody() != null;
                                    try {
                                        //String responseKey = "0";//params[11];

                                       /* if (!responseKey.equals("0")) {
                                            JSONObject js = new JSONObject(kk);
                                            kk = js.get(responseKey).toString();
                                        }*/
                                    } catch (Exception ex) {

                                    }
                                    /// String k = "{s1:" + kk + "}";
                                    if (RefeshKey.equals("1")) {
                                        try {

                                            if (OflineKey.equals("1")) {
                                                String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                                ScriptModel g = new ScriptModel(0, kk, mng);
                                                DatabaseHelper db_operations;
                                                db_operations = new DatabaseHelper(views.getAsView().getContext());
                                                db_operations.insert(g);
                                            }
                                        } catch (Exception ex) {

                                        }

                                    } else {
                                    }
                                   /* Gson g = views.getViewManager().getContext().getJson();
                                    Type type = new TypeToken<Value>() {

                                    }.getType();*/
                                    ObjectValue tempp = new ObjectValue();
                                    tempp.add("show_as_message", new Primitive(RefeshKeyasMessage));
                                    tempp.add("show_as_messagekey", new Primitive(RefeshKeyasMessageKeyval));
                                    tempp.add("show_as_messagekeytyp", new Primitive(0));
                                    tempp.add("show_as_messagetext", new Primitive(RefeshKeyasMessage == "1" ? "nomes" : kk));
                                    // Log.e("ddd",kk);
                                    if (usemul) {
                                        Value temppx = views.getViewManager().getContext().getvalueFromString(kk, keysname);
                                        Gson y = new Gson();
                                        // Log.e("dddmmm", y.toJson(temppx));
                                        Map<String, List<AbstractFlexibleItem>> r = getDataAllDataFromString(multiplc, temppx, defults, inflatrx);
                                        Ivdat.setDataAdvanced(r, 0);
                                    } else {
                                        Idata.sendEventA(tempp, 67606, kk);
                                    }
                                    //   views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
                                    views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    String prograssnam = "0";
                                    try {
                                        //  prograssnam =anoth[0];//enabprograss
                                    } catch (Exception ex) {

                                    }


                                } catch (Exception ex) {
                                    //  even.sendEventA(null,6767,null);
                                    //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                    //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji@@" + ex.getMessage());
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                    // loadrefd();
                                    // masss.showmessage(ex.getMessage());
                                    // stoptimertask();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Gson gv = new Gson();
                                try {
                                    String responseKey = "0";
                                    String OflineKey = "0";
                                    String OflinevalueKey = "0";
                                    String RefeshKey = "0";
                                    String RefeshKeyasMessage = "0";
                                    String RefeshKeyasMessageKeyval = "0";

                                    Iterator<hedaerOrQuary> wff = res.iterator();
                                    while (wff.hasNext()) {
                                        hedaerOrQuary ruo = wff.next();

                                        if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                            responseKey = ruo.getKeyValue();
                                            keysname = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                            OflinevalueKey = ruo.getKeyName();
                                            OflineKey = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                            RefeshKey = ruo.getKeyValue();
                                            //RefeshKey="1";
                                        }
                                        if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                            RefeshKeyasMessage = ruo.getKeyValue();
                                            //"1";
                                            RefeshKeyasMessageKeyval = ruo.getKeyName();
                                        }
                                    }
                                    //  views.getViewManager().getContext().getAllEven("After_Process").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    if (OflineKey.equals("1")) {

                                        ScriptModel g = new ScriptModel(0, "no", OflinevalueKey);
                                        DatabaseHelper db_operations;
                                        db_operations = new DatabaseHelper(views.getAsView().getContext());
                                        List<ScriptModel> x = db_operations.getAllNotes(g);
                                        String val = x.get(0).getContent();


                                        if (usemul) {
                                            Value tempp = views.getViewManager().getContext().getvalueFromString(val, keysname);
                                            Map<String, List<AbstractFlexibleItem>> r = getDataAllDataFromString(multiplc, tempp, defults, inflatrx);

                                            Ivdat.setDataAdvanced(r, 0);
                                        } else {
                                            Value tempp = views.getViewManager().getContext().getvalueFromString(val, keysname);
                                            Idata.sendEventA(tempp.getAsObject(), 67606, val);
                                            //  Idata.sendEventA(tempp, 67606,val);
                                        }

                                    }
                                    views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    String da = gv.toJson(Utility.networkResponseToMap(error.networkResponse));
                                    showmessagea(da, 2);
                                    //showmessagea(error.getMessage(), 2);
                                } catch (Exception ex) {
                                    try {

                                        if (!checkNetwork(views.getAsView().getContext())) {
                                            String dataf = "{\" data\":{\"message\":\"" + GlobalClass.MessageErorr + "\"}}";
                                            showmessagea(dataf, 2);
                                        }
                                    }catch (Exception exm){

                                    }
                                }
                            }
                        }) {
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                return hedermapx;
                            }

                            @Override
                            public String getBodyContentType() {
                                return contettyp;
                            }

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                return quert;
                            }
                        };
                        setPloyices(rrrr);
                        q.add(rrrr);
                        //}
                    } else {


                        final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(URL).create(retrofit_dynimcic.class);
                        RequestBody requestBodyBinary = null;

                        requestBodyBinary = RequestBody.create(MediaType.parse(contettyp), requestbody);

                        // sendreq(params[0],params[1],params[2]);
                        Call<ResponseBody> call = Postmethod.toLowerCase().equals("post") ? Retrofitapi.PostMethod(URL2, requestBodyBinary, hedermap, quarymap) : Retrofitapi.GetMethod(URL, hedermap, quarymap);
                        // Log.i("0000xx",params[12]);
                        call.enqueue(new Callback<ResponseBody>() {


                            @Override
                            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                                try {
                                    assert response.body() != null;
                                    String responseKey = "0";
                                    String OflineKey = "0";
                                    String OflinevalueKey = "0";
                                    String RefeshKey = "0";
                                    String RefeshKeyasMessage = "0";
                                    String RefeshKeyasMessageKeyval = "0";

                                    Iterator<hedaerOrQuary> wff = res.iterator();
                                    while (wff.hasNext()) {
                                        hedaerOrQuary ruo = wff.next();

                                        if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                            responseKey = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                            OflinevalueKey = ruo.getKeyName();
                                            OflineKey = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                            RefeshKey = ruo.getKeyValue();
                                            //RefeshKey="1";
                                        }
                                        if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                            RefeshKeyasMessage = ruo.getKeyValue();
                                            //"1";
                                            RefeshKeyasMessageKeyval = ruo.getKeyName();
                                        }
                                    }
                                    //   showResult(response.body().string(),protvv.getAsView());
                                    //  String x="mydesin";
                                    //    Log.i("0000xx",response.body().string());
                                    if (response.isSuccessful()) {

                                        String kk = response.body().string();
                                        // assert response.errorBody() != null;
                             /*   try {
                                    //String responseKey = "0";//params[11];

                                    if (!responseKey.equals("0")) {
                                        JSONObject js = new JSONObject(kk);
                                        kk = js.get(responseKey).toString();
                                    }
                                } catch (Exception ex) {

                                }*/
                                        String k = "{data:" + kk + "}";
                                        if (RefeshKey.equals("1")) {
                                            try {

                                                if (OflineKey.equals("1")) {
                                                    String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                                    ScriptModel g = new ScriptModel(0, k, mng);
                                                    DatabaseHelper db_operations;
                                                    db_operations = new DatabaseHelper(views.getAsView().getContext());
                                                    db_operations.insert(g);
                                                }
                                            } catch (Exception ex) {

                                            }

                                        } else {
                                        }
                              /*  Gson g = views.getViewManager().getContext().getJson();
                                Type type = new TypeToken<Value>() {

                                }.getType();
                                ObjectValue tempp = g.fromJson(k, type);
                                tempp.add("show_as_message", new Primitive(RefeshKeyasMessage));
                                tempp.add("show_as_messagekey", new Primitive(RefeshKeyasMessageKeyval));
                                tempp.add("show_as_messagekeytyp", new Primitive(0));
                                tempp.add("show_as_messagetext", new Primitive(RefeshKeyasMessage == "1" ? "nomes" : kk));*/
                                        Value temppx = views.getViewManager().getContext().getvalueFromString(k, keysname);
                                        if (usemul) {

                                            Map<String, List<AbstractFlexibleItem>> r = getDataAllDataFromString(multiplc, temppx, defults, inflatrx);
                                            Ivdat.setDataAdvanced(r, 0);
                                        } else {
                                            Idata.sendEventA(temppx.getAsObject(), 67606, k);
                                        }
                                        //   views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
                                        views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                        String prograssnam = "0";
                                        try {
                                            //  prograssnam =anoth[0];//enabprograss
                                        } catch (Exception ex) {

                                        }


                                    } else {
                                        try {
                                            assert response.errorBody() != null;


                                            String kk = response.errorBody().string();

                                        } catch (IOException ex) {

                                            //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                            //  even.sendEventA(null,6767,null);
                                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                            Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji@@" + ex.getMessage());
                                        }
                                    }


                                } catch (Exception ex) {
                                    //  even.sendEventA(null,6767,null);
                                    //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                    Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji@@" + ex.getMessage());
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                    // loadrefd();
                                    // masss.showmessage(ex.getMessage());
                                    // stoptimertask();
                                }

                            }

                            private Value showmessagev(String Keyname, int typ) {

                                return null;
                            }

                            private void showmessage(String mes, int typ, String keyname) {


                                // String kk=mes; //response.errorBody().string();
                                String kk = "";
                                if (!checkjson(mes)) {
                                    //mes=mes.replace('"',' ');
                                    mes = mes.replace("\"", "\\\"");
                                    kk = "\"" + mes + "\"";
                                } else {
                                    kk = mes;
                                }
                       /* String xv = "\"Message\":" + kk + "";
                        String k = "{Result:{" + xv + "}}";
                        // String kx="{\"Result\":{"+xv+"}}";
                        Gson g = views.getViewManager().getContext().getJson();
                        Type type = new TypeToken<Value>() {

                        }.getType();
                        ObjectValue tempp = g.fromJson(k, type);*/
                                Value tempp = views.getViewManager().getContext().getvalueFromString(kk, keyname);
                                try {
                                    views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), tempp, typ, views, tempp);
                                } catch (Exception ex) {

                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                //  stoptimertask();
                                try {

                                    String respon = t.getMessage();
                                    views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    String OflineKey = "0";
                                    String OflinevalueKey = "0";
                                    String responseKey = "0";
                                    String RefeshKey = "0";
                                    String RefeshKeyasMessage = "0";
                                    String RefeshKeyasMessageKeyval = "0";
                                    String wwe = "0";
                                    Iterator<hedaerOrQuary> wff = res.iterator();
                                    while (wff.hasNext()) {
                                        hedaerOrQuary ruo = wff.next();

                                        if (ruo.getKeyType().toLowerCase().equals("select_key")) {
                                            responseKey = ruo.getKeyValue();
                                            keysname = ruo.getKeyValue();
                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("offline_key")) {
                                            OflinevalueKey = ruo.getKeyName();
                                            OflineKey = ruo.getKeyValue();

                                        }
                                        if (ruo.getKeyType().toLowerCase().equals("refresh_key")) {
                                            RefeshKey = ruo.getKeyValue();
                                            //RefeshKey="1";
                                        }
                                        if (ruo.getKeyValue().toLowerCase().equals("show_as_message")) {
                                            RefeshKeyasMessage = ruo.getKeyValue();
                                            //"1";
                                            RefeshKeyasMessageKeyval = ruo.getKeyName();
                                        }
                                    }
                                    //  Log.i("fffff", OflineKey + "@@" + OflinevalueKey);
                                    // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
                                    if (t.getMessage().startsWith("Unable to resolve host")) {
                                        try {

                                            if (OflineKey.equals("1")) {

                                                ScriptModel g = new ScriptModel(0, "no", OflinevalueKey);
                                                DatabaseHelper db_operations;
                                                db_operations = new DatabaseHelper(views.getAsView().getContext());
                                                List<ScriptModel> x = db_operations.getAllNotes(g);
                                                String val = x.get(0).getContent();


                                                if (usemul) {
                                                    Value tempp = views.getViewManager().getContext().getvalueFromString(val, keysname);
                                                    Map<String, List<AbstractFlexibleItem>> r = getDataAllDataFromString(multiplc, tempp, defults, inflatrx);

                                                    Ivdat.setDataAdvanced(r, 0);
                                                } else {
                                                    Value tempp = views.getViewManager().getContext().getvalueFromString(val, keysname);
                                                    Idata.sendEventA(tempp.getAsObject(), 67606, val);
                                                    //  Idata.sendEventA(tempp, 67606,val);
                                                }

                                            } else {

                                            }

                                            showmessage(GlobalClass.MessageErorr, 2, keysname);
                                        } catch (Exception ex) {

                                            showmessage(ex.getMessage(), 2, keysname);
                                            //views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),0,views,tempp);
                                            //  views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp.get("s1"),2,views,new Primitive(ex.getMessage()));

                                        }

                                    } else {
                                        showmessage(t.getMessage(), 2, keysname);
                                        //  uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
                                    }


                                } catch (Exception ex) {

                                }
                            }
                        });
                    }
                }

            } catch (Exception ex) {

                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                //  loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return "";
        }
        private void showResult(String result, View c) {
            new AlertDialog.Builder(c.getContext())
                    .setMessage(result)
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

        @Override
        protected void onPostExecute(String result) {
            try {

            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(String... text) {
            // finalResult.setText(text[0]);

        }
    }






    private static    boolean checkNetwork(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    class AsyncTaskRunnervFromUrlSaveTo extends AsyncTask<String, String, String> {

        private Value  resp;
        private ProteusView views;
        boolean useoffline=false;
        Value afterprocess;
        String responsekeyy="0";
        boolean usevolleys;
        AsyncTaskRunnervFromUrlSaveTo(Value val, ProteusView viewss,Value afterprocesss,boolean usevoley) {



            this.resp=val;
            this.views=viewss;
            this.afterprocess=afterprocesss;
            this.usevolleys=usevoley;


        }
        private void loaddata(Value set,ObjectValue get,String keynam){
            Iterator<Map.Entry<String, Value>> tdfdx = get.entrySet().iterator();
            while (tdfdx.hasNext()) {
                Map.Entry<String, Value> ui=tdfdx.next();
                if(keynam.equals(ui.getKey())){

                }else{


                }
            }

        }

        private   boolean checkjsosn(String json){
            boolean ss=false;
            try{
                new JSONObject(json);
                ss=true;
            }catch (JSONException ex){

                try{
                    new JSONArray(json);
                }catch (JSONException ex1){
                    return  false;

                }
            }
            return ss;
        }

        private void showmessagea(String mes, int typ,String keyname ) {

//Log.e("yyyt",mes);
            // String kk=mes; //response.errorBody().string();
            String kk = "";
            if (!checkjson(mes)) {
                mes = mes.replace("\"", "\\\"");
                //mes=mes.replace('"',' ');
                kk = "\"" + mes + "\"";
            } else {
                kk = mes;
            }
            try {
                Value tempp= views.getViewManager().getContext().getvalueFromString(kk,keyname);

                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), tempp, typ, views, tempp);
            } catch (Exception ex) {
                Log.e("uuuukk",ex.getMessage());
            }
        }
        @Override
        protected String doInBackground(final String... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                Map<String, Object> hedermap = new HashMap<>();//Map<String, Object>();
                HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
                HashMap<String, String>  hedermapVolley = new HashMap<>();

                String URL = "no";
                String URL2 = "no";
                String Postmethod = "no";
                String requestbody = "nos";
                final String refresh = "0";///params[3];
                List<hedaerOrQuary> responsee = new ArrayList<>();
                Map<String, List<hedaerOrQuary>> ertu = new HashMap<>(); //getvaluuusHeder(resp,1);
                Iterator<Map.Entry<String, Value>> tdfdx = resp.getAsObject().entrySet().iterator();
                while (tdfdx.hasNext()) {
                    Map.Entry<String, Value> wr = tdfdx.next();
                    if (wr.getValue().isArray()) {
                        if (wr.getKey().toLowerCase().equals("sender_data")) {
                            Iterator<Value> aru = wr.getValue().getAsArray().get(0).getAsObject().getAsArray("API_Data").iterator();
                            while (aru.hasNext()) {
                                Value wrk = aru.next();
                                String urll = wrk.getAsObject().getAsString("Url");
                                String meth = wrk.getAsObject().getAsString("Type_Url");
                                Postmethod = wrk.getAsObject().getAsString("Method_Type");

                                String urlll = urldata(urll, meth);

                                String[] datt = urlll.split("#");
                                URL = datt[0];
                                URL2 = datt[1];


                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Header").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        hedermap.put(keynam, keynamm);
                                        hedermapVolley.put(keynam,keynamm);

                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Query").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String keynamm = wrkm.getAsObject().getAsString("Key_Value");
                                        quarymap.put(keynam, keynamm);

                                    }
                                } catch (Exception ex) {

                                }
                                try {
                                    int cou = 0;
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Request_Body").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();
                                        cou = cou + 1;
                                        if (cou == 1) {
                                            requestbody = wrkm.getAsObject().getAsString("Key_Value");
                                        }
                                    }
                                } catch (Exception ex) {

                                }

                                try {
                                    int cou = 0;
                                    List<hedaerOrQuary> eru = new ArrayList<>();
                                    Iterator<Value> wff = wrk.getAsObject().getAsArray("Response_Data").iterator();
                                    while (wff.hasNext()) {
                                        Value wrkm = wff.next();

                                        String keynam = wrkm.getAsObject().getAsString("Key_Name");
                                        String valuu = wrkm.getAsObject().getAsString("Key_Value");
                                        String valuuv = wrkm.getAsObject().getAsString("Key_Type");
                                        hedaerOrQuary stt = new hedaerOrQuary(keynam, valuu, valuuv, "0");
                                        eru.add(stt);
                                        //quarymap.put(keynam, keynamm);

                                    }
                                    responsee = eru;
                                } catch (Exception ex) {
                                    // Log.e("uuuukbbk",ex.getMessage());
                                }


                                Gson ddd = new Gson();
                                // Log.i("yyy",ddd.toJson(wrk));
                                //  Iterator<Map.Entry<String, Value>> vu=wrk.getAsObject().entrySet().iterator();


                            }
                        }


                    }

                }

                final List<hedaerOrQuary> res = responsee;
                final   String contettyp = "application/json; charset=UTF-8";
                String userAgentt = "fromandroid";
                Gson bvbv = new Gson();

                // Log.e("jjj", bvbv.toJson(hedermap));

                final  String bodys=requestbody;
                final   Map<String, String> hedermapx =hedermapVolley; //new HashMap<>();//Map<String, Object>();
                final   Map<String, String> quert= quarymap;
                //     String userAgentt = "fromandroid";
                boolean checvollye=false;


                if(this.usevolleys){

                    //  public  void settreq(final String auth, final String usertyp, final String email){
                    // String BASE_URL = "http://192.168.1.101:80/api/astoolacount/login";

                    RequestQueue q= Volley.newRequestQueue(views.getAsView().getContext());
                    int typmethod=Request.Method.POST;
                    if(Postmethod.toLowerCase().startsWith("g")){
                        typmethod=Request.Method.GET;
                    }
                    if(Postmethod.toLowerCase().startsWith("d")){
                        typmethod=Request.Method.DELETE;
                    }
                    if(Postmethod.toLowerCase().startsWith("pu")){
                        typmethod=Request.Method.PUT;
                    }
                    if(Postmethod.toLowerCase().startsWith("pa")){
                        typmethod=Request.Method.PATCH;
                    }
                    if(Postmethod.toLowerCase().startsWith("h")){
                        typmethod=Request.Method.HEAD;
                    }
                    CustomStringRequest rrrr=new CustomStringRequest(typmethod, URL + URL2, requestbody, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                assert response != null;
                                //  Log.e("uuuukkccc",response);
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if(ruo.getKeyType().toLowerCase().equals("select_key")){
                                        responseKey=ruo.getKeyValue();
                                        responsekeyy=ruo.getKeyValue();
                                    }
                                    if(ruo.getKeyType().toLowerCase().equals("offline_key")){
                                        OflinevalueKey=ruo.getKeyName();
                                        OflineKey=ruo.getKeyValue();
                                    }
                                    if(ruo.getKeyType().toLowerCase().equals("refresh_key")){
                                        RefeshKey=ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if(ruo.getKeyValue().toLowerCase().equals("show_as_message")){
                                        RefeshKeyasMessage=ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval=ruo.getKeyName();
                                    }
                                }




                                String kk = response;//.body().string();
                                // assert response.errorBody() != null;
                                try {
                                    //String responseKey = "0";//params[11];

        /*if (!responseKey.equals("0")) {
            JSONObject js = new JSONObject(kk);
            kk = js.get(responseKey).toString();
        }*/
                                } catch (Exception ex) {

                                }
                                //String k = "{Result:" + kk + "}";
                                if (RefeshKey.equals("1")) {
                                    try {

                                        if (OflineKey.equals("1")) {
                                            String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            ScriptModel g = new ScriptModel(0, kk, mng);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(views.getAsView().getContext());
                                            db_operations.insert(g);
                                        }
                                    } catch (Exception ex) {

                                    }

                                } else {
                                }
   /* Gson g = views.getViewManager().getContext().getJson();
    Type type = new TypeToken<Value>() {

    }.getType();
    ObjectValue tempp = g.fromJson(kk, type);
    tempp.add("show_as_message", new Primitive(RefeshKeyasMessage));
    tempp.add("show_as_messagekey", new Primitive(RefeshKeyasMessageKeyval));
    tempp.add("show_as_messagekeytyp", new Primitive(0));
    tempp.add("show_as_messagetext", new Primitive(RefeshKeyasMessage == "1" ? "nomes" : kk));
*/
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);

                                showmessagea(kk, 1,responsekeyy);
                                // views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp,1,views,tempp);

                                /*Intent intent = new Intent(views.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                                // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("data", kk);
                                views.getViewManager().getContext().getActvityAllt().startActivity(intent);*/
                                String prograssnam = "0";
                                try {
                                    //  prograssnam =anoth[0];//enabprograss
                                } catch (Exception ex) {

                                }





                            } catch (Exception ex) {

                                try {

                                    //String kk=;
                                    showmessagea(ex.getMessage(), 2,responsekeyy);
                                    //  views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),new Primitive(ex.getMessage()),2,views,new Primitive(ex.getMessage()));
                                } catch (Exception exm) {
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Gson gv=new Gson();
                            try {
//Log.e("ioioo","ggggggggggg");
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                                    if(ruo.getKeyType().toLowerCase().equals("select_key")){
                                        responseKey=ruo.getKeyValue();
                                        responsekeyy=ruo.getKeyValue();
                                    }
                                    if(ruo.getKeyType().toLowerCase().equals("offline_key")){
                                        OflinevalueKey=ruo.getKeyName();
                                        OflineKey=ruo.getKeyValue();
                                    }
                                    if(ruo.getKeyType().toLowerCase().equals("refresh_key")){
                                        RefeshKey=ruo.getKeyValue();
                                        //RefeshKey="1";
                                    }
                                    if(ruo.getKeyValue().toLowerCase().equals("show_as_message")){
                                        RefeshKeyasMessage=ruo.getKeyValue();
                                        //"1";
                                        RefeshKeyasMessageKeyval=ruo.getKeyName();
                                    }
                                }
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                String resul=null;
                                try {
                                    resul = gv.toJson(Utility.networkResponseToMap(error.networkResponse));
                                    Log.e("ddddddoop",resul);
                                }catch (Exception ex){
                                    Log.e("d",ex.getMessage());
                                }
                                if(resul==null){
                                    resul = "{\"data\":{\"message\":\"" + error.getMessage() + "\"}}";
                                }

                                showmessagea(resul, 2,responsekeyy);
                            }catch (Exception ex){
                                try {

                                    if (!checkNetwork(views.getAsView().getContext())) {
                                        String dataf = "{\"data\":{\"message\":\"" + GlobalClass.MessageErorr + "\"}}";
                                        showmessagea(dataf, 2, responsekeyy);
                                    }
                                }catch (Exception exm){
                                    Log.e("dddddd",exm.getMessage());
                                }
                            }
                        }
                    }){
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            return hedermapx;
                        }

                        @Override
                        public String getBodyContentType() {
                            return contettyp;
                        }

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            return quert;
                        }
                    };
                    setPloyices(rrrr);
                    q.add(rrrr);
                    //}
                }
                else{
                    final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(URL).create(retrofit_dynimcic.class);
                    RequestBody requestBodyBinary = null;
                    requestBodyBinary = RequestBody.create(MediaType.parse(contettyp), requestbody);
                    requestBodyBinary.contentType().charset(StandardCharsets.UTF_8);//.contentType().charset(Char)
                    Call<ResponseBody> call = Postmethod.toLowerCase().equals("post") ? Retrofitapi.PostMethod(URL2, requestBodyBinary, hedermap, quarymap) : Retrofitapi.GetMethod(URL, hedermap, quarymap);
                    call.enqueue(new Callback<ResponseBody>() {

                        private void showmessage(String mes, int typ) {


                            // String kk=mes; //response.errorBody().string();
                            String kk = "";
                            if (!checkjson(mes)) {
                                mes = mes.replace("\"", "\\\"");
                                //mes=mes.replace('"',' ');
                                kk = "\""+mes+"\"";
                            } else {
                                kk = mes;
                            }
                            //response.errorBody().string();
                            String xv = "\"Message\":"+kk+"";
                            String k = "{Result:{"+xv+"}}";
                            // String kx="{\"Result\":{"+xv+"}}";
                            Gson g = views.getViewManager().getContext().getJson();
                            Type type = new TypeToken<Value>() {

                            }.getType();
                            ObjectValue tempp = g.fromJson(k, type);
                            try {
                                views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), tempp, typ, views, tempp);
                            } catch (Exception ex) {

                            }
                        }

                        @Override
                        public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                            try {
                                assert response.body() != null;
                                String responseKey = "0";
                                String OflineKey = "0";
                                String OflinevalueKey = "0";
                                String RefeshKey = "0";
                                String RefeshKeyasMessage = "0";
                                String RefeshKeyasMessageKeyval = "0";

                                Iterator<hedaerOrQuary> wff = res.iterator();
                                while (wff.hasNext()) {
                                    hedaerOrQuary ruo = wff.next();

                               /* if(ruo.getKeyType().toLowerCase().equals("select_key")){
                                    responseKey=ruo.getKeyValue();
                                }
                                if(ruo.getKeyType().toLowerCase().equals("offline_key")){
                                    OflinevalueKey=ruo.getKeyName();
                                    OflineKey=ruo.getKeyValue();
                                }
                                if(ruo.getKeyType().toLowerCase().equals("refresh_key")){
                                    RefeshKey=ruo.getKeyValue();
                                    //RefeshKey="1";
                                }
                                if(ruo.getKeyValue().toLowerCase().equals("show_as_message")){
                                    RefeshKeyasMessage=ruo.getKeyValue();
                                    //"1";
                                    RefeshKeyasMessageKeyval=ruo.getKeyName();
                                }*/
                                }


                                if (response.isSuccessful()) {

                                    String kk = response.body().string();
                                    // assert response.errorBody() != null;
                              /*  try {
                                    //String responseKey = "0";//params[11];

                                    if (!responseKey.equals("0")) {
                                        JSONObject js = new JSONObject(kk);
                                        kk = js.get(responseKey).toString();
                                    }
                                } catch (Exception ex) {

                                }*/
                                    String k = "{data:" + kk + "}";
                                    if (RefeshKey.equals("1")) {
                                        try {

                                            if (OflineKey.equals("1")) {
                                                String mng = OflinevalueKey;//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                                ScriptModel g = new ScriptModel(0, k, mng);
                                                DatabaseHelper db_operations;
                                                db_operations = new DatabaseHelper(views.getAsView().getContext());
                                                db_operations.insert(g);
                                            }
                                        } catch (Exception ex) {

                                        }

                                    } else {
                                    }
                                    Gson g = views.getViewManager().getContext().getJson();
                                    Type type = new TypeToken<Value>() {

                                    }.getType();
                                    ObjectValue tempp = g.fromJson(k, type);
                                    tempp.add("show_as_message", new Primitive(RefeshKeyasMessage));
                                    tempp.add("show_as_messagekey", new Primitive(RefeshKeyasMessageKeyval));
                                    tempp.add("show_as_messagekeytyp", new Primitive(0));
                                    tempp.add("show_as_messagetext", new Primitive(RefeshKeyasMessage == "1" ? "nomes" : kk));

                                    views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                    showmessagea(kk, 1,responseKey);
                                    // views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),tempp,1,views,tempp);

                                /*Intent intent = new Intent(views.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                                // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("data", kk);
                                views.getViewManager().getContext().getActvityAllt().startActivity(intent);*/
                                    String prograssnam = "0";
                                    try {
                                        //  prograssnam =anoth[0];//enabprograss
                                    } catch (Exception ex) {

                                    }


                                } else {
                                    try {
                                        assert response.errorBody() != null;


                                        String kk = response.errorBody().string();
                                        showmessage(kk, 2);
                                    } catch (IOException ex) {


                                    }
                                }


                            } catch (Exception ex) {

                                try {

                                    //String kk=;
                                    showmessage(ex.getMessage(), 2);
                                    //  views.getViewManager().getContext().getAllEven("Response").call(views.getAsView().getContext(),views.getViewManager().getContext().getActvityAllt(),new Primitive(ex.getMessage()),2,views,new Primitive(ex.getMessage()));
                                } catch (Exception exm) {
                                }
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            //  stoptimertask();
                            try {
                                //Log.e("aaaaaa", t.getMessage());
                                String respon = t.getMessage();
                                views.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                                showmessage(respon, 2);



                            } catch (Exception ex) {
                                Log.e("aaaaaa", ex.getMessage() + "@@");
                            }
                        }
                    });
                }


            } catch (Exception ex) {

                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                //  loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return "";
        }
        private void showResult(String result, View c) {
            new AlertDialog.Builder(c.getContext())
                    .setMessage(result)
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }

        @Override
        protected void onPostExecute(String result) {
            try {

            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(String... text) {
            // finalResult.setText(text[0]);

        }
    }
    private static Map<String,List<AbstractFlexibleItem>> getDataAllDataFromString(Value dataseteng,Value dtd, Layout gg,ProteusLayoutInflater inflat){

        // Layout gg=infl.getViewManager().getContext().getLayout(this.layoutname);
        // String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;
        boolean useMultiplex = false;
        Gson gsonn = new Gson();

        Map<String,List<AbstractFlexibleItem>> ddat=new HashMap<>();
        List<modeltypeview> mlti = new ArrayList<>();
        List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
        List<AbstractFlexibleItem> mItemssb = new ArrayList<AbstractFlexibleItem>();
        try {
            Iterator<Map.Entry<String, Value>> rre = dataseteng.getAsObject().entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if(ddertr.getKey().equals("a_enable")) {
                    String hyy = ddertr.getValue().getAsString();//.getAsObject().getAsString("a_enable");

                    if (hyy.equals("1")) {
                        useMultiplex = true;
                    }
                }
                if(ddertr.getKey().equals("Filter_Views")) {
                    Array ar = ddertr.getValue().getAsArray();
                    filte = new String[ar.size()];
                    int coun = 0;
                    Iterator<Value> uuu = ar.iterator();
                    while (uuu.hasNext()) {
                        Value val = uuu.next();
                        filte[coun] = val.getAsObject().getAsString("Key_Name");


                        coun = coun + 1;
                    }

                }  if(ddertr.getKey().equals("MultipleViews")) {

                    Array arm = ddertr.getValue().getAsArray();//.getAsObject().getAsArray("MultipleViews");


                    Iterator<Value> uuuk = arm.iterator();
                    while (uuuk.hasNext()) {
                        Value val = uuuk.next();

                        String vnm = val.getAsObject().getAsString("v_Name");
                        String vnmm = val.getAsObject().getAsString("v_ColumnName");
                        String vnmmk = val.getAsObject().getAsString("v_EqualValue");
                        String vnmmkk = val.getAsObject().getAsString("v_id");


                        modeltypeview ww = new modeltypeview(vnm, vnmm, vnmmk, vnmmkk);
                        mlti.add(ww);
                        ;
                    }
                }



            }


            Value r = dtd.getAsObject().get("Result");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, r);
            //  Array re=r.getAsArray();-
            int   ccc=0;
            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().getAsArray().size();
                Gson ggm = new Gson();
                ccc=ccc+1;
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                    OOverIttem ioppp = new OOverIttem(mlti, useMultiplex, cx + 1, "no",gg, inflat, ddert.getValue().getAsArray().get(cx),filte);
                    mItemss.add(ioppp);
                    mItemssb.add(ioppp);
                }
            }
        }catch (Exception ex){

            //  Log.e("555",ex.getMessage());
        }
        ddat.put("main",mItemss);
        ddat.put("main1",mItemssb);
        return  ddat;

    }
    @NonNull
    public abstract void call(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v , Value... arguments) throws Exception;
    public abstract void callToRecycleview(Context context, AppCompatActivity act, Value data, int dataIndex, ProteusView v , IValuesData changeval,ProteusView.Manager.ActionEventViewForUto Actviw ,Value... arguments) throws Exception;

    public abstract String getName();
}
