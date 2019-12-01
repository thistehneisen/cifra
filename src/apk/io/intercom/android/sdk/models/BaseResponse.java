package io.intercom.android.sdk.models;

public abstract class BaseResponse {
    private final Config config;
    private final boolean hasConversations;
    private final User user;

    static abstract class Builder {
        io.intercom.android.sdk.models.Config.Builder config;
        boolean has_conversations;
        io.intercom.android.sdk.models.User.Builder user;

        Builder() {
        }

        public abstract BaseResponse build();
    }

    protected BaseResponse(Builder builder) {
        io.intercom.android.sdk.models.Config.Builder builder2 = builder.config;
        this.config = builder2 == null ? Config.NULL : builder2.build();
        this.hasConversations = builder.has_conversations;
        io.intercom.android.sdk.models.User.Builder builder3 = builder.user;
        this.user = builder3 == null ? User.NULL : builder3.build();
    }

    public Config getConfig() {
        return this.config;
    }

    public User getUser() {
        return this.user;
    }

    public boolean hasConversations() {
        return this.hasConversations;
    }
}
