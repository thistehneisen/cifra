package org.joda.time.e;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.a;
import org.joda.time.e;
import org.joda.time.g;
import org.joda.time.r;
import org.joda.time.t;

/* compiled from: DateTimeFormatter */
public class b {

    /* renamed from: a reason: collision with root package name */
    private final m f10829a;

    /* renamed from: b reason: collision with root package name */
    private final k f10830b;

    /* renamed from: c reason: collision with root package name */
    private final Locale f10831c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f10832d;

    /* renamed from: e reason: collision with root package name */
    private final a f10833e;

    /* renamed from: f reason: collision with root package name */
    private final g f10834f;

    /* renamed from: g reason: collision with root package name */
    private final Integer f10835g;

    /* renamed from: h reason: collision with root package name */
    private final int f10836h;

    b(m mVar, k kVar) {
        this.f10829a = mVar;
        this.f10830b = kVar;
        this.f10831c = null;
        this.f10832d = false;
        this.f10833e = null;
        this.f10834f = null;
        this.f10835g = null;
        this.f10836h = 2000;
    }

    private k g() {
        k kVar = this.f10830b;
        if (kVar != null) {
            return kVar;
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    private m h() {
        m mVar = this.f10829a;
        if (mVar != null) {
            return mVar;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public b a(Locale locale) {
        if (locale == a() || (locale != null && locale.equals(a()))) {
            return this;
        }
        b bVar = new b(this.f10829a, this.f10830b, locale, this.f10832d, this.f10833e, this.f10834f, this.f10835g, this.f10836h);
        return bVar;
    }

    public d b() {
        return l.a(this.f10830b);
    }

    /* access modifiers changed from: 0000 */
    public k c() {
        return this.f10830b;
    }

    /* access modifiers changed from: 0000 */
    public m d() {
        return this.f10829a;
    }

    public b e() {
        if (this.f10832d) {
            return this;
        }
        b bVar = new b(this.f10829a, this.f10830b, this.f10831c, true, this.f10833e, null, this.f10835g, this.f10836h);
        return bVar;
    }

    public b f() {
        return a(g.f10938a);
    }

    public long b(String str) {
        k g2 = g();
        e eVar = new e(0, b(this.f10833e), this.f10831c, this.f10835g, this.f10836h);
        return eVar.a(g2, (CharSequence) str);
    }

    public Locale a() {
        return this.f10831c;
    }

    public b a(a aVar) {
        if (this.f10833e == aVar) {
            return this;
        }
        b bVar = new b(this.f10829a, this.f10830b, this.f10831c, this.f10832d, aVar, this.f10834f, this.f10835g, this.f10836h);
        return bVar;
    }

    private a b(a aVar) {
        a a2 = e.a(aVar);
        a aVar2 = this.f10833e;
        if (aVar2 != null) {
            a2 = aVar2;
        }
        g gVar = this.f10834f;
        return gVar != null ? a2.a(gVar) : a2;
    }

    public b a(g gVar) {
        if (this.f10834f == gVar) {
            return this;
        }
        b bVar = new b(this.f10829a, this.f10830b, this.f10831c, false, this.f10833e, gVar, this.f10835g, this.f10836h);
        return bVar;
    }

    public void a(Appendable appendable, r rVar) throws IOException {
        a(appendable, e.b(rVar), e.a(rVar));
    }

    private b(m mVar, k kVar, Locale locale, boolean z, a aVar, g gVar, Integer num, int i2) {
        this.f10829a = mVar;
        this.f10830b = kVar;
        this.f10831c = locale;
        this.f10832d = z;
        this.f10833e = aVar;
        this.f10834f = gVar;
        this.f10835g = num;
        this.f10836h = i2;
    }

    public void a(StringBuffer stringBuffer, long j2) {
        try {
            a((Appendable) stringBuffer, j2);
        } catch (IOException unused) {
        }
    }

    public void a(Appendable appendable, long j2) throws IOException {
        a(appendable, j2, null);
    }

    public void a(Appendable appendable, t tVar) throws IOException {
        m h2 = h();
        if (tVar != null) {
            h2.a(appendable, tVar, this.f10831c);
            return;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }

    public String a(r rVar) {
        StringBuilder sb = new StringBuilder(h().b());
        try {
            a((Appendable) sb, rVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public String a(long j2) {
        StringBuilder sb = new StringBuilder(h().b());
        try {
            a((Appendable) sb, j2);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public String a(t tVar) {
        StringBuilder sb = new StringBuilder(h().b());
        try {
            a((Appendable) sb, tVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    private void a(Appendable appendable, long j2, a aVar) throws IOException {
        long j3 = j2;
        m h2 = h();
        a b2 = b(aVar);
        g k2 = b2.k();
        int c2 = k2.c(j3);
        long j4 = (long) c2;
        long j5 = j3 + j4;
        if ((j3 ^ j5) < 0 && (j4 ^ j3) >= 0) {
            k2 = g.f10938a;
            c2 = 0;
            j5 = j3;
        }
        m mVar = h2;
        Appendable appendable2 = appendable;
        long j6 = j5;
        mVar.a(appendable2, j6, b2.G(), c2, k2, this.f10831c);
    }

    public org.joda.time.b a(String str) {
        k g2 = g();
        a b2 = b((a) null);
        e eVar = new e(0, b2, this.f10831c, this.f10835g, this.f10836h);
        int a2 = g2.a(eVar, str, 0);
        if (a2 < 0) {
            a2 = ~a2;
        } else if (a2 >= str.length()) {
            long a3 = eVar.a(true, str);
            if (this.f10832d && eVar.c() != null) {
                b2 = b2.a(g.a(eVar.c().intValue()));
            } else if (eVar.e() != null) {
                b2 = b2.a(eVar.e());
            }
            org.joda.time.b bVar = new org.joda.time.b(a3, b2);
            g gVar = this.f10834f;
            return gVar != null ? bVar.a(gVar) : bVar;
        }
        throw new IllegalArgumentException(i.a(str, a2));
    }
}
