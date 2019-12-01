package io.intercom.com.bumptech.glide.b;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser */
public class d {

    /* renamed from: a reason: collision with root package name */
    private final byte[] f9193a = new byte[256];

    /* renamed from: b reason: collision with root package name */
    private ByteBuffer f9194b;

    /* renamed from: c reason: collision with root package name */
    private c f9195c;

    /* renamed from: d reason: collision with root package name */
    private int f9196d = 0;

    private boolean c() {
        return this.f9195c.f9182b != 0;
    }

    private int d() {
        try {
            return this.f9194b.get() & 255;
        } catch (Exception unused) {
            this.f9195c.f9182b = 1;
            return 0;
        }
    }

    private void e() {
        this.f9195c.f9184d.f9170a = l();
        this.f9195c.f9184d.f9171b = l();
        this.f9195c.f9184d.f9172c = l();
        this.f9195c.f9184d.f9173d = l();
        int d2 = d();
        boolean z = false;
        boolean z2 = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        b bVar = this.f9195c.f9184d;
        if ((d2 & 64) != 0) {
            z = true;
        }
        bVar.f9174e = z;
        if (z2) {
            this.f9195c.f9184d.f9180k = a(pow);
        } else {
            this.f9195c.f9184d.f9180k = null;
        }
        this.f9195c.f9184d.f9179j = this.f9194b.position();
        o();
        if (!c()) {
            c cVar = this.f9195c;
            cVar.f9183c++;
            cVar.f9185e.add(cVar.f9184d);
        }
    }

    private void f() {
        this.f9196d = d();
        if (this.f9196d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f9196d) {
                try {
                    i3 = this.f9196d - i2;
                    this.f9194b.get(this.f9193a, i2, i3);
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
                        sb.append(this.f9196d);
                        Log.d(str, sb.toString(), e2);
                    }
                    this.f9195c.f9182b = 1;
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
        b bVar = this.f9195c.f9184d;
        bVar.f9176g = (d2 & 28) >> 2;
        boolean z = true;
        if (bVar.f9176g == 0) {
            bVar.f9176g = 1;
        }
        b bVar2 = this.f9195c.f9184d;
        if ((d2 & 1) == 0) {
            z = false;
        }
        bVar2.f9175f = z;
        int l2 = l();
        if (l2 < 2) {
            l2 = 10;
        }
        b bVar3 = this.f9195c.f9184d;
        bVar3.f9178i = l2 * 10;
        bVar3.f9177h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f9195c.f9182b = 1;
            return;
        }
        j();
        if (this.f9195c.f9188h && !c()) {
            c cVar = this.f9195c;
            cVar.f9181a = a(cVar.f9189i);
            c cVar2 = this.f9195c;
            cVar2.f9192l = cVar2.f9181a[cVar2.f9190j];
        }
    }

    private void j() {
        this.f9195c.f9186f = l();
        this.f9195c.f9187g = l();
        int d2 = d();
        this.f9195c.f9188h = (d2 & 128) != 0;
        this.f9195c.f9189i = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        this.f9195c.f9190j = d();
        this.f9195c.f9191k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.f9193a;
            if (bArr[0] == 1) {
                this.f9195c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f9196d <= 0) {
                return;
            }
        } while (!c());
    }

    private int l() {
        return this.f9194b.getShort();
    }

    private void m() {
        this.f9194b = null;
        Arrays.fill(this.f9193a, 0);
        this.f9195c = new c();
        this.f9196d = 0;
    }

    private void n() {
        int d2;
        do {
            d2 = d();
            this.f9194b.position(Math.min(this.f9194b.position() + d2, this.f9194b.limit()));
        } while (d2 > 0);
    }

    private void o() {
        d();
        n();
    }

    public d a(ByteBuffer byteBuffer) {
        m();
        this.f9194b = byteBuffer.asReadOnlyBuffer();
        this.f9194b.position(0);
        this.f9194b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public c b() {
        if (this.f9194b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (c()) {
            return this.f9195c;
        } else {
            i();
            if (!c()) {
                g();
                c cVar = this.f9195c;
                if (cVar.f9183c < 0) {
                    cVar.f9182b = 1;
                }
            }
            return this.f9195c;
        }
    }

    public void a() {
        this.f9194b = null;
        this.f9195c = null;
    }

    private int[] a(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f9194b.get(bArr);
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
            this.f9195c.f9182b = 1;
        }
        return iArr;
    }

    private void b(int i2) {
        boolean z = false;
        while (!z && !c() && this.f9195c.f9183c <= i2) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    n();
                } else if (d3 == 249) {
                    this.f9195c.f9184d = new b();
                    h();
                } else if (d3 == 254) {
                    n();
                } else if (d3 != 255) {
                    n();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f9193a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f9195c;
                if (cVar.f9184d == null) {
                    cVar.f9184d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f9195c.f9182b = 1;
            } else {
                z = true;
            }
        }
    }
}
