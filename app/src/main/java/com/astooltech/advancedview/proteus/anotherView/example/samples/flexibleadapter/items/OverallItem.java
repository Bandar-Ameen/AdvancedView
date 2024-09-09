package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * Model object representing Overall functionality as CardView.
 */
public class OverallItem extends AbstractFlexibleItem<OverallItem.LabelViewHolder> {

    private int id;
    private String title;
    private String description;
    private Drawable icon;
    private View viewx;
    private boolean checkk;
    public OverallItem(int id, String title) {
        this.id = id;
        this.title = title;
        setSelectable(false);
        //Allow dragging
        setDraggable(true);
    }

    public OverallItem withDescription(String description) {
        this.description = description;
        return this;
    }

    public OverallItem withView(View view) {
        this.viewx = view;
        return this;
    }
    public OverallItem withcheck(boolean c) {
        this.checkk = c;
        return this;
    }
    public OverallItem withIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public OverallItem withEnabled(boolean enabled) {
        setEnabled(enabled);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverallItem that = (OverallItem) o;
        return id == that.id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_overall_item;
    }

    @Override
    public LabelViewHolder createViewHolder(View view, FlexibleAdapter adapter, int viewtyp) {


    //    ProteusView viewx = layoutInflater.inflate(scope ,data);
        return new LabelViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, LabelViewHolder holder, int position, List payloads) {

        if(getView()!=null){
            if(getCheck()==false) {
                holder.linn.removeAllViews();
                holder.linn.addView(getView());
                withcheck(true);
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
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
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


    public static class LabelViewHolder extends FlexibleViewHolder {

      /*  public TextView mTitle;
        public TextView mSubtitle;
        public ImageView mIcon;*/
public LinearLayout linn;
        public LabelViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            /*mTitle = view.findViewById(R.id.title);
            mSubtitle = view.findViewById(R.id.subtitle);
            mIcon = view.findViewById(R.id.label_background);*/
            linn= view.findViewById(R.id.name_container);

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

}