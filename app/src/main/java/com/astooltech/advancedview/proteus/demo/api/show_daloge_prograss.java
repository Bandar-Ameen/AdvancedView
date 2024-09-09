package com.astooltech.advancedview.proteus.demo.api;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.spinkit.SpinKitView;

public class show_daloge_prograss {

    private Context context;
  public   show_daloge_prograss(Context context){
        this.context=context;


    }

    public Dialog showdailog(){
        final Dialog dialog;
        final AlertDialog.Builder builder=new AlertDialog.Builder(context);
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.loader_screen,null);
        builder.setView(view);

        final SpinKitView message=view.findViewById(R.id.spin_kitm);
        dialog=builder.create();
        dialog.setCancelable(false);


        /*yess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logouts();
            }
        });
*/
      /*  noo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
*/


      return  dialog;
    //    dialog.show();

       /* while (true){
            if(checkdata)*/


    }

}
