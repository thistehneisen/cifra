package io.intercom.com.google.gson;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: Gson */
class l extends D<Number> {
    l() {
    }

    public Number a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return Long.valueOf(bVar.m());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, Number number) throws IOException {
        if (number == null) {
            dVar.h();
        } else {
            dVar.d(number.toString());
        }
    }
}
