package io.intercom.com.google.gson.b;

import io.intercom.com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* compiled from: ConstructorConstructor */
class l implements z<T> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Type f10125a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ q f10126b;

    l(q qVar, Type type) {
        this.f10126b = qVar;
        this.f10125a = type;
    }

    public T a() {
        Type type = this.f10125a;
        String str = "Invalid EnumSet type: ";
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f10125a.toString());
            throw new JsonIOException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f10125a.toString());
        throw new JsonIOException(sb2.toString());
    }
}
