package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.lifecycle.h.b;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: FragmentState */
final class D implements Parcelable {
    public static final Creator<D> CREATOR = new C();

    /* renamed from: a reason: collision with root package name */
    final String f1393a;

    /* renamed from: b reason: collision with root package name */
    final String f1394b;

    /* renamed from: c reason: collision with root package name */
    final boolean f1395c;

    /* renamed from: d reason: collision with root package name */
    final int f1396d;

    /* renamed from: e reason: collision with root package name */
    final int f1397e;

    /* renamed from: f reason: collision with root package name */
    final String f1398f;

    /* renamed from: g reason: collision with root package name */
    final boolean f1399g;

    /* renamed from: h reason: collision with root package name */
    final boolean f1400h;

    /* renamed from: i reason: collision with root package name */
    final boolean f1401i;

    /* renamed from: j reason: collision with root package name */
    final Bundle f1402j;

    /* renamed from: k reason: collision with root package name */
    final boolean f1403k;

    /* renamed from: l reason: collision with root package name */
    final int f1404l;
    Bundle m;
    Fragment n;

    D(Fragment fragment) {
        this.f1393a = fragment.getClass().getName();
        this.f1394b = fragment.mWho;
        this.f1395c = fragment.mFromLayout;
        this.f1396d = fragment.mFragmentId;
        this.f1397e = fragment.mContainerId;
        this.f1398f = fragment.mTag;
        this.f1399g = fragment.mRetainInstance;
        this.f1400h = fragment.mRemoving;
        this.f1401i = fragment.mDetached;
        this.f1402j = fragment.mArguments;
        this.f1403k = fragment.mHidden;
        this.f1404l = fragment.mMaxState.ordinal();
    }

    public Fragment a(ClassLoader classLoader, C0198m mVar) {
        if (this.n == null) {
            Bundle bundle = this.f1402j;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            this.n = mVar.a(classLoader, this.f1393a);
            this.n.setArguments(this.f1402j);
            Bundle bundle2 = this.m;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.n.mSavedFragmentState = this.m;
            } else {
                this.n.mSavedFragmentState = new Bundle();
            }
            Fragment fragment = this.n;
            fragment.mWho = this.f1394b;
            fragment.mFromLayout = this.f1395c;
            fragment.mRestored = true;
            fragment.mFragmentId = this.f1396d;
            fragment.mContainerId = this.f1397e;
            fragment.mTag = this.f1398f;
            fragment.mRetainInstance = this.f1399g;
            fragment.mRemoving = this.f1400h;
            fragment.mDetached = this.f1401i;
            fragment.mHidden = this.f1403k;
            fragment.mMaxState = b.values()[this.f1404l];
            if (C0207w.f1561c) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiated fragment ");
                sb.append(this.n);
                Log.v("FragmentManager", sb.toString());
            }
        }
        return this.n;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1393a);
        sb.append(" (");
        sb.append(this.f1394b);
        sb.append(")}:");
        if (this.f1395c) {
            sb.append(" fromLayout");
        }
        if (this.f1397e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1397e));
        }
        String str = this.f1398f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1398f);
        }
        if (this.f1399g) {
            sb.append(" retainInstance");
        }
        if (this.f1400h) {
            sb.append(" removing");
        }
        if (this.f1401i) {
            sb.append(" detached");
        }
        if (this.f1403k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1393a);
        parcel.writeString(this.f1394b);
        parcel.writeInt(this.f1395c ? 1 : 0);
        parcel.writeInt(this.f1396d);
        parcel.writeInt(this.f1397e);
        parcel.writeString(this.f1398f);
        parcel.writeInt(this.f1399g ? 1 : 0);
        parcel.writeInt(this.f1400h ? 1 : 0);
        parcel.writeInt(this.f1401i ? 1 : 0);
        parcel.writeBundle(this.f1402j);
        parcel.writeInt(this.f1403k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.f1404l);
    }

    D(Parcel parcel) {
        this.f1393a = parcel.readString();
        this.f1394b = parcel.readString();
        boolean z = true;
        this.f1395c = parcel.readInt() != 0;
        this.f1396d = parcel.readInt();
        this.f1397e = parcel.readInt();
        this.f1398f = parcel.readString();
        this.f1399g = parcel.readInt() != 0;
        this.f1400h = parcel.readInt() != 0;
        this.f1401i = parcel.readInt() != 0;
        this.f1402j = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f1403k = z;
        this.m = parcel.readBundle();
        this.f1404l = parcel.readInt();
    }
}
