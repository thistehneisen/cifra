package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.xe reason: case insensitive filesystem */
public final class C0467xe implements Ja<C0461we> {

    /* renamed from: a reason: collision with root package name */
    private static C0467xe f5420a = new C0467xe();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0461we> f5421b;

    private C0467xe(Ja<C0461we> ja) {
        this.f5421b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0461we) f5420a.get()).b();
    }

    public static boolean b() {
        return ((C0461we) f5420a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0461we) this.f5421b.get();
    }

    public C0467xe() {
        this(Ia.a(new C0479ze()));
    }
}
