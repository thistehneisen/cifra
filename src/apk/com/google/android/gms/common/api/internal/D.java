package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.C0321p;

public final class D<O extends d> {

    /* renamed from: a reason: collision with root package name */
    private final boolean f4555a;

    /* renamed from: b reason: collision with root package name */
    private final int f4556b;

    /* renamed from: c reason: collision with root package name */
    private final a<O> f4557c;

    /* renamed from: d reason: collision with root package name */
    private final O f4558d;

    public final String a() {
        return this.f4557c.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d2 = (D) obj;
        return !this.f4555a && !d2.f4555a && C0321p.a(this.f4557c, d2.f4557c) && C0321p.a(this.f4558d, d2.f4558d);
    }

    public final int hashCode() {
        return this.f4556b;
    }
}
