package io.intercom.android.sdk.state;

public abstract class HostAppState {
    public static HostAppState create(boolean z, boolean z2, long j2) {
        return new AutoValue_HostAppState(z, z2, j2);
    }

    public abstract long backgroundedTimestamp();

    public abstract boolean isBackgrounded();

    public abstract boolean sessionStartedSinceLastBackgrounded();
}
