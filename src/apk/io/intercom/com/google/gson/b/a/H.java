package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class H extends D<Class> {
    H() {
    }

    public /* bridge */ /* synthetic */ void a(d dVar, Object obj) throws IOException {
        a(dVar, (Class) obj);
        throw null;
    }

    public void a(d dVar, Class cls) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Attempted to serialize java.lang.Class: ");
        sb.append(cls.getName());
        sb.append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(sb.toString());
    }

    public Class a(b bVar) throws IOException {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
}
