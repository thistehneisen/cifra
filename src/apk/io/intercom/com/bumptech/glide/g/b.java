package io.intercom.com.bumptech.glide.g;

import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.g;
import java.security.MessageDigest;

/* compiled from: ObjectKey */
public final class b implements g {

    /* renamed from: a reason: collision with root package name */
    private final Object f9374a;

    public b(Object obj) {
        h.a(obj);
        this.f9374a = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f9374a.equals(((b) obj).f9374a);
    }

    public int hashCode() {
        return this.f9374a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectKey{object=");
        sb.append(this.f9374a);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f9374a.toString().getBytes(g.f9988a));
    }
}
