package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

public class DoubleMapper extends JsonMapper<Double> {
    public void parseField(Double d2, String str, e eVar) throws IOException {
    }

    public Double parse(e eVar) throws IOException {
        if (eVar.d() == g.VALUE_NULL) {
            return null;
        }
        return Double.valueOf(eVar.e());
    }

    public void serialize(Double d2, c cVar, boolean z) throws IOException {
        cVar.a(d2.doubleValue());
    }
}
