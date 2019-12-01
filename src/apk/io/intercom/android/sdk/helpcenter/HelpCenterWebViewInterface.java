package io.intercom.android.sdk.helpcenter;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.com.google.gson.o;
import java.util.Map;

public class HelpCenterWebViewInterface {
    public static final String METRIC_EVENT = "METRIC_EVENT";
    public static final String TRACK_REACTION = "TRACK_REACTION";
    /* access modifiers changed from: private */
    public final Api api;
    private final o gson;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    private final WebView webView;

    public HelpCenterWebViewInterface(WebView webView2, o oVar, MetricTracker metricTracker2, Api api2) {
        this.webView = webView2;
        this.gson = oVar;
        this.metricTracker = metricTracker2;
        this.api = api2;
    }

    @JavascriptInterface
    public void handleAction(String str) {
        HelpCenterWebViewAction helpCenterWebViewAction = (HelpCenterWebViewAction) this.gson.a(str, HelpCenterWebViewAction.class);
        String type = helpCenterWebViewAction.getType();
        final Map value = helpCenterWebViewAction.getValue();
        if (type != null && value != null) {
            char c2 = 65535;
            int hashCode = type.hashCode();
            if (hashCode != 9315005) {
                if (hashCode == 899662635 && type.equals(METRIC_EVENT)) {
                    c2 = 0;
                }
            } else if (type.equals(TRACK_REACTION)) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.webView.post(new Runnable() {
                    public void run() {
                        String str = "metadata";
                        HelpCenterWebViewInterface.this.metricTracker.educateWebviewMetric((String) value.get("action"), (String) value.get("object"), (String) value.get("place"), value.get(str) instanceof Map ? (Map) value.get(str) : null);
                    }
                });
            } else if (c2 == 1) {
                this.webView.post(new Runnable() {
                    public void run() {
                        Double d2 = (Double) value.get("article_id");
                        Double d3 = (Double) value.get("reaction_index");
                        if (d2 != null && d3 != null) {
                            HelpCenterWebViewInterface.this.api.reactToLink(String.valueOf(d2.intValue()), d3.intValue(), true);
                        }
                    }
                });
            }
        }
    }
}
