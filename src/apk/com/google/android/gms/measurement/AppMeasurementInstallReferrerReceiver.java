package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.Eb;
import com.google.android.gms.measurement.internal.Gb;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements Gb {

    /* renamed from: a reason: collision with root package name */
    private Eb f5490a;

    public final PendingResult a() {
        return goAsync();
    }

    public final void a(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f5490a == null) {
            this.f5490a = new Eb(this);
        }
        this.f5490a.a(context, intent);
    }
}
