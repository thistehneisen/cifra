package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class OperationInfo$$JsonObjectMapper extends JsonMapper<OperationInfo> {
    private static final JsonMapper<OperationRequisites> COM_TOUCHIN_VTB_API_OPERATIONREQUISITES__JSONOBJECTMAPPER = LoganSquare.mapperFor(OperationRequisites.class);
    private static final JsonMapper<PaymentInfo> parentObjectMapper = LoganSquare.mapperFor(PaymentInfo.class);

    public OperationInfo parse(e eVar) throws IOException {
        OperationInfo operationInfo = new OperationInfo();
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
            parseField(operationInfo, c2, eVar);
            eVar.G();
        }
        return operationInfo;
    }

    public void parseField(OperationInfo operationInfo, String str, e eVar) throws IOException {
        if ("id".equals(str)) {
            operationInfo.b(eVar.c(null));
        } else if ("imageUrl".equals(str)) {
            operationInfo.c(eVar.c(null));
        } else if ("payerRequisites".equals(str)) {
            operationInfo.a((OperationRequisites) COM_TOUCHIN_VTB_API_OPERATIONREQUISITES__JSONOBJECTMAPPER.parse(eVar));
        } else if ("receiverRequisites".equals(str)) {
            operationInfo.b((OperationRequisites) COM_TOUCHIN_VTB_API_OPERATIONREQUISITES__JSONOBJECTMAPPER.parse(eVar));
        } else {
            parentObjectMapper.parseField(operationInfo, str, eVar);
        }
    }

    public void serialize(OperationInfo operationInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (operationInfo.e() != null) {
            cVar.a("id", operationInfo.e());
        }
        if (operationInfo.f() != null) {
            cVar.a("imageUrl", operationInfo.f());
        }
        if (operationInfo.g() != null) {
            cVar.c("payerRequisites");
            COM_TOUCHIN_VTB_API_OPERATIONREQUISITES__JSONOBJECTMAPPER.serialize(operationInfo.g(), cVar, true);
        }
        if (operationInfo.h() != null) {
            cVar.c("receiverRequisites");
            COM_TOUCHIN_VTB_API_OPERATIONREQUISITES__JSONOBJECTMAPPER.serialize(operationInfo.h(), cVar, true);
        }
        parentObjectMapper.serialize(operationInfo, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
