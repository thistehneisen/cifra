package io.intercom.com.google.gson.b;

import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.p;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: ConstructorConstructor */
public final class q {

    /* renamed from: a reason: collision with root package name */
    private final Map<Type, p<?>> f10131a;

    public q(Map<Type, p<?>> map) {
        this.f10131a = map;
    }

    private <T> z<T> b(Type type, Class<? super T> cls) {
        return new C0784g(this, cls, type);
    }

    public <T> z<T> a(a<T> aVar) {
        Type b2 = aVar.b();
        Class a2 = aVar.a();
        p pVar = (p) this.f10131a.get(b2);
        if (pVar != null) {
            return new h(this, pVar, b2);
        }
        p pVar2 = (p) this.f10131a.get(a2);
        if (pVar2 != null) {
            return new i(this, pVar2, b2);
        }
        z<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        z<T> a4 = a(b2, a2);
        if (a4 != null) {
            return a4;
        }
        return b(b2, a2);
    }

    public String toString() {
        return this.f10131a.toString();
    }

    private <T> z<T> a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new j(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> z<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new l(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new m(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new n(this);
            }
            return new o(this);
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new p(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new C0780c(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C0781d(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) {
                return new C0783f(this);
            }
            return new C0782e(this);
        }
    }
}
