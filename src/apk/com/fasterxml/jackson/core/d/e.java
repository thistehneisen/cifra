package com.fasterxml.jackson.core.d;

/* compiled from: Name3 */
public final class e extends f {

    /* renamed from: c reason: collision with root package name */
    private final int f4337c;

    /* renamed from: d reason: collision with root package name */
    private final int f4338d;

    /* renamed from: e reason: collision with root package name */
    private final int f4339e;

    e(String str, int i2, int i3, int i4, int i5) {
        super(str, i2);
        this.f4337c = i3;
        this.f4338d = i4;
        this.f4339e = i5;
    }

    public boolean a(int i2) {
        return false;
    }

    public boolean a(int i2, int i3) {
        return false;
    }

    public boolean a(int[] iArr, int i2) {
        return i2 == 3 && iArr[0] == this.f4337c && iArr[1] == this.f4338d && iArr[2] == this.f4339e;
    }
}
