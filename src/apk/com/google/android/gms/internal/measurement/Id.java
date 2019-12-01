package com.google.android.gms.internal.measurement;

public final class Id implements Ja<Ld> {

    /* renamed from: a reason: collision with root package name */
    private static Id f4970a = new Id();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Ld> f4971b;

    private Id(Ja<Ld> ja) {
        this.f4971b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Ld) f4970a.get()).c();
    }

    public static boolean b() {
        return ((Ld) f4970a.get()).a();
    }

    public static boolean c() {
        return ((Ld) f4970a.get()).b();
    }

    public final /* synthetic */ Object get() {
        return (Ld) this.f4971b.get();
    }

    public Id() {
        this(Ia.a(new Kd()));
    }
}
