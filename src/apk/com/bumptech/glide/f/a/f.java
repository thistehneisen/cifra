package com.bumptech.glide.f.a;

import com.bumptech.glide.h.n;

@Deprecated
/* compiled from: SimpleTarget */
public abstract class f<Z> extends a<Z> {

    /* renamed from: b reason: collision with root package name */
    private final int f3444b;

    /* renamed from: c reason: collision with root package name */
    private final int f3445c;

    public f() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void a(g gVar) {
    }

    public final void b(g gVar) {
        if (n.b(this.f3444b, this.f3445c)) {
            gVar.a(this.f3444b, this.f3445c);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.f3444b);
        sb.append(" and height: ");
        sb.append(this.f3445c);
        sb.append(", either provide dimensions in the constructor or call override()");
        throw new IllegalArgumentException(sb.toString());
    }

    public f(int i2, int i3) {
        this.f3444b = i2;
        this.f3445c = i3;
    }
}
