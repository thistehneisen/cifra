package io.intercom.android.sdk.store;

import android.os.Handler;
import android.os.Looper;
import io.intercom.android.sdk.store.Store.Selector;
import io.intercom.android.sdk.store.Store.Subscriber;
import io.intercom.android.sdk.store.Store.Subscriber2;

class TwoParamChangeSubscriber<S, T1, T2> implements Subscriber<S> {
    private T1 last1;
    private T2 last2;
    private final Handler mainHandler;
    private final Selector<S, T1> selector1;
    private final Selector<S, T2> selector2;
    final Subscriber2<T1, T2> subscriber;

    TwoParamChangeSubscriber(Selector<S, T1> selector, Selector<S, T2> selector3, Subscriber2<T1, T2> subscriber2) {
        this(selector, selector3, subscriber2, new Handler(Looper.getMainLooper()));
    }

    public void onStateChange(S s) {
        final T1 transform = this.selector1.transform(s);
        final T2 transform2 = this.selector2.transform(s);
        if (this.last1 != transform || this.last2 != transform2) {
            this.last1 = transform;
            this.last2 = transform2;
            ChangeSubscriber.runOnMainThread(new Runnable() {
                public void run() {
                    TwoParamChangeSubscriber.this.subscriber.onStateChange(transform, transform2);
                }
            }, this.mainHandler);
        }
    }

    TwoParamChangeSubscriber(Selector<S, T1> selector, Selector<S, T2> selector3, Subscriber2<T1, T2> subscriber2, Handler handler) {
        this.last1 = null;
        this.last2 = null;
        this.selector1 = selector;
        this.selector2 = selector3;
        this.subscriber = subscriber2;
        this.mainHandler = handler;
    }
}
