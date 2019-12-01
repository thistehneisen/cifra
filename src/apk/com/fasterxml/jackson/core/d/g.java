package com.fasterxml.jackson.core.d;

import java.util.Arrays;

/* compiled from: NameN */
public final class g extends f {

    /* renamed from: c reason: collision with root package name */
    private final int f4342c;

    /* renamed from: d reason: collision with root package name */
    private final int f4343d;

    /* renamed from: e reason: collision with root package name */
    private final int f4344e;

    /* renamed from: f reason: collision with root package name */
    private final int f4345f;

    /* renamed from: g reason: collision with root package name */
    private final int f4346g;

    /* renamed from: h reason: collision with root package name */
    private final int[] f4347h;

    g(String str, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7) {
        super(str, i2);
        this.f4342c = i3;
        this.f4343d = i4;
        this.f4344e = i5;
        this.f4345f = i6;
        this.f4347h = iArr;
        this.f4346g = i7;
    }

    public static g a(String str, int i2, int[] iArr, int i3) {
        if (i3 >= 4) {
            g gVar = new g(str, i2, iArr[0], iArr[1], iArr[2], iArr[3], i3 + -4 > 0 ? Arrays.copyOfRange(iArr, 4, i3) : null, i3);
            return gVar;
        }
        throw new IllegalArgumentException();
    }

    public boolean a(int i2) {
        return false;
    }

    public boolean a(int i2, int i3) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (r7[6] == r6.f4347h[2]) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r7[5] == r6.f4347h[1]) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        if (r7[4] == r6.f4347h[0]) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        return true;
     */
    public boolean a(int[] iArr, int i2) {
        if (i2 != this.f4346g || iArr[0] != this.f4342c || iArr[1] != this.f4343d || iArr[2] != this.f4344e || iArr[3] != this.f4345f) {
            return false;
        }
        switch (i2) {
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                if (iArr[7] != this.f4347h[3]) {
                    return false;
                }
                break;
            default:
                return a(iArr);
        }
    }

    private final boolean a(int[] iArr) {
        int i2 = this.f4346g - 4;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3 + 4] != this.f4347h[i3]) {
                return false;
            }
        }
        return true;
    }
}
