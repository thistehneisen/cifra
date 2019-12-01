package io.intercom.com.bumptech.glide.load.c.b;

import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.engine.E;

/* compiled from: BytesResource */
public class b implements E<byte[]> {

    /* renamed from: a reason: collision with root package name */
    private final byte[] f9652a;

    public b(byte[] bArr) {
        h.a(bArr);
        this.f9652a = bArr;
    }

    public void a() {
    }

    public int b() {
        return this.f9652a.length;
    }

    public Class<byte[]> c() {
        return byte[].class;
    }

    public byte[] get() {
        return this.f9652a;
    }
}
