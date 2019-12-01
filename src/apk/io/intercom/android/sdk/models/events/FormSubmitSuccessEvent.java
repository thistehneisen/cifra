package io.intercom.android.sdk.models.events;

import io.intercom.android.sdk.models.Conversation;

public class FormSubmitSuccessEvent {
    private final Conversation conversation;
    private final String partId;

    public FormSubmitSuccessEvent(Conversation conversation2, String str) {
        this.conversation = conversation2;
        this.partId = str;
    }

    public Conversation getConversation() {
        return this.conversation;
    }

    public String getPartId() {
        return this.partId;
    }
}
