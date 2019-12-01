package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.AttachmentListBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.LocalAttachmentBlock;
import io.intercom.android.sdk.blocks.models.BlockAttachment;
import io.intercom.android.sdk.blocks.views.AttachmentView;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.views.ProgressLinearLayout;
import io.intercom.android.sdk.views.UploadProgressBar;
import java.util.List;

class Attachment implements AttachmentListBlock, LocalAttachmentBlock {
    private static final int ATTACHMENT_LINE_SPACING_DP = 12;
    private static final int DIVIDER_MARGIN_DP = 6;
    private static final int DIVIDER_WIDTH_DP = 1;
    private static final int LOCAL_ICON_SIZE_DP = 20;
    private final Provider<AppConfig> appConfigProvider;
    private final StyleType style;

    public Attachment(StyleType styleType, Provider<AppConfig> provider) {
        this.style = styleType;
        this.appConfigProvider = provider;
    }

    private ImageView getAttachmentIcon(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        imageView.setVisibility(8);
        imageView.setImageResource(R.drawable.intercom_icn_attachment);
        return imageView;
    }

    private LinearLayout getAttachmentListView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        BlockUtils.createLayoutParams(linearLayout, -2, -2);
        BlockUtils.setDefaultMarginBottom(linearLayout);
        return linearLayout;
    }

    private View getDivider(Context context) {
        int dpToPx = ScreenUtils.dpToPx(6.0f, context);
        int dpToPx2 = ScreenUtils.dpToPx(1.0f, context);
        View view = new View(context);
        view.setBackgroundResource(R.color.intercom_white);
        BlockUtils.createLayoutParams(view, dpToPx2, -1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = dpToPx;
        layoutParams.rightMargin = dpToPx;
        return view;
    }

    private FrameLayout getIconHolder(Context context) {
        int dpToPx = ScreenUtils.dpToPx(20.0f, context);
        FrameLayout frameLayout = new FrameLayout(context);
        BlockUtils.createLayoutParams(frameLayout, dpToPx, dpToPx);
        ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 19;
        return frameLayout;
    }

    private ProgressLinearLayout getLocalAttachmentView(Context context) {
        ProgressLinearLayout progressLinearLayout = new ProgressLinearLayout(context);
        BlockUtils.createLayoutParams(progressLinearLayout, -2, -2);
        BlockUtils.setDefaultMarginBottom(progressLinearLayout);
        progressLinearLayout.setOrientation(0);
        return progressLinearLayout;
    }

    private TextView getTextView(String str, Context context) {
        TextView textView = new TextView(context);
        BlockUtils.createLayoutParams(textView, -2, -2);
        BlockUtils.setSmallLineSpacing(textView);
        textView.setGravity(19);
        textView.setEllipsize(TruncateAt.END);
        textView.setTextSize(15.0f);
        textView.setTextColor(a.a(context, R.color.intercom_white));
        textView.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        textView.setText(str);
        return textView;
    }

    private UploadProgressBar getUploadProgressBar(Context context) {
        UploadProgressBar uploadProgressBar = new UploadProgressBar(context);
        uploadProgressBar.setLayoutParams(new LayoutParams(-1, -1));
        return uploadProgressBar;
    }

    public View addAttachment(BlockAttachment blockAttachment, boolean z, boolean z2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        ProgressLinearLayout localAttachmentView = getLocalAttachmentView(context);
        FrameLayout iconHolder = getIconHolder(context);
        ImageView attachmentIcon = getAttachmentIcon(context);
        UploadProgressBar uploadProgressBar = getUploadProgressBar(context);
        View divider = getDivider(context);
        TextView textView = getTextView(blockAttachment.getName(), context);
        iconHolder.addView(uploadProgressBar);
        iconHolder.addView(attachmentIcon);
        localAttachmentView.setUploadProgressBar(uploadProgressBar);
        localAttachmentView.setAttachmentIcon(attachmentIcon);
        localAttachmentView.addView(iconHolder);
        localAttachmentView.addView(divider);
        localAttachmentView.addView(textView);
        BlockUtils.setLayoutMarginsAndGravity(localAttachmentView, 3, z2);
        return localAttachmentView;
    }

    public View addAttachmentList(List<BlockAttachment> list, boolean z, boolean z2, ViewGroup viewGroup) {
        int primaryColor = ((AppConfig) this.appConfigProvider.get()).getPrimaryColor();
        Context context = viewGroup.getContext();
        LinearLayout attachmentListView = getAttachmentListView(context);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            AttachmentView attachmentView = new AttachmentView(context, this.style, primaryColor, (BlockAttachment) list.get(i2));
            if (i2 < size - 1) {
                attachmentView.setPadding(attachmentView.getPaddingLeft(), attachmentView.getPaddingTop(), attachmentView.getPaddingRight(), ScreenUtils.dpToPx(12.0f, context));
            }
            attachmentListView.addView(attachmentView);
        }
        BlockUtils.setLayoutMarginsAndGravity(attachmentListView, 3, z2);
        return attachmentListView;
    }
}
