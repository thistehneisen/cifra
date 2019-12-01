package io.fabric.sdk.android.services.concurrency;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: AsyncTask */
class c extends FutureTask<Result> {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ e f9047a;

    c(e eVar, Callable callable) {
        this.f9047a = eVar;
        super(callable);
    }

    /* access modifiers changed from: protected */
    public void done() {
        try {
            this.f9047a.e(get());
        } catch (InterruptedException e2) {
            Log.w("AsyncTask", e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
        } catch (CancellationException unused) {
            this.f9047a.e(null);
        }
    }
}
