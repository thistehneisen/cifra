package ru.touchin.roboswag.core.observables.storable;

import e.b.b;
import e.b.o;
import java.lang.reflect.Type;

/* compiled from: Store */
public interface l<TKey, TStoreObject> {
    b a(Type type, TKey tkey, TStoreObject tstoreobject);

    o<ru.touchin.roboswag.core.utils.b<TStoreObject>> a(Type type, TKey tkey);
}
