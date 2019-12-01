package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankConnectResponse$$JsonObjectMapper extends JsonMapper<BankConnectResponse> {
    private static TypeConverter<BankConnectionStatus> com_touchin_vtb_api_BankConnectionStatus_type_converter;

    private static final TypeConverter<BankConnectionStatus> getcom_touchin_vtb_api_BankConnectionStatus_type_converter() {
        if (com_touchin_vtb_api_BankConnectionStatus_type_converter == null) {
            com_touchin_vtb_api_BankConnectionStatus_type_converter = LoganSquare.typeConverterFor(BankConnectionStatus.class);
        }
        return com_touchin_vtb_api_BankConnectionStatus_type_converter;
    }

    public BankConnectResponse parse(e eVar) throws IOException {
        BankConnectResponse bankConnectResponse = new BankConnectResponse();
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
            parseField(bankConnectResponse, c2, eVar);
            eVar.G();
        }
        return bankConnectResponse;
    }

    public void parseField(BankConnectResponse bankConnectResponse, String str, e eVar) throws IOException {
        if ("bankConnectionStatus".equals(str)) {
            bankConnectResponse.a((BankConnectionStatus) getcom_touchin_vtb_api_BankConnectionStatus_type_converter().parse(eVar));
        } else if ("connectedBankId".equals(str)) {
            bankConnectResponse.a(eVar.c(null));
        }
    }

    public void serialize(BankConnectResponse bankConnectResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (bankConnectResponse.b() != null) {
            getcom_touchin_vtb_api_BankConnectionStatus_type_converter().serialize(bankConnectResponse.b(), "bankConnectionStatus", true, cVar);
        }
        if (bankConnectResponse.c() != null) {
            cVar.a("connectedBankId", bankConnectResponse.c());
        }
        if (z) {
            cVar.c();
        }
    }
}
