package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.engine.z;

/* compiled from: BitmapResource */
public class d implements E<Bitmap>, z {

    /* renamed from: a reason: collision with root package name */
    private final Bitmap f9584a;

    /* renamed from: b reason: collision with root package name */
    private final e f9585b;

    public d(Bitmap bitmap, e eVar) {
        h.a(bitmap, "Bitmap must not be null");
        this.f9584a = bitmap;
        h.a(eVar, "BitmapPool must not be null");
        this.f9585b = eVar;
    }

    public static d a(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    public int b() {
        return j.a(this.f9584a);
    }

    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    public void d() {
        this.f9584a.prepareToDraw();
    }

    public void a() {
        this.f9585b.a(this.f9584a);
    }

    public Bitmap get() {
        return this.f9584a;
    }
}
