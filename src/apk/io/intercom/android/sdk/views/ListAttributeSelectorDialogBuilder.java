package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.appcompat.app.C0146m;
import androidx.appcompat.app.C0146m.a;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.views.holder.ConversationListener;
import java.util.List;

public class ListAttributeSelectorDialogBuilder extends a {
    public ListAttributeSelectorDialogBuilder(Context context, String str, Attribute attribute, ConversationListener conversationListener, AttributeInputListener attributeInputListener) {
        super(context);
        setupDialog(attribute, str, conversationListener, attributeInputListener);
    }

    private void setupDialog(Attribute attribute, String str, ConversationListener conversationListener, AttributeInputListener attributeInputListener) {
        final List options = attribute.getOptions();
        final String identifier = attribute.getIdentifier();
        setSingleChoiceItems((CharSequence[]) (String[]) options.toArray(new String[0]), 0, (OnClickListener) null);
        setTitle((CharSequence) attribute.getName());
        final ConversationListener conversationListener2 = conversationListener;
        final String str2 = str;
        final Attribute attribute2 = attribute;
        final AttributeInputListener attributeInputListener2 = attributeInputListener;
        AnonymousClass1 r0 = new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String str = (String) options.get(((C0146m) dialogInterface).b().getCheckedItemPosition());
                conversationListener2.onSubmitAttribute(str2, identifier, str, attribute2.getType());
                attributeInputListener2.populateSelectedValue(str);
            }
        };
        setPositiveButton(17039370, (OnClickListener) r0);
        setNegativeButton(17039360, (OnClickListener) null);
        setCancelable(false);
    }
}
