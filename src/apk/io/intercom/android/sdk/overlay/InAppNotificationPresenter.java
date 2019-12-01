package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.activities.IntercomMessengerActivity;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.DeliveryOption;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.SystemSettings;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.com.bumptech.glide.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class InAppNotificationPresenter implements Listener, OnClickListener {
    private static final int MAX_DISPLAYED_NOTIFICATIONS = 3;
    private static final int PILL_START_OFFSET_DP = 66;
    private final Activity activity;
    private final Provider<AppConfig> appConfigProvider;
    private int bottomPadding = 0;
    private final ContextLocaliser contextLocaliser;
    final Handler handler;
    private boolean hasAnimated = false;
    private final LayoutInflater inflater;
    private final List<Conversation> lastDisplayedConversations = new ArrayList();
    private final Listener listener;
    private final MetricTracker metricTracker;
    private final Map<String, InAppNotification> notifications = new HashMap();
    /* access modifiers changed from: private */
    public float pillPosition;
    private final n requestManager;
    private final Twig twig = LumberMill.getLogger();

    interface Listener {
        ViewGroup getRootView() throws Exception;

        void markAsDismissed(Conversation conversation);

        void openNotification(Conversation conversation);
    }

    public InAppNotificationPresenter(LayoutInflater layoutInflater, Handler handler2, Listener listener2, MetricTracker metricTracker2, Provider<AppConfig> provider, ContextLocaliser contextLocaliser2, n nVar, Activity activity2) {
        this.inflater = layoutInflater;
        this.listener = listener2;
        this.handler = handler2;
        this.metricTracker = metricTracker2;
        this.appConfigProvider = provider;
        this.contextLocaliser = contextLocaliser2;
        this.requestManager = nVar;
        this.activity = activity2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0093  */
    private void addNewNotifications(List<Conversation> list, ViewGroup viewGroup) {
        ChatFull chatFull;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Conversation conversation = (Conversation) list.get(i2);
            Context createLocalisedContext = this.contextLocaliser.createLocalisedContext(viewGroup.getContext());
            Part lastPart = conversation.getLastPart();
            if (size < 2) {
                if (Part.CHAT_MESSAGE_STYLE.equals(lastPart.getMessageStyle())) {
                    if (lastPart.getDeliveryOption() == DeliveryOption.SUMMARY) {
                        ChatSnippet chatSnippet = new ChatSnippet(createLocalisedContext, conversation, i2, viewGroup.getHeight(), this, this.appConfigProvider, this.requestManager);
                        chatFull = chatSnippet;
                    } else {
                        ChatFull chatFull2 = new ChatFull(createLocalisedContext, conversation, i2, viewGroup.getHeight(), this, this.metricTracker, this.appConfigProvider, this.requestManager, this.activity);
                        chatFull = chatFull2;
                    }
                    this.notifications.put(conversation.getId(), chatFull);
                    if (i2 >= 3) {
                        chatFull.display(viewGroup, this.inflater, !this.hasAnimated, this.bottomPadding);
                    } else {
                        ViewGroup viewGroup2 = viewGroup;
                    }
                }
            }
            StackableSnippet stackableSnippet = new StackableSnippet(createLocalisedContext, conversation, i2, this.handler, viewGroup.getHeight(), this, this.appConfigProvider, this.requestManager);
            chatFull = stackableSnippet;
            this.notifications.put(conversation.getId(), chatFull);
            if (i2 >= 3) {
            }
        }
    }

    private void animatePill(final View view) {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                view.setY(InAppNotificationPresenter.this.pillPosition + ((float) ScreenUtils.dpToPx(66.0f, view.getContext())));
                view.animate().setInterpolator(new OvershootInterpolator()).y(InAppNotificationPresenter.this.pillPosition).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
            }
        }, (long) (SystemSettings.getTransitionScale(view.getContext()) * 500.0f));
    }

    private void displayPill(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        TextView textView = (TextView) viewGroup.findViewById(R.id.notification_pill);
        if (this.notifications.size() > 3) {
            if (textView == null) {
                layoutInflater.inflate(R.layout.intercom_notification_pill, viewGroup, true);
                textView = (TextView) viewGroup.findViewById(R.id.notification_pill);
                textView.setAlpha(0.0f);
                textView.setScaleX(0.4f);
                textView.setScaleY(0.4f);
                textView.setY(this.pillPosition);
                textView.setOnClickListener(this);
                animatePill(textView);
            }
            Phrase.from(this.contextLocaliser.createLocalisedContext(textView.getContext()), R.string.intercom_plus_x_more).put("n", this.notifications.size() - 3).into(textView);
        } else if (textView != null) {
            viewGroup.removeView(textView);
        }
    }

    private boolean isReply(Conversation conversation) {
        if (this.lastDisplayedConversations.isEmpty() || !conversation.getId().equals(((Conversation) this.lastDisplayedConversations.get(0)).getId())) {
            return false;
        }
        return true;
    }

    private void updateNotifications(final List<Conversation> list, final Map<String, InAppNotification> map, final ViewGroup viewGroup) {
        InAppNotification inAppNotification;
        final Conversation conversation = (Conversation) list.get(0);
        Iterator it = map.values().iterator();
        InAppNotification inAppNotification2 = (InAppNotification) it.next();
        loop0:
        while (true) {
            inAppNotification = inAppNotification2;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                inAppNotification2 = (InAppNotification) it.next();
                if (inAppNotification2.getPosition() < inAppNotification.getPosition()) {
                }
            }
        }
        if (isReply(conversation)) {
            inAppNotification.update(conversation, new Runnable() {
                public void run() {
                    InAppNotificationPresenter.this.syncUpdates(list, map, viewGroup);
                }
            });
        } else if (map.size() != 1 || !(inAppNotification instanceof ChatSnippet)) {
            for (InAppNotification inAppNotification3 : map.values()) {
                if (inAppNotification3.getPosition() < 3) {
                    inAppNotification3.moveBackward(viewGroup);
                } else {
                    inAppNotification3.setPosition(inAppNotification3.getPosition() + 1);
                }
            }
            addNewView(conversation, viewGroup, map);
            syncUpdates(list, map, viewGroup);
        } else {
            final ViewGroup viewGroup2 = viewGroup;
            final Map<String, InAppNotification> map2 = map;
            final List<Conversation> list2 = list;
            AnonymousClass3 r1 = new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    InAppNotificationPresenter.this.addNewView(conversation, viewGroup2, map2);
                    InAppNotificationPresenter.this.handler.postDelayed(new Runnable() {
                        public void run() {
                            AnonymousClass3 r0 = AnonymousClass3.this;
                            InAppNotificationPresenter.this.syncUpdates(list2, map2, viewGroup2);
                        }
                    }, 220);
                }
            };
            inAppNotification.moveBackward(viewGroup, r1);
        }
    }

    private void updatePillPosition(View view) {
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("y", new float[]{view.getY(), this.pillPosition})}).setDuration(300).start();
    }

    /* access modifiers changed from: 0000 */
    public void addNewView(Conversation conversation, ViewGroup viewGroup, Map<String, InAppNotification> map) {
        StackableSnippet stackableSnippet = new StackableSnippet(this.contextLocaliser.createLocalisedContext(viewGroup.getContext()), conversation, 0, this.handler, viewGroup.getHeight(), this, this.appConfigProvider, this.requestManager);
        stackableSnippet.display(viewGroup, this.inflater, true, this.bottomPadding);
        if (map.containsKey(conversation.getId())) {
            ((InAppNotification) map.get(conversation.getId())).removeView();
        }
        map.put(conversation.getId(), stackableSnippet);
    }

    public void displayNotifications(final ViewGroup viewGroup, final List<Conversation> list) {
        ViewUtils.waitForViewAttachment(viewGroup, new Runnable() {
            public void run() {
                InAppNotificationPresenter.this.displayNotificationsAfterAttach(list, viewGroup);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void displayNotificationsAfterAttach(List<Conversation> list, ViewGroup viewGroup) {
        boolean z = !this.lastDisplayedConversations.equals(list) && !this.notifications.isEmpty();
        HashMap hashMap = new HashMap(this.notifications);
        if (z) {
            updateNotifications(list, hashMap, viewGroup);
        } else if (!isDisplaying()) {
            addNewNotifications(list, viewGroup);
        }
        this.hasAnimated = true;
        Resources resources = viewGroup.getResources();
        this.pillPosition = (float) (((viewGroup.getHeight() - resources.getDimensionPixelSize(R.dimen.intercom_overlay_pill_bottom_margin)) - resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding)) - this.bottomPadding);
        displayPill(this.inflater, viewGroup);
        this.lastDisplayedConversations.clear();
        this.lastDisplayedConversations.addAll(list);
    }

    public boolean isDisplaying() {
        return !this.notifications.isEmpty();
    }

    public void onClick(View view) {
        view.getContext().startActivity(IntercomMessengerActivity.openInbox(view.getContext()));
    }

    public void onInAppNotificationDismiss(InAppNotification inAppNotification) {
        ViewGroup viewGroup;
        try {
            viewGroup = this.listener.getRootView();
        } catch (Exception e2) {
            Twig twig2 = this.twig;
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't get root view: ");
            sb.append(e2.getMessage());
            twig2.internal(sb.toString());
            viewGroup = null;
        }
        Conversation conversation = inAppNotification.getConversation();
        if (viewGroup != null) {
            this.listener.markAsDismissed(conversation);
            viewGroup.removeView(inAppNotification.getRootView());
            this.notifications.remove(conversation.getId());
            this.lastDisplayedConversations.remove(conversation);
            for (InAppNotification moveForward : this.notifications.values()) {
                moveForward.moveForward(viewGroup, this.inflater);
            }
            displayPill(this.inflater, viewGroup);
            if (this.notifications.isEmpty()) {
                this.hasAnimated = false;
            }
        }
        Part lastAdminPart = conversation.getLastAdminPart();
        if (Part.CHAT_MESSAGE_STYLE.equals(lastAdminPart.getMessageStyle()) && DeliveryOption.FULL == lastAdminPart.getDeliveryOption()) {
            this.metricTracker.closedInAppFromFull(conversation.getId(), lastAdminPart.getId());
        } else if (lastAdminPart.isInitialMessage()) {
            this.metricTracker.dismissInAppMessageSnippet(conversation.getId(), lastAdminPart.getId());
        } else {
            this.metricTracker.dismissInAppCommentSnippet(conversation.getId(), lastAdminPart.getId());
        }
    }

    public void onInAppNotificationTap(Conversation conversation) {
        this.listener.openNotification(conversation);
    }

    public void reset(ViewGroup viewGroup) {
        for (InAppNotification removeView : this.notifications.values()) {
            removeView.removeView();
        }
        View findViewById = viewGroup.findViewById(R.id.notification_pill);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        this.notifications.clear();
    }

    public void setBottomPadding(int i2) {
        this.bottomPadding = i2;
        if (isDisplaying()) {
            for (InAppNotification updateBottomPadding : this.notifications.values()) {
                updateBottomPadding.updateBottomPadding(this.inflater.getContext(), this.bottomPadding);
            }
            ViewGroup viewGroup = null;
            try {
                viewGroup = this.listener.getRootView();
            } catch (Exception e2) {
                Twig twig2 = this.twig;
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't get root view: ");
                sb.append(e2.getMessage());
                twig2.internal(sb.toString());
            }
            if (viewGroup != null) {
                Resources resources = viewGroup.getResources();
                this.pillPosition = (float) (((viewGroup.getHeight() - resources.getDimensionPixelSize(R.dimen.intercom_overlay_pill_bottom_margin)) - resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding)) - i2);
                View findViewById = viewGroup.findViewById(R.id.notification_pill);
                if (findViewById != null) {
                    updatePillPosition(findViewById);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void syncUpdates(List<Conversation> list, Map<String, InAppNotification> map, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Conversation conversation = (Conversation) list.get(i2);
            InAppNotification inAppNotification = (InAppNotification) map.remove(conversation.getId());
            if (((inAppNotification instanceof ChatSnippet) && i2 > 0) || inAppNotification == 0) {
                if (inAppNotification != 0) {
                    inAppNotification.removeView();
                }
                StackableSnippet stackableSnippet = new StackableSnippet(this.contextLocaliser.createLocalisedContext(viewGroup.getContext()), conversation, i2, this.handler, viewGroup.getHeight(), this, this.appConfigProvider, this.requestManager);
                inAppNotification = stackableSnippet;
            }
            if (i2 < 3) {
                inAppNotification.display(viewGroup, conversation, this.inflater, false, this.bottomPadding);
            } else {
                inAppNotification.removeView();
            }
            this.notifications.put(conversation.getId(), inAppNotification);
        }
        for (InAppNotification removeView : map.values()) {
            removeView.removeView();
        }
    }
}
