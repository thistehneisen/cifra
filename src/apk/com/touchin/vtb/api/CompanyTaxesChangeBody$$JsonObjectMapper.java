package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class CompanyTaxesChangeBody$$JsonObjectMapper extends JsonMapper<CompanyTaxesChangeBody> {
    private static TypeConverter<TaxSystem> com_touchin_vtb_api_TaxSystem_type_converter;
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    private static final TypeConverter<TaxSystem> getcom_touchin_vtb_api_TaxSystem_type_converter() {
        if (com_touchin_vtb_api_TaxSystem_type_converter == null) {
            com_touchin_vtb_api_TaxSystem_type_converter = LoganSquare.typeConverterFor(TaxSystem.class);
        }
        return com_touchin_vtb_api_TaxSystem_type_converter;
    }

    public CompanyTaxesChangeBody parse(e eVar) throws IOException {
        CompanyTaxesChangeBody companyTaxesChangeBody = new CompanyTaxesChangeBody();
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
            parseField(companyTaxesChangeBody, c2, eVar);
            eVar.G();
        }
        return companyTaxesChangeBody;
    }

    public void parseField(CompanyTaxesChangeBody companyTaxesChangeBody, String str, e eVar) throws IOException {
        if ("taxSystem".equals(str)) {
            companyTaxesChangeBody.a((TaxSystem) getcom_touchin_vtb_api_TaxSystem_type_converter().parse(eVar));
        } else {
            parentObjectMapper.parseField(companyTaxesChangeBody, str, eVar);
        }
    }

    public void serialize(CompanyTaxesChangeBody companyTaxesChangeBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (companyTaxesChangeBody.c() != null) {
            getcom_touchin_vtb_api_TaxSystem_type_converter().serialize(companyTaxesChangeBody.c(), "taxSystem", true, cVar);
        }
        parentObjectMapper.serialize(companyTaxesChangeBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
