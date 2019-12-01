package io.intercom.android.sdk;

import android.app.TaskStackBuilder;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.identity.Registration;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.twig.Twig;
import java.util.Map;

class InvalidIntercom extends Intercom {
    private final Twig twig = LumberMill.getLogger();

    InvalidIntercom() {
    }

    private void logIncorrectInitialisationWarning() {
        this.twig.e("Intercom has been initialized incorrectly. Please make sure the first Intercom method you call is initialize() and that you're passing in the correct app ID and API key", new Object[0]);
    }

    public void addUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener) {
        logIncorrectInitialisationWarning();
    }

    public void displayConversationsList() {
        logIncorrectInitialisationWarning();
    }

    public void displayHelpCenter() {
        logIncorrectInitialisationWarning();
    }

    public void displayMessageComposer() {
        logIncorrectInitialisationWarning();
    }

    public void displayMessenger() {
        logIncorrectInitialisationWarning();
    }

    public int getUnreadConversationCount() {
        logIncorrectInitialisationWarning();
        return 0;
    }

    public void handlePushMessage() {
        logIncorrectInitialisationWarning();
    }

    public void hideMessenger() {
        logIncorrectInitialisationWarning();
    }

    public void logEvent(String str) {
        logIncorrectInitialisationWarning();
    }

    public void logout() {
        logIncorrectInitialisationWarning();
    }

    public void registerIdentifiedUser(Registration registration) {
        logIncorrectInitialisationWarning();
    }

    public void registerUnidentifiedUser() {
        logIncorrectInitialisationWarning();
    }

    public void removeUnreadConversationCountListener(UnreadConversationCountListener unreadConversationCountListener) {
        logIncorrectInitialisationWarning();
    }

    public void reset() {
        logIncorrectInitialisationWarning();
    }

    public void setBottomPadding(int i2) {
        logIncorrectInitialisationWarning();
    }

    public void setInAppMessageVisibility(Visibility visibility) {
        logIncorrectInitialisationWarning();
    }

    public void setLauncherVisibility(Visibility visibility) {
        logIncorrectInitialisationWarning();
    }

    public void setUserHash(String str) {
        logIncorrectInitialisationWarning();
    }

    public void updateUser(UserAttributes userAttributes) {
        logIncorrectInitialisationWarning();
    }

    public void displayMessageComposer(String str) {
        logIncorrectInitialisationWarning();
    }

    public void handlePushMessage(TaskStackBuilder taskStackBuilder) {
        logIncorrectInitialisationWarning();
    }

    public void logEvent(String str, Map<String, ?> map) {
        logIncorrectInitialisationWarning();
    }
}
