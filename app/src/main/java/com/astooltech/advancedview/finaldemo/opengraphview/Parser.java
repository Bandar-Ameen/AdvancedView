package com.astooltech.advancedview.finaldemo.opengraphview;

import com.astooltech.advancedview.finaldemo.opengraphview.network.model.OGData;

import java.io.IOException;
import java.io.InputStream;


public interface Parser {
    OGData parse(InputStream inputStream) throws IOException;
}
