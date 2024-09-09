package com.astooltech.advancedview.finaldemo.widget;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.chatview.data.VideoPlayer;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.List;

//import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;

import static android.content.ContentValues.TAG;

/**
 * Created by shrikanthravi on 16/02/18.
 */


public class MessageAdapter  extends FlexibleAdapter<AbstractFlexibleItem> {

    private List<AbstractFlexibleItem> messageList;
   // private List<Message> filterList;

   // MessageFilter filter;
    ImageLoader imageLoader;
   // Typeface typeface;

    public static MediaPlayer mediaPlayer;

    String playingposition;
    //onCompletionListener method
    MediaPlayer.OnCompletionListener mCompletionListener;
    protected boolean showLeftBubbleIcon=true;
    protected boolean showRightBubbleIcon=true;
    protected boolean showSenderName=true;
private RecyclerView chatRV;
    private int leftBubbleLayoutColor = com.astooltech.advancedview.R.color.colorAccent2;
    private int rightBubbleLayoutColor = com.astooltech.advancedview.R.color.colorAccent1;
    private int leftBubbleTextColor = android.R.color.black;
    private int rightBubbleTextColor = android.R.color.white;
    private int timeTextColor = android.R.color.tab_indicator_text;
    private int senderNameTextColor = android.R.color.tab_indicator_text;
    private float textSize = 20;

    public MessageAdapter(List<AbstractFlexibleItem> verticalList, Object listeners, RecyclerView chatRV, Context c) {
        super(verticalList);
this.chatRV=chatRV;
        this.messageList = verticalList;
      //  this.context = context;
     //   this.filterList = verticalList;
       // filter = new MessageFilter(verticalList,this);
        imageLoader = ImageLoader.getInstance();
    //    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/product_san_regular.ttf");
        mCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mediaPlayer = null;
            }
        };
        mHandler = new Handler(Looper.getMainLooper(), new MyHandlerCallback());
        WrapContentLinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(c, LinearLayoutManager.VERTICAL,true);
       layoutManager.setStackFromEnd(true);
    //   this.setLongPressDragEnabled(true);
 this.addListener(listeners);

     //  layoutManager.setReverseLayout(true);
        this.chatRV.setLayoutManager(layoutManager);
      //  this.chatRV.setItemAnimator(new ScaleInBottomAnimator(new OvershootInterpolator(1f)));
        this.chatRV.setAdapter(this);
        //this.setTopEndless(false);this.setAnimationOnReverseScrolling(true);
       // this.chatRV.setAdapter(this);

    }
    private class WrapContentLinearLayoutManager extends LinearLayoutManager {
        public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                Log.e("probe", "meet a IOOBE in RecyclerView");
            }
        }
    }

    public void updateDataSet(List<AbstractFlexibleItem> items, boolean animate) {
        // NOTE: To have views/items not changed, set them into "items" before passing the final
        // list to the Adapter.

        // Overwrite the list and fully notify the change, pass false to not animate changes.
        // Watch out! The original list must a copy.
        super.updateDataSet(items, animate);

        // onPostUpdate() will automatically be called at the end of the Asynchronous update
        // process. Manipulate the list inside that method only or you won't see the changes.
    }


public int getItemcount(){
        return  getItemCount();
}
    private class MyHandlerCallback extends HandlerCallback {
        @Override
        public boolean handleMessage(Message message) {
            boolean done = super.handleMessage(message);
            switch (message.what) {
                // Currently reserved (you don't need to check these numbers!)
                case 1: //async updateDataSet
                case 2: //async filterItems
                case 3: //confirm delete
                case 8: //onLoadMore remove progress item
                    return done;

                // Free to use, example:
                case 10:
                case 11:
                    return true;
            }
            return false;
        }
    }


    public int getItemcoun() {
        return itemcoun;
    }

    public void setItemcoun(int itemcoun) {
        this.itemcoun = itemcoun;
    }

    /*  @Override
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            super.onViewRecycled(holder);
            Log.d(TAG, "onViewRecycledCalled");
            if(holder instanceof LeftVideoViewHolder){
                ((LeftVideoViewHolder) holder).videoLL.removeAllViews();
            }
            else{
                if(holder instanceof RightVideoViewHolder){
                    ((RightVideoViewHolder) holder).videoLL.removeAllViews();
                }
            }

        }
    */
private int itemcoun=0;
    @Override
    public int getItemCount() {
        return getItemcoun();
    }

    @Override
    public boolean addItem(@NonNull AbstractFlexibleItem item) {
        setItemcoun(getItemCount()+1);
        return super.addItem(item);
    }

    @Override
    public boolean addItem(int position, @NonNull AbstractFlexibleItem item) {
        setItemcoun(getItemCount()+1);

        return super.addItem(position, item);
    }

    public String getTimee(){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd MMM yyyy HH:mm");
        String time = mdformat.format(calendar.getTime());
        return time;
    }


    public void showLeftBubbleIcon(boolean b){
        this.showLeftBubbleIcon=b;
    }

    public void showRightBubbleIcon(boolean b){
        this.showRightBubbleIcon = b;
    }

    public void setLeftBubbleLayoutColor(int color){
        this.leftBubbleLayoutColor = color;
    }

    public void setRightBubbleLayoutColor(int color){
        this.rightBubbleLayoutColor = color;


    }

    public void setLeftBubbleTextColor(int color){
        this.leftBubbleTextColor = color;
    }

    public void setRightBubbleTextColor(int color){
        this.rightBubbleTextColor = color;
    }

    public void setTimeTextColor(int color){
        this.timeTextColor = color;
    }

    public void setTypeface(Typeface typeface){

    }

    public void showSenderName(boolean b){
        this.showSenderName = b;
    }

    public void setSenderNameTextColor(int color){
        this.senderNameTextColor = color;
    }

    public void setTextSize(float size){
        this.textSize = size;
    }

    public static int getScreenWidth(Context c) {
        int screenWidth = 0; // this is part of the class not the method
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }

    private void adjustAspectRatio(VideoPlayer m_TextureView, int videoWidth, int videoHeight) {
        int viewWidth = m_TextureView.getWidth();
        int viewHeight = m_TextureView.getHeight();
        double aspectRatio = (double) videoHeight / videoWidth;

        int newWidth, newHeight;
        if (viewHeight > (int) (viewWidth * aspectRatio)) {
            // limited by narrow width; restrict height
            newWidth = viewWidth;
            newHeight = (int) (viewWidth * aspectRatio);
        } else {
            // limited by short height; restrict width
            newWidth = (int) (viewHeight / aspectRatio);
            newHeight = viewHeight;
        }
        int xoff = (viewWidth - newWidth) / 2;
        int yoff = (viewHeight - newHeight) / 2;
        Log.v(TAG, "video=" + videoWidth + "x" + videoHeight +
                " view=" + viewWidth + "x" + viewHeight +
                " newView=" + newWidth + "x" + newHeight +
                " off=" + xoff + "," + yoff);

        Matrix txform = new Matrix();
        m_TextureView.getTransform(txform);
        txform.setScale((float) newWidth / viewWidth, (float) newHeight / viewHeight);
        //txform.postRotate(10);          // just for fun
        txform.postTranslate(xoff, yoff);
        m_TextureView.setTransform(txform);
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }


}
