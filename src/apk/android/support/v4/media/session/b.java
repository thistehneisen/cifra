package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMediaSession */
public interface b extends IInterface {

    /* compiled from: IMediaSession */
    public static abstract class a extends Binder implements b {

        /* renamed from: android.support.v4.media.session.b$a$a reason: collision with other inner class name */
        /* compiled from: IMediaSession */
        private static class C0003a implements b {

            /* renamed from: a reason: collision with root package name */
            private IBinder f348a;

            C0003a(IBinder iBinder) {
                this.f348a = iBinder;
            }

            public void a(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f348a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f348a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0003a(iBinder);
            }
            return (b) queryLocalInterface;
        }
    }

    void a(a aVar) throws RemoteException;
}
