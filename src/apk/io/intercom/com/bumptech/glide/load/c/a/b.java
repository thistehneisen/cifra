package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import io.intercom.com.bumptech.glide.load.c;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.l;
import java.io.File;

/* compiled from: BitmapDrawableEncoder */
public class b implements l<BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    private final e f9580a;

    /* renamed from: b reason: collision with root package name */
    private final l<Bitmap> f9581b;

    public b(e eVar, l<Bitmap> lVar) {
        this.f9580a = eVar;
        this.f9581b = lVar;
    }

    public boolean a(E<BitmapDrawable> e2, File file, j jVar) {
        return this.f9581b.a(new d(((BitmapDrawable) e2.get()).getBitmap(), this.f9580a), file, jVar);
    }

    public c a(j jVar) {
        return this.f9581b.a(jVar);
    }
}
