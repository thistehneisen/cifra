package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.ActiveConversationState;
import io.intercom.android.sdk.state.HostAppState;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.state.UiState;
import io.intercom.android.sdk.store.Store.Reducer;
import java.util.Set;

class StateReducer implements Reducer<State> {
    private final Reducer<ActiveConversationState> activeConversationStateReducer;
    private final Reducer<Boolean> hasConversationsReducer;
    private final Reducer<HostAppState> hostAppStateReducer;
    private final Reducer<InboxState> inboxStateReducer;
    private final Reducer<OverlayState> overlayStateReducer;
    private final Reducer<TeamPresence> teamPresenceReducer;
    private final Reducer<UiState> uiStateReducer;
    private final Reducer<Set<String>> unreadConversationIdsReducer;

    StateReducer(Reducer<Boolean> reducer, Reducer<UiState> reducer2, Reducer<TeamPresence> reducer3, Reducer<Set<String>> reducer4, Reducer<InboxState> reducer5, Reducer<HostAppState> reducer6, Reducer<OverlayState> reducer7, Reducer<ActiveConversationState> reducer8) {
        this.hasConversationsReducer = reducer;
        this.uiStateReducer = reducer2;
        this.teamPresenceReducer = reducer3;
        this.unreadConversationIdsReducer = reducer4;
        this.inboxStateReducer = reducer5;
        this.hostAppStateReducer = reducer6;
        this.overlayStateReducer = reducer7;
        this.activeConversationStateReducer = reducer8;
    }

    public State reduce(Action<?> action, State state) {
        return State.create(((Boolean) this.hasConversationsReducer.reduce(action, Boolean.valueOf(state.hasConversations()))).booleanValue(), (UiState) this.uiStateReducer.reduce(action, state.uiState()), (TeamPresence) this.teamPresenceReducer.reduce(action, state.teamPresence()), (Set) this.unreadConversationIdsReducer.reduce(action, state.unreadConversationIds()), (InboxState) this.inboxStateReducer.reduce(action, state.inboxState()), (HostAppState) this.hostAppStateReducer.reduce(action, state.hostAppState()), (OverlayState) this.overlayStateReducer.reduce(action, state.overlayState()), (ActiveConversationState) this.activeConversationStateReducer.reduce(action, state.activeConversationState()));
    }
}
