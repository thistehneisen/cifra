package com.touchin.vtb.api;

import com.appsflyer.AppsFlyerProperties;
import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.math.BigDecimal;

public final class Amount$$JsonObjectMapper extends JsonMapper<Amount> {
    private static TypeConverter<BigDecimal> java_math_BigDecimal_type_converter;

    private static final TypeConverter<BigDecimal> getjava_math_BigDecimal_type_converter() {
        if (java_math_BigDecimal_type_converter == null) {
            java_math_BigDecimal_type_converter = LoganSquare.typeConverterFor(BigDecimal.class);
        }
        return java_math_BigDecimal_type_converter;
    }

    public Amount parse(e eVar) throws IOException {
        Amount amount = new Amount();
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
            parseField(amount, c2, eVar);
            eVar.G();
        }
        return amount;
    }

    public void parseField(Amount amount, String str, e eVar) throws IOException {
        if (AppsFlyerProperties.CURRENCY_CODE.equals(str)) {
            amount.a(eVar.c(null));
        } else if ("sumAmount".equals(str)) {
            amount.a((BigDecimal) getjava_math_BigDecimal_type_converter().parse(eVar));
        }
    }

    public void serialize(Amount amount, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (amount.b() != null) {
            cVar.a(AppsFlyerProperties.CURRENCY_CODE, amount.b());
        }
        if (amount.c() != null) {
            getjava_math_BigDecimal_type_converter().serialize(amount.c(), "sumAmount", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
