package com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import com.bumptech.glide.h.d;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class v implements j<InputStream, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final l f3774a;

    /* renamed from: b reason: collision with root package name */
    private final b f3775b;

    /* compiled from: StreamBitmapDecoder */
    static class a implements com.bumptech.glide.load.c.a.l.a {

        /* renamed from: a reason: collision with root package name */
        private final t f3776a;

        /* renamed from: b reason: collision with root package name */
        private final d f3777b;

        a(t tVar, d dVar) {
            this.f3776a = tVar;
            this.f3777b = dVar;
        }

        public void a() {
            this.f3776a.a();
        }

        public void a(e eVar, Bitmap bitmap) throws IOException {
            IOException a2 = this.f3777b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }

    public v(l lVar, b bVar) {
        this.f3774a = lVar;
        this.f3775b = bVar;
    }

    public boolean a(InputStream inputStream, i iVar) {
        return this.f3774a.a(inputStream);
    }

    public G<Bitmap> a(InputStream inputStream, int i2, int i3, i iVar) throws IOException {
        t tVar;
        boolean z;
        if (inputStream instanceof t) {
            tVar = (t) inputStream;
            z = false;
        } else {
            tVar = new t(inputStream, this.f3775b);
            z = true;
        }
        d a2 = d.a(tVar);
        try {
            return this.f3774a.a((InputStream) new com.bumptech.glide.h.j(a2), i2, i3, iVar, (com.bumptech.glide.load.c.a.l.a) new a(tVar, a2));
        } finally {
            a2.b();
            if (z) {
                tVar.b();
            }
        }
    }
}
