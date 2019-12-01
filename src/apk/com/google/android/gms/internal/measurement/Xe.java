package com.google.android.gms.internal.measurement;

public final class Xe implements Ja<_e> {

    /* renamed from: a reason: collision with root package name */
    private static Xe f5088a = new Xe();

    /* renamed from: b reason: collision with root package name */
    private final Ja<_e> f5089b;

    private Xe(Ja<_e> ja) {
        this.f5089b = Ia.a(ja);
    }

    public static boolean a() {
        return ((_e) f5088a.get()).a();
    }

    public static boolean b() {
        return ((_e) f5088a.get()).b();
    }

    public final /* synthetic */ Object get() {
        return (_e) this.f5089b.get();
    }

    public Xe() {
        this(Ia.a(new Ze()));
    }
}
