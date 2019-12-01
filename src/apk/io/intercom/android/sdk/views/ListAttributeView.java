package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.views.holder.ConversationListener;

public class ListAttributeView extends BaseAttributeView implements AttributeInputListener {
    TextView attributeLabel;

    public ListAttributeView(Context context) {
        this(context, null);
    }

    public void displayEmptyState() {
        this.attributeLabel.setText("");
        this.attributeLabel.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.intercom_list_arrow_down, 0);
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
                    conversationListener.onListAttributeClicked(str, ListAttributeView.this.getAttribute(), ListAttributeView.this);
                }
            });
        }
    }

    public void updateAttributeContent(Attribute attribute) {
        setAttribute(attribute);
        if (attribute.hasValue()) {
            this.attributeLabel.setText(attribute.getValue());
            this.attributeLabel.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.intercom_attribute_verified_tick, 0);
            return;
        }
        displayEmptyState();
    }

    public ListAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attributeLabel = (TextView) findViewById(R.id.attribute_input);
    }
}
