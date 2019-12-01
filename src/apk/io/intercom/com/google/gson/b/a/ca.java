package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ca extends D<Boolean> {
    ca() {
    }

    public Boolean a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        } else if (bVar.G() == c.STRING) {
            return Boolean.valueOf(Boolean.parseBoolean(bVar.F()));
        } else {
            return Boolean.valueOf(bVar.j());
        }
    }

    public void a(d dVar, Boolean bool) throws IOException {
        dVar.a(bool);
    }
}
