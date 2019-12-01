package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.state.HostAppState;
import io.intercom.android.sdk.store.Store.Reducer;

class HostAppStateReducer implements Reducer<HostAppState> {
    static final HostAppState INITIAL_STATE = HostAppState.create(true, false, 0);

    /* renamed from: io.intercom.android.sdk.store.HostAppStateReducer$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.APP_ENTERED_FOREGROUND.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.APP_ENTERED_BACKGROUND.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SESSION_STARTED.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    HostAppStateReducer() {
    }

    public HostAppState reduce(Action<?> action, HostAppState hostAppState) {
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            return HostAppState.create(false, false, hostAppState.backgroundedTimestamp());
        }
        if (i2 == 2) {
            return HostAppState.create(true, hostAppState.sessionStartedSinceLastBackgrounded(), ((Long) action.value()).longValue());
        }
        if (i2 == 3) {
            return HostAppState.create(hostAppState.isBackgrounded(), true, hostAppState.backgroundedTimestamp());
        }
        if (i2 != 4) {
            return hostAppState;
        }
        return HostAppState.create(hostAppState.isBackgrounded(), false, hostAppState.backgroundedTimestamp());
    }
}
