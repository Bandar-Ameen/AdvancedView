package com.astooltech.advancedview.proteus.demo.api;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.astooltech.advancedview.proteus.ProteusView;

public class DalogeFragment extends DialogFragment {


    ProteusView proo;
    DialogInterface ondiloge;
    int setDatasave;
    boolean checkOK;
   public DalogeFragment( ProteusView pro,DialogInterface ondiloge,int setDatasavee, boolean checkOKk){

       proo=pro;
       this.ondiloge=ondiloge;
       this.setDatasave=setDatasavee;
       this.checkOK=checkOKk;
   }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        this.ondiloge.cancel();
        this.setDatasave=2;
        this.checkOK=true;
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        this.ondiloge.dismiss();
        this.setDatasave=1;
    }

    @NonNull
    @Override
    public AlertDialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);

        builder.setView(proo.getAsView());
      AlertDialog t=  builder.create();
 t.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
     return t;
    }
}
