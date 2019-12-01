package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;

/* compiled from: UnitBitmapDecoder */
public final class x implements j<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder */
    private static final class a implements G<Bitmap> {

        /* renamed from: a reason: collision with root package name */
        private final Bitmap f3783a;

        a(Bitmap bitmap) {
            this.f3783a = bitmap;
        }

        public void a() {
        }

        public int b() {
            return n.a(this.f3783a);
        }

        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        public Bitmap get() {
            return this.f3783a;
        }
    }

    public boolean a(Bitmap bitmap, i iVar) {
        return true;
    }

    public G<Bitmap> a(Bitmap bitmap, int i2, int i3, i iVar) {
        return new a(bitmap);
    }
}
