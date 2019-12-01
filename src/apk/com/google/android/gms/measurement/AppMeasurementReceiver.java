package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import b.k.a.a;
import com.google.android.gms.measurement.internal.Eb;
import com.google.android.gms.measurement.internal.Gb;

public final class AppMeasurementReceiver extends a implements Gb {

    /* renamed from: c reason: collision with root package name */
    private Eb f5492c;

    public final void a(Context context, Intent intent) {
        a.b(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f5492c == null) {
            this.f5492c = new Eb(this);
        }
        this.f5492c.a(context, intent);
    }

    public final PendingResult a() {
        return goAsync();
    }
}
