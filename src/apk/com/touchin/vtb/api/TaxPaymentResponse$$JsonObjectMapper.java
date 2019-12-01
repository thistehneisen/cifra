package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class TaxPaymentResponse$$JsonObjectMapper extends JsonMapper<TaxPaymentResponse> {
    private static TypeConverter<TaxPaymentStatus> com_touchin_vtb_api_TaxPaymentStatus_type_converter;

    private static final TypeConverter<TaxPaymentStatus> getcom_touchin_vtb_api_TaxPaymentStatus_type_converter() {
        if (com_touchin_vtb_api_TaxPaymentStatus_type_converter == null) {
            com_touchin_vtb_api_TaxPaymentStatus_type_converter = LoganSquare.typeConverterFor(TaxPaymentStatus.class);
        }
        return com_touchin_vtb_api_TaxPaymentStatus_type_converter;
    }

    public TaxPaymentResponse parse(e eVar) throws IOException {
        TaxPaymentResponse taxPaymentResponse = new TaxPaymentResponse();
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
            parseField(taxPaymentResponse, c2, eVar);
            eVar.G();
        }
        return taxPaymentResponse;
    }

    public void parseField(TaxPaymentResponse taxPaymentResponse, String str, e eVar) throws IOException {
        if ("smsOperationId".equals(str)) {
            taxPaymentResponse.a(eVar.c(null));
        } else if ("taxPaymentStatus".equals(str)) {
            taxPaymentResponse.a((TaxPaymentStatus) getcom_touchin_vtb_api_TaxPaymentStatus_type_converter().parse(eVar));
        }
    }

    public void serialize(TaxPaymentResponse taxPaymentResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (taxPaymentResponse.b() != null) {
            cVar.a("smsOperationId", taxPaymentResponse.b());
        }
        if (taxPaymentResponse.c() != null) {
            getcom_touchin_vtb_api_TaxPaymentStatus_type_converter().serialize(taxPaymentResponse.c(), "taxPaymentStatus", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
