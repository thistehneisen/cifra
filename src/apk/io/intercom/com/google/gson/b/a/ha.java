package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TypeAdapters */
class ha extends D<AtomicInteger> {
    ha() {
    }

    public AtomicInteger a(b bVar) throws IOException {
        try {
            return new AtomicInteger(bVar.l());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        }
    }

    public void a(d dVar, AtomicInteger atomicInteger) throws IOException {
        dVar.h((long) atomicInteger.get());
    }
}
