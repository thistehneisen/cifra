package io.intercom.com.bumptech.glide.f.a;

import io.intercom.com.bumptech.glide.h.j;

/* compiled from: SimpleTarget */
public abstract class f<Z> extends a<Z> {
    private final int height;
    private final int width;

    public f() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void getSize(g gVar) {
        if (j.b(this.width, this.height)) {
            gVar.a(this.width, this.height);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.width);
        sb.append(" and height: ");
        sb.append(this.height);
        sb.append(", either provide dimensions in the constructor or call override()");
        throw new IllegalArgumentException(sb.toString());
    }

    public void removeCallback(g gVar) {
    }

    public f(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }
}
