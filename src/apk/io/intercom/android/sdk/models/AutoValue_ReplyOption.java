package io.intercom.android.sdk.models;

final class AutoValue_ReplyOption extends ReplyOption {
    private final String text;
    private final String uuid;

    AutoValue_ReplyOption(String str, String str2) {
        if (str != null) {
            this.text = str;
            if (str2 != null) {
                this.uuid = str2;
                return;
            }
            throw new NullPointerException("Null uuid");
        }
        throw new NullPointerException("Null text");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReplyOption)) {
            return false;
        }
        ReplyOption replyOption = (ReplyOption) obj;
        if (!this.text.equals(replyOption.text()) || !this.uuid.equals(replyOption.uuid())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.text.hashCode() ^ 1000003) * 1000003) ^ this.uuid.hashCode();
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReplyOption{text=");
        sb.append(this.text);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append("}");
        return sb.toString();
    }

    public String uuid() {
        return this.uuid;
    }
}
