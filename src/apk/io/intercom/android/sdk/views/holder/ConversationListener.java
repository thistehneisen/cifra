package io.intercom.android.sdk.views.holder;

import android.view.View;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReplyOption;

public interface ConversationListener {
    String getConversationId();

    int getCount();

    Part getPart(int i2);

    Part getSelectedPart();

    void onContainerCardClicked(int i2, ContainerCardViewHolder containerCardViewHolder);

    void onDateAttributeClicked(String str, String str2, String str3, AttributeInputListener attributeInputListener);

    void onLinkClicked(int i2, View view);

    void onListAttributeClicked(String str, Attribute attribute, AttributeInputListener attributeInputListener);

    void onPartClicked(int i2, PartViewHolder partViewHolder);

    void onQuickReplyClicked(Participant participant, Part part, ReplyOption replyOption);

    void onSubmitAttribute(String str, String str2, Object obj, String str3);
}
