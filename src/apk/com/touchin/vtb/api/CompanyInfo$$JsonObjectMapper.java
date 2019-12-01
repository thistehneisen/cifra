package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import org.joda.time.b;

public final class CompanyInfo$$JsonObjectMapper extends JsonMapper<CompanyInfo> {
    private static TypeConverter<CompanyType> com_touchin_vtb_api_CompanyType_type_converter;
    private static TypeConverter<TaxSystem> com_touchin_vtb_api_TaxSystem_type_converter;
    private static TypeConverter<b> org_joda_time_DateTime_type_converter;

    private static final TypeConverter<CompanyType> getcom_touchin_vtb_api_CompanyType_type_converter() {
        if (com_touchin_vtb_api_CompanyType_type_converter == null) {
            com_touchin_vtb_api_CompanyType_type_converter = LoganSquare.typeConverterFor(CompanyType.class);
        }
        return com_touchin_vtb_api_CompanyType_type_converter;
    }

    private static final TypeConverter<TaxSystem> getcom_touchin_vtb_api_TaxSystem_type_converter() {
        if (com_touchin_vtb_api_TaxSystem_type_converter == null) {
            com_touchin_vtb_api_TaxSystem_type_converter = LoganSquare.typeConverterFor(TaxSystem.class);
        }
        return com_touchin_vtb_api_TaxSystem_type_converter;
    }

    private static final TypeConverter<b> getorg_joda_time_DateTime_type_converter() {
        if (org_joda_time_DateTime_type_converter == null) {
            org_joda_time_DateTime_type_converter = LoganSquare.typeConverterFor(b.class);
        }
        return org_joda_time_DateTime_type_converter;
    }

    public CompanyInfo parse(e eVar) throws IOException {
        CompanyInfo companyInfo = new CompanyInfo();
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
            parseField(companyInfo, c2, eVar);
            eVar.G();
        }
        return companyInfo;
    }

    public void parseField(CompanyInfo companyInfo, String str, e eVar) throws IOException {
        if ("address".equals(str)) {
            companyInfo.a(eVar.c(null));
        } else if ("companyType".equals(str)) {
            companyInfo.a((CompanyType) getcom_touchin_vtb_api_CompanyType_type_converter().parse(eVar));
        } else if ("inn".equals(str)) {
            companyInfo.b(eVar.c(null));
        } else if ("ogrn".equals(str)) {
            companyInfo.c(eVar.c(null));
        } else if ("registrationDate".equals(str)) {
            companyInfo.a((b) getorg_joda_time_DateTime_type_converter().parse(eVar));
        } else if ("taxSystem".equals(str)) {
            companyInfo.a((TaxSystem) getcom_touchin_vtb_api_TaxSystem_type_converter().parse(eVar));
        } else if ("title".equals(str)) {
            companyInfo.d(eVar.c(null));
        }
    }

    public void serialize(CompanyInfo companyInfo, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (companyInfo.b() != null) {
            cVar.a("address", companyInfo.b());
        }
        if (companyInfo.c() != null) {
            getcom_touchin_vtb_api_CompanyType_type_converter().serialize(companyInfo.c(), "companyType", true, cVar);
        }
        if (companyInfo.d() != null) {
            cVar.a("inn", companyInfo.d());
        }
        if (companyInfo.e() != null) {
            cVar.a("ogrn", companyInfo.e());
        }
        if (companyInfo.f() != null) {
            getorg_joda_time_DateTime_type_converter().serialize(companyInfo.f(), "registrationDate", true, cVar);
        }
        if (companyInfo.g() != null) {
            getcom_touchin_vtb_api_TaxSystem_type_converter().serialize(companyInfo.g(), "taxSystem", true, cVar);
        }
        if (companyInfo.h() != null) {
            cVar.a("title", companyInfo.h());
        }
        if (z) {
            cVar.c();
        }
    }
}
