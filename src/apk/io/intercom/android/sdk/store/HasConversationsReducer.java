package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.store.Store.Reducer;

class HasConversationsReducer implements Reducer<Boolean> {
    static final boolean INITIAL_STATE = false;

    /* renamed from: io.intercom.android.sdk.store.HasConversationsReducer$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.BASE_RESPONSE_RECEIVED.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 2;
        }
    }

    HasConversationsReducer() {
    }

    public Boolean reduce(Action<?> action, Boolean bool) {
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            return Boolean.valueOf(((BaseResponse) action.value()).hasConversations());
        }
        if (i2 != 2) {
            return bool;
        }
        return Boolean.valueOf(false);
    }
}
