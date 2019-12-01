package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.b.a.b.b.c.b;
import c.b.a.b.b.c.c;

/* renamed from: com.google.android.gms.common.internal.k reason: case insensitive filesystem */
public interface C0316k extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.k$a */
    public static abstract class a extends b implements C0316k {

        /* renamed from: com.google.android.gms.common.internal.k$a$a reason: collision with other inner class name */
        public static class C0065a extends c.b.a.b.b.c.a implements C0316k {
            C0065a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public final Account a() throws RemoteException {
                Parcel a2 = a(2, h());
                Account account = (Account) c.a(a2, Account.CREATOR);
                a2.recycle();
                return account;
            }
        }

        public static C0316k a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof C0316k) {
                return (C0316k) queryLocalInterface;
            }
            return new C0065a(iBinder);
        }
    }

    Account a() throws RemoteException;
}
