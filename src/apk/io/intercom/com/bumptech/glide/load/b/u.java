package io.intercom.com.bumptech.glide.load.b;

import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.a.b;
import io.intercom.com.bumptech.glide.load.g;
import io.intercom.com.bumptech.glide.load.j;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader */
public interface u<Model, Data> {

    /* compiled from: ModelLoader */
    public static class a<Data> {

        /* renamed from: a reason: collision with root package name */
        public final g f9544a;

        /* renamed from: b reason: collision with root package name */
        public final List<g> f9545b;

        /* renamed from: c reason: collision with root package name */
        public final b<Data> f9546c;

        public a(g gVar, b<Data> bVar) {
            this(gVar, Collections.emptyList(), bVar);
        }

        public a(g gVar, List<g> list, b<Data> bVar) {
            h.a(gVar);
            this.f9544a = gVar;
            h.a(list);
            this.f9545b = list;
            h.a(bVar);
            this.f9546c = bVar;
        }
    }

    a<Data> a(Model model, int i2, int i3, j jVar);

    boolean a(Model model);
}
