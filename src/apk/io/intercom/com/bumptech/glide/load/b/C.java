package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.j;

/* compiled from: UnitModelLoader */
public class C<Model> implements u<Model, Model> {

    /* renamed from: a reason: collision with root package name */
    private static final C<?> f9475a = new C<>();

    /* compiled from: UnitModelLoader */
    public static class a<Model> implements v<Model, Model> {

        /* renamed from: a reason: collision with root package name */
        private static final a<?> f9476a = new a<>();

        public static <T> a<T> a() {
            return f9476a;
        }

        public u<Model, Model> a(y yVar) {
            return C.a();
        }
    }

    /* compiled from: UnitModelLoader */
    private static class b<Model> implements io.intercom.com.bumptech.glide.load.a.b<Model> {

        /* renamed from: a reason: collision with root package name */
        private final Model f9477a;

        b(Model model) {
            this.f9477a = model;
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super Model> aVar) {
            aVar.a(this.f9477a);
        }

        public void b() {
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return io.intercom.com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Model> a() {
            return this.f9477a.getClass();
        }
    }

    public static <T> C<T> a() {
        return f9475a;
    }

    public boolean a(Model model) {
        return true;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Model> a(Model model, int i2, int i3, j jVar) {
        return new io.intercom.com.bumptech.glide.load.b.u.a<>(new io.intercom.com.bumptech.glide.g.b(model), new b(model));
    }
}
