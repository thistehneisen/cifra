package com.fasterxml.jackson.core.d;

/* compiled from: Name2 */
public final class d extends f {

    /* renamed from: c reason: collision with root package name */
    private final int f4335c;

    /* renamed from: d reason: collision with root package name */
    private final int f4336d;

    d(String str, int i2, int i3, int i4) {
        super(str, i2);
        this.f4335c = i3;
        this.f4336d = i4;
    }

    public boolean a(int i2) {
        return false;
    }

    public boolean a(int i2, int i3) {
        return i2 == this.f4335c && i3 == this.f4336d;
    }

    public boolean a(int[] iArr, int i2) {
        return i2 == 2 && iArr[0] == this.f4335c && iArr[1] == this.f4336d;
    }
}
