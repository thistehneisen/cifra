package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: TypeAdapters */
class E extends D<BigDecimal> {
    E() {
    }

    public BigDecimal a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        try {
            return new BigDecimal(bVar.F());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }

    public void a(d dVar, BigDecimal bigDecimal) throws IOException {
        dVar.a((Number) bigDecimal);
    }
}
