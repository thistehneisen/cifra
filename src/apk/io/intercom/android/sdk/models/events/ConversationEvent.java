package io.intercom.android.sdk.models.events;

import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class ConversationEvent {

    public static final class Builder {
        private final Conversation conversation;
        private Boolean isAttributeUpdated;

        public Builder(Conversation conversation2) {
            this.conversation = conversation2;
        }

        public ConversationEvent build() {
            Conversation conversation2 = this.conversation;
            if (conversation2 == null) {
                conversation2 = new Conversation();
            }
            return new AutoValue_ConversationEvent(conversation2, NullSafety.valueOrDefault(this.isAttributeUpdated, false));
        }

        public Builder isAttributeUpdated(boolean z) {
            this.isAttributeUpdated = Boolean.valueOf(z);
            return this;
        }
    }

    public abstract Conversation getResponse();

    public abstract boolean isAttributeUpdated();
}
