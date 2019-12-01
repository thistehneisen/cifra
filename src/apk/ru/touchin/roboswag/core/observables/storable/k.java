package ru.touchin.roboswag.core.observables.storable;

import java.lang.reflect.Type;
import ru.touchin.roboswag.core.observables.storable.h.a;

/* compiled from: Storable */
public class k<TKey, TObject, TStoreObject> extends a<TKey, TObject, TStoreObject> {
    public k(TKey tkey, Type type, Type type2, l<TKey, TStoreObject> lVar, Converter<TObject, TStoreObject> converter) {
        super(tkey, type, type2, lVar, converter);
    }

    public i.a<TKey, TObject, TStoreObject> b(TObject tobject) {
        return new i.a<>(this, tobject);
    }
}
