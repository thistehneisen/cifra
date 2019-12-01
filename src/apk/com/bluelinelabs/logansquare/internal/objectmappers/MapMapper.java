package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import java.io.IOException;
import java.util.Map;

public class MapMapper extends JsonMapper<Map<String, Object>> {
    public void parseField(Map<String, Object> map, String str, e eVar) throws IOException {
    }

    public Map<String, Object> parse(e eVar) throws IOException {
        return LoganSquare.mapperFor(Object.class).parseMap(eVar);
    }

    public void serialize(Map<String, Object> map, c cVar, boolean z) throws IOException {
        LoganSquare.mapperFor(Object.class).serialize(map, cVar);
    }
}
