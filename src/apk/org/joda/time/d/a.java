package org.joda.time.d;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.c;
import org.joda.time.d;

/* compiled from: AbstractReadableInstantFieldProperty */
public abstract class a implements Serializable {
    private static final long serialVersionUID = 1971226328211649661L;

    public int a() {
        return c().a(f());
    }

    /* access modifiers changed from: protected */
    public org.joda.time.a b() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public int c(Locale locale) {
        return c().a(locale);
    }

    public abstract c c();

    public d d() {
        return c().g();
    }

    public int e() {
        return c().c();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (a() != aVar.a() || !d().equals(aVar.d()) || !h.a((Object) b(), (Object) aVar.b())) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public abstract long f();

    public int g() {
        return c().d();
    }

    public String h() {
        return c().e();
    }

    public int hashCode() {
        return (a() * 17) + d().hashCode() + b().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Property[");
        sb.append(h());
        sb.append("]");
        return sb.toString();
    }

    public String a(Locale locale) {
        return c().a(f(), locale);
    }

    public String b(Locale locale) {
        return c().b(f(), locale);
    }
}
