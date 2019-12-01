package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class ConnectedBank$$JsonObjectMapper extends JsonMapper<ConnectedBank> {
    private static TypeConverter<BankType> com_touchin_vtb_api_BankType_type_converter;

    private static final TypeConverter<BankType> getcom_touchin_vtb_api_BankType_type_converter() {
        if (com_touchin_vtb_api_BankType_type_converter == null) {
            com_touchin_vtb_api_BankType_type_converter = LoganSquare.typeConverterFor(BankType.class);
        }
        return com_touchin_vtb_api_BankType_type_converter;
    }

    public ConnectedBank parse(e eVar) throws IOException {
        ConnectedBank connectedBank = new ConnectedBank();
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
            parseField(connectedBank, c2, eVar);
            eVar.G();
        }
        return connectedBank;
    }

    public void parseField(ConnectedBank connectedBank, String str, e eVar) throws IOException {
        if ("bankType".equals(str)) {
            connectedBank.a((BankType) getcom_touchin_vtb_api_BankType_type_converter().parse(eVar));
        } else if ("connectedBankId".equals(str)) {
            connectedBank.a(eVar.c(null));
        }
    }

    public void serialize(ConnectedBank connectedBank, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (connectedBank.b() != null) {
            getcom_touchin_vtb_api_BankType_type_converter().serialize(connectedBank.b(), "bankType", true, cVar);
        }
        if (connectedBank.c() != null) {
            cVar.a("connectedBankId", connectedBank.c());
        }
        if (z) {
            cVar.c();
        }
    }
}
