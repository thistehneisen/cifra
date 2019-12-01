package io.intercom.com.bumptech.glide.e;

import io.intercom.com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry */
public class a {

    /* renamed from: a reason: collision with root package name */
    private final List<C0101a<?>> f9278a = new ArrayList();

    /* renamed from: io.intercom.com.bumptech.glide.e.a$a reason: collision with other inner class name */
    /* compiled from: EncoderRegistry */
    private static final class C0101a<T> {

        /* renamed from: a reason: collision with root package name */
        private final Class<T> f9279a;

        /* renamed from: b reason: collision with root package name */
        final d<T> f9280b;

        C0101a(Class<T> cls, d<T> dVar) {
            this.f9279a = cls;
            this.f9280b = dVar;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(Class<?> cls) {
            return this.f9279a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> d<T> a(Class<T> cls) {
        for (C0101a aVar : this.f9278a) {
            if (aVar.a(cls)) {
                return aVar.f9280b;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f9278a.add(new C0101a(cls, dVar));
    }
}
