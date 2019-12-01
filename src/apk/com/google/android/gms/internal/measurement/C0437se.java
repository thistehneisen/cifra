package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.se reason: case insensitive filesystem */
public final class C0437se implements Ja<C0455ve> {

    /* renamed from: a reason: collision with root package name */
    private static C0437se f5366a = new C0437se();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0455ve> f5367b;

    private C0437se(Ja<C0455ve> ja) {
        this.f5367b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0455ve) f5366a.get()).c();
    }

    public static boolean b() {
        return ((C0455ve) f5366a.get()).b();
    }

    public static boolean c() {
        return ((C0455ve) f5366a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0455ve) this.f5367b.get();
    }

    public C0437se() {
        this(Ia.a(new C0449ue()));
    }
}
