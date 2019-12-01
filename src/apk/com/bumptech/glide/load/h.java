package com.bumptech.glide.load;

import com.bumptech.glide.h.l;
import java.security.MessageDigest;

/* compiled from: Option */
public final class h<T> {

    /* renamed from: a reason: collision with root package name */
    private static final a<Object> f4131a = new g();

    /* renamed from: b reason: collision with root package name */
    private final T f4132b;

    /* renamed from: c reason: collision with root package name */
    private final a<T> f4133c;

    /* renamed from: d reason: collision with root package name */
    private final String f4134d;

    /* renamed from: e reason: collision with root package name */
    private volatile byte[] f4135e;

    /* compiled from: Option */
    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private h(String str, T t, a<T> aVar) {
        l.a(str);
        this.f4134d = str;
        this.f4132b = t;
        l.a(aVar);
        this.f4133c = aVar;
    }

    public static <T> h<T> a(String str) {
        return new h<>(str, null, b());
    }

    private static <T> a<T> b() {
        return f4131a;
    }

    private byte[] c() {
        if (this.f4135e == null) {
            this.f4135e = this.f4134d.getBytes(f.f4130a);
        }
        return this.f4135e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f4134d.equals(((h) obj).f4134d);
    }

    public int hashCode() {
        return this.f4134d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{key='");
        sb.append(this.f4134d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static <T> h<T> a(String str, T t) {
        return new h<>(str, t, b());
    }

    public static <T> h<T> a(String str, T t, a<T> aVar) {
        return new h<>(str, t, aVar);
    }

    public T a() {
        return this.f4132b;
    }

    public void a(T t, MessageDigest messageDigest) {
        this.f4133c.a(c(), t, messageDigest);
    }
}
