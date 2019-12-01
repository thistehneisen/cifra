package io.intercom.com.bumptech.glide.load.c.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import io.intercom.com.bumptech.glide.load.c.b.b;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder */
public class a implements d<Bitmap, byte[]> {

    /* renamed from: a reason: collision with root package name */
    private final CompressFormat f9701a;

    /* renamed from: b reason: collision with root package name */
    private final int f9702b;

    public a() {
        this(CompressFormat.JPEG, 100);
    }

    public E<byte[]> a(E<Bitmap> e2, j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) e2.get()).compress(this.f9701a, this.f9702b, byteArrayOutputStream);
        e2.a();
        return new b(byteArrayOutputStream.toByteArray());
    }

    public a(CompressFormat compressFormat, int i2) {
        this.f9701a = compressFormat;
        this.f9702b = i2;
    }
}
