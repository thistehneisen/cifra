package com.google.firebase.iid;

public final class zzam extends Exception {
    private final int errorCode;

    public zzam(int i2, String str) {
        super(str);
        this.errorCode = i2;
    }

    public final int a() {
        return this.errorCode;
    }
}
