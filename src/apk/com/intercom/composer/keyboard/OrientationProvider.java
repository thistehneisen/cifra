package com.intercom.composer.keyboard;

import android.content.Context;

public class OrientationProvider {
    private final Context context;

    public OrientationProvider(Context context2) {
        this.context = context2;
    }

    public int getOrientation() {
        return this.context.getResources().getConfiguration().orientation;
    }
}
