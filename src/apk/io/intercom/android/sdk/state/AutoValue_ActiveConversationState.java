package io.intercom.android.sdk.state;

final class AutoValue_ActiveConversationState extends ActiveConversationState {
    private final String getConversationId;
    private final boolean hasSwitchedInputType;
    private final boolean hasTextInComposer;

    AutoValue_ActiveConversationState(String str, boolean z, boolean z2) {
        if (str != null) {
            this.getConversationId = str;
            this.hasSwitchedInputType = z;
            this.hasTextInComposer = z2;
            return;
        }
        throw new NullPointerException("Null getConversationId");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActiveConversationState)) {
            return false;
        }
        ActiveConversationState activeConversationState = (ActiveConversationState) obj;
        if (!(this.getConversationId.equals(activeConversationState.getConversationId()) && this.hasSwitchedInputType == activeConversationState.hasSwitchedInputType() && this.hasTextInComposer == activeConversationState.hasTextInComposer())) {
            z = false;
        }
        return z;
    }

    public String getConversationId() {
        return this.getConversationId;
    }

    public boolean hasSwitchedInputType() {
        return this.hasSwitchedInputType;
    }

    public boolean hasTextInComposer() {
        return this.hasTextInComposer;
    }

    public int hashCode() {
        int i2 = 1231;
        int hashCode = (((this.getConversationId.hashCode() ^ 1000003) * 1000003) ^ (this.hasSwitchedInputType ? 1231 : 1237)) * 1000003;
        if (!this.hasTextInComposer) {
            i2 = 1237;
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActiveConversationState{getConversationId=");
        sb.append(this.getConversationId);
        sb.append(", hasSwitchedInputType=");
        sb.append(this.hasSwitchedInputType);
        sb.append(", hasTextInComposer=");
        sb.append(this.hasTextInComposer);
        sb.append("}");
        return sb.toString();
    }
}
