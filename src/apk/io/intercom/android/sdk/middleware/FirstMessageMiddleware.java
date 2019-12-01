package io.intercom.android.sdk.middleware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;
import io.intercom.android.sdk.twig.Twig;

public class FirstMessageMiddleware implements Middleware<State> {
    private final Context context;
    private final Twig twig;

    /* renamed from: io.intercom.android.sdk.middleware.FirstMessageMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.BASE_RESPONSE_RECEIVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public FirstMessageMiddleware(Twig twig2, Context context2) {
        this.twig = twig2;
        this.context = context2;
    }

    private void showFirstMessageToast() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.intercom_onboarding_layout, null);
        Toast toast = new Toast(this.context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        if (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()] == 1 && ((BaseResponse) action.value()).getConfig().isFirstRequest()) {
            this.twig.i(this.context.getString(R.string.intercom_android_activated_message), new Object[0]);
            try {
                showFirstMessageToast();
            } catch (Exception e2) {
                Twig twig2 = this.twig;
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't show first message toast: ");
                sb.append(e2.getMessage());
                twig2.internal(sb.toString());
            }
        }
    }
}
