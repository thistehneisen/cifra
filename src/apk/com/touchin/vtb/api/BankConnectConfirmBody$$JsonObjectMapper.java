package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankConnectConfirmBody$$JsonObjectMapper extends JsonMapper<BankConnectConfirmBody> {
    private static final JsonMapper<ConnectedBankIdBody> parentObjectMapper = LoganSquare.mapperFor(ConnectedBankIdBody.class);

    public BankConnectConfirmBody parse(e eVar) throws IOException {
        BankConnectConfirmBody bankConnectConfirmBody = new BankConnectConfirmBody();
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
            parseField(bankConnectConfirmBody, c2, eVar);
            eVar.G();
        }
        return bankConnectConfirmBody;
    }

    public void parseField(BankConnectConfirmBody bankConnectConfirmBody, String str, e eVar) throws IOException {
        if ("code".equals(str)) {
            bankConnectConfirmBody.c(eVar.c(null));
        } else {
            parentObjectMapper.parseField(bankConnectConfirmBody, str, eVar);
        }
    }

    public void serialize(BankConnectConfirmBody bankConnectConfirmBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (bankConnectConfirmBody.d() != null) {
            cVar.a("code", bankConnectConfirmBody.d());
        }
        parentObjectMapper.serialize(bankConnectConfirmBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
