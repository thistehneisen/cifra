package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class vf extends r implements tf {
    vf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int e() throws RemoteException {
        Parcel a2 = a(2, h());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j2) throws RemoteException {
        Parcel h2 = h();
        h2.writeString(str);
        h2.writeString(str2);
        Ha.a(h2, (Parcelable) bundle);
        h2.writeLong(j2);
        b(1, h2);
    }
}
