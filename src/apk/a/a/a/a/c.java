package a.a.a.a;

import a.a.a.a.a.C0000a;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: ResultReceiver */
public class c implements Parcelable {
    public static final Creator<c> CREATOR = new b();

    /* renamed from: a reason: collision with root package name */
    final boolean f272a = false;

    /* renamed from: b reason: collision with root package name */
    final Handler f273b = null;

    /* renamed from: c reason: collision with root package name */
    a f274c;

    /* compiled from: ResultReceiver */
    class a extends C0000a {
        a() {
        }

        public void a(int i2, Bundle bundle) {
            c cVar = c.this;
            Handler handler = cVar.f273b;
            if (handler != null) {
                handler.post(new b(i2, bundle));
            } else {
                cVar.a(i2, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver */
    class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final int f276a;

        /* renamed from: b reason: collision with root package name */
        final Bundle f277b;

        b(int i2, Bundle bundle) {
            this.f276a = i2;
            this.f277b = bundle;
        }

        public void run() {
            c.this.a(this.f276a, this.f277b);
        }
    }

    c(Parcel parcel) {
        this.f274c = C0000a.a(parcel.readStrongBinder());
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f274c == null) {
                this.f274c = new a();
            }
            parcel.writeStrongBinder(this.f274c.asBinder());
        }
    }
}
