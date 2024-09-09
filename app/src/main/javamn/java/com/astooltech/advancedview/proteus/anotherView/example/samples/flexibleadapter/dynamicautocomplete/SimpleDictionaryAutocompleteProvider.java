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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SimpleDictionaryAutocompleteProvider extends AbstractProvider implements DynamicAutocompleteProvider<String> {

    private static final String REST_URL = "http://sstgadh.wirt09.biznes-host.pl/rest/api/dictionaryService.php?method=findWord&word=%s";

    @Override
    public Collection<String> provideDynamicAutocompleteItems(String constraint) {

        String queryUrl = buildQueryUrl(REST_URL, constraint);
        String json = invokeRestQuery(queryUrl);
        List<String> result = parseJsonContent(json);

        return result;
    }

    private List<String> parseJsonContent(String json) {

        List<String> result = new ArrayList<>();
      /*  Type type = new TypeToken<Collection<DictionaryModel>>(){}.getType();
        List<DictionaryModel> items = new Gson().fromJson(json, type);
        List<String> result = new ArrayList<>();

        if (items != null) {
            for (DictionaryModel item : items) {
                result.add(item.getWord());
            }
        }
*/
        return result;
    }
}