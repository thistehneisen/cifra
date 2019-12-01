package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.b.x;
import io.intercom.com.google.gson.o;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: io.intercom.com.google.gson.b.a.n reason: case insensitive filesystem */
/* compiled from: ObjectTypeAdapter */
public final class C0767n extends D<Object> {

    /* renamed from: a reason: collision with root package name */
    public static final E f10074a = new C0765l();

    /* renamed from: b reason: collision with root package name */
    private final o f10075b;

    C0767n(o oVar) {
        this.f10075b = oVar;
    }

    public Object a(b bVar) throws IOException {
        switch (C0766m.f10073a[bVar.G().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                bVar.a();
                while (bVar.g()) {
                    arrayList.add(a(bVar));
                }
                bVar.d();
                return arrayList;
            case 2:
                x xVar = new x();
                bVar.b();
                while (bVar.g()) {
                    xVar.put(bVar.D(), a(bVar));
                }
                bVar.e();
                return xVar;
            case 3:
                return bVar.F();
            case 4:
                return Double.valueOf(bVar.k());
            case 5:
                return Boolean.valueOf(bVar.j());
            case 6:
                bVar.E();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void a(d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.h();
            return;
        }
        D a2 = this.f10075b.a(obj.getClass());
        if (a2 instanceof C0767n) {
            dVar.b();
            dVar.d();
            return;
        }
        a2.a(dVar, obj);
    }
}
