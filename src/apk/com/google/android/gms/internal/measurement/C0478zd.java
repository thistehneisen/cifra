package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.measurement.zd reason: case insensitive filesystem */
final class C0478zd {

    /* renamed from: a reason: collision with root package name */
    final int f5463a;

    /* renamed from: b reason: collision with root package name */
    final byte[] f5464b;

    C0478zd(int i2, byte[] bArr) {
        this.f5463a = i2;
        this.f5464b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0478zd)) {
            return false;
        }
        C0478zd zdVar = (C0478zd) obj;
        return this.f5463a == zdVar.f5463a && Arrays.equals(this.f5464b, zdVar.f5464b);
    }

    public final int hashCode() {
        return ((this.f5463a + 527) * 31) + Arrays.hashCode(this.f5464b);
    }
}
