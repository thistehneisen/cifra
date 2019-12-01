package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BankConnectStatusesResponse$$JsonObjectMapper extends JsonMapper<BankConnectStatusesResponse> {
    private static final JsonMapper<BankConnectResponse> COM_TOUCHIN_VTB_API_BANKCONNECTRESPONSE__JSONOBJECTMAPPER = LoganSquare.mapperFor(BankConnectResponse.class);

    public BankConnectStatusesResponse parse(e eVar) throws IOException {
        BankConnectStatusesResponse bankConnectStatusesResponse = new BankConnectStatusesResponse();
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
            parseField(bankConnectStatusesResponse, c2, eVar);
            eVar.G();
        }
        return bankConnectStatusesResponse;
    }

    public void parseField(BankConnectStatusesResponse bankConnectStatusesResponse, String str, e eVar) throws IOException {
        if (!"banksList".equals(str)) {
            return;
        }
        if (eVar.d() == g.START_ARRAY) {
            ArrayList arrayList = new ArrayList();
            while (eVar.F() != g.END_ARRAY) {
                arrayList.add((BankConnectResponse) COM_TOUCHIN_VTB_API_BANKCONNECTRESPONSE__JSONOBJECTMAPPER.parse(eVar));
            }
            bankConnectStatusesResponse.a(arrayList);
            return;
        }
        bankConnectStatusesResponse.a(null);
    }

    public void serialize(BankConnectStatusesResponse bankConnectStatusesResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<BankConnectResponse> b2 = bankConnectStatusesResponse.b();
        if (b2 != null) {
            cVar.c("banksList");
            cVar.e();
            for (BankConnectResponse bankConnectResponse : b2) {
                if (bankConnectResponse != null) {
                    COM_TOUCHIN_VTB_API_BANKCONNECTRESPONSE__JSONOBJECTMAPPER.serialize(bankConnectResponse, cVar, true);
                }
            }
            cVar.b();
        }
        if (z) {
            cVar.c();
        }
    }
}
