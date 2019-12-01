package com.bumptech.glide.load.c.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.i;

/* compiled from: DrawableBytesTranscoder */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a reason: collision with root package name */
    private final e f3841a;

    /* renamed from: b reason: collision with root package name */
    private final e<Bitmap, byte[]> f3842b;

    /* renamed from: c reason: collision with root package name */
    private final e<com.bumptech.glide.load.c.e.c, byte[]> f3843c;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.load.c.e.c, byte[]> eVar3) {
        this.f3841a = eVar;
        this.f3842b = eVar2;
        this.f3843c = eVar3;
    }

    private static G<com.bumptech.glide.load.c.e.c> a(G<Drawable> g2) {
        return g2;
    }

    public G<byte[]> a(G<Drawable> g2, i iVar) {
        Drawable drawable = (Drawable) g2.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f3842b.a(d.a(((BitmapDrawable) drawable).getBitmap(), this.f3841a), iVar);
        }
        if (!(drawable instanceof com.bumptech.glide.load.c.e.c)) {
            return null;
        }
        e<com.bumptech.glide.load.c.e.c, byte[]> eVar = this.f3843c;
        a(g2);
        return eVar.a(g2, iVar);
    }
}
