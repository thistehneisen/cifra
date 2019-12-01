package com.google.firebase.components;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
public final class q {

    /* renamed from: a reason: collision with root package name */
    private final Class<?> f6712a;

    /* renamed from: b reason: collision with root package name */
    private final int f6713b;

    /* renamed from: c reason: collision with root package name */
    private final int f6714c;

    private q(Class<?> cls, int i2, int i3) {
        com.google.android.gms.common.internal.q.a(cls, (Object) "Null dependency anInterface.");
        this.f6712a = cls;
        this.f6713b = i2;
        this.f6714c = i3;
    }

    public static q a(Class<?> cls) {
        return new q(cls, 1, 0);
    }

    public static q b(Class<?> cls) {
        return new q(cls, 2, 0);
    }

    public boolean c() {
        return this.f6713b == 1;
    }

    public boolean d() {
        return this.f6713b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f6712a == qVar.f6712a && this.f6713b == qVar.f6713b && this.f6714c == qVar.f6714c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f6712a.hashCode() ^ 1000003) * 1000003) ^ this.f6713b) * 1000003) ^ this.f6714c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f6712a);
        sb.append(", type=");
        int i2 = this.f6713b;
        boolean z = true;
        String str = i2 == 1 ? "required" : i2 == 0 ? "optional" : "set";
        sb.append(str);
        sb.append(", direct=");
        if (this.f6714c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    public Class<?> a() {
        return this.f6712a;
    }

    public boolean b() {
        return this.f6714c == 0;
    }
}
