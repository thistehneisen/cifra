package io.intercom.android.sdk.identity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.intercom.android.sdk.models.User;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserIdentity {
    public static final String ANONYMOUS_ID = "anonymous_id";
    public static final String EMAIL = "email";
    public static final String INTERCOM_ID = "intercom_id";
    private static final String KEY_ANONYMOUS_ID = "INTERCOM_SDK_ANONYMOUS_ID";
    private static final String KEY_EMAIL_ID = "INTERCOM_SDK_EMAIL_ID";
    private static final String KEY_INTERCOM_ID = "INTERCOM_SDK_INTERCOM_ID";
    private static final String KEY_PREFIX = "intercomsdk-session-";
    private static final String KEY_SECURE_DATA = "SecureMode_Data";
    private static final String KEY_SECURE_HMAC = "SecureMode_HMAC";
    private static final String KEY_USER_ID = "INTERCOM_SDK_USER_ID";
    private static final String TYPE = "type";
    private static final String USER = "user";
    private static final String USER_ID = "user_id";
    private String anonymousId;
    private String data;
    private String email;
    private String encryptedUserId;
    private String fingerprint;
    private String hmac;
    private String intercomId;
    private final SharedPreferences prefs;
    private SoftUserIdentity softUserIdentity = SoftUserIdentity.NONE;
    private String userId;

    public UserIdentity(Context context) {
        String str = "";
        this.fingerprint = str;
        this.prefs = context.getSharedPreferences(PreferenceKeys.INTERCOM_USER_PREFS, 0);
        this.anonymousId = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID", str);
        this.intercomId = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", str);
        this.userId = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_USER_ID", str);
        this.email = this.prefs.getString("intercomsdk-session-INTERCOM_SDK_EMAIL_ID", str);
        this.data = this.prefs.getString("intercomsdk-session-SecureMode_Data", str);
        this.hmac = this.prefs.getString("intercomsdk-session-SecureMode_HMAC", str);
        this.encryptedUserId = str;
        if (identityExists()) {
            this.fingerprint = generateFingerprint();
        }
    }

    private String generateFingerprint() {
        return UUID.randomUUID().toString();
    }

    public boolean canRegisterIdentifiedUser(Registration registration) {
        return registration.isValidRegistration() && !isIdentified();
    }

    public boolean canRegisterUnidentifiedUser() {
        return !identityExists();
    }

    public String getAnonymousId() {
        return this.anonymousId;
    }

    public String getData() {
        return this.data;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getHmac() {
        return this.hmac;
    }

    public String getIntercomId() {
        return this.intercomId;
    }

    public String getSoftUserIdentityHmac() {
        return this.softUserIdentity.hmac();
    }

    public String getUserId() {
        return this.userId;
    }

    public void hardReset() {
        this.softUserIdentity = SoftUserIdentity.NONE;
    }

    public boolean hasIntercomId() {
        return !getIntercomId().isEmpty();
    }

    public boolean identityExists() {
        return !this.email.isEmpty() || !this.userId.isEmpty() || !this.intercomId.isEmpty() || !this.anonymousId.isEmpty();
    }

    public boolean isIdentified() {
        return identityExists() && !isUnidentified();
    }

    public boolean isSameUser(Registration registration) {
        if (isUnidentified()) {
            return false;
        }
        return this.softUserIdentity.isSameUser(registration);
    }

    public boolean isSoftReset() {
        return this.softUserIdentity.isPresent();
    }

    public boolean isUnidentified() {
        return !this.anonymousId.isEmpty() && this.email.isEmpty() && this.userId.isEmpty();
    }

    public void registerIdentifiedUser(Registration registration) {
        this.intercomId = "";
        Editor putString = this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", this.intercomId);
        if (!registration.getUserId().isEmpty()) {
            this.userId = registration.getUserId();
            putString.putString("intercomsdk-session-INTERCOM_SDK_USER_ID", this.userId);
        }
        if (!registration.getEmail().isEmpty()) {
            this.email = registration.getEmail();
            putString.putString("intercomsdk-session-INTERCOM_SDK_EMAIL_ID", this.email);
        }
        putString.apply();
        if (this.fingerprint.isEmpty()) {
            this.fingerprint = generateFingerprint();
        }
    }

    public void registerUnidentifiedUser() {
        this.anonymousId = UUID.randomUUID().toString();
        this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID", this.anonymousId).apply();
        if (this.fingerprint.isEmpty()) {
            this.fingerprint = generateFingerprint();
        }
    }

    public boolean registrationHasAttributes(Registration registration) {
        return (registration == null || registration.getAttributes() == null || registration.getAttributes().isEmpty()) ? false : true;
    }

    public void setSecureMode(String str, String str2) {
        this.data = str2;
        this.hmac = str;
        this.prefs.edit().putString("intercomsdk-session-SecureMode_Data", str2).putString("intercomsdk-session-SecureMode_HMAC", str).apply();
    }

    public void setUserHash(String str) {
        this.hmac = str;
        this.data = "";
        this.prefs.edit().putString("intercomsdk-session-SecureMode_HMAC", str).remove("intercomsdk-session-SecureMode_Data").apply();
    }

    public void softReset() {
        if (!isSoftReset()) {
            this.softUserIdentity = SoftUserIdentity.create(this.anonymousId, this.data, this.email, this.fingerprint, this.hmac, this.intercomId, this.userId, this.encryptedUserId);
            this.prefs.edit().clear().apply();
            String str = "";
            this.anonymousId = str;
            this.intercomId = str;
            this.encryptedUserId = str;
            this.userId = str;
            this.email = str;
            this.data = str;
            this.hmac = str;
            this.fingerprint = str;
        }
    }

    public void softRestart() {
        this.userId = this.softUserIdentity.userId();
        this.email = this.softUserIdentity.email();
        this.anonymousId = this.softUserIdentity.anonymousId();
        this.intercomId = this.softUserIdentity.intercomId();
        this.encryptedUserId = this.softUserIdentity.encryptedUserId();
        this.data = this.softUserIdentity.data();
        this.hmac = this.softUserIdentity.hmac();
        this.fingerprint = this.softUserIdentity.fingerprint();
        String str = "intercomsdk-session-INTERCOM_SDK_EMAIL_ID";
        String str2 = "intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID";
        String str3 = "intercomsdk-session-INTERCOM_SDK_INTERCOM_ID";
        this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_USER_ID", this.userId).putString(str, this.email).putString(str2, this.anonymousId).putString(str3, this.intercomId).apply();
        this.softUserIdentity = SoftUserIdentity.NONE;
    }

    public boolean softUserIdentityHmacDiffers(String str) {
        return this.softUserIdentity.isPresent() && !getSoftUserIdentityHmac().equals(str);
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        if (!this.anonymousId.isEmpty()) {
            hashMap.put(ANONYMOUS_ID, this.anonymousId);
        } else if (!this.intercomId.isEmpty()) {
            hashMap.put(INTERCOM_ID, this.intercomId);
        }
        if (!this.userId.isEmpty()) {
            hashMap.put(USER_ID, this.userId);
        }
        if (!this.email.isEmpty()) {
            hashMap.put("email", this.email);
        }
        hashMap.put(TYPE, USER);
        return hashMap;
    }

    public void update(User user) {
        if (user != User.NULL) {
            this.userId = user.getUserId();
            this.email = user.getEmail();
            this.anonymousId = user.getAnonymousId();
            this.encryptedUserId = user.getEncryptedUserId();
            String str = "intercomsdk-session-INTERCOM_SDK_EMAIL_ID";
            String str2 = "intercomsdk-session-INTERCOM_SDK_ANONYMOUS_ID";
            Editor putString = this.prefs.edit().putString("intercomsdk-session-INTERCOM_SDK_USER_ID", this.userId).putString(str, this.email).putString(str2, this.anonymousId);
            if (!user.getIntercomId().isEmpty()) {
                this.intercomId = user.getIntercomId();
                putString.putString("intercomsdk-session-INTERCOM_SDK_INTERCOM_ID", this.intercomId);
            }
            putString.apply();
        }
    }
}
