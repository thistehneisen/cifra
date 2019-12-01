package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.measurement.hb reason: case insensitive filesystem */
public abstract class C0369hb extends C0322a implements Gb {
    public static Gb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        if (queryLocalInterface instanceof Gb) {
            return (Gb) queryLocalInterface;
        }
        return new C0352ec(iBinder);
    }
}
