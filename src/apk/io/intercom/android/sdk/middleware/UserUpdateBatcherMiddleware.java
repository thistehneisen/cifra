package io.intercom.android.sdk.middleware;

import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.api.UserUpdateBatcher;
import io.intercom.android.sdk.api.UserUpdateRequest;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;

public class UserUpdateBatcherMiddleware implements Middleware<State> {
    private final Provider<AppConfig> appConfigProvider;
    private final Provider<UserIdentity> userIdentityProvider;
    private final Provider<UserUpdateBatcher> userUpdateBatcher;

    /* renamed from: io.intercom.android.sdk.middleware.UserUpdateBatcherMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.APP_ENTERED_FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public UserUpdateBatcherMiddleware(Provider<UserUpdateBatcher> provider, Provider<AppConfig> provider2, Provider<UserIdentity> provider3) {
        this.appConfigProvider = provider2;
        this.userUpdateBatcher = provider;
        this.userIdentityProvider = provider3;
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        if (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()] == 1 && ((Long) action.value()).longValue() - ((State) store.state()).hostAppState().backgroundedTimestamp() > ((AppConfig) this.appConfigProvider.get()).getNewSessionThresholdMs() && ((UserIdentity) this.userIdentityProvider.get()).identityExists() && !((Boolean) store.select(Selectors.SESSION_STARTED_SINCE_LAST_BACKGROUNDED)).booleanValue()) {
            ((UserUpdateBatcher) this.userUpdateBatcher.get()).updateUser(new UserUpdateRequest(true, ((Boolean) store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue(), true));
        }
    }
}
