package io.intercom.android.sdk.models.events.failure;

public class NewConversationFailedEvent {
    private final String partId;
    private final int position;

    public NewConversationFailedEvent(int i2, String str) {
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
