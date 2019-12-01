package org.joda.time.e;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.a;
import org.joda.time.g;
import org.joda.time.t;

/* compiled from: DateTimePrinterInternalPrinter */
class h implements m {

    /* renamed from: a reason: collision with root package name */
    private final g f10896a;

    private h(g gVar) {
        this.f10896a = gVar;
    }

    static m a(g gVar) {
        if (gVar == null) {
            return null;
        }
        return new h(gVar);
    }

    public int b() {
        return this.f10896a.b();
    }

    public void a(Appendable appendable, long j2, a aVar, int i2, g gVar, Locale locale) throws IOException {
        Appendable appendable2 = appendable;
        if (appendable2 instanceof StringBuffer) {
            this.f10896a.a((StringBuffer) appendable2, j2, aVar, i2, gVar, locale);
        } else if (appendable2 instanceof Writer) {
            this.f10896a.a((Writer) appendable2, j2, aVar, i2, gVar, locale);
        } else {
            StringBuffer stringBuffer = new StringBuffer(b());
            this.f10896a.a(stringBuffer, j2, aVar, i2, gVar, locale);
            appendable.append(stringBuffer);
        }
    }

    public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
        if (appendable instanceof StringBuffer) {
            this.f10896a.a((StringBuffer) appendable, tVar, locale);
        } else if (appendable instanceof Writer) {
            this.f10896a.a((Writer) appendable, tVar, locale);
        } else {
            StringBuffer stringBuffer = new StringBuffer(b());
            this.f10896a.a(stringBuffer, tVar, locale);
            appendable.append(stringBuffer);
        }
    }
}
