package io.intercom.android.sdk.blocks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.d;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.activities.IntercomArticleActivity;
import io.intercom.android.sdk.activities.IntercomHelpCenterActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.blockInterfaces.LinkListBlock;
import io.intercom.android.sdk.blocks.models.Link;
import io.intercom.android.sdk.blocks.models.LinkList;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.LinkOpener;

class LinkListRenderer implements LinkListBlock {
    /* access modifiers changed from: private */
    public final Api api;
    private final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public final String conversationId;

    LinkListRenderer(Api api2, Provider<AppConfig> provider, String str) {
        this.api = api2;
        this.appConfigProvider = provider;
        this.conversationId = str;
    }

    private void addLinkToLayout(final LinearLayout linearLayout, final Link link, int i2, final Context context, boolean z) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (z) {
            layoutParams.gravity = 17;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(i2);
        textView.setTextSize(16.0f);
        textView.setText(link.getTitle());
        textView.setMaxLines(2);
        textView.setEllipsize(TruncateAt.END);
        textView.setPadding(ScreenUtils.dpToPx(24.0f, context), ScreenUtils.dpToPx(16.0f, context), ScreenUtils.dpToPx(16.0f, context), ScreenUtils.dpToPx(16.0f, context));
        if (io.intercom.android.sdk.models.Link.HELP_CENTER_TYPE.equals(link.getLinkType())) {
            Drawable c2 = a.c(context, R.drawable.intercom_open_help_center);
            c2.setColorFilter(i2, Mode.SRC_IN);
            textView.setCompoundDrawablesWithIntrinsicBounds(c2, null, null, null);
            textView.setCompoundDrawablePadding(ScreenUtils.dpToPx(8.0f, context));
        }
        frameLayout.addView(textView);
        frameLayout.setOnClickListener(new OnClickListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
                if (io.intercom.android.sdk.models.Link.SUGGESTION_TYPE.equals(r7.getLinkType()) != false) goto L_0x0020;
             */
            public void onClick(View view) {
                String str = "link_background";
                if (!io.intercom.android.sdk.models.Link.ARTICLE_TYPE.equals(link.getLinkType())) {
                }
                Context context = context;
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    Intent buildIntent = IntercomArticleActivity.buildIntent(activity, link.getArticleId(), LinkListRenderer.this.conversationId);
                    if (VERSION.SDK_INT >= 16) {
                        activity.startActivity(buildIntent, d.a(activity, (View) linearLayout, str).a());
                        return;
                    } else {
                        activity.startActivity(buildIntent);
                        return;
                    }
                }
                if (io.intercom.android.sdk.models.Link.HELP_CENTER_TYPE.equals(link.getLinkType())) {
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        Activity activity2 = (Activity) context2;
                        Intent buildIntent2 = IntercomHelpCenterActivity.buildIntent(activity2, link.getUrl(), 0, LinkListRenderer.this.conversationId);
                        if (VERSION.SDK_INT >= 16) {
                            activity2.startActivity(buildIntent2, d.a(activity2, (View) linearLayout, str).a());
                            return;
                        } else {
                            activity2.startActivity(buildIntent2);
                            return;
                        }
                    }
                }
                LinkOpener.handleUrl(link.getUrl(), context, LinkListRenderer.this.api);
            }
        });
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843534, typedValue, true);
        frameLayout.setBackgroundResource(typedValue.resourceId);
        linearLayout.addView(frameLayout);
    }

    public View addLinkListBlock(LinkList linkList, boolean z, boolean z2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.intercom_card_list_block, viewGroup, false);
        int primaryOrDarkColor = ColorUtils.primaryOrDarkColor(context, (AppConfig) this.appConfigProvider.get());
        ColorUtils.updateInnerBorderColor((AppConfig) this.appConfigProvider.get(), frameLayout);
        LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.card_links);
        linearLayout.setShowDividers(2);
        linearLayout.setDividerDrawable(new ColorDrawable(a.a(context, R.color.intercom_container_border)));
        linearLayout.setOrientation(1);
        for (Link addLinkToLayout : linkList.getLinks()) {
            addLinkToLayout(linearLayout, addLinkToLayout, primaryOrDarkColor, context, false);
        }
        Link footerLink = linkList.getFooterLink();
        if (!footerLink.getText().isEmpty()) {
            addLinkToLayout(linearLayout, footerLink, primaryOrDarkColor, context, true);
        }
        return frameLayout;
    }
}
