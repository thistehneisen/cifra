package io.intercom.android.sdk.experimental;

import android.text.TextUtils;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;

public class IntercomSettings {
    private String apiKey;
    private String appId;
    private String email;
    private final Twig twig = LumberMill.getLogger();
    private String userHash;
    private String userId;

    public IntercomSettings() {
        String str = "";
        this.apiKey = str;
        this.appId = str;
        this.email = str;
        this.userId = str;
        this.userHash = str;
    }

    public static IntercomSettings create() {
        return new IntercomSettings();
    }

    public boolean canIdentifyUser() {
        return !TextUtils.isEmpty(this.userId) || !TextUtils.isEmpty(this.email);
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUserHash() {
        return this.userHash;
    }

    public String getUserId() {
        return this.userId;
    }

    public IntercomSettings withApiKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.apiKey = str;
        } else {
            this.twig.e("apiKey cannot be null or empty", new Object[0]);
        }
        return this;
    }

    public IntercomSettings withAppId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.appId = str;
        } else {
            this.twig.e("appId cannot be null or empty", new Object[0]);
        }
        return this;
    }

    public IntercomSettings withEmail(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.email = str;
        } else {
            this.twig.e("email cannot be null or empty", new Object[0]);
        }
        return this;
    }

    public IntercomSettings withUserHash(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.userHash = str;
        } else {
            this.twig.e("userHash cannot be null or empty", new Object[0]);
        }
        return this;
    }

    public IntercomSettings withUserId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.userId = str;
        } else {
            this.twig.e("userId cannot be null or empty", new Object[0]);
        }
        return this;
    }
}
