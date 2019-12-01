package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.ActiveConversationState;
import io.intercom.android.sdk.store.Store.Reducer;

public class ActiveConversationStateReducer implements Reducer<ActiveConversationState> {
    public static final ActiveConversationState INITIAL_STATE = ActiveConversationState.create("", false, false);

    /* renamed from: io.intercom.android.sdk.store.ActiveConversationStateReducer$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_TYPED_IN.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_CLEARED.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_INPUT_CHANGED.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_SEND_BUTTON_PRESSED.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_CONVERSATION_SUCCESS.ordinal()] = 5;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.NEW_CONVERSATION_SUCCESS.ordinal()] = 6;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_OPENED.ordinal()] = 7;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ActiveConversationState reduce(Action<?> action, ActiveConversationState activeConversationState) {
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
                return ActiveConversationState.create(activeConversationState.getConversationId(), activeConversationState.hasSwitchedInputType(), true);
            case 2:
                return ActiveConversationState.create(activeConversationState.getConversationId(), activeConversationState.hasSwitchedInputType(), false);
            case 3:
                return ActiveConversationState.create(activeConversationState.getConversationId(), true, activeConversationState.hasTextInComposer());
            case 4:
                return ActiveConversationState.create(activeConversationState.getConversationId(), INITIAL_STATE.hasSwitchedInputType(), INITIAL_STATE.hasTextInComposer());
            case 5:
            case 6:
                return ActiveConversationState.create(((Conversation) action.value()).getId(), activeConversationState.hasSwitchedInputType(), activeConversationState.hasTextInComposer());
            case 7:
                return ActiveConversationState.create((String) action.value(), activeConversationState.hasSwitchedInputType(), activeConversationState.hasTextInComposer());
            case 8:
                return INITIAL_STATE;
            default:
                return activeConversationState;
        }
    }
}
