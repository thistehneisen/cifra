package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.load.b.C0739c.a;
import io.intercom.com.bumptech.glide.load.b.C0739c.b;
import java.nio.ByteBuffer;

/* renamed from: io.intercom.com.bumptech.glide.load.b.b reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0738b implements b<ByteBuffer> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f9499a;

    C0738b(a aVar) {
        this.f9499a = aVar;
    }

    public ByteBuffer a(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }
}
