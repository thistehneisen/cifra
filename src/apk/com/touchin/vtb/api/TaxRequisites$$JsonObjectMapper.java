package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaxRequisites$$JsonObjectMapper extends JsonMapper<TaxRequisites> {
    private static final JsonMapper<BaseRequisites> parentObjectMapper = LoganSquare.mapperFor(BaseRequisites.class);

    public TaxRequisites parse(e eVar) throws IOException {
        TaxRequisites taxRequisites = new TaxRequisites();
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
            parseField(taxRequisites, c2, eVar);
            eVar.G();
        }
        return taxRequisites;
    }

    public void parseField(TaxRequisites taxRequisites, String str, e eVar) throws IOException {
        if ("accountNumber".equals(str)) {
            taxRequisites.b(eVar.c(null));
        } else if ("bankBic".equals(str)) {
            taxRequisites.c(eVar.c(null));
        } else if ("bankName".equals(str)) {
            taxRequisites.d(eVar.c(null));
        } else if ("inn".equals(str)) {
            taxRequisites.e(eVar.c(null));
        } else {
            parentObjectMapper.parseField(taxRequisites, str, eVar);
        }
    }

    public void serialize(TaxRequisites taxRequisites, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (taxRequisites.c() != null) {
            cVar.a("accountNumber", taxRequisites.c());
        }
        if (taxRequisites.d() != null) {
            cVar.a("bankBic", taxRequisites.d());
        }
        if (taxRequisites.e() != null) {
            cVar.a("bankName", taxRequisites.e());
        }
        if (taxRequisites.f() != null) {
            cVar.a("inn", taxRequisites.f());
        }
        parentObjectMapper.serialize(taxRequisites, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
