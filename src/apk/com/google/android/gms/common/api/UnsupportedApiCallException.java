package com.google.android.gms.common.api;

import com.google.android.gms.common.d;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final d zzas;

    public UnsupportedApiCallException(d dVar) {
        this.zzas = dVar;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.zzas);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
