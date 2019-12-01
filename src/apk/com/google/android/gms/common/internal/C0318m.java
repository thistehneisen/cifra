package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.c.b;
import c.b.a.b.b.c.c;

/* renamed from: com.google.android.gms.common.internal.m reason: case insensitive filesystem */
public interface C0318m extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.m$a */
    public static abstract class a extends b implements C0318m {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        /* access modifiers changed from: protected */
        public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                b(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                a(parcel.readInt(), parcel.readStrongBinder(), (B) c.a(parcel, B.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, B b2) throws RemoteException;

    void b(int i2, Bundle bundle) throws RemoteException;
}
