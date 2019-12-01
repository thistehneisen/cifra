package io.intercom.com.bumptech.glide.load.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder */
public class a<DataType> implements k<DataType, BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    private final k<DataType, Bitmap> f9578a;

    /* renamed from: b reason: collision with root package name */
    private final Resources f9579b;

    public a(Resources resources, k<DataType, Bitmap> kVar) {
        h.a(resources);
        this.f9579b = resources;
        h.a(kVar);
        this.f9578a = kVar;
    }

    public boolean a(DataType datatype, j jVar) throws IOException {
        return this.f9578a.a(datatype, jVar);
    }

    public E<BitmapDrawable> a(DataType datatype, int i2, int i3, j jVar) throws IOException {
        return r.a(this.f9579b, this.f9578a.a(datatype, i2, i3, jVar));
    }
}
