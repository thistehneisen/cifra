package io.intercom.android.sdk.blocks.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.blocks.models.BlockAttachment;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.utilities.IntentUtils;

@SuppressLint({"ViewConstructor"})
public class AttachmentView extends LinearLayout implements OnClickListener {
    static final int ATTACHMENT_ICON_WIDTH_DP = 20;
    static final int DIVIDER_MARGIN_DP = 6;
    static final int DIVIDER_WIDTH_DP = 1;
    private final String url;

    public AttachmentView(Context context, StyleType styleType, int i2, BlockAttachment blockAttachment) {
        super(context);
        this.url = blockAttachment.getUrl();
        setOrientation(0);
        addView(setupIcon(context, styleType, i2));
        if (isUserMessage(styleType)) {
            addView(setupDivider(context));
        }
        addView(setupName(context, styleType, i2, blockAttachment.getName()));
    }

    private boolean isUserMessage(StyleType styleType) {
        return StyleType.PREVIEW == styleType || StyleType.USER == styleType;
    }

    private View setupDivider(Context context) {
        View view = new View(context);
        int dpToPx = ScreenUtils.dpToPx(1.0f, context);
        int dpToPx2 = ScreenUtils.dpToPx(6.0f, context);
        LayoutParams layoutParams = new LayoutParams(dpToPx, -1);
        layoutParams.setMargins(dpToPx2, 0, dpToPx2, 0);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.color.intercom_white);
        return view;
    }

    private ImageView setupIcon(Context context, StyleType styleType, int i2) {
        ImageView imageView = new ImageView(context);
        LayoutParams layoutParams = new LayoutParams(ScreenUtils.dpToPx(20.0f, context), -2);
        layoutParams.gravity = 19;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.intercom_icn_attachment);
        if (!isUserMessage(styleType)) {
            imageView.setColorFilter(i2);
        }
        return imageView;
    }

    private TextView setupName(Context context, StyleType styleType, int i2, String str) {
        TextView textView = new TextView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 19;
        textView.setLayoutParams(layoutParams);
        textView.setEllipsize(TruncateAt.END);
        textView.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        textView.setGravity(19);
        textView.setTextSize(15.0f);
        textView.setText(str);
        textView.setOnClickListener(this);
        if (isUserMessage(styleType)) {
            textView.setTextColor(a.a(context, R.color.intercom_white));
        } else {
            textView.setTextColor(i2);
        }
        return textView;
    }

    public void onClick(View view) {
        Uri parse = Uri.parse(this.url);
        if (!Uri.EMPTY.equals(parse)) {
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setFlags(268435456);
            IntentUtils.safelyOpenIntent(getContext(), intent);
        }
    }
}
