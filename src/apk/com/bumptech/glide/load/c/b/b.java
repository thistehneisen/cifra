package com.bumptech.glide.load.c.b;

import com.bumptech.glide.h.l;
import com.bumptech.glide.load.engine.G;

/* compiled from: BytesResource */
public class b implements G<byte[]> {

    /* renamed from: a reason: collision with root package name */
    private final byte[] f3788a;

    public b(byte[] bArr) {
        l.a(bArr);
        this.f3788a = bArr;
    }

    public void a() {
    }

    public int b() {
        return this.f3788a.length;
    }

    public Class<byte[]> c() {
        return byte[].class;
    }

    public byte[] get() {
        return this.f3788a;
    }
}
