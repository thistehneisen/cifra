package com.touchin.vtb.api;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.ParameterizedType;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public final class DaDataSuggestion$$JsonObjectMapper extends JsonMapper<DaDataSuggestion> {
    private JsonMapper<DaDataObject<DaDataOrganizationDescription>> parentObjectMapper = LoganSquare.mapperFor((ParameterizedType<E>) new k<E>(this));

    public DaDataSuggestion parse(e eVar) throws IOException {
        DaDataSuggestion daDataSuggestion = new DaDataSuggestion();
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
            parseField(daDataSuggestion, c2, eVar);
            eVar.G();
        }
        return daDataSuggestion;
    }

    public void parseField(DaDataSuggestion daDataSuggestion, String str, e eVar) throws IOException {
        this.parentObjectMapper.parseField(daDataSuggestion, str, eVar);
    }

    public void serialize(DaDataSuggestion daDataSuggestion, c cVar, boolean z) throws IOException {
        if (z) {
            cVar.f();
        }
        this.parentObjectMapper.serialize(daDataSuggestion, cVar, false);
        if (z) {
            cVar.c();
        }
    }
}
