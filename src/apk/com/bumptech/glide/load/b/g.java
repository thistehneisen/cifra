package com.bumptech.glide.load.b;

import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.i;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader */
public final class g<Model, Data> implements u<Model, Data> {

    /* renamed from: a reason: collision with root package name */
    private final a<Data> f3635a;

    /* compiled from: DataUrlLoader */
    public interface a<Data> {
        Class<Data> a();

        void a(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* compiled from: DataUrlLoader */
    private static final class b<Data> implements d<Data> {

        /* renamed from: a reason: collision with root package name */
        private final String f3636a;

        /* renamed from: b reason: collision with root package name */
        private final a<Data> f3637b;

        /* renamed from: c reason: collision with root package name */
        private Data f3638c;

        b(String str, a<Data> aVar) {
            this.f3636a = str;
            this.f3637b = aVar;
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super Data> aVar) {
            try {
                this.f3638c = this.f3637b.decode(this.f3636a);
                aVar.a(this.f3638c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            try {
                this.f3637b.a(this.f3638c);
            } catch (IOException unused) {
            }
        }

        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Data> a() {
            return this.f3637b.a();
        }
    }

    /* compiled from: DataUrlLoader */
    public static final class c<Model> implements v<Model, InputStream> {

        /* renamed from: a reason: collision with root package name */
        private final a<InputStream> f3639a = new h(this);

        public u<Model, InputStream> a(y yVar) {
            return new g(this.f3639a);
        }

        public void a() {
        }
    }

    public g(a<Data> aVar) {
        this.f3635a = aVar;
    }

    public com.bumptech.glide.load.b.u.a<Data> a(Model model, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(model), new b(model.toString(), this.f3635a));
    }

    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
