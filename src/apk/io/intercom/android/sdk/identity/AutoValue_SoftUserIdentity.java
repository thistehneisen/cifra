package io.intercom.android.sdk.identity;

final class AutoValue_SoftUserIdentity extends SoftUserIdentity {
    private final String anonymousId;
    private final String data;
    private final String email;
    private final String encryptedUserId;
    private final String fingerprint;
    private final String hmac;
    private final String intercomId;
    private final String userId;

    AutoValue_SoftUserIdentity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (str != null) {
            this.anonymousId = str;
            if (str2 != null) {
                this.data = str2;
                if (str3 != null) {
                    this.email = str3;
                    if (str4 != null) {
                        this.fingerprint = str4;
                        if (str5 != null) {
                            this.hmac = str5;
                            if (str6 != null) {
                                this.intercomId = str6;
                                if (str7 != null) {
                                    this.userId = str7;
                                    if (str8 != null) {
                                        this.encryptedUserId = str8;
                                        return;
                                    }
                                    throw new NullPointerException("Null encryptedUserId");
                                }
                                throw new NullPointerException("Null userId");
                            }
                            throw new NullPointerException("Null intercomId");
                        }
                        throw new NullPointerException("Null hmac");
                    }
                    throw new NullPointerException("Null fingerprint");
                }
                throw new NullPointerException("Null email");
            }
            throw new NullPointerException("Null data");
        }
        throw new NullPointerException("Null anonymousId");
    }

    /* access modifiers changed from: 0000 */
    public String anonymousId() {
        return this.anonymousId;
    }

    /* access modifiers changed from: 0000 */
    public String data() {
        return this.data;
    }

    /* access modifiers changed from: 0000 */
    public String email() {
        return this.email;
    }

    /* access modifiers changed from: 0000 */
    public String encryptedUserId() {
        return this.encryptedUserId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SoftUserIdentity)) {
            return false;
        }
        SoftUserIdentity softUserIdentity = (SoftUserIdentity) obj;
        if (!this.anonymousId.equals(softUserIdentity.anonymousId()) || !this.data.equals(softUserIdentity.data()) || !this.email.equals(softUserIdentity.email()) || !this.fingerprint.equals(softUserIdentity.fingerprint()) || !this.hmac.equals(softUserIdentity.hmac()) || !this.intercomId.equals(softUserIdentity.intercomId()) || !this.userId.equals(softUserIdentity.userId()) || !this.encryptedUserId.equals(softUserIdentity.encryptedUserId())) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public String fingerprint() {
        return this.fingerprint;
    }

    public int hashCode() {
        return ((((((((((((((this.anonymousId.hashCode() ^ 1000003) * 1000003) ^ this.data.hashCode()) * 1000003) ^ this.email.hashCode()) * 1000003) ^ this.fingerprint.hashCode()) * 1000003) ^ this.hmac.hashCode()) * 1000003) ^ this.intercomId.hashCode()) * 1000003) ^ this.userId.hashCode()) * 1000003) ^ this.encryptedUserId.hashCode();
    }

    /* access modifiers changed from: 0000 */
    public String hmac() {
        return this.hmac;
    }

    /* access modifiers changed from: 0000 */
    public String intercomId() {
        return this.intercomId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SoftUserIdentity{anonymousId=");
        sb.append(this.anonymousId);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", fingerprint=");
        sb.append(this.fingerprint);
        sb.append(", hmac=");
        sb.append(this.hmac);
        sb.append(", intercomId=");
        sb.append(this.intercomId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", encryptedUserId=");
        sb.append(this.encryptedUserId);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public String userId() {
        return this.userId;
    }
}
