package com.astooltech.advancedview.proteus;

import androidx.annotation.NonNull;

import java.util.Map;


public class ALLEventManger {

    @NonNull
    private final Map<String, ALLEvent> event;

    public ALLEventManger(@NonNull Map<String, ALLEvent> event) {
        this.event = event;
    }

    @NonNull
    public ALLEvent get(@NonNull String name) {
        ALLEvent function = event.get(name);
        if (function == null) {
            function = ALLEvent.Allev;
        }
        return function;
    }
}
