package com.bumptech.glide.b;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser */
public class d {

    /* renamed from: a reason: collision with root package name */
    private final byte[] f3336a = new byte[256];

    /* renamed from: b reason: collision with root package name */
    private ByteBuffer f3337b;

    /* renamed from: c reason: collision with root package name */
    private c f3338c;

    /* renamed from: d reason: collision with root package name */
    private int f3339d = 0;

    private boolean c() {
        return this.f3338c.f3325b != 0;
    }

    private int d() {
        try {
            return this.f3337b.get() & 255;
        } catch (Exception unused) {
            this.f3338c.f3325b = 1;
            return 0;
        }
    }

    private void e() {
        this.f3338c.f3327d.f3313a = l();
        this.f3338c.f3327d.f3314b = l();
        this.f3338c.f3327d.f3315c = l();
        this.f3338c.f3327d.f3316d = l();
        int d2 = d();
        boolean z = false;
        boolean z2 = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        b bVar = this.f3338c.f3327d;
        if ((d2 & 64) != 0) {
            z = true;
        }
        bVar.f3317e = z;
        if (z2) {
            this.f3338c.f3327d.f3323k = a(pow);
        } else {
            this.f3338c.f3327d.f3323k = null;
        }
        this.f3338c.f3327d.f3322j = this.f3337b.position();
        o();
        if (!c()) {
            c cVar = this.f3338c;
            cVar.f3326c++;
            cVar.f3328e.add(cVar.f3327d);
        }
    }

    private void f() {
        this.f3339d = d();
        if (this.f3339d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f3339d) {
                try {
                    i3 = this.f3339d - i2;
                    this.f3337b.get(this.f3336a, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    String str = "GifHeaderParser";
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error Reading Block n: ");
                        sb.append(i2);
                        sb.append(" count: ");
                        sb.append(i3);
                        sb.append(" blockSize: ");
                        sb.append(this.f3339d);
                        Log.d(str, sb.toString(), e2);
                    }
                    this.f3338c.f3325b = 1;
                    return;
                }
            }
        }
    }

    private void g() {
        b(Integer.MAX_VALUE);
    }

    private void h() {
        d();
        int d2 = d();
        b bVar = this.f3338c.f3327d;
        bVar.f3319g = (d2 & 28) >> 2;
        boolean z = true;
        if (bVar.f3319g == 0) {
            bVar.f3319g = 1;
        }
        b bVar2 = this.f3338c.f3327d;
        if ((d2 & 1) == 0) {
            z = false;
        }
        bVar2.f3318f = z;
        int l2 = l();
        if (l2 < 2) {
            l2 = 10;
        }
        b bVar3 = this.f3338c.f3327d;
        bVar3.f3321i = l2 * 10;
        bVar3.f3320h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f3338c.f3325b = 1;
            return;
        }
        j();
        if (this.f3338c.f3331h && !c()) {
            c cVar = this.f3338c;
            cVar.f3324a = a(cVar.f3332i);
            c cVar2 = this.f3338c;
            cVar2.f3335l = cVar2.f3324a[cVar2.f3333j];
        }
    }

    private void j() {
        this.f3338c.f3329f = l();
        this.f3338c.f3330g = l();
        int d2 = d();
        this.f3338c.f3331h = (d2 & 128) != 0;
        this.f3338c.f3332i = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        this.f3338c.f3333j = d();
        this.f3338c.f3334k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.f3336a;
            if (bArr[0] == 1) {
                this.f3338c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f3339d <= 0) {
                return;
            }
        } while (!c());
    }

    private int l() {
        return this.f3337b.getShort();
    }

    private void m() {
        this.f3337b = null;
        Arrays.fill(this.f3336a, 0);
        this.f3338c = new c();
        this.f3339d = 0;
    }

    private void n() {
        int d2;
        do {
            d2 = d();
            this.f3337b.position(Math.min(this.f3337b.position() + d2, this.f3337b.limit()));
        } while (d2 > 0);
    }

    private void o() {
        d();
        n();
    }

    public d a(ByteBuffer byteBuffer) {
        m();
        this.f3337b = byteBuffer.asReadOnlyBuffer();
        this.f3337b.position(0);
        this.f3337b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public c b() {
        if (this.f3337b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (c()) {
            return this.f3338c;
        } else {
            i();
            if (!c()) {
                g();
                c cVar = this.f3338c;
                if (cVar.f3326c < 0) {
                    cVar.f3325b = 1;
                }
            }
            return this.f3338c;
        }
    }

    public void a() {
        this.f3337b = null;
        this.f3338c = null;
    }

    private int[] a(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f3337b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            String str = "GifHeaderParser";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Format Error Reading Color Table", e2);
            }
            this.f3338c.f3325b = 1;
        }
        return iArr;
    }

    private void b(int i2) {
        boolean z = false;
        while (!z && !c() && this.f3338c.f3326c <= i2) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    n();
                } else if (d3 == 249) {
                    this.f3338c.f3327d = new b();
                    h();
                } else if (d3 == 254) {
                    n();
                } else if (d3 != 255) {
                    n();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f3336a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f3338c;
                if (cVar.f3327d == null) {
                    cVar.f3327d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f3338c.f3325b = 1;
            } else {
                z = true;
            }
        }
    }
}
