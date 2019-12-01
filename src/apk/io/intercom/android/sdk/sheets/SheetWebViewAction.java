package io.intercom.android.sdk.sheets;

import java.util.Map;

public class SheetWebViewAction {
    private final Map<String, Object> metaData;
    private final Map<String, Object> payload;
    private final String type;

    public SheetWebViewAction(String str, Map<String, Object> map, Map<String, Object> map2) {
        this.type = str;
        this.payload = map;
        this.metaData = map2;
    }

    public Map<String, Object> getMetaData() {
        return this.metaData;
    }

    public Map<String, Object> getPayload() {
        return this.payload;
    }

    public String getType() {
        return this.type;
    }
}
