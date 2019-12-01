package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class y extends w {

    /* renamed from: e reason: collision with root package name */
    private final Callable<String> f4817e;

    private y(Callable<String> callable) {
        super(false, null, null);
        this.f4817e = callable;
    }

    /* access modifiers changed from: 0000 */
    public final String a() {
        try {
            return (String) this.f4817e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
