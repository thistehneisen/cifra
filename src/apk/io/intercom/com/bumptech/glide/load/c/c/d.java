package io.intercom.com.bumptech.glide.load.c.c;

import android.graphics.drawable.Drawable;
import io.intercom.com.bumptech.glide.load.engine.E;

/* compiled from: NonOwnedDrawableResource */
final class d extends b<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    static E<Drawable> a(Drawable drawable) {
        return new d(drawable);
    }

    public void a() {
    }

    public int b() {
        return Math.max(1, this.f9654a.getIntrinsicWidth() * this.f9654a.getIntrinsicHeight() * 4);
    }

    public Class<Drawable> c() {
        return this.f9654a.getClass();
    }
}
