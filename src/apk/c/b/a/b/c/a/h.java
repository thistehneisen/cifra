package c.b.a.b.c.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import c.b.a.b.b.b.a;
import c.b.a.b.b.b.c;

public final class h extends a implements g {
    h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(i iVar, e eVar) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, (Parcelable) iVar);
        c.a(h2, (IInterface) eVar);
        a(12, h2);
    }
}
