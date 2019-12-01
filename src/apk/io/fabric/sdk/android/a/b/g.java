package io.fabric.sdk.android.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import io.fabric.sdk.android.f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: AdvertisingInfoServiceStrategy */
class g implements h {

    /* renamed from: a reason: collision with root package name */
    private final Context f8814a;

    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class a implements ServiceConnection {

        /* renamed from: a reason: collision with root package name */
        private boolean f8815a;

        /* renamed from: b reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f8816b;

        private a() {
            this.f8815a = false;
            this.f8816b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f8815a) {
                f.e().b("Fabric", "getBinder already called");
            }
            this.f8815a = true;
            try {
                return (IBinder) this.f8816b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f8816b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f8816b.clear();
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class b implements IInterface {

        /* renamed from: a reason: collision with root package name */
        private final IBinder f8817a;

        public b(IBinder iBinder) {
            this.f8817a = iBinder;
        }

        public IBinder asBinder() {
            return this.f8817a;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            io.fabric.sdk.android.f.e().d("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0024 */
        public String getId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f8817a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return readString;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            io.fabric.sdk.android.f.e().d("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
        public boolean h() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(1);
            this.f8817a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        }
    }

    public g(Context context) {
        this.f8814a = context.getApplicationContext();
    }

    public C0731b a() {
        String str = "Could not bind to Google Play Service to capture AdvertisingId";
        String str2 = "Fabric";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            f.e().d(str2, "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f8814a.getPackageManager().getPackageInfo("com.android.vending", 0);
            a aVar = new a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f8814a.bindService(intent, aVar, 1)) {
                    try {
                        b bVar = new b(aVar.a());
                        C0731b bVar2 = new C0731b(bVar.getId(), bVar.h());
                        this.f8814a.unbindService(aVar);
                        return bVar2;
                    } catch (Exception e2) {
                        f.e().a(str2, "Exception in binding to Google Play Service to capture AdvertisingId", (Throwable) e2);
                        this.f8814a.unbindService(aVar);
                    }
                } else {
                    f.e().d(str2, str);
                    return null;
                }
            } catch (Throwable th) {
                f.e().c(str2, str, th);
            }
        } catch (NameNotFoundException unused) {
            f.e().d(str2, "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e3) {
            f.e().c(str2, "Unable to determine if Google Play Services is available", e3);
            return null;
        }
    }
}
