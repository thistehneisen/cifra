package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.jb reason: case insensitive filesystem */
public abstract class C0381jb {

    /* renamed from: a reason: collision with root package name */
    int f5229a;

    /* renamed from: b reason: collision with root package name */
    int f5230b;

    /* renamed from: c reason: collision with root package name */
    private int f5231c;

    /* renamed from: d reason: collision with root package name */
    C0387kb f5232d;

    /* renamed from: e reason: collision with root package name */
    private boolean f5233e;

    private C0381jb() {
        this.f5230b = 100;
        this.f5231c = Integer.MAX_VALUE;
        this.f5233e = false;
    }

    public static long a(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static C0381jb a(byte[] bArr, int i2, int i3) {
        return a(bArr, i2, i3, false);
    }

    public static int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract double a() throws IOException;

    public abstract <T extends C0400mc> T a(C0447uc<T> ucVar, C0428rb rbVar) throws IOException;

    public abstract void a(int i2) throws zzfi;

    public abstract float b() throws IOException;

    public abstract boolean b(int i2) throws IOException;

    public final int c(int i2) {
        if (i2 >= 0) {
            int i3 = this.f5230b;
            this.f5230b = i2;
            return i3;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract String c() throws IOException;

    public abstract int d() throws IOException;

    public abstract int d(int i2) throws zzfi;

    public abstract long e() throws IOException;

    public abstract void e(int i2);

    public abstract long f() throws IOException;

    public abstract void f(int i2) throws IOException;

    public abstract int g() throws IOException;

    public abstract long h() throws IOException;

    public abstract int i() throws IOException;

    public abstract boolean j() throws IOException;

    public abstract String k() throws IOException;

    public abstract Xa l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract boolean s() throws IOException;

    public abstract int t();

    static C0381jb a(byte[] bArr, int i2, int i3, boolean z) {
        C0393lb lbVar = new C0393lb(bArr, i2, i3, false);
        try {
            lbVar.d(i3);
            return lbVar;
        } catch (zzfi e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
