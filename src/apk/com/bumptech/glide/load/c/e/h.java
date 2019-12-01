package com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import com.bumptech.glide.b.a;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;

/* compiled from: GifFrameResourceDecoder */
public final class h implements j<a, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final e f3832a;

    public h(e eVar) {
        this.f3832a = eVar;
    }

    public boolean a(a aVar, i iVar) {
        return true;
    }

    public G<Bitmap> a(a aVar, int i2, int i3, i iVar) {
        return d.a(aVar.a(), this.f3832a);
    }
}
