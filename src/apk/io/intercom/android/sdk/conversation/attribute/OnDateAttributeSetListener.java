package io.intercom.android.sdk.conversation.attribute;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.holder.ConversationListener;
import java.util.Calendar;
import java.util.TimeZone;

public class OnDateAttributeSetListener implements OnDateSetListener {
    private final AttributeInputListener attributeInputListener;
    private final ConversationListener conversationListener;
    private final String formType;
    private final String identifier;
    private final String partId;

    public OnDateAttributeSetListener(String str, String str2, String str3, ConversationListener conversationListener2, AttributeInputListener attributeInputListener2) {
        this.partId = str;
        this.identifier = str2;
        this.formType = str3;
        this.conversationListener = conversationListener2;
        this.attributeInputListener = attributeInputListener2;
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.clear();
        instance.set(1, i2);
        instance.set(2, i3);
        instance.set(5, i4);
        long timeInMillis = instance.getTimeInMillis();
        this.conversationListener.onSubmitAttribute(this.partId, this.identifier, Long.valueOf(timeInMillis / 1000), this.formType);
        this.attributeInputListener.populateSelectedValue(TimeFormatter.formatTimeInMillisAsDate(timeInMillis));
    }
}
