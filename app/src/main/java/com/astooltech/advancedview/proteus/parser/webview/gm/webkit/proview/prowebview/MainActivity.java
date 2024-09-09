package com.astooltech.advancedview.proteus.parser.webview.gm.webkit.proview.prowebview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.parser.webview.gm.webkit.proview.ProWebView;
import com.astooltech.advancedview.proteus.parser.webview.gm.webkit.proview.ProWebViewControls;


public class MainActivity extends AppCompatActivity {

    private ProWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web);
        webView = findViewById(R.id.webview);
        webView.setActivity(this);
        webView.addSpecialScheme("test", new ProWebView.SchemeRequest() {
            @Override
            public boolean onSchemeRequested(ProWebView view, String url) {
                view.loadHtml("<h1>Loaded scheme &quot;test&quot;</h1>", url, url, "utf-8");
                return true;
            }
        });
        ProWebViewControls controls = findViewById(R.id.controls);
        controls.setProWebView(webView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.markdown) {
            webView.loadMarkdown("#Title\n" +
                    "##Title\n" +
                    "###Title\n" +
                    "####Title\n" +
                    "#####Title\n" +
                    "######Title\n" +
                    "Text with `code` here and a url [here](http://www.example.com/)\n" +
                    "\n" +
                    "~~Strike~~\n" +
                    "__Bold__\n" +
                    "*Italic*\n" +
                    "~~__*Strike, Bold and Italic*__~~\n" +
                    "\n" +
                    "```javascript\n" +
                    "function write(text) {\n" +
                    "\tconsole.log(text);\n" +
                    "}\n" +
                    "```\n" +
                    "\n" +
                    "![Markdown](https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Markdown-mark.svg/1200px-Markdown-mark.svg.png  \"Markdown\")");
        } else if (itemId == R.id.html) {
            webView.loadHtml("<!DOCTYPE html><html><h1>ProWebView</h1><p>This is a simple HTML code generated programmatically</p><p>See the documentation for more information</p></html>");
        } else if (itemId == R.id.example) {
            webView.loadUrl("http://www.example.com");
        } else if (itemId == R.id.clear) {
            webView.loadUrl("about:blank");
        } else if (itemId == R.id.upload_test) {
            webView.loadUrl("https://encodable.com/uploaddemo/");
        } else if (itemId == R.id.custom_scheme) {
            webView.loadUrl("test://scheme");
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        webView.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        webView.onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.onSavedInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.onRestoreInstanceState(savedInstanceState);
    }
}
