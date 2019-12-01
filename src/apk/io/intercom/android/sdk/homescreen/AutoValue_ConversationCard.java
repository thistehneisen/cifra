package io.intercom.android.sdk.homescreen;

import io.intercom.android.sdk.models.Conversation;
import java.util.List;

final class AutoValue_ConversationCard extends ConversationCard {
    private final boolean hasOlderConversations;
    private final boolean hasOlderUnreadConversations;
    private final boolean isLoading;
    private final List<Conversation> recentConversations;

    static final class Builder extends io.intercom.android.sdk.homescreen.ConversationCard.Builder {
        private Boolean hasOlderConversations;
        private Boolean hasOlderUnreadConversations;
        private Boolean isLoading;
        private List<Conversation> recentConversations;

        Builder() {
        }

        public ConversationCard build() {
            String str = "";
            if (this.isLoading == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" isLoading");
                str = sb.toString();
            }
            if (this.recentConversations == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" recentConversations");
                str = sb2.toString();
            }
            if (this.hasOlderConversations == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" hasOlderConversations");
                str = sb3.toString();
            }
            if (this.hasOlderUnreadConversations == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" hasOlderUnreadConversations");
                str = sb4.toString();
            }
            if (str.isEmpty()) {
                AutoValue_ConversationCard autoValue_ConversationCard = new AutoValue_ConversationCard(this.isLoading.booleanValue(), this.recentConversations, this.hasOlderConversations.booleanValue(), this.hasOlderUnreadConversations.booleanValue());
                return autoValue_ConversationCard;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Missing required properties:");
            sb5.append(str);
            throw new IllegalStateException(sb5.toString());
        }

        public io.intercom.android.sdk.homescreen.ConversationCard.Builder hasOlderConversations(boolean z) {
            this.hasOlderConversations = Boolean.valueOf(z);
            return this;
        }

        public io.intercom.android.sdk.homescreen.ConversationCard.Builder hasOlderUnreadConversations(boolean z) {
            this.hasOlderUnreadConversations = Boolean.valueOf(z);
            return this;
        }

        public io.intercom.android.sdk.homescreen.ConversationCard.Builder isLoading(boolean z) {
            this.isLoading = Boolean.valueOf(z);
            return this;
        }

        public io.intercom.android.sdk.homescreen.ConversationCard.Builder recentConversations(List<Conversation> list) {
            if (list != null) {
                this.recentConversations = list;
                return this;
            }
            throw new NullPointerException("Null recentConversations");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConversationCard)) {
            return false;
        }
        ConversationCard conversationCard = (ConversationCard) obj;
        if (!(this.isLoading == conversationCard.isLoading() && this.recentConversations.equals(conversationCard.recentConversations()) && this.hasOlderConversations == conversationCard.hasOlderConversations() && this.hasOlderUnreadConversations == conversationCard.hasOlderUnreadConversations())) {
            z = false;
        }
        return z;
    }

    public boolean hasOlderConversations() {
        return this.hasOlderConversations;
    }

    public boolean hasOlderUnreadConversations() {
        return this.hasOlderUnreadConversations;
    }

    public int hashCode() {
        int i2 = 1231;
        int hashCode = ((((((this.isLoading ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.recentConversations.hashCode()) * 1000003) ^ (this.hasOlderConversations ? 1231 : 1237)) * 1000003;
        if (!this.hasOlderUnreadConversations) {
            i2 = 1237;
        }
        return hashCode ^ i2;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public List<Conversation> recentConversations() {
        return this.recentConversations;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationCard{isLoading=");
        sb.append(this.isLoading);
        sb.append(", recentConversations=");
        sb.append(this.recentConversations);
        sb.append(", hasOlderConversations=");
        sb.append(this.hasOlderConversations);
        sb.append(", hasOlderUnreadConversations=");
        sb.append(this.hasOlderUnreadConversations);
        sb.append("}");
        return sb.toString();
    }

    private AutoValue_ConversationCard(boolean z, List<Conversation> list, boolean z2, boolean z3) {
        this.isLoading = z;
        this.recentConversations = list;
        this.hasOlderConversations = z2;
        this.hasOlderUnreadConversations = z3;
    }
}
