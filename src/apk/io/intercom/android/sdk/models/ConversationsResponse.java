package io.intercom.android.sdk.models;

public class ConversationsResponse extends BaseResponse {
    private final ConversationList conversationPage;

    public static final class Builder extends Builder {
        io.intercom.android.sdk.models.ConversationList.Builder conversation_page;

        public ConversationsResponse build() {
            return new ConversationsResponse(this);
        }
    }

    ConversationsResponse(Builder builder) {
        ConversationList conversationList;
        super(builder);
        io.intercom.android.sdk.models.ConversationList.Builder builder2 = builder.conversation_page;
        if (builder2 == null) {
            conversationList = new io.intercom.android.sdk.models.ConversationList.Builder().build();
        } else {
            conversationList = builder2.build();
        }
        this.conversationPage = conversationList;
    }

    public ConversationList getConversationPage() {
        return this.conversationPage;
    }
}
