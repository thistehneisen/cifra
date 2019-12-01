package io.intercom.android.sdk.utilities;

import java.util.UUID;

public interface UuidStringProvider {
    public static final UuidStringProvider SYSTEM = new UuidStringProvider() {
        public String newUuidString() {
            return UUID.randomUUID().toString();
        }
    };

    String newUuidString();
}
