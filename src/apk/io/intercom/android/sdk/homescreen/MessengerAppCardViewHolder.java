package io.intercom.android.sdk.homescreen;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView.x;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.messengercard.CardWebView;
import io.intercom.android.sdk.blocks.messengercard.MessengerCardWebViewPresenter;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.google.gson.o;

public class MessengerAppCardViewHolder extends x {
    private final Activity activity;
    private final Provider<AppConfig> appConfigProvider;
    private final d bus;
    private final o gson;
    private final ProgressBar loadingView;
    private final MetricTracker metricTracker;
    private final CardWebView webView;

    MessengerAppCardViewHolder(View view, d dVar, Provider<AppConfig> provider, o oVar, MetricTracker metricTracker2, Activity activity2) {
        super(view);
        this.webView = MessengerCardWebViewPresenter.createCardWebView(view.getContext());
        ((FrameLayout) view).addView(this.webView);
        CardWebView cardWebView = this.webView;
        cardWebView.setLayoutParams(new LayoutParams(-1, cardWebView.getResources().getDimensionPixelSize(R.dimen.intercom_home_app_card_min_height)));
        this.loadingView = (ProgressBar) view.findViewById(R.id.loading_view);
        this.bus = dVar;
        this.appConfigProvider = provider;
        this.gson = oVar;
        this.metricTracker = metricTracker2;
        this.activity = activity2;
        ColorUtils.updateInnerBorderColor((AppConfig) provider.get(), (FrameLayout) view.findViewById(R.id.messenger_card_layout));
    }

    public void bindCard(String str) {
        String str2 = str;
        MessengerCardWebViewPresenter messengerCardWebViewPresenter = new MessengerCardWebViewPresenter(this.webView, this.loadingView, str2, this.bus, ((AppConfig) this.appConfigProvider.get()).getPrimaryColor(), this.gson, this.metricTracker, this.webView.getContext().getCacheDir(), "", true, this.activity);
        messengerCardWebViewPresenter.setUpWebView();
        if (!TextUtils.isEmpty(str)) {
            this.webView.loadUrl(str);
        }
    }
}
