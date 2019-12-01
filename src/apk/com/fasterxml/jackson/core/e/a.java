package com.fasterxml.jackson.core.e;

import io.fabric.sdk.android.a.c.c;

/* compiled from: BufferRecycler */
public class a {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f4360a = {c.MAX_BYTE_SIZE_PER_FILE, c.MAX_BYTE_SIZE_PER_FILE, 2000, 2000};

    /* renamed from: b reason: collision with root package name */
    private static final int[] f4361b = {4000, 4000, 200, 200};

    /* renamed from: c reason: collision with root package name */
    protected final byte[][] f4362c;

    /* renamed from: d reason: collision with root package name */
    protected final char[][] f4363d;

    public a() {
        this(4, 4);
    }

    public final byte[] a(int i2) {
        return a(i2, 0);
    }

    public final char[] b(int i2) {
        return b(i2, 0);
    }

    /* access modifiers changed from: protected */
    public byte[] c(int i2) {
        return new byte[i2];
    }

    /* access modifiers changed from: protected */
    public int d(int i2) {
        return f4360a[i2];
    }

    /* access modifiers changed from: protected */
    public char[] e(int i2) {
        return new char[i2];
    }

    /* access modifiers changed from: protected */
    public int f(int i2) {
        return f4361b[i2];
    }

    protected a(int i2, int i3) {
        this.f4362c = new byte[i2][];
        this.f4363d = new char[i3][];
    }

    public byte[] a(int i2, int i3) {
        int d2 = d(i2);
        if (i3 < d2) {
            i3 = d2;
        }
        byte[][] bArr = this.f4362c;
        byte[] bArr2 = bArr[i2];
        if (bArr2 == null || bArr2.length < i3) {
            return c(i3);
        }
        bArr[i2] = null;
        return bArr2;
    }

    public char[] b(int i2, int i3) {
        int f2 = f(i2);
        if (i3 < f2) {
            i3 = f2;
        }
        char[][] cArr = this.f4363d;
        char[] cArr2 = cArr[i2];
        if (cArr2 == null || cArr2.length < i3) {
            return e(i3);
        }
        cArr[i2] = null;
        return cArr2;
    }

    public final void a(int i2, byte[] bArr) {
        this.f4362c[i2] = bArr;
    }

    public void a(int i2, char[] cArr) {
        this.f4363d[i2] = cArr;
    }
}
