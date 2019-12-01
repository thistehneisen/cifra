package io.intercom.android.sdk.middleware;

import b.d.i;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.conversation.SoundPlayer;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Middleware;
import io.intercom.android.sdk.store.Store.NextDispatcher;
import java.util.Set;

public class AudioMiddleware implements Middleware<State> {
    private final i<String, String> playedPartIdsForConversations = new i<>();
    private final SoundPlayer soundPlayer;
    private final Provider<UserIdentity> userIdentityProvider;

    /* renamed from: io.intercom.android.sdk.middleware.AudioMiddleware$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.UNREAD_CONVERSATIONS_SUCCESS.ordinal()] = 1;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT.ordinal()] = 2;
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.SET_IN_APP_NOTIFICATION_VISIBILITY.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type[Type.HARD_RESET.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public AudioMiddleware(SoundPlayer soundPlayer2, Provider<UserIdentity> provider) {
        this.soundPlayer = soundPlayer2;
        this.userIdentityProvider = provider;
    }

    private boolean neverPlayedAudioFor(Conversation conversation, Part part) {
        return !part.getId().equals((String) this.playedPartIdsForConversations.get(conversation.getId()));
    }

    private static boolean noActivityForOverlays(OverlayState overlayState) {
        return overlayState.resumedHostActivity() == null;
    }

    private static boolean notificationsDisabled(OverlayState overlayState) {
        return overlayState.notificationVisibility() != Visibility.VISIBLE;
    }

    public void dispatch(Store<State> store, Action<?> action, NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        if (!((UserIdentity) this.userIdentityProvider.get()).isSoftReset()) {
            int i2 = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                OverlayState overlayState = (OverlayState) store.select(Selectors.OVERLAY);
                if (!notificationsDisabled(overlayState) && !noActivityForOverlays(overlayState)) {
                    Set dismissedPartIds = overlayState.dismissedPartIds();
                    boolean z = false;
                    for (Conversation conversation : overlayState.conversations()) {
                        Part lastPart = conversation.getLastPart();
                        if (lastPart != Part.NULL && !dismissedPartIds.contains(lastPart.getId())) {
                            z = z || neverPlayedAudioFor(conversation, lastPart);
                            this.playedPartIdsForConversations.put(conversation.getId(), lastPart.getId());
                        }
                    }
                    if (z) {
                        this.soundPlayer.playMessageReceivedSound();
                    }
                }
            } else if (i2 == 4) {
                this.playedPartIdsForConversations.clear();
            }
        }
    }
}
