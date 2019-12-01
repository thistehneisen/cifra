package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ie reason: case insensitive filesystem */
public final class C0378ie implements C0384je {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5222a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Long> f5223b;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5222a = aa.a("measurement.fetch_config_with_admob_app_id", true);
        f5223b = aa.a("measurement.id.fetch_config_with_admob_app_id", 0);
    }

    public final boolean a() {
        return ((Boolean) f5222a.a()).booleanValue();
    }
}
