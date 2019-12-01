package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.me reason: case insensitive filesystem */
public final class C0402me implements Ja<C0420pe> {

    /* renamed from: a reason: collision with root package name */
    private static C0402me f5287a = new C0402me();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0420pe> f5288b;

    private C0402me(Ja<C0420pe> ja) {
        this.f5288b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0420pe) f5287a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0420pe) this.f5288b.get();
    }

    public C0402me() {
        this(Ia.a(new C0414oe()));
    }
}
