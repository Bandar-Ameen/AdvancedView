package com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.webkit.WebView;

import androidx.annotation.Nullable;

/**
 * @author xiaozhongcen
 * @date 20-8-18
 * @since 1.0.0
 * 提前初始化进程减少白屏
 */
public class WebService extends Service {

    private static final String TAG = WebService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "init process");
        try {
            new WebView(this.getApplicationContext());
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
