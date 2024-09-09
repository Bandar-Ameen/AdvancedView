package com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile;

import android.content.Intent;

import androidx.annotation.Nullable;

import io.reactivex.Observable;

public interface OnPreResult<T> {
    Observable<T> response(int requestCode, int resultCode, @Nullable Intent data);
}
