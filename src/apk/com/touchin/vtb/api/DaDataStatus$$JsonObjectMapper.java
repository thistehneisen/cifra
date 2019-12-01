package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.math.BigDecimal;

public final class DaDataStatus$$JsonObjectMapper extends JsonMapper<DaDataStatus> {
    private static TypeConverter<BigDecimal> java_math_BigDecimal_type_converter;

    private static final TypeConverter<BigDecimal> getjava_math_BigDecimal_type_converter() {
        if (java_math_BigDecimal_type_converter == null) {
            java_math_BigDecimal_type_converter = LoganSquare.typeConverterFor(BigDecimal.class);
        }
        return java_math_BigDecimal_type_converter;
    }

    public DaDataStatus parse(e eVar) throws IOException {
        DaDataStatus daDataStatus = new DaDataStatus();
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
            parseField(daDataStatus, c2, eVar);
            eVar.G();
        }
        return daDataStatus;
    }

    public void parseField(DaDataStatus daDataStatus, String str, e eVar) throws IOException {
        if ("registration_date".equals(str)) {
            daDataStatus.a((BigDecimal) getjava_math_BigDecimal_type_converter().parse(eVar));
        }
    }

    public void serialize(DaDataStatus daDataStatus, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataStatus.b() != null) {
            getjava_math_BigDecimal_type_converter().serialize(daDataStatus.b(), "registration_date", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
