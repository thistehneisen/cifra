package e.b.d.g;

import e.b.b.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: DisposeOnCancel */
final class c implements Future<Object> {

    /* renamed from: a reason: collision with root package name */
    final b f8212a;

    c(b bVar) {
        this.f8212a = bVar;
    }

    public boolean cancel(boolean z) {
        this.f8212a.b();
        return false;
    }

    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public Object get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }
}
