package com.google.android.gms.internal.measurement;

public final class Ud implements Ja<Xd> {

    /* renamed from: a reason: collision with root package name */
    private static Ud f5053a = new Ud();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Xd> f5054b;

    private Ud(Ja<Xd> ja) {
        this.f5054b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Xd) f5053a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Xd) this.f5054b.get();
    }

    public Ud() {
        this(Ia.a(new Wd()));
    }
}
