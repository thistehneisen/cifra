package com.bumptech.glide.load.c.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TranscoderRegistry */
public class f {

    /* renamed from: a reason: collision with root package name */
    private final List<a<?, ?>> f3844a = new ArrayList();

    /* compiled from: TranscoderRegistry */
    private static final class a<Z, R> {

        /* renamed from: a reason: collision with root package name */
        private final Class<Z> f3845a;

        /* renamed from: b reason: collision with root package name */
        private final Class<R> f3846b;

        /* renamed from: c reason: collision with root package name */
        final e<Z, R> f3847c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f3845a = cls;
            this.f3846b = cls2;
            this.f3847c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f3845a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f3846b);
        }
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f3844a.add(new a(cls, cls2, eVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a a2 : this.f3844a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a aVar : this.f3844a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f3847c;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No transcoder registered to transcode from ");
        sb.append(cls);
        sb.append(" to ");
        sb.append(cls2);
        throw new IllegalArgumentException(sb.toString());
    }
}
