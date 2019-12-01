package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.fe reason: case insensitive filesystem */
public final class C0360fe implements Ja<C0354ee> {

    /* renamed from: a reason: collision with root package name */
    private static C0360fe f5179a = new C0360fe();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0354ee> f5180b;

    private C0360fe(Ja<C0354ee> ja) {
        this.f5180b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0354ee) f5179a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0354ee) this.f5180b.get();
    }

    public C0360fe() {
        this(Ia.a(new C0372he()));
    }
}
