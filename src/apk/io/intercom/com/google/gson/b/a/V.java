package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;

/* compiled from: TypeAdapters */
class V implements E {
    V() {
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        Class<Enum> a2 = aVar.a();
        if (!Enum.class.isAssignableFrom(a2) || a2 == Enum.class) {
            return null;
        }
        if (!a2.isEnum()) {
            a2 = a2.getSuperclass();
        }
        return new a(a2);
    }
}
