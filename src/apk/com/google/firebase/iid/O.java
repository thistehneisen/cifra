package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;

public class O implements Parcelable {
    public static final Creator<O> CREATOR = new N();

    /* renamed from: a reason: collision with root package name */
    private Messenger f6777a;

    /* renamed from: b reason: collision with root package name */
    private Z f6778b;

    public static final class a extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (FirebaseInstanceId.h()) {
                Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            }
            return O.class;
        }
    }

    public O(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f6777a = new Messenger(iBinder);
        } else {
            this.f6778b = new Y(iBinder);
        }
    }

    private final IBinder n() {
        Messenger messenger = this.f6777a;
        return messenger != null ? messenger.getBinder() : this.f6778b.asBinder();
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f6777a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f6778b.a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return n().equals(((O) obj).n());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return n().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.f6777a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f6778b.asBinder());
        }
    }
}
