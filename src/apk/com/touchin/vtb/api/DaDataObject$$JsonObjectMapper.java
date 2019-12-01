package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;
import com.bluelinelabs.logansquare.util.SimpleArrayMap;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataObject$$JsonObjectMapper<TResult> extends JsonMapper<DaDataObject<TResult>> {
    private final JsonMapper<TResult> mm314694255ClassJsonMapper;

    public DaDataObject$$JsonObjectMapper(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, SimpleArrayMap<ParameterizedType, JsonMapper> simpleArrayMap) {
        simpleArrayMap.put(parameterizedType, this);
        this.mm314694255ClassJsonMapper = LoganSquare.mapperFor(parameterizedType2, simpleArrayMap);
    }

    public DaDataObject<TResult> parse(e eVar) throws IOException {
        DaDataObject<TResult> daDataObject = new DaDataObject<>();
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
            parseField(daDataObject, c2, eVar);
            eVar.G();
        }
        return daDataObject;
    }

    public void parseField(DaDataObject<TResult> daDataObject, String str, e eVar) throws IOException {
        if ("data".equals(str)) {
            daDataObject.b(this.mm314694255ClassJsonMapper.parse(eVar));
        } else if ("value".equals(str)) {
            daDataObject.a(eVar.c(null));
        }
    }

    public void serialize(DaDataObject<TResult> daDataObject, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        if (daDataObject.b() != null) {
            cVar.c("data");
            this.mm314694255ClassJsonMapper.serialize(daDataObject.b(), cVar, true);
        }
        if (daDataObject.c() != null) {
            cVar.a("value", daDataObject.c());
        }
        if (z) {
            cVar.c();
        }
    }
}
