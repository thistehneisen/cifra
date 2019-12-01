package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.UiState;
import io.intercom.android.sdk.state.UiState.Screen;
import io.intercom.android.sdk.store.Store.Reducer;

class LastViewReducer implements Reducer<UiState> {
    static final UiState INITIAL_STATE = UiState.create(Screen.NONE, null);

    /* renamed from: io.intercom.android.sdk.store.LastViewReducer$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HOME_OPENED.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.INBOX_OPENED.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.NEW_CONVERSATION_SCREEN_OPENED.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_OPENED.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.NEW_CONVERSATION_SUCCESS.ordinal()] = 5;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SOFT_RESET.ordinal()] = 6;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    LastViewReducer() {
    }

    public UiState reduce(Action<?> action, UiState uiState) {
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
                return UiState.create(Screen.HOME, null);
            case 2:
                return UiState.create(Screen.INBOX, null);
            case 3:
                return UiState.create(Screen.COMPOSER, null);
            case 4:
                return UiState.create(Screen.CONVERSATION, (String) action.value());
            case 5:
                return UiState.create(Screen.CONVERSATION, ((Conversation) action.value()).getId());
            case 6:
            case 7:
                return UiState.create(Screen.NONE, null);
            default:
                return uiState;
        }
    }
}
