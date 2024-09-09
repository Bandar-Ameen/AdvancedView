package com.astooltech.advancedview.finaldemo.inlineactivityresult;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;

import com.astooltech.advancedview.finaldemo.inlineactivityresult.request.Request;
import com.astooltech.advancedview.finaldemo.inlineactivityresult.request.RequestFabric;


/**
 * DO NOT USE THIS FRAGMENT DIRECTLY!
 * It's only here because fragments have to be public
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class ActivityResultFragment extends Fragment {

    private static final String INTENT_TO_START = "INTENT_TO_START";

    private static final int REQUEST_CODE = 24; // [0;65535]

    @Nullable
    private Request request;

    @Nullable
    private ActivityResultListener listener;

    public ActivityResultFragment() {
        setRetainInstance(true);
    }

    public static ActivityResultFragment newInstance(@NonNull final Intent intent, @Nullable ActivityResultListener listener) {
        return newInstance(RequestFabric.create(intent), listener);
    }

    public static ActivityResultFragment newInstance(@NonNull final Request request, @Nullable ActivityResultListener listener) {
        final ActivityResultFragment fragment = new ActivityResultFragment();

        fragment.setRequest(request);
        fragment.setListener(listener);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadArguments();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Execute Request
        executeRequest();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (listener != null) {
                listener.onActivityResult(requestCode, resultCode, data);
            }

            removeFragment();
        }
    }

    public void executeRequest() {
        if (request != null) {
            try {
                request.execute(this, REQUEST_CODE);
            } catch (Exception e) {
                e.printStackTrace();

                if (listener != null) {
                    listener.error(e);
                }

                removeFragment();
            }
        } else {
            // this shouldn't happen, but just to be sure
            if (listener != null) {
                listener.error(new NullPointerException("request is empty"));
            }
            removeFragment();
        }
    }

    private void setRequest(@NonNull Request request) {
        this.request = request;

        saveArguments();
    }

    private void setListener(@Nullable ActivityResultListener listener) {
        if (listener != null) {
            this.listener = listener;
        }
    }

    private void removeFragment() {
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction()
                    .remove(this)
                    .commitAllowingStateLoss();
        }
    }

    private void loadArguments() {
        Bundle arguments = getArguments();

        if (arguments != null) {
            this.request = arguments.getParcelable(INTENT_TO_START);
        }
    }

    private void saveArguments() {
        Bundle args = new Bundle();
        args.putParcelable(INTENT_TO_START, request);

        setArguments(args);
    }

    private int checkForValidRequestCode(int requestCode) {
        if ((requestCode & 0xffff0000) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode=" + requestCode);
        }

        return requestCode;
    }

    interface ActivityResultListener {
        void onActivityResult(int requestCode, int resultCode, Intent data);

        void error(Throwable throwable);
    }
}
