package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankConnectCheckResponse$$JsonObjectMapper extends JsonMapper<BankConnectCheckResponse> {
    private static TypeConverter<BankConnectionStatus> com_touchin_vtb_api_BankConnectionStatus_type_converter;

    private static final TypeConverter<BankConnectionStatus> getcom_touchin_vtb_api_BankConnectionStatus_type_converter() {
        if (com_touchin_vtb_api_BankConnectionStatus_type_converter == null) {
            com_touchin_vtb_api_BankConnectionStatus_type_converter = LoganSquare.typeConverterFor(BankConnectionStatus.class);
        }
        return com_touchin_vtb_api_BankConnectionStatus_type_converter;
    }

    public BankConnectCheckResponse parse(e eVar) throws IOException {
        BankConnectCheckResponse bankConnectCheckResponse = new BankConnectCheckResponse();
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
            parseField(bankConnectCheckResponse, c2, eVar);
            eVar.G();
        }
        return bankConnectCheckResponse;
    }

    public void parseField(BankConnectCheckResponse bankConnectCheckResponse, String str, e eVar) throws IOException {
        if ("bankConnectionStatus".equals(str)) {
            bankConnectCheckResponse.a((BankConnectionStatus) getcom_touchin_vtb_api_BankConnectionStatus_type_converter().parse(eVar));
        }
    }

    public void serialize(BankConnectCheckResponse bankConnectCheckResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (bankConnectCheckResponse.b() != null) {
            getcom_touchin_vtb_api_BankConnectionStatus_type_converter().serialize(bankConnectCheckResponse.b(), "bankConnectionStatus", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
