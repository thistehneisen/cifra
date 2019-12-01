package io.intercom.android.sdk.blocks.messengercard;

import java.util.Map;

public class MessengerCardWebViewAction {
    private final Map<String, Object> payload;
    private final String type;

    public MessengerCardWebViewAction(String str, Map<String, Object> map) {
        this.type = str;
        this.payload = map;
    }

    public Map<String, Object> getPayload() {
        return this.payload;
    }

    public String getType() {
        return this.type;
    }
}
