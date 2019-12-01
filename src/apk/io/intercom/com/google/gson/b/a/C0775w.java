package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: io.intercom.com.google.gson.b.a.w reason: case insensitive filesystem */
/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class C0775w<T> extends D<T> {

    /* renamed from: a reason: collision with root package name */
    private final o f10104a;

    /* renamed from: b reason: collision with root package name */
    private final D<T> f10105b;

    /* renamed from: c reason: collision with root package name */
    private final Type f10106c;

    C0775w(o oVar, D<T> d2, Type type) {
        this.f10104a = oVar;
        this.f10105b = d2;
        this.f10106c = type;
    }

    public T a(b bVar) throws IOException {
        return this.f10105b.a(bVar);
    }

    public void a(d dVar, T t) throws IOException {
        D<T> d2 = this.f10105b;
        Type a2 = a(this.f10106c, (Object) t);
        if (a2 != this.f10106c) {
            d2 = this.f10104a.a(a.a(a2));
            if (d2 instanceof C0769p.a) {
                D<T> d3 = this.f10105b;
                if (!(d3 instanceof C0769p.a)) {
                    d2 = d3;
                }
            }
        }
        d2.a(dVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }
}
