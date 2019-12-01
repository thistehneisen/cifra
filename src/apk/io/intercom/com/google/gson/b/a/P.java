package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.E;
import io.intercom.com.google.gson.c.a;
import io.intercom.com.google.gson.o;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class P implements E {
    P() {
    }

    public <T> D<T> a(o oVar, a<T> aVar) {
        if (aVar.a() != Timestamp.class) {
            return null;
        }
        return new O(this, oVar.a(Date.class));
    }
}
