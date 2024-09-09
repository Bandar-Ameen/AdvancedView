package com.astooltech.advancedview.proteus.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*This class is MyReceiver Broadcast receiver */
public class MyReceiver extends BroadcastReceiver {
static Context mcontext;
    public static ConnectivityReceiverListener connectivityReceiverListener;
public  static boolean usefilter;
public static String Filtername;
    public MyReceiver() {
        super();
    }
  ///  public  static ConnectivityReceiverListener mlisiner;
    @Override
    public void onReceive(Context context, Intent intent) {
        mcontext=context;

        /*get action name from activity which is trigger the broadcast receiver*/
        String action = intent.getAction();
if(usefilter) {
    /*check action name*/
    if ((Filtername).equals(action)) {
         String datvcx=intent.getDataString()+"@@@"+intent.getPackage()+"@@";
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
      //  Log.e("receiver", "on");
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected, 1, datvcx);
        }

    }
}else{
    String datvcx=intent.getDataString()+"@@@"+intent.getPackage()+"@@";
    if (connectivityReceiverListener != null) {
        connectivityReceiverListener.onNetworkConnectionChanged(false, 1, datvcx);
    }
}
    }



 /*   public static boolean isConnected() {
        ConnectivityManager
                cm = (ConnectivityManager) AppController.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }
*/
    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected, int typ, String Dataa);
    }
}
