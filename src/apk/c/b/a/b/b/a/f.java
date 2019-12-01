package c.b.a.b.b.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class f extends a implements d {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final boolean c(boolean z) throws RemoteException {
        Parcel h2 = h();
        c.a(h2, true);
        Parcel a2 = a(2, h2);
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }

    public final boolean d() throws RemoteException {
        Parcel a2 = a(6, h());
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }

    public final String getId() throws RemoteException {
        Parcel a2 = a(1, h());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }
}
