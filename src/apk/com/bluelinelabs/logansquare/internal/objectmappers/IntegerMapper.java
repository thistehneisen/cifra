package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public class IntegerMapper extends JsonMapper<Integer> {
    public void parseField(Integer num, String str, e eVar) throws IOException {
    }

    public Integer parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        return Integer.valueOf(eVar.h());
    }

    public void serialize(Integer num, c cVar, boolean z) throws IOException {
        cVar.a(num.intValue());
    }
}
