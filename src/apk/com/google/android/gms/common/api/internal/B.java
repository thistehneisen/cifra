package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0299b.a;
import com.google.android.gms.tasks.h;

abstract class B<T> extends u {

    /* renamed from: b reason: collision with root package name */
    protected final h<T> f4540b;

    public B(int i2, h<T> hVar) {
        super(i2);
        this.f4540b = hVar;
    }

    public void a(Status status) {
        this.f4540b.b((Exception) new ApiException(status));
    }

    /* access modifiers changed from: protected */
    public abstract void d(a<?> aVar) throws RemoteException;

    public void a(RuntimeException runtimeException) {
        this.f4540b.b((Exception) runtimeException);
    }

    public final void a(a<?> aVar) throws DeadObjectException {
        try {
            d(aVar);
        } catch (DeadObjectException e2) {
            a(l.b(e2));
            throw e2;
        } catch (RemoteException e3) {
            a(l.b(e3));
        } catch (RuntimeException e4) {
            a(e4);
        }
    }
}
