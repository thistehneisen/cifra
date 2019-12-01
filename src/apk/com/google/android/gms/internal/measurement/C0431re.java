package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.re reason: case insensitive filesystem */
public final class C0431re implements Ja<C0426qe> {

    /* renamed from: a reason: collision with root package name */
    private static C0431re f5361a = new C0431re();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0426qe> f5362b;

    private C0431re(Ja<C0426qe> ja) {
        this.f5362b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0426qe) f5361a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0426qe) this.f5362b.get();
    }

    public C0431re() {
        this(Ia.a(new C0443te()));
    }
}
