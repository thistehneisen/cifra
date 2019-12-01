package io.intercom.android.sdk.nexus;

import java.util.HashMap;

public class EventData extends HashMap<String, Object> {
    public EventData() {
    }

    public long optLong(String str) {
        return optLong(str, -1);
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public EventData(int i2) {
        super(i2);
    }

    public long optLong(String str, long j2) {
        Object obj = get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j2;
    }

    public String optString(String str, String str2) {
        Object obj = get(str);
        return obj instanceof String ? (String) obj : str2;
    }
}
