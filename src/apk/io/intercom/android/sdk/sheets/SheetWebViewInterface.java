package io.intercom.android.sdk.sheets;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.helpcenter.HelpCenterWebViewInterface;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.com.google.gson.o;
import java.util.Map;

public class SheetWebViewInterface {
    private static final String CLOSE_SHEET = "close";
    private static final String PAYLOAD_SHEET_TITLE = "title";
    private static final String SHEET_TITLE = "set-title";
    private static final String SUBMIT_SHEET = "submit-sheet";
    private final Api api;
    private final o gson;
    /* access modifiers changed from: private */
    public final SheetListener listener;
    private final MetricTracker metricTracker;
    private final WebView webView;

    SheetWebViewInterface(WebView webView2, o oVar, MetricTracker metricTracker2, Api api2, SheetListener sheetListener) {
        this.webView = webView2;
        this.gson = oVar;
        this.listener = sheetListener;
        this.metricTracker = metricTracker2;
        this.api = api2;
    }

    private boolean isHelpCenterMetric(String str) {
        return HelpCenterWebViewInterface.METRIC_EVENT.equals(str) || HelpCenterWebViewInterface.TRACK_REACTION.equals(str);
    }

    @JavascriptInterface
    public void handleAction(String str) {
        SheetWebViewAction sheetWebViewAction = (SheetWebViewAction) this.gson.a(str, SheetWebViewAction.class);
        String type = sheetWebViewAction.getType();
        final Map payload = sheetWebViewAction.getPayload();
        if (isHelpCenterMetric(type)) {
            new HelpCenterWebViewInterface(this.webView, this.gson, this.metricTracker, this.api).handleAction(str);
            return;
        }
        if (!(type == null || payload == null)) {
            char c2 = 65535;
            int hashCode = type.hashCode();
            if (hashCode != -498753235) {
                if (hashCode != 94756344) {
                    if (hashCode == 227622762 && type.equals(SUBMIT_SHEET)) {
                        c2 = 2;
                    }
                } else if (type.equals(CLOSE_SHEET)) {
                    c2 = 1;
                }
            } else if (type.equals(SHEET_TITLE)) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.webView.post(new Runnable() {
                    public void run() {
                        SheetWebViewInterface.this.listener.onSheetTitleAction(payload.get(SheetWebViewInterface.PAYLOAD_SHEET_TITLE).toString());
                    }
                });
            } else if (c2 == 1) {
                this.webView.post(new Runnable() {
                    public void run() {
                        SheetWebViewInterface.this.listener.onCloseSheetAction();
                    }
                });
            } else if (c2 == 2) {
                this.webView.post(new Runnable() {
                    public void run() {
                        SheetWebViewInterface.this.listener.onSubmitSheetAction(payload);
                    }
                });
            }
        }
    }
}
