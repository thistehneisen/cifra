package c.b.a.b.b.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a reason: collision with root package name */
    private final IBinder f3048a;

    /* renamed from: b reason: collision with root package name */
    private final String f3049b;

    protected a(IBinder iBinder, String str) {
        this.f3048a = iBinder;
        this.f3049b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f3048a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f3048a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3049b);
        return obtain;
    }
}
