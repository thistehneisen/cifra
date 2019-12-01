package com.google.android.gms.internal.measurement;

public final class Wd implements Xd {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5078a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Long> f5079b;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5078a = aa.a("measurement.upload_dsid_enabled", false);
        f5079b = aa.a("measurement.id.upload_dsid_enabled", 0);
    }

    public final boolean a() {
        return ((Boolean) f5078a.a()).booleanValue();
    }
}
