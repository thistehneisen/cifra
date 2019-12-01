package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.JsonSyntaxException;
import io.intercom.com.google.gson.b.u;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;

/* compiled from: TypeAdapters */
class B extends D<Number> {
    B() {
    }

    public Number a(b bVar) throws IOException {
        c G = bVar.G();
        int i2 = ba.f10044a[G.ordinal()];
        if (i2 == 1 || i2 == 3) {
            return new u(bVar.F());
        }
        if (i2 == 4) {
            bVar.E();
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expecting number, got: ");
        sb.append(G);
        throw new JsonSyntaxException(sb.toString());
    }

    public void a(d dVar, Number number) throws IOException {
        dVar.a(number);
    }
}
