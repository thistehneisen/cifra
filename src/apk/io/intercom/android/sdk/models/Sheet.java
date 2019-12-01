package io.intercom.android.sdk.models;

import io.intercom.com.google.gson.v;

public class Sheet {
    private final String body;

    public static final class Builder {
        v sheet_request_body;
        String sheet_title;

        public Sheet build() {
            return new Sheet(this);
        }
    }

    Sheet(Builder builder) {
        v vVar = builder.sheet_request_body;
        this.body = vVar == null ? "" : vVar.toString();
    }

    public String getBody() {
        return this.body;
    }
}
