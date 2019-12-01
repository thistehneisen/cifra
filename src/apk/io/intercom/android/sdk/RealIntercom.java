package io.intercom.android.sdk;

import android.app.Application;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.IntercomPushManager.IntercomPushIntegrationType;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.activities.IntercomHelpCenterActivity;
import io.intercom.android.sdk.activities.IntercomMessengerActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.DeDuper;
import io.intercom.android.sdk.api.UserUpdateBatcher;
import io.intercom.android.sdk.api.UserUpdateRequest;
import io.intercom.android.sdk.errorreporting.ErrorReporter;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.FeatureFlag;
import io.intercom.android.sdk.identity.Registration;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.overlay.LauncherOpenBehaviour;
import io.intercom.android.sdk.overlay.LauncherOpenBehaviour.LauncherType;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.push.SystemNotificationManager;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.UnreadCountTracker;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.user.DeviceData;
import io.intercom.android.sdk.utilities.ActivityFinisher;
import io.intercom.android.sdk.utilities.AttributeSanitiser;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class RealIntercom extends Intercom {
    private final ActivityFinisher activityFinisher;
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final Context context;
    private final ErrorReporter errorReporter;
    private final MetricTracker metricTracker;
    private final NexusClient nexusClient;
    /* access modifiers changed from: private */
    public final OverlayPresenter overlayPresenter;
    private final ResetManager resetManager;
    private final Store<State> store;
    private final DeDuper superDeDuper;
    private final SystemNotificationManager systemNotificationManager;
    private final Twig twig;
    private final UnreadCountTracker unreadCountTracker;
    private final UserIdentity userIdentity;
    private final Provider<UserUpdateBatcher> userUpdateBatcher;

    /* renamed from: io.intercom.android.sdk.RealIntercom$2 reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$IntercomPushManager$IntercomPushIntegrationType = new int[IntercomPushIntegrationType.values().length];

        static {
            try {
                $SwitchMap$io$intercom$android$sdk$IntercomPushManager$IntercomPushIntegrationType[IntercomPushIntegrationType.FCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    RealIntercom(DeDuper deDuper, Provider<Api> provider, NexusClient nexusClient2, Store<State> store2, UnreadCountTracker unreadCountTracker2, MetricTracker metricTracker2, ErrorReporter errorReporter2, Context context2, OverlayPresenter overlayPresenter2, Provider<AppConfig> provider2, UserIdentity userIdentity2, SystemNotificationManager systemNotificationManager2, Provider<UserUpdateBatcher> provider3, ResetManager resetManager2, Twig twig2, ActivityFinisher activityFinisher2) {
        Context context3 = context2;
        SystemNotificationManager systemNotificationManager3 = systemNotificationManager2;
        Twig twig3 = twig2;
        this.superDeDuper = deDuper;
        this.apiProvider = provider;
        this.nexusClient = nexusClient2;
        this.store = store2;
        this.unreadCountTracker = unreadCountTracker2;
        this.metricTracker = metricTracker2;
        this.errorReporter = errorReporter2;
        this.context = context3;
        this.overlayPresenter = overlayPresenter2;
        this.appConfigProvider = provider2;
        this.userIdentity = userIdentity2;
        this.systemNotificationManager = systemNotificationManager3;
        this.userUpdateBatcher = provider3;
        this.resetManager = resetManager2;
        this.twig = twig3;
        this.activityFinisher = activityFinisher2;
        if (AnonymousClass2.$SwitchMap$io$intercom$android$sdk$IntercomPushManager$IntercomPushIntegrationType[IntercomPushManager.getInstalledModuleType().ordinal()] != 1) {
            systemNotificationManager2.deleteNotificationChannels();
            twig3.internal("No FCM integration detected");
        } else {
            twig3.i("Enabling FCM for cloud messaging", new Object[0]);
            systemNotificationManager3.setUpNotificationChannelsIfSupported(context2);
        }
        if (shouldDisableErrorReporting()) {
            errorReporter2.disableExceptionHandler();
        } else {
            errorReporter2.enableExceptionHandler();
        }
    }

    static Intercom create(Application application, String str, String str2) {
        Application application2 = application;
        Injector.initWithAppCredentials(application, str, str2);
        Injector injector = Injector.get();
        UserIdentity userIdentity2 = injector.getUserIdentity();
        Store store2 = injector.getStore();
        Store store3 = store2;
        DeDuper deDuper = injector.getDeDuper();
        Provider apiProvider2 = injector.getApiProvider();
        NexusClient nexusClient2 = injector.getNexusClient();
        UnreadCountTracker unreadCountTracker2 = r7;
        UnreadCountTracker unreadCountTracker3 = new UnreadCountTracker(store2);
        RealIntercom realIntercom = new RealIntercom(deDuper, apiProvider2, nexusClient2, store3, unreadCountTracker2, injector.getMetricTracker(), injector.getErrorReporter(), application2, injector.getOverlayPresenter(), injector.getAppConfigProvider(), userIdentity2, injector.getSystemNotificationManager(), injector.getUserUpdateBatcherProvider(), injector.getResetManager(), LumberMill.getLogger(), injector.getActivityFinisher());
        return realIntercom;
    }

    private void logErrorAndOpenInbox(String str) {
        this.twig.e(str, new Object[0]);
        displayConversationsList();
    }

    private void logEventWithValidation(String str, Map<String, ?> map) {
        if (TextUtils.isEmpty(str)) {
            this.twig.e("The event name is null or empty. We can't log an event with this string.", new Object[0]);
            return;
        }
        ((UserUpdateBatcher) this.userUpdateBatcher.get()).submitPendingUpdate();
        ((Api) this.apiProvider.get()).logEvent(str, map);
    }

    private boolean noUserRegistered() {
        return !this.userIdentity.identityExists() || this.userIdentity.isSoftReset();
    }

    private void openIntercomChatPush(String str, TaskStackBuilder taskStackBuilder) {
        Intent intent;
        if (str.equals(IntercomPushManager.MULTIPLE_NOTIFICATIONS)) {
            intent = IntercomMessengerActivity.openInbox(this.context);
        } else {
            intent = IntercomMessengerActivity.openConversation(this.context, str, LastParticipatingAdmin.NULL);
        }
        if (taskStackBuilder == null || VERSION.SDK_INT < 16) {
            this.context.startActivity(intent);
        } else {
            taskStackBuilder.addNextIntent(intent);
            this.context.startActivities(taskStackBuilder.getIntents());
        }
        this.metricTracker.viewedPushNotification(str);
        this.systemNotificationManager.clear();
    }

    private void performUpdate(Map<String, Object> map) {
        if (this.userIdentity.isUnidentified()) {
            AttributeSanitiser.anonymousSanitisation(map);
        }
        String str = "dupe";
        if (this.superDeDuper.shouldUpdateUser(map)) {
            this.superDeDuper.update(map);
            ((UserUpdateBatcher) this.userUpdateBatcher.get()).updateUser(new UserUpdateRequest(false, ((Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue(), map, false));
            this.twig.internal(str, "updated user");
            return;
        }
        this.twig.internal(str, "dropped dupe");
    }

    private boolean shouldDisableErrorReporting() {
        return ((AppConfig) this.appConfigProvider.get()).hasFeature(FeatureFlag.DISABLE_ERROR_REPORTING);
    }

    private void softRegister() {
        String deviceToken = DeviceData.getDeviceToken(this.context);
        if (!TextUtils.isEmpty(deviceToken)) {
            ((Api) this.apiProvider.get()).setDeviceToken(deviceToken);
        }
        this.nexusClient.connect(((AppConfig) this.appConfigProvider.get()).getRealTimeConfig(), true);
        this.userIdentity.softRestart();
        this.resetManager.clear();
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                RealIntercom.this.overlayPresenter.refreshStateBecauseUserIdentityIsNotInStoreYet();
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r0);
        }
    }

    private boolean userIsRegistered(Registration registration) {
        return this.userIdentity.isSoftReset() && this.userIdentity.isSameUser(registration);
    }

    public void addUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener) {
        if (unreadConversationCountListener != null) {
            this.unreadCountTracker.addListener(unreadConversationCountListener);
        }
    }

    public void displayConversationsList() {
        this.metricTracker.openedMessengerConversationList(LauncherType.CUSTOM);
        Context context2 = this.context;
        context2.startActivity(IntercomMessengerActivity.openHomeScreen(context2));
    }

    public void displayHelpCenter() {
        if (!TextUtils.isEmpty(((AppConfig) this.appConfigProvider.get()).getHelpCenterUrl())) {
            this.context.startActivity(IntercomHelpCenterActivity.buildIntent(this.context, ((AppConfig) this.appConfigProvider.get()).getHelpCenterUrl(), 1, ""));
        } else if (noUserRegistered()) {
            this.twig.e("The app config has not been retrieved, please call registerUnidentifiedUser() or registerIdentifiedUser(Registration) before calling displayHelpCenter().", new Object[0]);
        } else {
            this.twig.e("Could not open Help Center. Please make sure you have turned on Help Center in Educate settings.", new Object[0]);
        }
    }

    public void displayMessageComposer() {
        displayMessageComposer("");
    }

    public void displayMessenger() {
        if (noUserRegistered()) {
            logErrorAndOpenInbox("The messenger was opened but there was no user registered on this device.Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).");
        } else {
            new LauncherOpenBehaviour(this.store, LauncherType.CUSTOM, this.metricTracker, this.appConfigProvider).openMessenger(this.context);
        }
    }

    public int getUnreadConversationCount() {
        return ((State) this.store.state()).unreadConversationIds().size();
    }

    public void handlePushMessage() {
        handlePushMessage(null);
    }

    public void hideMessenger() {
        this.activityFinisher.finishActivities();
    }

    public void logEvent(String str) {
        logEventWithValidation(str, Collections.emptyMap());
    }

    public void logout() {
        if (!this.userIdentity.isSoftReset()) {
            this.resetManager.softReset();
        }
    }

    public void registerIdentifiedUser(Registration registration) {
        UserUpdateRequest userUpdateRequest;
        if (registration == null) {
            this.twig.e("The registration object you passed to is null. An example successful call is registerIdentifiedUser(Registration.create().withEmail(email));", new Object[0]);
            return;
        }
        if (userIsRegistered(registration)) {
            softRegister();
        } else {
            this.resetManager.hardReset();
            if (this.userIdentity.canRegisterIdentifiedUser(registration)) {
                this.userIdentity.registerIdentifiedUser(registration);
                this.nexusClient.disconnect();
                Boolean valueOf = Boolean.valueOf(!((Boolean) this.store.select(Selectors.SESSION_STARTED_SINCE_LAST_BACKGROUNDED)).booleanValue());
                Boolean bool = (Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED);
                if (registration.getAttributes() != null) {
                    userUpdateRequest = new UserUpdateRequest(valueOf.booleanValue(), bool.booleanValue(), registration.getAttributes().toMap(), true);
                } else {
                    userUpdateRequest = new UserUpdateRequest(valueOf.booleanValue(), bool.booleanValue(), true);
                }
                ((UserUpdateBatcher) this.userUpdateBatcher.get()).updateUser(userUpdateRequest);
            } else if (this.userIdentity.registrationHasAttributes(registration)) {
                this.twig.i("We already have a registered user. Updating this user with the attributes provided.", new Object[0]);
                updateUser(registration.getAttributes());
            } else {
                this.twig.i("Failed to register user. We already have a registered user. If you are attempting to register a new user, call logout() before this.", new Object[0]);
            }
        }
    }

    public void registerUnidentifiedUser() {
        if (this.userIdentity.canRegisterUnidentifiedUser()) {
            this.resetManager.hardReset();
            this.userIdentity.registerUnidentifiedUser();
            this.nexusClient.disconnect();
            Boolean bool = (Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED);
            ((UserUpdateBatcher) this.userUpdateBatcher.get()).updateUser(new UserUpdateRequest(Boolean.valueOf(!((Boolean) this.store.select(Selectors.SESSION_STARTED_SINCE_LAST_BACKGROUNDED)).booleanValue()).booleanValue(), bool.booleanValue(), true));
            return;
        }
        this.twig.i("Failed to register user. We already have a registered user. If you are attempting to register a new user, call logout() before this. If you are attempting to register an identified user call: registerIdentifiedUser(Registration)", new Object[0]);
    }

    public void removeUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener) {
        this.unreadCountTracker.removeListener(unreadConversationCountListener);
    }

    public void reset() {
        logout();
    }

    public void setBottomPadding(int i2) {
        this.store.dispatch(Actions.setBottomPadding(i2));
    }

    public void setInAppMessageVisibility(Visibility visibility) {
        this.store.dispatch(Actions.setInAppNotificationVisibility(visibility));
    }

    public void setLauncherVisibility(Visibility visibility) {
        this.store.dispatch(Actions.setLauncherVisibility(visibility));
    }

    public void setUserHash(String str) {
        if (TextUtils.isEmpty(str)) {
            this.twig.w("The user hash you sent us to verify was either null or empty, we will not be able to authenticate your requests without a valid user hash.", new Object[0]);
        } else if (this.userIdentity.getHmac().equals(str)) {
            this.twig.i("The user hash set matches the existing user identity hash value", new Object[0]);
        } else {
            if (this.userIdentity.softUserIdentityHmacDiffers(str)) {
                this.resetManager.hardReset();
            }
            this.userIdentity.setUserHash(str);
        }
    }

    public void updateUser(UserAttributes userAttributes) {
        if (userAttributes == null) {
            this.twig.e("updateUser method failed: the UserAttributes object provided is null", new Object[0]);
            return;
        }
        performUpdate(userAttributes.toMap());
    }

    public void displayMessageComposer(String str) {
        if (noUserRegistered()) {
            logErrorAndOpenInbox("The messenger was opened but there was no user registered on this device. Please call registerUnidentifiedUser() or registerIdentifiedUser(Registration).");
        } else if (!((AppConfig) this.appConfigProvider.get()).isReceivedFromServer()) {
            logErrorAndOpenInbox("It appears your app has not received a successful response from Intercom. Please check you are using the correct Android app ID and API Key from the Intercom settings.");
        } else if (!((AppConfig) this.appConfigProvider.get()).isInboundMessages()) {
            logErrorAndOpenInbox("It appears your app is not on a plan that allows message composing. As a fallback we are calling displayConversationsList()");
        } else {
            this.metricTracker.openedMessengerNewConversation(LauncherType.CUSTOM);
            Context context2 = this.context;
            context2.startActivity(IntercomMessengerActivity.openComposer(context2, str));
        }
    }

    public void handlePushMessage(TaskStackBuilder taskStackBuilder) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(PreferenceKeys.INTERCOM_PUSH_PREFS, 0);
        String string = sharedPreferences.getString(IntercomPushManager.INTERCOM_PUSH_PATH, "");
        if (TextUtils.isEmpty(string)) {
            this.twig.internal("No Uri found");
            return;
        }
        openIntercomChatPush(string, taskStackBuilder);
        sharedPreferences.edit().clear().apply();
    }

    public void logEvent(String str, Map<String, ?> map) {
        if (map == null) {
            this.twig.i("The metadata provided is null, logging event with no metadata", new Object[0]);
            map = new HashMap<>();
        } else if (map.isEmpty()) {
            this.twig.i("The metadata provided is empty, logging event with no metadata", new Object[0]);
        }
        logEventWithValidation(str, map);
    }
}
