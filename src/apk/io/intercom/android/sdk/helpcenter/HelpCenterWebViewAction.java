package io.intercom.android.sdk.helpcenter;

import java.util.Map;

public class HelpCenterWebViewAction {
    private final String type;
    private final Map<String, Object> value;

    public HelpCenterWebViewAction(String str, Map<String, Object> map) {
        this.type = str;
        this.value = map;
    }

    public String getType() {
        return this.type;
    }

    public Map<String, Object> getValue() {
        return this.value;
    }
}
