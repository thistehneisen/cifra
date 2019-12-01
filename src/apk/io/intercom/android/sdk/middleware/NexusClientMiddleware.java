package io.intercom.android.sdk.middleware;

import android.os.Handler;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.nexus.NexusConfig;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;

public class NexusClientMiddleware implements Middleware<State> {
    private final Provider<AppConfig> appConfigProvider;
    private final Runnable disconnectRunnable = new Runnable() {
        public void run() {
            NexusClientMiddleware.this.client().disconnect();
        }
    };
    private final Handler handler;
    private final Provider<NexusClient> nexusClient;

    /* renamed from: io.intercom.android.sdk.middleware.NexusClientMiddleware$2 reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SOFT_RESET.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.BASE_RESPONSE_RECEIVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public NexusClientMiddleware(Provider<NexusClient> provider, Provider<AppConfig> provider2, Handler handler2) {
        this.nexusClient = provider;
        this.appConfigProvider = provider2;
        this.handler = handler2;
    }

    private void connectWithConfig(NexusConfig nexusConfig) {
        this.handler.removeCallbacks(this.disconnectRunnable);
        client().connect(nexusConfig, true);
    }

    private void disconnectImmediately() {
        this.handler.removeCallbacks(this.disconnectRunnable);
        client().disconnect();
    }

    private void scheduleDisconnect() {
        this.handler.removeCallbacks(this.disconnectRunnable);
        this.handler.postDelayed(this.disconnectRunnable, ((AppConfig) this.appConfigProvider.get()).getNewSessionThresholdMs());
    }

    /* access modifiers changed from: 0000 */
    public NexusClient client() {
        return (NexusClient) this.nexusClient.get();
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i2 = AnonymousClass2.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            connectWithConfig(((AppConfig) this.appConfigProvider.get()).getRealTimeConfig());
        } else if (i2 == 2) {
            scheduleDisconnect();
        } else if (i2 == 3) {
            disconnectImmediately();
        } else if (i2 == 4) {
            NexusConfig realTimeConfig = ((BaseResponse) action.value()).getConfig().getRealTimeConfig();
            if (realTimeConfig.getEndpoints().isEmpty()) {
                disconnectImmediately();
            } else if (!((Boolean) store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue()) {
                connectWithConfig(realTimeConfig);
            }
        }
    }
}
