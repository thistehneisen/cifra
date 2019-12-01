package io.intercom.com.google.gson;

import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: Gson */
class k extends D<Number> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ o f10173a;

    k(o oVar) {
        this.f10173a = oVar;
    }

    public Float a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return Float.valueOf((float) bVar.k());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, Number number) throws IOException {
        if (number == null) {
            dVar.h();
            return;
        }
        o.a((double) number.floatValue());
        dVar.a(number);
    }
}
