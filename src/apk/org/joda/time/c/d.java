package org.joda.time.c;

/* compiled from: ConverterManager */
public final class d {

    /* renamed from: a reason: collision with root package name */
    private static d f10769a;

    /* renamed from: b reason: collision with root package name */
    private e f10770b = new e(new c[]{o.f10783a, s.f10787a, b.f10768a, f.f10779a, j.f10780a, k.f10781a});

    /* renamed from: c reason: collision with root package name */
    private e f10771c = new e(new c[]{q.f10785a, o.f10783a, s.f10787a, b.f10768a, f.f10779a, j.f10780a, k.f10781a});

    /* renamed from: d reason: collision with root package name */
    private e f10772d = new e(new c[]{n.f10782a, p.f10784a, s.f10787a, j.f10780a, k.f10781a});

    /* renamed from: e reason: collision with root package name */
    private e f10773e = new e(new c[]{n.f10782a, r.f10786a, p.f10784a, s.f10787a, k.f10781a});

    /* renamed from: f reason: collision with root package name */
    private e f10774f = new e(new c[]{p.f10784a, s.f10787a, k.f10781a});

    protected d() {
    }

    public static d a() {
        if (f10769a == null) {
            f10769a = new d();
        }
        return f10769a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConverterManager[");
        sb.append(this.f10770b.a());
        sb.append(" instant,");
        sb.append(this.f10771c.a());
        sb.append(" partial,");
        sb.append(this.f10772d.a());
        sb.append(" duration,");
        sb.append(this.f10773e.a());
        sb.append(" period,");
        sb.append(this.f10774f.a());
        sb.append(" interval]");
        return sb.toString();
    }

    public h a(Object obj) {
        Class cls;
        String str;
        e eVar = this.f10770b;
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        h hVar = (h) eVar.a(cls);
        if (hVar != null) {
            return hVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No instant converter found for type: ");
        if (obj == null) {
            str = "null";
        } else {
            str = obj.getClass().getName();
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }
}
