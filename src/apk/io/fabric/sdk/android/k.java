package io.fabric.sdk.android;

import io.fabric.sdk.android.a.b.F;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.m;

/* compiled from: InitializationTask */
class k<Result> extends m<Void, Void, Result> {
    final l<Result> p;

    public k(l<Result> lVar) {
        this.p = lVar;
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        this.p.onPostExecute(result);
        this.p.initializationCallback.a(result);
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.c();
        F a2 = a("onPreExecute");
        try {
            boolean onPreExecute = this.p.onPreExecute();
            a2.b();
            if (onPreExecute) {
                return;
            }
        } catch (UnmetDependencyException e2) {
            throw e2;
        } catch (Exception e3) {
            f.e().b("Fabric", "Failure onPreExecute()", e3);
            a2.b();
        } catch (Throwable th) {
            a2.b();
            a(true);
            throw th;
        }
        a(true);
    }

    public io.fabric.sdk.android.services.concurrency.k getPriority() {
        return io.fabric.sdk.android.services.concurrency.k.HIGH;
    }

    /* access modifiers changed from: protected */
    public Result a(Void... voidArr) {
        F a2 = a("doInBackground");
        Result doInBackground = !b() ? this.p.doInBackground() : null;
        a2.b();
        return doInBackground;
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
        this.p.onCancelled(result);
        StringBuilder sb = new StringBuilder();
        sb.append(this.p.getIdentifier());
        sb.append(" Initialization was cancelled");
        this.p.initializationCallback.a((Exception) new InitializationException(sb.toString()));
    }

    private F a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.p.getIdentifier());
        sb.append(".");
        sb.append(str);
        F f2 = new F(sb.toString(), "KitInitialization");
        f2.a();
        return f2;
    }
}
