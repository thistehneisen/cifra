package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaxPaymentConfirmBody$$JsonObjectMapper extends JsonMapper<TaxPaymentConfirmBody> {
    private static final JsonMapper<UserRegisterConfirmBody> parentObjectMapper = LoganSquare.mapperFor(UserRegisterConfirmBody.class);

    public TaxPaymentConfirmBody parse(e eVar) throws IOException {
        TaxPaymentConfirmBody taxPaymentConfirmBody = new TaxPaymentConfirmBody();
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
            parseField(taxPaymentConfirmBody, c2, eVar);
            eVar.G();
        }
        return taxPaymentConfirmBody;
    }

    public void parseField(TaxPaymentConfirmBody taxPaymentConfirmBody, String str, e eVar) throws IOException {
        if ("taskId".equals(str)) {
            taxPaymentConfirmBody.d(eVar.c(null));
        } else {
            parentObjectMapper.parseField(taxPaymentConfirmBody, str, eVar);
        }
    }

    public void serialize(TaxPaymentConfirmBody taxPaymentConfirmBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (taxPaymentConfirmBody.e() != null) {
            cVar.a("taskId", taxPaymentConfirmBody.e());
        }
        parentObjectMapper.serialize(taxPaymentConfirmBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
