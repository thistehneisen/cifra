package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.measurement.sa reason: case insensitive filesystem */
final class C0433sa extends ContentObserver {
    C0433sa(C0422qa qaVar, Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        C0439ta.b();
    }
}
