package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.TeamPresence;
import java.util.Set;

public abstract class State {
    public static State create(boolean z, UiState uiState, TeamPresence teamPresence, Set<String> set, InboxState inboxState, HostAppState hostAppState, OverlayState overlayState, ActiveConversationState activeConversationState) {
        AutoValue_State autoValue_State = new AutoValue_State(z, uiState, teamPresence, set, inboxState, hostAppState, overlayState, activeConversationState);
        return autoValue_State;
    }

    public abstract ActiveConversationState activeConversationState();

    public abstract boolean hasConversations();

    public abstract HostAppState hostAppState();

    public abstract InboxState inboxState();

    public abstract OverlayState overlayState();

    public abstract TeamPresence teamPresence();

    public abstract UiState uiState();

    public abstract Set<String> unreadConversationIds();
}
