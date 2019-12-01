package com.google.android.gms.internal.measurement;

public final class ff implements gf {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5181a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5182b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Boolean> f5183c;

    /* renamed from: d reason: collision with root package name */
    private static final C0439ta<Boolean> f5184d;

    /* renamed from: e reason: collision with root package name */
    private static final C0439ta<Boolean> f5185e;

    /* renamed from: f reason: collision with root package name */
    private static final C0439ta<Long> f5186f;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5181a = aa.a("measurement.client.sessions.background_sessions_enabled", true);
        f5182b = aa.a("measurement.client.sessions.immediate_start_enabled_foreground", false);
        f5183c = aa.a("measurement.client.sessions.immediate_start_enabled", false);
        f5184d = aa.a("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        f5185e = aa.a("measurement.client.sessions.session_id_enabled", true);
        f5186f = aa.a("measurement.id.sessionization_client", 0);
    }

    public final boolean a() {
        return ((Boolean) f5181a.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5182b.a()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f5184d.a()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f5185e.a()).booleanValue();
    }
}
