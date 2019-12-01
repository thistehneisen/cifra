package io.intercom.android.sdk.identity;

import android.text.TextUtils;

abstract class SoftUserIdentity {
    static final SoftUserIdentity NONE = create("", "", "", "", "", "", "", "");

    SoftUserIdentity() {
    }

    static SoftUserIdentity create(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AutoValue_SoftUserIdentity autoValue_SoftUserIdentity = new AutoValue_SoftUserIdentity(str, str2, str3, str4, str5, str6, str7, str8);
        return autoValue_SoftUserIdentity;
    }

    /* access modifiers changed from: 0000 */
    public abstract String anonymousId();

    /* access modifiers changed from: 0000 */
    public abstract String data();

    /* access modifiers changed from: 0000 */
    public abstract String email();

    /* access modifiers changed from: 0000 */
    public abstract String encryptedUserId();

    /* access modifiers changed from: 0000 */
    public abstract String fingerprint();

    /* access modifiers changed from: 0000 */
    public abstract String hmac();

    /* access modifiers changed from: 0000 */
    public abstract String intercomId();

    /* access modifiers changed from: 0000 */
    public boolean isPresent() {
        return !equals(NONE);
    }

    /* access modifiers changed from: 0000 */
    public boolean isSameUser(Registration registration) {
        String userId = registration.getUserId();
        String email = registration.getEmail();
        boolean z = !TextUtils.isEmpty(userId) || !TextUtils.isEmpty(email);
        if (!TextUtils.isEmpty(userId)) {
            z = z && userId.equals(userId());
        }
        if (!TextUtils.isEmpty(email)) {
            return z && email.equals(email());
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public abstract String userId();
}
