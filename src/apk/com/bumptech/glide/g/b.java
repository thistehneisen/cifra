package com.bumptech.glide.g;

import com.bumptech.glide.h.l;
import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: ObjectKey */
public final class b implements f {

    /* renamed from: a reason: collision with root package name */
    private final Object f3498a;

    public b(Object obj) {
        l.a(obj);
        this.f3498a = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f3498a.equals(((b) obj).f3498a);
    }

    public int hashCode() {
        return this.f3498a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectKey{object=");
        sb.append(this.f3498a);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f3498a.toString().getBytes(f.f4130a));
    }
}
