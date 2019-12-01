package io.fabric.sdk.android.a.b;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
public class F {

    /* renamed from: a reason: collision with root package name */
    private final String f8802a;

    /* renamed from: b reason: collision with root package name */
    private final String f8803b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f8804c;

    /* renamed from: d reason: collision with root package name */
    private long f8805d;

    /* renamed from: e reason: collision with root package name */
    private long f8806e;

    public F(String str, String str2) {
        this.f8802a = str;
        this.f8803b = str2;
        this.f8804c = !Log.isLoggable(str2, 2);
    }

    private void c() {
        String str = this.f8803b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8802a);
        sb.append(": ");
        sb.append(this.f8806e);
        sb.append("ms");
        Log.v(str, sb.toString());
    }

    public synchronized void a() {
        if (!this.f8804c) {
            this.f8805d = SystemClock.elapsedRealtime();
            this.f8806e = 0;
        }
    }

    public synchronized void b() {
        if (!this.f8804c) {
            if (this.f8806e == 0) {
                this.f8806e = SystemClock.elapsedRealtime() - this.f8805d;
                c();
            }
        }
    }
}
