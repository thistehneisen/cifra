package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class TaxesYearInfo$$JsonObjectMapper extends JsonMapper<TaxesYearInfo> {
    private static final JsonMapper<Amount> COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER = LoganSquare.mapperFor(Amount.class);
    private static final JsonMapper<PaymentInfo> COM_TOUCHIN_VTB_API_PAYMENTINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(PaymentInfo.class);

    public TaxesYearInfo parse(e eVar) throws IOException {
        TaxesYearInfo taxesYearInfo = new TaxesYearInfo();
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
            parseField(taxesYearInfo, c2, eVar);
            eVar.G();
        }
        return taxesYearInfo;
    }

    public void parseField(TaxesYearInfo taxesYearInfo, String str, e eVar) throws IOException {
        if ("taxPaymentsList".equals(str)) {
            if (eVar.d() == g.START_ARRAY) {
                ArrayList arrayList = new ArrayList();
                while (eVar.F() != g.END_ARRAY) {
                    arrayList.add((PaymentInfo) COM_TOUCHIN_VTB_API_PAYMENTINFO__JSONOBJECTMAPPER.parse(eVar));
                }
                taxesYearInfo.a((List<PaymentInfo>) arrayList);
                return;
            }
            taxesYearInfo.a(null);
        } else if ("totalAmount".equals(str)) {
            taxesYearInfo.a((Amount) COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.parse(eVar));
        } else if ("year".equals(str)) {
            taxesYearInfo.a(eVar.m());
        }
    }

    public void serialize(TaxesYearInfo taxesYearInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        List<PaymentInfo> b2 = taxesYearInfo.b();
        if (b2 != null) {
            cVar.c("taxPaymentsList");
            cVar.e();
            for (PaymentInfo paymentInfo : b2) {
                if (paymentInfo != null) {
                    COM_TOUCHIN_VTB_API_PAYMENTINFO__JSONOBJECTMAPPER.serialize(paymentInfo, cVar, true);
                }
            }
            cVar.b();
        }
        if (taxesYearInfo.c() != null) {
            cVar.c("totalAmount");
            COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.serialize(taxesYearInfo.c(), cVar, true);
        }
        cVar.a("year", taxesYearInfo.d());
        if (z) {
            cVar.c();
        }
    }
}
