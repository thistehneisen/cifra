package com.touchin.vtb.b;

/* compiled from: VTBAnalytics.kt */
public enum e {
    DEVICE_MODEL("device_model");
    
    private final String propertyName;

    private e(String str) {
        this.propertyName = str;
    }

    public final String a() {
        return this.propertyName;
    }
}
