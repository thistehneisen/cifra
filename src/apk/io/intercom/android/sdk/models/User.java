package io.intercom.android.sdk.models;

import io.intercom.android.sdk.utilities.NullSafety;
import io.intercom.com.google.gson.a.c;

public class User {
    public static final User NULL = new User();
    @c("anonymous_id")
    private final String anonymousId;
    private final String email;
    @c("encrypted_user_id")
    private final String encryptedUserId;
    @c("intercom_id")
    private final String intercomId;
    @c("user_id")
    private final String userId;

    public static final class Builder {
        String anonymous_id;
        private io.intercom.android.sdk.models.Avatar.Builder avatar;
        String email;
        String encrypted_user_id;
        String intercom_id;
        String user_id;

        public User build() {
            return new User(this);
        }

        public Builder withAnonymousId(String str) {
            this.anonymous_id = str;
            return this;
        }

        public Builder withAvatar(io.intercom.android.sdk.models.Avatar.Builder builder) {
            this.avatar = builder;
            return this;
        }

        public Builder withEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder withEncryptedUserId(String str) {
            this.encrypted_user_id = str;
            return this;
        }

        public Builder withIntercomId(String str) {
            this.intercom_id = str;
            return this;
        }

        public Builder withUserId(String str) {
            this.user_id = str;
            return this;
        }
    }

    public User() {
        String str = "";
        this.intercomId = str;
        this.encryptedUserId = str;
        this.anonymousId = str;
        this.userId = str;
        this.email = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.intercomId.equals(user.intercomId) && this.encryptedUserId.equals(user.encryptedUserId) && this.anonymousId.equals(user.anonymousId) && this.userId.equals(user.userId)) {
            return this.email.equals(user.email);
        }
        return false;
    }

    public String getAnonymousId() {
        return this.anonymousId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public String getIntercomId() {
        return this.intercomId;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((this.intercomId.hashCode() * 31) + this.encryptedUserId.hashCode()) * 31) + this.anonymousId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.email.hashCode();
    }

    User(Builder builder) {
        this.intercomId = NullSafety.valueOrEmpty(builder.intercom_id);
        this.encryptedUserId = NullSafety.valueOrEmpty(builder.encrypted_user_id);
        this.anonymousId = NullSafety.valueOrEmpty(builder.anonymous_id);
        this.userId = NullSafety.valueOrEmpty(builder.user_id);
        this.email = NullSafety.valueOrEmpty(builder.email);
    }
}
