package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.j;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader */
public final class g<Data> implements u<String, Data> {

    /* renamed from: a reason: collision with root package name */
    private final a<Data> f9505a;

    /* compiled from: DataUrlLoader */
    public interface a<Data> {
        Class<Data> a();

        void a(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader */
    private static final class b<Data> implements io.intercom.com.bumptech.glide.load.a.b<Data> {

        /* renamed from: a reason: collision with root package name */
        private final String f9506a;

        /* renamed from: b reason: collision with root package name */
        private final a<Data> f9507b;

        /* renamed from: c reason: collision with root package name */
        private Data f9508c;

        b(String str, a<Data> aVar) {
            this.f9506a = str;
            this.f9507b = aVar;
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super Data> aVar) {
            try {
                this.f9508c = this.f9507b.decode(this.f9506a);
                aVar.a(this.f9508c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            try {
                this.f9507b.a(this.f9508c);
            } catch (IOException unused) {
            }
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return io.intercom.com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f9507b.a();
        }
    }

    /* compiled from: DataUrlLoader */
    public static final class c implements v<String, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final a<InputStream> f9509a = new h(this);

        public final u<String, InputStream> a(y yVar) {
            return new g(this.f9509a);
        }
    }

    public g(a<Data> aVar) {
        this.f9505a = aVar;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(String str, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(str), new b(str, this.f9505a));
    }

    public boolean a(String str) {
        return str.startsWith("data:image");
    }
}
