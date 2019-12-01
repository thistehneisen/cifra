package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.b.a.C0044a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder */
public class e implements a {

    /* renamed from: a reason: collision with root package name */
    private static final String f3340a = "e";

    /* renamed from: b reason: collision with root package name */
    private int[] f3341b;

    /* renamed from: c reason: collision with root package name */
    private final int[] f3342c;

    /* renamed from: d reason: collision with root package name */
    private final C0044a f3343d;

    /* renamed from: e reason: collision with root package name */
    private ByteBuffer f3344e;

    /* renamed from: f reason: collision with root package name */
    private byte[] f3345f;

    /* renamed from: g reason: collision with root package name */
    private short[] f3346g;

    /* renamed from: h reason: collision with root package name */
    private byte[] f3347h;

    /* renamed from: i reason: collision with root package name */
    private byte[] f3348i;

    /* renamed from: j reason: collision with root package name */
    private byte[] f3349j;

    /* renamed from: k reason: collision with root package name */
    private int[] f3350k;

    /* renamed from: l reason: collision with root package name */
    private int f3351l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Config u;

    public e(C0044a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(cVar, byteBuffer, i2);
    }

    private Bitmap g() {
        Boolean bool = this.t;
        Bitmap a2 = this.f3343d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }

    private int h() {
        int i2 = i();
        if (i2 <= 0) {
            return i2;
        }
        ByteBuffer byteBuffer = this.f3344e;
        byteBuffer.get(this.f3345f, 0, Math.min(i2, byteBuffer.remaining()));
        return i2;
    }

    private int i() {
        return this.f3344e.get() & 255;
    }

    public int a(int i2) {
        if (i2 >= 0) {
            c cVar = this.m;
            if (i2 < cVar.f3326c) {
                return ((b) cVar.f3328e.get(i2)).f3321i;
            }
        }
        return -1;
    }

    public void advance() {
        this.f3351l = (this.f3351l + 1) % this.m.f3326c;
    }

    public int b() {
        return this.m.f3326c;
    }

    public int c() {
        if (this.m.f3326c > 0) {
            int i2 = this.f3351l;
            if (i2 >= 0) {
                return a(i2);
            }
        }
        return 0;
    }

    public void clear() {
        this.m = null;
        byte[] bArr = this.f3349j;
        if (bArr != null) {
            this.f3343d.a(bArr);
        }
        int[] iArr = this.f3350k;
        if (iArr != null) {
            this.f3343d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f3343d.a(bitmap);
        }
        this.n = null;
        this.f3344e = null;
        this.t = null;
        byte[] bArr2 = this.f3345f;
        if (bArr2 != null) {
            this.f3343d.a(bArr2);
        }
    }

    public void d() {
        this.f3351l = -1;
    }

    public int e() {
        return this.f3351l;
    }

    public int f() {
        return this.f3344e.limit() + this.f3349j.length + (this.f3350k.length * 4);
    }

    public ByteBuffer getData() {
        return this.f3344e;
    }

    private void b(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f3350k;
        int i2 = bVar2.f3316d;
        int i3 = bVar2.f3314b;
        int i4 = bVar2.f3315c;
        int i5 = bVar2.f3313a;
        boolean z = this.f3351l == 0;
        int i6 = this.s;
        byte[] bArr = this.f3349j;
        int[] iArr2 = this.f3341b;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f3315c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i14 = iArr2[b4];
                    if (i14 != 0) {
                        iArr[i13] = i14;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                b bVar3 = bVar;
            }
            i7++;
            bVar2 = bVar;
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    public e(C0044a aVar) {
        this.f3342c = new int[256];
        this.u = Config.ARGB_8888;
        this.f3343d = aVar;
        this.m = new c();
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [short[]] */
    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r28v0 */
    /* JADX WARNING: type inference failed for: r28v1 */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r28v2 */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r4v16, types: [short] */
    /* JADX WARNING: type inference failed for: r4v18, types: [int] */
    /* JADX WARNING: type inference failed for: r28v5 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r28v6 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r28v7 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r28v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r4v16, types: [short] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short[], code=null, for r3v1, types: [short[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r22v3
      assigns: []
      uses: []
      mth insns count: 171
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    private void c(b bVar) {
        int i2;
        int i3;
        ? r22;
        int i4;
        ? r222;
        ? r28;
        int i5;
        ? r4;
        int i6;
        ? r282;
        e eVar = this;
        b bVar2 = bVar;
        if (bVar2 != null) {
            eVar.f3344e.position(bVar2.f3322j);
        }
        if (bVar2 == null) {
            c cVar = eVar.m;
            i2 = cVar.f3329f;
            i3 = cVar.f3330g;
        } else {
            i2 = bVar2.f3315c;
            i3 = bVar2.f3316d;
        }
        int i7 = i2 * i3;
        byte[] bArr = eVar.f3349j;
        if (bArr == null || bArr.length < i7) {
            eVar.f3349j = eVar.f3343d.b(i7);
        }
        byte[] bArr2 = eVar.f3349j;
        if (eVar.f3346g == null) {
            eVar.f3346g = new short[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        }
        ? r3 = eVar.f3346g;
        if (eVar.f3347h == null) {
            eVar.f3347h = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        }
        byte[] bArr3 = eVar.f3347h;
        if (eVar.f3348i == null) {
            eVar.f3348i = new byte[4097];
        }
        byte[] bArr4 = eVar.f3348i;
        int i8 = i();
        int i9 = 1 << i8;
        int i10 = i9 + 1;
        int i11 = i9 + 2;
        int i12 = i8 + 1;
        int i13 = (1 << i12) - 1;
        int i14 = 0;
        for (int i15 = 0; i15 < i9; i15++) {
            r3[i15] = 0;
            bArr3[i15] = (byte) i15;
        }
        byte[] bArr5 = eVar.f3345f;
        int i16 = i12;
        int i17 = i11;
        int i18 = i13;
        int i19 = 0;
        ? r17 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = 0;
        ? r223 = 0;
        while (true) {
            if (i14 >= i7) {
                break;
            }
            if (i19 == 0) {
                i19 = h();
                if (i19 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i21 = 0;
            }
            i20 += (bArr5[i21] & 255) << r17;
            i21++;
            i19--;
            int i25 = r17 + 8;
            int i26 = i23;
            ? r283 = r223;
            int i27 = i17;
            int i28 = i22;
            int i29 = i14;
            int i30 = i16;
            while (true) {
                if (i25 < i30) {
                    i16 = i30;
                    r22 = r283;
                    i14 = i29;
                    i22 = i28;
                    i4 = i25;
                    i17 = i27;
                    i23 = i26;
                    eVar = this;
                    break;
                }
                byte b2 = i20 & i18;
                i20 >>= i30;
                i25 -= i30;
                if (b2 == i9) {
                    i30 = i12;
                    i27 = i11;
                    i18 = i13;
                    i26 = -1;
                    r282 = r283;
                } else if (b2 == i10) {
                    i4 = i25;
                    i16 = i30;
                    i14 = i29;
                    i22 = i28;
                    i17 = i27;
                    r22 = r283;
                    i23 = i26;
                    break;
                } else if (i26 == -1) {
                    bArr2[i28] = bArr3[b2];
                    i28++;
                    i29++;
                    eVar = this;
                    i26 = b2;
                    r282 = i26;
                } else {
                    int i31 = i27;
                    if (b2 >= i31) {
                        i5 = i25;
                        bArr4[i24] = (byte) r283;
                        i24++;
                        i6 = i26;
                    } else {
                        i5 = i25;
                        i6 = b2;
                    }
                    while (r4 >= i9) {
                        bArr4[i24] = bArr3[r4];
                        i24++;
                        r4 = r3[r4];
                    }
                    byte b3 = bArr3[r4] & 255;
                    int i32 = i12;
                    byte b4 = (byte) b3;
                    bArr2[i28] = b4;
                    while (true) {
                        i28++;
                        i29++;
                        if (i24 <= 0) {
                            break;
                        }
                        i24--;
                        bArr2[i28] = bArr4[i24];
                    }
                    byte b5 = b3;
                    if (i31 < 4096) {
                        r3[i31] = (short) i26;
                        bArr3[i31] = b4;
                        i31++;
                        if ((i31 & i18) == 0 && i31 < 4096) {
                            i30++;
                            i18 += i31;
                        }
                    }
                    i26 = b2;
                    i25 = i5;
                    i12 = i32;
                    r28 = b5;
                    i27 = i31;
                    eVar = this;
                    r283 = r28;
                }
                r28 = r282;
                r283 = r28;
            }
            r223 = r222;
            r17 = i4;
        }
        Arrays.fill(bArr2, i22, i7, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e9, code lost:
        return null;
     */
    public synchronized Bitmap a() {
        if (this.m.f3326c <= 0 || this.f3351l < 0) {
            if (Log.isLoggable(f3340a, 3)) {
                String str = f3340a;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to decode frame, frameCount=");
                sb.append(this.m.f3326c);
                sb.append(", framePointer=");
                sb.append(this.f3351l);
                Log.d(str, sb.toString());
            }
            this.p = 1;
        }
        if (this.p != 1) {
            if (this.p != 2) {
                this.p = 0;
                if (this.f3345f == null) {
                    this.f3345f = this.f3343d.b(255);
                }
                b bVar = (b) this.m.f3328e.get(this.f3351l);
                int i2 = this.f3351l - 1;
                b bVar2 = i2 >= 0 ? (b) this.m.f3328e.get(i2) : null;
                this.f3341b = bVar.f3323k != null ? bVar.f3323k : this.m.f3324a;
                if (this.f3341b == null) {
                    if (Log.isLoggable(f3340a, 3)) {
                        String str2 = f3340a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("No valid color table found for frame #");
                        sb2.append(this.f3351l);
                        Log.d(str2, sb2.toString());
                    }
                    this.p = 1;
                    return null;
                }
                if (bVar.f3318f) {
                    System.arraycopy(this.f3341b, 0, this.f3342c, 0, this.f3341b.length);
                    this.f3341b = this.f3342c;
                    this.f3341b[bVar.f3320h] = 0;
                }
                return a(bVar, bVar2);
            }
        }
        if (Log.isLoggable(f3340a, 3)) {
            String str3 = f3340a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to decode frame, status=");
            sb3.append(this.p);
            Log.d(str3, sb3.toString());
        }
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.p = 0;
            this.m = cVar;
            this.f3351l = -1;
            this.f3344e = byteBuffer.asReadOnlyBuffer();
            this.f3344e.position(0);
            this.f3344e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator it = cVar.f3328e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((b) it.next()).f3319g == 3) {
                        this.o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.q = highestOneBit;
            this.s = cVar.f3329f / highestOneBit;
            this.r = cVar.f3330g / highestOneBit;
            this.f3349j = this.f3343d.b(cVar.f3329f * cVar.f3330g);
            this.f3350k = this.f3343d.a(this.s * this.r);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Sample size must be >=0, not: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void a(Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.u = config;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported format: ");
        sb.append(config);
        sb.append(", must be one of ");
        sb.append(Config.ARGB_8888);
        sb.append(" or ");
        sb.append(Config.RGB_565);
        throw new IllegalArgumentException(sb.toString());
    }

    private Bitmap a(b bVar, b bVar2) {
        int[] iArr = this.f3350k;
        int i2 = 0;
        if (bVar2 == null) {
            Bitmap bitmap = this.n;
            if (bitmap != null) {
                this.f3343d.a(bitmap);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f3319g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null) {
            int i3 = bVar2.f3319g;
            if (i3 > 0) {
                if (i3 == 2) {
                    if (!bVar.f3318f) {
                        c cVar = this.m;
                        int i4 = cVar.f3335l;
                        if (bVar.f3323k == null || cVar.f3333j != bVar.f3320h) {
                            i2 = i4;
                        }
                    } else if (this.f3351l == 0) {
                        this.t = Boolean.valueOf(true);
                    }
                    int i5 = bVar2.f3316d;
                    int i6 = this.q;
                    int i7 = i5 / i6;
                    int i8 = bVar2.f3314b / i6;
                    int i9 = bVar2.f3315c / i6;
                    int i10 = bVar2.f3313a / i6;
                    int i11 = this.s;
                    int i12 = (i8 * i11) + i10;
                    int i13 = (i7 * i11) + i12;
                    while (i12 < i13) {
                        int i14 = i12 + i9;
                        for (int i15 = i12; i15 < i14; i15++) {
                            iArr[i15] = i2;
                        }
                        i12 += this.s;
                    }
                } else if (i3 == 3) {
                    Bitmap bitmap2 = this.n;
                    if (bitmap2 != null) {
                        int i16 = this.s;
                        bitmap2.getPixels(iArr, 0, i16, 0, 0, i16, this.r);
                    }
                }
            }
        }
        c(bVar);
        if (bVar.f3317e || this.q != 1) {
            a(bVar);
        } else {
            b(bVar);
        }
        if (this.o) {
            int i17 = bVar.f3319g;
            if (i17 == 0 || i17 == 1) {
                if (this.n == null) {
                    this.n = g();
                }
                Bitmap bitmap3 = this.n;
                int i18 = this.s;
                bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
            }
        }
        Bitmap g2 = g();
        int i19 = this.s;
        g2.setPixels(iArr, 0, i19, 0, 0, i19, this.r);
        return g2;
    }

    private void a(b bVar) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        b bVar2 = bVar;
        int[] iArr = this.f3350k;
        int i7 = bVar2.f3316d;
        int i8 = this.q;
        int i9 = i7 / i8;
        int i10 = bVar2.f3314b / i8;
        int i11 = bVar2.f3315c / i8;
        int i12 = bVar2.f3313a / i8;
        int i13 = this.f3351l;
        Boolean valueOf = Boolean.valueOf(true);
        boolean z2 = i13 == 0;
        int i14 = this.q;
        int i15 = this.s;
        int i16 = this.r;
        byte[] bArr = this.f3349j;
        int[] iArr2 = this.f3341b;
        Boolean bool = this.t;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        int i20 = 8;
        while (i17 < i9) {
            Boolean bool2 = valueOf;
            if (bVar2.f3317e) {
                if (i18 >= i9) {
                    i2 = i9;
                    i6 = i19 + 1;
                    if (i6 == 2) {
                        i18 = 4;
                    } else if (i6 == 3) {
                        i18 = 2;
                        i20 = 4;
                    } else if (i6 == 4) {
                        i18 = 1;
                        i20 = 2;
                    }
                } else {
                    i2 = i9;
                    i6 = i19;
                }
                i3 = i18 + i20;
                i19 = i6;
            } else {
                i2 = i9;
                i3 = i18;
                i18 = i17;
            }
            int i21 = i18 + i10;
            boolean z3 = i14 == 1;
            if (i21 < i16) {
                int i22 = i21 * i15;
                int i23 = i22 + i12;
                int i24 = i23 + i11;
                int i25 = i22 + i15;
                if (i25 < i24) {
                    i24 = i25;
                }
                i4 = i10;
                int i26 = i17 * i14 * bVar2.f3315c;
                if (z3) {
                    int i27 = i23;
                    while (i27 < i24) {
                        int i28 = i11;
                        int i29 = iArr2[bArr[i26] & 255];
                        if (i29 != 0) {
                            iArr[i27] = i29;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i26 += i14;
                        i27++;
                        i11 = i28;
                    }
                } else {
                    i5 = i11;
                    int i30 = ((i24 - i23) * i14) + i26;
                    int i31 = i23;
                    while (i31 < i24) {
                        int i32 = i24;
                        int a2 = a(i26, i30, bVar2.f3315c);
                        if (a2 != 0) {
                            iArr[i31] = a2;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i26 += i14;
                        i31++;
                        i24 = i32;
                    }
                    i17++;
                    i18 = i3;
                    i11 = i5;
                    valueOf = bool2;
                    i9 = i2;
                    i10 = i4;
                }
            } else {
                i4 = i10;
            }
            i5 = i11;
            i17++;
            i18 = i3;
            i11 = i5;
            valueOf = bool2;
            i9 = i2;
            i10 = i4;
        }
        if (this.t == null) {
            if (bool == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            this.t = Boolean.valueOf(z);
        }
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.q + i2; i10++) {
            byte[] bArr = this.f3349j;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f3341b[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.q + i12; i13++) {
            byte[] bArr2 = this.f3349j;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f3341b[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }
}
