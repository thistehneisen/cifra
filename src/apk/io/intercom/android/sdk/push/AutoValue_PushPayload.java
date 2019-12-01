package io.intercom.android.sdk.push;

final class AutoValue_PushPayload extends PushPayload {
    private final String appName;
    private final String authorName;
    private final String body;
    private final String conversationId;
    private final String conversationPartType;
    private final String imageUrl;
    private final String intercomPushType;
    private final String message;
    private final int priority;
    private final String pushOnlyConversationId;
    private final String receiver;
    private final String title;
    private final String uri;

    AutoValue_PushPayload(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i2) {
        if (str != null) {
            this.conversationId = str;
            if (str2 != null) {
                this.message = str2;
                if (str3 != null) {
                    this.body = str3;
                    if (str4 != null) {
                        this.authorName = str4;
                        if (str5 != null) {
                            this.imageUrl = str5;
                            if (str6 != null) {
                                this.appName = str6;
                                if (str7 != null) {
                                    this.receiver = str7;
                                    if (str8 != null) {
                                        this.conversationPartType = str8;
                                        if (str9 != null) {
                                            this.intercomPushType = str9;
                                            if (str10 != null) {
                                                this.uri = str10;
                                                if (str11 != null) {
                                                    this.pushOnlyConversationId = str11;
                                                    if (str12 != null) {
                                                        this.title = str12;
                                                        this.priority = i2;
                                                        return;
                                                    }
                                                    throw new NullPointerException("Null title");
                                                }
                                                throw new NullPointerException("Null pushOnlyConversationId");
                                            }
                                            throw new NullPointerException("Null uri");
                                        }
                                        throw new NullPointerException("Null intercomPushType");
                                    }
                                    throw new NullPointerException("Null conversationPartType");
                                }
                                throw new NullPointerException("Null receiver");
                            }
                            throw new NullPointerException("Null appName");
                        }
                        throw new NullPointerException("Null imageUrl");
                    }
                    throw new NullPointerException("Null authorName");
                }
                throw new NullPointerException("Null body");
            }
            throw new NullPointerException("Null message");
        }
        throw new NullPointerException("Null conversationId");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushPayload)) {
            return false;
        }
        PushPayload pushPayload = (PushPayload) obj;
        if (!this.conversationId.equals(pushPayload.getConversationId()) || !this.message.equals(pushPayload.getMessage()) || !this.body.equals(pushPayload.getBody()) || !this.authorName.equals(pushPayload.getAuthorName()) || !this.imageUrl.equals(pushPayload.getImageUrl()) || !this.appName.equals(pushPayload.getAppName()) || !this.receiver.equals(pushPayload.getReceiver()) || !this.conversationPartType.equals(pushPayload.getConversationPartType()) || !this.intercomPushType.equals(pushPayload.getIntercomPushType()) || !this.uri.equals(pushPayload.getUri()) || !this.pushOnlyConversationId.equals(pushPayload.getPushOnlyConversationId()) || !this.title.equals(pushPayload.getTitle()) || this.priority != pushPayload.getPriority()) {
            z = false;
        }
        return z;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getBody() {
        return this.body;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public String getConversationPartType() {
        return this.conversationPartType;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getIntercomPushType() {
        return this.intercomPushType;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getPushOnlyConversationId() {
        return this.pushOnlyConversationId;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.conversationId.hashCode() ^ 1000003) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.body.hashCode()) * 1000003) ^ this.authorName.hashCode()) * 1000003) ^ this.imageUrl.hashCode()) * 1000003) ^ this.appName.hashCode()) * 1000003) ^ this.receiver.hashCode()) * 1000003) ^ this.conversationPartType.hashCode()) * 1000003) ^ this.intercomPushType.hashCode()) * 1000003) ^ this.uri.hashCode()) * 1000003) ^ this.pushOnlyConversationId.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.priority;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushPayload{conversationId=");
        sb.append(this.conversationId);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(", authorName=");
        sb.append(this.authorName);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", appName=");
        sb.append(this.appName);
        sb.append(", receiver=");
        sb.append(this.receiver);
        sb.append(", conversationPartType=");
        sb.append(this.conversationPartType);
        sb.append(", intercomPushType=");
        sb.append(this.intercomPushType);
        sb.append(", uri=");
        sb.append(this.uri);
        sb.append(", pushOnlyConversationId=");
        sb.append(this.pushOnlyConversationId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append("}");
        return sb.toString();
    }
}
