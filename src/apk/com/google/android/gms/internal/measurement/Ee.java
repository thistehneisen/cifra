package com.google.android.gms.internal.measurement;

public final class Ee implements Ja<De> {

    /* renamed from: a reason: collision with root package name */
    private static Ee f4928a = new Ee();

    /* renamed from: b reason: collision with root package name */
    private final Ja<De> f4929b;

    private Ee(Ja<De> ja) {
        this.f4929b = Ia.a(ja);
    }

    public static boolean a() {
        return ((De) f4928a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (De) this.f4929b.get();
    }

    public Ee() {
        this(Ia.a(new Ge()));
    }
}
