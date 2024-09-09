package com.astooltech.advancedview.inlineactivityresult.callbacks;


import com.astooltech.advancedview.inlineactivityresult.Result;

public interface ActivityResultListener {
    void onSuccess(Result result);
    void onFailed(Result result);
}
