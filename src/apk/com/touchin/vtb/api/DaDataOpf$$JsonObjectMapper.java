package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataOpf$$JsonObjectMapper extends JsonMapper<DaDataOpf> {
    public DaDataOpf parse(e eVar) throws IOException {
        DaDataOpf daDataOpf = new DaDataOpf();
        if (eVar.d() == null) {
            eVar.F();
        }
        if (eVar.d() != g.START_OBJECT) {
            eVar.G();
            return null;
        }
        while (eVar.F() != g.END_OBJECT) {
            String c2 = eVar.c();
            eVar.F();
            parseField(daDataOpf, c2, eVar);
            eVar.G();
        }
        return daDataOpf;
    }

    public void parseField(DaDataOpf daDataOpf, String str, e eVar) throws IOException {
        if ("full".equals(str)) {
            daDataOpf.a(eVar.c(null));
        } else if ("code".equals(str)) {
            daDataOpf.b(eVar.c(null));
        } else if ("short".equals(str)) {
            daDataOpf.c(eVar.c(null));
        } else if ("type".equals(str)) {
            daDataOpf.d(eVar.c(null));
        }
    }

    public void serialize(DaDataOpf daDataOpf, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataOpf.b() != null) {
            cVar.a("full", daDataOpf.b());
        }
        if (daDataOpf.c() != null) {
            cVar.a("code", daDataOpf.c());
        }
        if (daDataOpf.d() != null) {
            cVar.a("short", daDataOpf.d());
        }
        if (daDataOpf.e() != null) {
            cVar.a("type", daDataOpf.e());
        }
        if (z) {
            cVar.c();
        }
    }
}
