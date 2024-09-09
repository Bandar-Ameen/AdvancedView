package com.astooltech.advancedview.proteus.chatview.data;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.playpause.PlayPauseView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;
import com.astooltech.advancedview.proteus.chatview.activities.ImageFFActivity;
import com.astooltech.advancedview.proteus.chatview.activities.VideoFFActivity;
import com.astooltech.advancedview.proteus.chatview.photoview.CollageView;
import com.astooltech.advancedview.proteus.parser.expandablelayout.ExpandableLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class OverallItemChatItem extends AbstractFlexibleItem<FlexibleViewHolder> implements IFilterable<String> {

    private long id;
    private String title;
    private String description;
    private Drawable icon;
    private View viewx;
    private boolean checkk;

    ImageLoader imageLoader;
    public Message getMesag() {
        return mesag;
    }

    public void setMesag(Message mesag) {
        this.mesag = mesag;
    }

    private Message mesag;
    protected boolean showLeftBubbleIcon=true;
    protected boolean showRightBubbleIcon=true;
    protected boolean showSenderName=true;
    public static MediaPlayer mediaPlayer;

    String playingposition;
    //onCompletionListener method
    MediaPlayer.OnCompletionListener mCompletionListener;
    private int leftBubbleLayoutColor = R.color.colorAccent2;
    private int rightBubbleLayoutColor = R.color.colorAccent1;
    private int leftBubbleTextColor = android.R.color.black;
    private int rightBubbleTextColor = android.R.color.white;
    private int timeTextColor = android.R.color.tab_indicator_text;
    private int senderNameTextColor = android.R.color.tab_indicator_text;
    private float textSize = 20;
    public OverallItemChatItem(Message m) {
       this.mesag=m;
        this.id = getMesag().id;
        this.title = title;
        setSelectable(false);
        //Allow dragging
        setDraggable(true);
        imageLoader = ImageLoader.getInstance();
        mCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mediaPlayer = null;
            }
        };
    }

    public OverallItemChatItem withDescription(String description) {
        this.description = description;
        return this;
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

    public OverallItemChatItem withView(View view) {
        this.viewx = view;
        return this;
    }
    public OverallItemChatItem withcheck(boolean c) {
        this.checkk = c;
        return this;
    }
    public OverallItemChatItem withIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public OverallItemChatItem withEnabled(boolean enabled) {
        setEnabled(enabled);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverallItemChatItem that = (OverallItemChatItem) o;
        return id == that.id;
    }

    @Override
    public int getLayoutRes() {


        int type=0;
        switch (mesag.getMessageType()) {
            case LeftSimpleMessage: {
                type = R.layout.left_text_layout;
                break;
            }
            case RightSimpleImage: {
                type = R.layout.right_text_layout;
                break;
            }
            case LeftSingleImage: {
                type = R.layout.left_image_layout;
                break;
            }
            case RightSingleImage: {
                type = R.layout.right_image_layout;
                break;
            }
            case LeftMultipleImages: {
                type = R.layout.left_images_layout;
                break;
            }
            case RightMultipleImages: {
                type = R.layout.right_images_layout;
                break;
            }
            case LeftVideo: {
                type = R.layout.left_video_layout;
                break;
            }
            case RightVideo: {
                type = R.layout.right_video_layout;
                break;
            }
            case LeftAudio: {
                type = R.layout.left_audio_layout;
                break;
            }
            case RightAudio: {
                type = R.layout.right_audio_layout;
                break;
            }
        }
        if(type==0){
            throw new RuntimeException("Set Message Type ( Message Type is Null )");
        }
        else {
            return type;
        }
       // return R.layout.recycler_overall_item;
    }

    @Override
    public FlexibleViewHolder createViewHolder(View view, FlexibleAdapter<IFlexible> adapter, int viewtyp) {
        FlexibleViewHolder viewHolder;
int viewType=viewtyp;
View parent=view;
        if(viewType==1){
            View viewx = LayoutInflater.from(view.getContext())
                    .inflate(R.layout.left_text_layout, null, false);
            viewHolder = new LeftTextViewHolder(viewx,adapter);
        }
        else{
            if(viewType==2){
                View viewx = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.right_text_layout, null, false);
                viewHolder = new RightTextViewHolder(viewx,adapter);
            }
            else{
                if(viewType==3){
                    View viewx = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.left_image_layout, null, false);
                    viewHolder = new LeftImageViewHolder(viewx,adapter);
                }
                else{
                    if(viewType==4){
                        View viewx = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.right_image_layout, null, false);
                        viewHolder = new RightImageViewHolder(viewx,adapter);
                    }
                    else{
                        if(viewType==5){
                            View viewx = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.left_images_layout, null, false);
                            viewHolder = new LeftImagesViewHolder(viewx,adapter);
                        }
                        else{
                            if(viewType==6) {
                                View viewx = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.right_images_layout, null, false);
                                viewHolder = new RightImagesViewHolder(viewx,adapter);
                            }
                            else{
                                if(viewType==20) {
                                    View viewx = LayoutInflater.from(parent.getContext())
                                            .inflate(R.layout.left_typing_layout, null, false);
                                    viewHolder = new LeftTypingViewHolder(viewx,adapter);
                                }
                                else{
                                    if(viewType==7) {
                                        View viewx = LayoutInflater.from(parent.getContext())
                                                .inflate(R.layout.left_video_layout, null, false);

                                        viewHolder = new LeftVideoViewHolder(viewx,adapter);

                                    }
                                    else{
                                        if(viewType==8) {

                                            View viewx = LayoutInflater.from(parent.getContext())
                                                    .inflate(R.layout.right_video_layout, null, false);
                                            viewHolder = new RightVideoViewHolder(viewx,adapter);
                                        }
                                        else {
                                            if(viewType==9){
                                                View viewx = LayoutInflater.from(parent.getContext())
                                                        .inflate(R.layout.left_audio_layout, null, false);
                                                viewHolder = new LeftAudioViewHolder(viewx,adapter);
                                            }
                                            else{
                                                View viewx = LayoutInflater.from(parent.getContext())
                                                        .inflate(R.layout.right_audio_layout, null, false);
                                                viewHolder = new RightAudioViewHolder(viewx,adapter);
                                            }

                                        }



                                    }
                                }

                            }
                        }
                    }
                }
            }

        }


        if(viewHolder==null){
            throw new RuntimeException("View Holder is null");
        }
        return viewHolder;


    }

    private   Drawable convertBitmapToDrawable(Bitmap original, Context context) {
try {
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    int width = original.getWidth();
    int height = original.getHeight();

    float scaleWidth = displayMetrics.scaledDensity;
    float scaleHeight = displayMetrics.scaledDensity;
    Matrix matrix = new Matrix();
    matrix.postScale(scaleWidth, scaleHeight);

    Bitmap resizedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true);

    return new BitmapDrawable(context.getResources(), resizedBitmap);
}catch (Exception ex){
    return  null;
}
    }
    @Override
    public void bindViewHolder(FlexibleAdapter adapter, FlexibleViewHolder holder, int position, List payloads) {

      final    Message message = getMesag();

final Context context=holder.itemView.getContext();

        if(holder instanceof LeftTextViewHolder){
            final LeftTextViewHolder holder1 =(LeftTextViewHolder) holder;
            holder1.leftTV.setText(message.getBody());
            holder1.leftTimeTV.setText(message.getTime());

            if(message.getUserIcon()!=null) {
                Picasso.with(context).load(message.getUserIcon()).into(holder1.leftBubbleIconIV);
            }
            try {
if(message.getsEnderProfileBase64()!=null) {
    byte[] bbb = Base64.decode(message.getsEnderProfileBase64(), 0);
    //   ByteArrayOutputStream ary = new ByteArrayOutputStream();
    Drawable dk = convertBitmapToDrawable(BitmapFactory.decodeByteArray(bbb, 0, bbb.length), holder1.itemView.getContext());
    holder1.leftBubbleIconIV.setBackground(dk);
}
            }catch (Exception ex){

            }

            holder1.senderNameTV.setText(message.getUserName());
        }
        else{
            if(holder instanceof RightTextViewHolder){
                final RightTextViewHolder holder1 =(RightTextViewHolder) holder;
                holder1.rightTV.setText(message.getBody());
                holder1.rightTimeTV.setText(message.getTime());
                if(message.getUserIcon()!=null) {
                    Picasso.with(context).load(message.getUserIcon()).into(holder1.rightBubbleIconIV);
                }
                holder1.senderNameTV.setText(message.getUserName());
            }
            else{
                if(holder instanceof LeftImageViewHolder){
                    final LeftImageViewHolder holder1 =(LeftImageViewHolder) holder;

                    if(message.getUserIcon()!=null) {
                        Picasso.with(context).load(message.getUserIcon()).into(holder1.leftBubbleIconIV);
                    }
                    holder1.senderNameTV.setText(message.getUserName());
                    if (message.getImageList().get(0) != null && !message.getImageList().get(0).equals("")) {
                        final File image = DiskCacheUtils.findInCache(message.getImageList().get(0).toString(), imageLoader.getDiskCache());
                        if (image!= null && image.exists()) {
                            Picasso.with(context).load(image).into(holder1.leftIV);
                        } else {
                            imageLoader.loadImage(message.getImageList().get(0).toString(), new ImageLoadingListener() {
                                @Override
                                public void onLoadingStarted(String s, View view) {
                                    holder1.leftIV.setImageBitmap(null);
                                }

                                @Override
                                public void onLoadingFailed(String s, View view, FailReason failReason) {

                                }

                                @Override
                                public void onLoadingComplete(String s, View view, final Bitmap bitmap) {
                                    Picasso.with(context).load(s).into(holder1.leftIV);

                                }

                                @Override
                                public void onLoadingCancelled(String s, View view) {

                                }
                            });
                        }
                    }else {
                        holder1.leftIV.setImageBitmap(null);
                    }

                    holder1.leftTimeTV.setText(message.getTime());

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        holder1.leftIV.setTransitionName("photoTransition");
                    }
                    holder1.leftIV.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, ImageFFActivity.class);
                            intent.putExtra("photoURI",message.getImageList().get(0).toString());
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, holder1.leftIV, holder1.leftIV.getTransitionName());
                                context.startActivity(intent, optionsCompat.toBundle());
                            }
                        }
                    });
                }
                else{
                    if(holder instanceof RightImageViewHolder){
                        final RightImageViewHolder holder1 =(RightImageViewHolder) holder;

                        if(message.getUserIcon()!=null) {
                            Picasso.with(context).load(message.getUserIcon()).into(holder1.rightBubbleIconIV);
                        }
                        holder1.senderNameTV.setText(message.getUserName());

                        if (message.getImageList().get(0) != null && !message.getImageList().get(0).equals("")) {
                            final File image = DiskCacheUtils.findInCache(message.getImageList().get(0).toString(), imageLoader.getDiskCache());
                            if (image!= null && image.exists()) {
                                Picasso.with(context).load(image).into(holder1.rightIV);
                            } else {
                                imageLoader.loadImage(message.getImageList().get(0).toString(), new ImageLoadingListener() {
                                    @Override
                                    public void onLoadingStarted(String s, View view) {
                                        holder1.rightIV.setImageBitmap(null);
                                    }

                                    @Override
                                    public void onLoadingFailed(String s, View view, FailReason failReason) {

                                    }

                                    @Override
                                    public void onLoadingComplete(String s, View view, final Bitmap bitmap) {
                                        Picasso.with(context).load(s).into(holder1.rightIV);

                                    }

                                    @Override
                                    public void onLoadingCancelled(String s, View view) {

                                    }
                                });
                            }
                        }else {
                            holder1.rightIV.setImageBitmap(null);
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            holder1.rightIV.setTransitionName("photoTransition");
                        }

                        holder1.rightIV.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, ImageFFActivity.class);
                                intent.putExtra("photoURI",message.getImageList().get(0).toString());
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, holder1.rightIV, holder1.rightIV.getTransitionName());
                                    context.startActivity(intent, optionsCompat.toBundle());
                                }
                            }
                        });
                        holder1.rightTimeTV.setText(message.getTime());

                    }
                    else{
                        if(holder instanceof LeftImagesViewHolder) {
                            final LeftImagesViewHolder holder1 = (LeftImagesViewHolder) holder;

                            if (message.getUserIcon() != null) {
                                Picasso.with(context).load(message.getUserIcon()).into(holder1.leftBubbleIconIV);
                            }
                            holder1.senderNameTV.setText(message.getUserName());

                            List<String> imageList = new ArrayList<>();
                            for (int i = 0; i < message.getImageList().size(); i++) {
                                imageList.add(message.getImageList().get(i).toString());
                            }
                            holder1.leftTimeTV.setText(message.getTime());

                            holder1.leftCollageView
                                    .photoMargin(8)
                                    .photoPadding(0)
                                    .backgroundColor(leftBubbleLayoutColor)
                                    .useFirstAsHeader(false) // makes first photo fit device widtdh and use full line
                                    .defaultPhotosForLine(2) // sets default photos number for line of photos (can be changed by program at runtime)
                                    .useCards(true)// adds cardview backgrounds to all photos
                                    .loadPhotos(imageList);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            holder1.leftCollageView.setTransitionName("photoTransition");
                        }
                            holder1.leftCollageView.setOnPhotoClickListener(new CollageView.OnPhotoClickListener() {
                                @Override
                                public void onPhotoClick(int i) {

                                    Intent intent = new Intent(context,ImageFFActivity.class);
                                    intent.putExtra("photoURI",message.getImageList().get(i).toString());
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, holder1.leftCollageView, holder1.leftCollageView.getTransitionName());
                                        context.startActivity(intent, optionsCompat.toBundle());
                                    }
                                }
                            });
                        }
                        else{

                            if(holder instanceof RightImagesViewHolder) {
                                final RightImagesViewHolder holder1 = (RightImagesViewHolder) holder;

                                if(message.getUserIcon()!=null) {
                                    Picasso.with(context).load(message.getUserIcon()).into(holder1.rightBubbleIconIV);
                                }
                                holder1.senderNameTV.setText(message.getUserName());
                                List<String> imageList = new ArrayList<>();
                                for (int i = 0; i < message.getImageList().size(); i++) {
                                    imageList.add(message.getImageList().get(i).toString());
                                }
                                holder1.rightTimeTV.setText(message.getTime());
                                holder1.rightCollageView
                                        .photoMargin(8)
                                        .photoPadding(0)
                                        .backgroundColor(rightBubbleLayoutColor)
                                        .useFirstAsHeader(false) // makes first photo fit device widtdh and use full line
                                        .defaultPhotosForLine(2) // sets default photos number for line of photos (can be changed by program at runtime)
                                        .useCards(true)// adds cardview backgrounds to all photos
                                        .loadPhotos(imageList);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    holder1.rightCollageView.setTransitionName("photoTransition");
                                }
                                holder1.rightCollageView.setOnPhotoClickListener(new CollageView.OnPhotoClickListener() {
                                    @Override
                                    public void onPhotoClick(int i) {

                                        Intent intent = new Intent(context, ImageFFActivity.class);
                                        intent.putExtra("photoURI", message.getImageList().get(i).toString());
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, holder1.rightCollageView, holder1.rightCollageView.getTransitionName());

                                            context.startActivity(intent, optionsCompat.toBundle());
                                        }
                                    }

                                });
                            }
                            else{

                                if(holder instanceof LeftTypingViewHolder){

                                }
                                else{
                                    if(holder instanceof LeftVideoViewHolder){
                                        final LeftVideoViewHolder holder1 =(LeftVideoViewHolder) holder;
                                        final VideoPlayer videoPlayer = new VideoPlayer(context);
                                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                                        videoPlayer.setLayoutParams(params);
                                        videoPlayer.setScaleType(VideoPlayer.ScaleType.CENTER_CROP);
                                        //((LeftVideoViewHolder) holder).videoLL.getLayoutParams().height = getScreenWidth(context) * 9 /16;
                                        //holder1.videoLL.removeAllViews();
                                        holder1.videoLL.addView(videoPlayer);
                                        videoPlayer.loadVideo(message.getVideoUri().toString(),message);
                                        if(message.getUserIcon()!=null) {
                                            Picasso.with(context).load(message.getUserIcon()).into(holder1.leftBubbleIconIV);
                                        }

                                        videoPlayer.setOnClickListener(new View.OnClickListener() {
                                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                            @Override
                                            public void onClick(View view) {
                                                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                                                    mediaPlayer.pause();
                                                }
                                                videoPlayer.setTransitionName("videoFF");
                                                Intent intent = new Intent(context, VideoFFActivity.class);
                                                intent.putExtra("videoURI", message.getVideoUri().toString());
                                                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, videoPlayer, videoPlayer.getTransitionName());
                                                context.startActivity(intent, optionsCompat.toBundle());
                                            }
                                        });
                                        holder1.senderNameTV.setText(message.getUserName());

                                        holder1.leftTimeTV.setText(message.getTime());

                                    }
                                    else{
                                        if (holder instanceof RightVideoViewHolder) {
                                            final RightVideoViewHolder holder1 = (RightVideoViewHolder) holder;
                                            final VideoPlayer videoPlayer = new VideoPlayer(context);
                                            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                                            videoPlayer.setScaleType(VideoPlayer.ScaleType.CENTER_CROP);
                                            videoPlayer.setLayoutParams(params);
                                            //((RightVideoViewHolder) holder).videoLL.getLayoutParams().height = getScreenWidth(context) * 9 /16;
                                            //holder1.videoLL.removeAllViews();
                                            holder1.videoLL.addView(videoPlayer);
                                            videoPlayer.loadVideo(message.getVideoUri().toString(), message);
                                            //adjustAspectRatio(videoPlayer,videoPlayer.getMp().getVideoWidth(),videoPlayer.getMp().getVideoHeight());

                                            if (message.getUserIcon() != null) {
                                                Picasso.with(context).load(message.getUserIcon()).into(holder1.rightBubbleIconIV);
                                            }

                                            videoPlayer.setOnClickListener(new View.OnClickListener() {
                                                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                                @Override
                                                public void onClick(View view) {
                                                    if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                                                        mediaPlayer.pause();
                                                    }
                                                    videoPlayer.setTransitionName("videoFF");
                                                    Intent intent = new Intent(context, VideoFFActivity.class);
                                                    intent.putExtra("videoURI", message.getVideoUri().toString());
                                                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, videoPlayer, videoPlayer.getTransitionName());
                                                    context.startActivity(intent, optionsCompat.toBundle());
                                                }
                                            });
                                            holder1.senderNameTV.setText(message.getUserName());

                                            holder1.rightTimeTV.setText(message.getTime());
                                        }
                                        else{
                                            if(holder instanceof LeftAudioViewHolder){
                                                final LeftAudioViewHolder holder1 =(LeftAudioViewHolder) holder;

                                                holder1.leftTimeTV.setText(message.getTime());

                                                if(message.getUserIcon()!=null) {
                                                    Picasso.with(context).load(message.getUserIcon()).into(holder1.leftBubbleIconIV);
                                                }
                                                holder1.senderNameTV.setText(message.getUserName());

                                                holder1.setMessage(message);

                                            }
                                            else{
                                                final RightAudioViewHolder holder1 =(RightAudioViewHolder) holder;

                                                holder1.rightTimeTV.setText(message.getTime());
                                                if(message.getUserIcon()!=null) {
                                                    Picasso.with(context).load(message.getUserIcon()).into(holder1.rightBubbleIconIV);
                                                }


                                                holder1.senderNameTV.setText(message.getUserName());

                                                holder1.setMessage(message);


                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /* if (getTitle() != null) {
            holder.mTitle.setText(getTitle());
            holder.mTitle.setEnabled(isEnabled());
        }
        if (getDescription() != null) {
            holder.mSubtitle.setText(Utils.fromHtmlCompat(getDescription()));
            holder.mSubtitle.setEnabled(isEnabled());
        }
        if (getIcon() != null) {
            holder.mIcon.setImageDrawable(getIcon());
        }*/
    }

    @Override
    public int getItemViewType() {
        int type=0;
        switch (mesag.getMessageType()) {
            case LeftSimpleMessage: {
                type = 1;
                break;
            }
            case RightSimpleImage: {
                type = 2;
                break;
            }
            case LeftSingleImage: {
                type = 3;
                break;
            }
            case RightSingleImage: {
                type = 4;
                break;
            }
            case LeftMultipleImages: {
                type = 5;
                break;
            }
            case RightMultipleImages: {
                type = 6;
                break;
            }
            case LeftVideo: {
                type = 7;
                break;
            }
            case RightVideo: {
                type = 8;
                break;
            }
            case LeftAudio: {
                type = 9;
                break;
            }
            case RightAudio: {
                type = 10;
                break;
            }
        }
        if(type==0){
            throw new RuntimeException("Set Message Type ( Message Type is Null )");
        }
        else {
            return type;
        }
    }





    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public boolean getCheck() {
        return checkk;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public View getView() {
        return viewx;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
    protected class LeftTextViewHolder  extends FlexibleViewHolder {

        public TextView leftTV,leftTimeTV,senderNameTV;
        public ExpandableLayout leftEL;
        public ImageView lefttMessageStatusIV,leftBubbleIconIV;
        public CardView leftBubbleIconCV;

        public LeftTextViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);

            leftTV = view.findViewById(R.id.leftTV);
            leftTimeTV = view.findViewById(R.id.leftTimeTV);
            leftEL = view.findViewById(R.id.leftEL);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            leftBubbleIconIV = view.findViewById(R.id.leftBubbleIconIV);
            leftBubbleIconCV = view.findViewById(R.id.leftBubbleIconCV);
            setBackgroundColor(leftBubbleLayoutColor);
            setTextColor(leftBubbleTextColor);
            setTimeTextColor(timeTextColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showLeftBubbleIcon(showLeftBubbleIcon);
            setTextSize(textSize);

           /* FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setBackgroundColor(int color){
            Drawable backgroundDrawable = DrawableCompat.wrap(leftTV.getBackground()).mutate();
            DrawableCompat.setTint(backgroundDrawable,color);
        }

        public void setTextColor(int color){
            leftTV.setTextColor(color);
        }

        public void setTimeTextColor(int color){
            leftTimeTV.setTextColor(color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showLeftBubbleIcon(boolean b){
            if(b){
                leftBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                leftBubbleIconCV.setVisibility(View.GONE);
            }
        }

        public void setTextSize(float size){
            leftTV.setTextSize(size);
        }
        @Override
        public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
            if (mAdapter.getRecyclerView().getLayoutManager() instanceof GridLayoutManager) {
                if (position % 2 != 0)
                    AnimatorHelper.slideInFromRightAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
                else
                    AnimatorHelper.slideInFromLeftAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
            } else {
                if (isForward)
                    AnimatorHelper.slideInFromBottomAnimator(animators, itemView, mAdapter.getRecyclerView());
                else
                    AnimatorHelper.slideInFromTopAnimator(animators, itemView, mAdapter.getRecyclerView());
            }
        }


    }
    protected class RightTextViewHolder extends FlexibleViewHolder {

        public TextView rightTV,rightTimeTV,senderNameTV;
        public ImageView rightMessageStatusIV,rightBubbleIconIV;
        public ExpandableLayout rightEL;
        public CardView rightBubbleIconCV;

        public RightTextViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);

            rightTV = view.findViewById(R.id.rightTV);
            rightTimeTV = view.findViewById(R.id.rightTimeTV);
            rightEL = view.findViewById(R.id.rightEL);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            rightBubbleIconCV = view.findViewById(R.id.rightBubbleIconCV);
            rightBubbleIconIV = view.findViewById(R.id.rightBubbleIconIV);
            setBackgroundColor(rightBubbleLayoutColor);
            setTextColor(rightBubbleTextColor);
            setTimeTextColor(timeTextColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showRightBubbleIcon(showRightBubbleIcon);
            setTextSize(textSize);
          /*  FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);
*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setBackgroundColor(int color){
            Drawable backgroundDrawable = DrawableCompat.wrap(rightTV.getBackground()).mutate();
            DrawableCompat.setTint(backgroundDrawable,color);
        }

        public void setTextColor(int color){
            rightTV.setTextColor(color);
        }

        public void setTimeTextColor(int color){
            rightTimeTV.setTextColor(color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }
        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showRightBubbleIcon(boolean b){
            if(b){
                rightBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                rightBubbleIconCV.setVisibility(View.GONE);
            }
        }

        public void setTextSize(float size){
            rightTV.setTextSize(size);
        }
    }

    protected class LeftImageViewHolder extends FlexibleViewHolder {

        public TextView leftTimeTV,senderNameTV;
        public ExpandableLayout leftEL;
        public ImageView lefttMessageStatusIV,leftBubbleIconIV;
        public CardView leftBubbleIconCV;
        public CardView leftIVCV;
        public ImageView leftIV;

        public LeftImageViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);



            leftTimeTV = view.findViewById(R.id.leftTimeTV);
            leftEL = view.findViewById(R.id.leftEL);
            leftIV = view.findViewById(R.id.leftIV);
            leftIVCV = view.findViewById(R.id.leftIVCV);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            leftBubbleIconIV = view.findViewById(R.id.leftBubbleIconIV);
            leftBubbleIconCV = view.findViewById(R.id.leftBubbleIconCV);

            setBackgroundColor(leftBubbleLayoutColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showLeftBubbleIcon(showLeftBubbleIcon);
           /* FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setBackgroundColor(int color){
            Drawable backgroundDrawable = DrawableCompat.wrap(leftIV.getBackground()).mutate();
            DrawableCompat.setTint(backgroundDrawable,color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showLeftBubbleIcon(boolean b){
            if(b){
                leftBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                leftBubbleIconCV.setVisibility(View.GONE);
            }
        }
    }

    protected class RightImageViewHolder extends FlexibleViewHolder {

        public TextView rightTV,rightTimeTV,senderNameTV;
        public ExpandableLayout rightEL;
        public ImageView rightMessageStatusIV,rightBubbleIconIV;
        public CardView rightBubbleIconCV;
        public CardView rightIVCV;
        public ImageView rightIV;

        public RightImageViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);



            rightTimeTV = view.findViewById(R.id.rightTimeTV);
            rightEL = view.findViewById(R.id.rightEL);
            rightIV = view.findViewById(R.id.rightIV);
            rightIVCV = view.findViewById(R.id.rightIVCV);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            rightBubbleIconCV = view.findViewById(R.id.rightBubbleIconCV);
            rightBubbleIconIV = view.findViewById(R.id.rightBubbleIconIV);
        /*    FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            setBackgroundColor(rightBubbleLayoutColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showRightBubbleIcon(showRightBubbleIcon);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setBackgroundColor(int color){
            Drawable backgroundDrawable = DrawableCompat.wrap(rightIV.getBackground()).mutate();
            DrawableCompat.setTint(backgroundDrawable,color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }
        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }
        public void showRightBubbleIcon(boolean b){
            if(b){
                rightBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                rightBubbleIconCV.setVisibility(View.GONE);
            }
        }
    }

    protected class LeftImagesViewHolder extends FlexibleViewHolder {

        public TextView leftTimeTV,senderNameTV;
        public ExpandableLayout leftEL;
        public ImageView lefttMessageStatusIV,leftBubbleIconIV;
        public CardView leftBubbleIconCV;
        public CollageView leftCollageView;

        public LeftImagesViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);


            leftTimeTV = view.findViewById(R.id.leftTimeTV);
            leftEL = view.findViewById(R.id.leftEL);
            leftCollageView = view.findViewById(R.id.leftCollageView);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            leftBubbleIconIV = view.findViewById(R.id.leftBubbleIconIV);
            leftBubbleIconCV = view.findViewById(R.id.leftBubbleIconCV);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showLeftBubbleIcon(showLeftBubbleIcon);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showLeftBubbleIcon(boolean b){
            if(b){
                leftBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                leftBubbleIconCV.setVisibility(View.GONE);
            }
        }
    }

    protected class RightImagesViewHolder extends FlexibleViewHolder {

        public TextView rightTimeTV,senderNameTV;
        public ExpandableLayout rightEL;
        public ImageView rightMessageStatusIV,rightBubbleIconIV;
        public CardView rightBubbleIconCV;
        public CollageView rightCollageView,leftCollageView;

        public RightImagesViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);


            rightTimeTV = view.findViewById(R.id.rightTimeTV);
            rightEL = view.findViewById(R.id.rightEL);
            rightCollageView = view.findViewById(R.id.rightCollageView);
            leftCollageView = view.findViewById(R.id.leftCollageView);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            rightBubbleIconCV = view.findViewById(R.id.rightBubbleIconCV);
            rightBubbleIconIV = view.findViewById(R.id.rightBubbleIconIV);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showRightBubbleIcon(showRightBubbleIcon);
          /*  FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }
        public void showRightBubbleIcon(boolean b){
            if(b){
                rightBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                rightBubbleIconCV.setVisibility(View.GONE);
            }
        }
    }

    protected class LeftVideoViewHolder extends FlexibleViewHolder {

        public TextView leftTimeTV,senderNameTV;
        public ExpandableLayout leftEL;
        public ImageView lefttMessageStatusIV,leftBubbleIconIV;
        public CardView leftBubbleIconCV;
        public CardView leftIVCV;
        public ImageView leftIV;
        public LinearLayout videoLL;

        public LeftVideoViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);



            leftIVCV = view.findViewById(R.id.leftIVCV);
            leftTimeTV = view.findViewById(R.id.leftTimeTV);
            leftEL = view.findViewById(R.id.leftEL);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            leftBubbleIconIV = view.findViewById(R.id.leftBubbleIconIV);
            leftBubbleIconCV = view.findViewById(R.id.leftBubbleIconCV);
            videoLL = view.findViewById(R.id.videoLL);

            setBackgroundColor(leftBubbleLayoutColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showLeftBubbleIcon(showLeftBubbleIcon);
           /* FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public void setBackgroundColor(int color){
            leftIVCV.setCardBackgroundColor(color);
        }



        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showLeftBubbleIcon(boolean b){
            if(b){
                leftBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                leftBubbleIconCV.setVisibility(View.GONE);
            }
        }
    }

    protected class RightVideoViewHolder extends FlexibleViewHolder {

        public TextView rightTimeTV,senderNameTV;
        public ExpandableLayout rightEL;
        public ImageView rightMessageStatusIV,rightBubbleIconIV;
        public CardView rightBubbleIconCV,rightIVCV;
        public LinearLayout videoLL;

        public RightVideoViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);


            rightTimeTV = view.findViewById(R.id.rightTimeTV);
            rightEL = view.findViewById(R.id.rightEL);
            rightIVCV = view.findViewById(R.id.rightIVCV);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            rightBubbleIconCV = view.findViewById(R.id.rightBubbleIconCV);
            rightBubbleIconIV = view.findViewById(R.id.rightBubbleIconIV);
            videoLL = view.findViewById(R.id.videoLL);

            setBackgroundColor(rightBubbleLayoutColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showRightBubbleIcon(showRightBubbleIcon);
         /*   FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }
        public void setBackgroundColor(int color){
            rightIVCV.setCardBackgroundColor(color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }
        public void showRightBubbleIcon(boolean b){
            if(b){
                rightBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                rightBubbleIconCV.setVisibility(View.GONE);
            }
        }
    }

    protected class LeftAudioViewHolder extends FlexibleViewHolder {

        public TextView leftTimeTV,senderNameTV;
        public ExpandableLayout leftEL;
        public ImageView leftBubbleIconIV;
        public CardView leftBubbleIconCV;
        public SeekBar audioSeekbar;
        public PlayPauseView playPauseView;
        public Message message;
        public android.os.Handler handler;

        public LeftAudioViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);


            audioSeekbar = view.findViewById(R.id.audioSeekbar);
            playPauseView = view.findViewById(R.id.play_pause_view);
            leftTimeTV = view.findViewById(R.id.leftTimeTV);
            leftEL = view.findViewById(R.id.leftEL);

            senderNameTV = view.findViewById(R.id.senderNameTV);
            leftBubbleIconIV = view.findViewById(R.id.leftBubbleIconIV);
            leftBubbleIconCV = view.findViewById(R.id.leftBubbleIconCV);
            setBackgroundColor(leftBubbleLayoutColor);
            setSeekBarLineColor(leftBubbleTextColor);
            setSeekBarThumbColor(rightBubbleLayoutColor);
            setTimeTextColor(timeTextColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showLeftBubbleIcon(showLeftBubbleIcon);
            handler=new android.os.Handler();
            audioSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    if(playingposition==message.getAudioUri().toString()) {
                        mediaPlayer.seekTo(seekBar.getProgress());
                    }
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    if(playingposition==message.getAudioUri().toString()) {
                        mediaPlayer.seekTo(seekBar.getProgress());
                    }
                }
            });
            ((Activity)view.getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (message != null) {
                        if (playingposition == message.getAudioUri().toString()) {
                            if (mediaPlayer != null) {

                                if (mediaPlayer.isPlaying()) {

                                    audioSeekbar.setProgress(mediaPlayer.getCurrentPosition());
                                    if (playPauseView.isPlay()) {
                                        playPauseView.change(false);
                                    }
                                } else {
                                    playPauseView.change(true);
                                }
                            } else {
                                playPauseView.change(true);
                            }

                        } else {

                            audioSeekbar.setProgress(0);
                            playPauseView.change(true);
                            playPauseView.change(true);
                        }
                    }
                    handler.postDelayed(this, 1000);
                }
            });
            playPauseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                        if(playingposition==message.getAudioUri().toString()) {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            playPauseView.change(true);
                        }

                        else {

                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            mediaPlayer = MediaPlayer.create(v.getContext(), message.getAudioUri());
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mediaPlayer) {

                                    mediaPlayer.start();
                                    playingposition=message.getAudioUri().toString();
                                    audioSeekbar.setMax(mediaPlayer.getDuration());
                                    playPauseView.change(false);
                                }
                            });

                        }
                    }
                    else{

                        mediaPlayer = MediaPlayer.create(v.getContext(), message.getAudioUri());
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {

                                mediaPlayer.start();
                                playingposition=message.getAudioUri().toString();
                                audioSeekbar.setMax(mediaPlayer.getDuration());
                                playPauseView.change(false);
                            }
                        });
                    }



                }
            });

      /*      FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(final Message message) {
            this.message = message;

        }

        public void setBackgroundColor(int color){
            Drawable backgroundDrawable = DrawableCompat.wrap(audioSeekbar.getBackground()).mutate();
            DrawableCompat.setTint(backgroundDrawable,color);
        }

        public void setSeekBarLineColor(int color){
            audioSeekbar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);

        }

        public void setSeekBarThumbColor(int color){
            Drawable backgroundDrawable1 = DrawableCompat.wrap(audioSeekbar.getThumb()).mutate();
            DrawableCompat.setTint(backgroundDrawable1,color);
        }


        public void setTimeTextColor(int color){
            leftTimeTV.setTextColor(color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }

        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showLeftBubbleIcon(boolean b){
            if(b){
                leftBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                leftBubbleIconCV.setVisibility(View.GONE);
            }
        }


    }

    protected class RightAudioViewHolder extends FlexibleViewHolder {

        public TextView rightTimeTV,senderNameTV;
        public ImageView rightMessageStatusIV,rightBubbleIconIV;
        public ExpandableLayout rightEL;
        public CardView rightBubbleIconCV;
        public Message message;
        public SeekBar audioSeekbar;
        public PlayPauseView playPauseView;
        public android.os.Handler handler;

        public RightAudioViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);



            audioSeekbar = view.findViewById(R.id.audioSeekbar);
            playPauseView = view.findViewById(R.id.play_pause_view);
            rightTimeTV = view.findViewById(R.id.rightTimeTV);
            rightEL = view.findViewById(R.id.rightEL);
            senderNameTV = view.findViewById(R.id.senderNameTV);
            rightBubbleIconCV = view.findViewById(R.id.rightBubbleIconCV);
            rightBubbleIconIV = view.findViewById(R.id.rightBubbleIconIV);
            setBackgroundColor(rightBubbleLayoutColor);
            setSeekBarLineColor(rightBubbleTextColor);
            setSeekBarThumbColor(leftBubbleLayoutColor);
            setTimeTextColor(timeTextColor);
            setSenderNameTextColor(senderNameTextColor);
            showSenderName(showSenderName);
            showRightBubbleIcon(showRightBubbleIcon);
            handler=new android.os.Handler();
            audioSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    if(mediaPlayer!=null){
                        if(playingposition==message.getAudioUri().toString()) {
                            mediaPlayer.seekTo(seekBar.getProgress());
                        }
                    }
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    if(mediaPlayer!=null){
                        if(playingposition==message.getAudioUri().toString()) {
                            mediaPlayer.seekTo(seekBar.getProgress());
                        }
                    }
                }
            });
            ((Activity)view.getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (message != null) {
                        if (playingposition == message.getAudioUri().toString()) {
                            if (mediaPlayer != null) {
                                if (mediaPlayer.isPlaying()) {

                                    audioSeekbar.setProgress(mediaPlayer.getCurrentPosition());
                                    if (playPauseView.isPlay()) {
                                        playPauseView.change(false);
                                    }
                                } else {
                                    playPauseView.change(true);
                                }
                            } else {
                                playPauseView.change(true);
                            }

                        } else {

                            audioSeekbar.setProgress(0);
                            playPauseView.change(true);
                            playPauseView.change(true);
                        }
                    }
                    handler.postDelayed(this, 1000);

                }
            });

            playPauseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                        if(playingposition==message.getAudioUri().toString()) {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            playPauseView.change(true);
                        }
                        else {

                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = null;
                            mediaPlayer = MediaPlayer.create(v.getContext(), message.getAudioUri());
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mediaPlayer) {

                                    mediaPlayer.start();
                                    playingposition=message.getAudioUri().toString();
                                    audioSeekbar.setMax(mediaPlayer.getDuration());
                                    playPauseView.change(false);
                                }
                            });

                        }
                    }
                    else{

                        mediaPlayer = MediaPlayer.create(v.getContext(), message.getAudioUri());
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {

                                mediaPlayer.start();
                                playingposition=message.getAudioUri().toString();
                                audioSeekbar.setMax(mediaPlayer.getDuration());
                                playPauseView.change(false);
                            }
                        });
                    }





                }
            });
        /*    FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(final Message message) {
            this.message = message;

        }

        public void setBackgroundColor(int color){
            Drawable backgroundDrawable = DrawableCompat.wrap(audioSeekbar.getBackground()).mutate();
            DrawableCompat.setTint(backgroundDrawable,color);
        }

        public void setSeekBarLineColor(int color){
            audioSeekbar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);

        }
        public void setSeekBarThumbColor(int color){
            Drawable backgroundDrawable1 = DrawableCompat.wrap(audioSeekbar.getThumb()).mutate();
            DrawableCompat.setTint(backgroundDrawable1,color);
        }

        public void setTimeTextColor(int color){
            rightTimeTV.setTextColor(color);
        }

        public void setSenderNameTextColor(int color){
            senderNameTV.setTextColor(color);
        }
        public void showSenderName(boolean b){
            if(b){
                senderNameTV.setVisibility(View.VISIBLE);
            }
            else{
                senderNameTV.setVisibility(View.GONE);
            }
        }

        public void showRightBubbleIcon(boolean b){
            if(b){
                rightBubbleIconCV.setVisibility(View.VISIBLE);
            }
            else{
                rightBubbleIconCV.setVisibility(View.GONE);
            }
        }

    }




    protected class LeftTypingViewHolder extends FlexibleViewHolder {


        public LeftTypingViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);



         /*   FontChanger fontChanger = new FontChanger(typeface);
            fontChanger.replaceFonts((ViewGroup)view);*/
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int pos = getLayoutPosition();

                    return true;
                }
            });
        }
    }


    @Override
    public boolean filter(String constraint) {
        boolean trueif;
        List<Boolean> datar=new ArrayList<>();
        int trr = 0;
        try {
            if (getMesag() != null) {


                        boolean re = getMesag().getBody().contains(constraint);
                        datar.add(re);



            }

            int faa = 0;
            for (int cx = 0; cx < datar.size(); cx++) {
                if (datar.get(cx)) {

                    trr = trr + 1;
                } else {
                    faa = faa + 1;
                }

            }

        }catch (Exception ex){


        }
        if (trr == 0) {
            return false;
        } else {
            return true;
        }
        // return data.getAsObject() != null && data.getAsObject().get("drugName_ar").toString().contains(constraint);
    }



}