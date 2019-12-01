package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.D;
import io.intercom.com.google.gson.b.u;
import io.intercom.com.google.gson.q;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.d;
import io.intercom.com.google.gson.t;
import io.intercom.com.google.gson.v;
import io.intercom.com.google.gson.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: TypeAdapters */
class T extends D<t> {
    T() {
    }

    public t a(b bVar) throws IOException {
        switch (ba.f10044a[bVar.G().ordinal()]) {
            case 1:
                return new w((Number) new u(bVar.F()));
            case 2:
                return new w(Boolean.valueOf(bVar.j()));
            case 3:
                return new w(bVar.F());
            case 4:
                bVar.E();
                return io.intercom.com.google.gson.u.f10224a;
            case 5:
                q qVar = new q();
                bVar.a();
                while (bVar.g()) {
                    qVar.a(a(bVar));
                }
                bVar.d();
                return qVar;
            case 6:
                v vVar = new v();
                bVar.b();
                while (bVar.g()) {
                    vVar.a(bVar.D(), a(bVar));
                }
                bVar.e();
                return vVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void a(d dVar, t tVar) throws IOException {
        if (tVar == null || tVar.i()) {
            dVar.h();
        } else if (tVar.k()) {
            w g2 = tVar.g();
            if (g2.t()) {
                dVar.a(g2.q());
            } else if (g2.s()) {
                dVar.d(g2.l());
            } else {
                dVar.d(g2.r());
            }
        } else if (tVar.h()) {
            dVar.a();
            Iterator it = tVar.e().iterator();
            while (it.hasNext()) {
                a(dVar, (t) it.next());
            }
            dVar.c();
        } else if (tVar.j()) {
            dVar.b();
            for (Entry entry : tVar.f().l()) {
                dVar.b((String) entry.getKey());
                a(dVar, (t) entry.getValue());
            }
            dVar.d();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't write ");
            sb.append(tVar.getClass());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
