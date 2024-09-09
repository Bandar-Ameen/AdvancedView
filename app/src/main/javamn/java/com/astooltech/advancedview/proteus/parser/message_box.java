package com.astooltech.advancedview.proteus.parser;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.astooltech.advancedview.R;
import com.google.gson.Gson;

public class message_box {

    Context context;
    public message_box(Context context) {
        this.context = context;
    }
    public message_box() {
    }


    public void customToast(String message){


            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.custome_aliog_essage, null);
            TextView messagee = view.findViewById(R.id.textmessage);
            messagee.setText(message);
            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(view);
            toast.show();



}
    public void customToast(String message,  typ_message typmessage,boolean fromrequest){




          if(typmessage==typ_message.messagrror) {

              if(fromrequest) {
try {
    Gson g = new Gson();

    response_cacher bb = g.fromJson(message, response_cacher.class);

    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View view = layoutInflater.inflate(R.layout.custome_aliog_essage, null);
    TextView messagee = view.findViewById(R.id.textmessage);
    messagee.setText(bb
            .getData());
    Toast toast = new Toast(context);
    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.setView(view);
    toast.show();
}catch (Exception ex){

}
              }else{
                  LayoutInflater layoutInflater = LayoutInflater.from(context);
                  View view = layoutInflater.inflate(R.layout.custome_aliog_essage, null);
                  TextView messagee = view.findViewById(R.id.textmessage);
                  messagee.setText(message);
                  Toast toast = new Toast(context);
                  toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                  toast.setDuration(Toast.LENGTH_SHORT);
                  toast.setView(view);
                  toast.show();


              }
          }




    }
}
