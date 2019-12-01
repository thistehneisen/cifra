package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;
import java.util.List;

public class ListMapper extends JsonMapper<List<Object>> {
    public void parseField(List<Object> list, String str, e eVar) throws IOException {
    }

    public List<Object> parse(e eVar) throws IOException {
        return LoganSquare.mapperFor(Object.class).parseList(eVar);
    }

    public void serialize(List<Object> list, c cVar, boolean z) throws IOException {
        LoganSquare.mapperFor(Object.class).serialize(list, cVar);
    }
}
