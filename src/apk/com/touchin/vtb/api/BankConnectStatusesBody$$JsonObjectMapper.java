package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BankConnectStatusesBody$$JsonObjectMapper extends JsonMapper<BankConnectStatusesBody> {
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    public BankConnectStatusesBody parse(e eVar) throws IOException {
        BankConnectStatusesBody bankConnectStatusesBody = new BankConnectStatusesBody();
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
            parseField(bankConnectStatusesBody, c2, eVar);
            eVar.G();
        }
        return bankConnectStatusesBody;
    }

    public void parseField(BankConnectStatusesBody bankConnectStatusesBody, String str, e eVar) throws IOException {
        if (!"bankIdsList".equals(str)) {
            parentObjectMapper.parseField(bankConnectStatusesBody, str, eVar);
        } else if (eVar.d() == g.START_ARRAY) {
            ArrayList arrayList = new ArrayList();
            while (eVar.F() != g.END_ARRAY) {
                arrayList.add(eVar.c(null));
            }
            bankConnectStatusesBody.a(arrayList);
        } else {
            bankConnectStatusesBody.a(null);
        }
    }

    public void serialize(BankConnectStatusesBody bankConnectStatusesBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<String> c2 = bankConnectStatusesBody.c();
        if (c2 != null) {
            cVar.c("bankIdsList");
            cVar.e();
            for (String str : c2) {
                if (str != null) {
                    cVar.f(str);
                }
            }
            cVar.b();
        }
        parentObjectMapper.serialize(bankConnectStatusesBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
