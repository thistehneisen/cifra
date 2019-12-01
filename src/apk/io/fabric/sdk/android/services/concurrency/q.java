package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
public class q implements h<s>, p, s {
    private final List<s> dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference<Throwable> throwable = new AtomicReference<>(null);

    public static boolean isProperDelegate(Object obj) {
        try {
            h hVar = (h) obj;
            s sVar = (s) obj;
            p pVar = (p) obj;
            if (hVar == null || sVar == null || pVar == null) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean areDependenciesMet() {
        for (s isFinished : getDependencies()) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public int compareTo(Object obj) {
        return k.a(this, obj);
    }

    public synchronized Collection<s> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    public Throwable getError() {
        return (Throwable) this.throwable.get();
    }

    public k getPriority() {
        return k.NORMAL;
    }

    public boolean isFinished() {
        return this.hasRun.get();
    }

    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    public synchronized void addDependency(s sVar) {
        this.dependencies.add(sVar);
    }
}
