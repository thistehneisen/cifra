package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class o<V> extends FutureTask<V> implements h<s>, p, s, g {

    /* renamed from: a reason: collision with root package name */
    final Object f9080a;

    public o(Callable<V> callable) {
        super(callable);
        this.f9080a = a((Object) callable);
    }

    /* renamed from: a */
    public void addDependency(s sVar) {
        ((h) ((p) a())).addDependency(sVar);
    }

    public boolean areDependenciesMet() {
        return ((h) ((p) a())).areDependenciesMet();
    }

    public int compareTo(Object obj) {
        return ((p) a()).compareTo(obj);
    }

    public Collection<s> getDependencies() {
        return ((h) ((p) a())).getDependencies();
    }

    public k getPriority() {
        return ((p) a()).getPriority();
    }

    public boolean isFinished() {
        return ((s) ((p) a())).isFinished();
    }

    public void setError(Throwable th) {
        ((s) ((p) a())).setError(th);
    }

    public void setFinished(boolean z) {
        ((s) ((p) a())).setFinished(z);
    }

    public <T extends h<s> & p & s> T a() {
        return (h) this.f9080a;
    }

    public o(Runnable runnable, V v) {
        super(runnable, v);
        this.f9080a = a((Object) runnable);
    }

    /* access modifiers changed from: protected */
    public <T extends h<s> & p & s> T a(Object obj) {
        if (q.isProperDelegate(obj)) {
            return (h) obj;
        }
        return new q();
    }
}
