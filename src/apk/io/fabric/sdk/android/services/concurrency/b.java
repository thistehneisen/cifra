package io.fabric.sdk.android.services.concurrency;

import android.os.Process;

/* compiled from: AsyncTask */
class b extends C0098e<Params, Result> {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ e f9046b;

    b(e eVar) {
        this.f9046b = eVar;
        super(null);
    }

    public Result call() throws Exception {
        this.f9046b.n.set(true);
        Process.setThreadPriority(10);
        e eVar = this.f9046b;
        Result a2 = eVar.a(this.f9069a);
        eVar.d(a2);
        return a2;
    }
}
