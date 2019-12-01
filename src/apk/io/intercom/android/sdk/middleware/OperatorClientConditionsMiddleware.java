package io.intercom.android.sdk.middleware;

import android.os.Handler;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.OperatorClientCondition;
import io.intercom.android.sdk.operator.OperatorClientConditionTimer;
import io.intercom.android.sdk.state.ActiveConversationState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;
import io.intercom.android.sdk.views.ClientConditionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OperatorClientConditionsMiddleware implements ClientConditionListener, Middleware<State> {
    private static final String USER_INTERACTION_CONDITION = "user_interaction_condition";
    private final Provider<Api> apiProvider;
    final Map<String, List<OperatorClientConditionTimer>> conversationConditions = new HashMap();
    private final Handler handler;

    /* renamed from: io.intercom.android.sdk.middleware.OperatorClientConditionsMiddleware$1 reason: invalid class name */
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
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_TYPED_IN.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_CLEARED.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.COMPOSER_INPUT_CHANGED.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_CONVERSATION_SUCCESS.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.NEW_CONVERSATION_SUCCESS.ordinal()] = 5;
        }
    }

    public OperatorClientConditionsMiddleware(Provider<Api> provider, Handler handler2) {
        this.apiProvider = provider;
        this.handler = handler2;
    }

    private void addClientConditionsForConversation(String str, List<OperatorClientCondition> list, ActiveConversationState activeConversationState) {
        if (!list.isEmpty()) {
            List list2 = (List) this.conversationConditions.get(str);
            if (list2 == null) {
                list2 = new ArrayList();
                this.conversationConditions.put(str, list2);
            }
            for (OperatorClientCondition operatorClientCondition : list) {
                if (USER_INTERACTION_CONDITION.equals(operatorClientCondition.conditionId())) {
                    createOperatorClientConditionTimer(str, activeConversationState, list2, operatorClientCondition);
                }
            }
        }
    }

    private void createOperatorClientConditionTimer(String str, ActiveConversationState activeConversationState, List<OperatorClientConditionTimer> list, OperatorClientCondition operatorClientCondition) {
        OperatorClientConditionTimer operatorClientConditionTimer = new OperatorClientConditionTimer(str, operatorClientCondition.id(), this.handler, this);
        list.add(operatorClientConditionTimer);
        operatorClientConditionTimer.beginCountdown();
        if (userHasInteractedWithConversation(str, activeConversationState)) {
            operatorClientConditionTimer.interrupt();
        }
    }

    private void interruptCondition(String str) {
        List<OperatorClientConditionTimer> list = (List) this.conversationConditions.get(str);
        if (list != null) {
            for (OperatorClientConditionTimer interrupt : list) {
                interrupt.interrupt();
            }
        }
    }

    private boolean userHasInteractedWithConversation(String str, ActiveConversationState activeConversationState) {
        return activeConversationState.getConversationId().equals(str) && (activeConversationState.hasSwitchedInputType() || activeConversationState.hasTextInComposer());
    }

    public void conditionSatisfied(String str, String str2) {
        Iterator it = ((List) this.conversationConditions.get(str)).iterator();
        while (it.hasNext()) {
            if (((OperatorClientConditionTimer) it.next()).getCondition().equals(str2)) {
                it.remove();
            }
        }
        ((Api) this.apiProvider.get()).satisfyOperatorCondition(str, str2);
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            interruptCondition(((State) store.state()).activeConversationState().getConversationId());
        } else if (i2 == 4 || i2 == 5) {
            Conversation conversation = (Conversation) action.value();
            addClientConditionsForConversation(conversation.getId(), conversation.getOperatorClientConditions(), ((State) store.state()).activeConversationState());
        }
    }
}
