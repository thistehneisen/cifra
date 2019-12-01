package c.b.a.b.b.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f3042a;

    /* renamed from: b reason: collision with root package name */
    private final String f3043b;

    protected a(IBinder iBinder, String str) {
        this.f3042a = iBinder;
        this.f3043b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f3042a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3042a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3043b);
        return obtain;
    }
}
