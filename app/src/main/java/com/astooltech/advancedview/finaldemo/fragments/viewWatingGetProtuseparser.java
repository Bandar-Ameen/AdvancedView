package com.astooltech.advancedview.finaldemo.fragments;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.Result;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.finaldemo.widget.Message;
import com.astooltech.advancedview.proteus.chatview.widget.ChatView;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.InlineActivityResult;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.callbacks.ActivityResultListener;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.request.Request;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.request.RequestFabric;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class viewWatingGetProtuseparser<V extends viewWatingGet> extends ViewTypeParser<V> {

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
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new viewWatingGetProtuse(context.getActvityAllt());
    }
    @NonNull
    @Override
    public String getType() {
        return "Viewx";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new viewWatingGetProtuse(context.getActvityAllt());
    }
    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof viewWatingGetProtuse){
         SetGetFindTextInputLayoutEditTextB((viewWatingGetProtuse)view,data,typoper);
        }
    }



    private void SetGetFindTextInputLayoutEditTextB(viewWatingGetProtuse dt, DataValueSelect datb, int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

                //Button b=null;
                // b.setCompoundDrawables(dt.getIndeterminateDrawable(),null,null,null);

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
                            dt.showError(d);


                        }
                        else   if(datb.getTypselect().equals("6")) {
                            String d=datb.getDataGet();
                            dt.setViewContiners();


                        }
                        else   if(datb.getTypselect().equals("7")) {

                            dt.startWating();


                        }
                    }
                }

            }

        }
    }
    public String getTime(){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd MMM yyyy HH:mm");
        String time = mdformat.format(calendar.getTime());
        return time;
    }
    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("proper", new AttributeProcessor<V>() {
            private boolean km(boolean a,boolean name){
                a=name;
                return  a;
            }
            private File createImageFile() {
                // External location
                //TODO: Ver si cambiar a almacenamiento interno o externo no publico
                File mediaStorageDir = new File(
                        Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                        GlobalClass.fileDIRECTORY);

                // Create the storage directory if it does not exist
                if (!mediaStorageDir.exists()) {
                    if (!mediaStorageDir.mkdirs()) {

                        return null;
                    }
                }

                // Create a media file name
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
                File mediaFile;
                mediaFile = new File(mediaStorageDir.getPath() + File.separator
                        + "IMG_" + timeStamp + ".jpg");


                return mediaFile;
            }
            public String getPathVideo(Uri uri, AppCompatActivity ac, int typ) {
                System.out.println("getpath "+uri.toString());
                String[] projection = {typ==50? MediaStore.Video.Media.DATA:MediaStore.Images.Media.DATA };
                Cursor cursor = ac.getContentResolver().query(uri, projection, null, null, null);
                if(cursor!=null) {
                    int column_index = cursor.getColumnIndexOrThrow(typ==50? MediaStore.Video.Media.DATA:MediaStore.Images.Media.DATA );
                    cursor.moveToFirst();
                    String res=cursor.getString(column_index);
                    //storage/emulated/0/DCIM/Screenshots/Screenshot_20231016-070902_Facebook.jpg
                    Log.e("rrrrrr",res);
                    return res;
                }
                else return null;
            }
            private void myMethod(Request request, final AppCompatActivity ac, final prtouseChatviews chatView, final int typ, final File f ) {
                new InlineActivityResult(ac)
                        .startForResult(request, new ActivityResultListener() {

                            @Override
                            public void onSuccess(Result result) {
                                Uri extras = result.getData().getData();//.getData().getExtras();

                                int resultCode = result.getRequestCode();//.resultCode();
                                Log.e("jhjhjhjh","hjhjhjh"+resultCode);

                                // Uri contentURI = ;
                                try {
                                    if(typ==50) {
                                        com.astooltech.advancedview.finaldemo.widget.Message message = new com.astooltech.advancedview.finaldemo.widget.Message();
                                        message.setMessageType(com.astooltech.advancedview.finaldemo.widget.Message.MessageType.RightVideo);
                                        message.setTime(getTime());
                                        message.setUserName("Groot");

                                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));

                                        message.setVideoUri(Uri.parse(getPathVideo(result.getData().getData(), ac,typ)));
                                        //chatView.addMessage(message);
                                    }
                                    if(typ==52) {
                                        List<Uri>
                                                mSelectedd = new ArrayList<>();
                                        com.astooltech.advancedview.finaldemo.widget.Message message = new com.astooltech.advancedview.finaldemo.widget.Message();
                                        message.setMessageType(Message.MessageType.RightSingleImage);
                                        message.setTime(getTime());
                                        message.setUserName("Groot");
                                        //File file = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
                                        //Uri of camera image
                                        // Uri uri = FileProvider.getUriForFile(ac, ac.getApplicationContext().getPackageName() + ".provider", f);
                                        mSelectedd.add(result.getData().getData());
                                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                                        message.setImageList(mSelectedd);
                                       // chatView.addMessage(message);
                                    }
                                    if(typ==51) {

                                        List<Uri>
                                                mSelected = new ArrayList<>();
                                        try {
                                            if (result.getData().getClipData().getItemCount() == 0) {
                                                mSelected.add(result.getData().getData());
                                            } else {
                                                for (int x = 0; x < result.getData().getClipData().getItemCount(); x++) {
                                                    mSelected.add(result.getData().getClipData().getItemAt(x).getUri());
                                                }
                                            }
                                        }catch (Exception ex){
                                            mSelected.add(result.getData().getData());
                                        }
                                        com.astooltech.advancedview.finaldemo.widget.Message message = new com.astooltech.advancedview.finaldemo.widget.Message();
                                        message.setMessageType(mSelected.size()==1? Message.MessageType.RightSingleImage: Message.MessageType.RightMultipleImages);
                                        message.setTime(getTime());
                                        message.setUserName("Groot");

                                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));

                                        message.setImageList(mSelected);
                                      //  chatView.addMessage(message);
                                    }                                /*  ByteArrayOutputStream ary = new ByteArrayOutputStream();
                                        Bundle extrasm = result.getData().getExtras();
                                       // Uri h=(Uri) extrasm.get("data");
                                       // imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, ary);
                                        List<Uri> mSelected=new ArrayList<>();
                                        mSelected.add(extras);
                                        com.astooltech.advancedview.finaldemo.widget.Message message = new com.astooltech.advancedview.finaldemo.widget.Message();
                                        message.setBody("");
                                        message.setMessageType(Message.MessageType.RightVideo);
                                        message.setTime(getTime());
                                        message.setUserName("Groot");
                                        message.setImageList(mSelected);
                                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));

                                        chatView.addMessage(message);*/
                                    //String res = Base64.encodeToString(ary.toByteArray(), Base64.DEFAULT);
                                    Log.e("uuuutt","r");
                                      /*  Gson v=new Gson();

                                        Log.e("jhjhjhjh","hjhjhjh"+v.toJson(result.getData().getExtras().get("data")));
                                        Bundle extrasmk = result.getData().getExtras();
                                       // Bitmap imageBitmap = (Bitmap) extras.get("data");
                                       // resultView.setImageBitmap(imageBitmap);
                                        Intent datam = result.getData();
                                        List<Uri> mSelected;
                                        mSelected = Matisse.obtainResult(result.getData());

                                            Log.e("jhjhjhjh","hjhjhjh");
                                            com.astooltech.advancedview.finaldemo.widget.Message message = new com.astooltech.advancedview.finaldemo.widget.Message();
                                            message.setBody("");
                                            message.setMessageType(com.astooltech.advancedview.finaldemo.widget.Message.MessageType.RightSingleImage);
                                            message.setTime(getTime());
                                            message.setUserName("Groot");
                                            message.setImageList(mSelected);
                                            message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                                            chatView.addMessage(message);
*/


                                } catch (Exception e) {
                                    Log.e("77", e.getMessage());
                                    //Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onFailed(Result result) {

                            }
                        });
            }                  @Override
            public void handleValue(final V view, final Value value) {

                Gson g=new Gson();

                Value getproper=value.getAsObject().get("proper");
                int wait=1000;
                String Errorbton="Error";
                try{
                  wait=  value.getAsObject().getAsInteger("daley");
                    Errorbton=  value.getAsObject().getAsString("errorText");
                }catch (Exception ex){

                }


//A_al
                //A_alpha
                //int cxx= ((ProteusView)view).getViewManager().getLayout().attributes.lastIndexOf("A_alpha");
                //   int cxx=((ProteusView)view).getViewManager().getLayout()

                viewWatingGetProtuse   chatView=(viewWatingGetProtuse)view;
               final viewWatingGetProtuse viez=(viewWatingGetProtuse)view;
                chatView.setProperPrograss(getproper);
                chatView.getError_btton().setText(Errorbton);
                chatView.getError_btton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                   /*Intent in=   viez.getViewManager().getContext().getActvityAllt().getIntent();
                       viez.getViewManager().getContext().getActvityAllt().finish();

                        viez.getViewManager().getContext().getActvityAllt().startActivity(in);*/
                    }
                });
                chatView.startWating();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
try {
    ProteusView v = ((viewWatingGetProtuse) view).getViewManager().getContext().getInflater().inflate(value.getAsObject().get("view").getAsLayout(), ((viewWatingGetProtuse) view).getViewManager().getDataContext().getData());
    ((viewWatingGetProtuse) view).setViewContiners(v.getAsView());

}catch (Exception ex){
    ((viewWatingGetProtuse) view).showError(ex.getMessage());
}

                    }
                },  wait);



            }

            @Override
            public void handleResource(V view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {

            }
        });

        addAttributeProcessor("mm", new GravityAttributeProcessor<V>() {
            @Override
            public void setGravity(V view, @Gravity int gravity) {


                // com.astooltech.advancedview.spinkit.SpinKitView ss=new com.astooltech.advancedview.spinkit.SpinKitView();
                view.setFitsSystemWindows(true);


                //  Wave ff=new Wave();

                //  ff.setBounds(0,0,100,100);

                //Sprite ee=new Sprite();
                //  view.setBackground(ff);

                //.setLayerType(SpinKitView.OVER_SCROLL_ALWAYS,).setCollapsedTitleGravity(gravity);
            }
        });
/*
        addAttributeProcessor("contentScrim", new DrawableResourceProcessor<V>() {
            @Override
            public void setDrawable(V view, Drawable drawable) {
                view.setContentScrim(drawable);
            }
        });

        addAttributeProcessor("expandedTitleGravity", new GravityAttributeProcessor<V>() {
            @Override
            public void setGravity(V view, @Gravity int gravity) {
                view.setExpandedTitleGravity(gravity);
            }
        });

        addAttributeProcessor("expandedTitleMargin", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMargin((int) dimension, (int) dimension, (int) dimension, (int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginBottom", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginBottom((int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginEnd", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginEnd((int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginStart", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginStart((int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginTop", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginTop((int) dimension);
            }
        });

        addAttributeProcessor("scrimAnimationDuration", new NumberAttributeProcessor<V>() {
            @Override
            public void setNumber(V view, @NonNull Number value) {
                view.setScrimAnimationDuration(value.longValue());
            }
        });


        addAttributeProcessor("scrimVisibleHeightTrigger", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setScrimVisibleHeightTrigger((int) dimension);
            }
        });

        addAttributeProcessor("statusBarScrim", new DrawableResourceProcessor<V>() {
            @Override
            public void setDrawable(V view, Drawable drawable) {
                view.setStatusBarScrim(drawable);
            }
        });

        addAttributeProcessor("title", new StringAttributeProcessor<V>() {
            @Override
            public void setString(V view, String value) {
                view.setTitle(value);
            }
        });

        addAttributeProcessor("titleEnabled", new BooleanAttributeProcessor<V>() {
            @Override
            public void setBoolean(V view, boolean value) {
                view.setTitleEnabled(value);
            }
        });*/
    }
}
