package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class OperationRequisites$$JsonObjectMapper extends JsonMapper<OperationRequisites> {
    private static final JsonMapper<BaseRequisites> parentObjectMapper = LoganSquare.mapperFor(BaseRequisites.class);

    public OperationRequisites parse(e eVar) throws IOException {
        OperationRequisites operationRequisites = new OperationRequisites();
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
            parseField(operationRequisites, c2, eVar);
            eVar.G();
        }
        return operationRequisites;
    }

    public void parseField(OperationRequisites operationRequisites, String str, e eVar) throws IOException {
        if ("accountNumber".equals(str)) {
            operationRequisites.b(eVar.c(null));
        } else if ("bankBic".equals(str)) {
            operationRequisites.c(eVar.c(null));
        } else if ("bankName".equals(str)) {
            operationRequisites.d(eVar.c(null));
        } else if ("inn".equals(str)) {
            operationRequisites.e(eVar.c(null));
        } else {
            parentObjectMapper.parseField(operationRequisites, str, eVar);
        }
    }

    public void serialize(OperationRequisites operationRequisites, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (operationRequisites.c() != null) {
            cVar.a("accountNumber", operationRequisites.c());
        }
        if (operationRequisites.d() != null) {
            cVar.a("bankBic", operationRequisites.d());
        }
        if (operationRequisites.e() != null) {
            cVar.a("bankName", operationRequisites.e());
        }
        if (operationRequisites.f() != null) {
            cVar.a("inn", operationRequisites.f());
        }
        parentObjectMapper.serialize(operationRequisites, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
