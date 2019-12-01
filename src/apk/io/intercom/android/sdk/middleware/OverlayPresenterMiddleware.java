package io.intercom.android.sdk.middleware;

import android.app.Activity;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;

public class OverlayPresenterMiddleware implements Middleware<State> {
    private final Provider<OverlayPresenter> presenterProvider;

    /* renamed from: io.intercom.android.sdk.middleware.OverlayPresenterMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_PAUSED.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_STOPPED.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.APP_ENTERED_BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public OverlayPresenterMiddleware(Provider<OverlayPresenter> provider) {
        this.presenterProvider = provider;
    }

    private OverlayPresenter presenter() {
        return (OverlayPresenter) this.presenterProvider.get();
    }

    private void removeOverlays(Activity activity) {
        if (activity != null) {
            presenter().removeOverlaysIfPresent(activity);
        }
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        OverlayState overlayState = (OverlayState) store.select(Selectors.OVERLAY);
        Activity pausedHostActivity = overlayState.pausedHostActivity();
        Activity resumedHostActivity = overlayState.resumedHostActivity();
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                removeOverlays(pausedHostActivity);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    presenter().cancelAnimations();
                    removeOverlays(pausedHostActivity);
                    removeOverlays(resumedHostActivity);
                }
            } else if (((Activity) action.value()) == pausedHostActivity) {
                removeOverlays(pausedHostActivity);
            }
        } else if (((Activity) action.value()) != pausedHostActivity) {
            removeOverlays(pausedHostActivity);
        }
        nextDispatcher.dispatch(action);
    }
}
