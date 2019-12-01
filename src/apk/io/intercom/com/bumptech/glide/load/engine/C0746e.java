package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.g;
import java.security.MessageDigest;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.e reason: case insensitive filesystem */
/* compiled from: DataCacheKey */
final class C0746e implements g {

    /* renamed from: a reason: collision with root package name */
    private final g f9877a;

    /* renamed from: b reason: collision with root package name */
    private final g f9878b;

    C0746e(g gVar, g gVar2) {
        this.f9877a = gVar;
        this.f9878b = gVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0746e)) {
            return false;
        }
        C0746e eVar = (C0746e) obj;
        if (!this.f9877a.equals(eVar.f9877a) || !this.f9878b.equals(eVar.f9878b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f9877a.hashCode() * 31) + this.f9878b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataCacheKey{sourceKey=");
        sb.append(this.f9877a);
        sb.append(", signature=");
        sb.append(this.f9878b);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f9877a.updateDiskCacheKey(messageDigest);
        this.f9878b.updateDiskCacheKey(messageDigest);
    }
}
