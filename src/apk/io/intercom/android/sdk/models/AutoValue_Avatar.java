package io.intercom.android.sdk.models;

final class AutoValue_Avatar extends Avatar {
    private final String imageUrl;
    private final String initials;

    AutoValue_Avatar(String str, String str2) {
        if (str != null) {
            this.imageUrl = str;
            if (str2 != null) {
                this.initials = str2;
                return;
            }
            throw new NullPointerException("Null initials");
        }
        throw new NullPointerException("Null imageUrl");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Avatar)) {
            return false;
        }
        Avatar avatar = (Avatar) obj;
        if (!this.imageUrl.equals(avatar.getImageUrl()) || !this.initials.equals(avatar.getInitials())) {
            z = false;
        }
        return z;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getInitials() {
        return this.initials;
    }

    public int hashCode() {
        return ((this.imageUrl.hashCode() ^ 1000003) * 1000003) ^ this.initials.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Avatar{imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", initials=");
        sb.append(this.initials);
        sb.append("}");
        return sb.toString();
    }
}
