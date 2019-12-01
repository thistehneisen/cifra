package io.intercom.android.sdk.middleware;

import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;

public class ApiMiddleware implements Middleware<State> {
    private final Provider<Api> apiProvider;

    /* renamed from: io.intercom.android.sdk.middleware.ApiMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_MARKED_AS_DISMISSED.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_MARKED_AS_READ.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_REQUEST.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_BEFORE_DATE_REQUEST.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.NEW_COMMENT_EVENT_RECEIVED.ordinal()] = 5;
        }
    }

    public ApiMiddleware(Provider<Api> provider) {
        this.apiProvider = provider;
    }

    private Api api() {
        return (Api) this.apiProvider.get();
    }

    private void fetchDataForCurrentScreen(Store<State> store, String str) {
        if (((OverlayState) store.select(Selectors.OVERLAY)).resumedHostActivity() != null || ((Boolean) store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue()) {
            api().getUnreadConversations();
        } else {
            api().getConversation(str);
        }
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            api().markConversationAsDismissed(((Conversation) action.value()).getId());
        } else if (i2 == 2) {
            int size = ((OverlayState) store.select(Selectors.OVERLAY)).conversations().size();
            if (size == 1 && ((Integer) store.select(Selectors.UNREAD_COUNT)).intValue() > size) {
                api().getUnreadConversations();
            }
        } else if (i2 == 3) {
            api().getInbox();
        } else if (i2 == 4) {
            api().getInboxBefore(((Long) action.value()).longValue());
        } else if (i2 == 5) {
            fetchDataForCurrentScreen(store, (String) action.value());
        }
    }
}
