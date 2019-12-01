package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.net.URL;

/* compiled from: TypeAdapters */
class J extends D<URL> {
    J() {
    }

    public URL a(b bVar) throws IOException {
        URL url = null;
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        String F = bVar.F();
        if (!"null".equals(F)) {
            url = new URL(F);
        }
        return url;
    }

    public void a(d dVar, URL url) throws IOException {
        dVar.d(url == null ? null : url.toExternalForm());
    }
}
