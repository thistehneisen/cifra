package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.g reason: case insensitive filesystem */
/* compiled from: DataCacheKey */
final class C0293g implements f {

    /* renamed from: a reason: collision with root package name */
    private final f f4016a;

    /* renamed from: b reason: collision with root package name */
    private final f f4017b;

    C0293g(f fVar, f fVar2) {
        this.f4016a = fVar;
        this.f4017b = fVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0293g)) {
            return false;
        }
        C0293g gVar = (C0293g) obj;
        if (!this.f4016a.equals(gVar.f4016a) || !this.f4017b.equals(gVar.f4017b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f4016a.hashCode() * 31) + this.f4017b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataCacheKey{sourceKey=");
        sb.append(this.f4016a);
        sb.append(", signature=");
        sb.append(this.f4017b);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f4016a.updateDiskCacheKey(messageDigest);
        this.f4017b.updateDiskCacheKey(messageDigest);
    }
}
