package io.intercom.android.sdk.models.events.failure;

public class UploadFailedEvent {
    private final String partId;
    private final int position;

    public UploadFailedEvent(int i2, String str) {
        this.position = i2;
        this.partId = str;
    }

    public String getPartId() {
        return this.partId;
    }

    public int getPosition() {
        return this.position;
    }
}
