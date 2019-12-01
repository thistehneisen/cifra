package com.bumptech.glide.load.engine;

import com.bumptech.glide.h.i;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey */
final class I implements f {

    /* renamed from: a reason: collision with root package name */
    private static final i<Class<?>, byte[]> f3880a = new i<>(50);

    /* renamed from: b reason: collision with root package name */
    private final b f3881b;

    /* renamed from: c reason: collision with root package name */
    private final f f3882c;

    /* renamed from: d reason: collision with root package name */
    private final f f3883d;

    /* renamed from: e reason: collision with root package name */
    private final int f3884e;

    /* renamed from: f reason: collision with root package name */
    private final int f3885f;

    /* renamed from: g reason: collision with root package name */
    private final Class<?> f3886g;

    /* renamed from: h reason: collision with root package name */
    private final com.bumptech.glide.load.i f3887h;

    /* renamed from: i reason: collision with root package name */
    private final l<?> f3888i;

    I(b bVar, f fVar, f fVar2, int i2, int i3, l<?> lVar, Class<?> cls, com.bumptech.glide.load.i iVar) {
        this.f3881b = bVar;
        this.f3882c = fVar;
        this.f3883d = fVar2;
        this.f3884e = i2;
        this.f3885f = i3;
        this.f3888i = lVar;
        this.f3886g = cls;
        this.f3887h = iVar;
    }

    private byte[] a() {
        byte[] bArr = (byte[]) f3880a.a(this.f3886g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f3886g.getName().getBytes(f.f4130a);
        f3880a.b(this.f3886g, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof I)) {
            return false;
        }
        I i2 = (I) obj;
        if (this.f3885f != i2.f3885f || this.f3884e != i2.f3884e || !n.b((Object) this.f3888i, (Object) i2.f3888i) || !this.f3886g.equals(i2.f3886g) || !this.f3882c.equals(i2.f3882c) || !this.f3883d.equals(i2.f3883d) || !this.f3887h.equals(i2.f3887h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f3882c.hashCode() * 31) + this.f3883d.hashCode()) * 31) + this.f3884e) * 31) + this.f3885f;
        l<?> lVar = this.f3888i;
        if (lVar != null) {
            hashCode = (hashCode * 31) + lVar.hashCode();
        }
        return (((hashCode * 31) + this.f3886g.hashCode()) * 31) + this.f3887h.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.f3882c);
        sb.append(", signature=");
        sb.append(this.f3883d);
        sb.append(", width=");
        sb.append(this.f3884e);
        sb.append(", height=");
        sb.append(this.f3885f);
        sb.append(", decodedResourceClass=");
        sb.append(this.f3886g);
        sb.append(", transformation='");
        sb.append(this.f3888i);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.f3887h);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f3881b.a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f3884e).putInt(this.f3885f).array();
        this.f3883d.updateDiskCacheKey(messageDigest);
        this.f3882c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        l<?> lVar = this.f3888i;
        if (lVar != null) {
            lVar.updateDiskCacheKey(messageDigest);
        }
        this.f3887h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f3881b.put(bArr);
    }
}
