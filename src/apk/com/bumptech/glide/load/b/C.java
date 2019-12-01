package com.bumptech.glide.load.b;

import com.bumptech.glide.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.i;

/* compiled from: UnitModelLoader */
public class C<Model> implements u<Model, Model> {

    /* renamed from: a reason: collision with root package name */
    private static final C<?> f3604a = new C<>();

    /* compiled from: UnitModelLoader */
    public static class a<Model> implements v<Model, Model> {

        /* renamed from: a reason: collision with root package name */
        private static final a<?> f3605a = new a<>();

        public static <T> a<T> b() {
            return f3605a;
        }

        public u<Model, Model> a(y yVar) {
            return C.a();
        }

        public void a() {
        }
    }

    /* compiled from: UnitModelLoader */
    private static class b<Model> implements d<Model> {

        /* renamed from: a reason: collision with root package name */
        private final Model f3606a;

        b(Model model) {
            this.f3606a = model;
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super Model> aVar) {
            aVar.a(this.f3606a);
        }

        public void b() {
        }

        public com.bumptech.glide.load.a c() {
            return com.bumptech.glide.load.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Model> a() {
            return this.f3606a.getClass();
        }
    }

    public static <T> C<T> a() {
        return f3604a;
    }

    public boolean a(Model model) {
        return true;
    }

    public com.bumptech.glide.load.b.u.a<Model> a(Model model, int i2, int i3, i iVar) {
        return new com.bumptech.glide.load.b.u.a<>(new com.bumptech.glide.g.b(model), new b(model));
    }
}
