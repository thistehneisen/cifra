package io.intercom.android.sdk.models.events;

import io.intercom.android.sdk.models.Conversation;

final class AutoValue_ConversationEvent extends ConversationEvent {
    private final boolean attributeUpdated;
    private final Conversation response;

    AutoValue_ConversationEvent(Conversation conversation, boolean z) {
        if (conversation != null) {
            this.response = conversation;
            this.attributeUpdated = z;
            return;
        }
        throw new NullPointerException("Null response");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConversationEvent)) {
            return false;
        }
        ConversationEvent conversationEvent = (ConversationEvent) obj;
        if (!this.response.equals(conversationEvent.getResponse()) || this.attributeUpdated != conversationEvent.isAttributeUpdated()) {
            z = false;
        }
        return z;
    }

    public Conversation getResponse() {
        return this.response;
    }

    public int hashCode() {
        return ((this.response.hashCode() ^ 1000003) * 1000003) ^ (this.attributeUpdated ? 1231 : 1237);
    }

    public boolean isAttributeUpdated() {
        return this.attributeUpdated;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationEvent{response=");
        sb.append(this.response);
        sb.append(", attributeUpdated=");
        sb.append(this.attributeUpdated);
        sb.append("}");
        return sb.toString();
    }
}
