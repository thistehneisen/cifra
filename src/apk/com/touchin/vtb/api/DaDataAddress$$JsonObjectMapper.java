package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataAddress$$JsonObjectMapper extends JsonMapper<DaDataAddress> {
    private JsonMapper<DaDataObject<DaDataAddressDescription>> parentObjectMapper = LoganSquare.mapperFor((ParameterizedType<E>) new i<E>(this));

    public DaDataAddress parse(e eVar) throws IOException {
        DaDataAddress daDataAddress = new DaDataAddress();
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
            parseField(daDataAddress, c2, eVar);
            eVar.G();
        }
        return daDataAddress;
    }

    public void parseField(DaDataAddress daDataAddress, String str, e eVar) throws IOException {
        this.parentObjectMapper.parseField(daDataAddress, str, eVar);
    }

    public void serialize(DaDataAddress daDataAddress, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        this.parentObjectMapper.serialize(daDataAddress, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
