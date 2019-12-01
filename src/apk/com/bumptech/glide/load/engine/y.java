package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey */
class y implements f {

    /* renamed from: a reason: collision with root package name */
    private final Object f4121a;

    /* renamed from: b reason: collision with root package name */
    private final int f4122b;

    /* renamed from: c reason: collision with root package name */
    private final int f4123c;

    /* renamed from: d reason: collision with root package name */
    private final Class<?> f4124d;

    /* renamed from: e reason: collision with root package name */
    private final Class<?> f4125e;

    /* renamed from: f reason: collision with root package name */
    private final f f4126f;

    /* renamed from: g reason: collision with root package name */
    private final Map<Class<?>, l<?>> f4127g;

    /* renamed from: h reason: collision with root package name */
    private final i f4128h;

    /* renamed from: i reason: collision with root package name */
    private int f4129i;

    y(Object obj, f fVar, int i2, int i3, Map<Class<?>, l<?>> map, Class<?> cls, Class<?> cls2, i iVar) {
        com.bumptech.glide.h.l.a(obj);
        this.f4121a = obj;
        com.bumptech.glide.h.l.a(fVar, "Signature must not be null");
        this.f4126f = fVar;
        this.f4122b = i2;
        this.f4123c = i3;
        com.bumptech.glide.h.l.a(map);
        this.f4127g = map;
        com.bumptech.glide.h.l.a(cls, "Resource class must not be null");
        this.f4124d = cls;
        com.bumptech.glide.h.l.a(cls2, "Transcode class must not be null");
        this.f4125e = cls2;
        com.bumptech.glide.h.l.a(iVar);
        this.f4128h = iVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (!this.f4121a.equals(yVar.f4121a) || !this.f4126f.equals(yVar.f4126f) || this.f4123c != yVar.f4123c || this.f4122b != yVar.f4122b || !this.f4127g.equals(yVar.f4127g) || !this.f4124d.equals(yVar.f4124d) || !this.f4125e.equals(yVar.f4125e) || !this.f4128h.equals(yVar.f4128h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f4129i == 0) {
            this.f4129i = this.f4121a.hashCode();
            this.f4129i = (this.f4129i * 31) + this.f4126f.hashCode();
            this.f4129i = (this.f4129i * 31) + this.f4122b;
            this.f4129i = (this.f4129i * 31) + this.f4123c;
            this.f4129i = (this.f4129i * 31) + this.f4127g.hashCode();
            this.f4129i = (this.f4129i * 31) + this.f4124d.hashCode();
            this.f4129i = (this.f4129i * 31) + this.f4125e.hashCode();
            this.f4129i = (this.f4129i * 31) + this.f4128h.hashCode();
        }
        return this.f4129i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.f4121a);
        sb.append(", width=");
        sb.append(this.f4122b);
        sb.append(", height=");
        sb.append(this.f4123c);
        sb.append(", resourceClass=");
        sb.append(this.f4124d);
        sb.append(", transcodeClass=");
        sb.append(this.f4125e);
        sb.append(", signature=");
        sb.append(this.f4126f);
        sb.append(", hashCode=");
        sb.append(this.f4129i);
        sb.append(", transformations=");
        sb.append(this.f4127g);
        sb.append(", options=");
        sb.append(this.f4128h);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
