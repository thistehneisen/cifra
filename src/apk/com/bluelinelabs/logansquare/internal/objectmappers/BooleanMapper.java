package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public class BooleanMapper extends JsonMapper<Boolean> {
    public void parseField(Boolean bool, String str, e eVar) throws IOException {
    }

    public Boolean parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        return Boolean.valueOf(eVar.a());
    }

    public void serialize(Boolean bool, c cVar, boolean z) throws IOException {
        cVar.a(bool.booleanValue());
    }
}
