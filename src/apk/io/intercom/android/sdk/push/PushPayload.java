package io.intercom.android.sdk.push;

import android.os.Bundle;

public abstract class PushPayload {
    private static final String MESSAGE_TYPE = "message";
    private static final String PUSH_ONLY = "push_only";

    public static PushPayload create(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle2 == null) {
            return create(Bundle.EMPTY);
        }
        AutoValue_PushPayload autoValue_PushPayload = new AutoValue_PushPayload(stringOrEmpty(bundle2, "conversation_id"), stringOrEmpty(bundle2, "message"), stringOrEmpty(bundle2, "body"), stringOrEmpty(bundle2, "author_name"), stringOrEmpty(bundle2, "image_url"), stringOrEmpty(bundle2, "app_name"), stringOrEmpty(bundle2, "receiver"), stringOrEmpty(bundle2, "conversation_part_type"), stringOrEmpty(bundle2, "intercom_push_type"), stringOrEmpty(bundle2, "uri"), stringOrEmpty(bundle2, "push_only_conv_id"), stringOrEmpty(bundle2, "title"), bundle2.getInt("intercom_priority_type", 1));
        return autoValue_PushPayload;
    }

    private static String stringOrEmpty(Bundle bundle, String str) {
        return bundle.getString(str, "");
    }

    public abstract String getAppName();

    public abstract String getAuthorName();

    public abstract String getBody();

    public abstract String getConversationId();

    public abstract String getConversationPartType();

    public abstract String getImageUrl();

    public abstract String getIntercomPushType();

    public abstract String getMessage();

    public abstract int getPriority();

    public abstract String getPushOnlyConversationId();

    public abstract String getReceiver();

    public abstract String getTitle();

    public abstract String getUri();

    /* access modifiers changed from: 0000 */
    public boolean isFirstPart() {
        return "message".equals(getConversationPartType());
    }

    /* access modifiers changed from: 0000 */
    public boolean isIntercomPush() {
        if (!getIntercomPushType().isEmpty()) {
            if ("intercom_sdk".equals(getReceiver())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean isPushOnly() {
        return PUSH_ONLY.equals(getIntercomPushType());
    }

    /* access modifiers changed from: 0000 */
    public String messageOrBody() {
        return getMessage().isEmpty() ? getBody() : getMessage();
    }
}
