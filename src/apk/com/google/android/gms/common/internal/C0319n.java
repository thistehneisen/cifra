package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.common.internal.n reason: case insensitive filesystem */
final class C0319n implements C0320o {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f4755a;

    C0319n(IBinder iBinder) {
        this.f4755a = iBinder;
    }

    public final void a(C0318m mVar, C0311f fVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
            if (fVar != null) {
                obtain.writeInt(1);
                fVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4755a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f4755a;
    }
}
