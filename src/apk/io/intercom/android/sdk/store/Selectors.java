package io.intercom.android.sdk.store;

import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.ActiveConversationState;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store.Selector;

public class Selectors {
    public static final Selector<State, ActiveConversationState> ACTIVE_CONVERSATION = new Selector<State, ActiveConversationState>() {
        public ActiveConversationState transform(State state) {
            return state.activeConversationState();
        }
    };
    public static final Selector<State, Boolean> APP_IS_BACKGROUNDED = new Selector<State, Boolean>() {
        public Boolean transform(State state) {
            return Boolean.valueOf(state.hostAppState().isBackgrounded());
        }
    };
    public static final Selector<State, InboxState> INBOX = new Selector<State, InboxState>() {
        public InboxState transform(State state) {
            return state.inboxState();
        }
    };
    public static final Selector<State, OverlayState> OVERLAY = new Selector<State, OverlayState>() {
        public OverlayState transform(State state) {
            return state.overlayState();
        }
    };
    public static final Selector<State, Boolean> SESSION_STARTED_SINCE_LAST_BACKGROUNDED = new Selector<State, Boolean>() {
        public Boolean transform(State state) {
            return Boolean.valueOf(state.hostAppState().sessionStartedSinceLastBackgrounded());
        }
    };
    public static final Selector<State, TeamPresence> TEAM_PRESENCE = new Selector<State, TeamPresence>() {
        public TeamPresence transform(State state) {
            return state.teamPresence();
        }
    };
    public static final Selector<State, Integer> UNREAD_COUNT = new Selector<State, Integer>() {
        public Integer transform(State state) {
            return Integer.valueOf(state.unreadConversationIds().size());
        }
    };
}
