package io.intercom.com.bumptech.glide.load.a;

import io.intercom.com.bumptech.glide.load.c.a.s;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder */
public final class j implements c<InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final s f9462a;

    /* compiled from: InputStreamRewinder */
    public static final class a implements io.intercom.com.bumptech.glide.load.a.c.a<InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final b f9463a;

        public a(b bVar) {
            this.f9463a = bVar;
        }

        public c<InputStream> a(InputStream inputStream) {
            return new j(inputStream, this.f9463a);
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    j(InputStream inputStream, b bVar) {
        this.f9462a = new s(inputStream, bVar);
        this.f9462a.mark(5242880);
    }

    public void b() {
        this.f9462a.b();
    }

    public InputStream a() throws IOException {
        this.f9462a.reset();
        return this.f9462a;
    }
}
