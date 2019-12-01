package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.b.C0779b;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: io.intercom.com.google.gson.b.a.a reason: case insensitive filesystem */
/* compiled from: ArrayTypeAdapter */
class C0754a implements E {
    C0754a() {
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        Type b2 = aVar.b();
        if (!(b2 instanceof GenericArrayType) && (!(b2 instanceof Class) || !((Class) b2).isArray())) {
            return null;
        }
        Type d2 = C0779b.d(b2);
        return new C0755b(oVar, oVar.a(a.a(d2)), C0779b.e(d2));
    }
}
