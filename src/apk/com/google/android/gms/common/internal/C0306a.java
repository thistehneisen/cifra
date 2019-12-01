package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.C0316k.a;

/* renamed from: com.google.android.gms.common.internal.a reason: case insensitive filesystem */
public class C0306a extends a {
    public static Account a(C0316k kVar) {
        if (kVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return kVar.a();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
