package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BaseRequisites$$JsonObjectMapper extends JsonMapper<BaseRequisites> {
    public BaseRequisites parse(e eVar) throws IOException {
        BaseRequisites baseRequisites = new BaseRequisites();
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
            parseField(baseRequisites, c2, eVar);
            eVar.G();
        }
        return baseRequisites;
    }

    public void parseField(BaseRequisites baseRequisites, String str, e eVar) throws IOException {
        if ("title".equals(str)) {
            baseRequisites.a(eVar.c(null));
        }
    }

    public void serialize(BaseRequisites baseRequisites, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (baseRequisites.b() != null) {
            cVar.a("title", baseRequisites.b());
        }
        if (z) {
            cVar.c();
        }
    }
}
