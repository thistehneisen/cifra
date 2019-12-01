package io.intercom.android.sdk.conversation.attribute;

public abstract class AttributeMetadata {
    public static final AttributeMetadata SINGLE_ATTRIBUTE_METADATA = new Builder().withPosition(0).withTotalCount(1).build();

    public static final class Builder {
        private int position;
        private int totalCount;

        public AttributeMetadata build() {
            return new AutoValue_AttributeMetadata(this.position, this.totalCount);
        }

        public Builder withPosition(int i2) {
            this.position = i2;
            return this;
        }

        public Builder withTotalCount(int i2) {
            this.totalCount = i2;
            return this;
        }
    }

    public abstract int getPosition();

    public abstract int getTotalCount();
}
