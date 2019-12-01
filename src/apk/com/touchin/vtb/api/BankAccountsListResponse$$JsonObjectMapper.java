package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BankAccountsListResponse$$JsonObjectMapper extends JsonMapper<BankAccountsListResponse> {
    private static final JsonMapper<AccountInfo> COM_TOUCHIN_VTB_API_ACCOUNTINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(AccountInfo.class);
    private static final JsonMapper<TicketInfoResponse> parentObjectMapper = LoganSquare.mapperFor(TicketInfoResponse.class);

    public BankAccountsListResponse parse(e eVar) throws IOException {
        BankAccountsListResponse bankAccountsListResponse = new BankAccountsListResponse();
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
            parseField(bankAccountsListResponse, c2, eVar);
            eVar.G();
        }
        return bankAccountsListResponse;
    }

    public void parseField(BankAccountsListResponse bankAccountsListResponse, String str, e eVar) throws IOException {
        if (!"accountsList".equals(str)) {
            parentObjectMapper.parseField(bankAccountsListResponse, str, eVar);
        } else if (eVar.d() == g.START_ARRAY) {
            ArrayList arrayList = new ArrayList();
            while (eVar.F() != g.END_ARRAY) {
                arrayList.add((AccountInfo) COM_TOUCHIN_VTB_API_ACCOUNTINFO__JSONOBJECTMAPPER.parse(eVar));
            }
            bankAccountsListResponse.a(arrayList);
        } else {
            bankAccountsListResponse.a(null);
        }
    }

    public void serialize(BankAccountsListResponse bankAccountsListResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<AccountInfo> c2 = bankAccountsListResponse.c();
        if (c2 != null) {
            cVar.c("accountsList");
            cVar.e();
            for (AccountInfo accountInfo : c2) {
                if (accountInfo != null) {
                    COM_TOUCHIN_VTB_API_ACCOUNTINFO__JSONOBJECTMAPPER.serialize(accountInfo, cVar, true);
                }
            }
            cVar.b();
        }
        parentObjectMapper.serialize(bankAccountsListResponse, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
