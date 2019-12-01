package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.g;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.m;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey */
class w implements g {

    /* renamed from: a reason: collision with root package name */
    private final Object f9972a;

    /* renamed from: b reason: collision with root package name */
    private final int f9973b;

    /* renamed from: c reason: collision with root package name */
    private final int f9974c;

    /* renamed from: d reason: collision with root package name */
    private final Class<?> f9975d;

    /* renamed from: e reason: collision with root package name */
    private final Class<?> f9976e;

    /* renamed from: f reason: collision with root package name */
    private final g f9977f;

    /* renamed from: g reason: collision with root package name */
    private final Map<Class<?>, m<?>> f9978g;

    /* renamed from: h reason: collision with root package name */
    private final j f9979h;

    /* renamed from: i reason: collision with root package name */
    private int f9980i;

    w(Object obj, g gVar, int i2, int i3, Map<Class<?>, m<?>> map, Class<?> cls, Class<?> cls2, j jVar) {
        h.a(obj);
        this.f9972a = obj;
        h.a(gVar, "Signature must not be null");
        this.f9977f = gVar;
        this.f9973b = i2;
        this.f9974c = i3;
        h.a(map);
        this.f9978g = map;
        h.a(cls, "Resource class must not be null");
        this.f9975d = cls;
        h.a(cls2, "Transcode class must not be null");
        this.f9976e = cls2;
        h.a(jVar);
        this.f9979h = jVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (!this.f9972a.equals(wVar.f9972a) || !this.f9977f.equals(wVar.f9977f) || this.f9974c != wVar.f9974c || this.f9973b != wVar.f9973b || !this.f9978g.equals(wVar.f9978g) || !this.f9975d.equals(wVar.f9975d) || !this.f9976e.equals(wVar.f9976e) || !this.f9979h.equals(wVar.f9979h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f9980i == 0) {
            this.f9980i = this.f9972a.hashCode();
            this.f9980i = (this.f9980i * 31) + this.f9977f.hashCode();
            this.f9980i = (this.f9980i * 31) + this.f9973b;
            this.f9980i = (this.f9980i * 31) + this.f9974c;
            this.f9980i = (this.f9980i * 31) + this.f9978g.hashCode();
            this.f9980i = (this.f9980i * 31) + this.f9975d.hashCode();
            this.f9980i = (this.f9980i * 31) + this.f9976e.hashCode();
            this.f9980i = (this.f9980i * 31) + this.f9979h.hashCode();
        }
        return this.f9980i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.f9972a);
        sb.append(", width=");
        sb.append(this.f9973b);
        sb.append(", height=");
        sb.append(this.f9974c);
        sb.append(", resourceClass=");
        sb.append(this.f9975d);
        sb.append(", transcodeClass=");
        sb.append(this.f9976e);
        sb.append(", signature=");
        sb.append(this.f9977f);
        sb.append(", hashCode=");
        sb.append(this.f9980i);
        sb.append(", transformations=");
        sb.append(this.f9978g);
        sb.append(", options=");
        sb.append(this.f9979h);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
