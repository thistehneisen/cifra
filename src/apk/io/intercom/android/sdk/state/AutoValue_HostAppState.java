package io.intercom.android.sdk.state;

final class AutoValue_HostAppState extends HostAppState {
    private final long backgroundedTimestamp;
    private final boolean isBackgrounded;
    private final boolean sessionStartedSinceLastBackgrounded;

    AutoValue_HostAppState(boolean z, boolean z2, long j2) {
        this.isBackgrounded = z;
        this.sessionStartedSinceLastBackgrounded = z2;
        this.backgroundedTimestamp = j2;
    }

    public long backgroundedTimestamp() {
        return this.backgroundedTimestamp;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HostAppState)) {
            return false;
        }
        HostAppState hostAppState = (HostAppState) obj;
        if (!(this.isBackgrounded == hostAppState.isBackgrounded() && this.sessionStartedSinceLastBackgrounded == hostAppState.sessionStartedSinceLastBackgrounded() && this.backgroundedTimestamp == hostAppState.backgroundedTimestamp())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i2 = 1231;
        int i3 = ((this.isBackgrounded ? 1231 : 1237) ^ 1000003) * 1000003;
        if (!this.sessionStartedSinceLastBackgrounded) {
            i2 = 1237;
        }
        int i4 = (i3 ^ i2) * 1000003;
        long j2 = this.backgroundedTimestamp;
        return i4 ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isBackgrounded() {
        return this.isBackgrounded;
    }

    public boolean sessionStartedSinceLastBackgrounded() {
        return this.sessionStartedSinceLastBackgrounded;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HostAppState{isBackgrounded=");
        sb.append(this.isBackgrounded);
        sb.append(", sessionStartedSinceLastBackgrounded=");
        sb.append(this.sessionStartedSinceLastBackgrounded);
        sb.append(", backgroundedTimestamp=");
        sb.append(this.backgroundedTimestamp);
        sb.append("}");
        return sb.toString();
    }
}
