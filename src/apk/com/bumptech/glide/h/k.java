package com.bumptech.glide.h;

/* compiled from: MultiClassKey */
public class k {

    /* renamed from: a reason: collision with root package name */
    private Class<?> f3529a;

    /* renamed from: b reason: collision with root package name */
    private Class<?> f3530b;

    /* renamed from: c reason: collision with root package name */
    private Class<?> f3531c;

    public k() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f3529a = cls;
        this.f3530b = cls2;
        this.f3531c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f3529a.equals(kVar.f3529a) && this.f3530b.equals(kVar.f3530b) && n.b((Object) this.f3531c, (Object) kVar.f3531c);
    }

    public int hashCode() {
        int hashCode = ((this.f3529a.hashCode() * 31) + this.f3530b.hashCode()) * 31;
        Class<?> cls = this.f3531c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiClassKey{first=");
        sb.append(this.f3529a);
        sb.append(", second=");
        sb.append(this.f3530b);
        sb.append('}');
        return sb.toString();
    }

    public k(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
