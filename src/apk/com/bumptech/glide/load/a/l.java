package com.bumptech.glide.load.a;

import com.bumptech.glide.load.c.a.t;
import com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder */
public final class l implements e<InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final t f3592a;

    /* compiled from: InputStreamRewinder */
    public static final class a implements com.bumptech.glide.load.a.e.a<InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final b f3593a;

        public a(b bVar) {
            this.f3593a = bVar;
        }

        public e<InputStream> a(InputStream inputStream) {
            return new l(inputStream, this.f3593a);
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    l(InputStream inputStream, b bVar) {
        this.f3592a = new t(inputStream, bVar);
        this.f3592a.mark(5242880);
    }

    public void b() {
        this.f3592a.b();
    }

    public InputStream a() throws IOException {
        this.f3592a.reset();
        return this.f3592a;
    }
}
