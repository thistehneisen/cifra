package com.bumptech.glide.load.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.c.a.a reason: case insensitive filesystem */
/* compiled from: BitmapDrawableDecoder */
public class C0286a<DataType> implements j<DataType, BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    private final j<DataType, Bitmap> f3716a;

    /* renamed from: b reason: collision with root package name */
    private final Resources f3717b;

    public C0286a(Resources resources, j<DataType, Bitmap> jVar) {
        l.a(resources);
        this.f3717b = resources;
        l.a(jVar);
        this.f3716a = jVar;
    }

    public boolean a(DataType datatype, i iVar) throws IOException {
        return this.f3716a.a(datatype, iVar);
    }

    public G<BitmapDrawable> a(DataType datatype, int i2, int i3, i iVar) throws IOException {
        return s.a(this.f3717b, this.f3716a.a(datatype, i2, i3, iVar));
    }
}
