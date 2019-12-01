package io.intercom.com.google.gson.stream;

import io.intercom.com.google.gson.b.a.C0761h;
import io.intercom.com.google.gson.b.t;
import java.io.IOException;

/* compiled from: JsonReader */
class a extends t {
    a() {
    }

    public void a(b bVar) throws IOException {
        if (bVar instanceof C0761h) {
            ((C0761h) bVar).I();
            return;
        }
        int i2 = bVar.f10198i;
        if (i2 == 0) {
            i2 = bVar.c();
        }
        if (i2 == 13) {
            bVar.f10198i = 9;
        } else if (i2 == 12) {
            bVar.f10198i = 8;
        } else if (i2 == 14) {
            bVar.f10198i = 10;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a name but was ");
            sb.append(bVar.G());
            sb.append(bVar.i());
            throw new IllegalStateException(sb.toString());
        }
    }
}
