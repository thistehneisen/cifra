package io.fabric.sdk.android.a.b;

/* renamed from: io.fabric.sdk.android.a.b.b reason: case insensitive filesystem */
/* compiled from: AdvertisingInfo */
class C0731b {

    /* renamed from: a reason: collision with root package name */
    public final String f8807a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f8808b;

    C0731b(String str, boolean z) {
        this.f8807a = str;
        this.f8808b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0731b.class != obj.getClass()) {
            return false;
        }
        C0731b bVar = (C0731b) obj;
        if (this.f8808b != bVar.f8808b) {
            return false;
        }
        String str = this.f8807a;
        return str == null ? bVar.f8807a == null : str.equals(bVar.f8807a);
    }

    public int hashCode() {
        String str = this.f8807a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f8808b ? 1 : 0);
    }
}
