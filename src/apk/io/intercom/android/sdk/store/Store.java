package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Store<S> {
    S currentState;
    final Middleware<S> dispatcher = new Middleware<S>() {
        public void dispatch(Store<S> store, Action<?> action, NextDispatcher nextDispatcher) {
            synchronized (this) {
                Store.this.currentState = store.reducer.reduce(action, Store.this.currentState);
            }
            for (int i2 = 0; i2 < Store.this.subscribers.size(); i2++) {
                ((Subscriber) store.subscribers.get(i2)).onStateChange(Store.this.currentState);
            }
        }
    };
    private final List<NextDispatcher> next = new ArrayList();
    final Reducer<S> reducer;
    final List<Subscriber<S>> subscribers = new CopyOnWriteArrayList();

    public interface Middleware<S> {
        void dispatch(Store<S> store, Action<?> action, NextDispatcher nextDispatcher);
    }

    public interface NextDispatcher {
        void dispatch(Action<?> action);
    }

    public interface Reducer<S> {
        S reduce(Action<?> action, S s);
    }

    public interface Selector<S, T> {
        T transform(S s);
    }

    public interface Subscriber<T> {
        void onStateChange(T t);
    }

    public interface Subscriber2<T1, T2> {
        void onStateChange(T1 t1, T2 t2);
    }

    public interface Subscription {
        void unsubscribe();
    }

    @SafeVarargs
    public Store(Reducer<S> reducer2, S s, Middleware<S>... middlewareArr) {
        this.reducer = reducer2;
        this.currentState = s;
        this.next.add(new NextDispatcher() {
            public void dispatch(Action<?> action) {
                Store store = Store.this;
                store.dispatcher.dispatch(store, action, null);
            }
        });
        for (int length = middlewareArr.length - 1; length >= 0; length--) {
            final Middleware<S> middleware = middlewareArr[length];
            final NextDispatcher nextDispatcher = (NextDispatcher) this.next.get(0);
            this.next.add(0, new NextDispatcher() {
                public void dispatch(Action<?> action) {
                    middleware.dispatch(Store.this, action, nextDispatcher);
                }
            });
        }
    }

    public S dispatch(Action<?> action) {
        ((NextDispatcher) this.next.get(0)).dispatch(action);
        return state();
    }

    public <T> T select(Selector<S, T> selector) {
        return selector.transform(state());
    }

    public S state() {
        return this.currentState;
    }

    public Subscription subscribe(final Subscriber<S> subscriber) {
        this.subscribers.add(subscriber);
        subscriber.onStateChange(state());
        return new Subscription() {
            public void unsubscribe() {
                Store.this.subscribers.remove(subscriber);
            }
        };
    }

    public <T> Subscription subscribeToChanges(Selector<S, T> selector, Subscriber<T> subscriber) {
        return subscribe(new ChangeSubscriber(selector, subscriber));
    }

    public <T1, T2> Subscription subscribeToChanges(Selector<S, T1> selector, Selector<S, T2> selector2, Subscriber2<T1, T2> subscriber2) {
        return subscribe(new TwoParamChangeSubscriber(selector, selector2, subscriber2));
    }
}
