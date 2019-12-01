package com.bluelinelabs.logansquare.internal.objectmappers;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ObjectMapper extends JsonMapper<Object> {

    /* renamed from: com.bluelinelabs.logansquare.internal.objectmappers.ObjectMapper$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[g.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_NULL.ordinal()] = 1;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_FALSE.ordinal()] = 2;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_TRUE.ordinal()] = 3;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_NUMBER_INT.ordinal()] = 5;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_STRING.ordinal()] = 6;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.VALUE_EMBEDDED_OBJECT.ordinal()] = 7;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.START_OBJECT.ordinal()] = 8;
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[g.START_ARRAY.ordinal()] = 9;
        }
    }

    public Object parse(e eVar) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[eVar.d().ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(false);
            case 3:
                return Boolean.valueOf(true);
            case 4:
                return Double.valueOf(eVar.e());
            case 5:
                return Long.valueOf(eVar.i());
            case 6:
                return eVar.j();
            case 7:
                return LoganSquare.mapperFor(Map.class).parse(eVar);
            case 8:
                return LoganSquare.mapperFor(Map.class).parse(eVar);
            case 9:
                return LoganSquare.mapperFor(List.class).parse(eVar);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid json token encountered: ");
                sb.append(eVar.d());
                throw new RuntimeException(sb.toString());
        }
    }

    public void parseField(Object obj, String str, e eVar) throws IOException {
    }

    public void serialize(Object obj, c cVar, boolean z) throws IOException {
        if (obj == null) {
            cVar.d();
        } else if (obj instanceof String) {
            cVar.f((String) obj);
        } else if (obj instanceof Integer) {
            cVar.a(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            cVar.h(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            cVar.a(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            cVar.a(((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            cVar.a(((Boolean) obj).booleanValue());
        } else if (obj instanceof List) {
            LoganSquare.mapperFor(List.class).serialize((List) obj, cVar, z);
        } else if (obj instanceof Map) {
            LoganSquare.mapperFor(Map.class).serialize((Map) obj, cVar, z);
        } else {
            JsonMapper mapperFor = LoganSquare.mapperFor(obj.getClass());
            if (mapperFor != null) {
                if (z) {
                    cVar.f();
                }
                mapperFor.serialize(obj, cVar, false);
                if (z) {
                    cVar.c();
                }
            }
        }
    }
}
