package com.appsflyer;

import android.os.Build.VERSION;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AFHelper {
    public static JSONObject convertToJsonObject(Map<String, ?> map) {
        if (VERSION.SDK_INT >= 19) {
            return new JSONObject(map);
        }
        return toJsonObject(map);
    }

    public static JSONObject toJsonObject(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), m6(entry.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private static Object m6(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            if (obj.equals(JSONObject.NULL)) {
                return obj;
            }
            try {
                if (obj instanceof Collection) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object r1 : (Collection) obj) {
                        jSONArray.put(m6(r1));
                    }
                    return jSONArray;
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < length; i2++) {
                        jSONArray2.put(m6(Array.get(obj, i2)));
                    }
                    return jSONArray2;
                } else if (obj instanceof Map) {
                    return toJsonObject((Map) obj);
                } else {
                    if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                        obj = obj.toString();
                    }
                    return obj;
                }
            } catch (Exception unused) {
                obj = JSONObject.NULL;
            }
        }
        return obj;
    }
}
