package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TypeAdapters */
class ia extends D<AtomicBoolean> {
    ia() {
    }

    public AtomicBoolean a(b bVar) throws IOException {
        return new AtomicBoolean(bVar.j());
    }

    public void a(d dVar, AtomicBoolean atomicBoolean) throws IOException {
        dVar.d(atomicBoolean.get());
    }
}
