package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.C0283c.b;
import com.bumptech.glide.load.b.C0283c.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.b.d reason: case insensitive filesystem */
/* compiled from: ByteArrayLoader */
class C0284d implements b<InputStream> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f3633a;

    C0284d(d dVar) {
        this.f3633a = dVar;
    }

    public InputStream a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
