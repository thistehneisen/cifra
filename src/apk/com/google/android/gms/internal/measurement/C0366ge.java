package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ge reason: case insensitive filesystem */
public final class C0366ge implements Ja<C0384je> {

    /* renamed from: a reason: collision with root package name */
    private static C0366ge f5203a = new C0366ge();

    /* renamed from: b reason: collision with root package name */
    private final Ja<C0384je> f5204b;

    private C0366ge(Ja<C0384je> ja) {
        this.f5204b = Ia.a(ja);
    }

    public static boolean a() {
        return ((C0384je) f5203a.get()).a();
    }

    public final /* synthetic */ Object get() {
        return (C0384je) this.f5204b.get();
    }

    public C0366ge() {
        this(Ia.a(new C0378ie()));
    }
}
