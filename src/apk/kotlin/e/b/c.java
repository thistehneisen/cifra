package kotlin.e.b;

import kotlin.e.a;

/* compiled from: ClassReference.kt */
public final class c implements kotlin.g.c<Object>, b {

    /* renamed from: a reason: collision with root package name */
    private final Class<?> f10304a;

    public c(Class<?> cls) {
        h.b(cls, "jClass");
        this.f10304a = cls;
    }

    public Class<?> a() {
        return this.f10304a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && h.a((Object) a.a(this), (Object) a.a((kotlin.g.c) obj));
    }

    public int hashCode() {
        return a.a(this).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a().toString());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
