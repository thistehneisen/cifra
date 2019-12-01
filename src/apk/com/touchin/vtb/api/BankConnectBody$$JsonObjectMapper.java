package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankConnectBody$$JsonObjectMapper extends JsonMapper<BankConnectBody> {
    private static TypeConverter<BankType> com_touchin_vtb_api_BankType_type_converter;
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    private static final TypeConverter<BankType> getcom_touchin_vtb_api_BankType_type_converter() {
        if (com_touchin_vtb_api_BankType_type_converter == null) {
            com_touchin_vtb_api_BankType_type_converter = LoganSquare.typeConverterFor(BankType.class);
        }
        return com_touchin_vtb_api_BankType_type_converter;
    }

    public BankConnectBody parse(e eVar) throws IOException {
        BankConnectBody bankConnectBody = new BankConnectBody();
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
            parseField(bankConnectBody, c2, eVar);
            eVar.G();
        }
        return bankConnectBody;
    }

    public void parseField(BankConnectBody bankConnectBody, String str, e eVar) throws IOException {
        if ("bankType".equals(str)) {
            bankConnectBody.a((BankType) getcom_touchin_vtb_api_BankType_type_converter().parse(eVar));
        } else if ("connectedBankId".equals(str)) {
            bankConnectBody.b(eVar.c(null));
        } else if ("login".equals(str)) {
            bankConnectBody.c(eVar.c(null));
        } else if ("password".equals(str)) {
            bankConnectBody.d(eVar.c(null));
        } else {
            parentObjectMapper.parseField(bankConnectBody, str, eVar);
        }
    }

    public void serialize(BankConnectBody bankConnectBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (bankConnectBody.c() != null) {
            getcom_touchin_vtb_api_BankType_type_converter().serialize(bankConnectBody.c(), "bankType", true, cVar);
        }
        if (bankConnectBody.d() != null) {
            cVar.a("connectedBankId", bankConnectBody.d());
        }
        if (bankConnectBody.e() != null) {
            cVar.a("login", bankConnectBody.e());
        }
        if (bankConnectBody.getPassword() != null) {
            cVar.a("password", bankConnectBody.getPassword());
        }
        parentObjectMapper.serialize(bankConnectBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
