package io.intercom.android.sdk.middleware;

import android.app.Activity;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;
import io.intercom.android.sdk.twig.Twig;

public class LoggerMiddleware<S> implements Middleware<S> {
    private final Twig twig;

    /* renamed from: io.intercom.android.sdk.middleware.LoggerMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_PAUSED.ordinal()] = 2;
        }
    }

    public LoggerMiddleware(Twig twig2) {
        this.twig = twig2;
    }

    public void dispatch(Store<S> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatched Action: ");
        sb.append(action.toString());
        twig2.i(sb.toString(), new Object[0]);
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            Activity activity = (Activity) action.value();
            Twig twig3 = this.twig;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ready to show in-app messages in ");
            sb2.append(activity);
            twig3.i(sb2.toString(), new Object[0]);
        } else if (i2 == 2) {
            Activity activity2 = (Activity) action.value();
            Twig twig4 = this.twig;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(activity2);
            sb3.append(" was paused");
            twig4.i(sb3.toString(), new Object[0]);
        }
    }
}
