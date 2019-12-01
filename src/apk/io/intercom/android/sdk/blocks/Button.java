package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.blockInterfaces.ButtonBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.FacebookBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.TwitterBlock;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.views.ButtonSelector;

class Button implements ButtonBlock, FacebookBlock, TwitterBlock {
    private static final int FACEBOOK_LOGO_PADDING_LEFT_DP = 20;
    private static final int TWITTER_LOGO_PADDING_LEFT_DP = 16;
    private final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public final ButtonClickListener buttonClickListener;
    private final StyleType style;

    public Button(StyleType styleType, Provider<AppConfig> provider, ButtonClickListener buttonClickListener2) {
        this.style = styleType;
        this.appConfigProvider = provider;
        this.buttonClickListener = buttonClickListener2;
    }

    private View createButtonWithLogo(Context context, String str, int i2, int i3) {
        FrameLayout frameLayout = new FrameLayout(context);
        BlockUtils.createLayoutParams(frameLayout, -1, ScreenUtils.dpToPx(44.0f, context));
        BlockUtils.setDefaultMarginBottom(frameLayout);
        BackgroundUtils.setBackground(frameLayout, new ButtonSelector(context, R.drawable.intercom_border, ((AppConfig) this.appConfigProvider.get()).getPrimaryColor()));
        ((LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
        ImageView imageView = new ImageView(context);
        BlockUtils.createLayoutParams(imageView, -2, -1);
        imageView.setImageResource(i3);
        imageView.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        imageView.setPadding(i2, 0, 0, 0);
        ((LayoutParams) imageView.getLayoutParams()).gravity = 19;
        TextView textView = new TextView(context);
        BlockUtils.createLayoutParams(textView, -1, -1);
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setTextColor(a.a(context, R.color.intercom_white));
        textView.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        textView.setGravity(17);
        FontUtils.setRobotoMediumTypeface(textView);
        frameLayout.addView(imageView);
        frameLayout.addView(textView);
        return frameLayout;
    }

    private TextView createDefaultTextView(Context context, String str, BlockAlignment blockAlignment) {
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        ParagraphView paragraphView = new ParagraphView(context, this.style, blockAlignment, appConfig);
        paragraphView.setTextColor(appConfig.getPrimaryColor());
        paragraphView.setPaintFlags(paragraphView.getPaintFlags() | 8);
        paragraphView.setGravity(blockAlignment.getGravity());
        paragraphView.setText(str);
        return paragraphView;
    }

    private android.widget.Button createFullWidthButton(Context context, String str) {
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        android.widget.Button button = new android.widget.Button(context);
        button.setTextSize(16.0f);
        button.setTextColor(ColorUtils.whiteOrDarkColor(context, appConfig.primaryColorRenderDarkText()));
        button.setAllCaps(false);
        button.setGravity(17);
        button.setText(str);
        BlockUtils.createLayoutParams(button, -1, -2);
        BlockUtils.setDefaultMarginBottom(button);
        BackgroundUtils.setBackground(button, new ButtonSelector(context, R.drawable.intercom_border, appConfig.getPrimaryColor()));
        FontUtils.setRobotoMediumTypeface(button);
        return button;
    }

    private View setButtonDefaults(View view, final String str, BlockAlignment blockAlignment, boolean z) {
        if (this.buttonClickListener.shouldHandleClicks()) {
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Button.this.buttonClickListener.onButtonClicked(view, str);
                }
            });
        }
        BlockUtils.setLayoutMarginsAndGravity(view, blockAlignment.getGravity(), z);
        return view;
    }

    public View addButton(String str, String str2, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        StyleType styleType = this.style;
        if (styleType == StyleType.NOTE || styleType == StyleType.ARTICLE || styleType == StyleType.POST || styleType == StyleType.CONTAINER_CARD) {
            view = createFullWidthButton(context, str);
        } else {
            view = createDefaultTextView(context, str, blockAlignment);
        }
        setButtonDefaults(view, str2, blockAlignment, z2);
        return view;
    }

    public View addFacebookButton(String str, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        String string = context.getString(R.string.intercom_facebook_like);
        StyleType styleType = this.style;
        if (styleType == StyleType.NOTE || styleType == StyleType.ARTICLE || styleType == StyleType.POST || styleType == StyleType.CONTAINER_CARD) {
            view = createButtonWithLogo(context, string, ScreenUtils.dpToPx(20.0f, context), R.drawable.intercom_icn_fb);
        } else {
            view = createDefaultTextView(context, string, blockAlignment);
        }
        setButtonDefaults(view, str, blockAlignment, z2);
        return view;
    }

    public View addTwitterButton(String str, BlockAlignment blockAlignment, boolean z, boolean z2, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        String string = context.getString(R.string.intercom_twitter_follow);
        StyleType styleType = this.style;
        if (styleType == StyleType.NOTE || styleType == StyleType.ARTICLE || styleType == StyleType.POST || styleType == StyleType.CONTAINER_CARD) {
            view = createButtonWithLogo(context, string, ScreenUtils.dpToPx(16.0f, context), R.drawable.intercom_icn_twitter);
        } else {
            view = createDefaultTextView(context, string, blockAlignment);
        }
        setButtonDefaults(view, str, blockAlignment, z2);
        return view;
    }
}
