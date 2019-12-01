package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.stream.d;
import java.io.IOException;
import java.net.InetAddress;

/* compiled from: TypeAdapters */
class L extends D<InetAddress> {
    L() {
    }

    public InetAddress a(b bVar) throws IOException {
        if (bVar.G() != c.NULL) {
            return InetAddress.getByName(bVar.F());
        }
        bVar.E();
        return null;
    }

    public void a(d dVar, InetAddress inetAddress) throws IOException {
        dVar.d(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
