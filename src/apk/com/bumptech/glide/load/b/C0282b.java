package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.C0283c.a;
import com.bumptech.glide.load.b.C0283c.b;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.b.b reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0282b implements b<ByteBuffer> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f3629a;

    C0282b(a aVar) {
        this.f3629a = aVar;
    }

    public ByteBuffer a(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }
}
