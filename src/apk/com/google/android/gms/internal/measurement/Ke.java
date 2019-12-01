package com.google.android.gms.internal.measurement;

public final class Ke implements Ja<Je> {

    /* renamed from: a reason: collision with root package name */
    private static Ke f4982a = new Ke();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Je> f4983b;

    private Ke(Ja<Je> ja) {
        this.f4983b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Je) f4982a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Je) this.f4983b.get();
    }

    public Ke() {
        this(Ia.a(new Me()));
    }
}
