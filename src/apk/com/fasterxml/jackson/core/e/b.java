package com.fasterxml.jackson.core.e;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ByteArrayBuilder */
public final class b extends OutputStream {

    /* renamed from: a reason: collision with root package name */
    public static final byte[] f4364a = new byte[0];

    /* renamed from: b reason: collision with root package name */
    private final a f4365b;

    /* renamed from: c reason: collision with root package name */
    private final LinkedList<byte[]> f4366c;

    /* renamed from: d reason: collision with root package name */
    private int f4367d;

    /* renamed from: e reason: collision with root package name */
    private byte[] f4368e;

    /* renamed from: f reason: collision with root package name */
    private int f4369f;

    public b(a aVar) {
        this(aVar, 500);
    }

    private void e() {
        this.f4367d += this.f4368e.length;
        int max = Math.max(this.f4367d >> 1, 1000);
        if (max > 262144) {
            max = 262144;
        }
        this.f4366c.add(this.f4368e);
        this.f4368e = new byte[max];
        this.f4369f = 0;
    }

    public void a(int i2) {
        if (this.f4369f >= this.f4368e.length) {
            e();
        }
        byte[] bArr = this.f4368e;
        int i3 = this.f4369f;
        this.f4369f = i3 + 1;
        bArr[i3] = (byte) i2;
    }

    public void b() {
        this.f4367d = 0;
        this.f4369f = 0;
        if (!this.f4366c.isEmpty()) {
            this.f4366c.clear();
        }
    }

    public byte[] c() {
        b();
        return this.f4368e;
    }

    public void close() {
    }

    public byte[] d() {
        int i2 = this.f4367d + this.f4369f;
        if (i2 == 0) {
            return f4364a;
        }
        byte[] bArr = new byte[i2];
        Iterator it = this.f4366c.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i3, length);
            i3 += length;
        }
        System.arraycopy(this.f4368e, 0, bArr, i3, this.f4369f);
        int i4 = i3 + this.f4369f;
        if (i4 == i2) {
            if (!this.f4366c.isEmpty()) {
                b();
            }
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Internal error: total len assumed to be ");
        sb.append(i2);
        sb.append(", copied ");
        sb.append(i4);
        sb.append(" bytes");
        throw new RuntimeException(sb.toString());
    }

    public void flush() {
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public b(a aVar, int i2) {
        this.f4366c = new LinkedList<>();
        this.f4365b = aVar;
        this.f4368e = aVar == null ? new byte[i2] : aVar.a(2);
    }

    public void write(byte[] bArr, int i2, int i3) {
        while (true) {
            int min = Math.min(this.f4368e.length - this.f4369f, i3);
            if (min > 0) {
                System.arraycopy(bArr, i2, this.f4368e, this.f4369f, min);
                i2 += min;
                this.f4369f += min;
                i3 -= min;
            }
            if (i3 > 0) {
                e();
            } else {
                return;
            }
        }
    }

    public byte[] a() {
        e();
        return this.f4368e;
    }

    public byte[] b(int i2) {
        this.f4369f = i2;
        return d();
    }

    public void write(int i2) {
        a(i2);
    }
}
