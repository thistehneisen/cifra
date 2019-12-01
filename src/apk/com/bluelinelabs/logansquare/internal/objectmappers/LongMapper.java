package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public class LongMapper extends JsonMapper<Long> {
    public void parseField(Long l2, String str, e eVar) throws IOException {
    }

    public Long parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        return Long.valueOf(eVar.i());
    }

    public void serialize(Long l2, c cVar, boolean z) throws IOException {
        cVar.h(l2.longValue());
    }
}
