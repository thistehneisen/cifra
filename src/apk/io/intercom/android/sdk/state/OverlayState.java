package io.intercom.android.sdk.state;

import android.app.Activity;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import java.util.Set;

public abstract class OverlayState {

    public static abstract class Builder {
        public abstract Builder bottomPadding(int i2);

        public abstract OverlayState build();

        public abstract Builder conversations(List<Conversation> list);

        public abstract Builder dismissedPartIds(Set<String> set);

        public abstract Builder launcherVisibility(Visibility visibility);

        public abstract Builder notificationVisibility(Visibility visibility);

        public abstract Builder pausedHostActivity(Activity activity);

        public abstract Builder resumedHostActivity(Activity activity);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static OverlayState create(List<Conversation> list, Set<String> set, Visibility visibility, Visibility visibility2, Activity activity, Activity activity2, int i2) {
        return builder().conversations(list).dismissedPartIds(set).notificationVisibility(visibility).launcherVisibility(visibility2).bottomPadding(i2).resumedHostActivity(activity).pausedHostActivity(activity2).build();
    }

    public abstract int bottomPadding();

    public abstract List<Conversation> conversations();

    public abstract Set<String> dismissedPartIds();

    public abstract Visibility launcherVisibility();

    public abstract Visibility notificationVisibility();

    public abstract Activity pausedHostActivity();

    public abstract Activity resumedHostActivity();

    public abstract Builder toBuilder();
}
