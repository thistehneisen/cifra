package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataQueryRequest$$JsonObjectMapper extends JsonMapper<DaDataQueryRequest> {
    public DaDataQueryRequest parse(e eVar) throws IOException {
        DaDataQueryRequest daDataQueryRequest = new DaDataQueryRequest();
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
            parseField(daDataQueryRequest, c2, eVar);
            eVar.G();
        }
        return daDataQueryRequest;
    }

    public void parseField(DaDataQueryRequest daDataQueryRequest, String str, e eVar) throws IOException {
        if ("query".equals(str)) {
            daDataQueryRequest.a(eVar.c(null));
        }
    }

    public void serialize(DaDataQueryRequest daDataQueryRequest, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataQueryRequest.b() != null) {
            cVar.a("query", daDataQueryRequest.b());
        }
        if (z) {
            cVar.c();
        }
    }
}
