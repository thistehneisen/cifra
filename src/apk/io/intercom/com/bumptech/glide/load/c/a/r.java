package io.intercom.com.bumptech.glide.load.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.z;

/* compiled from: LazyBitmapDrawableResource */
public final class r implements E<BitmapDrawable>, z {

    /* renamed from: a reason: collision with root package name */
    private final Resources f9623a;

    /* renamed from: b reason: collision with root package name */
    private final E<Bitmap> f9624b;

    private r(Resources resources, E<Bitmap> e2) {
        h.a(resources);
        this.f9623a = resources;
        h.a(e2);
        this.f9624b = e2;
    }

    public static E<BitmapDrawable> a(Resources resources, E<Bitmap> e2) {
        if (e2 == null) {
            return null;
        }
        return new r(resources, e2);
    }

    public int b() {
        return this.f9624b.b();
    }

    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    public void d() {
        E<Bitmap> e2 = this.f9624b;
        if (e2 instanceof z) {
            ((z) e2).d();
        }
    }

    public void a() {
        this.f9624b.a();
    }

    public BitmapDrawable get() {
        return new BitmapDrawable(this.f9623a, (Bitmap) this.f9624b.get());
    }
}
