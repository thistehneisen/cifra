package com.google.android.gms.internal.measurement;

public final class ef implements C0328af {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5173a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5174b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Boolean> f5175c;

    /* renamed from: d reason: collision with root package name */
    private static final C0439ta<Long> f5176d;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5173a = aa.a("measurement.service.sessions.remove_disabled_session_number", false);
        f5174b = aa.a("measurement.service.sessions.session_number_enabled", false);
        f5175c = aa.a("measurement.service.sessions.session_number_backfill_enabled", false);
        f5176d = aa.a("measurement.id.session_number", 0);
    }

    public final boolean a() {
        return ((Boolean) f5175c.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5173a.a()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f5174b.a()).booleanValue();
    }
}
