package com.touchin.vtb.b;

/* compiled from: VTBAnalytics.kt */
public enum f {
    NO_NETWORK("no_network"),
    FAILED_TO_LOAD_DATA("failed_to_load_data"),
    SESSION_EXPIRED("session_expired"),
    BANK_CONNECTION_FAILED("bank_connection_failed"),
    INVALID_ENTER_PIN("invalid_enter_pin");
    
    private final String errorName;

    private f(String str) {
        this.errorName = str;
    }

    public final String a() {
        return this.errorName;
    }
}
