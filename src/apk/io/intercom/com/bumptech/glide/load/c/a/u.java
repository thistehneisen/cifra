package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import io.intercom.com.bumptech.glide.h.c;
import io.intercom.com.bumptech.glide.h.f;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.k;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder */
public class u implements k<InputStream, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    private final l f9633a;

    /* renamed from: b reason: collision with root package name */
    private final b f9634b;

    /* compiled from: StreamBitmapDecoder */
    static class a implements io.intercom.com.bumptech.glide.load.c.a.l.a {

        /* renamed from: a reason: collision with root package name */
        private final s f9635a;

        /* renamed from: b reason: collision with root package name */
        private final c f9636b;

        a(s sVar, c cVar) {
            this.f9635a = sVar;
            this.f9636b = cVar;
        }

        public void a() {
            this.f9635a.a();
        }

        public void a(e eVar, Bitmap bitmap) throws IOException {
            IOException a2 = this.f9636b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }

    public u(l lVar, b bVar) {
        this.f9633a = lVar;
        this.f9634b = bVar;
    }

    public boolean a(InputStream inputStream, j jVar) throws IOException {
        return this.f9633a.a(inputStream);
    }

    public E<Bitmap> a(InputStream inputStream, int i2, int i3, j jVar) throws IOException {
        s sVar;
        boolean z;
        if (inputStream instanceof s) {
            sVar = (s) inputStream;
            z = false;
        } else {
            sVar = new s(inputStream, this.f9634b);
            z = true;
        }
        c a2 = c.a(sVar);
        try {
            return this.f9633a.a((InputStream) new f(a2), i2, i3, jVar, (io.intercom.com.bumptech.glide.load.c.a.l.a) new a(sVar, a2));
        } finally {
            a2.b();
            if (z) {
                sVar.b();
            }
        }
    }
}
