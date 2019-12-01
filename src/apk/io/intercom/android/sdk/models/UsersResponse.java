package io.intercom.android.sdk.models;

public class UsersResponse extends BaseResponse {
    private final ConversationList unreadConversations;

    public static class Builder extends Builder {
        io.intercom.android.sdk.models.ConversationList.Builder unread_conversations;

        public UsersResponse build() {
            return new UsersResponse(this);
        }
    }

    UsersResponse(Builder builder) {
        ConversationList conversationList;
        super(builder);
        io.intercom.android.sdk.models.ConversationList.Builder builder2 = builder.unread_conversations;
        if (builder2 == null) {
            conversationList = new io.intercom.android.sdk.models.ConversationList.Builder().build();
        } else {
            conversationList = builder2.build();
        }
        this.unreadConversations = conversationList;
    }

    public ConversationList getUnreadConversations() {
        return this.unreadConversations;
    }
}
