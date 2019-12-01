package io.intercom.android.sdk.models;

final class AutoValue_Reaction extends Reaction {
    private final String imageUrl;
    private final int index;

    AutoValue_Reaction(int i2, String str) {
        this.index = i2;
        if (str != null) {
            this.imageUrl = str;
            return;
        }
        throw new NullPointerException("Null imageUrl");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Reaction)) {
            return false;
        }
        Reaction reaction = (Reaction) obj;
        if (this.index != reaction.getIndex() || !this.imageUrl.equals(reaction.getImageUrl())) {
            z = false;
        }
        return z;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return ((this.index ^ 1000003) * 1000003) ^ this.imageUrl.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reaction{index=");
        sb.append(this.index);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append("}");
        return sb.toString();
    }
}
