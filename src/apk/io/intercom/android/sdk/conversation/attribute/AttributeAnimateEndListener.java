package io.intercom.android.sdk.conversation.attribute;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import e.a.a.a.a.d;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.events.ConversationEvent.Builder;

public class AttributeAnimateEndListener implements AnimatorListener {
    private final d bus;
    private final Conversation conversation;

    public AttributeAnimateEndListener(Conversation conversation2, d dVar) {
        this.conversation = conversation2;
        this.bus = dVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.bus.post(new Builder(this.conversation).isAttributeUpdated(true).build());
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
