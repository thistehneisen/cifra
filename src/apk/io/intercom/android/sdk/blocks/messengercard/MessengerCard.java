package io.intercom.android.sdk.blocks.messengercard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.BlockAlignment;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.blocks.blockInterfaces.MessengerCardBlock;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.google.gson.o;

public class MessengerCard implements MessengerCardBlock {
    private final Activity activity;
    private final Provider<AppConfig> appConfigProvider;
    private final d bus;
    private final String conversationId;
    private final o gson;
    private final MetricTracker metricTracker;
    private final StyleType styleType;

    public MessengerCard(Provider<AppConfig> provider, o oVar, d dVar, MetricTracker metricTracker2, String str, StyleType styleType2, Activity activity2) {
        this.appConfigProvider = provider;
        this.gson = oVar;
        this.bus = dVar;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        this.styleType = styleType2;
        this.activity = activity2;
    }

    private boolean isWithinInAppMessage() {
        return this.styleType.equals(StyleType.NOTE) || this.styleType.equals(StyleType.POST) || this.styleType.equals(StyleType.CONTAINER_CARD) || this.styleType.equals(StyleType.CHAT_FULL);
    }

    private void removeShadowAndMargin(FrameLayout frameLayout) {
        if (isWithinInAppMessage()) {
            if (VERSION.SDK_INT >= 21) {
                frameLayout.setElevation(0.0f);
            }
            try {
                LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
                layoutParams.setMargins(0, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            } catch (ClassCastException unused) {
            }
        }
    }

    private View textFallback(String str, ViewGroup viewGroup) {
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), StyleType.ADMIN, BlockAlignment.LEFT, (AppConfig) this.appConfigProvider.get());
        paragraphView.setText(HtmlCompat.fromHtml(str));
        return paragraphView;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public View addCard(String str, String str2, boolean z, boolean z2, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        if (TextUtils.isEmpty(str2)) {
            return textFallback(str, viewGroup2);
        }
        Context context = viewGroup.getContext();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.intercom_messenger_card_block, viewGroup2, false);
        if (VERSION.SDK_INT >= 16) {
            frameLayout.getLayoutTransition().enableTransitionType(4);
        }
        removeShadowAndMargin(frameLayout);
        ColorUtils.updateInnerBorderColor((AppConfig) this.appConfigProvider.get(), frameLayout);
        ProgressBar progressBar = (ProgressBar) frameLayout.findViewById(R.id.loading_view);
        CardWebView createCardWebView = MessengerCardWebViewPresenter.createCardWebView(context);
        frameLayout.addView(createCardWebView);
        MessengerCardWebViewPresenter messengerCardWebViewPresenter = new MessengerCardWebViewPresenter(createCardWebView, progressBar, str2, this.bus, ((AppConfig) this.appConfigProvider.get()).getPrimaryColor(), this.gson, this.metricTracker, context.getCacheDir(), this.conversationId, false, this.activity);
        messengerCardWebViewPresenter.setUpWebView();
        createCardWebView.loadUrl(str2);
        return frameLayout;
    }
}
