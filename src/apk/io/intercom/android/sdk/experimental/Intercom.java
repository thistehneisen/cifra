package io.intercom.android.sdk.experimental;

import android.app.Application;
import android.app.TaskStackBuilder;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Intercom.LogLevel;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.LateInitializationPreparer;
import io.intercom.android.sdk.UnreadConversationCountListener;
import io.intercom.android.sdk.UserAttributes;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ValidatorUtil;
import java.util.Map;

public abstract class Intercom {
    public static final String PUSH_RECEIVER = "intercom_sdk";
    private static final Twig TWIG = LumberMill.getLogger();
    private static Intercom instance;

    public static synchronized void boot(Application application, IntercomSettings intercomSettings) {
        synchronized (Intercom.class) {
            if (instance == null) {
                if (ValidatorUtil.isValidConstructorParams(application, intercomSettings.getApiKey(), intercomSettings.getAppId())) {
                    instance = RealIntercom.create(application, intercomSettings.getApiKey(), intercomSettings.getAppId());
                    LateInitializationPreparer.getInstance().handlePastLifecycleEvents(application, Injector.get());
                    ((RealIntercom) instance).registerUser(intercomSettings);
                } else {
                    instance = new InvalidIntercom();
                }
            } else if (instance instanceof RealIntercom) {
                ((RealIntercom) instance).registerUser(intercomSettings);
            }
        }
    }

    public static synchronized Intercom client() {
        Intercom intercom;
        synchronized (Intercom.class) {
            if (isBooted()) {
                intercom = instance;
            } else {
                throw new IllegalStateException("Please call Intercom.boot() before requesting the client.");
            }
        }
        return intercom;
    }

    public static boolean isBooted() {
        return instance != null;
    }

    public static synchronized void registerForLaterBoot(Application application) {
        synchronized (Intercom.class) {
            if (isBooted()) {
                TWIG.i("Intercom has already been booted", new Object[0]);
            } else if (application != null) {
                LateInitializationPreparer.getInstance().register(application);
            } else {
                throw new NullPointerException("Cannot call registerForLaterBoot() with a null Application");
            }
        }
    }

    public static void setLogLevel(@LogLevel int i2) {
        LumberMill.setLogLevel(i2);
    }

    public static void unregisterForLateBoot(Application application) {
        if (application != null) {
            LateInitializationPreparer.getInstance().unregister(application);
            return;
        }
        throw new NullPointerException("Cannot call unregisterForLateBoot() with a null Application");
    }

    public abstract void addUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener);

    @Deprecated
    public abstract void displayConversationsList();

    public abstract void displayHelpCenter();

    public abstract void displayMessageComposer();

    public abstract void displayMessageComposer(String str);

    public abstract void displayMessenger();

    public abstract int getUnreadConversationCount();

    public abstract void handlePushMessage();

    public abstract void handlePushMessage(TaskStackBuilder taskStackBuilder);

    public abstract void hideMessenger();

    public abstract void logEvent(String str);

    public abstract void logEvent(String str, Map<String, ?> map);

    public abstract void removeUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener);

    public abstract void setBottomPadding(int i2);

    public abstract void setInAppMessageVisibility(Visibility visibility);

    public abstract void setLauncherVisibility(Visibility visibility);

    public abstract void setUserHash(String str);

    public abstract void shutdown();

    public abstract void updateUser(UserAttributes userAttributes);
}
