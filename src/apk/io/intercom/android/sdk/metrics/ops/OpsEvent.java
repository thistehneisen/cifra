package io.intercom.android.sdk.metrics.ops;

public class OpsEvent {
    private final String eventType;
    private final String name;
    private final long timestamp;

    public OpsEvent(String str, String str2, long j2) {
        this.eventType = str;
        this.name = str2;
        this.timestamp = j2;
    }

    public String getEventType() {
        return this.eventType;
    }

    public String getName() {
        return this.name;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
