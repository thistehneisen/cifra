package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.e.d;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
public abstract class m<Params, Progress, Result> extends e<Params, Progress, Result> implements h<s>, p, s, g {
    private final q o = new q();

    /* compiled from: PriorityAsyncTask */
    private static class a<Result> implements Executor {

        /* renamed from: a reason: collision with root package name */
        private final Executor f9078a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final m f9079b;

        public a(Executor executor, m mVar) {
            this.f9078a = executor;
            this.f9079b = mVar;
        }

        public void execute(Runnable runnable) {
            this.f9078a.execute(new l(this, runnable, null));
        }
    }

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a((Executor) new a(executorService, this), paramsArr);
    }

    public boolean areDependenciesMet() {
        return ((h) ((p) d())).areDependenciesMet();
    }

    public int compareTo(Object obj) {
        return k.a(this, obj);
    }

    public <T extends h<s> & p & s> T d() {
        return this.o;
    }

    public Collection<s> getDependencies() {
        return ((h) ((p) d())).getDependencies();
    }

    public boolean isFinished() {
        return ((s) ((p) d())).isFinished();
    }

    public void setError(Throwable th) {
        ((s) ((p) d())).setError(th);
    }

    public void setFinished(boolean z) {
        ((s) ((p) d())).setFinished(z);
    }

    /* renamed from: a */
    public void addDependency(s sVar) {
        if (a() == d.PENDING) {
            ((h) ((p) d())).addDependency(sVar);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }
}
