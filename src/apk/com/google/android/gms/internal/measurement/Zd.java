package com.google.android.gms.internal.measurement;

public final class Zd implements Ja<Yd> {

    /* renamed from: a reason: collision with root package name */
    private static Zd f5110a = new Zd();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Yd> f5111b;

    private Zd(Ja<Yd> ja) {
        this.f5111b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Yd) f5110a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Yd) this.f5111b.get();
    }

    public Zd() {
        this(Ia.a(new C0334be()));
    }
}
