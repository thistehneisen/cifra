package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.h.a;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder */
public class f implements k<ByteBuffer, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final l f9586a;

    public f(l lVar) {
        this.f9586a = lVar;
    }

    public boolean a(ByteBuffer byteBuffer, j jVar) throws IOException {
        return this.f9586a.a(byteBuffer);
    }

    public E<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, j jVar) throws IOException {
        return this.f9586a.a(a.b(byteBuffer), i2, i3, jVar);
    }
}
