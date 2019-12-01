package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import io.intercom.com.bumptech.glide.load.c.c.e;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;

/* compiled from: ResourceBitmapDecoder */
public class t implements k<Uri, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final e f9631a;

    /* renamed from: b reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.a.e f9632b;

    public t(e eVar, io.intercom.com.bumptech.glide.load.engine.a.e eVar2) {
        this.f9631a = eVar;
        this.f9632b = eVar2;
    }

    public boolean a(Uri uri, j jVar) throws IOException {
        return "android.resource".equals(uri.getScheme());
    }

    public E<Bitmap> a(Uri uri, int i2, int i3, j jVar) throws IOException {
        return n.a(this.f9632b, (Drawable) this.f9631a.a(uri, i2, i3, jVar).get(), i2, i3);
    }
}
