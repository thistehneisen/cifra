package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BankOperationsListResponse$$JsonObjectMapper extends JsonMapper<BankOperationsListResponse> {
    private static final JsonMapper<OperationInfo> COM_TOUCHIN_VTB_API_OPERATIONINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(OperationInfo.class);
    private static final JsonMapper<TicketInfoResponse> parentObjectMapper = LoganSquare.mapperFor(TicketInfoResponse.class);

    public BankOperationsListResponse parse(e eVar) throws IOException {
        BankOperationsListResponse bankOperationsListResponse = new BankOperationsListResponse();
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
            parseField(bankOperationsListResponse, c2, eVar);
            eVar.G();
        }
        return bankOperationsListResponse;
    }

    public void parseField(BankOperationsListResponse bankOperationsListResponse, String str, e eVar) throws IOException {
        if (!"operations".equals(str)) {
            parentObjectMapper.parseField(bankOperationsListResponse, str, eVar);
        } else if (eVar.d() == g.START_ARRAY) {
            ArrayList arrayList = new ArrayList();
            while (eVar.F() != g.END_ARRAY) {
                arrayList.add((OperationInfo) COM_TOUCHIN_VTB_API_OPERATIONINFO__JSONOBJECTMAPPER.parse(eVar));
            }
            bankOperationsListResponse.a(arrayList);
        } else {
            bankOperationsListResponse.a(null);
        }
    }

    public void serialize(BankOperationsListResponse bankOperationsListResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<OperationInfo> c2 = bankOperationsListResponse.c();
        if (c2 != null) {
            cVar.c("operations");
            cVar.e();
            for (OperationInfo operationInfo : c2) {
                if (operationInfo != null) {
                    COM_TOUCHIN_VTB_API_OPERATIONINFO__JSONOBJECTMAPPER.serialize(operationInfo, cVar, true);
                }
            }
            cVar.b();
        }
        parentObjectMapper.serialize(bankOperationsListResponse, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
