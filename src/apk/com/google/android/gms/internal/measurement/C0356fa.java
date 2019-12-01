package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.measurement.fa reason: case insensitive filesystem */
final class C0356fa extends ContentObserver {
    C0356fa(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        C0362ga.f5193e.set(true);
    }
}
