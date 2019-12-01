package com.google.android.gms.internal.measurement;

public final class Qe implements Ja<Pe> {

    /* renamed from: a reason: collision with root package name */
    private static Qe f5033a = new Qe();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Pe> f5034b;

    private Qe(Ja<Pe> ja) {
        this.f5034b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Pe) f5033a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Pe) this.f5034b.get();
    }

    public Qe() {
        this(Ia.a(new Se()));
    }
}
