package io.intercom.com.bumptech.glide.load.b;

import b.g.h.d;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.a.b;
import io.intercom.com.bumptech.glide.load.engine.GlideException;
import io.intercom.com.bumptech.glide.load.g;
import io.intercom.com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MultiModelLoader */
class x<Model, Data> implements u<Model, Data> {

    /* renamed from: a reason: collision with root package name */
    private final List<u<Model, Data>> f9551a;

    /* renamed from: b reason: collision with root package name */
    private final d<List<Throwable>> f9552b;

    /* compiled from: MultiModelLoader */
    static class a<Data> implements b<Data>, io.intercom.com.bumptech.glide.load.a.b.a<Data> {

        /* renamed from: a reason: collision with root package name */
        private final List<b<Data>> f9553a;

        /* renamed from: b reason: collision with root package name */
        private final d<List<Throwable>> f9554b;

        /* renamed from: c reason: collision with root package name */
        private int f9555c = 0;

        /* renamed from: d reason: collision with root package name */
        private h f9556d;

        /* renamed from: e reason: collision with root package name */
        private io.intercom.com.bumptech.glide.load.a.b.a<? super Data> f9557e;

        /* renamed from: f reason: collision with root package name */
        private List<Throwable> f9558f;

        a(List<b<Data>> list, d<List<Throwable>> dVar) {
            this.f9554b = dVar;
            io.intercom.com.bumptech.glide.h.h.a(list);
            this.f9553a = list;
        }

        private void d() {
            if (this.f9555c < this.f9553a.size() - 1) {
                this.f9555c++;
                a(this.f9556d, this.f9557e);
                return;
            }
            io.intercom.com.bumptech.glide.h.h.a(this.f9558f);
            this.f9557e.a((Exception) new GlideException("Fetch failed", (List<Throwable>) new ArrayList<Throwable>(this.f9558f)));
        }

        public void a(h hVar, io.intercom.com.bumptech.glide.load.a.b.a<? super Data> aVar) {
            this.f9556d = hVar;
            this.f9557e = aVar;
            this.f9558f = (List) this.f9554b.a();
            ((b) this.f9553a.get(this.f9555c)).a(hVar, this);
        }

        public void b() {
            List<Throwable> list = this.f9558f;
            if (list != null) {
                this.f9554b.a(list);
            }
            this.f9558f = null;
            for (b b2 : this.f9553a) {
                b2.b();
            }
        }

        public io.intercom.com.bumptech.glide.load.a c() {
            return ((b) this.f9553a.get(0)).c();
        }

        public void cancel() {
            for (b cancel : this.f9553a) {
                cancel.cancel();
            }
        }

        public Class<Data> a() {
            return ((b) this.f9553a.get(0)).a();
        }

        public void a(Data data) {
            if (data != null) {
                this.f9557e.a(data);
            } else {
                d();
            }
        }

        public void a(Exception exc) {
            List<Throwable> list = this.f9558f;
            io.intercom.com.bumptech.glide.h.h.a(list);
            list.add(exc);
            d();
        }
    }

    x(List<u<Model, Data>> list, d<List<Throwable>> dVar) {
        this.f9551a = list;
        this.f9552b = dVar;
    }

    public io.intercom.com.bumptech.glide.load.b.u.a<Data> a(Model model, int i2, int i3, j jVar) {
        int size = this.f9551a.size();
        ArrayList arrayList = new ArrayList(size);
        g gVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            u uVar = (u) this.f9551a.get(i4);
            if (uVar.a(model)) {
                io.intercom.com.bumptech.glide.load.b.u.a a2 = uVar.a(model, i2, i3, jVar);
                if (a2 != null) {
                    gVar = a2.f9544a;
                    arrayList.add(a2.f9546c);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return new io.intercom.com.bumptech.glide.load.b.u.a<>(gVar, new a(arrayList, this.f9552b));
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        List<u<Model, Data>> list = this.f9551a;
        sb.append(Arrays.toString(list.toArray(new u[list.size()])));
        sb.append('}');
        return sb.toString();
    }

    public boolean a(Model model) {
        for (u a2 : this.f9551a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }
}
