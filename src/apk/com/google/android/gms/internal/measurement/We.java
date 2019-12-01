package com.google.android.gms.internal.measurement;

public final class We implements Ja<Ve> {

    /* renamed from: a reason: collision with root package name */
    private static We f5080a = new We();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Ve> f5081b;

    private We(Ja<Ve> ja) {
        this.f5081b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Ve) f5080a.get()).b();
    }

    public static boolean b() {
        return ((Ve) f5080a.get()).c();
    }

    public static boolean c() {
        return ((Ve) f5080a.get()).d();
    }

    public static boolean d() {
        return ((Ve) f5080a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Ve) this.f5081b.get();
    }

    public We() {
        this(Ia.a(new Ye()));
    }
}
