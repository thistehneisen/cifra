package io.intercom.android.sdk.blocks.messengercard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.com.google.gson.o;
import java.io.File;

public class MessengerCardWebViewPresenter {
    private final Activity activity;
    private final d bus;
    private final File cache;
    private final String conversationId;
    private final String fallbackUrl;
    private final o gson;
    private final boolean isHomeScreen;
    private final View loadingView;
    private final MetricTracker metricTracker;
    private final int primaryColor;
    private final CardWebView webView;

    public MessengerCardWebViewPresenter(CardWebView cardWebView, View view, String str, d dVar, int i2, o oVar, MetricTracker metricTracker2, File file, String str2, boolean z, Activity activity2) {
        this.webView = cardWebView;
        this.loadingView = view;
        this.fallbackUrl = str;
        this.bus = dVar;
        this.primaryColor = i2;
        this.gson = oVar;
        this.metricTracker = metricTracker2;
        this.conversationId = str2;
        this.cache = file;
        this.isHomeScreen = z;
        this.activity = activity2;
    }

    public static CardWebView createCardWebView(Context context) {
        CardWebView cardWebView;
        try {
            cardWebView = new CardWebView(context);
        } catch (NotFoundException unused) {
            cardWebView = new CardWebView(Injector.get().getApplication());
        }
        cardWebView.setAlpha(0.0f);
        cardWebView.setId(R.id.intercom_messenger_card_webview);
        cardWebView.setLayoutParams(new LayoutParams(-2, -2));
        return cardWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setUpWebView() {
        this.webView.setUp(this.bus);
        this.webView.setBackgroundColor(0);
        this.webView.setWebViewClient(new MessengerCardWebViewClient(Uri.parse(this.fallbackUrl).getHost()));
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(true);
        File file = this.cache;
        if (file != null) {
            settings.setAppCachePath(file.getAbsolutePath());
        }
        settings.setCacheMode(-1);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        MessengerCardWebViewInterface messengerCardWebViewInterface = new MessengerCardWebViewInterface(this.webView, this.loadingView, this.gson, this.primaryColor, this.metricTracker, this.conversationId, this.isHomeScreen, this.activity);
        this.webView.addJavascriptInterface(messengerCardWebViewInterface, "AndroidHost");
    }
}
