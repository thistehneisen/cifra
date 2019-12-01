package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BankOperationsListBody$$JsonObjectMapper extends JsonMapper<BankOperationsListBody> {
    private static final JsonMapper<ConnectedBankIdBody> parentObjectMapper = LoganSquare.mapperFor(ConnectedBankIdBody.class);

    public BankOperationsListBody parse(e eVar) throws IOException {
        BankOperationsListBody bankOperationsListBody = new BankOperationsListBody();
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
            parseField(bankOperationsListBody, c2, eVar);
            eVar.G();
        }
        return bankOperationsListBody;
    }

    public void parseField(BankOperationsListBody bankOperationsListBody, String str, e eVar) throws IOException {
        if ("accountId".equals(str)) {
            bankOperationsListBody.c(eVar.c(null));
        } else if ("limit".equals(str)) {
            bankOperationsListBody.a(eVar.m());
        } else if ("offset".equals(str)) {
            bankOperationsListBody.b(eVar.m());
        } else if ("ticketId".equals(str)) {
            bankOperationsListBody.d(eVar.c(null));
        } else {
            parentObjectMapper.parseField(bankOperationsListBody, str, eVar);
        }
    }

    public void serialize(BankOperationsListBody bankOperationsListBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (bankOperationsListBody.d() != null) {
            cVar.a("accountId", bankOperationsListBody.d());
        }
        cVar.a("limit", bankOperationsListBody.e());
        cVar.a("offset", bankOperationsListBody.f());
        if (bankOperationsListBody.g() != null) {
            cVar.a("ticketId", bankOperationsListBody.g());
        }
        parentObjectMapper.serialize(bankOperationsListBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
