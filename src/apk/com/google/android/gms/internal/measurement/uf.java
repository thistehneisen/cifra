package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class uf extends r implements sf {
    uf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void c(Bundle bundle) throws RemoteException {
        Parcel h2 = h();
        Ha.a(h2, (Parcelable) bundle);
        b(1, h2);
    }
}
