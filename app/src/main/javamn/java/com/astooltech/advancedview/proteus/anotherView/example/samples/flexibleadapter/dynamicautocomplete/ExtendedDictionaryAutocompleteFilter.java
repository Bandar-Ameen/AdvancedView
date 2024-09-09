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

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;


public class ExtendedDictionaryAutocompleteFilter extends DynamicAutocompleteFilter<AbstractFlexibleItem> {

    public ExtendedDictionaryAutocompleteFilter(
            DynamicAutocompleteProvider dynamicAutocompleteProvider,
            OnDynamicAutocompleteFilterListener onDynamicAutocompleteFilterListener) {
        super(dynamicAutocompleteProvider, onDynamicAutocompleteFilterListener);
    }

    @Override
    public CharSequence convertResultToString(Object resultValue) {
      /*  if (resultValue instanceof AbstractFlexibleItem) {
            AbstractFlexibleItem countryModel = (AbstractFlexibleItem) resultValue;

            return "hh";//countryModel..getName();
        }*/

        return super.convertResultToString(resultValue);
    }
}
