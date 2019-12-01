package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.store.Store.Reducer;
import java.util.Collections;

class TeamPresenceReducer implements Reducer<TeamPresence> {
    static final TeamPresence INITIAL_STATE;

    /* renamed from: io.intercom.android.sdk.store.TeamPresenceReducer$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.TEAM_PRESENCE_UPDATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static {
        String str = "";
        INITIAL_STATE = TeamPresence.create(Collections.emptyList(), str, str);
    }

    TeamPresenceReducer() {
    }

    public TeamPresence reduce(Action<?> action, TeamPresence teamPresence) {
        if (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()] != 1) {
            return teamPresence;
        }
        return (TeamPresence) action.value();
    }
}
