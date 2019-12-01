package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.views.holder.ConversationListener;

public class BooleanAttributeView extends BaseAttributeView {
    final TextView no;
    final TextView yes;

    public BooleanAttributeView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: private */
    public void showSelectedState(boolean z) {
        ColorStateList b2 = a.b(getContext(), R.color.intercom_boolean_attribute_selected_text_selector);
        ColorStateList b3 = a.b(getContext(), R.color.intercom_boolean_attribute_nonselected_text_selector);
        int a2 = a.a(getContext(), R.color.intercom_attribute_selected_background);
        int a3 = a.a(getContext(), R.color.intercom_white);
        int a4 = a.a(getContext(), R.color.intercom_attribute_input_outline);
        this.yes.setTextColor(z ? b2 : b3);
        TextView textView = this.no;
        if (z) {
            b2 = b3;
        }
        textView.setTextColor(b2);
        float f2 = 1.0f;
        this.yes.setAlpha(z ? 1.0f : 0.5f);
        TextView textView2 = this.no;
        if (z) {
            f2 = 0.5f;
        }
        textView2.setAlpha(f2);
        BackgroundUtils.setRippleButtonBackgroundColor(this.yes.getBackground(), R.id.background, z ? a2 : a3);
        Drawable background = this.no.getBackground();
        int i2 = R.id.background;
        if (z) {
            a2 = a3;
        }
        BackgroundUtils.setRippleButtonBackgroundColor(background, i2, a2);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.yes.getBackground(), R.id.background, a4);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.no.getBackground(), R.id.background, a4);
        this.yes.setEnabled(false);
        this.no.setEnabled(false);
    }

    public void displayEmptyState() {
        ColorStateList b2 = a.b(getContext(), R.color.intercom_boolean_attribute_selected_text_selector);
        this.yes.setTextColor(b2);
        this.no.setTextColor(b2);
        int a2 = a.a(getContext(), R.color.intercom_white);
        int a3 = a.a(getContext(), R.color.intercom_attribute_input_outline);
        BackgroundUtils.setRippleButtonBackgroundColor(this.yes.getBackground(), R.id.background, a2);
        BackgroundUtils.setRippleButtonBackgroundColor(this.no.getBackground(), R.id.background, a2);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.yes.getBackground(), R.id.background, a3);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.no.getBackground(), R.id.background, a3);
        this.yes.setAlpha(1.0f);
        this.no.setAlpha(1.0f);
        this.yes.setEnabled(true);
        this.no.setEnabled(true);
    }

    public void displayErrorState(String str) {
        setError(str);
    }

    public int getLayoutRes() {
        return R.layout.intercom_view_boolean_attribute;
    }

    public void setOnSubmitClickListener(final String str, final ConversationListener conversationListener) {
        this.yes.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BooleanAttributeView.this.showSelectedState(true);
                Attribute attribute = BooleanAttributeView.this.getAttribute();
                conversationListener.onSubmitAttribute(str, attribute.getIdentifier(), Boolean.valueOf(true), attribute.getType());
            }
        });
        this.no.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BooleanAttributeView.this.showSelectedState(false);
                Attribute attribute = BooleanAttributeView.this.getAttribute();
                conversationListener.onSubmitAttribute(str, attribute.getIdentifier(), Boolean.valueOf(false), attribute.getType());
            }
        });
    }

    public void updateAttributeContent(Attribute attribute) {
        setAttribute(attribute);
        if (attribute.hasValue()) {
            showSelectedState(attribute.getValue().equals(Boolean.TRUE.toString()));
        } else {
            displayEmptyState();
        }
    }

    public BooleanAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yes = (TextView) findViewById(R.id.yes);
        this.no = (TextView) findViewById(R.id.no);
    }
}
