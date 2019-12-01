package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.cf reason: case insensitive filesystem */
public final class C0342cf implements Ja<C0328af> {

    /* renamed from: a reason: collision with root package name */
    private static C0342cf f5148a = new C0342cf();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0328af> f5149b;

    private C0342cf(Ja<C0328af> ja) {
        this.f5149b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0328af) f5148a.get()).b();
    }

    public static boolean b() {
        return ((C0328af) f5148a.get()).c();
    }

    public static boolean c() {
        return ((C0328af) f5148a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0328af) this.f5149b.get();
    }

    public C0342cf() {
        this(Ia.a(new ef()));
    }
}
