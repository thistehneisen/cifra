package io.intercom.android.sdk.overlay;

import android.content.Context;
import android.text.TextUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.activities.IntercomMessengerActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.state.UiState;
import io.intercom.android.sdk.state.UiState.Screen;
import io.intercom.android.sdk.store.Store;
import java.util.Set;

public class LauncherOpenBehaviour {
    private final AppConfig appConfig;
    private final LauncherType launcherType;
    private final MetricTracker metricTracker;
    private final Store<State> store;

    /* renamed from: io.intercom.android.sdk.overlay.LauncherOpenBehaviour$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$state$UiState$Screen = new int[Screen.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$io$intercom$android$sdk$state$UiState$Screen[Screen.CONVERSATION.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$state$UiState$Screen[Screen.COMPOSER.ordinal()] = 2;
            try {
                $SwitchMap$io$intercom$android$sdk$state$UiState$Screen[Screen.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum LauncherType {
        DEFAULT,
        CUSTOM
    }

    public LauncherOpenBehaviour(Store<State> store2, LauncherType launcherType2, MetricTracker metricTracker2, Provider<AppConfig> provider) {
        this.store = store2;
        this.launcherType = launcherType2;
        this.metricTracker = metricTracker2;
        this.appConfig = (AppConfig) provider.get();
    }

    private void openLastOrDefaultState(Context context) {
        UiState uiState = ((State) this.store.state()).uiState();
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$state$UiState$Screen[uiState.screen().ordinal()];
        if (i2 == 1) {
            String conversationId = uiState.conversationId();
            if (TextUtils.isEmpty(conversationId)) {
                presentHome(context);
            } else {
                presentConversation(context, conversationId);
            }
        } else if (i2 != 2) {
            presentHome(context);
        } else {
            presentComposer(context);
        }
    }

    private void presentComposer(Context context) {
        this.metricTracker.openedMessengerNewConversation(this.launcherType);
        context.startActivity(IntercomMessengerActivity.openComposer(context, ""));
    }

    private void presentConversation(Context context, String str) {
        this.metricTracker.openedMessengerConversation(str, this.launcherType);
        context.startActivity(IntercomMessengerActivity.openConversation(context, str, LastParticipatingAdmin.NULL));
    }

    private void presentHome(Context context) {
        this.metricTracker.openedHomeScreen(this.launcherType);
        context.startActivity(IntercomMessengerActivity.openHomeScreen(context));
    }

    public void openMessenger(Context context) {
        Set unreadConversationIds = ((State) this.store.state()).unreadConversationIds();
        if (unreadConversationIds.size() == 1) {
            presentConversation(context, (String) unreadConversationIds.iterator().next());
        } else if (!this.appConfig.isInboundMessages() || ((State) this.store.state()).hasConversations() || this.appConfig.getHomeScreenCardCount() != 0) {
            openLastOrDefaultState(context);
        } else {
            presentComposer(context);
        }
    }
}
