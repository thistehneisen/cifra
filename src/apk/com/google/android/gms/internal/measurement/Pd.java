package com.google.android.gms.internal.measurement;

public final class Pd implements Md {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5016a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Long> f5017b;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5016a = aa.a("measurement.app_launch.event_ordering_fix", false);
        f5017b = aa.a("measurement.id.app_launch.event_ordering_fix", 0);
    }

    public final boolean a() {
        return ((Boolean) f5016a.a()).booleanValue();
    }
}
