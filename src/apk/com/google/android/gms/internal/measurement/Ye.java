package com.google.android.gms.internal.measurement;

public final class Ye implements Ve {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5103a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5104b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Boolean> f5105c;

    /* renamed from: d reason: collision with root package name */
    private static final C0439ta<Boolean> f5106d;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5103a = aa.a("measurement.service.audience.scoped_filters_v27", false);
        f5104b = aa.a("measurement.service.audience.session_scoped_user_engagement", false);
        f5105c = aa.a("measurement.service.audience.session_scoped_event_aggregates", false);
        f5106d = aa.a("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }

    public final boolean a() {
        return ((Boolean) f5103a.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5104b.a()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f5105c.a()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f5106d.a()).booleanValue();
    }
}
