package com.bumptech.glide.load;

import b.d.b;
import java.security.MessageDigest;

/* compiled from: Options */
public final class i implements f {

    /* renamed from: a reason: collision with root package name */
    private final b<h<?>, Object> f4136a = new com.bumptech.glide.h.b();

    public void a(i iVar) {
        this.f4136a.a((b.d.i<? extends K, ? extends V>) iVar.f4136a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        return this.f4136a.equals(((i) obj).f4136a);
    }

    public int hashCode() {
        return this.f4136a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Options{values=");
        sb.append(this.f4136a);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f4136a.size(); i2++) {
            a((h) this.f4136a.b(i2), this.f4136a.d(i2), messageDigest);
        }
    }

    public <T> i a(h<T> hVar, T t) {
        this.f4136a.put(hVar, t);
        return this;
    }

    public <T> T a(h<T> hVar) {
        return this.f4136a.containsKey(hVar) ? this.f4136a.get(hVar) : hVar.a();
    }

    private static <T> void a(h<T> hVar, Object obj, MessageDigest messageDigest) {
        hVar.a(obj, messageDigest);
    }
}
