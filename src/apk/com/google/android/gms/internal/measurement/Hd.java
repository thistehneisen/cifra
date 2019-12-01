package com.google.android.gms.internal.measurement;

public final class Hd implements Ja<Gd> {

    /* renamed from: a reason: collision with root package name */
    private static Hd f4959a = new Hd();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Gd> f4960b;

    private Hd(Ja<Gd> ja) {
        this.f4960b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Gd) f4959a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Gd) this.f4960b.get();
    }

    public Hd() {
        this(Ia.a(new Jd()));
    }
}
