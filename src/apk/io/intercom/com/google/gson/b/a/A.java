package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class A extends D<Number> {
    A() {
    }

    public Number a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return Double.valueOf(bVar.k());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, Number number) throws IOException {
        dVar.a(number);
    }
}
