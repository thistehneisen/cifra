package com.google.android.gms.internal.measurement;

public final class Bd implements Ja<Ad> {

    /* renamed from: a reason: collision with root package name */
    private static Bd f4866a = new Bd();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Ad> f4867b;

    private Bd(Ja<Ad> ja) {
        this.f4867b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Ad) f4866a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Ad) this.f4867b.get();
    }

    public Bd() {
        this(Ia.a(new Dd()));
    }
}
