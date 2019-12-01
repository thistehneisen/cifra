package io.intercom.android.sdk.operator;

import android.os.Handler;
import io.intercom.android.sdk.views.ClientConditionListener;

public class OperatorClientConditionTimer {
    private static final int LONG_DELAY_MILLIS = 10000;
    private static final int SHORT_DELAY_MILLIS = 2000;
    private final String condition;
    private final String conversationId;
    private final Handler handler;
    private final Runnable runnable;

    public OperatorClientConditionTimer(final String str, final String str2, Handler handler2, final ClientConditionListener clientConditionListener) {
        this.conversationId = str;
        this.condition = str2;
        this.handler = handler2;
        this.runnable = new Runnable() {
            public void run() {
                clientConditionListener.conditionSatisfied(str, str2);
            }
        };
    }

    public void beginCountdown() {
        this.handler.postDelayed(this.runnable, 2000);
    }

    public String getCondition() {
        return this.condition;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void interrupt() {
        this.handler.removeCallbacks(this.runnable);
        this.handler.postDelayed(this.runnable, 10000);
    }
}
