package io.intercom.android.sdk.store;

import android.annotation.SuppressLint;
import android.app.Activity;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part.DeliveryOption;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.store.Store.Reducer;
import io.intercom.android.sdk.utilities.ActivityUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class OverlayStateReducer implements Reducer<OverlayState> {
    @SuppressLint({"StaticFieldLeak"})
    static final OverlayState INITIAL_STATE = OverlayState.create(Collections.emptyList(), Collections.emptySet(), Visibility.VISIBLE, Visibility.GONE, null, null, 0);

    /* renamed from: io.intercom.android.sdk.store.OverlayStateReducer$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SET_IN_APP_NOTIFICATION_VISIBILITY.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SET_LAUNCHER_VISIBILITY.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SET_BOTTOM_PADDING.ordinal()] = 3;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 4;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_MARKED_AS_READ.ordinal()] = 5;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.CONVERSATION_MARKED_AS_DISMISSED.ordinal()] = 6;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.UNREAD_CONVERSATIONS_SUCCESS.ordinal()] = 7;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT.ordinal()] = 8;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_PAUSED.ordinal()] = 9;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_STOPPED.ordinal()] = 10;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.APP_ENTERED_BACKGROUND.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    OverlayStateReducer() {
    }

    private static OverlayState newStateIfNewHostActivity(OverlayState overlayState, Activity activity, Activity activity2) {
        if (overlayState.resumedHostActivity() == activity && overlayState.pausedHostActivity() == activity2) {
            return overlayState;
        }
        return overlayState.toBuilder().resumedHostActivity(activity).pausedHostActivity(activity2).build();
    }

    private static void removeBadgeConversations(List<Conversation> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((Conversation) list.get(size)).getLastPart().getDeliveryOption() == DeliveryOption.BADGE) {
                list.remove(size);
            }
        }
    }

    private static void removeConversationWithId(List<Conversation> list, String str) {
        for (Conversation conversation : list) {
            if (conversation.getId().equals(str)) {
                list.remove(conversation);
                return;
            }
        }
    }

    private static void removeDismissedConversations(List<Conversation> list, Set<String> set) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (set.contains(((Conversation) list.get(size)).getLastPart().getId())) {
                list.remove(size);
            }
        }
    }

    public OverlayState reduce(Action<?> action, OverlayState overlayState) {
        Activity activity = null;
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
                return overlayState.toBuilder().notificationVisibility((Visibility) action.value()).build();
            case 2:
                return overlayState.toBuilder().launcherVisibility((Visibility) action.value()).build();
            case 3:
                return overlayState.toBuilder().bottomPadding(((Integer) action.value()).intValue()).build();
            case 4:
                return overlayState.toBuilder().conversations(Collections.emptyList()).dismissedPartIds(Collections.emptySet()).build();
            case 5:
                ArrayList arrayList = new ArrayList(overlayState.conversations());
                removeConversationWithId(arrayList, (String) action.value());
                return overlayState.toBuilder().conversations(arrayList).build();
            case 6:
                Conversation conversation = (Conversation) action.value();
                ArrayList arrayList2 = new ArrayList(overlayState.conversations());
                HashSet hashSet = new HashSet(overlayState.dismissedPartIds());
                hashSet.add(conversation.getLastPart().getId());
                removeDismissedConversations(arrayList2, hashSet);
                return overlayState.toBuilder().conversations(arrayList2).dismissedPartIds(hashSet).build();
            case 7:
                ArrayList arrayList3 = new ArrayList(((UsersResponse) action.value()).getUnreadConversations().getConversations());
                removeDismissedConversations(arrayList3, overlayState.dismissedPartIds());
                removeBadgeConversations(arrayList3);
                return overlayState.toBuilder().conversations(arrayList3).build();
            case 8:
                Activity activity2 = (Activity) action.value();
                if (!ActivityUtils.isHostActivity(activity2) && !ActivityUtils.isFullScreenHelpCenter(activity2)) {
                    activity2 = null;
                }
                return newStateIfNewHostActivity(overlayState, activity2, null);
            case 9:
                return newStateIfNewHostActivity(overlayState, null, (Activity) action.value());
            case 10:
                if (((Activity) action.value()) != overlayState.pausedHostActivity()) {
                    activity = overlayState.pausedHostActivity();
                }
                return newStateIfNewHostActivity(overlayState, overlayState.resumedHostActivity(), activity);
            case 11:
                return newStateIfNewHostActivity(overlayState, null, null);
            default:
                return overlayState;
        }
    }
}
