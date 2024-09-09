package com.astooltech.advancedview.proteus.demo.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class checkNetWork {

    public static boolean isNetworkConnected( Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
