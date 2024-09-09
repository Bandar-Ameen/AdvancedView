package com.astooltech.advancedview.finaldemo.opengraphview.network.tasks;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.finaldemo.opengraphview.network.model.OGData;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;


public class OGDataTask extends BaseTask<OGData> {

    public OGDataTask(@NonNull Callable<OGData> callable, OnLoadListener<OGData> listener) {
        super(callable, listener);
    }

    @Override
    protected void done() {
        super.done();
        OGData data;
        if (isCancelled()) {
            return;
        }
        try {
            data = get();
        } catch (InterruptedException | ExecutionException e) {
            onError(e);
            return;
        }
        if (data == null) {
            onError(new IOException("No cache data."));
            return;
        }
        onSuccess(data);
    }
}
