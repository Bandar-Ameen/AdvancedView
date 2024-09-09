/*
 * Copyright (c) 2016 Qiscus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.finaldemo.fragments;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import com.astooltech.advancedview.R;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on : April 06, 2017
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
public class QiscusCarouselItemView extends FrameLayout {
    private View cardView;
    private ImageView imageView;
    private TextView titleView;
    private TextView descriptionView;
    private ViewGroup buttonsContainer;

    private JSONObject payload;

    private int titleTextColor;
    private int descriptionTextColor;

    private int buttonsTextColor;
    private int buttonsBackgroundColor;

    private CarouselItemClickListener carouselItemClickListener;
    private QiscusChatButtonView.ChatButtonClickListener chatButtonClickListener;

    public QiscusCarouselItemView(Context context) {
        super(context);
        injectViews();
    }

    public QiscusCarouselItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        injectViews();
    }

    public void setPayload(JSONObject payload) {
        this.payload = payload;
    }

    public void setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    public void setDescriptionTextColor(int descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
    }

    public void setButtonsTextColor(int buttonsTextColor) {
        this.buttonsTextColor = buttonsTextColor;
    }

    public void setButtonsBackgroundColor(int buttonsBackgroundColor) {
        this.buttonsBackgroundColor = buttonsBackgroundColor;
    }

    private void injectViews() {

    }

    public void render() {
        cardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject action = payload.optJSONObject("default_action");
                String type = action.optString("type");
                if (type.equals("postback")) {
                    if (carouselItemClickListener != null) {
                        carouselItemClickListener.onCarouselItemClick(action);
                    }
                } else if (type.equals("link")) {
                    //QiscusCarouselItemView.this.openLink(action.optJSONObject("payload").optString("url"));
                }
            }
        });

        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeholder(R.drawable.qiscus_image_placeholder)
                .error(R.drawable.qiscus_image_placeholder);



        titleView.setTextColor(titleTextColor);
        titleView.setText(payload.optString("title", ""));

        descriptionView.setTextColor(descriptionTextColor);
        descriptionView.setText(payload.optString("description", ""));

        try {
            setUpButtons(payload.getJSONArray("buttons"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setUpButtons(JSONArray buttons) {
        buttonsContainer.removeAllViews();

        int size = buttons.length();
        if (size < 1) {
            return;
        }
        List<QiscusChatButtonView> buttonViews = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                JSONObject jsonButton = buttons.getJSONObject(i);
                String type = jsonButton.optString("type", "");
                if ("postback".equals(type)) {
                    QiscusChatButtonView button = new QiscusChatButtonView(buttonsContainer.getContext(), jsonButton);
                    button.setChatButtonClickListener(chatButtonClickListener);
                    buttonViews.add(button);
                } else if ("link".equals(type)) {
                    QiscusChatButtonView button = new QiscusChatButtonView(buttonsContainer.getContext(), jsonButton);
                    button.setChatButtonClickListener(new QiscusChatButtonView.ChatButtonClickListener() {
                        @Override
                        public void onChatButtonClick(JSONObject jsonButton1) {
                            //QiscusCarouselItemView.this.openLink(jsonButton1.optJSONObject("payload").optString("url"));
                        }
                    });
                    buttonViews.add(button);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < buttonViews.size(); i++) {
            buttonViews.get(i).getButton().setBackgroundColor(buttonsBackgroundColor);
            buttonViews.get(i).getButton().setTextColor(buttonsTextColor);
            buttonsContainer.addView(buttonViews.get(i));
        }

        buttonsContainer.setVisibility(View.VISIBLE);
    }



    public void setCarouselItemClickListener(CarouselItemClickListener carouselItemClickListener) {
        this.carouselItemClickListener = carouselItemClickListener;
    }

    public void setChatButtonClickListener(QiscusChatButtonView.ChatButtonClickListener chatButtonClickListener) {
        this.chatButtonClickListener = chatButtonClickListener;
    }

    public interface CarouselItemClickListener {
        void onCarouselItemClick(JSONObject payload);
    }
}
