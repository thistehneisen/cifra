package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.InboxState.Status;
import io.intercom.android.sdk.state.ReplyPart;
import io.intercom.android.sdk.store.Store.Reducer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class InboxStateReducer implements Reducer<InboxState> {
    static final InboxState INITIAL_STATE = InboxState.create(Collections.emptyList(), Status.INITIAL, true);

    /* renamed from: io.intercom.android.sdk.store.InboxStateReducer$2 reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_REQUEST.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_BEFORE_DATE_REQUEST.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_SUCCESS.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_INBOX_FAILED.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_MARKED_AS_READ.ordinal()] = 5;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_REPLY_SUCCESS.ordinal()] = 6;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_CONVERSATION_SUCCESS.ordinal()] = 7;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.NEW_CONVERSATION_SUCCESS.ordinal()] = 8;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.FETCH_HOME_CARDS_SUCCESS.ordinal()] = 9;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SOFT_RESET.ordinal()] = 10;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    InboxStateReducer() {
    }

    private void addConversationAtTop(List<Conversation> list, Conversation conversation) {
        list.add(0, conversation);
    }

    private void markConversationAsRead(String str, List<Conversation> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Conversation conversation = (Conversation) list.get(i2);
            if (str.equals(conversation.getId())) {
                list.set(i2, conversation.withRead(true));
            }
        }
    }

    private List<Conversation> mergeConversationLists(List<Conversation> list, List<Conversation> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        HashSet hashSet = new HashSet(list2.size());
        for (Conversation conversation : list2) {
            hashSet.add(conversation.getId());
            arrayList.add(conversation);
        }
        for (Conversation conversation2 : list) {
            if (!hashSet.contains(conversation2.getId())) {
                arrayList.add(conversation2);
            }
        }
        return arrayList;
    }

    private void sortByLastPartDate(List<Conversation> list) {
        Collections.sort(list, new Comparator<Conversation>() {
            public int compare(Conversation conversation, Conversation conversation2) {
                return (int) (conversation2.getLastPart().getCreatedAt() - conversation.getLastPart().getCreatedAt());
            }
        });
    }

    private void updateOrAddConversation(Conversation conversation, List<Conversation> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (conversation.getId().equals(((Conversation) list.get(i2)).getId())) {
                list.set(i2, conversation);
                return;
            }
        }
        addConversationAtTop(list, conversation);
    }

    private void updateRepliedConversationAndMoveToTop(ReplyPart replyPart, List<Conversation> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Conversation conversation = (Conversation) list.get(i2);
            if (replyPart.getConversationId().equals(conversation.getId())) {
                conversation.getParts().add(replyPart.getPart());
                list.remove(conversation);
                addConversationAtTop(list, conversation);
            }
        }
    }

    public InboxState reduce(Action<?> action, InboxState inboxState) {
        switch (AnonymousClass2.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
            case 2:
                if (inboxState.status() == Status.LOADING) {
                    return inboxState;
                }
                return InboxState.create(inboxState.conversations(), Status.LOADING, inboxState.hasMorePages());
            case 3:
                ConversationsResponse conversationsResponse = (ConversationsResponse) action.value();
                List mergeConversationLists = mergeConversationLists(inboxState.conversations(), conversationsResponse.getConversationPage().getConversations());
                sortByLastPartDate(mergeConversationLists);
                return InboxState.create(mergeConversationLists, Status.SUCCESS, conversationsResponse.getConversationPage().hasMorePages());
            case 4:
                return InboxState.create(inboxState.conversations(), Status.FAILED, inboxState.hasMorePages());
            case 5:
                ArrayList arrayList = new ArrayList(inboxState.conversations());
                markConversationAsRead((String) action.value(), arrayList);
                return InboxState.create(arrayList, Status.SUCCESS, inboxState.hasMorePages());
            case 6:
                ArrayList arrayList2 = new ArrayList(inboxState.conversations());
                updateRepliedConversationAndMoveToTop((ReplyPart) action.value(), arrayList2);
                return InboxState.create(arrayList2, Status.SUCCESS, inboxState.hasMorePages());
            case 7:
                ArrayList arrayList3 = new ArrayList(inboxState.conversations());
                updateOrAddConversation((Conversation) action.value(), arrayList3);
                sortByLastPartDate(arrayList3);
                return InboxState.create(arrayList3, Status.SUCCESS, inboxState.hasMorePages());
            case 8:
                ArrayList arrayList4 = new ArrayList(inboxState.conversations());
                addConversationAtTop(arrayList4, (Conversation) action.value());
                return InboxState.create(arrayList4, Status.SUCCESS, inboxState.hasMorePages());
            case 9:
                List mergeConversationLists2 = mergeConversationLists(inboxState.conversations(), ((HomeCardsResponse) action.value()).getConversations());
                sortByLastPartDate(mergeConversationLists2);
                return InboxState.create(mergeConversationLists2, Status.SUCCESS, inboxState.hasMorePages());
            case 10:
            case 11:
                return INITIAL_STATE;
            default:
                return inboxState;
        }
    }
}
