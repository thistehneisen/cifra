package com.google.android.gms.internal.measurement;

public final class Td implements Ja<Sd> {

    /* renamed from: a reason: collision with root package name */
    private static Td f5050a = new Td();

    /* renamed from: b reason: collision with root package name */
    private final Ja<Sd> f5051b;

    private Td(Ja<Sd> ja) {
        this.f5051b = Ia.a(ja);
    }

    public static boolean a() {
        return ((Sd) f5050a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (Sd) this.f5051b.get();
    }

    public Td() {
        this(Ia.a(new Vd()));
    }
}
