package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import e.a.a.a.a.d;
import e.a.a.a.a.k;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.activities.IntercomMessengerActivity;
import io.intercom.android.sdk.activities.IntercomNoteActivity;
import io.intercom.android.sdk.activities.IntercomPostActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricTracker.InAppMessageViewContext;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.DeliveryOption;
import io.intercom.android.sdk.models.events.ConfigUpdateEvent;
import io.intercom.android.sdk.overlay.LauncherOpenBehaviour.LauncherType;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.Store.Subscriber2;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.com.bumptech.glide.n;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OverlayPresenter implements Listener, Subscriber2<Integer, OverlayState> {
    /* access modifiers changed from: private */
    public final Provider<AppConfig> appConfigProvider;
    private final Handler handler;
    final InAppNotificationPresenter inAppNotificationPresenter;
    final DefaultLauncherPresenter launcherPresenter;
    private final MetricTracker metricTracker;
    private final n requestManager;
    private final Store<State> store;
    private final Twig twig = LumberMill.getLogger();
    /* access modifiers changed from: private */
    public final UserIdentity userIdentity;
    private final Set<String> viewedPartIds = new HashSet();

    public OverlayPresenter(Application application, d dVar, Store<State> store2, Provider<AppConfig> provider, MetricTracker metricTracker2, UserIdentity userIdentity2, n nVar) {
        Store<State> store3 = store2;
        Provider<AppConfig> provider2 = provider;
        MetricTracker metricTracker3 = metricTracker2;
        this.appConfigProvider = provider2;
        this.store = store3;
        this.metricTracker = metricTracker3;
        this.userIdentity = userIdentity2;
        n nVar2 = nVar;
        this.requestManager = nVar2;
        LayoutInflater from = LayoutInflater.from(application);
        this.handler = new Handler(Looper.getMainLooper());
        InAppNotificationPresenter inAppNotificationPresenter2 = new InAppNotificationPresenter(from, this.handler, this, metricTracker2, provider, new ContextLocaliser(provider2), nVar2, hostActivity());
        this.inAppNotificationPresenter = inAppNotificationPresenter2;
        this.launcherPresenter = new DefaultLauncherPresenter(from, new LauncherOpenBehaviour(store3, LauncherType.DEFAULT, metricTracker3, provider2), metricTracker3);
        dVar.register(this);
        store3.subscribeToChanges(Selectors.UNREAD_COUNT, Selectors.OVERLAY, this);
    }

    private Activity hostActivity() {
        return ((OverlayState) this.store.select(Selectors.OVERLAY)).resumedHostActivity();
    }

    private void openMessenger(Conversation conversation) {
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            hostActivity.startActivity(IntercomMessengerActivity.openConversation(hostActivity, conversation.getId(), conversation.getLastParticipatingAdmin()));
        }
    }

    private void openNote(Conversation conversation) {
        try {
            Activity hostActivity = hostActivity();
            if (hostActivity != null) {
                hostActivity.startActivity(IntercomNoteActivity.buildNoteIntent(hostActivity, conversation.getLastPart(), conversation.getId(), conversation.getLastParticipatingAdmin()));
            }
        } catch (IllegalArgumentException e2) {
            Twig twig2 = this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Error loading the note ");
            sb.append(e2.getMessage());
            twig2.internal("Overlay", sb.toString());
        }
    }

    private void openPost(Conversation conversation) {
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            hostActivity.startActivity(IntercomPostActivity.buildPostIntent(hostActivity, conversation.getLastPart(), conversation.getId(), conversation.getLastParticipatingAdmin(), true));
        }
    }

    private void trackInAppView(String str, String str2, @InAppMessageViewContext int i2) {
        if (!this.viewedPartIds.contains(str2)) {
            this.viewedPartIds.add(str2);
            this.metricTracker.viewedInApp(str, str2, i2);
        }
    }

    public void cancelAnimations() {
        this.handler.removeCallbacksAndMessages(null);
    }

    @k
    public void configUpdated(ConfigUpdateEvent configUpdateEvent) {
        OverlayState overlayState = (OverlayState) this.store.select(Selectors.OVERLAY);
        Activity resumedHostActivity = overlayState.resumedHostActivity();
        if (shouldDisplayLauncher(overlayState.conversations(), overlayState.notificationVisibility(), overlayState.launcherVisibility(), resumedHostActivity)) {
            final ViewGroup rootView = getRootView(resumedHostActivity);
            ViewUtils.waitForViewAttachment(rootView, new Runnable() {
                public void run() {
                    int primaryColor = ((AppConfig) OverlayPresenter.this.appConfigProvider.get()).getPrimaryColor();
                    OverlayPresenter overlayPresenter = OverlayPresenter.this;
                    overlayPresenter.launcherPresenter.displayLauncherOnAttachedRoot(rootView, primaryColor, (AppConfig) overlayPresenter.appConfigProvider.get());
                }
            });
            return;
        }
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        this.launcherPresenter.setLauncherBackgroundColor(appConfig, appConfig.getPrimaryColor());
    }

    /* access modifiers changed from: 0000 */
    public void displayNotifications(final List<Conversation> list, Activity activity) {
        final ViewGroup rootView = getRootView(activity);
        Conversation conversation = (Conversation) list.get(0);
        String messageStyle = conversation.getLastPart().getMessageStyle();
        DeliveryOption deliveryOption = conversation.getLastPart().getDeliveryOption();
        if (list.size() > 1 || this.inAppNotificationPresenter.isDisplaying() || deliveryOption == DeliveryOption.SUMMARY || (deliveryOption == DeliveryOption.FULL && Part.CHAT_MESSAGE_STYLE.equals(messageStyle))) {
            if (this.launcherPresenter.isDisplaying()) {
                final DefaultLauncher andUnsetLauncher = this.launcherPresenter.getAndUnsetLauncher();
                if (list.size() == 1) {
                    andUnsetLauncher.pulseForTransformation(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            andUnsetLauncher.fadeOffScreen(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    andUnsetLauncher.removeView();
                                }
                            });
                            OverlayPresenter.this.inAppNotificationPresenter.displayNotifications(rootView, list);
                        }
                    });
                } else {
                    andUnsetLauncher.fadeOffScreen(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            andUnsetLauncher.removeView();
                            OverlayPresenter.this.inAppNotificationPresenter.displayNotifications(rootView, list);
                        }
                    });
                }
            } else {
                this.inAppNotificationPresenter.displayNotifications(rootView, list);
            }
        } else if (deliveryOption != DeliveryOption.FULL) {
        } else {
            if (Part.POST_MESSAGE_STYLE.equals(messageStyle)) {
                trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 1);
                openPost(conversation);
            } else if (Part.NOTE_MESSAGE_STYLE.equals(messageStyle)) {
                trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 1);
                openNote(conversation);
            }
        }
    }

    public ViewGroup getRootView() throws Exception {
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            return getRootView(hostActivity);
        }
        throw new NullPointerException();
    }

    public void markAsDismissed(Conversation conversation) {
        this.store.dispatch(Actions.conversationMarkedAsDismissed(conversation));
    }

    public void openNotification(Conversation conversation) {
        Part lastAdminPart = conversation.getLastAdminPart();
        String messageStyle = lastAdminPart.getMessageStyle();
        if (Part.POST_MESSAGE_STYLE.equals(messageStyle)) {
            trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 0);
            openPost(conversation);
        } else if (Part.NOTE_MESSAGE_STYLE.equals(messageStyle)) {
            trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 0);
            openNote(conversation);
        } else {
            openMessenger(conversation);
            if (!Part.CHAT_MESSAGE_STYLE.equals(messageStyle) || DeliveryOption.FULL != lastAdminPart.getDeliveryOption()) {
                this.metricTracker.openedConversationFromSnippet(conversation.getId(), lastAdminPart.getId());
            } else {
                this.metricTracker.openedConversationFromFull(conversation.getId(), lastAdminPart.getId());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void preloadAvatarThenDisplayNotifications(List<Conversation> list, Visibility visibility, Activity activity, String str) {
        Avatar avatar = ((Conversation) list.get(0)).getLastAdmin().getAvatar();
        final String str2 = str;
        final List<Conversation> list2 = list;
        final Visibility visibility2 = visibility;
        final Activity activity2 = activity;
        AnonymousClass4 r1 = new Runnable() {
            public void run() {
                if (str2.equals(OverlayPresenter.this.userIdentity.getFingerprint()) && OverlayPresenter.this.shouldDisplayNotifications(list2, visibility2, activity2)) {
                    OverlayPresenter.this.displayNotifications(list2, activity2);
                }
            }
        };
        AvatarUtils.preloadAvatar(avatar, r1, this.requestManager);
    }

    public void refreshStateBecauseUserIdentityIsNotInStoreYet() {
        onStateChange((Integer) this.store.select(Selectors.UNREAD_COUNT), (OverlayState) this.store.select(Selectors.OVERLAY));
    }

    public void removeOverlaysIfPresent(Activity activity) {
        final View findViewById = activity.findViewById(R.id.intercom_overlay_root);
        activity.runOnUiThread(new Runnable() {
            public void run() {
                if (findViewById != null) {
                    OverlayPresenter.this.launcherPresenter.removeLauncher();
                    OverlayPresenter.this.inAppNotificationPresenter.reset((ViewGroup) findViewById);
                    if (findViewById.getParent() != null) {
                        ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldDisplayLauncher(List<Conversation> list, Visibility visibility, Visibility visibility2, Activity activity) {
        boolean z = false;
        if (visibility == Visibility.VISIBLE) {
            for (Conversation lastPart : list) {
                if (DeliveryOption.BADGE != lastPart.getLastPart().getDeliveryOption()) {
                    return false;
                }
            }
        }
        if (visibility2 == Visibility.VISIBLE && !this.userIdentity.isSoftReset() && this.userIdentity.identityExists() && ((AppConfig) this.appConfigProvider.get()).isReceivedFromServer() && activity != null) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldDisplayNotifications(List<Conversation> list, Visibility visibility, Activity activity) {
        return visibility == Visibility.VISIBLE && !this.userIdentity.isSoftReset() && !list.isEmpty() && activity != null;
    }

    public void softReset() {
        cancelAnimations();
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            removeOverlaysIfPresent(hostActivity);
        }
    }

    public void onStateChange(final Integer num, OverlayState overlayState) {
        Visibility notificationVisibility = overlayState.notificationVisibility();
        Activity resumedHostActivity = overlayState.resumedHostActivity();
        List conversations = overlayState.conversations();
        this.launcherPresenter.setBottomPadding(overlayState.bottomPadding());
        this.inAppNotificationPresenter.setBottomPadding(overlayState.bottomPadding());
        if (resumedHostActivity != null && !resumedHostActivity.isFinishing()) {
            if (VERSION.SDK_INT >= 17 && resumedHostActivity.isDestroyed()) {
                return;
            }
            if (shouldDisplayNotifications(conversations, notificationVisibility, resumedHostActivity)) {
                preloadAvatarThenDisplayNotifications(conversations, notificationVisibility, resumedHostActivity, this.userIdentity.getFingerprint());
            } else if (shouldDisplayLauncher(conversations, notificationVisibility, overlayState.launcherVisibility(), resumedHostActivity)) {
                final ViewGroup rootView = getRootView(resumedHostActivity);
                ViewUtils.waitForViewAttachment(rootView, new Runnable() {
                    public void run() {
                        OverlayPresenter.this.inAppNotificationPresenter.reset(rootView);
                        OverlayPresenter.this.launcherPresenter.setUnreadCount(num.intValue());
                        int primaryColor = ((AppConfig) OverlayPresenter.this.appConfigProvider.get()).getPrimaryColor();
                        OverlayPresenter overlayPresenter = OverlayPresenter.this;
                        overlayPresenter.launcherPresenter.displayLauncherOnAttachedRoot(rootView, primaryColor, (AppConfig) overlayPresenter.appConfigProvider.get());
                    }
                });
            } else {
                removeOverlaysIfPresent(resumedHostActivity);
            }
        }
    }

    private ViewGroup getRootView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.intercom_overlay_root);
        if (viewGroup != null) {
            return viewGroup;
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.setFitsSystemWindows(true);
        frameLayout.setId(R.id.intercom_overlay_root);
        activity.addContentView(frameLayout, new LayoutParams(-1, -1, 80));
        return frameLayout;
    }
}
