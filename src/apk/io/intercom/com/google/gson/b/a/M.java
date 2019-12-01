package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.UUID;

/* compiled from: TypeAdapters */
class M extends D<UUID> {
    M() {
    }

    public UUID a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return UUID.fromString(bVar.F());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, UUID uuid) throws IOException {
        dVar.d(uuid == null ? null : uuid.toString());
    }
}
