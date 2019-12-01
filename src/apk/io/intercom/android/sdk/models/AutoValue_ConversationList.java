package io.intercom.android.sdk.models;

import java.util.List;
import java.util.Set;

final class AutoValue_ConversationList extends ConversationList {
    private final List<Conversation> getConversations;
    private final Set<String> getUnreadConversationIds;
    private final boolean hasMorePages;

    AutoValue_ConversationList(List<Conversation> list, Set<String> set, boolean z) {
        if (list != null) {
            this.getConversations = list;
            if (set != null) {
                this.getUnreadConversationIds = set;
                this.hasMorePages = z;
                return;
            }
            throw new NullPointerException("Null getUnreadConversationIds");
        }
        throw new NullPointerException("Null getConversations");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConversationList)) {
            return false;
        }
        ConversationList conversationList = (ConversationList) obj;
        if (!this.getConversations.equals(conversationList.getConversations()) || !this.getUnreadConversationIds.equals(conversationList.getUnreadConversationIds()) || this.hasMorePages != conversationList.hasMorePages()) {
            z = false;
        }
        return z;
    }

    public List<Conversation> getConversations() {
        return this.getConversations;
    }

    public Set<String> getUnreadConversationIds() {
        return this.getUnreadConversationIds;
    }

    public boolean hasMorePages() {
        return this.hasMorePages;
    }

    public int hashCode() {
        return ((((this.getConversations.hashCode() ^ 1000003) * 1000003) ^ this.getUnreadConversationIds.hashCode()) * 1000003) ^ (this.hasMorePages ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationList{getConversations=");
        sb.append(this.getConversations);
        sb.append(", getUnreadConversationIds=");
        sb.append(this.getUnreadConversationIds);
        sb.append(", hasMorePages=");
        sb.append(this.hasMorePages);
        sb.append("}");
        return sb.toString();
    }
}
