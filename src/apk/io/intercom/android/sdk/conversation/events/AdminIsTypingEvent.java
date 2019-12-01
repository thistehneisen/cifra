package io.intercom.android.sdk.conversation.events;

public class AdminIsTypingEvent {
    private final String adminAvatarUrl;
    private final String adminId;
    private final String adminName;
    private final String conversationId;

    public AdminIsTypingEvent(String str, String str2, String str3, String str4) {
        this.adminId = str;
        this.conversationId = str2;
        this.adminName = str3;
        this.adminAvatarUrl = str4;
    }

    public String getAdminAvatarUrl() {
        return this.adminAvatarUrl;
    }

    public String getAdminId() {
        return this.adminId;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public String getConversationId() {
        return this.conversationId;
    }
}
