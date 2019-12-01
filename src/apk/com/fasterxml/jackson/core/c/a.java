package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.b.f;
import com.fasterxml.jackson.core.b.k;
import com.fasterxml.jackson.core.d.b;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.h;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* compiled from: ByteSourceJsonBootstrapper */
public final class a {

    /* renamed from: a reason: collision with root package name */
    protected final c f4261a;

    /* renamed from: b reason: collision with root package name */
    protected final InputStream f4262b;

    /* renamed from: c reason: collision with root package name */
    protected final byte[] f4263c;

    /* renamed from: d reason: collision with root package name */
    private int f4264d;

    /* renamed from: e reason: collision with root package name */
    private int f4265e;

    /* renamed from: f reason: collision with root package name */
    private final boolean f4266f;

    /* renamed from: g reason: collision with root package name */
    protected int f4267g;

    /* renamed from: h reason: collision with root package name */
    protected boolean f4268h = true;

    /* renamed from: i reason: collision with root package name */
    protected int f4269i = 0;

    public a(c cVar, InputStream inputStream) {
        this.f4261a = cVar;
        this.f4262b = inputStream;
        this.f4263c = cVar.b();
        this.f4264d = 0;
        this.f4265e = 0;
        this.f4267g = 0;
        this.f4266f = true;
    }

    private boolean c(int i2) throws IOException {
        if ((i2 >> 8) == 0) {
            this.f4268h = true;
        } else if ((16777215 & i2) == 0) {
            this.f4268h = false;
        } else if ((-16711681 & i2) == 0) {
            a("3412");
            throw null;
        } else if ((i2 & -65281) != 0) {
            return false;
        } else {
            a("2143");
            throw null;
        }
        this.f4269i = 4;
        return true;
    }

    private boolean d(int i2) throws IOException {
        if (i2 == -16842752) {
            a("3412");
            throw null;
        } else if (i2 == -131072) {
            this.f4264d += 4;
            this.f4269i = 4;
            this.f4268h = false;
            return true;
        } else if (i2 == 65279) {
            this.f4268h = true;
            this.f4264d += 4;
            this.f4269i = 4;
            return true;
        } else if (i2 != 65534) {
            int i3 = i2 >>> 16;
            if (i3 == 65279) {
                this.f4264d += 2;
                this.f4269i = 2;
                this.f4268h = true;
                return true;
            } else if (i3 == 65534) {
                this.f4264d += 2;
                this.f4269i = 2;
                this.f4268h = false;
                return true;
            } else if ((i2 >>> 8) != 15711167) {
                return false;
            } else {
                this.f4264d += 3;
                this.f4269i = 1;
                this.f4268h = true;
                return true;
            }
        } else {
            a("2143");
            throw null;
        }
    }

    public Reader a() throws IOException {
        com.fasterxml.jackson.core.a f2 = this.f4261a.f();
        int a2 = f2.a();
        if (a2 == 8 || a2 == 16) {
            InputStream inputStream = this.f4262b;
            if (inputStream == 0) {
                inputStream = new ByteArrayInputStream(this.f4263c, this.f4264d, this.f4265e);
            } else {
                int i2 = this.f4264d;
                int i3 = this.f4265e;
                if (i2 < i3) {
                    f fVar = new f(this.f4261a, inputStream, this.f4263c, i2, i3);
                    inputStream = fVar;
                }
            }
            return new InputStreamReader(inputStream, f2.b());
        } else if (a2 == 32) {
            c cVar = this.f4261a;
            k kVar = new k(cVar, this.f4262b, this.f4263c, this.f4264d, this.f4265e, cVar.f().c());
            return kVar;
        } else {
            throw new RuntimeException("Internal error");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (b((r1[r5 + 1] & 255) | ((r1[r5] & 255) << 8)) != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (b(r1 >>> 16) != false) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    public com.fasterxml.jackson.core.a b() throws IOException {
        com.fasterxml.jackson.core.a aVar;
        boolean z = false;
        if (a(4)) {
            byte[] bArr = this.f4263c;
            int i2 = this.f4264d;
            byte b2 = (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
            if (!d(b2)) {
                if (!c(b2)) {
                }
            }
        } else {
            if (a(2)) {
                byte[] bArr2 = this.f4263c;
                int i3 = this.f4264d;
            }
            if (z) {
                aVar = com.fasterxml.jackson.core.a.UTF8;
            } else {
                int i4 = this.f4269i;
                if (i4 == 1) {
                    aVar = com.fasterxml.jackson.core.a.UTF8;
                } else if (i4 == 2) {
                    aVar = this.f4268h ? com.fasterxml.jackson.core.a.UTF16_BE : com.fasterxml.jackson.core.a.UTF16_LE;
                } else if (i4 == 4) {
                    aVar = this.f4268h ? com.fasterxml.jackson.core.a.UTF32_BE : com.fasterxml.jackson.core.a.UTF32_LE;
                } else {
                    throw new RuntimeException("Internal error");
                }
            }
            this.f4261a.a(aVar);
            return aVar;
        }
        z = true;
        if (z) {
        }
        this.f4261a.a(aVar);
        return aVar;
    }

    public a(c cVar, byte[] bArr, int i2, int i3) {
        this.f4261a = cVar;
        this.f4262b = null;
        this.f4263c = bArr;
        this.f4264d = i2;
        this.f4265e = i3 + i2;
        this.f4267g = -i2;
        this.f4266f = false;
    }

    public e a(int i2, h hVar, com.fasterxml.jackson.core.d.a aVar, b bVar, int i3) throws IOException {
        int i4 = i3;
        if (b() != com.fasterxml.jackson.core.a.UTF8 || !com.fasterxml.jackson.core.b.a.CANONICALIZE_FIELD_NAMES.b(i4)) {
            f fVar = new f(this.f4261a, i2, a(), hVar, bVar.c(i3));
            return fVar;
        }
        int i5 = i2;
        h hVar2 = hVar;
        h hVar3 = new h(this.f4261a, i5, this.f4262b, hVar2, aVar.d(i4), this.f4263c, this.f4264d, this.f4265e, this.f4266f);
        return hVar3;
    }

    private void a(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported UCS-4 endianness (");
        sb.append(str);
        sb.append(") detected");
        throw new CharConversionException(sb.toString());
    }

    private boolean b(int i2) {
        if ((65280 & i2) == 0) {
            this.f4268h = true;
        } else if ((i2 & 255) != 0) {
            return false;
        } else {
            this.f4268h = false;
        }
        this.f4269i = 2;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) throws IOException {
        int i3;
        int i4 = this.f4265e - this.f4264d;
        while (i4 < i2) {
            InputStream inputStream = this.f4262b;
            if (inputStream == null) {
                i3 = -1;
            } else {
                byte[] bArr = this.f4263c;
                int i5 = this.f4265e;
                i3 = inputStream.read(bArr, i5, bArr.length - i5);
            }
            if (i3 < 1) {
                return false;
            }
            this.f4265e += i3;
            i4 += i3;
        }
        return true;
    }
}
