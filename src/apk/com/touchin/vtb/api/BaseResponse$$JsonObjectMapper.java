package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.bluelinelabs.logansquare.util.SimpleArrayMap;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class BaseResponse$$JsonObjectMapper<T> extends JsonMapper<BaseResponse<T>> {
    private static TypeConverter<ApiError> com_touchin_vtb_api_ApiError_type_converter;
    private final JsonMapper<T> m84ClassJsonMapper;

    public BaseResponse$$JsonObjectMapper(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, SimpleArrayMap<ParameterizedType, JsonMapper> simpleArrayMap) {
        simpleArrayMap.put(parameterizedType, this);
        this.m84ClassJsonMapper = LoganSquare.mapperFor(parameterizedType2, simpleArrayMap);
    }

    private static final TypeConverter<ApiError> getcom_touchin_vtb_api_ApiError_type_converter() {
        if (com_touchin_vtb_api_ApiError_type_converter == null) {
            com_touchin_vtb_api_ApiError_type_converter = LoganSquare.typeConverterFor(ApiError.class);
        }
        return com_touchin_vtb_api_ApiError_type_converter;
    }

    public BaseResponse<T> parse(e eVar) throws IOException {
        BaseResponse<T> baseResponse = new BaseResponse<>();
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
            parseField(baseResponse, c2, eVar);
            eVar.G();
        }
        return baseResponse;
    }

    public void parseField(BaseResponse<T> baseResponse, String str, e eVar) throws IOException {
        if ("errorCode".equals(str)) {
            baseResponse.a((ApiError) getcom_touchin_vtb_api_ApiError_type_converter().parse(eVar));
        } else if ("errorMessage".equals(str)) {
            baseResponse.a(eVar.c(null));
        } else if ("result".equals(str)) {
            baseResponse.b(this.m84ClassJsonMapper.parse(eVar));
        }
    }

    public void serialize(BaseResponse<T> baseResponse, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (baseResponse.b() != null) {
            getcom_touchin_vtb_api_ApiError_type_converter().serialize(baseResponse.b(), "errorCode", true, cVar);
        }
        if (baseResponse.c() != null) {
            cVar.a("errorMessage", baseResponse.c());
        }
        if (baseResponse.d() != null) {
            cVar.c("result");
            this.m84ClassJsonMapper.serialize(baseResponse.d(), cVar, true);
        }
        if (z) {
            cVar.c();
        }
    }
}
