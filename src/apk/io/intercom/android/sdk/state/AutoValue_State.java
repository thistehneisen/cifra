package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.TeamPresence;
import java.util.Set;

final class AutoValue_State extends State {
    private final ActiveConversationState activeConversationState;
    private final boolean hasConversations;
    private final HostAppState hostAppState;
    private final InboxState inboxState;
    private final OverlayState overlayState;
    private final TeamPresence teamPresence;
    private final UiState uiState;
    private final Set<String> unreadConversationIds;

    AutoValue_State(boolean z, UiState uiState2, TeamPresence teamPresence2, Set<String> set, InboxState inboxState2, HostAppState hostAppState2, OverlayState overlayState2, ActiveConversationState activeConversationState2) {
        this.hasConversations = z;
        if (uiState2 != null) {
            this.uiState = uiState2;
            if (teamPresence2 != null) {
                this.teamPresence = teamPresence2;
                if (set != null) {
                    this.unreadConversationIds = set;
                    if (inboxState2 != null) {
                        this.inboxState = inboxState2;
                        if (hostAppState2 != null) {
                            this.hostAppState = hostAppState2;
                            if (overlayState2 != null) {
                                this.overlayState = overlayState2;
                                if (activeConversationState2 != null) {
                                    this.activeConversationState = activeConversationState2;
                                    return;
                                }
                                throw new NullPointerException("Null activeConversationState");
                            }
                            throw new NullPointerException("Null overlayState");
                        }
                        throw new NullPointerException("Null hostAppState");
                    }
                    throw new NullPointerException("Null inboxState");
                }
                throw new NullPointerException("Null unreadConversationIds");
            }
            throw new NullPointerException("Null teamPresence");
        }
        throw new NullPointerException("Null uiState");
    }

    public ActiveConversationState activeConversationState() {
        return this.activeConversationState;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof State)) {
            return false;
        }
        State state = (State) obj;
        if (this.hasConversations != state.hasConversations() || !this.uiState.equals(state.uiState()) || !this.teamPresence.equals(state.teamPresence()) || !this.unreadConversationIds.equals(state.unreadConversationIds()) || !this.inboxState.equals(state.inboxState()) || !this.hostAppState.equals(state.hostAppState()) || !this.overlayState.equals(state.overlayState()) || !this.activeConversationState.equals(state.activeConversationState())) {
            z = false;
        }
        return z;
    }

    public boolean hasConversations() {
        return this.hasConversations;
    }

    public int hashCode() {
        return (((((((((((((((this.hasConversations ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.uiState.hashCode()) * 1000003) ^ this.teamPresence.hashCode()) * 1000003) ^ this.unreadConversationIds.hashCode()) * 1000003) ^ this.inboxState.hashCode()) * 1000003) ^ this.hostAppState.hashCode()) * 1000003) ^ this.overlayState.hashCode()) * 1000003) ^ this.activeConversationState.hashCode();
    }

    public HostAppState hostAppState() {
        return this.hostAppState;
    }

    public InboxState inboxState() {
        return this.inboxState;
    }

    public OverlayState overlayState() {
        return this.overlayState;
    }

    public TeamPresence teamPresence() {
        return this.teamPresence;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("State{hasConversations=");
        sb.append(this.hasConversations);
        sb.append(", uiState=");
        sb.append(this.uiState);
        sb.append(", teamPresence=");
        sb.append(this.teamPresence);
        sb.append(", unreadConversationIds=");
        sb.append(this.unreadConversationIds);
        sb.append(", inboxState=");
        sb.append(this.inboxState);
        sb.append(", hostAppState=");
        sb.append(this.hostAppState);
        sb.append(", overlayState=");
        sb.append(this.overlayState);
        sb.append(", activeConversationState=");
        sb.append(this.activeConversationState);
        sb.append("}");
        return sb.toString();
    }

    public UiState uiState() {
        return this.uiState;
    }

    public Set<String> unreadConversationIds() {
        return this.unreadConversationIds;
    }
}
