package com.fasterxml.jackson.core.d;

/* compiled from: Name */
public abstract class f {

    /* renamed from: a reason: collision with root package name */
    protected final String f4340a;

    /* renamed from: b reason: collision with root package name */
    protected final int f4341b;

    protected f(String str, int i2) {
        this.f4340a = str;
        this.f4341b = i2;
    }

    public String a() {
        return this.f4340a;
    }

    public abstract boolean a(int i2);

    public abstract boolean a(int i2, int i3);

    public abstract boolean a(int[] iArr, int i2);

    public boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return this.f4341b;
    }

    public String toString() {
        return this.f4340a;
    }
}
