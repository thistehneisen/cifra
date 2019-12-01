package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BasePaymentInfo$$JsonObjectMapper extends JsonMapper<BasePaymentInfo> {
    private static final JsonMapper<Amount> COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER = LoganSquare.mapperFor(Amount.class);

    public BasePaymentInfo parse(e eVar) throws IOException {
        BasePaymentInfo basePaymentInfo = new BasePaymentInfo();
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
            parseField(basePaymentInfo, c2, eVar);
            eVar.G();
        }
        return basePaymentInfo;
    }

    public void parseField(BasePaymentInfo basePaymentInfo, String str, e eVar) throws IOException {
        if ("amount".equals(str)) {
            basePaymentInfo.a((Amount) COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.parse(eVar));
        } else if ("description".equals(str)) {
            basePaymentInfo.a(eVar.c(null));
        }
    }

    public void serialize(BasePaymentInfo basePaymentInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (basePaymentInfo.b() != null) {
            cVar.c("amount");
            COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.serialize(basePaymentInfo.b(), cVar, true);
        }
        if (basePaymentInfo.c() != null) {
            cVar.a("description", basePaymentInfo.c());
        }
        if (z) {
            cVar.c();
        }
    }
}
