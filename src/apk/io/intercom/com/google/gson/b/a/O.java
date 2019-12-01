package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class O extends D<Timestamp> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f10026a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ P f10027b;

    O(P p, D d2) {
        this.f10027b = p;
        this.f10026a = d2;
    }

    public Timestamp a(b bVar) throws IOException {
        Date date = (Date) this.f10026a.a(bVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    public void a(d dVar, Timestamp timestamp) throws IOException {
        this.f10026a.a(dVar, timestamp);
    }
}
