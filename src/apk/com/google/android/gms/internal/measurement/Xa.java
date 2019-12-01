package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class Xa implements Serializable, Iterable<Byte> {

    /* renamed from: a reason: collision with root package name */
    public static final Xa f5082a = new C0363gb(Fb.f4932c);

    /* renamed from: b reason: collision with root package name */
    private static final C0338cb f5083b = (Qa.a() ? new C0357fb(null) : new C0324ab(null));

    /* renamed from: c reason: collision with root package name */
    private static final Comparator<Xa> f5084c = new Za();
    private int zzadj = 0;

    Xa() {
    }

    public static Xa a(byte[] bArr, int i2, int i3) {
        b(i2, i2 + i3, bArr.length);
        return new C0363gb(f5083b.a(bArr, i2, i3));
    }

    /* access modifiers changed from: private */
    public static int b(byte b2) {
        return b2 & 255;
    }

    static int b(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i2);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i3);
            sb3.append(" >= ");
            sb3.append(i4);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    static C0351eb g(int i2) {
        return new C0351eb(i2, null);
    }

    public abstract byte a(int i2);

    /* access modifiers changed from: protected */
    public abstract int a(int i2, int i3, int i4);

    public abstract Xa a(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String a(Charset charset);

    /* access modifiers changed from: 0000 */
    public abstract void a(Ua ua) throws IOException;

    public final String e() {
        return size() == 0 ? "" : a(Fb.f4930a);
    }

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract byte f(int i2);

    public abstract boolean f();

    public final int hashCode() {
        int i2 = this.zzadj;
        if (i2 == 0) {
            int size = size();
            i2 = a(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzadj = i2;
        }
        return i2;
    }

    public /* synthetic */ Iterator iterator() {
        return new Wa(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public final int g() {
        return this.zzadj;
    }

    static Xa a(byte[] bArr) {
        return new C0363gb(bArr);
    }

    public static Xa a(String str) {
        return new C0363gb(str.getBytes(Fb.f4930a));
    }
}
