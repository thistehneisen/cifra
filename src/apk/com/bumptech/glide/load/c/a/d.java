package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import com.bumptech.glide.h.l;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.B;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.e;

/* compiled from: BitmapResource */
public class d implements G<Bitmap>, B {

    /* renamed from: a reason: collision with root package name */
    private final Bitmap f3723a;

    /* renamed from: b reason: collision with root package name */
    private final e f3724b;

    public d(Bitmap bitmap, e eVar) {
        l.a(bitmap, "Bitmap must not be null");
        this.f3723a = bitmap;
        l.a(eVar, "BitmapPool must not be null");
        this.f3724b = eVar;
    }

    public static d a(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    public int b() {
        return n.a(this.f3723a);
    }

    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    public void d() {
        this.f3723a.prepareToDraw();
    }

    public void a() {
        this.f3724b.a(this.f3723a);
    }

    public Bitmap get() {
        return this.f3723a;
    }
}
