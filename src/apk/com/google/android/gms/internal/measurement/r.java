package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class r implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f5345a;

    /* renamed from: b reason: collision with root package name */
    private final String f5346b;

    protected r(IBinder iBinder, String str) {
        this.f5345a = iBinder;
        this.f5346b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f5345a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f5345a;
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f5345a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f5346b);
        return obtain;
    }
}
