package io.intercom.com.bumptech.glide.load.c.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.c.a.r;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;

/* compiled from: BitmapDrawableTranscoder */
public class b implements d<Bitmap, BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    private final Resources f9703a;

    public b(Resources resources) {
        h.a(resources);
        this.f9703a = resources;
    }

    public E<BitmapDrawable> a(E<Bitmap> e2, j jVar) {
        return r.a(this.f9703a, e2);
    }
}
