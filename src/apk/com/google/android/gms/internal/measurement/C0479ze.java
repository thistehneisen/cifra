package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ze reason: case insensitive filesystem */
public final class C0479ze implements C0461we {

    /* renamed from: a reason: collision with root package name */
    private static final C0439ta<Boolean> f5465a;

    /* renamed from: b reason: collision with root package name */
    private static final C0439ta<Boolean> f5466b;

    static {
        Aa aa = new Aa(C0445ua.a("com.google.android.gms.measurement"));
        f5465a = aa.a("measurement.personalized_ads_signals_collection_enabled", true);
        f5466b = aa.a("measurement.personalized_ads_property_translation_enabled", true);
    }

    public final boolean a() {
        return ((Boolean) f5466b.a()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f5465a.a()).booleanValue();
    }
}
