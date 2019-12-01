package com.bumptech.glide.e;

import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry */
public class f {

    /* renamed from: a reason: collision with root package name */
    private final List<a<?>> f3415a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry */
    private static final class a<T> {

        /* renamed from: a reason: collision with root package name */
        private final Class<T> f3416a;

        /* renamed from: b reason: collision with root package name */
        final k<T> f3417b;

        a(Class<T> cls, k<T> kVar) {
            this.f3416a = cls;
            this.f3417b = kVar;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(Class<?> cls) {
            return this.f3416a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, k<Z> kVar) {
        this.f3415a.add(new a(cls, kVar));
    }

    public synchronized <Z> k<Z> a(Class<Z> cls) {
        int size = this.f3415a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.f3415a.get(i2);
            if (aVar.a(cls)) {
                return aVar.f3417b;
            }
        }
        return null;
    }
}
