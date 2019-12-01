package com.fasterxml.jackson.core;

/* compiled from: JsonStreamContext */
public abstract class f {

    /* renamed from: a reason: collision with root package name */
    protected int f4390a;

    /* renamed from: b reason: collision with root package name */
    protected int f4391b;

    protected f() {
    }

    public final int a() {
        int i2 = this.f4391b;
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public final int b() {
        return this.f4391b + 1;
    }

    public final String c() {
        int i2 = this.f4390a;
        if (i2 == 0) {
            return "ROOT";
        }
        if (i2 != 1) {
            return i2 != 2 ? "?" : "OBJECT";
        }
        return "ARRAY";
    }

    public final boolean d() {
        return this.f4390a == 1;
    }

    public final boolean e() {
        return this.f4390a == 2;
    }

    public final boolean f() {
        return this.f4390a == 0;
    }
}
