/*
 * Copyright (C) 2017 Sylwester Sokolowski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete;

import android.widget.AutoCompleteTextView;

/**
 * Interface definition for a callback to be invoked when autocomplete has been finished.
 *
 * @author Sylwester Sokolowski
 */
public interface OnDynamicAutocompleteListener {
    /**
     * Called when autocomplete process has been started.
     *
     * @param view instance of AutoCompleteTextView.
     */
    void onDynamicAutocompleteStart(AutoCompleteTextView view);

    /**
     * Called when autocomplete process has been finished.
     *
     * @param view instance of AutoCompleteTextView.
     */
    void onDynamicAutocompleteStop(AutoCompleteTextView view);
}
