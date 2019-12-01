package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class TaxesListResponse$$JsonObjectMapper extends JsonMapper<TaxesListResponse> {
    private static final JsonMapper<Amount> COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER = LoganSquare.mapperFor(Amount.class);
    private static final JsonMapper<TaxesYearInfo> COM_TOUCHIN_VTB_API_TAXESYEARINFO__JSONOBJECTMAPPER = LoganSquare.mapperFor(TaxesYearInfo.class);

    public TaxesListResponse parse(e eVar) throws IOException {
        TaxesListResponse taxesListResponse = new TaxesListResponse();
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
            parseField(taxesListResponse, c2, eVar);
            eVar.G();
        }
        return taxesListResponse;
    }

    public void parseField(TaxesListResponse taxesListResponse, String str, e eVar) throws IOException {
        if ("amount".equals(str)) {
            taxesListResponse.a((Amount) COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.parse(eVar));
        } else if (!"taxesList".equals(str)) {
        } else {
            if (eVar.d() == g.START_ARRAY) {
                ArrayList arrayList = new ArrayList();
                while (eVar.F() != g.END_ARRAY) {
                    arrayList.add((TaxesYearInfo) COM_TOUCHIN_VTB_API_TAXESYEARINFO__JSONOBJECTMAPPER.parse(eVar));
                }
                taxesListResponse.a((List<TaxesYearInfo>) arrayList);
                return;
            }
            taxesListResponse.a(null);
        }
    }

    public void serialize(TaxesListResponse taxesListResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (taxesListResponse.b() != null) {
            cVar.c("amount");
            COM_TOUCHIN_VTB_API_AMOUNT__JSONOBJECTMAPPER.serialize(taxesListResponse.b(), cVar, true);
        }
        List<TaxesYearInfo> c2 = taxesListResponse.c();
        if (c2 != null) {
            cVar.c("taxesList");
            cVar.e();
            for (TaxesYearInfo taxesYearInfo : c2) {
                if (taxesYearInfo != null) {
                    COM_TOUCHIN_VTB_API_TAXESYEARINFO__JSONOBJECTMAPPER.serialize(taxesYearInfo, cVar, true);
                }
            }
            cVar.b();
        }
        if (z) {
            cVar.c();
        }
    }
}
