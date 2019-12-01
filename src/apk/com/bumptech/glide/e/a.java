package com.bumptech.glide.e;

import com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry */
public class a {

    /* renamed from: a reason: collision with root package name */
    private final List<C0045a<?>> f3401a = new ArrayList();

    /* renamed from: com.bumptech.glide.e.a$a reason: collision with other inner class name */
    /* compiled from: EncoderRegistry */
    private static final class C0045a<T> {

        /* renamed from: a reason: collision with root package name */
        private final Class<T> f3402a;

        /* renamed from: b reason: collision with root package name */
        final d<T> f3403b;

        C0045a(Class<T> cls, d<T> dVar) {
            this.f3402a = cls;
            this.f3403b = dVar;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(Class<?> cls) {
            return this.f3402a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> d<T> a(Class<T> cls) {
        for (C0045a aVar : this.f3401a) {
            if (aVar.a(cls)) {
                return aVar.f3403b;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f3401a.add(new C0045a(cls, dVar));
    }
}
