package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import java.sql.Time;

/* renamed from: io.intercom.com.google.gson.b.a.s reason: case insensitive filesystem */
/* compiled from: TimeTypeAdapter */
class C0771s implements E {
    C0771s() {
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        if (aVar.a() == Time.class) {
            return new C0772t();
        }
        return null;
    }
}
