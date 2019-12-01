package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import c.b.a.b.b.c.b;

public abstract class M extends b implements L {
    public static L a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof L) {
            return (L) queryLocalInterface;
        }
        return new N(iBinder);
    }
}
