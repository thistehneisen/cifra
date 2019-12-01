package a.a.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IResultReceiver */
public interface a extends IInterface {

    /* renamed from: a.a.a.a.a$a reason: collision with other inner class name */
    /* compiled from: IResultReceiver */
    public static abstract class C0000a extends Binder implements a {

        /* renamed from: a.a.a.a.a$a$a reason: collision with other inner class name */
        /* compiled from: IResultReceiver */
        private static class C0001a implements a {

            /* renamed from: a reason: collision with root package name */
            private IBinder f271a;

            C0001a(IBinder iBinder) {
                this.f271a = iBinder;
            }

            public IBinder asBinder() {
                return this.f271a;
            }
        }

        public C0000a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0001a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = "android.support.v4.os.IResultReceiver";
            if (i2 == 1) {
                parcel.enforceInterface(str);
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    void a(int i2, Bundle bundle) throws RemoteException;
}
