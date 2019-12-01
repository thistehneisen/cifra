package io.intercom.android.sdk.identity;

final class AutoValue_AppIdentity extends AppIdentity {
    private final String apiKey;
    private final String appId;

    AutoValue_AppIdentity(String str, String str2) {
        if (str != null) {
            this.apiKey = str;
            if (str2 != null) {
                this.appId = str2;
                return;
            }
            throw new NullPointerException("Null appId");
        }
        throw new NullPointerException("Null apiKey");
    }

    public String apiKey() {
        return this.apiKey;
    }

    public String appId() {
        return this.appId;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppIdentity)) {
            return false;
        }
        AppIdentity appIdentity = (AppIdentity) obj;
        if (!this.apiKey.equals(appIdentity.apiKey()) || !this.appId.equals(appIdentity.appId())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.apiKey.hashCode() ^ 1000003) * 1000003) ^ this.appId.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppIdentity{apiKey=");
        sb.append(this.apiKey);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append("}");
        return sb.toString();
    }
}
