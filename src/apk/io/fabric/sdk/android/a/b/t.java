package io.fabric.sdk.android.a.b;

import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorUtils */
class t extends j {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ String f8852a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ExecutorService f8853b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ long f8854c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ TimeUnit f8855d;

    t(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
        this.f8852a = str;
        this.f8853b = executorService;
        this.f8854c = j2;
        this.f8855d = timeUnit;
    }

    public void onRun() {
        String str = "Fabric";
        try {
            o e2 = f.e();
            StringBuilder sb = new StringBuilder();
            sb.append("Executing shutdown hook for ");
            sb.append(this.f8852a);
            e2.d(str, sb.toString());
            this.f8853b.shutdown();
            if (!this.f8853b.awaitTermination(this.f8854c, this.f8855d)) {
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f8852a);
                sb2.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                e3.d(str, sb2.toString());
                this.f8853b.shutdownNow();
            }
        } catch (InterruptedException unused) {
            f.e().d(str, String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f8852a}));
            this.f8853b.shutdownNow();
        }
    }
}
