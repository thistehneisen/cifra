package io.intercom.android.sdk.models;

import java.util.ArrayList;
import java.util.List;

public class HomeCardsResponse extends BaseResponse {
    private final List<HomeCard> cards;
    private final List<Conversation> conversations = new ArrayList();
    private final boolean hasMoreConversations;

    public static class Builder extends Builder {
        List<io.intercom.android.sdk.models.HomeCard.Builder> cards;
        List<io.intercom.android.sdk.models.Conversation.Builder> conversations;
        boolean has_more_conversations;

        public HomeCardsResponse build() {
            return new HomeCardsResponse(this);
        }
    }

    HomeCardsResponse(Builder builder) {
        super(builder);
        List<io.intercom.android.sdk.models.Conversation.Builder> list = builder.conversations;
        if (list != null) {
            for (io.intercom.android.sdk.models.Conversation.Builder build : list) {
                this.conversations.add(build.build());
            }
        }
        this.cards = new ArrayList();
        List<io.intercom.android.sdk.models.HomeCard.Builder> list2 = builder.cards;
        if (list2 != null) {
            for (io.intercom.android.sdk.models.HomeCard.Builder build2 : list2) {
                this.cards.add(build2.build());
            }
        }
        this.hasMoreConversations = builder.has_more_conversations;
    }

    public List<HomeCard> getCards() {
        return this.cards;
    }

    public List<Conversation> getConversations() {
        return this.conversations;
    }

    public boolean hasMoreConversations() {
        return this.hasMoreConversations;
    }
}
