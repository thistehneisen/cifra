package io.intercom.android.sdk.models;

final class AutoValue_SocialAccount extends SocialAccount {
    private final String profileUrl;
    private final String provider;

    AutoValue_SocialAccount(String str, String str2) {
        if (str != null) {
            this.provider = str;
            if (str2 != null) {
                this.profileUrl = str2;
                return;
            }
            throw new NullPointerException("Null profileUrl");
        }
        throw new NullPointerException("Null provider");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SocialAccount)) {
            return false;
        }
        SocialAccount socialAccount = (SocialAccount) obj;
        if (!this.provider.equals(socialAccount.getProvider()) || !this.profileUrl.equals(socialAccount.getProfileUrl())) {
            z = false;
        }
        return z;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        return ((this.provider.hashCode() ^ 1000003) * 1000003) ^ this.profileUrl.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialAccount{provider=");
        sb.append(this.provider);
        sb.append(", profileUrl=");
        sb.append(this.profileUrl);
        sb.append("}");
        return sb.toString();
    }
}
