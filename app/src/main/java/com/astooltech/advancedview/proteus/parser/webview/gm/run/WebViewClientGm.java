/*
 *    Copyright 2012 Werner Bayer
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.astooltech.advancedview.proteus.parser.webview.gm.run;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.astooltech.advancedview.proteus.parser.webview.gm.model.Script;
import com.astooltech.advancedview.proteus.parser.webview.gm.model.ScriptRequire;
import com.astooltech.advancedview.proteus.parser.webview.gm.store.ScriptStore;

import java.util.UUID;

/**
 * A user script enabled WebViewClient to be used by WebViewGm.
 */
public class WebViewClientGm extends WebViewClient {

	private static final String TAG = WebViewClientGm.class.getName();

	private static final String JSCONTAINERSTART = "(function() {\n";

	private static final String JSCONTAINEREND = "\n})()";

	private static final String JSUNSAFEWINDOW = "unsafeWindow = (function() { var el = document.createElement('p'); el.setAttribute('onclick', 'return window;'); return el.onclick(); }()); window.wrappedJSObject = unsafeWindow;\n";

	private static final String JSMISSINGFUNCTION = "function() { GM_log(\"Called function not yet implemented\"); };\n";

	private static final String JSMISSINGFUNCTIONS = "var GM_info = "
			+ JSMISSINGFUNCTION + "var GM_openInTab = " + JSMISSINGFUNCTION
			+ "var GM_registerMenuCommand = " + JSMISSINGFUNCTION
			+ "var GM_setClipboard = " + JSMISSINGFUNCTION;

	private ScriptStore scriptStore;

	private String jsBridgeName;

	private String secret;

	/**
	 * Constructs a new WebViewClientGm with a ScriptStore.
	 * 
	 * @param scriptStore
	 *            the script database to query for scripts to run when a page
	 *            starts/finishes loading
	 * @param jsBridgeName
	 *            the variable name to access the webview GM functions from
	 *            javascript code
	 * @param secret
	 *            a random string that is added to calls of the GM API
	 */
	public WebViewClientGm(ScriptStore scriptStore, String jsBridgeName,
			String secret) {
		this.scriptStore = scriptStore;
		this.jsBridgeName = jsBridgeName;
		this.secret = secret;
	}

	/**
	 * Runs user scripts enabled for a given URL.
	 * 
	 * Unless a script specifies unwrap it is executed inside an anonymous
	 * function to hide it from access from the loaded page. Calls to the global
	 * JavaScript bridge methods require a secret that is set inside of each
	 * user script's anonymous function.
	 * 
	 * @param view
	 *            the view to load scripts in
	 * @param url
	 *            the current address
	 * @param pageFinished
	 *            true if scripts with runAt property set to document-end or
	 *            null should be run, false if set to document-start
	 * @param jsBeforeScript
	 *            JavaScript code to add between the GM API and the start of the
	 *            user script code (may be null)
	 * @param jsAfterScript
	 *            JavaScript code to add after the end of the user script code
	 *            (may be null)
	 */
	protected void runMatchingScripts(WebView view, String url,
			boolean pageFinished, String jsBeforeScript, String jsAfterScript) {
		if (scriptStore == null) {
			Log.w(TAG, "Property scriptStore is null - not running any scripts");
			return;
		}
		Script[] matchingScripts = scriptStore.get(url);
		if (matchingScripts == null) {
			return;
		}
		if (jsBeforeScript == null) {
			jsBeforeScript = "";
		}
		if (jsAfterScript == null) {
			jsAfterScript = "";
		}
		for (Script script : matchingScripts) {
			if ((!pageFinished && Script.RUNATSTART.equals(script.getRunAt()))
					|| (pageFinished && (script.getRunAt() == null || Script.RUNATEND
							.equals(script.getRunAt())))) {
				Log.i(TAG, "Running script \"" + script + "\" on " + url);
				String defaultSignature = "\""
						+ script.getName().replace("\"", "\\\"") + "\", \""
						+ script.getNamespace().replace("\"", "\\\"")
						+ "\", \"" + secret + "\"";
				String callbackPrefix = ("GM_"
						+ script.getName()
						+ script.getNamespace()
						+ UUID.randomUUID().toString())
						.replaceAll("[^0-9a-zA-Z_]", "");
				String jsApi = JSUNSAFEWINDOW;
				jsApi += "var GM_listValues = function() { return "
						+ jsBridgeName + ".listValues(" + defaultSignature
						+ ").split(\",\"); };\n";
				jsApi += "var GM_getValue = function(name, defaultValue) { return "
						+ jsBridgeName
						+ ".getValue("
						+ defaultSignature
						+ ", name, defaultValue); };\n";
				jsApi += "var GM_setValue = function(name, value) { "
						+ jsBridgeName + ".setValue(" + defaultSignature
						+ ", name, value); };\n";
				jsApi += "var GM_deleteValue = function(name) { "
						+ jsBridgeName + ".deleteValue(" + defaultSignature
						+ ", name); };\n";
				jsApi += "var GM_addStyle = function(css) { "
						+ "var style = document.createElement(\"style\"); "
						+ "style.type = \"text/css\"; style.innerHTML = css; "
						+ "document.getElementsByTagName('head')[0].appendChild(style); };\n";
				jsApi += "var GM_log = function(message) { " + jsBridgeName
						+ ".log(" + defaultSignature + ", message); };\n";
				jsApi += "var GM_getResourceURL = function(resourceName) { return "
						+ jsBridgeName
						+ ".getResourceURL("
						+ defaultSignature
						+ ", resourceName); };\n";
				jsApi += "var GM_getResourceText = function(resourceName) { return "
						+ jsBridgeName
						+ ".getResourceText("
						+ defaultSignature
						+ ", resourceName); };\n";
				jsApi += "var GM_xmlhttpRequest = function(details) { \n"
						+ "if (details.onabort) { unsafeWindow."
						+ callbackPrefix
						+ "GM_onAbortCallback = details.onabort;\n"
						+ "details.onabort = '"
						+ callbackPrefix
						+ "GM_onAbortCallback'; }\n"
						+ "if (details.onerror) { unsafeWindow."
						+ callbackPrefix
						+ "GM_onErrorCallback = details.onerror;\n"
						+ "details.onerror = '"
						+ callbackPrefix
						+ "GM_onErrorCallback'; }\n"
						+ "if (details.onload) { unsafeWindow."
						+ callbackPrefix
						+ "GM_onLoadCallback = details.onload;\n"
						+ "details.onload = '"
						+ callbackPrefix
						+ "GM_onLoadCallback'; }\n"
						+ "if (details.onprogress) { unsafeWindow."
						+ callbackPrefix
						+ "GM_onProgressCallback = details.onprogress;\n"
						+ "details.onprogress = '"
						+ callbackPrefix
						+ "GM_onProgressCallback'; }\n"
						+ "if (details.onreadystatechange) { unsafeWindow."
						+ callbackPrefix
						+ "GM_onReadyStateChange = details.onreadystatechange;\n"
						+ "details.onreadystatechange = '"
						+ callbackPrefix
						+ "GM_onReadyStateChange'; }\n"
						+ "if (details.ontimeout) { unsafeWindow."
						+ callbackPrefix
						+ "GM_onTimeoutCallback = details.ontimeout;\n"
						+ "details.ontimeout = '"
						+ callbackPrefix
						+ "GM_onTimeoutCallback'; }\n"
						+ "if (details.upload) {\n"
						+ "if (details.upload.onabort) { unsafeWindow."
						+ callbackPrefix
						+ "GM_uploadOnAbortCallback = details.upload.onabort;\n"
						+ "details.upload.onabort = '"
						+ callbackPrefix
						+ "GM_uploadOnAbortCallback'; }\n"
						+ "if (details.upload.onerror) { unsafeWindow."
						+ callbackPrefix
						+ "GM_uploadOnErrorCallback = details.upload.onerror;\n"
						+ "details.upload.onerror = '"
						+ callbackPrefix
						+ "GM_uploadOnErrorCallback'; }\n"
						+ "if (details.upload.onload) { unsafeWindow."
						+ callbackPrefix
						+ "GM_uploadOnLoadCallback = details.upload.onload;\n"
						+ "details.upload.onload = '"
						+ callbackPrefix
						+ "GM_uploadOnLoadCallback'; }\n"
						+ "if (details.upload.onprogress) { unsafeWindow."
						+ callbackPrefix
						+ "GM_uploadOnProgressCallback = details.upload.onprogress;\n"
						+ "details.upload.onprogress = '"
						+ callbackPrefix
						+ "GM_uploadOnProgressCallback'; }\n"
						+ "}\n"
						+ "return JSON.parse("
						+ jsBridgeName
						+ ".xmlHttpRequest("
						+ defaultSignature
						+ ", JSON.stringify(details))); };\n";
				// TODO implement missing functions
				jsApi += JSMISSINGFUNCTIONS;

				// Get @require'd scripts to inject for this script.
				String jsAllRequires = "";
				ScriptRequire[] requires = script.getRequires();
				if (requires != null) {
					for (ScriptRequire currentRequire : requires) {
						jsAllRequires += (currentRequire.getContent() + "\n");
					}
				}

                String jsCode = jsApi + jsAllRequires + jsBeforeScript + script
                        .getContent() + jsAfterScript;
                if (!script.isUnwrap()) {
                    jsCode = JSCONTAINERSTART + jsCode + JSCONTAINEREND;
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    view.evaluateJavascript(jsCode, null);
                } else {
                    view.loadUrl("javascript:\n" + jsCode);
                }
			}
		}
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		runMatchingScripts(view, url, false, null, null);
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		runMatchingScripts(view, url, true, null, null);
	}

	/**
	 * @return the scriptStore
	 */
	public ScriptStore getScriptStore() {
		return scriptStore;
	}

	/**
	 * @param scriptStore
	 *            the scriptStore to set
	 */
	public void setScriptStore(ScriptStore scriptStore) {
		this.scriptStore = scriptStore;
	}

	/**
	 * @return the jsBridgeName
	 */
	public String getJsBridgeName() {
		return jsBridgeName;
	}

	/**
	 * @param jsBridgeName
	 *            the jsBridgeName to set
	 */
	public void setJsBridgeName(String jsBridgeName) {
		this.jsBridgeName = jsBridgeName;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

}
