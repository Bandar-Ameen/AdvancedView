package com.astooltech.advancedview.proteus.processor;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;

import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;


public abstract class ObjectAttributeProcessor<V extends View> extends AttributeProcessor<V> {

    /**
     * @param view  View
     * @param value
     */
    @Override
    public void handleValue(V view, Value value) {
        if (value.isPrimitive() || value.isNull()) {
            setString(view, value.getAsObject());
        } else {
            setString(view,value.getAsObject());
        }
    }

    @Override
    public void handleResource(V view, Resource resource) {
        String string = resource.getString(view.getContext());
      //  setString(view, null == string ? ProteusConstants.EMPTY : string);
    }

    @Override
    public void handleAttributeResource(V view, AttributeResource attribute) {
        TypedArray a = attribute.apply(view.getContext());
      //  setString(view, a.getString(0));
    }

    @Override
    public void handleStyleResource(V view, StyleResource style) {
        TypedArray a = style.apply(view.getContext());
       // setString(view, a.getString(0));
    }

    /**
     * @param view View
     */
    public abstract void setString(V view, ObjectValue value);

    @Override
    public Value compile(@Nullable Value value, Context context) {
        if (null == value || value.isNull()) {
            return ProteusConstants.EMPTY_STRING;
        }
        return value;
    }
}
