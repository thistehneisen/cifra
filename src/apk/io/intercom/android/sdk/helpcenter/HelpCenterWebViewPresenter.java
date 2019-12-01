package io.intercom.android.sdk.helpcenter;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.WebView;
import io.intercom.android.sdk.Intercom.Visibility;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.conversation.JavascriptRunner;
import io.intercom.android.sdk.experimental.Intercom;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.FeatureFlag;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.com.google.gson.o;
import java.util.Collections;
import java.util.Map;

public class HelpCenterWebViewPresenter {
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final AppIdentity appIdentity;
    private final CookieManager cookieManager;
    private final o gson;
    private final Map<String, String> headers = Collections.singletonMap("MobileClient", "AndroidIntercomWebView");
    private final String helpCenterUrl;
    Visibility hostInAppsVisibility;
    Visibility hostLauncherVisibility;
    private final JavascriptRunner jsRunner;
    private final HelpCenterListener listener;
    private final MetricTracker metricTracker;
    private final Store<State> store;
    private final UserIdentity userIdentity;
    private final WebView webView;

    public HelpCenterWebViewPresenter(WebView webView2, JavascriptRunner javascriptRunner, String str, o oVar, MetricTracker metricTracker2, Provider<AppConfig> provider, Store<State> store2, Provider<Api> provider2, UserIdentity userIdentity2, AppIdentity appIdentity2, CookieManager cookieManager2, HelpCenterListener helpCenterListener) {
        this.webView = webView2;
        this.jsRunner = javascriptRunner;
        this.helpCenterUrl = str;
        this.gson = oVar;
        this.metricTracker = metricTracker2;
        this.appConfigProvider = provider;
        this.store = store2;
        this.apiProvider = provider2;
        this.userIdentity = userIdentity2;
        this.appIdentity = appIdentity2;
        this.listener = helpCenterListener;
        this.cookieManager = cookieManager2;
    }

    private void setCookie() {
        StringBuilder sb = new StringBuilder();
        sb.append("intercom-session-");
        sb.append(this.appIdentity.appId());
        String sb2 = sb.toString();
        String encryptedUserId = this.userIdentity.getEncryptedUserId();
        CookieManager cookieManager2 = this.cookieManager;
        String str = this.helpCenterUrl;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("=");
        sb3.append(encryptedUserId);
        cookieManager2.setCookie(str, sb3.toString());
    }

    private boolean shouldForceShowMessengerInHelpCenter() {
        return !((AppConfig) this.appConfigProvider.get()).hasFeature(FeatureFlag.DISABLE_FORCE_SHOW_HELP_CENTER_MESSENGER);
    }

    private void storeHostVisibilitySettings() {
        OverlayState overlayState = (OverlayState) this.store.select(Selectors.OVERLAY);
        this.hostLauncherVisibility = overlayState.launcherVisibility();
        this.hostInAppsVisibility = overlayState.notificationVisibility();
    }

    public void loadBundle() {
        this.jsRunner.reset();
        setCookie();
        this.webView.loadUrl(this.helpCenterUrl, this.headers);
    }

    public void resetMessengerToHostState(Intercom intercom) {
        if (shouldForceShowMessengerInHelpCenter()) {
            intercom.setLauncherVisibility(this.hostLauncherVisibility);
            intercom.setInAppMessageVisibility(this.hostInAppsVisibility);
        }
    }

    public void setUpMessenger(Intercom intercom) {
        if (shouldForceShowMessengerInHelpCenter()) {
            storeHostVisibilitySettings();
            intercom.setLauncherVisibility(io.intercom.android.sdk.Intercom.VISIBLE);
            intercom.setInAppMessageVisibility(io.intercom.android.sdk.Intercom.VISIBLE);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setUpWebView() {
        this.webView.setVerticalScrollBarEnabled(false);
        if (VERSION.SDK_INT >= 21) {
            this.webView.setClipToOutline(true);
        }
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(new HelpCenterWebViewInterface(this.webView, this.gson, this.metricTracker, (Api) this.apiProvider.get()), "AndroidHost");
        this.webView.setWebViewClient(new HelpCenterWebViewClient(Uri.parse(this.helpCenterUrl).getHost(), this.headers, this.listener));
    }
}
