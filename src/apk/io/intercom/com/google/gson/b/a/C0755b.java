package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* renamed from: io.intercom.com.google.gson.b.a.b reason: case insensitive filesystem */
/* compiled from: ArrayTypeAdapter */
public final class C0755b<E> extends D<Object> {

    /* renamed from: a reason: collision with root package name */
    public static final E f10041a = new C0754a();

    /* renamed from: b reason: collision with root package name */
    private final Class<E> f10042b;

    /* renamed from: c reason: collision with root package name */
    private final D<E> f10043c;

    public C0755b(o oVar, D<E> d2, Class<E> cls) {
        this.f10043c = new C0775w(oVar, d2, cls);
        this.f10042b = cls;
    }

    public Object a(b bVar) throws IOException {
        if (bVar.G() == c.NULL) {
            bVar.E();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bVar.a();
        while (bVar.g()) {
            arrayList.add(this.f10043c.a(bVar));
        }
        bVar.d();
        int size = arrayList.size();
        Object newInstance = Array.newInstance(this.f10042b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    public void a(d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.h();
            return;
        }
        dVar.a();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f10043c.a(dVar, Array.get(obj, i2));
        }
        dVar.c();
    }
}
