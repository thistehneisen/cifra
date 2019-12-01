package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.ec reason: case insensitive filesystem */
public final class C0352ec extends r implements Gb {
    C0352ec(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle d(Bundle bundle) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) bundle);
        Parcel a2 = a(1, h2);
        Bundle bundle2 = (Bundle) Ha.a(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle2;
    }
}
