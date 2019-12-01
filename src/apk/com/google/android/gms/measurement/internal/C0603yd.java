package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* renamed from: com.google.android.gms.measurement.internal.yd reason: case insensitive filesystem */
final /* synthetic */ class C0603yd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final C0593wd f6172a;

    /* renamed from: b reason: collision with root package name */
    private final C0532kb f6173b;

    /* renamed from: c reason: collision with root package name */
    private final JobParameters f6174c;

    C0603yd(C0593wd wdVar, C0532kb kbVar, JobParameters jobParameters) {
        this.f6172a = wdVar;
        this.f6173b = kbVar;
        this.f6174c = jobParameters;
    }

    public final void run() {
        this.f6172a.a(this.f6173b, this.f6174c);
    }
}
