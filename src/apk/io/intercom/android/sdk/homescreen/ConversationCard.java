package io.intercom.android.sdk.homescreen;

import io.intercom.android.sdk.models.Conversation;
import java.util.ArrayList;
import java.util.List;

public abstract class ConversationCard {

    public static abstract class Builder {
        public abstract ConversationCard build();

        public abstract Builder hasOlderConversations(boolean z);

        public abstract Builder hasOlderUnreadConversations(boolean z);

        public abstract Builder isLoading(boolean z);

        public abstract Builder recentConversations(List<Conversation> list);
    }

    public static Builder builder() {
        return new Builder().recentConversations(new ArrayList()).hasOlderConversations(false).hasOlderUnreadConversations(false).isLoading(false);
    }

    public abstract boolean hasOlderConversations();

    public abstract boolean hasOlderUnreadConversations();

    public abstract boolean isLoading();

    public abstract List<Conversation> recentConversations();
}
