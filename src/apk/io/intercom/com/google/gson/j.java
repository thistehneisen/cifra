package io.intercom.com.google.gson;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: Gson */
class j extends D<Number> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ o f10172a;

    j(o oVar) {
        this.f10172a = oVar;
    }

    public Double a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return Double.valueOf(bVar.k());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, Number number) throws IOException {
        if (number == null) {
            dVar.h();
            return;
        }
        o.a(number.doubleValue());
        dVar.a(number);
    }
}
