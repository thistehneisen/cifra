package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.FontUtils;

public class IntercomErrorView extends RelativeLayout {
    private Button actionButton;
    private TextView subtitle;
    private TextView titleView;

    public IntercomErrorView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.titleView = (TextView) findViewById(R.id.empty_text_title);
        FontUtils.setRobotoMediumTypeface(this.titleView);
        this.subtitle = (TextView) findViewById(R.id.empty_text_subtitle);
        this.actionButton = (Button) findViewById(R.id.action_button);
    }

    public void setActionButtonClickListener(OnClickListener onClickListener) {
        this.actionButton.setOnClickListener(onClickListener);
    }

    public void setActionButtonText(int i2) {
        this.actionButton.setText(i2);
    }

    public void setActionButtonTextColor(int i2) {
        this.actionButton.setTextColor(i2);
    }

    public void setActionButtonVisibility(int i2) {
        this.actionButton.setVisibility(i2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.subtitle.setText(charSequence);
    }

    public void setTitle(int i2) {
        this.titleView.setText(i2);
    }

    public IntercomErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSubtitle(int i2) {
        this.subtitle.setText(i2);
    }
}
