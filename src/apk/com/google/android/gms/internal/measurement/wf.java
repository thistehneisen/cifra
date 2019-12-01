package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class wf extends C0322a implements tf {
    public wf() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            onEvent(parcel.readString(), parcel.readString(), (Bundle) Ha.a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else if (i2 != 2) {
            return false;
        } else {
            int e2 = e();
            parcel2.writeNoException();
            parcel2.writeInt(e2);
        }
        return true;
    }
}
