package io.intercom.com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import io.intercom.com.bumptech.glide.b.a.C0100a;
import io.intercom.com.bumptech.glide.load.engine.a.e;

/* compiled from: GifBitmapProvider */
public final class b implements C0100a {

    /* renamed from: a reason: collision with root package name */
    private final e f9664a;

    /* renamed from: b reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.a.b f9665b;

    public b(e eVar, io.intercom.com.bumptech.glide.load.engine.a.b bVar) {
        this.f9664a = eVar;
        this.f9665b = bVar;
    }

    public Bitmap a(int i2, int i3, Config config) {
        return this.f9664a.a(i2, i3, config);
    }

    public byte[] b(int i2) {
        io.intercom.com.bumptech.glide.load.engine.a.b bVar = this.f9665b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.b(i2, byte[].class);
    }

    public void a(Bitmap bitmap) {
        this.f9664a.a(bitmap);
    }

    public void a(byte[] bArr) {
        io.intercom.com.bumptech.glide.load.engine.a.b bVar = this.f9665b;
        if (bVar != null) {
            bVar.put(bArr);
        }
    }

    public int[] a(int i2) {
        io.intercom.com.bumptech.glide.load.engine.a.b bVar = this.f9665b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.b(i2, int[].class);
    }

    public void a(int[] iArr) {
        io.intercom.com.bumptech.glide.load.engine.a.b bVar = this.f9665b;
        if (bVar != null) {
            bVar.put(iArr);
        }
    }
}
