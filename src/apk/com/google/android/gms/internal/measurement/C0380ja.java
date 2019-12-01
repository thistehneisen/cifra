package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.measurement.ja reason: case insensitive filesystem */
final class C0380ja extends ContentObserver {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0368ha f5228a;

    C0380ja(C0368ha haVar, Handler handler) {
        this.f5228a = haVar;
        super(null);
    }

    public final void onChange(boolean z) {
        this.f5228a.b();
    }
}
