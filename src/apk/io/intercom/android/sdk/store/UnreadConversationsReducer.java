package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.store.Store.Reducer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class UnreadConversationsReducer implements Reducer<Set<String>> {
    static final Set<String> INITIAL_STATE = Collections.emptySet();

    /* renamed from: io.intercom.android.sdk.store.UnreadConversationsReducer$1 reason: invalid class name */
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
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_MARKED_AS_READ.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.UNREAD_CONVERSATIONS_SUCCESS.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_SUCCESS.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_CONVERSATION_SUCCESS.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 5;
        }
    }

    UnreadConversationsReducer() {
    }

    public Set<String> reduce(Action<?> action, Set<String> set) {
        int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i2 == 1) {
            HashSet hashSet = new HashSet(set);
            hashSet.remove((String) action.value());
            return hashSet;
        } else if (i2 == 2) {
            return new HashSet(((UsersResponse) action.value()).getUnreadConversations().getUnreadConversationIds());
        } else {
            if (i2 == 3) {
                return new HashSet(((ConversationsResponse) action.value()).getConversationPage().getUnreadConversationIds());
            }
            if (i2 == 4) {
                HashSet hashSet2 = new HashSet(set);
                Conversation conversation = (Conversation) action.value();
                if (conversation.isRead()) {
                    hashSet2.remove(conversation.getId());
                } else {
                    hashSet2.add(conversation.getId());
                }
                return hashSet2;
            } else if (i2 != 5) {
                return set;
            } else {
                return INITIAL_STATE;
            }
        }
    }
}
