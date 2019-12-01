package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.c.b;
import c.b.a.b.b.c.c;
import com.google.android.gms.dynamic.a;

public abstract class J extends b implements I {
    public J() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static I a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof I) {
            return (I) queryLocalInterface;
        }
        return new K(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            a f2 = f();
            parcel2.writeNoException();
            c.a(parcel2, (IInterface) f2);
        } else if (i2 != 2) {
            return false;
        } else {
            int d2 = d();
            parcel2.writeNoException();
            parcel2.writeInt(d2);
        }
        return true;
    }
}
