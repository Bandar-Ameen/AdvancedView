package com.astooltech.advancedview.finaldemo.opengraphview.network.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.finaldemo.opengraphview.OGParser;
import com.astooltech.advancedview.finaldemo.opengraphview.Parser;
import com.astooltech.advancedview.finaldemo.opengraphview.network.model.OGData;

public class OGDataCallable implements Callable<OGData> {

    private final String url;
    private final Parser parser;

    public OGDataCallable(String url, Parser parser) {
        this.url = url;
        this.parser = parser == null ? new OGParser() : parser;
    }

    @Override
    public OGData call() throws Exception {
        InputStream is = null;
        OGData data = null;
        try {
            is = downloadUrl(url);
            data = parser.parse(is);
        } catch (IOException e) {
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    //nop
                }
            }
        }
        return data;
    }

    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
