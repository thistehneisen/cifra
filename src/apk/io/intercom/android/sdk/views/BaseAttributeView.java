package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.attribute.AttributeMetadata;
import io.intercom.android.sdk.models.Attribute;

public abstract class BaseAttributeView extends LinearLayout {
    private Attribute attribute;
    protected final TextView attributeErrorView;
    protected final TextView attributeNameView;
    public final TextView attributePositionLabel;
    private AttributeMetadata metadata;

    public BaseAttributeView(Context context) {
        this(context, null);
    }

    public abstract void displayEmptyState();

    public abstract void displayErrorState(String str);

    public Attribute getAttribute() {
        return this.attribute;
    }

    public abstract int getLayoutRes();

    public AttributeMetadata getMetadata() {
        return this.metadata;
    }

    /* access modifiers changed from: protected */
    public void hideErrorView() {
        this.attributeErrorView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void setAttribute(Attribute attribute2) {
        this.attribute = attribute2;
        String name = attribute2.getName();
        int position = this.metadata.getPosition() + 1;
        if (this.metadata.getTotalCount() > 1) {
            TextView textView = this.attributeNameView;
            StringBuilder sb = new StringBuilder();
            sb.append(position);
            sb.append(". ");
            sb.append(name);
            textView.setText(sb.toString());
            return;
        }
        this.attributeNameView.setText(name);
    }

    /* access modifiers changed from: protected */
    public void setError(String str) {
        this.attributeErrorView.setText(str);
        this.attributeErrorView.setVisibility(0);
    }

    public void setMetadata(AttributeMetadata attributeMetadata) {
        this.metadata = attributeMetadata;
    }

    public void showLabel(int i2) {
        this.attributePositionLabel.setVisibility(0);
        TextView textView = this.attributePositionLabel;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(i2);
        sb.append(" / ");
        sb.append(this.metadata.getTotalCount());
        sb.append(")");
        textView.setText(sb.toString());
    }

    public BaseAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attribute = Attribute.NULL;
        this.metadata = AttributeMetadata.SINGLE_ATTRIBUTE_METADATA;
        LinearLayout.inflate(getContext(), getLayoutRes(), this);
        this.attributeNameView = (TextView) findViewById(R.id.attribute_name);
        this.attributeErrorView = (TextView) findViewById(R.id.error_text);
        this.attributePositionLabel = (TextView) findViewById(R.id.multi_attribute_label);
    }
}
