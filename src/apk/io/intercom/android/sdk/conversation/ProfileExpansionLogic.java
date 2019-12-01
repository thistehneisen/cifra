package io.intercom.android.sdk.conversation;

import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;

class ProfileExpansionLogic {
    ProfileExpansionLogic() {
    }

    private static boolean hasNoUserReplies(Conversation conversation) {
        boolean z = false;
        for (Part part : conversation.getParts()) {
            if (part.isAdmin()) {
                z = true;
            }
            if (z && !part.isAdmin()) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasOnlyUserParts(Conversation conversation) {
        for (Part isAdmin : conversation.getParts()) {
            if (isAdmin.isAdmin()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldExpandProfile(Conversation conversation) {
        return hasOnlyUserParts(conversation) || hasNoUserReplies(conversation);
    }
}
