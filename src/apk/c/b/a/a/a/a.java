package c.b.a.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IGetInstallReferrerService */
public interface a extends IInterface {

    /* renamed from: c.b.a.a.a.a$a reason: collision with other inner class name */
    /* compiled from: IGetInstallReferrerService */
    public static abstract class C0037a extends Binder implements a {

        /* renamed from: c.b.a.a.a.a$a$a reason: collision with other inner class name */
        /* compiled from: IGetInstallReferrerService */
        private static class C0038a implements a {

            /* renamed from: a reason: collision with root package name */
            private IBinder f3041a;

            C0038a(IBinder iBinder) {
                this.f3041a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3041a;
            }

            public Bundle b(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3041a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0038a(iBinder);
            }
            return (a) queryLocalInterface;
        }
    }

    Bundle b(Bundle bundle) throws RemoteException;
}
