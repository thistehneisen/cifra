package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.Part;

public class ReplyPart {
    private final String conversationId;
    private final Part part;

    public ReplyPart(Part part2, String str) {
        this.part = part2;
        this.conversationId = str;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Part getPart() {
        return this.part;
    }
}
