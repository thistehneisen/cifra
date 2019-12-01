package io.intercom.android.sdk.store;

import android.os.Handler;
import android.os.Looper;
import io.intercom.android.sdk.store.Store.Selector;
import io.intercom.android.sdk.store.Store.Subscriber;

class ChangeSubscriber<S, T> implements Subscriber<S> {
    private T last;
    private final Handler mainHandler;
    private final Selector<S, T> selector;
    final Subscriber<T> subscriber;

    ChangeSubscriber(Selector<S, T> selector2, Subscriber<T> subscriber2) {
        this(selector2, subscriber2, new Handler(Looper.getMainLooper()));
    }

    static void runOnMainThread(Runnable runnable, Handler handler) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public void onStateChange(S s) {
        final T transform = this.selector.transform(s);
        if (this.last != transform) {
            this.last = transform;
            runOnMainThread(new Runnable() {
                public void run() {
                    ChangeSubscriber.this.subscriber.onStateChange(transform);
                }
            }, this.mainHandler);
        }
    }

    ChangeSubscriber(Selector<S, T> selector2, Subscriber<T> subscriber2, Handler handler) {
        this.last = null;
        this.selector = selector2;
        this.subscriber = subscriber2;
        this.mainHandler = handler;
    }
}
