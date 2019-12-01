package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.c.a;
import c.b.a.b.b.c.c;
import com.google.android.gms.dynamic.a.C0066a;

public final class l extends a implements k {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final com.google.android.gms.dynamic.a a(com.google.android.gms.dynamic.a aVar, String str, int i2, com.google.android.gms.dynamic.a aVar2) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (IInterface) aVar);
        h2.writeString(str);
        h2.writeInt(i2);
        c.a(h2, (IInterface) aVar2);
        Parcel a2 = a(2, h2);
        com.google.android.gms.dynamic.a a3 = C0066a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final com.google.android.gms.dynamic.a b(com.google.android.gms.dynamic.a aVar, String str, int i2, com.google.android.gms.dynamic.a aVar2) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (IInterface) aVar);
        h2.writeString(str);
        h2.writeInt(i2);
        c.a(h2, (IInterface) aVar2);
        Parcel a2 = a(3, h2);
        com.google.android.gms.dynamic.a a3 = C0066a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
