package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import com.bumptech.glide.h.a;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder */
public class f implements j<ByteBuffer, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final l f3725a;

    public f(l lVar) {
        this.f3725a = lVar;
    }

    public boolean a(ByteBuffer byteBuffer, i iVar) {
        return this.f3725a.a(byteBuffer);
    }

    public G<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, i iVar) throws IOException {
        return this.f3725a.a(a.b(byteBuffer), i2, i3, iVar);
    }
}
