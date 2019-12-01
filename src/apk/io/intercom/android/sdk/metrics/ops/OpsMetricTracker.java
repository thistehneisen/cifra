package io.intercom.android.sdk.metrics.ops;

import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.metrics.MetricsStore;
import io.intercom.android.sdk.utilities.UuidStringProvider;
import java.util.ArrayList;
import java.util.List;

public class OpsMetricTracker {
    public static final String FINISH = "finish";
    public static final String LOAD_CONVERSATION_TIME_TO_COMPLETE_REQUEST = "time-to-complete-request-load-conversation-ms";
    public static final String LOAD_CONVERSATION_TIME_TO_PROCESS_ACTION = "time-to-process-action-load-conversation-ms";
    public static final String LOAD_CONVERSATION_TIME_TO_RENDER_RESULT = "time-to-render-result-load-conversation-ms";
    public static final String SEND_PART_TIME_TO_COMPLETE_REQUEST = "time-to-complete-request-send-part-ms";
    public static final String SEND_PART_TIME_TO_PROCESS_ACTION = "time-to-process-action-send-part-ms";
    public static final String SEND_PART_TIME_TO_RENDER_RESULT = "time-to-render-result-send-part-ms";
    public static final String START = "start";
    public static final String TIMING_TYPE = "timing";
    final List<OpsEvent> events = new ArrayList();
    private final MetricsStore store;
    private final TimeProvider timeProvider;
    private final UuidStringProvider uuidStringProvider;

    public OpsMetricTracker(MetricsStore metricsStore, TimeProvider timeProvider2, UuidStringProvider uuidStringProvider2) {
        this.store = metricsStore;
        this.timeProvider = timeProvider2;
        this.uuidStringProvider = uuidStringProvider2;
    }

    private OpsEvent findStartEvent(String str) {
        for (int size = this.events.size() - 1; size >= 0; size--) {
            OpsEvent opsEvent = (OpsEvent) this.events.get(size);
            if (START.equals(opsEvent.getEventType()) && str.equals(opsEvent.getName())) {
                return opsEvent;
            }
        }
        return null;
    }

    private void trackOpsEvent(OpsEvent opsEvent) {
        OpsEvent findStartEvent = findStartEvent(opsEvent.getName());
        if (findStartEvent != null) {
            this.events.remove(findStartEvent);
            MetricsStore metricsStore = this.store;
            OpsMetricObject opsMetricObject = new OpsMetricObject(TIMING_TYPE, findStartEvent.getName(), opsEvent.getTimestamp() - findStartEvent.getTimestamp(), this.uuidStringProvider.newUuidString());
            metricsStore.track(opsMetricObject);
        }
    }

    public void clear() {
        this.events.clear();
    }

    public void trackEvent(String str, String str2) {
        OpsEvent opsEvent = new OpsEvent(str, str2, this.timeProvider.currentTimeMillis());
        if (FINISH.equals(str)) {
            trackOpsEvent(opsEvent);
        } else {
            this.events.add(opsEvent);
        }
    }
}
