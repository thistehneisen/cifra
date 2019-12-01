package com.touchin.vtb.b;

/* compiled from: VTBAnalytics.kt */
public enum d {
    BANK_TYPE("bank_type"),
    TASK_TYPE("task_type"),
    LOGIN_DATE("login_date"),
    LOGIN_TIME("login_time"),
    CONNECTED_BANKS("connected_banks"),
    BANK_TIME_USAGE("bank_time_usage"),
    APPLICATION_TIME_USAGE("application_time_usage");
    
    private final String parameterName;

    private d(String str) {
        this.parameterName = str;
    }

    public final String a() {
        return this.parameterName;
    }
}
