package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;


public class ExtendedDictionaryAutocompleteFilterA extends DynamicAutocompleteFilterA<AbstractFlexibleItem> {

    public ExtendedDictionaryAutocompleteFilterA(
            DynamicAutocompleteProvider dynamicAutocompleteProvider,
            OnDynamicAutocompleteFilterListener onDynamicAutocompleteFilterListener) {
        super(dynamicAutocompleteProvider, onDynamicAutocompleteFilterListener);
    }

    @Override
    public CharSequence convertResultToString(Object resultValue) {
      /* if (resultValue instanceof AbstractFlexibleItem) {
            AbstractFlexibleItem countryModel = (AbstractFlexibleItem) resultValue;

            return "hh";//countryModel..getName();
        }*/

        return super.convertResultToString(resultValue);
    }
}
