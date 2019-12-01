package io.intercom.com.bumptech.glide.load;

import io.intercom.com.bumptech.glide.h.h;
import java.security.MessageDigest;

/* compiled from: Option */
public final class i<T> {

    /* renamed from: a reason: collision with root package name */
    private static final a<Object> f9989a = new h();

    /* renamed from: b reason: collision with root package name */
    private final T f9990b;

    /* renamed from: c reason: collision with root package name */
    private final a<T> f9991c;

    /* renamed from: d reason: collision with root package name */
    private final String f9992d;

    /* renamed from: e reason: collision with root package name */
    private volatile byte[] f9993e;

    /* compiled from: Option */
    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private i(String str, T t, a<T> aVar) {
        h.a(str);
        this.f9992d = str;
        this.f9990b = t;
        h.a(aVar);
        this.f9991c = aVar;
    }

    public static <T> i<T> a(String str) {
        return new i<>(str, null, b());
    }

    private static <T> a<T> b() {
        return f9989a;
    }

    private byte[] c() {
        if (this.f9993e == null) {
            this.f9993e = this.f9992d.getBytes(g.f9988a);
        }
        return this.f9993e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        return this.f9992d.equals(((i) obj).f9992d);
    }

    public int hashCode() {
        return this.f9992d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{key='");
        sb.append(this.f9992d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static <T> i<T> a(String str, T t) {
        return new i<>(str, t, b());
    }

    public static <T> i<T> a(String str, T t, a<T> aVar) {
        return new i<>(str, t, aVar);
    }

    public T a() {
        return this.f9990b;
    }

    public void a(T t, MessageDigest messageDigest) {
        this.f9991c.a(c(), t, messageDigest);
    }
}
