package io.intercom.com.bumptech.glide.h;

/* compiled from: MultiClassKey */
public class g {

    /* renamed from: a reason: collision with root package name */
    private Class<?> f9402a;

    /* renamed from: b reason: collision with root package name */
    private Class<?> f9403b;

    /* renamed from: c reason: collision with root package name */
    private Class<?> f9404c;

    public g() {
    }

    public void a(Class<?> cls, Class<?> cls2) {
        a(cls, cls2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f9402a.equals(gVar.f9402a) && this.f9403b.equals(gVar.f9403b) && j.b((Object) this.f9404c, (Object) gVar.f9404c);
    }

    public int hashCode() {
        int hashCode = ((this.f9402a.hashCode() * 31) + this.f9403b.hashCode()) * 31;
        Class<?> cls = this.f9404c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiClassKey{first=");
        sb.append(this.f9402a);
        sb.append(", second=");
        sb.append(this.f9403b);
        sb.append('}');
        return sb.toString();
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f9402a = cls;
        this.f9403b = cls2;
        this.f9404c = cls3;
    }

    public g(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
