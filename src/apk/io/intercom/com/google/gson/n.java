package io.intercom.com.google.gson;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
class n extends D<AtomicLongArray> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f10175a;

    n(D d2) {
        this.f10175a = d2;
    }

    public void a(d dVar, AtomicLongArray atomicLongArray) throws IOException {
        dVar.a();
        int length = atomicLongArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            this.f10175a.a(dVar, Long.valueOf(atomicLongArray.get(i2)));
        }
        dVar.c();
    }

    public AtomicLongArray a(b bVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bVar.a();
        while (bVar.g()) {
            arrayList.add(Long.valueOf(((Number) this.f10175a.a(bVar)).longValue()));
        }
        bVar.d();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
        }
        return atomicLongArray;
    }
}
