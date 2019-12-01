package com.google.firebase.c;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
final class a extends e {

    /* renamed from: a reason: collision with root package name */
    private final String f6675a;

    /* renamed from: b reason: collision with root package name */
    private final String f6676b;

    a(String str, String str2) {
        if (str != null) {
            this.f6675a = str;
            if (str2 != null) {
                this.f6676b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String a() {
        return this.f6675a;
    }

    public String b() {
        return this.f6676b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f6675a.equals(eVar.a()) || !this.f6676b.equals(eVar.b())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.f6675a.hashCode() ^ 1000003) * 1000003) ^ this.f6676b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LibraryVersion{libraryName=");
        sb.append(this.f6675a);
        sb.append(", version=");
        sb.append(this.f6676b);
        sb.append("}");
        return sb.toString();
    }
}
