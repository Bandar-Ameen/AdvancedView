package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astooltech.advancedview.R;

public class HeaderView extends LinearLayout {

   // @BindView(R.id.header_view_title)
    TextView title;
   // @BindView(R.id.header_view_sub_title)
    TextView subTitle;


    public HeaderView(Context context) {
        this(context, null);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        title=this.findViewById(R.id.header_view_title);
        subTitle=this.findViewById(R.id.header_view_sub_title);
       // ButterKnife.bind(this);
    }

    public void bindTo(CharSequence title) {
        bindTo(title, "");
    }

    public void bindTo(CharSequence title, CharSequence subTitle) {
        hideOrSetText(this.title, title);
        hideOrSetText(this.subTitle, subTitle);
    }

    private static void hideOrSetText(TextView tv, CharSequence text) {
        if (text == null || text.equals(""))
            tv.setVisibility(GONE);
        else
            tv.setText(text);
    }

}