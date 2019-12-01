package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.c.c.d;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;

/* compiled from: ResourceBitmapDecoder */
public class u implements j<Uri, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final d f3772a;

    /* renamed from: b reason: collision with root package name */
    private final e f3773b;

    public u(d dVar, e eVar) {
        this.f3772a = dVar;
        this.f3773b = eVar;
    }

    public boolean a(Uri uri, i iVar) {
        return "android.resource".equals(uri.getScheme());
    }

    public G<Bitmap> a(Uri uri, int i2, int i3, i iVar) {
        G a2 = this.f3772a.a(uri, i2, i3, iVar);
        if (a2 == null) {
            return null;
        }
        return n.a(this.f3773b, (Drawable) a2.get(), i2, i3);
    }
}
