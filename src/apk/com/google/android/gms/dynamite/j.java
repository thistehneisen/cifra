package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.c.a;
import c.b.a.b.b.c.c;
import com.google.android.gms.dynamic.a.C0066a;

public final class j extends a implements i {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final com.google.android.gms.dynamic.a a(com.google.android.gms.dynamic.a aVar, String str, int i2) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (IInterface) aVar);
        h2.writeString(str);
        h2.writeInt(i2);
        Parcel a2 = a(2, h2);
        com.google.android.gms.dynamic.a a3 = C0066a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final int b(com.google.android.gms.dynamic.a aVar, String str, boolean z) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (IInterface) aVar);
        h2.writeString(str);
        c.a(h2, z);
        Parcel a2 = a(3, h2);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    public final int g() throws RemoteException {
        Parcel a2 = a(6, h());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    public final int a(com.google.android.gms.dynamic.a aVar, String str, boolean z) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (IInterface) aVar);
        h2.writeString(str);
        c.a(h2, z);
        Parcel a2 = a(5, h2);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    public final com.google.android.gms.dynamic.a b(com.google.android.gms.dynamic.a aVar, String str, int i2) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (IInterface) aVar);
        h2.writeString(str);
        h2.writeInt(i2);
        Parcel a2 = a(4, h2);
        com.google.android.gms.dynamic.a a3 = C0066a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
