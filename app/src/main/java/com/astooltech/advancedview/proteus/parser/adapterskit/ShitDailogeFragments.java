package com.astooltech.advancedview.proteus.parser.adapterskit;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.astooltech.advancedview.proteus.ProteusView;

public class ShitDailogeFragments extends BottomSheetDialogFragment {


    ProteusView proo;

    public ShitDailogeFragments( ProteusView pro){

        proo=pro;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        //super.setupDialog(dialog, style);
      /*  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);*/

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
   dialog.setContentView(R.layout.activity_main_content);
      ViewGroup container = getView().findViewById(R.id.recycler_view_container);

      container.addView(proo.getAsView());
       // t.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


}
