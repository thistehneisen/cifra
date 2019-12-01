package io.intercom.okhttp3;

import io.intercom.okhttp3.internal.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher {
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    private void promoteCalls() {
        if (this.runningAsyncCalls.size() < this.maxRequests && !this.readyAsyncCalls.isEmpty()) {
            Iterator it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                AsyncCall asyncCall = (AsyncCall) it.next();
                if (runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningAsyncCalls.add(asyncCall);
                    executorService().execute(asyncCall);
                }
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
            }
        }
    }

    private int runningCallsForHost(AsyncCall asyncCall) {
        int i2 = 0;
        for (AsyncCall asyncCall2 : this.runningAsyncCalls) {
            if (!asyncCall2.get().forWebSocket && asyncCall2.host().equals(asyncCall.host())) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized void cancelAll() {
        for (AsyncCall asyncCall : this.readyAsyncCalls) {
            asyncCall.get().cancel();
        }
        for (AsyncCall asyncCall2 : this.runningAsyncCalls) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.runningSyncCalls) {
            cancel.cancel();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void enqueue(AsyncCall asyncCall) {
        if (this.runningAsyncCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
            this.readyAsyncCalls.add(asyncCall);
        } else {
            this.runningAsyncCalls.add(asyncCall);
            executorService().execute(asyncCall);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void executed(RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            this.executorService = threadPoolExecutor;
        }
        return this.executorService;
    }

    /* access modifiers changed from: 0000 */
    public void finished(AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall, true);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (AsyncCall asyncCall : this.readyAsyncCalls) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        for (AsyncCall asyncCall : this.runningAsyncCalls) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public synchronized void setMaxRequests(int i2) {
        if (i2 >= 1) {
            this.maxRequests = i2;
            promoteCalls();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("max < 1: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public synchronized void setMaxRequestsPerHost(int i2) {
        if (i2 >= 1) {
            this.maxRequestsPerHost = i2;
            promoteCalls();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("max < 1: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void finished(RealCall realCall) {
        finished(this.runningSyncCalls, realCall, false);
    }

    private <T> void finished(Deque<T> deque, T t, boolean z) {
        int runningCallsCount;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    promoteCalls();
                }
                runningCallsCount = runningCallsCount();
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (runningCallsCount == 0 && runnable != null) {
            runnable.run();
        }
    }

    public Dispatcher() {
    }
}
