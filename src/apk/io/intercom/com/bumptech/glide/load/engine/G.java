package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.h.e;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.g;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.m;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey */
final class G implements g {

    /* renamed from: a reason: collision with root package name */
    private static final e<Class<?>, byte[]> f9739a = new e<>(50);

    /* renamed from: b reason: collision with root package name */
    private final b f9740b;

    /* renamed from: c reason: collision with root package name */
    private final g f9741c;

    /* renamed from: d reason: collision with root package name */
    private final g f9742d;

    /* renamed from: e reason: collision with root package name */
    private final int f9743e;

    /* renamed from: f reason: collision with root package name */
    private final int f9744f;

    /* renamed from: g reason: collision with root package name */
    private final Class<?> f9745g;

    /* renamed from: h reason: collision with root package name */
    private final j f9746h;

    /* renamed from: i reason: collision with root package name */
    private final m<?> f9747i;

    G(b bVar, g gVar, g gVar2, int i2, int i3, m<?> mVar, Class<?> cls, j jVar) {
        this.f9740b = bVar;
        this.f9741c = gVar;
        this.f9742d = gVar2;
        this.f9743e = i2;
        this.f9744f = i3;
        this.f9747i = mVar;
        this.f9745g = cls;
        this.f9746h = jVar;
    }

    private byte[] a() {
        byte[] bArr = (byte[]) f9739a.a(this.f9745g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f9745g.getName().getBytes(g.f9988a);
        f9739a.b(this.f9745g, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof G)) {
            return false;
        }
        G g2 = (G) obj;
        if (this.f9744f != g2.f9744f || this.f9743e != g2.f9743e || !io.intercom.com.bumptech.glide.h.j.b((Object) this.f9747i, (Object) g2.f9747i) || !this.f9745g.equals(g2.f9745g) || !this.f9741c.equals(g2.f9741c) || !this.f9742d.equals(g2.f9742d) || !this.f9746h.equals(g2.f9746h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f9741c.hashCode() * 31) + this.f9742d.hashCode()) * 31) + this.f9743e) * 31) + this.f9744f;
        m<?> mVar = this.f9747i;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return (((hashCode * 31) + this.f9745g.hashCode()) * 31) + this.f9746h.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.f9741c);
        sb.append(", signature=");
        sb.append(this.f9742d);
        sb.append(", width=");
        sb.append(this.f9743e);
        sb.append(", height=");
        sb.append(this.f9744f);
        sb.append(", decodedResourceClass=");
        sb.append(this.f9745g);
        sb.append(", transformation='");
        sb.append(this.f9747i);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.f9746h);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f9740b.a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f9743e).putInt(this.f9744f).array();
        this.f9742d.updateDiskCacheKey(messageDigest);
        this.f9741c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        m<?> mVar = this.f9747i;
        if (mVar != null) {
            mVar.updateDiskCacheKey(messageDigest);
        }
        this.f9746h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f9740b.put(bArr);
    }
}
