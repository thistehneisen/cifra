package com.bumptech.glide.load.b;

import com.bumptech.glide.h.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader */
public interface u<Model, Data> {

    /* compiled from: ModelLoader */
    public static class a<Data> {

        /* renamed from: a reason: collision with root package name */
        public final f f3674a;

        /* renamed from: b reason: collision with root package name */
        public final List<f> f3675b;

        /* renamed from: c reason: collision with root package name */
        public final d<Data> f3676c;

        public a(f fVar, d<Data> dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(f fVar, List<f> list, d<Data> dVar) {
            l.a(fVar);
            this.f3674a = fVar;
            l.a(list);
            this.f3675b = list;
            l.a(dVar);
            this.f3676c = dVar;
        }
    }

    a<Data> a(Model model, int i2, int i3, i iVar);

    boolean a(Model model);
}
