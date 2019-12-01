package io.intercom.com.bumptech.glide.load;

import b.d.b;
import b.d.i;
import java.security.MessageDigest;

/* compiled from: Options */
public final class j implements g {

    /* renamed from: a reason: collision with root package name */
    private final b<i<?>, Object> f9994a = new b<>();

    public void a(j jVar) {
        this.f9994a.a((i<? extends K, ? extends V>) jVar.f9994a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        return this.f9994a.equals(((j) obj).f9994a);
    }

    public int hashCode() {
        return this.f9994a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Options{values=");
        sb.append(this.f9994a);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f9994a.size(); i2++) {
            a((i) this.f9994a.b(i2), this.f9994a.d(i2), messageDigest);
        }
    }

    public <T> j a(i<T> iVar, T t) {
        this.f9994a.put(iVar, t);
        return this;
    }

    public <T> T a(i<T> iVar) {
        return this.f9994a.containsKey(iVar) ? this.f9994a.get(iVar) : iVar.a();
    }

    private static <T> void a(i<T> iVar, Object obj, MessageDigest messageDigest) {
        iVar.a(obj, messageDigest);
    }
}
