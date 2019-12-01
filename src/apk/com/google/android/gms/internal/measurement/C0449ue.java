package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ue reason: case insensitive filesystem */
public final class C0449ue implements C0455ve {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5397a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5398b;

    /* renamed from: c reason: collision with root package name */
    private static final C0439ta<Boolean> f5399c;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5397a = aa.a("measurement.sdk.collection.last_deep_link_referrer", false);
        f5398b = aa.a("measurement.sdk.collection.last_deep_link_referrer_campaign", false);
        f5399c = aa.a("measurement.sdk.collection.last_gclid_from_referrer", false);
    }

    public final boolean a() {
        return ((Boolean) f5399c.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5398b.a()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f5397a.a()).booleanValue();
    }
}
