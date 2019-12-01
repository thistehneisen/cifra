package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class G extends D<StringBuilder> {
    G() {
    }

    public StringBuilder a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return new StringBuilder(bVar.F());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, StringBuilder sb) throws IOException {
        dVar.d(sb == null ? null : sb.toString());
    }
}
