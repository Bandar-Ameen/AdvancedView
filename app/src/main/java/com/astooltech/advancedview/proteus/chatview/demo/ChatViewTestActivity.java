package com.astooltech.advancedview.proteus.chatview.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.chatview.photoview.ExpandIconView;
import com.astooltech.advancedview.proteus.chatview.widget.ChatView;
import com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
/*import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.PicassoEngine;
*/
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatViewTestActivity extends AppCompatActivity {


    HorizontalScrollView moreHSV;
    ExpandIconView expandIconView;
    MaterialRippleLayout galleryMRL;
    public static int imagePickerRequestCode=10;
    public static int SELECT_VIDEO=11;
    public static int CAMERA_REQUEST=12;
    public static int SELECT_AUDIO=13;
    ChatView chatView;
    ImageView sendIcon;
    EditText messageET;
    boolean switchbool=true;
    boolean more = false;
    List<Uri> mSelected;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view_test);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config);
        chatView = findViewById(R.id.chatView);

        messageET = findViewById(R.id.messageET1);
        messageET.requestFocus();

        //Initialization start
        moreHSV = findViewById(R.id.moreLL1);
        expandIconView = findViewById(R.id.expandIconView1);
        expandIconView.setState(1,false);
        galleryMRL = findViewById(R.id.galleryMRL1);
        mSelected  = new ArrayList<>();



        //Send button click listerer
        chatView.setOnClickSendButtonListener(new ChatView.OnClickSendButtonListener() {
            @Override
            public void onSendButtonClick(String body) {
                if(switchbool) {
                    com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                    message.setBody(body);

                    message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.RightSimpleImage);
                    message.setTime(getTime());
                    message.setUserName("Groot");
                    message.setUserIcon(Uri.parse("android.resource://com.astooltech.advancedview/drawable/groot"));
                  //  chatView.addMessage(message);

                    switchbool=false;
                }
                else{
                    com.astooltech.advancedview.proteus.chatview.data.Message message1 = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                    message1.setBody(body);
                    message1.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.LeftSimpleMessage);
                    message1.setTime(getTime());
                    message1.setUserName("Hodor");
                    message1.setUserIcon(Uri.parse("android.resource://com.astooltech.advancedview/drawable/hodor"));
                  //  chatView.addMessage(message1);

                    switchbool=true;
                }
            }
        });

        //Gallery button click listener
        chatView.setOnClickGalleryButtonListener(new ChatView.OnClickGalleryButtonListener() {
            @Override
            public void onGalleryButtonClick() {
             /*  Matisse.from(ChatViewTestActivity.this)
                        .choose(MimeType.allOf())
                        .countable(true)
                        .maxSelectable(9)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new PicassoEngine())
                        .forResult(imagePickerRequestCode);*/
            }
        });

        //Video button click listener
        chatView.setOnClickVideoButtonListener(new ChatView.OnClickVideoButtonListener() {
            @Override
            public void onVideoButtonClick() {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                i.setType("video/*");
                startActivityForResult(i, SELECT_VIDEO);
            }
        });

        //Camera button click listener
        chatView.setOnClickCameraButtonListener(new ChatView.OnClickCameraButtonListener() {
            @Override
            public void onCameraButtonClicked() {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
                file.delete();
                File file1 = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");

                Uri uri = FileProvider.getUriForFile(ChatViewTestActivity.this, getApplicationContext().getPackageName() + ".provider", file1);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });


        chatView.setOnClickAudioButtonListener(new ChatView.OnClickAudioButtonListener() {
            @Override
            public void onAudioButtonClicked() {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("audio/*");
                //String[] mimetypes = {"audio/3gp", "audio/AMR", "audio/mp3"};
                //i.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
                startActivityForResult(i, SELECT_AUDIO);
            }
        });


    }


    public String getTime(){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd MMM yyyy HH:mm");
        String time = mdformat.format(calendar.getTime());
        return time;
    }



    public static String getRandomText() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(30);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        switch (requestCode){
            case 10:{

                //Image Selection result
                if(resultCode==RESULT_OK){
                    mSelected = null;//Matisse.obtainResult(data);

                    if(switchbool) {
                        if (mSelected.size() == 1) {
                            com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                            message.setBody(messageET.getText().toString().trim());
                            message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.RightSingleImage);
                            message.setTime(getTime());
                            message.setUserName("Groot");
                            message.setImageList(mSelected);
                            message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                           // chatView.addMessage(message);
                            switchbool=false;
                        } else {

                            com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                            message.setBody(messageET.getText().toString().trim());
                            message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.RightMultipleImages);
                            message.setTime(getTime());
                            message.setUserName("Groot");
                            message.setImageList(mSelected);
                            message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                           // chatView.addMessage(message);
                            switchbool=false;
                        }
                    }
                    else{

                        if (mSelected.size() == 1) {
                            com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                            message.setBody(messageET.getText().toString().trim());
                            message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.LeftSingleImage);
                            message.setTime(getTime());
                            message.setUserName("Hodor");
                            message.setImageList(mSelected);
                            message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/hodor"));
                           // chatView.addMessage(message);
                            switchbool=true;
                        } else {

                            com.astooltech.advancedview.proteus.chatview.data.Message message = new com.astooltech.advancedview.proteus.chatview.data.Message();
                            message.setBody(messageET.getText().toString().trim());
                            message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.LeftMultipleImages);
                            message.setTime(getTime());
                            message.setUserName("Hodor");
                            message.setImageList(mSelected);
                            message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/hodor"));
                            //chatView.addMessage(message);
                            switchbool=true;
                        }

                    }
                }
                break;
            }
            case 11:{

                //Video Selection Result
                if(resultCode == RESULT_OK) {
                    if (switchbool) {
                        com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                        message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.RightVideo);
                        message.setTime(getTime());
                        message.setUserName("Groot");
                        message.setVideoUri(Uri.parse(getPathVideo(data.getData())));
                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                       // chatView.addMessage(message);
                        switchbool = false;
                    } else {
                        com.astooltech.advancedview.proteus.chatview.data.Message message = new com.astooltech.advancedview.proteus.chatview.data.Message();

                        message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.LeftVideo);
                        message.setTime(getTime());
                        message.setUserName("Hodor");
                        message.setVideoUri(Uri.parse(getPathVideo(data.getData())));
                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/hodor"));
                       // chatView.addMessage(message);
                        switchbool = true;
                    }
                }
                break;
            }
            case 12:{

                //Image Capture result

                if (resultCode == RESULT_OK) {


                    if (switchbool) {
                        com.astooltech.advancedview.proteus.chatview.data.Message message = new com.astooltech.advancedview.proteus.chatview.data.Message();
                        message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.RightSingleImage);
                        message.setTime(getTime());
                        message.setUserName("Groot");
                        mSelected.clear();
                        File file = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
                        //Uri of camera image
                        Uri uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
                        mSelected.add(uri);
                        message.setImageList(mSelected);
                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                      //  chatView.addMessage(message);
                        switchbool = false;
                    } else {
                        com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();

                        message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.LeftSingleImage);
                        message.setTime(getTime());
                        message.setUserName("Hodor");
                        mSelected.clear();
                        File file = new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
                        //Uri of camera image
                        Uri uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
                        mSelected.add(uri);
                        message.setImageList(mSelected);
                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/hodor"));
                        //chatView.addMessage(message);
                        switchbool = true;
                    }
                }
                break;
            }
            case 13:{
                if(resultCode == RESULT_OK){
                    if (switchbool) {
                        com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();
                        message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.RightAudio);
                        message.setTime(getTime());
                        message.setUserName("Groot");
                        message.setAudioUri(Uri.parse(getPathAudio(data.getData())));
                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/groot"));
                       // chatView.addMessage(message);
                        switchbool = false;
                    } else {
                        com.astooltech.advancedview.proteus.chatview.data.Message message = new  com.astooltech.advancedview.proteus.chatview.data.Message();

                        message.setMessageType( com.astooltech.advancedview.proteus.chatview.data.Message.MessageType.LeftAudio);
                        message.setTime(getTime());
                        message.setUserName("Hodor");
                        message.setAudioUri(Uri.parse(getPathAudio(data.getData())));
                        message.setUserIcon(Uri.parse("android.resource://com.shrikanthravi.chatviewlibrary/drawable/hodor"));
                      //  chatView.addMessage(message);
                        switchbool = true;
                    }
                }
                break;
            }
        }

    }







    public String getPathVideo(Uri uri) {
        System.out.println("getpath "+uri.toString());
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if(cursor!=null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        else return null;
    }

    public String getPathAudio(Uri uri) {
        System.out.println("getpath "+uri.toString());
        String[] projection = { MediaStore.Audio.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

        int columnIndex = cursor.getColumnIndex(projection[0]);
        cursor.moveToFirst();
        if(cursor!=null) {
            return cursor.getString(columnIndex);
        }
        else return null;
    }



}
