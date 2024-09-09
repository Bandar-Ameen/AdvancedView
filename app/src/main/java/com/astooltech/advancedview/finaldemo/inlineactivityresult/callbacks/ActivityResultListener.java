package com.astooltech.advancedview.finaldemo.inlineactivityresult.callbacks;


import com.astooltech.advancedview.finaldemo.inlineactivityresult.Result;

public interface ActivityResultListener {
    void onSuccess(Result result);
    void onFailed(Result result);
}
