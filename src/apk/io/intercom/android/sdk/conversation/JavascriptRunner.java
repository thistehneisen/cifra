package io.intercom.android.sdk.conversation;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;

public class JavascriptRunner {
    private final Collection<Runnable> actionsAfterLoad;
    private boolean hasLoaded;
    /* access modifiers changed from: private */
    public final WebView webView;

    public JavascriptRunner(WebView webView2) {
        this(webView2, new ArrayList());
    }

    public synchronized void clearPendingScripts() {
        this.actionsAfterLoad.clear();
    }

    public synchronized void reset() {
        this.hasLoaded = false;
        clearPendingScripts();
    }

    public synchronized void run(final String str) {
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                WebView access$000 = JavascriptRunner.this.webView;
                StringBuilder sb = new StringBuilder();
                sb.append("javascript:");
                sb.append(str);
                access$000.loadUrl(sb.toString());
            }
        };
        if (this.hasLoaded) {
            this.webView.post(r0);
        } else {
            this.actionsAfterLoad.add(r0);
        }
    }

    public synchronized void runPendingScripts() {
        this.hasLoaded = true;
        for (Runnable run : this.actionsAfterLoad) {
            run.run();
        }
        clearPendingScripts();
    }

    JavascriptRunner(WebView webView2, Collection<Runnable> collection) {
        this.hasLoaded = false;
        this.webView = webView2;
        this.actionsAfterLoad = collection;
    }
}
