package io.intercom.com.bumptech.glide.e;

import io.intercom.com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry */
public class f {

    /* renamed from: a reason: collision with root package name */
    private final List<a<?>> f9291a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry */
    private static final class a<T> {

        /* renamed from: a reason: collision with root package name */
        private final Class<T> f9292a;

        /* renamed from: b reason: collision with root package name */
        final l<T> f9293b;

        a(Class<T> cls, l<T> lVar) {
            this.f9292a = cls;
            this.f9293b = lVar;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(Class<?> cls) {
            return this.f9292a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, l<Z> lVar) {
        this.f9291a.add(new a(cls, lVar));
    }

    public synchronized <Z> l<Z> a(Class<Z> cls) {
        int size = this.f9291a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.f9291a.get(i2);
            if (aVar.a(cls)) {
                return aVar.f9293b;
            }
        }
        return null;
    }
}
