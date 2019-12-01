package kotlin.e.b;

/* compiled from: PackageReference.kt */
public final class j implements b {

    /* renamed from: a reason: collision with root package name */
    private final Class<?> f10306a;

    /* renamed from: b reason: collision with root package name */
    private final String f10307b;

    public j(Class<?> cls, String str) {
        h.b(cls, "jClass");
        h.b(str, "moduleName");
        this.f10306a = cls;
        this.f10307b = str;
    }

    public Class<?> a() {
        return this.f10306a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && h.a((Object) a(), (Object) ((j) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a().toString());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
