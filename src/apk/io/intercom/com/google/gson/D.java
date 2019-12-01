package io.intercom.com.google.gson;

import io.intercom.com.google.gson.b.a.C0763j;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapter */
public abstract class D<T> {
    public final D<T> a() {
        return new C(this);
    }

    public abstract T a(b bVar) throws IOException;

    public abstract void a(d dVar, T t) throws IOException;

    public final t a(T t) {
        try {
            C0763j jVar = new C0763j();
            a(jVar, t);
            return jVar.i();
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        }
    }
}
