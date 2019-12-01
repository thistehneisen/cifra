package com.google.android.gms.internal.measurement;

public final class Kd implements Ld {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f4979a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f4980b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Boolean> f4981c;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f4979a = aa.a("measurement.log_installs_enabled", false);
        f4980b = aa.a("measurement.log_third_party_store_events_enabled", false);
        f4981c = aa.a("measurement.log_upgrades_enabled", false);
    }

    public final boolean a() {
        return ((Boolean) f4980b.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f4981c.a()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f4979a.a()).booleanValue();
    }
}
