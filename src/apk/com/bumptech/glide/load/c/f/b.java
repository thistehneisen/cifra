package com.bumptech.glide.load.c.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.c.a.s;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;

/* compiled from: BitmapDrawableTranscoder */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    private final Resources f3840a;

    public b(Resources resources) {
        l.a(resources);
        this.f3840a = resources;
    }

    public G<BitmapDrawable> a(G<Bitmap> g2, i iVar) {
        return s.a(this.f3840a, g2);
    }
}
