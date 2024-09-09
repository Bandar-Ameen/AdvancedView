/*
Copyright 2017 Victor Campos

Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.astooltech.advancedview.proteus.parser.webview.gm.webkit.proview;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.MailTo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewDatabase;
import android.widget.EditText;

import androidx.annotation.AttrRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.astooltech.advancedview.R;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.app.Activity.RESULT_OK;
import static android.webkit.WebSettings.LOAD_CACHE_ELSE_NETWORK;
import static android.webkit.WebSettings.LOAD_CACHE_ONLY;
import static android.webkit.WebSettings.LOAD_DEFAULT;
import static android.webkit.WebSettings.LOAD_NO_CACHE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * ProWebView is another WebView for Android with more functionality and without the hell of the WebClient
 * and the WebChromeClient. With ProWebView you don't have to worry about asking permissions, file download,
 * file upload, JS alerts and dialogs, links without protocols, cache managing and/or cookies managing.
 *
 * ProWebView also supports XML attributes, private mode, block ads and nested scrolling.
 *
 * <b>Permissions</b>
 * ProWebView requires the following permissions:

 * android.permission.INTERNET: required by the {@link WebView}.
 * android.permission.READ_EXTERNAL_STORAGE and android.permission.WRITE_EXTERNAL_STORAGE: required fo the download manager if enabled.
 * android.permission.ACCESS_FINE_LOCATION: required if the location is enabled and the location mode is setted to `modeFine` or `modeBoth`.
 * android.permission.ACCESS_COARSE_LOCATION: required if the location is enabled and the location mode is setted to `modeCoarse` or `modeBoth`.
 * android.permission.ACCESS_NETWORK_STATE and android.network.ACCESS_WIFI_STATE: <b>optional</b>. Used for getting the current network mode.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ProWebView extends WebView implements DownloadListener, NestedScrollingChild {

    /**
     * Set cache mode
     */
    @Retention(SOURCE)
    @IntDef({
            LOAD_CACHE_ELSE_NETWORK,
            LOAD_CACHE_ONLY,
            LOAD_DEFAULT,
            LOAD_NO_CACHE
    })
    private @interface CacheMode {}

    /**
     * Provides a easy handling for {@link WebViewClient} and {@link WebChromeClient} events
     */
    public static class ProClient {
        public void onProgressChanged(ProWebView webView, int progress) {}
        public void onStateChanged(ProWebView webView) {}
        public void onWindowStateChanged(ProWebView webView, boolean showing) {}
        public void onInformationReceived(ProWebView webView, String url, String title, Bitmap favicon) {}
        public void onCustomViewStateChanged(ProWebView webView, View customView, boolean showing) {}
        public void onDownloadStarted(ProWebView webView, String filename, String url) {}
        public void onReceivedError(ProWebView webView, ProWebResourceRequest resourceRequest, ProWebResourceError webResourceError) {}
        public boolean shouldOverrideUrlLoading(ProWebView webView, String url) { return true; }
    }

    /**
     * Callback for source code request
     */
    public interface SourceCodeCallback {
        void onCompleted(String code);
    }

    /**
     * Listener for print jobs
     */
    @RequiresApi(19)
    public interface PrintListener {
        void onSuccess();
        void onFailed();
    }

    /**
     * Listener for console messages
     */
    public interface JsConsoleMessageListener  {
        void onConsoleMessageReceived(ConsoleMessage consoleMessage);
    }

    /**
     * Event handler for HTTP schemes
     */
    public interface SchemeRequest {
        boolean onSchemeRequested(ProWebView view, String url);
    }

    /**
     * Callback for permissions requests
     */
    public interface PermissionCallback {
        @Deprecated
        @RequiresApi(21)
        void onPermissionRequested(RequestCallback<String[]> callback, String[] permission);
        @RequiresApi(21)
        void onPermissionRequested(PermissionRequest permissionRequest);
        void onGeolocationPermission(RequestCallback<Boolean> callback);
    }

    /**
     * Listener for blacklisted hosts and SSL errors
     */
    public interface UrlRequest{
        void onBlockedUrlRequest(RequestCallback<Boolean> callback, String url);
        void onSslErrorRequest(RequestCallback<Void> callback, SslError error);
    }

    /**
     * Callback for requests
     */
    public abstract class RequestCallback<F> {
        public abstract void allow(@Nullable F extra);
        public abstract void deny(@Nullable F extra);
    }

    private static final int REQUEST_FILE = 80;
    private static final int PERMISSION_REQUEST = 81;

    /**
     * Geolocation mode
     */
    public enum LocationMode {
        MODE_FINE,
        MODE_COARSE,
        MODE_BOTH
    }

    /**
     * Detected connection mode
     */
    public enum ConnectionMode {
        CONNECTION_4G,
        CONNECTION_WIFI,
        CONNECTION_NONE,
        CONNECTION_UNKNOWN
    }

    private String aboutBlankHtml;
    private String homeUrl;
    private View customView;
    private ViewGroup targetView;
    private boolean busy;
    private ValueCallback<Uri[]> filePathCallback;
    private ValueCallback<Uri> uriCallback;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private Activity activity;
    private Fragment fragment;
    private List<String> blacklist;
    private boolean privateMode;
    private Map<String, Boolean> loadedUrls;
    private AdBlock adBlock;
    private boolean blockAds;
    private List<String> backStack, forwardStack;
    private List<ConsoleMessage> consoleMessages;
    private ProClient proClient;
    private JsConsoleMessageListener messageListener;
    private HashMap<String, SchemeRequest> schemeHashMap;
    private String defaultProtocol = "http";
    private UrlRequest urlRequest;
    private boolean thirdPartyCookies;
    private boolean cookies;
    private boolean networkEnabled;
    private ConnectionMode connectionMode;
    private List<OnTouchListener> touchListeners;
    private BroadcastReceiver downloadBroadcast;

    private String geoOrigin;
    private boolean geolocationEnabled;
    private LocationMode locationMode;
    private GeolocationPermissions.Callback geoCallback;
    private PermissionCallback permissionCallback;
    private PendingDownload pendingDownload;

    private PermissionRequest requestPermission;

    private int lastY;
    private int[] scrollOffset = new int[2];
    private int[] scrollConsumed = new int[2];
    private int nestedOffsetY;
    private NestedScrollingChildHelper scrollChildHelper;

    private AsyncCodeLoader codeLoader;

    private static final String TAG = "ProWebView";

    /**
     * Receive connection state changes
     */
    private BroadcastReceiver connectionStatusBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ((intent.hasExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY))&&(intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false))) {
                return;
            }
            ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm == null) {
                networkEnabled = false;
                connectionMode = ConnectionMode.CONNECTION_UNKNOWN;
                return;
            }
            @SuppressLint("MissingPermission") NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            if (isConnected) {
                boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
                if (isWiFi) {
                    networkEnabled = true;
                    connectionMode = ConnectionMode.CONNECTION_WIFI;
                } else {
                    networkEnabled = true;
                    connectionMode = ConnectionMode.CONNECTION_4G;
                }
            } else {
                networkEnabled = false;
                connectionMode = ConnectionMode.CONNECTION_NONE;
            }
        }
    };

    /**
     * @see WebView(Context)
     */
    public ProWebView(@NonNull Context context) {
        this(context, null);
    }

    /**
     * @see WebView(Context, AttributeSet)
     */
    public ProWebView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @see WebView(Context, AttributeSet, int)
     */
    public ProWebView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        scrollChildHelper = new NestedScrollingChildHelper(this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ProWebView);
        try {
            setAboutBlankHtml(array.getString(R.styleable.ProWebView_blankHtml));
            setHomeUrl(array.getString(R.styleable.ProWebView_home));
            CharSequence[] blacklist = array.getTextArray(R.styleable.ProWebView_blacklist);
            if (blacklist!=null) {
                for (CharSequence sequence : blacklist)
                    this.blacklist.add(sequence.toString());
            }
            setPrivateBrowsingEnabled(array.getBoolean(R.styleable.ProWebView_privateMode, false));
            blockAds(array.getBoolean(R.styleable.ProWebView_blockAds, false));
            setGeolocationEnabled(array.getBoolean(R.styleable.ProWebView_locationEnabled, false));
            getSettings().setJavaScriptEnabled(array.getBoolean(R.styleable.ProWebView_javascriptEnabled, true));
            switch (array.getInt(R.styleable.ProWebView_locationMode, 1)){
                case 1:
                    setLocationMode(LocationMode.MODE_BOTH);
                    break;
                case 2:
                    setLocationMode(LocationMode.MODE_FINE);
                    break;
                case 3:
                    setLocationMode(LocationMode.MODE_COARSE);
                    break;
            }
            setCookiesEnabled(array.getBoolean(R.styleable.ProWebView_cookiesEnabled, true));
            if (Build.VERSION.SDK_INT>=21)
                setThirdPartyCookiesEnabled(array.getBoolean(R.styleable.ProWebView_thirdPartyCookiesEnabled, true));
            switch (array.getInt(R.styleable.ProWebView_cacheMode, 3)) {
                case 1:
                    getSettings().setCacheMode(LOAD_CACHE_ELSE_NETWORK);
                    break;
                case 2:
                    getSettings().setCacheMode(LOAD_CACHE_ONLY);
                    break;
                case 3:
                    getSettings().setCacheMode(LOAD_DEFAULT);
                    break;
                case 4:
                    getSettings().setCacheMode(LOAD_NO_CACHE);
                    break;
            }
            setNestedScrollingEnabled(array.getBoolean(R.styleable.ProWebView_nestedScrollingEnabled, true));
            String protocol = array.getString(R.styleable.ProWebView_defaultProtocol);
            if (protocol!=null)
                setDefaultProtocol(protocol);
        } finally {
            array.recycle();
        }
    }

    /**
     * This method was marked as deprecated by Google but ProWebView can handle the private browsing by itself.
     * @see WebView(Context, AttributeSet, int, boolean)
     */
    public ProWebView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, boolean privateBrowsing) {
        this(context, attrs, defStyleAttr);
        setPrivateBrowsingEnabled(privateBrowsing);
    }

    /**
     * Initialize ProWebView
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        blacklist = new ArrayList<>();
        adBlock = new AdBlock(getContext());
        loadedUrls = new HashMap<>();
        backStack = new ArrayList<>();
        forwardStack = new ArrayList<>();
        consoleMessages = new ArrayList<>();
        schemeHashMap = new HashMap<>();
        touchListeners = new ArrayList<>();
        registerSchemes();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLocationMode(LocationMode.MODE_BOTH);
        getSettings().setSupportMultipleWindows(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setAllowContentAccess(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setAllowFileAccessFromFileURLs(true);
        getSettings().setAppCacheEnabled(true);
        getSettings().setBuiltInZoomControls(true);
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        getSettings().setDisplayZoomControls(false);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setSupportMultipleWindows(true);
        getSettings().setSupportZoom(true);
        WebViewClient webViewClient = new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                if (Build.VERSION.SDK_INT>=23) {
                    ProWebResourceError webResourceError = new ProWebResourceError(error.getDescription(), error.getErrorCode());
                    boolean redir = false;
                    if (Build.VERSION.SDK_INT>=24)
                        redir = request.isRedirect();
                    ProWebResourceRequest resourceRequest = new ProWebResourceRequest(request.getMethod(), request.getRequestHeaders(), request.getUrl(), request.hasGesture(), request.isForMainFrame(), redir);
                    if (proClient != null)
                        proClient.onReceivedError(ProWebView.this, resourceRequest,webResourceError);
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                ProWebResourceError webResourceError = new ProWebResourceError(description, errorCode);
                ProWebResourceRequest resourceRequest = ProWebResourceRequest.compatBuilder(failingUrl);
                if (proClient !=null)
                    proClient.onReceivedError(ProWebView.this, resourceRequest,webResourceError);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                busy = false;
                backStack.add(url);
                if (proClient !=null)
                    proClient.onStateChanged(ProWebView.this);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                busy = true;
                consoleMessages.clear();
                if (proClient !=null)
                    proClient.onStateChanged(ProWebView.this);
            }

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return shouldOverrideUrlLoading(view, request.getUrl().toString());
            }

            @Override
            public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                boolean doEvent = true;
                if (proClient != null)
                    doEvent = proClient.shouldOverrideUrlLoading((ProWebView) view, url);
                if (doEvent) {
                    if (blacklist.contains(Uri.parse(url).getHost())) {
                        if (urlRequest!=null) {
                            urlRequest.onBlockedUrlRequest(new RequestCallback<Boolean>() {
                                @Override
                                public void allow(@Nullable Boolean extra) {
                                    blacklist.remove(Uri.parse(url).getHost());
                                    view.loadUrl(url);
                                }

                                @Override
                                public void deny(@Nullable Boolean extra) {

                                }
                            }, url);
                        }
                        view.reload();
                        return true;
                    }
                }
                return doEvent;
            }

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, @NonNull WebResourceRequest request) {
                return shouldInterceptRequest(view, request.getUrl().toString());
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (blockAds) {
                    boolean ad;
                    if (!loadedUrls.containsKey(url)) {
                        ad = adBlock.isAd(url);
                        loadedUrls.put(url, ad);
                    } else
                        ad = loadedUrls.get(url);
                    return ad ? adBlock.createEmptyResource() : super.shouldInterceptRequest(view, url);
                }
                return super.shouldInterceptRequest(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                if (urlRequest!=null) {
                    urlRequest.onSslErrorRequest(new RequestCallback<Void>() {
                        @Override
                        public void allow(@Nullable Void extra) {
                            handler.proceed();
                        }

                        @Override
                        public void deny(@Nullable Void extra) {
                            handler.cancel();
                        }
                    }, error);
                }
            }

            @Override
            public void onFormResubmission(@NonNull WebView view, final Message dontResend, final Message resend) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(view.getTitle())
                        .setMessage(R.string.resend_message)
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                resend.sendToTarget();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dontResend.sendToTarget();
                            }
                        })
                        .create().show();
            }
        };
        super.setWebViewClient(webViewClient);
        WebChromeClient webChromeClient = new WebChromeClient(){

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                consoleMessages.add(consoleMessage);
                if (messageListener!=null)
                    messageListener.onConsoleMessageReceived(consoleMessage);
                return true;
            }

            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                if (proClient !=null) {
                    WebViewTransport transport = (WebViewTransport) resultMsg.obj;
                    ProWebView webView = new ProWebView(getContext());
                    transport.setWebView(webView);
                    resultMsg.sendToTarget();
                    proClient.onWindowStateChanged(webView, true);
                    return true;
                }
                return false;
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(view.getTitle());
                builder.setMessage(message);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.confirm();
                    }
                });
                builder.create().show();
                return true;
            }

            @Override
            public boolean onJsBeforeUnload(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(view.getTitle());
                builder.setMessage(message);
                builder.setCancelable(true);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        result.cancel();
                    }
                });
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.confirm();
                    }
                });
                builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.cancel();
                    }
                });
                builder.create().show();
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(view.getTitle());
                builder.setMessage(message);
                builder.setCancelable(true);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        result.cancel();
                    }
                });
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.confirm();
                    }
                });
                builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.cancel();
                    }
                });
                builder.create().show();
                return true;
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
                final EditText editText = new EditText(getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(editText);
                builder.setMessage(message);
                editText.setText(defaultValue);
                builder.setTitle(view.getTitle());
                builder.setCancelable(true);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        result.cancel();
                    }
                });
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.confirm(editText.getText().toString());
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.cancel();
                    }
                });
                builder.create().show();
                return true;
            }

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                openFileInput(uploadMsg, null, null, false);
            }

            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                boolean allowMultiple = false;
                if (Build.VERSION.SDK_INT >= 21)
                    allowMultiple = fileChooserParams.getMode() == FileChooserParams.MODE_OPEN_MULTIPLE;
                return openFileInput(null, filePathCallback, fileChooserParams, allowMultiple);
            }

            @Override
            public void onCloseWindow(WebView window) {
                if (proClient !=null)
                    proClient.onWindowStateChanged((ProWebView) window, false);
            }

            @Override
            public void onHideCustomView() {
                if (targetView==null)
                    throw new NullPointerException();
                if (customView==null)
                    return;
                customView.setVisibility(View.GONE);
                targetView.removeView(customView);
                customView = null;
                targetView.setVisibility(View.GONE);
                customViewCallback.onCustomViewHidden();
                if (proClient !=null)
                    proClient.onCustomViewStateChanged(ProWebView.this, customView, false);
            }

            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                if (targetView==null)
                    throw new NullPointerException();
                customViewCallback = callback;
                targetView.addView(view);
                customView = view;
                targetView.setVisibility(View.VISIBLE);
                targetView.bringToFront();
                if (proClient !=null)
                    proClient.onCustomViewStateChanged(ProWebView.this, customView, true);
            }

            @Override
            public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
                onShowCustomView(view, callback);
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                geoCallback = callback;
                geoOrigin = origin;
                if (proClient !=null) {
                    boolean permission = false;
                    if (isGeolocationEnabled()) {
                        switch (locationMode) {
                            case MODE_BOTH:
                                permission = (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)&&(ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED);
                                break;
                            case MODE_FINE:
                                permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED;
                                break;
                            case MODE_COARSE:
                                permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED;
                                break;
                        }
                        if (permission)
                            if (permissionCallback!=null) {
                                permissionCallback.onGeolocationPermission(new RequestCallback<Boolean>() {
                                    @Override
                                    public void allow(@Nullable Boolean extra) {
                                        if (extra==null)
                                            return;
                                        geoCallback.invoke(geoOrigin, true, extra);
                                        geoCallback = null;
                                        geoOrigin = null;
                                    }

                                    @Override
                                    public void deny(@Nullable Boolean extra) {
                                        if (extra==null)
                                            return;
                                        geoCallback.invoke(geoOrigin, false, extra);
                                        geoCallback = null;
                                        geoOrigin = null;
                                    }
                                });
                            } else {
                                callback.invoke(origin, true, false);
                            }
                        else {
                            switch (locationMode) {
                                case MODE_BOTH:
                                    ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST);
                                    break;
                                case MODE_FINE:
                                    ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
                                    break;
                                case MODE_COARSE:
                                    ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST);
                                    break;
                            }
                        }
                    } else {
                        callback.invoke(origin, false, false);
                    }
                }
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                if (proClient !=null)
                    proClient.onInformationReceived(ProWebView.this, view.getUrl(), view.getTitle(), icon);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (proClient !=null)
                    proClient.onInformationReceived(ProWebView.this, view.getUrl(), title, view.getFavicon());
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (proClient !=null)
                    proClient.onProgressChanged(ProWebView.this, newProgress);
            }

            @SuppressLint("NewApi")
            @Override
            public void onPermissionRequest(PermissionRequest request) {
                if (permissionCallback != null)
                    permissionCallback.onPermissionRequested(request);
                else
                    super.onPermissionRequest(request);
            }
        };
        super.setWebChromeClient(webChromeClient);
        super.setDownloadListener(this);
        setUserAgent(); // Modified user agent
        if ((checkPermission(Manifest.permission.ACCESS_NETWORK_STATE))&&(checkPermission(Manifest.permission.ACCESS_WIFI_STATE))) {
            getContext().registerReceiver(connectionStatusBroadcast, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
            ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm == null) {
                networkEnabled = false;
                connectionMode = ConnectionMode.CONNECTION_UNKNOWN;
                return;
            }
            @SuppressLint("MissingPermission") NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            if (isConnected) {
                boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
                if (isWiFi) {
                    networkEnabled = true;
                    connectionMode = ConnectionMode.CONNECTION_WIFI;
                } else {
                    networkEnabled = true;
                    connectionMode = ConnectionMode.CONNECTION_4G;
                }
            } else {
                networkEnabled = false;
                connectionMode = ConnectionMode.CONNECTION_NONE;
            }
        }
    }

    /**
     * Download handler
     */
    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        if ((activity==null)&&(fragment==null)) {
            throw new NullPointerException();
        }
        DownloadManager dm = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
        if (dm == null)
            return;
        assert activity != null;
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED) {
            if (activity!=null) {
                ActivityCompat.requestPermissions(activity, new String[] {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }, PERMISSION_REQUEST);
            } else {
                fragment.requestPermissions(new String[] {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }, PERMISSION_REQUEST);
            }
            pendingDownload = new PendingDownload(url, userAgent, contentDisposition, mimetype, contentLength);
            return;
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setMimeType(mimetype);
        String cookies = CookieManager.getInstance().getCookie(url);
        request.addRequestHeader("cookie", cookies);
        request.addRequestHeader("User-Agent", userAgent);
        String desc = getResources().getString(R.string.downloading, getLastPathOfUri(url));
        request.setDescription(desc);
        request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
        dm.enqueue(request);
        if (proClient !=null)
            proClient.onDownloadStarted(this, getLastPathOfUri(url), url);
    }

    /**
     * Nested scrolling
     */
    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        scrollChildHelper.setNestedScrollingEnabled(enabled);
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean isNestedScrollingEnabled() {
        return scrollChildHelper.isNestedScrollingEnabled();
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean startNestedScroll(int axes) {
        return scrollChildHelper.startNestedScroll(axes);
    }

    /**
     * Nested scrolling
     */
    @Override
    public void stopNestedScroll() {
        scrollChildHelper.stopNestedScroll();
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean hasNestedScrollingParent() {
        return scrollChildHelper.hasNestedScrollingParent();
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return scrollChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return scrollChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return scrollChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    /**
     * Nested scrolling
     */
    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return scrollChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    /**
     * Nested scrolling. Also fires all the touch listeners
     * @see #addOnTouchListener(OnTouchListener)
     * @see #removeTouchListener(OnTouchListener)
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean returnValue = false;
        MotionEvent event = MotionEvent.obtain(ev);
        final int action = MotionEventCompat.getActionMasked(event);
        if (action == MotionEvent.ACTION_DOWN)
            nestedOffsetY = 0;
        int eventY = (int) event.getY();
        event.offsetLocation(0, nestedOffsetY);
        switch (action) {
            case MotionEvent.ACTION_MOVE:
                int deltaY = lastY - eventY;
                if (dispatchNestedPreScroll(0, deltaY, scrollConsumed, scrollOffset)) {
                    deltaY -= scrollConsumed[1];
                    lastY = eventY - scrollOffset[1];
                    event.offsetLocation(0, -scrollOffset[1]);
                    nestedOffsetY += scrollOffset[1];
                }
                returnValue = super.onTouchEvent(event);
                if (dispatchNestedScroll(0, scrollOffset[1], 0, deltaY, scrollOffset)) {
                    event.offsetLocation(0, scrollOffset[1]);
                    nestedOffsetY += scrollOffset[1];
                    lastY -= scrollOffset[1];
                }
                break;
            case MotionEvent.ACTION_DOWN:
                returnValue = super.onTouchEvent(event);
                lastY = eventY;
                startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                returnValue = super.onTouchEvent(event);
                stopNestedScroll();
                break;
        }
        for (OnTouchListener listener : touchListeners)
            listener.onTouch(this, ev);
        return returnValue;
    }

    /**
     * Improved {@link WebView#goBack()} and {@link WebView#canGoBack()}
     */
    @Override
    public void goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.add(getUrl());
            super.goBack();
            backStack.remove(backStack.size() - 1);
        }
    }
    /**
     * Improved {@link WebView#goForward()} and {@link WebView#canGoForward()}
     */
    @Override
    public void goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.add(getUrl());
            super.goForward();
            forwardStack.remove(forwardStack.size() - 1);
        }
    }

    /**
     * Improved {@link WebView#loadUrl(String)}.
     * Load the links without protocol (Example: google.com) and handle the about:blank
     */
    @Override
    public void loadUrl(String url) {
        if (url.equals("about:blank"))
            showBlank();
        else {
            if (hasProtocol(url)) {
                String scheme = Uri.parse(url).getScheme();
                if (schemeHashMap.containsKey(scheme)) {
                    boolean loaded = schemeHashMap.get(scheme).onSchemeRequested(this, url);
                    if (!loaded)
                        super.loadUrl(url);
                } else
                    super.loadUrl(url);
            } else {
                super.loadUrl(defaultProtocol + "://" + url);
            }
        }
    }

    /**
     * Improved {@link WebView#loadUrl(String, Map)}.
     * Load the links without protocol (Example: google.com) and handle the about:blank
     */
    @Override
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        if (url.equals("about:blank"))
            showBlank();
        else {
            if (hasProtocol(url)) {
                String scheme = Uri.parse(url).getScheme();
                if (schemeHashMap.containsKey(scheme)) {
                    boolean loaded = schemeHashMap.get(scheme).onSchemeRequested(this, url);
                    if (!loaded)
                        super.loadUrl(url, additionalHttpHeaders);
                } else
                    super.loadUrl(url, additionalHttpHeaders);
            } else {
                super.loadUrl(defaultProtocol + "://" + url, additionalHttpHeaders);
            }
        }
    }

    /**
     * Pauses the WebView and all the timers
     * @see WebView#onPause()
     * @see WebView#pauseTimers()
     */
    @Override
    public void onPause() {
        super.pauseTimers();
        super.onPause();
    }

    /**
     * Resume the WebView and all the timers
     * @see WebView#onResume()
     * @see WebView#resumeTimers()
     */
    @Override
    public void onResume() {
        super.resumeTimers();
        super.onResume();
    }

    /**
     * Clear the history and all the back and forward stacks
     */
    @Override
    public void clearHistory() {
        super.clearHistory();
        backStack.clear();
        forwardStack.clear();
    }

    /**
     * @see WebView#isPrivateBrowsingEnabled()
     */
    @Override
    public boolean isPrivateBrowsingEnabled() {
        return privateMode;
    }

    /**
     * @see WebView#setNetworkAvailable(boolean)
     * @deprecated This method is updated automatically if you use ACCESS_WIFI_STATE and ACCESS_NETWORK_STATE
     */
    @Override
    @Deprecated
    public void setNetworkAvailable(boolean networkUp) {
        throw new UnsupportedOperationException("This method is updated automatically if you use ACCESS_WIFI_STATE and ACCESS_NETWORK_STATE");
    }

    /**
     * @see WebView#setWebChromeClient(WebChromeClient)
     * @deprecated Avoid calling this method. Use {@link #setProClient(ProClient)} instead
     */
    @Override
    @Deprecated
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        throw new UnsupportedOperationException("Avoid calling this method. Use setProClient(ProClient) instead.");
    }

    /**
     * @see WebView#setWebViewClient(WebViewClient)
     * @deprecated Avoid calling this method. Use {@link #setProClient(ProClient)} instead
     */
    @Override
    @Deprecated
    public void setWebViewClient(WebViewClient client) {
        throw new UnsupportedOperationException("Avoid calling this method. Use setProClient(ProClient) instead.");
    }

    /**
     * @see WebView#setDownloadListener(DownloadListener)
     * @deprecated Avoid calling this method. Use {@link #setProClient(ProClient)} instead
     */
    @Override
    @Deprecated
    public void setDownloadListener(DownloadListener listener) {
        throw new UnsupportedOperationException("Avoid calling this method. Use setProClient(ProClient) instead.");
    }

    /**
     * Add a new {@link OnTouchListener}
     */
    public void addOnTouchListener(@NonNull OnTouchListener listener) {
        touchListeners.add(listener);
    }

    /**
     * Remove a {@link OnTouchListener}
     */
    public void removeTouchListener(@NonNull OnTouchListener listener) {
        touchListeners.remove(listener);
    }

    /**
     * Register a {@link UrlRequest}
     * @param request listener to register
     */
    public void setUrlRequestListener(UrlRequest request) {
        this.urlRequest = request;
    }

    /**
     * Add a new scheme handler. ProWebView can handle <i>tel:</i>, <i>intent://</i>, <i>geo</i> and <i>mail:</i> schemes
     * @param scheme Scheme to register
     * @param request Listener for the scheme
     */
    public void addSpecialScheme(String scheme, SchemeRequest request) {
        schemeHashMap.put(scheme, request);
    }

    /**
     * Remove a scheme handler
     * @param scheme scheme to remove
     */
    public void removeSpecialScheme(String scheme) {
        schemeHashMap.remove(scheme);
    }

    /**
     * Improved {@link WebView#canGoBackOrForward(int)} and {@link WebView#goBackOrForward(int)}
     */
    public boolean goTo(int steps) {
        if (canGoBackOrForward(steps)) {
            goBackOrForward(steps);
            return true;
        }
        return false;
    }

    /**
     * Improved {@link WebView#canGoBack()} and {@link WebView#goBack()}
     */
    public boolean tryGoBack() {
        if (canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    /**
     * Improved {@link WebView#canGoForward()} and {@link WebView#goForward()}
     */
    public boolean tryGoForward() {
        if (canGoForward()) {
            goForward();
            return true;
        }
        return false;
    }

    /**
     * Check if the geolocation is enabled
     * @return true if enabled
     */
    public boolean isGeolocationEnabled() {
        return geolocationEnabled;
    }

    public void setGeolocationEnabled(boolean enabled){
        this.getSettings().setGeolocationEnabled(enabled);
        this.geolocationEnabled = enabled;
    }

    /**
     * Set a custom HTML code to show in <i>about:blank</i>
     */
    public void setAboutBlankHtml(String html) {
        this.aboutBlankHtml = html;
    }

    /**
     * Get the current HTML code for <i>about:blank</i>
     */
    public String getAboutBlankHtml() {
        return aboutBlankHtml;
    }

    /**
     * Set a home url
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    /**
     * Get the current home url
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * Go home
     */
    public void goHome() {
        if ((homeUrl!=null)&&(homeUrl.length()!=0))
            loadUrl(homeUrl);
        else
            showBlank();
    }

    /**
     * Load the current <i>about:blank</i>
     */
    public void showBlank() {
        if ((aboutBlankHtml!=null) && (!aboutBlankHtml.equals("")))
            loadHtml(aboutBlankHtml);
        else
            super.loadUrl("about:blank");
    }

    /**
     * Load a markdown string into the web view using <a href="https://github.com/arturadib/strapdown">Strapdown.js</a>
     * @param markdown Markdown file
     */
    @SuppressWarnings("StringBufferReplaceableByString")
    public void loadMarkdown(String markdown) {
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>");
        builder.append("<html>");
        builder.append("<textarea theme=\"bootstrap\" style=\"display:none;\">");
        builder.append(markdown);
        builder.append("</textarea>");
        builder.append("<script src=\"file:///android_asset/strapdown.js\"></script>");
        builder.append("</html>");
        loadHtml(builder.toString());
    }

    /**
     * Loads and displays the provided HTML source text
     *
     * @param html the HTML source text to load
     */
    public void loadHtml(String html) {
        loadHtml(html, null);
    }

    /**
     * Loads and displays the provided HTML source text
     *
     * @param html the HTML source text to load
     * @param baseUrl the URL to use as the page's base URL
     */
    public void loadHtml(String html, String baseUrl) {
        loadHtml(html, baseUrl, null);
    }

    /**
     * Loads and displays the provided HTML source text
     *
     * @param html the HTML source text to load
     * @param baseUrl the URL to use as the page's base URL
     * @param historyUrl the URL to use for the page's history entry
     */
    public void loadHtml(String html, String baseUrl, String historyUrl) {
        loadHtml(html, baseUrl, historyUrl, "utf-8");
    }

    /**
     * Loads and displays the provided HTML source text
     *
     * @param html the HTML source text to load
     * @param baseUrl the URL to use as the page's base URL
     * @param historyUrl the URL to use for the page's history entry
     * @param encoding the encoding or charset of the HTML source text
     */
    public void loadHtml(String html, String baseUrl, String historyUrl, String encoding) {
        loadDataWithBaseURL(baseUrl, html, "text/html", encoding, historyUrl);
    }

    /**
     * Force web sites to show their desktop versions
     * @param enabled false loads the mobile version
     */
    public void setDesktopMode(boolean enabled) {
        WebSettings webSettings = getSettings();
        String newUserAgent;
        if (enabled)
            newUserAgent = webSettings.getUserAgentString().replace("Mobile", "eliboM").replace("Android", "diordnA");
        else
            newUserAgent = webSettings.getUserAgentString().replace("eliboM", "Mobile").replace("diordnA", "Android");
        webSettings.setUserAgentString(newUserAgent);
        webSettings.setUseWideViewPort(enabled);
        webSettings.setLoadWithOverviewMode(enabled);
        webSettings.setSupportZoom(enabled);
        webSettings.setBuiltInZoomControls(enabled);
    }

    /**
     * Register a {@link ProClient}
     */
    public void setProClient(ProClient proClient) {
        this.proClient = proClient;
    }

    /**
     * Check if ProWebView is loading a web site
     */
    public boolean isBusy() {
        return busy;
    }

    /**
     * Set a default protocol for urls without it
     */
    public void setDefaultProtocol(String protocol) {
        this.defaultProtocol = protocol;
    }

    /**
     * Get the current default protocol
     */
    public String getDefaultProtocol() {
        return defaultProtocol;
    }

    /**
     * Set the target for custom views
     * @see WebChromeClient#onShowCustomView(View, WebChromeClient.CustomViewCallback)
     * @see WebChromeClient#onShowCustomView(View, int, WebChromeClient.CustomViewCallback)
     * @see WebChromeClient#onHideCustomView()
     */
    public void setTargetView(ViewGroup targetView) {
        this.targetView = targetView;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * <b>Important: </b>set the fragment for the permission manager system.
     * Use this method if you are using ProWebView in an {@link Fragment}
     */
    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    /**
     * Set a listener for {@link ConsoleMessage}
     * @see WebChromeClient#onConsoleMessage(ConsoleMessage)
     * @see WebChromeClient#onConsoleMessage(String, int, String)
     */
    public void setJsConsoleMessageListener(JsConsoleMessageListener listener) {
        this.messageListener = listener;
    }

    /**
     * Enable or disable the private mode
     */
    public void setPrivateBrowsingEnabled(boolean active) {
        setCookiesEnabled(!active);
        if (Build.VERSION.SDK_INT>=21)
            setThirdPartyCookiesEnabled(!active);
        getSettings().setCacheMode(LOAD_NO_CACHE);
        this.privateMode = active;
    }

    /**
     * Check if the connection is enabled
     *
     * @return true if connected
     */
    @RequiresPermission(allOf = {Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE})
    public boolean isNetworkAvailable() {
        return (checkPermission(Manifest.permission.ACCESS_NETWORK_STATE)) && (checkPermission(Manifest.permission.ACCESS_WIFI_STATE)) && ((connectionMode != ConnectionMode.CONNECTION_NONE) && networkEnabled);
    }

    /**
     * Delete the current browsing data
     */
    public void deleteData() {
        clearCache(true);
        clearHistory();
        clearCookies();
        clearDatabase();
        clearStorage();
    }

    /**
     * Clear the cache
     * @see WebView#clearCache(boolean)
     */
    public void clearCache() {
        super.clearCache(false);
    }

    /**
     * Clear the web database
     */
    public void clearDatabase() {
        WebViewDatabase database = WebViewDatabase.getInstance(getContext());
        database.clearHttpAuthUsernamePassword();
        database.clearFormData();
        database.clearUsernamePassword();
    }

    /**
     * Clear the web storage
     * @see WebStorage#deleteAllData()
     */
    public void clearStorage() {
        WebStorage storage = WebStorage.getInstance();
        storage.deleteAllData();
    }

    /**
     * Clear the web storage from a specific origin
     * @see WebStorage#deleteOrigin(String)
     */
    public void clearStorage(String origin) {
        WebStorage storage = WebStorage.getInstance();
        storage.deleteOrigin(origin);
    }

    /**
     * Set the location mode
     */
    public void setLocationMode(LocationMode mode) {
        this.locationMode = mode;
    }

    /**
     * Get the current location mode
     */
    public LocationMode getLocationMode() {
        return locationMode;
    }

    /**
     * Get the current connection mode
     */
    public ConnectionMode getConnectionMode() {
        return connectionMode;
    }

    /**
     * Clear the cookies
     */
    @SuppressWarnings("deprecation")
    public void clearCookies() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(getContext());
            cookieSyncMngr.startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncMngr.stopSync();
            cookieSyncMngr.sync();
        }
    }

    /**
     * Enable or disable third party cookies
     */
    @RequiresApi(21)
    public void setThirdPartyCookiesEnabled(boolean enabled) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, enabled);
        this.thirdPartyCookies = enabled;
    }

    /**
     * Enable or disable the cookies
     */
    public void setCookiesEnabled(boolean enabled) {
        CookieManager.getInstance().setAcceptCookie(enabled);
        this.cookies = enabled;
    }

    /**
     * Check if the third party cookies are enabled
     */
    @RequiresApi(21)
    public boolean areThirdPartyCookiesEnabled() {
        return thirdPartyCookies;
    }

    /**
     * Check if the cookies are enabled
     */
    public boolean areCookiesEnabled()  {
        return cookies;
    }

    /**
     * Add a host to the black list
     */
    public void addHostToBlacklist(String host) {
        blacklist.add(host);
    }

    /**
     * Remove a host from the black list
     */
    public void removeHostFromBlacklist(String host) {
        if (blacklist.contains(host))
            blacklist.remove(host);
    }

    /**
     * Get a list of all the hosts in the black list
     * @return an unmodifiable list of all the hosts in the black list
     * @deprecated This method will be removed soon. Use {@link #getBlacklistedHostsArray()} instead
     */
    @Deprecated
    public List<String> getBlacklistedHosts() {
        return Collections.unmodifiableList(blacklist);
    }

    /**
     * Get a list of all the hosts in the black list
     * @return hosts in black list
     */
    public String[] getBlacklistedHostsArray() {
        return blacklist.toArray(new String[blacklist.size()]);
    }

    /**
     * Check if the ad blocker is active
     */
    public boolean areAdsBlocked() {
        return blockAds;
    }

    /**
     * Enable or disable the ad blocker
     */
    public void blockAds(boolean block) {
        this.blockAds = block;
    }

    /**
     * Get the current back stack
     * @return an unmodifiableList
     * @deprecated This method will be removed soon. Use {@link #getBackStackArray()} instead
     */
    @Deprecated
    public List<String> getBackStack() {
        if (!privateMode)
            return Collections.unmodifiableList(backStack);
        return null;
    }

    /**
     * Get the current back stack
     * @return the back stack
     */
    public String[] getBackStackArray() {
        if (!privateMode)
            return backStack.toArray(new String[backStack.size()]);
        return null;
    }

    /**
     * Get the current forward stack
     * @return an unmodifiableList
     * @deprecated This method will be removed soon. Use {@link #getForwardStackArray()} instead
     */
    @Deprecated
    public List<String> getForwardStack() {
        if (!privateMode)
            return Collections.unmodifiableList(forwardStack);
        return null;
    }

    /**
     * Get the current forward stack
     * @return the forward stack
     */
    public String[] getForwardStackArray() {
        if (!privateMode)
            return forwardStack.toArray(new String[forwardStack.size()]);
        return null;
    }

    /**
     * Get a preview of the web view
     * @param width bitmap width
     * @param height bitmap height
     * @return a preview
     */
    public Bitmap getPreview(int width, int height) {
        if (getMeasuredHeight() <= 0) {
            Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            layout(getLeft(), getTop(), getRight(), getBottom());
            draw(c);
            return b;
        } else {
            int specWidth = MeasureSpec.makeMeasureSpec(0 , MeasureSpec.UNSPECIFIED);
            //noinspection SuspiciousNameCombination
            measure(specWidth, specWidth);
            Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
            draw(c);
            return b;
        }
    }

    /**
     * Register a permission callback
     */
    public void setPermissionCallback(@Nullable PermissionCallback callback) {
        this.permissionCallback = callback;
    }

    /**
     * Get a list of all the console messages sended by the web site
     * @return and unmodifiable list
     * @deprecated This method will be removed soon. Use {@link #getConsoleMessagesArray()} instead
     */
    @Deprecated
    public List<ConsoleMessage> getConsoleMessages() {
        return Collections.unmodifiableList(consoleMessages);
    }

    /**
     * Get a list of all the console messages sended by the web site
     * @return console messages
     */
    public ConsoleMessage[] getConsoleMessagesArray() {
        return consoleMessages.toArray(new ConsoleMessage[consoleMessages.size()]);
    }

    /**
     * Get the source code of the current web site in an {@link AsyncTask}
     */
    public void getSourceCode(@NonNull final SourceCodeCallback callback) {
        codeLoader = new AsyncCodeLoader(new SourceCodeCallback() {
            @Override
            public void onCompleted(String code) {
                callback.onCompleted(code);
                codeLoader = null;
            }
        });
        codeLoader.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, getUrl());
    }

    /**
     * Cancel the current source code request
     */
    public boolean cancelCodeRequest() {
        if (codeLoader!=null) {
            codeLoader.cancel(true);
            codeLoader = null;
            return true;
        }
        return false;
    }

    /**
     * Print the current web site
     */
    @RequiresApi(19)
    public void printWebView(@Nullable PrintListener listener) {
        PrintManager printManager = (PrintManager) getContext().getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printAdapter = createPrintDocumentAdapter();
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setMediaSize(PrintAttributes.MediaSize.NA_LETTER);
        if (printManager != null) {
            PrintJob printJob = printManager.print(getTitle(), printAdapter, builder.build());
            if (listener!=null) {
                if(printJob.isCompleted()){
                    listener.onSuccess();
                } else {
                    listener.onFailed();
                }
            }
        } else {
            if (listener != null) {
                listener.onFailed();
            }
        }
    }

    /**
     * <b>Important</b>
     * Destroy ProWebView
     */
    public void onDestroy() {
        if ((checkPermission(Manifest.permission.ACCESS_NETWORK_STATE))&&(checkPermission(Manifest.permission.ACCESS_WIFI_STATE)))
            getContext().unregisterReceiver(connectionStatusBroadcast);
    }

    /**
     * <b>Important</b>
     * Call this method to upload files
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK) {
            if (requestCode==REQUEST_FILE) {
                if (filePathCallback!=null){
                    if (data.getData()!=null) {
                        filePathCallback.onReceiveValue(new Uri[]{data.getData()});
                        filePathCallback = null;
                    }
                } else if (uriCallback!=null) {
                    if (data.getData()!=null) {
                        uriCallback.onReceiveValue(data.getData());
                        uriCallback = null;
                    }
                }
            }
        } else {
            if (filePathCallback!=null) {
                filePathCallback.onReceiveValue(null);
                filePathCallback = null;
            }
            if (uriCallback!=null) {
                uriCallback.onReceiveValue(null);
                uriCallback = null;
            }
        }
    }

    /**
     * Save the current instance
     */
    public void onSavedInstanceState(Bundle outState) {
        saveState(outState);
    }

    /**
     * Restore the instance
     */
    public void onRestoreInstanceState(Bundle inState) {
        restoreState(inState);
    }

    /**
     * <b>Important</b>
     * This is the permission manager system
     */
    @SuppressLint("NewApi")
    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean write = false;
        boolean read = false;
        boolean fine = false;
        boolean coarse = false;
        if (requestCode==PERMISSION_REQUEST) {
            for(int i = 0; i<permissions.length; i++) {
                String permission = permissions[i];
                int result = grantResults[i];
                switch (permission) {
                    case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                        write = result==PackageManager.PERMISSION_GRANTED;
                        break;
                    case Manifest.permission.READ_EXTERNAL_STORAGE:
                        read = result==PackageManager.PERMISSION_GRANTED;
                        break;
                    case Manifest.permission.ACCESS_FINE_LOCATION:
                        fine = result==PackageManager.PERMISSION_GRANTED;
                        break;
                    case Manifest.permission.ACCESS_COARSE_LOCATION:
                        coarse = result==PackageManager.PERMISSION_GRANTED;
                        break;
                }
            }
            if (fine || coarse) {
                if (permissionCallback!=null) {
                    permissionCallback.onGeolocationPermission(new RequestCallback<Boolean>() {

                        @Override
                        public void allow(@Nullable Boolean extra) {
                            if (extra==null)
                                return;
                            geoCallback.invoke(geoOrigin, true, extra);
                            geoCallback = null;
                            geoOrigin = null;
                        }

                        @Override
                        public void deny(@Nullable Boolean extra) {
                            if (extra==null)
                                return;
                            geoCallback.invoke(geoOrigin, false, extra);
                            geoCallback = null;
                            geoOrigin = null;
                        }
                    });
                } else {
                    geoCallback.invoke(geoOrigin, false, false);
                    geoCallback = null;
                    geoOrigin = null;
                }
            }
            if (write && read) {
                if (pendingDownload != null) {
                    onDownloadStart(pendingDownload.getUrl(), pendingDownload.getUserAgent(), pendingDownload.getContent(), pendingDownload.getMime(), pendingDownload.getLen());
                    pendingDownload = null;
                }
            }
        }
    }

    //Private methods

    @NonNull
    private String getLastPathOfUri(String url) {
        try {
            URI uri = new URI(url);
            String path = uri.getPath();
            return path.substring(path.lastIndexOf('/') + 1);
        } catch (URISyntaxException e) {
            Log.e(TAG, e.getMessage());
            return "";
        }
    }

    private Intent newEmailIntent(String address, String subject, String body, String cc) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { address });
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_CC, cc);
        intent.setType("message/rfc822");
        return intent;
    }

    private boolean hasProtocol(String url) {
        Pattern pattern = Pattern.compile("\\w+:");
        Matcher matcher = pattern.matcher(url);
        return matcher.find();
    }

    private boolean checkPermission(String permission) {
        int res = getContext().checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    private void setUserAgent() {
        String userAgent = getSettings().getUserAgentString();
        getSettings().setUserAgentString(userAgent + " ProMod/1.0");
    }

    private void registerSchemes() {
        addSpecialScheme("tel", new SchemeRequest() {
            @Override
            public boolean onSchemeRequested(ProWebView view, String url) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                getContext().startActivity(intent);
                view.reload();
                return true;
            }
        });
        addSpecialScheme("mailto", new SchemeRequest() {
            @Override
            public boolean onSchemeRequested(ProWebView view, String url) {
                MailTo mt = MailTo.parse(url);
                Intent i = newEmailIntent(mt.getTo(), mt.getSubject(), mt.getBody(), mt.getCc());
                getContext().startActivity(i);
                view.reload();
                return true;
            }
        });
        addSpecialScheme("intent", new SchemeRequest() {
            @Override
            public boolean onSchemeRequested(ProWebView view, String url) {
                try {
                    Context context = view.getContext();
                    Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                    if (intent != null) {
                        view.stopLoading();
                        PackageManager packageManager = context.getPackageManager();
                        ResolveInfo info = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (info != null) {
                            context.startActivity(intent);
                        }
                        return true;
                    }
                } catch (URISyntaxException eg) {
                    Log.e(TAG, eg.getMessage());
                }
                return false;
            }
        });
        addSpecialScheme("geo", new SchemeRequest() {
            @Override
            public boolean onSchemeRequested(ProWebView view, String url) {
                getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                view.reload();
                return true;
            }
        });
    }

    private boolean openFileInput(ValueCallback<Uri> uriCallback, ValueCallback<Uri[]> arrayCallback, WebChromeClient.FileChooserParams fileChooserParams, boolean allowMultiple) {
        if ((activity==null)&&(fragment==null))
            throw new NullPointerException("Must set an activity or a fragment!");
        assert activity != null;
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED) {
            if (activity!=null) {
                ActivityCompat.requestPermissions(activity, new String[] {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }, PERMISSION_REQUEST);
            } else {
                fragment.requestPermissions(new String[] {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }, PERMISSION_REQUEST);
            }
            return false;
        }
        if (filePathCallback!=null) {
            filePathCallback.onReceiveValue(new Uri[]{});
            filePathCallback = null;
        }
        if (this.uriCallback!=null) {
            this.uriCallback.onReceiveValue(null);
            this.uriCallback = null;
        }
        Intent intent= new Intent();
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        if (Build.VERSION.SDK_INT>=21) {
            if (fileChooserParams.getAcceptTypes()!=null)
                intent.putExtra(Intent.EXTRA_MIME_TYPES, fileChooserParams.getAcceptTypes());
        }
        if (allowMultiple) {
            if (Build.VERSION.SDK_INT >= 18) {
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            }
        }
        if ((arrayCallback!=null) && (fileChooserParams!=null)) {
            this.filePathCallback = arrayCallback;
            this.uriCallback = null;
        } else if (uriCallback!=null) {
            this.filePathCallback = null;
            this.uriCallback = uriCallback;
        }
        String title = getResources().getString(R.string.file_picker);
        if (Build.VERSION.SDK_INT>=21) {
            try {
                //noinspection ConstantConditions
                title = fileChooserParams.getTitle().toString();
            } catch (NullPointerException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        if (activity!=null)
            activity.startActivityForResult(Intent.createChooser(intent, title), REQUEST_FILE);
        else if (fragment!=null)
            fragment.startActivityForResult(Intent.createChooser(intent, title), REQUEST_FILE);
        return true;
    }

    private class AdBlock {

        private String AD_HOSTS_FILE = "pgl.yoyo.org.txt";
        private Set<String> AD_HOSTS = new HashSet<>();
        private Context context;

        AdBlock(Context context) {
            this.context = context;
            init();
        }

        private void init() {
            try {
                loadFromAssets(context);
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }
        }

        @WorkerThread
        private void loadFromAssets(Context context) throws IOException {
            InputStream stream = context.getAssets().open(AD_HOSTS_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                AD_HOSTS.add(line);
            }
            reader.close();
            stream.close();
        }

        boolean isAd(String url) {
            Uri httpUrl = Uri.parse(url);
            return isAdHost(httpUrl != null ? httpUrl.getHost() : "");
        }

        private boolean isAdHost(String host) {
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            int index = host.indexOf(".");
            return index >= 0 && (AD_HOSTS.contains(host) ||
                    index + 1 < host.length() && isAdHost(host.substring(index + 1)));
        }

        @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
        WebResourceResponse createEmptyResource() {
            return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
        }

    }

    private static class AsyncCodeLoader extends AsyncTask<String, Void, String> {

        private @NonNull
        SourceCodeCallback callback;

        private AsyncCodeLoader(@NonNull SourceCodeCallback callback) {
            this.callback = callback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            Uri uri = Uri.parse(strings[0]);
            StringBuilder sb = new StringBuilder();
            if (uri.getScheme().contains("http")) {
                try {
                    URL url = new URL(strings[0]);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(url.openStream()));

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        sb.append(inputLine);
                        sb.append('\n');
                    }
                    in.close();
                    return sb.toString();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                    return "\n";
                }
            } else {
                try {
                    File file = new File(uri.getPath());
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                        sb.append('\n');
                    }
                    br.close();
                    return sb.toString();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                    return "\n";
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            callback.onCompleted(s);
        }
    }

}
