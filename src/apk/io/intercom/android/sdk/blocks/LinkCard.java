package io.intercom.android.sdk.blocks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.d;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.activities.IntercomArticleActivity;
import io.intercom.android.sdk.blocks.blockInterfaces.LinkBlock;
import io.intercom.android.sdk.blocks.models.Link;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.bumptech.glide.n;

class LinkCard implements LinkBlock {
    private final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public final String conversationId;
    private final n requestManager;
    private final StyleType style;

    LinkCard(StyleType styleType, Provider<AppConfig> provider, String str, n nVar) {
        this.style = styleType;
        this.appConfigProvider = provider;
        this.conversationId = str;
        this.requestManager = nVar;
    }

    @SuppressLint({"SetTextI18n"})
    private void addAuthorDetails(Link link, ImageView imageView, TextView textView, String str) {
        imageView.setVisibility(0);
        textView.setVisibility(0);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        StringBuilder sb = new StringBuilder();
        sb.append("Written by ");
        sb.append(spannableString);
        textView.setText(sb.toString());
        AvatarUtils.createAvatar(Avatar.create(link.getAuthor().getAvatar(), ""), imageView, imageView.getResources().getDimensionPixelSize(R.dimen.intercom_avatar_size), (AppConfig) this.appConfigProvider.get(), this.requestManager);
    }

    private View createLinkBlock(final Link link, ViewGroup viewGroup, boolean z, boolean z2) {
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        final Context context = viewGroup.getContext();
        final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.intercom_link_block, viewGroup, false);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        ColorUtils.setTextColorPrimaryOrDark(textView, appConfig);
        textView.setText(link.getTitle());
        setUpDescription(link, (TextView) linearLayout.findViewById(R.id.description));
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.avatar);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.author);
        String firstName = link.getAuthor().getFirstName();
        if (TextUtils.isEmpty(firstName)) {
            imageView.setVisibility(8);
            textView2.setVisibility(8);
        } else {
            addAuthorDetails(link, imageView, textView2, firstName);
        }
        if (!z) {
            if (io.intercom.android.sdk.models.Link.ARTICLE_TYPE.equals(link.getLinkType())) {
                linearLayout.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        Context context = context;
                        if (context instanceof Activity) {
                            Activity activity = (Activity) context;
                            Intent buildIntent = IntercomArticleActivity.buildIntent(activity, link.getArticleId(), LinkCard.this.conversationId);
                            if (VERSION.SDK_INT >= 16) {
                                activity.startActivity(buildIntent, d.a(activity, (View) linearLayout, "link_background").a());
                            } else {
                                activity.startActivity(buildIntent);
                            }
                        }
                    }
                });
            }
            BackgroundUtils.setBackground(linearLayout, a.c(context, R.drawable.intercom_conversation_card_background));
            BlockUtils.setMarginBottom(linearLayout, 8);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.intercom_link_padding);
            linearLayout.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            BlockUtils.setLayoutMarginsAndGravity(linearLayout, 3, z2);
        }
        return linearLayout;
    }

    private boolean isOnlyBlock(boolean z, boolean z2) {
        return z && z2;
    }

    private void setUpDescription(Link link, TextView textView) {
        String description = link.getDescription();
        if (TextUtils.isEmpty(description)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(description);
    }

    private boolean shouldDisplayLink() {
        return StyleType.ADMIN.equals(this.style) || StyleType.CHAT_FULL.equals(this.style);
    }

    public View addLinkBlock(Link link, boolean z, boolean z2, ViewGroup viewGroup) {
        boolean isOnlyBlock = isOnlyBlock(z, z2);
        if (shouldDisplayLink()) {
            return createLinkBlock(link, viewGroup, isOnlyBlock, z2);
        }
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), StyleType.ADMIN, BlockAlignment.LEFT, (AppConfig) this.appConfigProvider.get());
        paragraphView.setText(HtmlCompat.fromHtml(link.getText()));
        return paragraphView;
    }
}
