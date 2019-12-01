package io.intercom.android.sdk.activities;

import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.conversation.ReactionListener;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricTracker.ReactionLocation;
import io.intercom.android.sdk.models.Reaction;

public class ConversationReactionListener implements ReactionListener {
    private final Api api;
    private final String conversationId;
    private final ReactionLocation location;
    private final MetricTracker metricTracker;
    private final String partId;

    public ConversationReactionListener(ReactionLocation reactionLocation, String str, String str2, Api api2, MetricTracker metricTracker2) {
        this.conversationId = str2;
        this.partId = str;
        this.location = reactionLocation;
        this.api = api2;
        this.metricTracker = metricTracker2;
    }

    public void onReactionSelected(Reaction reaction) {
        this.api.reactToConversation(this.conversationId, reaction.getIndex());
        this.metricTracker.sentReaction(this.conversationId, this.partId, reaction.getIndex(), this.location);
    }
}
