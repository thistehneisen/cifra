package com.google.android.gms.internal.measurement;

public final class Nd implements Ja<Md> {

    /* renamed from: a reason: collision with root package name */
    private static Nd f4995a = new Nd();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Md> f4996b;

    private Nd(Ja<Md> ja) {
        this.f4996b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Md) f4995a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Md) this.f4996b.get();
    }

    public Nd() {
        this(Ia.a(new Pd()));
    }
}
