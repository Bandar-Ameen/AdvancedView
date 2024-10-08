/*
 * Copyright (c) 2016 Qiscus.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.finaldemo.fragments;

import androidx.annotation.RestrictTo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created on : March 04, 2017
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public final class QiscusRawDataExtractor {

    private QiscusRawDataExtractor() {
    }

    public static JSONObject getPayload(QiscusComment qiscusComment) throws JSONException {
        return new JSONObject(qiscusComment.getExtraPayload());
    }
}
