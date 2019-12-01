package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: TypeAdapters */
class F extends D<BigInteger> {
    F() {
    }

    public BigInteger a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        try {
            return new BigInteger(bVar.F());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }

    public void a(d dVar, BigInteger bigInteger) throws IOException {
        dVar.a((Number) bigInteger);
    }
}
