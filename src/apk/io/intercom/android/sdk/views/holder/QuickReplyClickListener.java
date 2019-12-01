package io.intercom.android.sdk.views.holder;

import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReplyOption;

public interface QuickReplyClickListener {
    void onQuickReplyClicked(Participant participant, Part part, ReplyOption replyOption);
}
