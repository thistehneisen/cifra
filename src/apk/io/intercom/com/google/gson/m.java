package io.intercom.com.google.gson;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Gson */
class m extends D<AtomicLong> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f10174a;

    m(D d2) {
        this.f10174a = d2;
    }

    public void a(d dVar, AtomicLong atomicLong) throws IOException {
        this.f10174a.a(dVar, Long.valueOf(atomicLong.get()));
    }

    public AtomicLong a(b bVar) throws IOException {
        return new AtomicLong(((Number) this.f10174a.a(bVar)).longValue());
    }
}
