package io.intercom.android.sdk.middleware;

import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;

public class UserIdentityMiddleware implements Middleware<State> {
    private final Provider<UserIdentity> userIdentityProvider;

    /* renamed from: io.intercom.android.sdk.middleware.UserIdentityMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.BASE_RESPONSE_RECEIVED.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SOFT_RESET.ordinal()] = 2;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public UserIdentityMiddleware(Provider<UserIdentity> provider) {
        this.userIdentityProvider = provider;
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            ((UserIdentity) this.userIdentityProvider.get()).update(((BaseResponse) action.value()).getUser());
        } else if (i2 == 2) {
            ((UserIdentity) this.userIdentityProvider.get()).softReset();
        } else if (i2 == 3) {
            ((UserIdentity) this.userIdentityProvider.get()).hardReset();
        }
    }
}
