package io.intercom.android.sdk.state;

import android.app.Activity;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import java.util.Set;

final class AutoValue_OverlayState extends OverlayState {
    private final int bottomPadding;
    private final List<Conversation> conversations;
    private final Set<String> dismissedPartIds;
    private final Visibility launcherVisibility;
    private final Visibility notificationVisibility;
    private final Activity pausedHostActivity;
    private final Activity resumedHostActivity;

    static final class Builder extends io.intercom.android.sdk.state.OverlayState.Builder {
        private Integer bottomPadding;
        private List<Conversation> conversations;
        private Set<String> dismissedPartIds;
        private Visibility launcherVisibility;
        private Visibility notificationVisibility;
        private Activity pausedHostActivity;
        private Activity resumedHostActivity;

        public io.intercom.android.sdk.state.OverlayState.Builder bottomPadding(int i2) {
            this.bottomPadding = Integer.valueOf(i2);
            return this;
        }

        public OverlayState build() {
            String str = "";
            if (this.conversations == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" conversations");
                str = sb.toString();
            }
            if (this.dismissedPartIds == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" dismissedPartIds");
                str = sb2.toString();
            }
            if (this.notificationVisibility == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" notificationVisibility");
                str = sb3.toString();
            }
            if (this.launcherVisibility == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(" launcherVisibility");
                str = sb4.toString();
            }
            if (this.bottomPadding == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" bottomPadding");
                str = sb5.toString();
            }
            if (str.isEmpty()) {
                AutoValue_OverlayState autoValue_OverlayState = new AutoValue_OverlayState(this.conversations, this.dismissedPartIds, this.notificationVisibility, this.launcherVisibility, this.bottomPadding.intValue(), this.resumedHostActivity, this.pausedHostActivity);
                return autoValue_OverlayState;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Missing required properties:");
            sb6.append(str);
            throw new IllegalStateException(sb6.toString());
        }

        public io.intercom.android.sdk.state.OverlayState.Builder conversations(List<Conversation> list) {
            if (list != null) {
                this.conversations = list;
                return this;
            }
            throw new NullPointerException("Null conversations");
        }

        public io.intercom.android.sdk.state.OverlayState.Builder dismissedPartIds(Set<String> set) {
            if (set != null) {
                this.dismissedPartIds = set;
                return this;
            }
            throw new NullPointerException("Null dismissedPartIds");
        }

        public io.intercom.android.sdk.state.OverlayState.Builder launcherVisibility(Visibility visibility) {
            if (visibility != null) {
                this.launcherVisibility = visibility;
                return this;
            }
            throw new NullPointerException("Null launcherVisibility");
        }

        public io.intercom.android.sdk.state.OverlayState.Builder notificationVisibility(Visibility visibility) {
            if (visibility != null) {
                this.notificationVisibility = visibility;
                return this;
            }
            throw new NullPointerException("Null notificationVisibility");
        }

        public io.intercom.android.sdk.state.OverlayState.Builder pausedHostActivity(Activity activity) {
            this.pausedHostActivity = activity;
            return this;
        }

        public io.intercom.android.sdk.state.OverlayState.Builder resumedHostActivity(Activity activity) {
            this.resumedHostActivity = activity;
            return this;
        }

        Builder() {
        }

        private Builder(OverlayState overlayState) {
            this.conversations = overlayState.conversations();
            this.dismissedPartIds = overlayState.dismissedPartIds();
            this.notificationVisibility = overlayState.notificationVisibility();
            this.launcherVisibility = overlayState.launcherVisibility();
            this.bottomPadding = Integer.valueOf(overlayState.bottomPadding());
            this.resumedHostActivity = overlayState.resumedHostActivity();
            this.pausedHostActivity = overlayState.pausedHostActivity();
        }
    }

    public int bottomPadding() {
        return this.bottomPadding;
    }

    public List<Conversation> conversations() {
        return this.conversations;
    }

    public Set<String> dismissedPartIds() {
        return this.dismissedPartIds;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OverlayState)) {
            return false;
        }
        OverlayState overlayState = (OverlayState) obj;
        if (this.conversations.equals(overlayState.conversations()) && this.dismissedPartIds.equals(overlayState.dismissedPartIds()) && this.notificationVisibility.equals(overlayState.notificationVisibility()) && this.launcherVisibility.equals(overlayState.launcherVisibility()) && this.bottomPadding == overlayState.bottomPadding()) {
            Activity activity = this.resumedHostActivity;
            if (activity != null ? activity.equals(overlayState.resumedHostActivity()) : overlayState.resumedHostActivity() == null) {
                Activity activity2 = this.pausedHostActivity;
                if (activity2 != null) {
                }
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int hashCode = (((((((((this.conversations.hashCode() ^ 1000003) * 1000003) ^ this.dismissedPartIds.hashCode()) * 1000003) ^ this.notificationVisibility.hashCode()) * 1000003) ^ this.launcherVisibility.hashCode()) * 1000003) ^ this.bottomPadding) * 1000003;
        Activity activity = this.resumedHostActivity;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (activity == null ? 0 : activity.hashCode())) * 1000003;
        Activity activity2 = this.pausedHostActivity;
        if (activity2 != null) {
            i2 = activity2.hashCode();
        }
        return hashCode2 ^ i2;
    }

    public Visibility launcherVisibility() {
        return this.launcherVisibility;
    }

    public Visibility notificationVisibility() {
        return this.notificationVisibility;
    }

    public Activity pausedHostActivity() {
        return this.pausedHostActivity;
    }

    public Activity resumedHostActivity() {
        return this.resumedHostActivity;
    }

    public io.intercom.android.sdk.state.OverlayState.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OverlayState{conversations=");
        sb.append(this.conversations);
        sb.append(", dismissedPartIds=");
        sb.append(this.dismissedPartIds);
        sb.append(", notificationVisibility=");
        sb.append(this.notificationVisibility);
        sb.append(", launcherVisibility=");
        sb.append(this.launcherVisibility);
        sb.append(", bottomPadding=");
        sb.append(this.bottomPadding);
        sb.append(", resumedHostActivity=");
        sb.append(this.resumedHostActivity);
        sb.append(", pausedHostActivity=");
        sb.append(this.pausedHostActivity);
        sb.append("}");
        return sb.toString();
    }

    private AutoValue_OverlayState(List<Conversation> list, Set<String> set, Visibility visibility, Visibility visibility2, int i2, Activity activity, Activity activity2) {
        this.conversations = list;
        this.dismissedPartIds = set;
        this.notificationVisibility = visibility;
        this.launcherVisibility = visibility2;
        this.bottomPadding = i2;
        this.resumedHostActivity = activity;
        this.pausedHostActivity = activity2;
    }
}
