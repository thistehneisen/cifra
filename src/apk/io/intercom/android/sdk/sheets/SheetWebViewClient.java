package io.intercom.android.sdk.sheets;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class SheetWebViewClient extends WebViewClient {
    private final SheetListener sheetListener;

    SheetWebViewClient(SheetListener sheetListener2) {
        this.sheetListener = sheetListener2;
    }

    public void onPageFinished(WebView webView, String str) {
        this.sheetListener.onWebViewFinishedLoad();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme.equals("http") || scheme.equals("https")) {
            webView.loadUrl(str);
            return false;
        }
        webView.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
        return true;
    }

    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
