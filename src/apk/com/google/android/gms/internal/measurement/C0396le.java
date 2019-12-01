package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.le reason: case insensitive filesystem */
public final class C0396le implements Ja<C0390ke> {

    /* renamed from: a reason: collision with root package name */
    private static C0396le f5269a = new C0396le();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0390ke> f5270b;

    private C0396le(Ja<C0390ke> ja) {
        this.f5270b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0390ke) f5269a.get()).b();
    }

    public static boolean b() {
        return ((C0390ke) f5269a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0390ke) this.f5270b.get();
    }

    public C0396le() {
        this(Ia.a(new C0408ne()));
    }
}
