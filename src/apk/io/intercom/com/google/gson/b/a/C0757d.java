package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import java.util.Date;

/* renamed from: io.intercom.com.google.gson.b.a.d reason: case insensitive filesystem */
/* compiled from: DateTypeAdapter */
class C0757d implements E {
    C0757d() {
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        if (aVar.a() == Date.class) {
            return new C0758e();
        }
        return null;
    }
}
