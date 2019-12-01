package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ye reason: case insensitive filesystem */
public final class C0473ye implements Ja<Ce> {

    /* renamed from: a reason: collision with root package name */
    private static C0473ye f5439a = new C0473ye();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Ce> f5440b;

    private C0473ye(Ja<Ce> ja) {
        this.f5440b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Ce) f5439a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Ce) this.f5440b.get();
    }

    public C0473ye() {
        this(Ia.a(new Ae()));
    }
}
