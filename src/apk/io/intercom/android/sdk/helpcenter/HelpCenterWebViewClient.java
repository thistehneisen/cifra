package io.intercom.android.sdk.helpcenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

class HelpCenterWebViewClient extends WebViewClient {
    private final Map<String, String> headers;
    private final String helpCenterHost;
    private final HelpCenterListener helpCenterListener;

    HelpCenterWebViewClient(String str, Map<String, String> map, HelpCenterListener helpCenterListener2) {
        this.helpCenterHost = str;
        this.helpCenterListener = helpCenterListener2;
        this.headers = map;
    }

    public void onPageFinished(WebView webView, String str) {
        this.helpCenterListener.onWebViewFinishedLoad();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (TextUtils.isEmpty(this.helpCenterHost) || !this.helpCenterHost.equals(host)) {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
            return true;
        }
        webView.loadUrl(str, this.headers);
        return false;
    }

    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
