package com.intercom.input.gallery;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmptyView extends LinearLayout {
    private Button actionButton;
    private String actionButtonText;
    private int internalPaddingBottom;
    private int internalPaddingLeft;
    private int internalPaddingRight;
    private int internalPaddingTop;
    private TextView subtitle;
    private String subtitleText;
    private TextView title;
    private String titleText;

    public EmptyView(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.title = (TextView) findViewById(R.id.empty_text_title);
        this.subtitle = (TextView) findViewById(R.id.empty_text_subtitle);
        this.actionButton = (Button) findViewById(R.id.empty_action_button);
        this.title.setText(this.titleText);
        this.subtitle.setText(this.subtitleText);
        if (!TextUtils.isEmpty(this.actionButtonText)) {
            this.actionButton.setText(this.actionButtonText);
        } else {
            this.actionButton.setVisibility(8);
        }
        ((LinearLayout) findViewById(R.id.empty_view_layout)).setPadding(this.internalPaddingLeft, this.internalPaddingTop, this.internalPaddingRight, this.internalPaddingBottom);
    }

    public void setActionButtonClickListener(OnClickListener onClickListener) {
        this.actionButton.setOnClickListener(onClickListener);
    }

    public void setActionButtonVisibility(int i2) {
        this.actionButton.setVisibility(i2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.subtitle.setText(charSequence);
    }

    public void setThemeColor(int i2) {
        this.actionButton.setBackgroundColor(i2);
    }

    public void setTitle(CharSequence charSequence) {
        this.title.setText(charSequence);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|4|5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0054, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0068, code lost:
        r5.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0056 */
    public EmptyView(Context context, AttributeSet attributeSet) {
        String str = "";
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.intercom_composer_empty_view, this, true);
        setBackgroundResource(R.color.intercom_composer_white);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.intercom_composer_empty_view, 0, 0);
        this.titleText = obtainStyledAttributes.getString(R.styleable.intercom_composer_empty_view_intercom_composer_titleText);
        this.subtitleText = obtainStyledAttributes.getString(R.styleable.intercom_composer_empty_view_intercom_composer_subtitleText);
        this.actionButtonText = obtainStyledAttributes.getString(R.styleable.intercom_composer_empty_view_intercom_composer_actionButtonText);
        this.internalPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingTop, 0);
        this.internalPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingBottom, 0);
        this.internalPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingLeft, 0);
        this.internalPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingRight, 0);
        this.titleText = str;
        this.subtitleText = str;
        this.actionButtonText = str;
        this.internalPaddingTop = 0;
        this.internalPaddingBottom = 0;
        this.internalPaddingLeft = 0;
        this.internalPaddingRight = 0;
        obtainStyledAttributes.recycle();
    }

    public void setSubtitle(int i2) {
        this.subtitle.setText(i2);
    }

    public void setTitle(int i2) {
        this.title.setText(i2);
    }
}
