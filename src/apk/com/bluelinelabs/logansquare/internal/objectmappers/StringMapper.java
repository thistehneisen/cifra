package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;

public class StringMapper extends JsonMapper<String> {
    public void parseField(String str, String str2, e eVar) throws IOException {
    }

    public String parse(e eVar) throws IOException {
        return eVar.j();
    }

    public void serialize(String str, c cVar, boolean z) throws IOException {
        cVar.f(str);
    }
}
