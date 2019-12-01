package io.intercom.com.google.gson.c;

import io.intercom.com.google.gson.b.C0753a;
import io.intercom.com.google.gson.b.C0779b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken */
public class a<T> {

    /* renamed from: a reason: collision with root package name */
    final Class<? super T> f10163a;

    /* renamed from: b reason: collision with root package name */
    final Type f10164b;

    /* renamed from: c reason: collision with root package name */
    final int f10165c;

    protected a() {
        this.f10164b = b(a.class);
        this.f10163a = C0779b.e(this.f10164b);
        this.f10165c = this.f10164b.hashCode();
    }

    static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C0779b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> a() {
        return this.f10163a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C0779b.a(this.f10164b, ((a) obj).f10164b);
    }

    public final int hashCode() {
        return this.f10165c;
    }

    public final String toString() {
        return C0779b.h(this.f10164b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    a(Type type) {
        C0753a.a(type);
        this.f10164b = C0779b.b(type);
        this.f10163a = C0779b.e(this.f10164b);
        this.f10165c = this.f10164b.hashCode();
    }

    public final Type b() {
        return this.f10164b;
    }
}
