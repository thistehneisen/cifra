package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.eb reason: case insensitive filesystem */
final class C0351eb {

    /* renamed from: a reason: collision with root package name */
    private final zzee f5171a;

    /* renamed from: b reason: collision with root package name */
    private final byte[] f5172b;

    private C0351eb(int i2) {
        this.f5172b = new byte[i2];
        this.f5171a = zzee.a(this.f5172b);
    }

    public final Xa a() {
        this.f5171a.c();
        return new C0363gb(this.f5172b);
    }

    public final zzee b() {
        return this.f5171a;
    }

    /* synthetic */ C0351eb(int i2, Wa wa) {
        this(i2);
    }
}
