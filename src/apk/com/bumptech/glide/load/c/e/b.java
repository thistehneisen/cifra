package com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.b.a.C0044a;
import com.bumptech.glide.load.engine.a.e;

/* compiled from: GifBitmapProvider */
public final class b implements C0044a {

    /* renamed from: a reason: collision with root package name */
    private final e f3800a;

    /* renamed from: b reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3801b;

    public b(e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f3800a = eVar;
        this.f3801b = bVar;
    }

    public Bitmap a(int i2, int i3, Config config) {
        return this.f3800a.a(i2, i3, config);
    }

    public byte[] b(int i2) {
        com.bumptech.glide.load.engine.a.b bVar = this.f3801b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.b(i2, byte[].class);
    }

    public void a(Bitmap bitmap) {
        this.f3800a.a(bitmap);
    }

    public void a(byte[] bArr) {
        com.bumptech.glide.load.engine.a.b bVar = this.f3801b;
        if (bVar != null) {
            bVar.put(bArr);
        }
    }

    public int[] a(int i2) {
        com.bumptech.glide.load.engine.a.b bVar = this.f3801b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.b(i2, int[].class);
    }

    public void a(int[] iArr) {
        com.bumptech.glide.load.engine.a.b bVar = this.f3801b;
        if (bVar != null) {
            bVar.put(iArr);
        }
    }
}
