package com.google.android.gms.internal.measurement;

public final class Cd implements Ja<Fd> {

    /* renamed from: a reason: collision with root package name */
    private static Cd f4881a = new Cd();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Fd> f4882b;

    private Cd(Ja<Fd> ja) {
        this.f4882b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Fd) f4881a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Fd) this.f4882b.get();
    }

    public Cd() {
        this(Ia.a(new Ed()));
    }
}
