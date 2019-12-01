package org.joda.time.e;

/* compiled from: InternalParserDateTimeParser */
class l implements d, k {

    /* renamed from: a reason: collision with root package name */
    private final k f10910a;

    private l(k kVar) {
        this.f10910a = kVar;
    }

    static d a(k kVar) {
        if (kVar instanceof f) {
            return ((f) kVar).b();
        }
        if (kVar instanceof d) {
            return (d) kVar;
        }
        if (kVar == null) {
            return null;
        }
        return new l(kVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        return this.f10910a.equals(((l) obj).f10910a);
    }

    public int a() {
        return this.f10910a.a();
    }

    public int a(e eVar, CharSequence charSequence, int i2) {
        return this.f10910a.a(eVar, charSequence, i2);
    }

    public int a(e eVar, String str, int i2) {
        return this.f10910a.a(eVar, str, i2);
    }
}
