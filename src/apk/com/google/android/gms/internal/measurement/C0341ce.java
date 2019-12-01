package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ce reason: case insensitive filesystem */
public final class C0341ce implements C0348de {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5143a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5144b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Boolean> f5145c;

    /* renamed from: d reason: collision with root package name */
    private static final C0439ta<Boolean> f5146d;

    /* renamed from: e reason: collision with root package name */
    private static final C0439ta<Long> f5147e;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5143a = aa.a("measurement.sdk.dynamite.allow_remote_dynamite", false);
        f5144b = aa.a("measurement.collection.init_params_control_enabled", true);
        f5145c = aa.a("measurement.sdk.dynamite.use_dynamite", false);
        f5146d = aa.a("measurement.sdk.dynamite.use_dynamite2", false);
        f5147e = aa.a("measurement.id.sdk.dynamite.use_dynamite", 0);
    }

    public final boolean a() {
        return ((Boolean) f5143a.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5145c.a()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f5144b.a()).booleanValue();
    }
}
