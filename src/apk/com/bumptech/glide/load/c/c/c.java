package com.bumptech.glide.load.c.c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.G;

/* compiled from: NonOwnedDrawableResource */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static G<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    public void a() {
    }

    public int b() {
        return Math.max(1, this.f3790a.getIntrinsicWidth() * this.f3790a.getIntrinsicHeight() * 4);
    }

    public Class<Drawable> c() {
        return this.f3790a.getClass();
    }
}
