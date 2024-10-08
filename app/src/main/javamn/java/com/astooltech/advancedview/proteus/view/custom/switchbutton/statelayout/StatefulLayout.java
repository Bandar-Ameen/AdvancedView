package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.AnimRes;
import androidx.annotation.StringRes;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.UIConfig;


/**
 * 状态布局，可根据模板自定义状态布局
 *
 * @author xuexiang
 * @since 2020/4/30 12:16 AM
 */
public class StatefulLayout extends LinearLayout {

    private static final String MSG_ONE_CHILD = "StatefulLayout must have one child!";

    /**
     * Indicates whether to place the animation on state changes
     */
    private boolean mAnimationEnabled;
    /**
     * Animation started begin of state change
     */
    private Animation mInAnimation;
    /**
     * Animation started end of state change
     */
    private Animation mOutAnimation;
    /**
     * to synchronize transition animations when animation duration shorter then request of state change
     */
    private int mAnimCounter;

    private View mContent;
    private LinearLayout mLlContainer;
    private ProgressBar mProgressBar;
    private ImageView mImage;
    private TextView mMessage;
    private Button mBtnRetry;

    public StatefulLayout(Context context) {
        this(context, null);
    }

    public StatefulLayout(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.StatefulLayoutStyle);
    }

    public StatefulLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr);
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.StatefulLayout, defStyleAttr, 0);
        mAnimationEnabled = array.getBoolean(R.styleable.StatefulLayout_stf_animationEnabled, UIConfig.getInstance(context).getStateLayoutConfig().animationEnabled);
        int inAnimationResId = array.getResourceId(R.styleable.StatefulLayout_stf_inAnimation, -1);
        if (inAnimationResId != -1) {
            mInAnimation = loadAnimation(inAnimationResId);
        } else {
            mInAnimation = UIConfig.getInstance(context).getStateLayoutConfig().getInAnimation();
        }
        int outAnimationResId = array.getResourceId(R.styleable.StatefulLayout_stf_outAnimation, -1);
        if (inAnimationResId != -1) {
            mOutAnimation = loadAnimation(outAnimationResId);
        } else {
            mOutAnimation = UIConfig.getInstance(context).getStateLayoutConfig().getOutAnimation();
        }
        array.recycle();
    }

    public boolean isAnimationEnabled() {
        return mAnimationEnabled;
    }

    public StatefulLayout setAnimationEnabled(boolean animationEnabled) {
        this.mAnimationEnabled = animationEnabled;
        return this;
    }

    public Animation getInAnimation() {
        return mInAnimation;
    }

    public StatefulLayout setInAnimation(Animation animation) {
        mInAnimation = animation;
        return this;
    }

    public StatefulLayout setInAnimation(@AnimRes int anim) {
        mInAnimation = loadAnimation(anim);
        return this;
    }

    public Animation getOutAnimation() {
        return mOutAnimation;
    }

    public StatefulLayout setOutAnimation(Animation animation) {
        mOutAnimation = animation;
        return this;
    }

    public StatefulLayout setOutAnimation(@AnimRes int anim) {
        mOutAnimation = loadAnimation(anim);
        return this;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1) {
            throw new IllegalStateException(MSG_ONE_CHILD);
        }
        attachTemplate();
    }

    /**
     * 加载模板
     */
    public void attachTemplate() {
        setOrientation(VERTICAL);
        // assume first child as content
        mContent = getChildAt(0);
        LayoutInflater.from(getContext()).inflate(R.layout.xui_layout_stateful_template, this, true);
        mLlContainer = findViewById(R.id.stContainer);
        mProgressBar = findViewById(R.id.stProgress);
        mImage = findViewById(R.id.stImage);
        mMessage = findViewById(R.id.stMessage);
        mBtnRetry = findViewById(R.id.stButton);
    }

    // content //

    /**
     * 显示正文布局
     */
    public void showContent() {
        if (mContent == null) {
            return;
        }
        if (isAnimationEnabled()) {
            mLlContainer.clearAnimation();
            mContent.clearAnimation();
            final int animCounterCopy = ++mAnimCounter;
            if (mLlContainer.getVisibility() == VISIBLE) {
                mOutAnimation.setAnimationListener(new SimpleAnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (mAnimCounter != animCounterCopy) {
                            return;
                        }
                        mLlContainer.setVisibility(GONE);
                        mContent.setVisibility(VISIBLE);
                        mContent.startAnimation(mInAnimation);
                    }
                });
                mLlContainer.startAnimation(mOutAnimation);
            }
        } else {
            mLlContainer.setVisibility(GONE);
            mContent.setVisibility(VISIBLE);
        }
    }

    // loading //

    /**
     * 显示加载中布局
     */
    public void showLoading() {
        showLoading(UIConfig.getInstance(getContext()).getStateLayoutConfig().getLoadingMessageRes());
    }

    public void showLoading(@StringRes int resId) {
        showLoading(getString(resId));
    }

    public void showLoading(String message) {
        showCustom(new CustomStateOptions()
                .message(message)
                .loading());
    }

    // empty //

    /**
     * 显示空内容布局
     */
    public void showEmpty() {
        showEmpty(UIConfig.getInstance(getContext()).getStateLayoutConfig().getEmptyMessageRes());
    }

    public void showEmpty(@StringRes int resId) {
        showEmpty(getString(resId));
    }

    public void showEmpty(String message) {
        showCustom(new CustomStateOptions()
                .message(message)
                .image(UIConfig.getInstance(getContext()).getStateLayoutConfig().getEmptyImageRes()));
    }

    // error //

    /**
     * 显示出错布局
     *
     * @param clickListener
     */
    public void showError(OnClickListener clickListener) {
        showError(UIConfig.getInstance(getContext()).getStateLayoutConfig().getErrorMessageRes(), clickListener);
    }

    public void showError(@StringRes int resId, OnClickListener clickListener) {
        showError(getString(resId), clickListener);
    }

    public void showError(String message, OnClickListener clickListener) {
        showError(message, getString(UIConfig.getInstance(getContext()).getStateLayoutConfig().getRetryMessageRes()), clickListener);
    }

    public void showError(String message, String buttonText, OnClickListener clickListener) {
        showCustom(new CustomStateOptions()
                .message(message)
                .image(UIConfig.getInstance(getContext()).getStateLayoutConfig().getErrorImageRes())
                .buttonText(buttonText)
                .buttonClickListener(clickListener));
    }

    // offline

    /**
     * 显示离线布局（网络异常）
     *
     * @param clickListener
     */
    public void showOffline(OnClickListener clickListener) {
        showOffline(UIConfig.getInstance(getContext()).getStateLayoutConfig().getOfflineMessageRes(), clickListener);
    }

    public void showOffline(@StringRes int resId, OnClickListener clickListener) {
        showOffline(getString(resId), clickListener);
    }

    public void showOffline(String message, OnClickListener clickListener) {
        showOffline(message, getString(UIConfig.getInstance(getContext()).getStateLayoutConfig().getRetryMessageRes()), clickListener);
    }

    public void showOffline(String message, String buttonText, OnClickListener clickListener) {
        showCustom(new CustomStateOptions()
                .message(message)
                .image(UIConfig.getInstance(getContext()).getStateLayoutConfig().getOfflineImageRes())
                .buttonText(buttonText)
                .buttonClickListener(clickListener));
    }

    // location off //

    /**
     * 显示定位未打开
     *
     * @param clickListener
     */
    public void showLocationOff(OnClickListener clickListener) {
        showLocationOff(UIConfig.getInstance(getContext()).getStateLayoutConfig().getLocationOffMessageRes(), clickListener);
    }

    public void showLocationOff(@StringRes int resId, OnClickListener clickListener) {
        showLocationOff(getString(resId), clickListener);
    }

    public void showLocationOff(String message, OnClickListener clickListener) {
        showLocationOff(message, getString(UIConfig.getInstance(getContext()).getStateLayoutConfig().getRetryMessageRes()), clickListener);
    }

    public void showLocationOff(String message, String buttonText, OnClickListener clickListener) {
        showCustom(new CustomStateOptions()
                .message(message)
                .image(UIConfig.getInstance(getContext()).getStateLayoutConfig().getLocationOffImageRes())
                .buttonText(buttonText)
                .buttonClickListener(clickListener));
    }

    // custom //


    public void showCustom(final CustomStateOptions options) {
        if (isAnimationEnabled()) {
            mLlContainer.clearAnimation();
            if (mContent != null) {
                mContent.clearAnimation();
            }
            final int animCounterCopy = ++mAnimCounter;
            if (mLlContainer.getVisibility() == GONE) {
                mOutAnimation.setAnimationListener(new SimpleAnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (animCounterCopy != mAnimCounter) {
                            return;
                        }
                        if (mContent != null) {
                            mContent.setVisibility(GONE);
                        }
                        mLlContainer.setVisibility(VISIBLE);
                        mLlContainer.startAnimation(mInAnimation);
                    }
                });
                if (mContent != null) {
                    mContent.startAnimation(mOutAnimation);
                }
                state(options);
            } else {
                mOutAnimation.setAnimationListener(new SimpleAnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (animCounterCopy != mAnimCounter) {
                            return;
                        }
                        state(options);
                        mLlContainer.startAnimation(mInAnimation);
                    }
                });
                mLlContainer.startAnimation(mOutAnimation);
            }
        } else {
            if (mContent != null) {
                mContent.setVisibility(GONE);
            }
            mLlContainer.setVisibility(VISIBLE);
            state(options);
        }
    }

    // helper methods //

    private void state(CustomStateOptions options) {
        if (!TextUtils.isEmpty(options.getMessage())) {
            mMessage.setVisibility(VISIBLE);
            mMessage.setText(options.getMessage());
        } else {
            mMessage.setVisibility(GONE);
        }

        if (options.isLoading()) {
            mProgressBar.setVisibility(VISIBLE);
            mImage.setVisibility(GONE);
            mBtnRetry.setVisibility(GONE);
        } else {
            mProgressBar.setVisibility(GONE);
            if (options.getImageRes() != 0) {
                mImage.setVisibility(VISIBLE);
                mImage.setImageResource(options.getImageRes());
            } else {
                mImage.setVisibility(GONE);
            }

            if (options.getClickListener() != null) {
                mBtnRetry.setVisibility(VISIBLE);
                mBtnRetry.setOnClickListener(options.getClickListener());
                if (!TextUtils.isEmpty(options.getButtonText())) {
                    mBtnRetry.setText(options.getButtonText());
                }
            } else {
                mBtnRetry.setVisibility(GONE);
            }
        }
    }

    private String getString(@StringRes int resId) {
        return getContext().getString(resId);
    }

    private Animation loadAnimation(@AnimRes int resId) {
        return AnimationUtils.loadAnimation(getContext(), resId);
    }

}
