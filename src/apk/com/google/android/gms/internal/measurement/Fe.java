package com.google.android.gms.internal.measurement;

public final class Fe implements Ja<Ie> {

    /* renamed from: a reason: collision with root package name */
    private static Fe f4935a = new Fe();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Ie> f4936b;

    private Fe(Ja<Ie> ja) {
        this.f4936b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Ie) f4935a.get()).b();
    }

    public static double b() {
        return ((Ie) f4935a.get()).a();
    }

    public static long c() {
        return ((Ie) f4935a.get()).e();
    }

    public static long d() {
        return ((Ie) f4935a.get()).d();
    }

    public static String e() {
        return ((Ie) f4935a.get()).c();
    }

    public final /* synthetic */ Object get() {
        return (Ie) this.f4936b.get();
    }

    public Fe() {
        this(Ia.a(new He()));
    }
}
