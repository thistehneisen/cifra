package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;

/* compiled from: UnitBitmapDecoder */
public final class w implements k<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder */
    private static final class a implements E<Bitmap> {

        /* renamed from: a reason: collision with root package name */
        private final Bitmap f9642a;

        a(Bitmap bitmap) {
            this.f9642a = bitmap;
        }

        public void a() {
        }

        public int b() {
            return j.a(this.f9642a);
        }

        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        public Bitmap get() {
            return this.f9642a;
        }
    }

    public boolean a(Bitmap bitmap, io.intercom.com.bumptech.glide.load.j jVar) throws IOException {
        return true;
    }

    public E<Bitmap> a(Bitmap bitmap, int i2, int i3, io.intercom.com.bumptech.glide.load.j jVar) throws IOException {
        return new a(bitmap);
    }
}
