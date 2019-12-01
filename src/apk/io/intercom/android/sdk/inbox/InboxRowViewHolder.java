package io.intercom.android.sdk.inbox;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.InboxRowLayout;
import io.intercom.com.bumptech.glide.n;

class InboxRowViewHolder extends x implements OnClickListener {
    private final ConversationClickListener conversationClickListener;
    private final InboxRowLayout inboxRowLayout;
    private final n requestManager;
    private final TimeFormatter timeFormatter;

    InboxRowViewHolder(InboxRowLayout inboxRowLayout2, ConversationClickListener conversationClickListener2, TimeFormatter timeFormatter2, n nVar) {
        super(inboxRowLayout2);
        this.conversationClickListener = conversationClickListener2;
        this.timeFormatter = timeFormatter2;
        this.requestManager = nVar;
        inboxRowLayout2.setOnClickListener(this);
        this.inboxRowLayout = inboxRowLayout2;
    }

    /* access modifiers changed from: 0000 */
    public void bindData(Conversation conversation, UserIdentity userIdentity, AppConfig appConfig, TeamPresence teamPresence) {
        this.inboxRowLayout.updateConversation(conversation, userIdentity, appConfig, teamPresence, this.requestManager, this.timeFormatter);
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationClickListener.onConversationClicked(adapterPosition);
        }
    }
}
