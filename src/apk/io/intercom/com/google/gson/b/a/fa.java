package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class fa extends D<Number> {
    fa() {
    }

    public Number a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        try {
            return Short.valueOf((short) bVar.l());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }

    public void a(d dVar, Number number) throws IOException {
        dVar.a(number);
    }
}
