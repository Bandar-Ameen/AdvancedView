package com.astooltech.advancedview.proteus.chatview.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ExpandCustomeLayout extends LinearLayout {
    public static final int INVALID_ICON = -1;
    private List<String> urls;
    private int[] resIds;

    private int color = Color.TRANSPARENT;
    private int photoPadding = 0;
    private int photoMargin = 0;
    private int placeHolderResId = 0;
    private int photoFrameColor = Color.TRANSPARENT;
    private boolean useCards = false;
    private boolean useFirstAsHeader = true;

    private IconSelector iconSelector;

    private int defaultPhotosForLine = 3;

    private int maxWidth = -1;

    private int iconSize = 0;

    private ImageForm photosForm = ImageForm.IMAGE_FORM_SQUARE;
    private ImageForm headerForm = ImageForm.IMAGE_FORM_SQUARE;


    private OnPhotoClickListener onPhotoClickListener;

    public ExpandCustomeLayout(Context context) {
        super(context);
    }

    public ExpandCustomeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandCustomeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExpandCustomeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ExpandCustomeLayout backgroundColor(int color) {
        this.color = color;
        return this;
    }

    public ExpandCustomeLayout photoPadding(int photoPadding) {
        this.photoPadding = photoPadding;
        return this;
    }

    public ExpandCustomeLayout iconSelector(IconSelector iconSelector, int iconSize) {
        this.iconSelector = iconSelector;
        this.iconSize = iconSize;
        return this;
    }

    public ExpandCustomeLayout iconSelector(IconSelector iconSelector) {
        this.iconSelector = iconSelector;
        return this;
    }

    public ExpandCustomeLayout photoMargin(int photoMargin) {
        this.photoMargin = photoMargin;
        return this;
    }

    public ExpandCustomeLayout maxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public ExpandCustomeLayout photoFrameColor(int photoFrameColor) {
        this.photoFrameColor = photoFrameColor;
        return this;
    }

    public ExpandCustomeLayout placeHolder(int resId) {
        this.placeHolderResId = resId;
        return this;
    }

    public ExpandCustomeLayout useCards(boolean useCards) {
        this.useCards = useCards;
        return this;
    }

    public void loadPhotos(String[] urls) {
        this.urls = new ArrayList<>(Arrays.asList(urls));
        init();
    }

    public void loadPhotos(int[] resIds) {
        this.resIds = resIds;
        init();
    }

    public void loadPhotos(List<String> urls) {
        this.urls = urls;
        init();
    }

    public ExpandCustomeLayout useFirstAsHeader(boolean useFirstAsHeader) {
        this.useFirstAsHeader = useFirstAsHeader;
        return this;
    }

    public ExpandCustomeLayout defaultPhotosForLine(int defaultPhotosForLine) {
        this.defaultPhotosForLine = defaultPhotosForLine;
        return this;
    }

    public ExpandCustomeLayout photosForm(ImageForm photosForm) {
        this.photosForm = photosForm;
        return this;
    }

    public ExpandCustomeLayout headerForm(ImageForm headerForm) {
        this.headerForm = headerForm;
        return this;
    }

    private void init() {
        boolean fromResources = resIds != null && urls == null;
//ExpandIconView expands =new ExpandIconView();
        setOrientation(VERTICAL);
        setBackgroundColor(color);
        removeAllViews();
       // addView(photosLine);
    }

    private int getPhotosSize() {
        int size = 0;
        if (urls != null) {
            size = urls.size();
        } else if (resIds != null) {
            size = resIds.length;
        }
        return size;
    }

    private ArrayList<Integer> buildPhotosCounts() {
        int headerDecreaser = useFirstAsHeader ? 1 : 0;
        int photosSize = getPhotosSize() - headerDecreaser;
        int remainder = photosSize % defaultPhotosForLine;
        int lineCount = photosSize / defaultPhotosForLine;
        ArrayList<Integer> photosCounts = new ArrayList<>();
        if (useFirstAsHeader) {
            photosCounts.add(1);
            lineCount++;
        }
        for (int i = 0; i < lineCount; i++) {
            photosCounts.add(defaultPhotosForLine);
        }
        if (remainder >= lineCount) {
            photosCounts.add(headerDecreaser, remainder);
        } else {
            for (int i = lineCount - 1; i > lineCount - remainder - 1; i--) {
                photosCounts.set(i, photosCounts.get(i) + 1);
            }
        }
        return photosCounts;
    }

    public void setOnPhotoClickListener(OnPhotoClickListener onPhotoClickListener) {
        this.onPhotoClickListener = onPhotoClickListener;
    }

    public interface OnPhotoClickListener {
        void onPhotoClick(int position);
    }


    public enum ImageForm {
        IMAGE_FORM_SQUARE(1), IMAGE_FORM_HALF_HEIGHT(2);

        private int divider = 1;

        ImageForm(int divider) {
            this.divider = divider;
        }

        public int getDivider() {
            return divider;
        }
    }

    /**
     * Created by alan on 14.06.17.
     */

    public interface IconSelector {
        int getIconResId(int pos);
    }
}