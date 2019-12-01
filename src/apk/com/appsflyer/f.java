package com.appsflyer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

final class f {

    static final class b {

        /* renamed from: ˊ reason: contains not printable characters */
        private final String f133;

        /* renamed from: ˋ reason: contains not printable characters */
        private final boolean f134;

        b(String str, boolean z) {
            this.f133 = str;
            this.f134 = z;
        }

        /* renamed from: ˊ reason: contains not printable characters */
        public final String m126() {
            return this.f133;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˏ reason: contains not printable characters */
        public final boolean m127() {
            return this.f134;
        }
    }

    static final class c implements ServiceConnection {

        /* renamed from: ˊ reason: contains not printable characters */
        private final LinkedBlockingQueue<IBinder> f135;

        /* renamed from: ˋ reason: contains not printable characters */
        private boolean f136;

        private c() {
            this.f136 = false;
            this.f135 = new LinkedBlockingQueue<>(1);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f135.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* renamed from: ˊ reason: contains not printable characters */
        public final IBinder m128() throws InterruptedException {
            if (!this.f136) {
                this.f136 = true;
                return (IBinder) this.f135.take();
            }
            throw new IllegalStateException();
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static final class e implements IInterface {

        /* renamed from: ˊ reason: contains not printable characters */
        private IBinder f137;

        e(IBinder iBinder) {
            this.f137 = iBinder;
        }

        public final IBinder asBinder() {
            return this.f137;
        }

        /* renamed from: ˊ reason: contains not printable characters */
        public final String m129() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f137.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ˋ reason: contains not printable characters */
        public final boolean m130() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f137.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    f() {
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static b m125(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                c cVar = new c(0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (context.bindService(intent, cVar, 1)) {
                        e eVar = new e(cVar.m128());
                        b bVar = new b(eVar.m129(), eVar.m130());
                        if (context != null) {
                            context.unbindService(cVar);
                        }
                        return bVar;
                    }
                    if (context != null) {
                        context.unbindService(cVar);
                    }
                    throw new IOException("Google Play connection failed");
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (context != null) {
                        context.unbindService(cVar);
                    }
                    throw th;
                }
            } catch (Exception e3) {
                throw e3;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
