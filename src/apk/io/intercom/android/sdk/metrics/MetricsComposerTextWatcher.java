package io.intercom.android.sdk.metrics;

import android.text.Editable;
import android.text.TextUtils;
import io.intercom.android.sdk.utilities.SimpleTextWatcher;

public class MetricsComposerTextWatcher extends SimpleTextWatcher {
    private String conversationId;
    private boolean hasTrackedEvent;
    private final MetricTracker metricTracker;

    public MetricsComposerTextWatcher(MetricTracker metricTracker2) {
        this.metricTracker = metricTracker2;
    }

    public void afterTextChanged(Editable editable) {
        if (!this.hasTrackedEvent && editable.length() != 0) {
            if (TextUtils.isEmpty(this.conversationId)) {
                this.metricTracker.typeInNewConversation();
            } else {
                this.metricTracker.typeInConversation(this.conversationId);
            }
            this.hasTrackedEvent = true;
        }
    }

    public void reset() {
        this.hasTrackedEvent = false;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }
}
