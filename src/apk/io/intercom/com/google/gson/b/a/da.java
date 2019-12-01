package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class da extends D<Boolean> {
    da() {
    }

    public Boolean a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return Boolean.valueOf(bVar.F());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, Boolean bool) throws IOException {
        dVar.d(bool == null ? "null" : bool.toString());
    }
}
