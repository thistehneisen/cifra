package io.intercom.android.sdk.blocks.messengercard;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MessengerCardWebViewClient extends WebViewClient {
    private static final int WEBVIEW_FADE_IN_TIME_MS = 150;
    private final String cardHost;

    MessengerCardWebViewClient(String str) {
        this.cardHost = str;
    }

    public void onPageFinished(WebView webView, String str) {
        webView.animate().alpha(1.0f).setStartDelay(150).setDuration(150).start();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (TextUtils.isEmpty(this.cardHost) || !this.cardHost.equals(host)) {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
            return true;
        }
        webView.loadUrl(str);
        return false;
    }

    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
