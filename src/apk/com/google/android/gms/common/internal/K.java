package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.c.a;
import com.google.android.gms.dynamic.a.C0066a;

public final class K extends a implements I {
    K(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final int d() throws RemoteException {
        Parcel a2 = a(2, h());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    public final com.google.android.gms.dynamic.a f() throws RemoteException {
        Parcel a2 = a(1, h());
        com.google.android.gms.dynamic.a a3 = C0066a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
