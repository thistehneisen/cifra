package io.intercom.android.sdk.middleware;

import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;

public class AppConfigMiddleware implements Middleware<State> {
    private final Provider<AppConfig> appConfigProvider;
    private final d bus;

    /* renamed from: io.intercom.android.sdk.middleware.AppConfigMiddleware$1 reason: invalid class name */
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

    public AppConfigMiddleware(Provider<AppConfig> provider, d dVar) {
        this.appConfigProvider = provider;
        this.bus = dVar;
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            ((AppConfig) this.appConfigProvider.get()).update(((BaseResponse) action.value()).getConfig(), this.bus);
        } else if (i2 == 2) {
            ((AppConfig) this.appConfigProvider.get()).resetRealTimeConfig();
        }
    }
}
