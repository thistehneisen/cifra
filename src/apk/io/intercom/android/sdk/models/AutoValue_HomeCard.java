package io.intercom.android.sdk.models;

final class AutoValue_HomeCard extends HomeCard {
    private final String fallbackUrl;

    AutoValue_HomeCard(String str) {
        if (str != null) {
            this.fallbackUrl = str;
            return;
        }
        throw new NullPointerException("Null fallbackUrl");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeCard)) {
            return false;
        }
        return this.fallbackUrl.equals(((HomeCard) obj).fallbackUrl());
    }

    public String fallbackUrl() {
        return this.fallbackUrl;
    }

    public int hashCode() {
        return this.fallbackUrl.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HomeCard{fallbackUrl=");
        sb.append(this.fallbackUrl);
        sb.append("}");
        return sb.toString();
    }
}
