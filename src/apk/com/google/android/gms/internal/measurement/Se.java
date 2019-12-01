package com.google.android.gms.internal.measurement;

public final class Se implements Pe {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5047a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Long> f5048b;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5047a = aa.a("measurement.reset_analytics.persist_time", false);
        f5048b = aa.a("measurement.id.reset_analytics.persist_time", 0);
    }

    public final boolean a() {
        return ((Boolean) f5047a.a()).booleanValue();
    }
}
