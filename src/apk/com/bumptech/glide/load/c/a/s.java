package com.bumptech.glide.load.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.engine.B;
import com.bumptech.glide.load.engine.G;

/* compiled from: LazyBitmapDrawableResource */
public final class s implements G<BitmapDrawable>, B {

    /* renamed from: a reason: collision with root package name */
    private final Resources f3764a;

    /* renamed from: b reason: collision with root package name */
    private final G<Bitmap> f3765b;

    private s(Resources resources, G<Bitmap> g2) {
        l.a(resources);
        this.f3764a = resources;
        l.a(g2);
        this.f3765b = g2;
    }

    public static G<BitmapDrawable> a(Resources resources, G<Bitmap> g2) {
        if (g2 == null) {
            return null;
        }
        return new s(resources, g2);
    }

    public int b() {
        return this.f3765b.b();
    }

    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    public void d() {
        G<Bitmap> g2 = this.f3765b;
        if (g2 instanceof B) {
            ((B) g2).d();
        }
    }

    public void a() {
        this.f3765b.a();
    }

    public BitmapDrawable get() {
        return new BitmapDrawable(this.f3764a, (Bitmap) this.f3765b.get());
    }
}
