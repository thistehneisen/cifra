package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.f reason: case insensitive filesystem */
public final class C0303f<L> {

    /* renamed from: a reason: collision with root package name */
    private final L f4607a;

    /* renamed from: b reason: collision with root package name */
    private final String f4608b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0303f)) {
            return false;
        }
        C0303f fVar = (C0303f) obj;
        return this.f4607a == fVar.f4607a && this.f4608b.equals(fVar.f4608b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f4607a) * 31) + this.f4608b.hashCode();
    }
}
