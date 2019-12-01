package io.intercom.com.bumptech.glide.load.c.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TranscoderRegistry */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final List<a<?, ?>> f9704a = new ArrayList();

    /* compiled from: TranscoderRegistry */
    private static final class a<Z, R> {

        /* renamed from: a reason: collision with root package name */
        private final Class<Z> f9705a;

        /* renamed from: b reason: collision with root package name */
        private final Class<R> f9706b;

        /* renamed from: c reason: collision with root package name */
        final d<Z, R> f9707c;

        a(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
            this.f9705a = cls;
            this.f9706b = cls2;
            this.f9707c = dVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f9705a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f9706b);
        }
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
        this.f9704a.add(new a(cls, cls2, dVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a a2 : this.f9704a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> d<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return f.a();
        }
        for (a aVar : this.f9704a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f9707c;
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
