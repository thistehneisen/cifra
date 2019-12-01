package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public class FloatMapper extends JsonMapper<Float> {
    public void parseField(Float f2, String str, e eVar) throws IOException {
    }

    public Float parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        return Float.valueOf(eVar.g());
    }

    public void serialize(Float f2, c cVar, boolean z) throws IOException {
        cVar.a(f2.floatValue());
    }
}
