package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import c.b.a.b.b.c.a;
import c.b.a.b.b.c.c;
import com.google.android.gms.common.u;

public final class N extends a implements L {
    N(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean a(u uVar, com.google.android.gms.dynamic.a aVar) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (Parcelable) uVar);
        c.a(h2, (IInterface) aVar);
        Parcel a2 = a(5, h2);
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }
}
