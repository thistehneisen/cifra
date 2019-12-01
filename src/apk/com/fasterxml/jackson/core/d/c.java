package com.fasterxml.jackson.core.d;

/* compiled from: Name1 */
public final class c extends f {

    /* renamed from: c reason: collision with root package name */
    private static final c f4333c = new c("", 0, 0);

    /* renamed from: d reason: collision with root package name */
    private final int f4334d;

    c(String str, int i2, int i3) {
        super(str, i2);
        this.f4334d = i3;
    }

    public static c b() {
        return f4333c;
    }

    public boolean a(int i2) {
        return i2 == this.f4334d;
    }

    public boolean a(int i2, int i3) {
        return i2 == this.f4334d && i3 == 0;
    }

    public boolean a(int[] iArr, int i2) {
        return i2 == 1 && iArr[0] == this.f4334d;
    }
}
