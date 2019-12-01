package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.C0307b;
import com.google.android.gms.common.internal.C0307b.C0064b;
import com.google.android.gms.common.internal.C0307b.a;

/* renamed from: com.google.android.gms.measurement.internal.hb reason: case insensitive filesystem */
public final class C0517hb extends C0307b<C0487bb> {
    public C0517hb(Context context, Looper looper, a aVar, C0064b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof C0487bb) {
            return (C0487bb) queryLocalInterface;
        }
        return new C0497db(iBinder);
    }

    public final int e() {
        return g.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String s() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    /* access modifiers changed from: protected */
    public final String t() {
        return "com.google.android.gms.measurement.START";
    }
}
