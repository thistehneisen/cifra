package ru.touchin.roboswag.core.observables.storable;

import e.b.c.g;
import e.b.k;
import ru.touchin.roboswag.core.utils.ShouldNotHappenException;
import ru.touchin.roboswag.core.utils.b;

/* compiled from: NonNullStorable */
public class i<TKey, TObject, TStoreObject> extends h<TKey, TObject, TStoreObject, TObject> {

    /* compiled from: NonNullStorable */
    public static class a<TKey, TObject, TStoreObject> extends ru.touchin.roboswag.core.observables.storable.h.a<TKey, TObject, TStoreObject> {
        public a(k<TKey, TObject, TStoreObject> kVar, TObject tobject) {
            super(kVar);
            if (tobject != null) {
                a(tobject);
                return;
            }
            throw new ShouldNotHappenException();
        }

        public i<TKey, TObject, TStoreObject> b() {
            if (a() != null) {
                return new i<>(this);
            }
            throw new ShouldNotHappenException();
        }
    }

    public i(a<TKey, TObject, TStoreObject> aVar) {
        super(aVar);
    }

    static /* synthetic */ Object b(b bVar) throws Exception {
        if (bVar.a() != null) {
            return bVar.a();
        }
        throw new ShouldNotHappenException();
    }

    public k<TObject> c() {
        return d().b((g<? super T, ? extends R>) g.f11146a);
    }
}
