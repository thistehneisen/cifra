package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: io.intercom.com.google.gson.b.a.x reason: case insensitive filesystem */
/* compiled from: TypeAdapters */
class C0776x extends D<AtomicIntegerArray> {
    C0776x() {
    }

    public AtomicIntegerArray a(b bVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        bVar.a();
        while (bVar.g()) {
            try {
                arrayList.add(Integer.valueOf(bVar.l()));
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException((Throwable) e2);
            }
        }
        bVar.d();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
        }
        return atomicIntegerArray;
    }

    public void a(d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
        dVar.a();
        int length = atomicIntegerArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            dVar.h((long) atomicIntegerArray.get(i2));
        }
        dVar.c();
    }
}
