package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonIOException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: TypeAdapters */
class K extends D<URI> {
    K() {
    }

    public URI a(b bVar) throws IOException {
        URI uri = null;
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        try {
            String F = bVar.F();
            if (!"null".equals(F)) {
                uri = new URI(F);
            }
            return uri;
        } catch (URISyntaxException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }

    public void a(d dVar, URI uri) throws IOException {
        dVar.d(uri == null ? null : uri.toASCIIString());
    }
}
