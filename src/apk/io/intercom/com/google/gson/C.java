package io.intercom.com.google.gson;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapter */
class C extends D<T> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f10014a;

    C(D d2) {
        this.f10014a = d2;
    }

    public void a(d dVar, T t) throws IOException {
        if (t == null) {
            dVar.h();
        } else {
            this.f10014a.a(dVar, t);
        }
    }

    public T a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return this.f10014a.a(bVar);
        }
        bVar.E();
        return null;
    }
}
