package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* renamed from: io.intercom.com.google.gson.b.a.z reason: case insensitive filesystem */
/* compiled from: TypeAdapters */
class C0778z extends D<Number> {
    C0778z() {
    }

    public Number a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return Float.valueOf((float) bVar.k());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, Number number) throws IOException {
        dVar.a(number);
    }
}
