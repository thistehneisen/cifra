package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class UserSessionCreateBody$$JsonObjectMapper extends JsonMapper<UserSessionCreateBody> {
    private static TypeConverter<Platform> com_touchin_vtb_api_Platform_type_converter;

    private static final TypeConverter<Platform> getcom_touchin_vtb_api_Platform_type_converter() {
        if (com_touchin_vtb_api_Platform_type_converter == null) {
            com_touchin_vtb_api_Platform_type_converter = LoganSquare.typeConverterFor(Platform.class);
        }
        return com_touchin_vtb_api_Platform_type_converter;
    }

    public UserSessionCreateBody parse(e eVar) throws IOException {
        UserSessionCreateBody userSessionCreateBody = new UserSessionCreateBody();
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
            parseField(userSessionCreateBody, c2, eVar);
            eVar.G();
        }
        return userSessionCreateBody;
    }

    public void parseField(UserSessionCreateBody userSessionCreateBody, String str, e eVar) throws IOException {
        if ("appVersion".equals(str)) {
            userSessionCreateBody.a(eVar.c(null));
        } else if ("model".equals(str)) {
            userSessionCreateBody.b(eVar.c(null));
        } else if ("osVersion".equals(str)) {
            userSessionCreateBody.c(eVar.c(null));
        } else if ("platform".equals(str)) {
            userSessionCreateBody.a((Platform) getcom_touchin_vtb_api_Platform_type_converter().parse(eVar));
        }
    }

    public void serialize(UserSessionCreateBody userSessionCreateBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (userSessionCreateBody.b() != null) {
            cVar.a("appVersion", userSessionCreateBody.b());
        }
        if (userSessionCreateBody.c() != null) {
            cVar.a("model", userSessionCreateBody.c());
        }
        if (userSessionCreateBody.d() != null) {
            cVar.a("osVersion", userSessionCreateBody.d());
        }
        if (userSessionCreateBody.e() != null) {
            getcom_touchin_vtb_api_Platform_type_converter().serialize(userSessionCreateBody.e(), "platform", true, cVar);
        }
        if (z) {
            cVar.c();
        }
    }
}
