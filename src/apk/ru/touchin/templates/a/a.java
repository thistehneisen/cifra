package ru.touchin.templates.a;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: LoganSquareBigDecimalConverter */
public class a implements TypeConverter<BigDecimal> {
    /* renamed from: a */
    public void serialize(BigDecimal bigDecimal, String str, boolean z, c cVar) throws IOException {
        String str2 = null;
        if (str != null) {
            if (bigDecimal != null) {
                str2 = bigDecimal.toString();
            }
            cVar.a(str, str2);
            return;
        }
        if (bigDecimal != null) {
            str2 = bigDecimal.toString();
        }
        cVar.f(str2);
    }

    public BigDecimal parse(e eVar) throws IOException {
        String E = eVar.E();
        if (E == null) {
            return null;
        }
        try {
            return new BigDecimal(E);
        } catch (RuntimeException e2) {
            l.a.d.b.a.c.a((Throwable) e2);
            return null;
        }
    }
}
