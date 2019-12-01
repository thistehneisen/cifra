package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0299b.a;
import com.google.android.gms.common.util.k;

public abstract class l {

    /* renamed from: a reason: collision with root package name */
    private final int f4613a;

    public l(int i2) {
        this.f4613a = i2;
    }

    /* access modifiers changed from: private */
    public static Status b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (k.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(Status status);

    public abstract void a(a<?> aVar) throws DeadObjectException;

    public abstract void a(i iVar, boolean z);

    public abstract void a(RuntimeException runtimeException);
}
