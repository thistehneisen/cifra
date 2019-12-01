package com.touchin.vtb.f;

import kotlin.e.b.h;

/* compiled from: ConfirmModel.kt */
public final class d {

    /* renamed from: a reason: collision with root package name */
    private final String f7390a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f7391b;

    public d(String str, boolean z) {
        h.b(str, "pin");
        this.f7390a = str;
        this.f7391b = z;
    }

    public final String a() {
        return this.f7390a;
    }

    public final boolean b() {
        return this.f7391b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (h.a((Object) this.f7390a, (Object) dVar.f7390a)) {
                    if (this.f7391b == dVar.f7391b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7390a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.f7391b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfirmModel(pin=");
        sb.append(this.f7390a);
        sb.append(", isFingerprintEnabled=");
        sb.append(this.f7391b);
        sb.append(")");
        return sb.toString();
    }
}
