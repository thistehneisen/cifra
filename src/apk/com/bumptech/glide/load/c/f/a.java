package com.bumptech.glide.load.c.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.c.b.b;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder */
public class a implements e<Bitmap, byte[]> {

    /* renamed from: a reason: collision with root package name */
    private final CompressFormat f3838a;

    /* renamed from: b reason: collision with root package name */
    private final int f3839b;

    public a() {
        this(CompressFormat.JPEG, 100);
    }

    public G<byte[]> a(G<Bitmap> g2, i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) g2.get()).compress(this.f3838a, this.f3839b, byteArrayOutputStream);
        g2.a();
        return new b(byteArrayOutputStream.toByteArray());
    }

    public a(CompressFormat compressFormat, int i2) {
        this.f3838a = compressFormat;
        this.f3839b = i2;
    }
}
