package io.intercom.android.sdk.conversation.attribute;

final class AutoValue_AttributeMetadata extends AttributeMetadata {
    private final int position;
    private final int totalCount;

    AutoValue_AttributeMetadata(int i2, int i3) {
        this.position = i2;
        this.totalCount = i3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeMetadata)) {
            return false;
        }
        AttributeMetadata attributeMetadata = (AttributeMetadata) obj;
        if (!(this.position == attributeMetadata.getPosition() && this.totalCount == attributeMetadata.getTotalCount())) {
            z = false;
        }
        return z;
    }

    public int getPosition() {
        return this.position;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return ((this.position ^ 1000003) * 1000003) ^ this.totalCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeMetadata{position=");
        sb.append(this.position);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append("}");
        return sb.toString();
    }
}
