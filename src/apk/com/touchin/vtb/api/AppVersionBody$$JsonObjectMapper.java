package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class AppVersionBody$$JsonObjectMapper extends JsonMapper<AppVersionBody> {
    private static TypeConverter<Platform> com_touchin_vtb_api_Platform_type_converter;
    private static final JsonMapper<SessionIdBody> parentObjectMapper = LoganSquare.mapperFor(SessionIdBody.class);

    private static final TypeConverter<Platform> getcom_touchin_vtb_api_Platform_type_converter() {
        if (com_touchin_vtb_api_Platform_type_converter == null) {
            com_touchin_vtb_api_Platform_type_converter = LoganSquare.typeConverterFor(Platform.class);
        }
        return com_touchin_vtb_api_Platform_type_converter;
    }

    public AppVersionBody parse(e eVar) throws IOException {
        AppVersionBody appVersionBody = new AppVersionBody();
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
            parseField(appVersionBody, c2, eVar);
            eVar.G();
        }
        return appVersionBody;
    }

    public void parseField(AppVersionBody appVersionBody, String str, e eVar) throws IOException {
        if ("appVersion".equals(str)) {
            appVersionBody.b(eVar.c(null));
        } else if ("platform".equals(str)) {
            appVersionBody.a((Platform) getcom_touchin_vtb_api_Platform_type_converter().parse(eVar));
        } else {
            parentObjectMapper.parseField(appVersionBody, str, eVar);
        }
    }

    public void serialize(AppVersionBody appVersionBody, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (appVersionBody.c() != null) {
            cVar.a("appVersion", appVersionBody.c());
        }
        if (appVersionBody.d() != null) {
            getcom_touchin_vtb_api_Platform_type_converter().serialize(appVersionBody.d(), "platform", true, cVar);
        }
        parentObjectMapper.serialize(appVersionBody, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
