package com.google.android.gms.common.api;

public class ApiException extends Exception {
    protected final Status mStatus;

    public ApiException(Status status) {
        int f2 = status.f();
        String g2 = status.g() != null ? status.g() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(g2).length() + 13);
        sb.append(f2);
        sb.append(": ");
        sb.append(g2);
        super(sb.toString());
        this.mStatus = status;
    }
}
