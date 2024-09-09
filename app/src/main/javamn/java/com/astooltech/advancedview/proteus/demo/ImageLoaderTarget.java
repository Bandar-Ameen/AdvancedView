/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.DrawableValue;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ImageLoaderTarget implements Target {


  @NonNull
  private final DrawableValue.AsyncCallback callback;
private  Context con;
  ProteusView view;
  public ImageLoaderTarget(@NonNull DrawableValue.AsyncCallback callback,Context context) {
    this.callback = callback;
    this.con=context;

  }
  public ImageLoaderTarget(@NonNull DrawableValue.AsyncCallback callback,Context context,ProteusView viewx) {
    this.callback = callback;
    this.con=context;
    this.view=viewx;

  }
  /*@Override
  public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
    callback.setDrawable(resource);
  }
*/

  public  Drawable convertBitmapToDrawable(Bitmap original, Context context) {

    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    int width = original.getWidth();
    int height = original.getHeight();

    float scaleWidth = displayMetrics.scaledDensity;
    float scaleHeight = displayMetrics.scaledDensity;
    Matrix matrix = new Matrix();
    matrix.postScale(scaleWidth, scaleHeight);

    Bitmap resizedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true);

    return new BitmapDrawable(context.getResources(), resizedBitmap);
  }
  @Override
  public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
/*try {


 /* Log.e("999922"
  ViewGroup xc=(ViewGroup) view.getAsView().getRootView();
ProteusView erty=(ProteusView)xc;
  Log.e("999922",erty.getViewManager().findViewById("kkb").getClass().getName());//view.getClass().getName());// ( view.getViewManager().getContext().getInflater().getUniqueViewId("kkb").findViewById("kkb").getClass().getName());
  if (view.getViewManager().findViewById("kkb") instanceof ProtouseSkeletonViewGroup) {

    ProtouseSkeletonViewGroup rre = (ProtouseSkeletonViewGroup) view.getViewManager().findViewById("kkb");
    rre.getViewManager().getActionEventView().sendEvent(null, 155, "noo");
  }
}catch (Exception ex){
  Log.e("999922",ex.getMessage());
}*/

    Drawable x= convertBitmapToDrawable(bitmap,con);
    callback.setDrawable(x);
  }

  @Override
  public void onBitmapFailed(Drawable drawable) {
    callback.setDrawable(drawable);
  }

  /*@Override
  public void onBitmapFailed(Exception e, Drawable errorDrawable) {
  /*  try {
      if (view.getViewManager().findViewById("kkb") instanceof ProtouseSkeletonViewGroup) {

        ProtouseSkeletonViewGroup rre = (ProtouseSkeletonViewGroup) view.getViewManager().findViewById("kkb");
        rre.getViewManager().getActionEventView().sendEvent(null, 156, "noo");
      }
    }catch (Exception ex){
      Log.e("9999",ex.getMessage());
    }
  }
*/
  @Override
  public void onPrepareLoad(Drawable placeHolderDrawable) {
   /*String value="1";
    Sprite g= (value.equals("1")? new Wave():(value.equals("2")?new ChasingDots():new CubeGrid()));
    int   background = ParseHelper.parseColor("#2cdb81");
    g.setColor(background);

    callback.setDrawable(g);*/

   callback.setDrawable(placeHolderDrawable);
  }
}
