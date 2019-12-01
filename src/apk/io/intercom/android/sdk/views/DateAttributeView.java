package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.holder.ConversationListener;

public class DateAttributeView extends BaseAttributeView implements AttributeInputListener {
    TextView attributeLabel;

    public DateAttributeView(Context context) {
        this(context, null);
    }

    private long convertTimestampToLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void displayEmptyState() {
        this.attributeLabel.setText("");
        this.attributeLabel.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.intercom_attribute_date, 0);
    }

    public void displayErrorState(String str) {
        setError(str);
    }

    public int getLayoutRes() {
        return R.layout.intercom_view_list_attribute;
    }

    public void populateSelectedValue(String str) {
        this.attributeLabel.setText(str);
    }

    public void setOnClickListener(final String str, final ConversationListener conversationListener) {
        if (getAttribute().getValue().isEmpty()) {
            this.attributeLabel.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Attribute attribute = DateAttributeView.this.getAttribute();
                    conversationListener.onDateAttributeClicked(str, attribute.getIdentifier(), attribute.getType(), DateAttributeView.this);
                }
            });
        }
    }

    public void updateAttributeContent(Attribute attribute) {
        setAttribute(attribute);
        this.attributeLabel.setHint(R.string.intercom_choose_the_date);
        if (attribute.hasValue()) {
            long convertTimestampToLong = convertTimestampToLong(attribute.getValue());
            if (convertTimestampToLong > 0) {
                this.attributeLabel.setText(TimeFormatter.formatTimeInMillisAsDate(convertTimestampToLong * 1000));
            } else {
                this.attributeLabel.setText(attribute.getValue());
            }
            this.attributeLabel.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.intercom_attribute_verified_tick, 0);
            return;
        }
        displayEmptyState();
    }

    public DateAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attributeLabel = (TextView) findViewById(R.id.attribute_input);
    }
}
