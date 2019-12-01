package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import java.sql.Date;

/* renamed from: io.intercom.com.google.gson.b.a.q reason: case insensitive filesystem */
/* compiled from: SqlDateTypeAdapter */
class C0770q implements E {
    C0770q() {
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        if (aVar.a() == Date.class) {
            return new r();
        }
        return null;
    }
}
