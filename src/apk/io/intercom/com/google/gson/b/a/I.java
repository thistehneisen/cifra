package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class I extends D<StringBuffer> {
    I() {
    }

    public StringBuffer a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return new StringBuffer(bVar.F());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, StringBuffer stringBuffer) throws IOException {
        dVar.d(stringBuffer == null ? null : stringBuffer.toString());
    }
}
