package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractSectionableItem;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;
import java.util.Random;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;

public class InstagramItem extends AbstractSectionableItem<InstagramItem.ViewHolder, InstagramHeaderItem> {

    private String id;
    private String url;
    private int quantity;

    public InstagramItem(String id, InstagramHeaderItem header) {
        super(header);
        this.id = id;
        this.header = header;
        setSelectable(false);
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof InstagramItem) {
            InstagramItem inItem = (InstagramItem) inObject;
            return this.id.equals(inItem.id);
        }
        return false;
    }

    public InstagramItem withImageUrl(String url) {
        this.url = url;
        return this;
    }

    public InstagramItem withName(String name) {
        getHeader().setTitle(name);
        return this;
    }

    public InstagramItem withPlace(String place) {
        getHeader().setSubtitle(place);
        return this;
    }

    public boolean getStarred() {
        return new Random().nextBoolean();
    }

    public String getLikes() {
        return Integer.toString(new Random().nextInt(1000));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_instagram_item;
    }

    @Override
    public ViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, ViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();

        holder.mQuantityLikes.setText(context.getResources().getString(R.string.likes, getLikes()));
        holder.mImageFavourite.flipSilently(getStarred());

        // Load image via Glide
        RequestOptions options = new RequestOptions()
                .optionalFitCenter();
        Glide.with(context.getApplicationContext())
             .asBitmap()
             .apply(options)
             .transition(withCrossFade(200))
             .load(url)
             .into(holder.mImage);
    }

    static final class ViewHolder extends FlexibleViewHolder {

        ImageView mImage;
        FlipView mImageFavourite;
        ImageView mImageComment;
        ImageView mImageShare;
        TextView mQuantityLikes;

        public ViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.mImage = view.findViewById(R.id.instagram_image);
            this.mImageFavourite = view.findViewById(R.id.instagram_image_like);
            this.mImageComment = view.findViewById(R.id.instagram_image_comment);
            this.mImageShare = view.findViewById(R.id.instagram_image_share);
            this.mQuantityLikes = view.findViewById(R.id.instagram_quantity_likes);
        }
    }

    @Override
    public String toString() {
        return "InstagramItem[" + super.toString() + "]";
    }

}