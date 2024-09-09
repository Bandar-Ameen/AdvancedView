package com.astooltech.advancedview.finaldemo.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.Result;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.finaldemo.widget.Message;
import com.astooltech.advancedview.proteus.chatview.demo.ChatViewTestActivity;
import com.astooltech.advancedview.proteus.chatview.photoview.ExpandIconView;
import com.astooltech.advancedview.proteus.chatview.widget.ChatView;
import com.astooltech.advancedview.proteus.design.widget.WatingBarView;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.OnPreResult;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.RxActivityResult;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.spinkit.SpinKitView;
import com.astooltech.advancedview.spinkit.SpriteFactory;
import com.astooltech.advancedview.spinkit.Style;
import com.astooltech.advancedview.spinkit.sprite.Sprite;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.InlineActivityResult;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.callbacks.ActivityResultListener;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.request.Request;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.request.RequestFabric;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static android.app.Activity.RESULT_OK;
import static com.astooltech.advancedview.proteus.chatview.demo.ChatViewTestActivity.imagePickerRequestCode;


public class WatingBarViewParser<V extends com.astooltech.advancedview.proteus.chatview.widget.ChatView> extends ViewTypeParser<V> {

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
        return new prtouseChatviews(context.getActvityAllt());
    }
    @NonNull
    @Override
    public String getType() {
        return "WaitingViewb";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new prtouseChatviews(context.getActvityAllt());
    }
    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof prtouseChatviews){
            SetGetFindTextInputLayoutEditTextB((prtouseChatviews)view,data,typoper);
        }
    }



    private void SetGetFindTextInputLayoutEditTextB(prtouseChatviews dt, DataValueSelect datb, int typoper) {
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

                            com.astooltech.advancedview.finaldemo.widget.Message message1 = new  com.astooltech.advancedview.finaldemo.widget.Message();
                            message1.setBody(datb.getDataGet());
                            message1.setMessageType( com.astooltech.advancedview.finaldemo.widget.Message.MessageType.LeftSimpleMessage);
                            message1.setTime(getTime());
                            message1.setUserName("Hodor");
                            message1.setUserIcon(Uri.parse("android.resource://com.astooltech.advancedview/drawable/hodor"));
                           // dt.addMessage(message1);
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
            public String getPathVideo(Uri uri,AppCompatActivity ac,int typ) {
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
            private void myMethod(Request request,final AppCompatActivity ac,final prtouseChatviews chatView,final int typ,final File f ) {
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
   // chatView.addMessage(message);
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
                                            //chatView.addMessage(message);
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
                                           // chatView.addMessage(message);
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
                    public void handleValue(final V view, Value value) {

                        Gson g=new Gson();


//A_al
                        //A_alpha
                       //int cxx= ((ProteusView)view).getViewManager().getLayout().attributes.lastIndexOf("A_alpha");
                     //   int cxx=((ProteusView)view).getViewManager().getLayout()

                    final     prtouseChatviews   chatView=(prtouseChatviews)view;


                        chatView.setOnClickSendButtonListener(new ChatView.OnClickSendButtonListener() {
                            boolean switchbool=true;
                            @Override
                            public void onSendButtonClick(String body) {

                               if(switchbool) {
                                    com.astooltech.advancedview.finaldemo.widget.Message message = new  com.astooltech.advancedview.finaldemo.widget.Message();
                                    message.setBody(body);
                                    message.setMessageType( com.astooltech.advancedview.finaldemo.widget.Message.MessageType.RightSimpleImage);
                                    message.setTime(getTime());
                                    message.setUserName("Groot");
                                    message.setUserIcon(Uri.parse("android.resource://com.astooltech.advancedview/drawable/groot"));
                                   // chatView.addMessage(message);

                                    switchbool=false;
                                }
                                else{
                                    com.astooltech.advancedview.finaldemo.widget.Message message1 = new  com.astooltech.advancedview.finaldemo.widget.Message();
                                    message1.setBody(body);
                                    message1.setMessageType( com.astooltech.advancedview.finaldemo.widget.Message.MessageType.LeftSimpleMessage);
                                    message1.setTime(getTime());
                                    message1.setUserName("Hodor");
                                    message1.setUserIcon(Uri.parse("android.resource://com.astooltech.advancedview/drawable/hodor"));
                                   // chatView.addMessage(message1);

                                    switchbool=true;
                                }
                            }
                        });

                        chatView.setOnClickVideoButtonListener(new ChatView.OnClickVideoButtonListener() {
                            @SuppressLint("CheckResult")
                            @Override
                            public void onVideoButtonClick() {
                                ((prtouseChatviews) view).getViewManager().getContext().getActvityAllt().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                              @SuppressLint("IntentReset") Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                             i.setType("video/*");

                                         // Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                                            PendingIntent pendingIntent = PendingIntent.getActivity(((prtouseChatviews) view).getAsView().getContext(), 0, i, 0);

                                            Request request = RequestFabric.create(pendingIntent.getIntentSender(), null, 0, 0, 0, null);

                                            myMethod(request,((prtouseChatviews) view).getViewManager().getContext().getActvityAllt(),((prtouseChatviews) view),50,null);



                            }
                        });
                            }
                        });
                        chatView.setOnClickCameraButtonListener(new ChatView.OnClickCameraButtonListener() {
                            @Override
                            public void onCameraButtonClicked() {
                                ((prtouseChatviews) view).getViewManager().getContext().getActvityAllt().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        StrictMode.VmPolicy.Builder b=new StrictMode.VmPolicy.Builder();
                                        StrictMode.setVmPolicy(b.build());

String names=Environment.getExternalStorageDirectory()+ GlobalClass.fileDIRECTORY+"/" + DateFormat.format("yyyy-MM-dd_hhmmss",new Date()).toString()+".jpg";
                                         Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        File file = new File(names);

                                        try {
                                           file.createNewFile();
                                       }catch (IOException ex){

                                       }


                                       // Uri uri = FileProvider.getUriForFile(((prtouseChatviews) view).getViewManager().getContext().getActvityAllt(), ((prtouseChatviews) view).getViewManager().getContext().getActvityAllt().getApplicationContext().getPackageName() + ".provider", file);
                                      i.putExtra(MediaStore.EXTRA_OUTPUT, file.toURI());
                                        PendingIntent pendingIntent = PendingIntent.getActivity(((prtouseChatviews) view).getAsView().getContext(), 0, i, 0);

                                        Request request = RequestFabric.create(pendingIntent.getIntentSender(), null, 0, 0, 0, null);

                                        myMethod(request,((prtouseChatviews) view).getViewManager().getContext().getActvityAllt(),((prtouseChatviews) view),52,file);



                                    }
                                });
                            }
                        });
                        chatView.setOnClickGalleryButtonListener(new ChatView.OnClickGalleryButtonListener() {
                            @Override
                            public void onGalleryButtonClick() {
                                ((prtouseChatviews) view).getViewManager().getContext().getActvityAllt().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                                        Intent i =new Intent();
                                        i.setType("image/*");
i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
i.setAction(Intent.ACTION_GET_CONTENT);

                                        // Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                                        PendingIntent pendingIntent = PendingIntent.getActivity(((prtouseChatviews) view).getAsView().getContext(), 0, i, 0);

                                        Request request = RequestFabric.create(pendingIntent.getIntentSender(), null, 0, 0, 0, null);

                                        myMethod(request,((prtouseChatviews) view).getViewManager().getContext().getActvityAllt(),((prtouseChatviews) view),51,null);



                                    }
                                });
                            }
                        });

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