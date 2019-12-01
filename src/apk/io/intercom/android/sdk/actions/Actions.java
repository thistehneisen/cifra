package io.intercom.android.sdk.actions;

import android.app.Activity;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.actions.Action.Type;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.state.ReplyPart;

public class Actions {
    private static final Object NONE = "No Value";

    public static Action<Activity> activityPaused(Activity activity) {
        return new Action<>(Type.ACTIVITY_PAUSED, activity);
    }

    public static Action<Activity> activityReadyForViewAttachment(Activity activity) {
        return new Action<>(Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT, activity);
    }

    public static Action<Activity> activityStopped(Activity activity) {
        return new Action<>(Type.ACTIVITY_STOPPED, activity);
    }

    public static Action<Long> appEnteredBackground(long j2) {
        return new Action<>(Type.APP_ENTERED_BACKGROUND, Long.valueOf(j2));
    }

    public static Action<Long> appEnteredForeground(long j2) {
        return new Action<>(Type.APP_ENTERED_FOREGROUND, Long.valueOf(j2));
    }

    public static Action<BaseResponse> baseResponseReceived(BaseResponse baseResponse) {
        return new Action<>(Type.BASE_RESPONSE_RECEIVED, baseResponse);
    }

    public static Action<String> composerCleared(String str) {
        return new Action<>(Type.COMPOSER_CLEARED, str);
    }

    public static Action<?> composerInputChanged() {
        return noValueAction(Type.COMPOSER_INPUT_CHANGED);
    }

    public static Action<?> composerOpened() {
        return noValueAction(Type.NEW_CONVERSATION_SCREEN_OPENED);
    }

    public static Action<?> composerSendButtonPressed() {
        return noValueAction(Type.COMPOSER_SEND_BUTTON_PRESSED);
    }

    public static Action<String> composerTypedIn(String str) {
        return new Action<>(Type.COMPOSER_TYPED_IN, str);
    }

    public static Action<?> conversationClosed() {
        return noValueAction(Type.CONVERSATION_CLOSED);
    }

    public static Action<Conversation> conversationMarkedAsDismissed(Conversation conversation) {
        return new Action<>(Type.CONVERSATION_MARKED_AS_DISMISSED, conversation);
    }

    public static Action<String> conversationMarkedAsRead(String str) {
        return new Action<>(Type.CONVERSATION_MARKED_AS_READ, str);
    }

    public static Action<String> conversationOpened(String str) {
        return new Action<>(Type.CONVERSATION_OPENED, str);
    }

    public static Action<ReplyPart> conversationReplySuccess(ReplyPart replyPart) {
        return new Action<>(Type.CONVERSATION_REPLY_SUCCESS, replyPart);
    }

    public static Action<Conversation> fetchConversationSuccess(Conversation conversation) {
        return new Action<>(Type.FETCH_CONVERSATION_SUCCESS, conversation);
    }

    public static Action<HomeCardsResponse> fetchHomeCardsSuccess(HomeCardsResponse homeCardsResponse) {
        return new Action<>(Type.FETCH_HOME_CARDS_SUCCESS, homeCardsResponse);
    }

    public static Action<Long> fetchInboxBeforeDateRequest(long j2) {
        return new Action<>(Type.FETCH_INBOX_BEFORE_DATE_REQUEST, Long.valueOf(j2));
    }

    public static Action<?> fetchInboxFailed() {
        return noValueAction(Type.FETCH_INBOX_FAILED);
    }

    public static Action<?> fetchInboxRequest() {
        return noValueAction(Type.FETCH_INBOX_REQUEST);
    }

    public static Action<ConversationsResponse> fetchInboxSuccess(ConversationsResponse conversationsResponse) {
        return new Action<>(Type.FETCH_INBOX_SUCCESS, conversationsResponse);
    }

    public static Action<?> hardReset() {
        return noValueAction(Type.HARD_RESET);
    }

    public static Action<?> homeOpened() {
        return noValueAction(Type.HOME_OPENED);
    }

    public static Action<?> inboxOpened() {
        return noValueAction(Type.INBOX_OPENED);
    }

    public static Action<String> newCommentEventReceived(String str) {
        return new Action<>(Type.NEW_COMMENT_EVENT_RECEIVED, str);
    }

    public static Action<Conversation> newConversationSuccess(Conversation conversation) {
        return new Action<>(Type.NEW_CONVERSATION_SUCCESS, conversation);
    }

    private static Action<?> noValueAction(Type type) {
        return new Action<>(type, NONE);
    }

    public static Action<?> sessionStarted() {
        return noValueAction(Type.SESSION_STARTED);
    }

    public static Action<Integer> setBottomPadding(int i2) {
        return new Action<>(Type.SET_BOTTOM_PADDING, Integer.valueOf(i2));
    }

    public static Action<Visibility> setInAppNotificationVisibility(Visibility visibility) {
        return new Action<>(Type.SET_IN_APP_NOTIFICATION_VISIBILITY, visibility);
    }

    public static Action<Visibility> setLauncherVisibility(Visibility visibility) {
        return new Action<>(Type.SET_LAUNCHER_VISIBILITY, visibility);
    }

    public static Action<?> softReset() {
        return noValueAction(Type.SOFT_RESET);
    }

    public static Action<TeamPresence> teamPresenceUpdated(TeamPresence teamPresence) {
        return new Action<>(Type.TEAM_PRESENCE_UPDATED, teamPresence);
    }

    public static Action<UsersResponse> unreadConversationsSuccess(UsersResponse usersResponse) {
        return new Action<>(Type.UNREAD_CONVERSATIONS_SUCCESS, usersResponse);
    }
}
