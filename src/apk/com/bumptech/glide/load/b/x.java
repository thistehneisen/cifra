package com.bumptech.glide.load.b;

import b.g.h.d;
import com.bumptech.glide.h.l;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MultiModelLoader */
class x<Model, Data> implements u<Model, Data> {

    /* renamed from: a reason: collision with root package name */
    private final List<u<Model, Data>> f3681a;

    /* renamed from: b reason: collision with root package name */
    private final d<List<Throwable>> f3682b;

    /* compiled from: MultiModelLoader */
    static class a<Data> implements com.bumptech.glide.load.a.d<Data>, com.bumptech.glide.load.a.d.a<Data> {

        /* renamed from: a reason: collision with root package name */
        private final List<com.bumptech.glide.load.a.d<Data>> f3683a;

        /* renamed from: b reason: collision with root package name */
        private final d<List<Throwable>> f3684b;

        /* renamed from: c reason: collision with root package name */
        private int f3685c = 0;

        /* renamed from: d reason: collision with root package name */
        private j f3686d;

        /* renamed from: e reason: collision with root package name */
        private com.bumptech.glide.load.a.d.a<? super Data> f3687e;

        /* renamed from: f reason: collision with root package name */
        private List<Throwable> f3688f;

        /* renamed from: g reason: collision with root package name */
        private boolean f3689g;

        a(List<com.bumptech.glide.load.a.d<Data>> list, d<List<Throwable>> dVar) {
            this.f3684b = dVar;
            l.a(list);
            this.f3683a = list;
        }

        private void d() {
            if (!this.f3689g) {
                if (this.f3685c < this.f3683a.size() - 1) {
                    this.f3685c++;
                    a(this.f3686d, this.f3687e);
                } else {
                    l.a(this.f3688f);
                    this.f3687e.a((Exception) new GlideException("Fetch failed", (List<Throwable>) new ArrayList<Throwable>(this.f3688f)));
                }
            }
        }

        public void a(j jVar, com.bumptech.glide.load.a.d.a<? super Data> aVar) {
            this.f3686d = jVar;
            this.f3687e = aVar;
            this.f3688f = (List) this.f3684b.a();
            ((com.bumptech.glide.load.a.d) this.f3683a.get(this.f3685c)).a(jVar, this);
            if (this.f3689g) {
                cancel();
            }
        }

        public void b() {
            List<Throwable> list = this.f3688f;
            if (list != null) {
                this.f3684b.a(list);
            }
            this.f3688f = null;
            for (com.bumptech.glide.load.a.d b2 : this.f3683a) {
                b2.b();
            }
        }

        public com.bumptech.glide.load.a c() {
            return ((com.bumptech.glide.load.a.d) this.f3683a.get(0)).c();
        }

        public void cancel() {
            this.f3689g = true;
            for (com.bumptech.glide.load.a.d cancel : this.f3683a) {
                cancel.cancel();
            }
        }

        public Class<Data> a() {
            return ((com.bumptech.glide.load.a.d) this.f3683a.get(0)).a();
        }

        public void a(Data data) {
            if (data != null) {
                this.f3687e.a(data);
            } else {
                d();
            }
        }

        public void a(Exception exc) {
            List<Throwable> list = this.f3688f;
            l.a(list);
            list.add(exc);
            d();
        }
    }

    x(List<u<Model, Data>> list, d<List<Throwable>> dVar) {
        this.f3681a = list;
        this.f3682b = dVar;
    }

    public com.bumptech.glide.load.b.u.a<Data> a(Model model, int i2, int i3, i iVar) {
        int size = this.f3681a.size();
        ArrayList arrayList = new ArrayList(size);
        f fVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            u uVar = (u) this.f3681a.get(i4);
            if (uVar.a(model)) {
                com.bumptech.glide.load.b.u.a a2 = uVar.a(model, i2, i3, iVar);
                if (a2 != null) {
                    fVar = a2.f3674a;
                    arrayList.add(a2.f3676c);
                }
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new com.bumptech.glide.load.b.u.a<>(fVar, new a(arrayList, this.f3682b));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        sb.append(Arrays.toString(this.f3681a.toArray()));
        sb.append('}');
        return sb.toString();
    }

    public boolean a(Model model) {
        for (u a2 : this.f3681a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }
}
