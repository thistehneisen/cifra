package io.intercom.android.sdk;

import android.app.Application;
import android.app.TaskStackBuilder;
import io.intercom.android.sdk.identity.Registration;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ValidatorUtil;
import java.util.Map;

public abstract class Intercom {
    public static final Visibility GONE = Visibility.GONE;
    public static final String PUSH_RECEIVER = "intercom_sdk";
    private static final Twig TWIG = LumberMill.getLogger();
    public static final Visibility VISIBLE = Visibility.VISIBLE;
    private static Intercom instance;

    public @interface LogLevel {
        public static final int ASSERT = 7;
        public static final int DEBUG = 3;
        public static final int DISABLED = 8;
        public static final int ERROR = 6;
        public static final int INFO = 4;
        public static final int VERBOSE = 2;
        public static final int WARN = 5;
    }

    public enum Visibility {
        GONE,
        VISIBLE
    }

    public static synchronized Intercom client() {
        Intercom intercom;
        synchronized (Intercom.class) {
            if (instance != null) {
                intercom = instance;
            } else {
                throw new IllegalStateException("Please call Intercom.initialize() before requesting the client.");
            }
        }
        return intercom;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        return;
     */
    public static synchronized void initialize(Application application, String str, String str2) {
        synchronized (Intercom.class) {
            if (instance != null) {
                TWIG.i("Intercom has already been initialized", new Object[0]);
            } else if (ValidatorUtil.isValidConstructorParams(application, str, str2)) {
                TWIG.i("Intercom has already been initialized", new Object[0]);
                instance = RealIntercom.create(application, str, str2);
                LateInitializationPreparer.getInstance().handlePastLifecycleEvents(application, Injector.get());
            } else {
                instance = new InvalidIntercom();
            }
        }
    }

    public static synchronized void registerForLaterInitialisation(Application application) {
        synchronized (Intercom.class) {
            if (instance != null) {
                TWIG.i("Intercom has already been initialized", new Object[0]);
            } else if (application != null) {
                LateInitializationPreparer.getInstance().register(application);
            } else {
                throw new NullPointerException("Cannot call registerForLaterInitialisation() with a null Application");
            }
        }
    }

    public static void setLogLevel(@LogLevel int i2) {
        LumberMill.setLogLevel(i2);
    }

    public static void unregisterForLateInitialisation(Application application) {
        if (application != null) {
            LateInitializationPreparer.getInstance().unregister(application);
            return;
        }
        throw new NullPointerException("Cannot call unregisterForLateInitialisation() with a null Application");
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

    public abstract void logout();

    public abstract void registerIdentifiedUser(Registration registration);

    public abstract void registerUnidentifiedUser();

    public abstract void removeUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener);

    @Deprecated
    public abstract void reset();

    public abstract void setBottomPadding(int i2);

    public abstract void setInAppMessageVisibility(Visibility visibility);

    public abstract void setLauncherVisibility(Visibility visibility);

    public abstract void setUserHash(String str);

    public abstract void updateUser(UserAttributes userAttributes);
}
