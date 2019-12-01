package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.load.b.C0739c.b;
import io.intercom.com.bumptech.glide.load.b.C0739c.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: io.intercom.com.bumptech.glide.load.b.d reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0740d implements b<InputStream> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f9503a;

    C0740d(d dVar) {
        this.f9503a = dVar;
    }

    public InputStream a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
