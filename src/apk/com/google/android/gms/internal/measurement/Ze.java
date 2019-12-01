package com.google.android.gms.internal.measurement;

public final class Ze implements _e {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5112a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5113b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Long> f5114c;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5112a = aa.a("measurement.audience.sequence_filters", false);
        f5113b = aa.a("measurement.audience.sequence_filters_bundle_timestamp", false);
        f5114c = aa.a("measurement.id.audience.sequence_filters", 0);
    }

    public final boolean a() {
        return ((Boolean) f5112a.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5113b.a()).booleanValue();
    }
}
