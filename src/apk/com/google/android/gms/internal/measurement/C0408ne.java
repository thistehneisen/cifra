package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ne reason: case insensitive filesystem */
public final class C0408ne implements C0390ke {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5295a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5296b;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5295a = aa.a("measurement.collection.efficient_engagement_reporting_enabled", false);
        f5296b = aa.a("measurement.collection.redundant_engagement_removal_enabled", false);
    }

    public final boolean a() {
        return ((Boolean) f5296b.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5295a.a()).booleanValue();
    }
}
