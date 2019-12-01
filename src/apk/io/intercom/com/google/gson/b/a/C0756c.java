package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.b.C0779b;
import io.intercom.com.google.gson.b.q;
import io.intercom.com.google.gson.b.z;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: io.intercom.com.google.gson.b.a.c reason: case insensitive filesystem */
/* compiled from: CollectionTypeAdapterFactory */
public final class C0756c implements E {

    /* renamed from: a reason: collision with root package name */
    private final q f10045a;

    /* renamed from: io.intercom.com.google.gson.b.a.c$a */
    /* compiled from: CollectionTypeAdapterFactory */
    private static final class a<E> extends D<Collection<E>> {

        /* renamed from: a reason: collision with root package name */
        private final D<E> f10046a;

        /* renamed from: b reason: collision with root package name */
        private final z<? extends Collection<E>> f10047b;

        public a(o oVar, Type type, D<E> d2, z<? extends Collection<E>> zVar) {
            this.f10046a = new C0775w(oVar, d2, type);
            this.f10047b = zVar;
        }

        public Collection<E> a(b bVar) throws IOException {
            if (bVar.G() == c.NULL) {
                bVar.E();
                return null;
            }
            Collection<E> collection = (Collection) this.f10047b.a();
            bVar.a();
            while (bVar.g()) {
                collection.add(this.f10046a.a(bVar));
            }
            bVar.d();
            return collection;
        }

        public void a(d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.h();
                return;
            }
            dVar.a();
            for (E a2 : collection) {
                this.f10046a.a(dVar, a2);
            }
            dVar.c();
        }
    }

    public C0756c(q qVar) {
        this.f10045a = qVar;
    }

    public <T> D<T> a(o oVar, io.intercom.com.google.gson.c.a<T> aVar) {
        Type b2 = aVar.b();
        Class a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = C0779b.a(b2, a2);
        return new a(oVar, a3, oVar.a(io.intercom.com.google.gson.c.a.a(a3)), this.f10045a.a(aVar));
    }
}
