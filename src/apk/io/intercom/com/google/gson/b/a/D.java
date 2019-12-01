package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class D extends io.intercom.com.google.gson.D<String> {
    D() {
    }

    public String a(b bVar) throws IOException {
        c G = bVar.G();
        if (G == c.NULL) {
            bVar.E();
            return null;
        } else if (G == c.BOOLEAN) {
            return Boolean.toString(bVar.j());
        } else {
            return bVar.F();
        }
    }

    public void a(d dVar, String str) throws IOException {
        dVar.d(str);
    }
}
