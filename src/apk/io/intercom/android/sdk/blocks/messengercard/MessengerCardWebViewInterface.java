package io.intercom.android.sdk.blocks.messengercard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.C0146m;
import io.intercom.android.sdk.activities.IntercomSheetActivity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.com.google.gson.o;
import java.util.HashMap;
import java.util.Map;

class MessengerCardWebViewInterface {
    private static final String HEIGHT_CHANGE_EVENT = "HEIGHT_CHANGE_EVENT";
    private static final String INPUT_TEXT = "INPUT_TEXT";
    private static final String METRIC_EVENT = "METRIC_EVENT";
    private static final String OPEN_SHEET = "OPEN_SHEET";
    private static final String OPEN_URL = "OPEN_URL";
    /* access modifiers changed from: private */
    public final Activity activity;
    private final String conversationId;
    private final o gson;
    /* access modifiers changed from: private */
    public final Boolean isHomescreen;
    /* access modifiers changed from: private */
    public final View loadingView;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    private final int primaryColor;
    /* access modifiers changed from: private */
    public final WebView webView;

    MessengerCardWebViewInterface(WebView webView2, View view, o oVar, int i2, MetricTracker metricTracker2, String str, boolean z, Activity activity2) {
        this.webView = webView2;
        this.loadingView = view;
        this.gson = oVar;
        this.primaryColor = i2;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        this.isHomescreen = Boolean.valueOf(z);
        this.activity = activity2;
    }

    /* access modifiers changed from: private */
    public void openSheet(Map<String, Object> map, Context context) {
        String str = (String) map.get("url");
        String str2 = "params";
        Map hashMap = map.containsKey(str2) ? (Map) map.get(str2) : new HashMap();
        String str3 = "uri";
        String obj = hashMap.containsKey(str3) ? hashMap.get(str3).toString() : "";
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(obj)) {
            context.startActivity(IntercomSheetActivity.buildIntent(context, str, hashMap, obj, this.conversationId));
        }
    }

    /* access modifiers changed from: private */
    public void openUrl(Map<String, Object> map, Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) map.get("url"))));
    }

    /* access modifiers changed from: private */
    public void showTextInputDialog(Map<String, Object> map, Context context) {
        C0146m create = new MessengerCardAlertDialogBuilder(context, map, this.primaryColor, this.webView).create();
        create.show();
        create.getWindow().setSoftInputMode(5);
        create.b(-2).setTextColor(this.primaryColor);
        create.b(-1).setTextColor(this.primaryColor);
    }

    @JavascriptInterface
    public void handleAction(String str) {
        final MessengerCardWebViewAction messengerCardWebViewAction = (MessengerCardWebViewAction) this.gson.a(str, MessengerCardWebViewAction.class);
        final Map payload = messengerCardWebViewAction.getPayload();
        String type = messengerCardWebViewAction.getType();
        if (type != null && payload != null) {
            char c2 = 65535;
            switch (type.hashCode()) {
                case 279273946:
                    if (type.equals(OPEN_URL)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 387980611:
                    if (type.equals(HEIGHT_CHANGE_EVENT)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 899662635:
                    if (type.equals("METRIC_EVENT")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1901318306:
                    if (type.equals(INPUT_TEXT)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2092140298:
                    if (type.equals(OPEN_SHEET)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface messengerCardWebViewInterface = MessengerCardWebViewInterface.this;
                        messengerCardWebViewInterface.openUrl(payload, messengerCardWebViewInterface.activity);
                    }
                });
            } else if (c2 == 1) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface messengerCardWebViewInterface = MessengerCardWebViewInterface.this;
                        messengerCardWebViewInterface.openSheet(payload, messengerCardWebViewInterface.activity);
                    }
                });
            } else if (c2 == 2) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface messengerCardWebViewInterface = MessengerCardWebViewInterface.this;
                        messengerCardWebViewInterface.showTextInputDialog(payload, messengerCardWebViewInterface.activity);
                    }
                });
            } else if (c2 != 3) {
                if (c2 == 4) {
                    this.webView.post(new Runnable() {
                        public void run() {
                            Map payload = messengerCardWebViewAction.getPayload();
                            String str = "metadata";
                            MessengerCardWebViewInterface.this.metricTracker.messengerCardWebViewEvent((String) payload.get("action"), (String) payload.get("object"), (String) payload.get("place"), payload.get(str) instanceof Map ? (Map) payload.get(str) : null, MessengerCardWebViewInterface.this.isHomescreen.booleanValue());
                        }
                    });
                }
            } else if (this.loadingView.getVisibility() == 0) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface.this.loadingView.setVisibility(8);
                        MessengerCardWebViewInterface.this.webView.setLayoutParams(new LayoutParams(-1, -2));
                    }
                });
            }
        }
    }
}
