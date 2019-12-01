package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import b.g.a.a;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.ConversationFragment;
import io.intercom.android.sdk.homescreen.HomeClickListener;
import io.intercom.android.sdk.homescreen.HomeFragment;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.inbox.InboxFragment;
import io.intercom.android.sdk.inbox.InboxFragment.Listener;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.state.InboxState.Status;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ActivityFinisher;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import java.util.Collections;
import java.util.List;

public class IntercomMessengerActivity extends IntercomBaseActivity implements Listener, ConversationFragment.Listener, HomeClickListener {
    static final String LAST_PARTICIPANT = "last_participant";
    static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    static final String PARCEL_INITIAL_MESSAGE = "parcel_initial_message";
    static final String SHOW_HOME_SCREEN = "showHomeScreen";
    static final String SHOW_INBOX = "showInbox";
    private ActivityFinisher activityFinisher;
    private Provider<AppConfig> appConfigProvider;
    View background;
    ValueAnimator colorAnimation;
    private View containerView;
    private HomeFragment homeFragment;
    private InboxFragment inboxFragment;
    private boolean isTwoPane;
    private MetricTracker metricTracker;
    private final Twig twig = LumberMill.getLogger();

    private void animateBackgroundColor() {
        this.background = getWindow().getDecorView();
        BackgroundUtils.animateBackground(a.a((Context) this, 17170445), a.a((Context) this, R.color.intercom_transparent_black), 200, this.background, new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomMessengerActivity.this.background.post(new Runnable() {
                    public void run() {
                        IntercomMessengerActivity.this.animateSdkWindowIn();
                    }
                });
            }
        });
    }

    private void applyBackOrCloseMessenger() {
        if (getSupportFragmentManager().b() == 0) {
            this.metricTracker.closedMessengerBackButton();
            closeMessenger();
            return;
        }
        trackMoveToConversationListMetric();
        hideKeyboard();
        super.onBackPressed();
    }

    private void closeMessenger() {
        hideKeyboard();
        showBackgroundColour();
        this.containerView.animate().y((float) getWindow().getDecorView().getHeight()).setInterpolator(new OvershootInterpolator()).setDuration(600).start();
        fadeOutBackground();
    }

    private void displayConversation(String str, LastParticipatingAdmin lastParticipatingAdmin, boolean z, boolean z2, String str2) {
        displayConversation(str, lastParticipatingAdmin, z, z2, str2, Collections.emptyList());
    }

    private void displayFragment(Fragment fragment, String str, boolean z) {
        Twig twig2 = this.twig;
        StringBuilder sb = new StringBuilder();
        sb.append("displaying ");
        sb.append(fragment);
        String str2 = "frag";
        twig2.internal(str2, sb.toString());
        F a2 = getSupportFragmentManager().a();
        a2.b((!(fragment instanceof ConversationFragment) || !this.isTwoPane) ? R.id.inbox_fragment : R.id.conversation_fragment, fragment, str);
        if (z) {
            Twig twig3 = this.twig;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adding ");
            sb2.append(fragment);
            sb2.append(" to the back stack");
            twig3.internal(str2, sb2.toString());
            a2.a(str);
        }
        a2.b();
    }

    private void fadeOutBackground() {
        int a2 = a.a((Context) this, 17170445);
        int a3 = a.a((Context) this, R.color.intercom_transparent_black);
        this.colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(a3), Integer.valueOf(a2)});
        this.colorAnimation.setDuration(300);
        this.colorAnimation.setStartDelay(100);
        this.colorAnimation.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IntercomMessengerActivity.this.background.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.colorAnimation.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomMessengerActivity.this.finish();
                IntercomMessengerActivity.this.overridePendingTransition(0, 0);
            }
        });
        this.colorAnimation.start();
    }

    private LastParticipatingAdmin getLastParticipatingAdmin(Conversation conversation) {
        LastParticipatingAdmin lastParticipatingAdmin = conversation.getLastParticipatingAdmin();
        return LastParticipatingAdmin.isNull(lastParticipatingAdmin) ? LastParticipatingAdmin.NONE : lastParticipatingAdmin;
    }

    private int getScreenHeight() {
        return findViewById(16908290).getMeasuredHeight();
    }

    private boolean hasLoadedFragment(String str) {
        return getSupportFragmentManager().a(str) != null;
    }

    private void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static Intent openComposer(Context context, String str) {
        Intent putExtra = new Intent(context, IntercomMessengerActivity.class).setFlags(268435456).putExtra(SHOW_INBOX, false);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra(PARCEL_INITIAL_MESSAGE, str);
        }
        return putExtra;
    }

    public static Intent openConversation(Context context, String str, LastParticipatingAdmin lastParticipatingAdmin) {
        Intent putExtra = new Intent(context, IntercomMessengerActivity.class).setFlags(268435456).putExtra(SHOW_INBOX, false);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra(PARCEL_CONVERSATION_ID, str);
        }
        if (!LastParticipatingAdmin.isNull(lastParticipatingAdmin)) {
            putExtra.putExtra(LAST_PARTICIPANT, lastParticipatingAdmin);
        }
        putExtra.setExtrasClassLoader(LastParticipatingAdmin.class.getClassLoader());
        return putExtra;
    }

    public static Intent openHomeScreen(Context context) {
        return new Intent(context, IntercomMessengerActivity.class).setFlags(268435456).putExtra(SHOW_HOME_SCREEN, true);
    }

    public static Intent openInbox(Context context) {
        return new Intent(context, IntercomMessengerActivity.class).setFlags(268435456).putExtra(SHOW_INBOX, true);
    }

    private void showBackgroundColour() {
        this.background.setBackgroundResource(R.color.intercom_transparent_black);
    }

    private void showMessenger() {
        String str;
        LastParticipatingAdmin lastParticipatingAdmin;
        String str2;
        boolean z;
        boolean z2;
        Bundle extras = getIntent().getExtras();
        LastParticipatingAdmin lastParticipatingAdmin2 = LastParticipatingAdmin.NULL;
        String str3 = "";
        if (extras != null) {
            extras.setClassLoader(Part.class.getClassLoader());
            String string = extras.getString(PARCEL_CONVERSATION_ID, str3);
            String string2 = extras.getString(PARCEL_INITIAL_MESSAGE, str3);
            z2 = extras.getBoolean(SHOW_HOME_SCREEN);
            z = extras.getBoolean(SHOW_INBOX);
            String str4 = LAST_PARTICIPANT;
            if (extras.containsKey(str4)) {
                lastParticipatingAdmin2 = (LastParticipatingAdmin) extras.getParcelable(str4);
            }
            lastParticipatingAdmin = lastParticipatingAdmin2;
            str = string2;
            str2 = string;
        } else {
            lastParticipatingAdmin = lastParticipatingAdmin2;
            str2 = str3;
            str = str2;
            z2 = false;
            z = false;
        }
        if (z2) {
            displayFragment(this.homeFragment, HomeFragment.class.getName(), false);
        } else if (this.isTwoPane) {
            displayFragment(this.inboxFragment, InboxFragment.class.getName(), false);
            boolean z3 = !str.isEmpty();
            if ((!str2.isEmpty()) || z3) {
                displayConversation(str2, lastParticipatingAdmin, false, false, str);
            }
        } else if (z) {
            displayFragment(this.inboxFragment, InboxFragment.class.getName(), false);
        } else {
            displayConversation(str2, lastParticipatingAdmin, false, false, str);
        }
        animateBackgroundColor();
    }

    private void trackMoveToConversationListMetric() {
        ConversationFragment existingConversationFragment = getExistingConversationFragment();
        if (existingConversationFragment != null) {
            String conversationId = existingConversationFragment.getConversationId();
            if (TextUtils.isEmpty(conversationId)) {
                this.metricTracker.openConversationsListFromNewConversation();
            } else {
                this.metricTracker.openConversationsListFromConversation(conversationId);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void animateSdkWindowIn() {
        this.containerView.setVisibility(0);
        this.containerView.setY((float) getScreenHeight());
        this.containerView.animate().y(0.0f).setInterpolator(new OvershootInterpolator(0.6f)).setDuration(350).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomMessengerActivity.this.hideBackgroundColor();
                ConversationFragment existingConversationFragment = IntercomMessengerActivity.this.getExistingConversationFragment();
                if (existingConversationFragment != null) {
                    existingConversationFragment.sdkWindowFinishedAnimating();
                }
            }
        }).start();
    }

    /* access modifiers changed from: 0000 */
    public ConversationFragment getExistingConversationFragment() {
        return (ConversationFragment) getSupportFragmentManager().a(ConversationFragment.class.getName());
    }

    /* access modifiers changed from: 0000 */
    public void hideBackgroundColor() {
        this.background.setBackgroundResource(R.color.intercom_full_transparent_full_black);
    }

    public void onBackClicked() {
        if (hasLoadedFragment(HomeFragment.class.getName())) {
            applyBackOrCloseMessenger();
            return;
        }
        trackMoveToConversationListMetric();
        hideKeyboard();
        displayFragment(this.homeFragment, HomeFragment.class.getName(), false);
    }

    public void onBackPressed() {
        ConversationFragment existingConversationFragment = getExistingConversationFragment();
        if (existingConversationFragment == null || !existingConversationFragment.shouldHandleOnBackPressed()) {
            applyBackOrCloseMessenger();
        } else {
            existingConversationFragment.handleOnBackPressed();
        }
    }

    public void onCloseClicked() {
        finish();
    }

    public void onComposerSelected() {
        displayConversation("", LastParticipatingAdmin.NONE, true, !this.isTwoPane, "");
        this.metricTracker.newConversationFromComposeButton(((State) Injector.get().getStore().state()).teamPresence().getOfficeHours().isEmpty());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.containerView.setY(0.0f);
        this.containerView.getLayoutParams().height = -1;
    }

    public void onConversationClicked(Conversation conversation) {
        this.metricTracker.openedConversationFromHomeScreen(conversation.getId());
        displayFragment(ConversationFragment.newInstance(conversation.getId(), getLastParticipatingAdmin(conversation), conversation.isRead(), this.isTwoPane, "", conversation.getGroupConversationParticipants()), ConversationFragment.class.getName(), true);
    }

    public void onConversationSelected(Conversation conversation) {
        LastParticipatingAdmin lastParticipatingAdmin = getLastParticipatingAdmin(conversation);
        TimeFormatter timeFormatter = new TimeFormatter(this, Injector.get().getTimeProvider());
        LastParticipatingAdmin lastParticipatingAdmin2 = lastParticipatingAdmin;
        displayConversation(conversation.getId(), lastParticipatingAdmin2, conversation.isRead(), !this.isTwoPane, "", conversation.getGroupConversationParticipants());
        this.metricTracker.openConversationFromConversationList(conversation.getId(), ((State) Injector.get().getStore().state()).teamPresence().getOfficeHours().isEmpty(), lastParticipatingAdmin.isActive(), timeFormatter.getLastActiveMinutes(lastParticipatingAdmin.getLastActiveAt()));
    }

    public void onConversationsLoaded(List<Conversation> list, Status status) {
        if (!this.isTwoPane || status != Status.SUCCESS || getExistingConversationFragment() != null) {
            return;
        }
        if (!list.isEmpty()) {
            onConversationSelected((Conversation) list.get(0));
        } else if (((AppConfig) this.appConfigProvider.get()).isInboundMessages()) {
            onComposerSelected();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_messenger_activity_layout);
        this.isTwoPane = getResources().getBoolean(R.bool.intercom_is_two_pane);
        this.homeFragment = HomeFragment.newInstance();
        this.inboxFragment = InboxFragment.newInstance(this.isTwoPane);
        this.containerView = findViewById(R.id.messenger_container);
        View view = this.containerView;
        if (view != null) {
            view.setVisibility(8);
        }
        getFragmentManager().executePendingTransactions();
        showMessenger();
        Injector injector = Injector.get();
        this.activityFinisher = injector.getActivityFinisher();
        this.activityFinisher.register(this);
        this.metricTracker = injector.getMetricTracker();
        this.appConfigProvider = injector.getAppConfigProvider();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.activityFinisher.unregister(this);
        super.onDestroy();
    }

    public void onNewConversationClicked() {
        this.metricTracker.openedNewConversationFromHomeScreen();
        displayFragment(ConversationFragment.newInstance("", LastParticipatingAdmin.NULL, false, this.isTwoPane, "", Collections.emptyList()), ConversationFragment.class.getName(), true);
    }

    public void onReloadClicked() {
        if (hasLoadedFragment(HomeFragment.class.getName())) {
            this.homeFragment.reload();
        }
    }

    public void onSeePreviousClicked() {
        displayFragment(this.inboxFragment, InboxFragment.class.getName(), true);
    }

    public void onToolbarCloseClicked() {
        this.metricTracker.closedMessengerCloseButton();
        closeMessenger();
    }

    private void displayConversation(String str, LastParticipatingAdmin lastParticipatingAdmin, boolean z, boolean z2, String str2, List<Participant> list) {
        displayFragment(ConversationFragment.newInstance(str, lastParticipatingAdmin, z, this.isTwoPane, str2, list), ConversationFragment.class.getName(), z2);
    }
}
