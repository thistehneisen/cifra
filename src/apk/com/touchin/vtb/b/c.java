package com.touchin.vtb.b;

/* compiled from: VTBAnalytics.kt */
public enum c {
    CONFIRM_SELECT_BANK("confirm_select_bank"),
    LOGIN_DATE("login_date"),
    LOGIN_TIME("login_time"),
    SETTINGS_CONFIRM_SELECT_BANK("settings_confirm_select_bank"),
    SELECTED_TASK("selected_task"),
    CONNECTED_BANKS("connected_banks"),
    BANK_TIME_USAGE("bank_time_usage");
    
    private final String eventName;

    private c(String str) {
        this.eventName = str;
    }

    public final String a() {
        return this.eventName;
    }
}
