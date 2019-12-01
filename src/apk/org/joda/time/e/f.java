package org.joda.time.e;

/* compiled from: DateTimeParserInternalParser */
class f implements k {

    /* renamed from: a reason: collision with root package name */
    private final d f10895a;

    private f(d dVar) {
        this.f10895a = dVar;
    }

    static k a(d dVar) {
        if (dVar instanceof l) {
            return (k) dVar;
        }
        if (dVar == null) {
            return null;
        }
        return new f(dVar);
    }

    /* access modifiers changed from: 0000 */
    public d b() {
        return this.f10895a;
    }

    public int a() {
        return this.f10895a.a();
    }

    public int a(e eVar, CharSequence charSequence, int i2) {
        return this.f10895a.a(eVar, charSequence.toString(), i2);
    }
}
