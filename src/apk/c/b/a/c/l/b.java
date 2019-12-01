package c.b.a.c.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import b.d.i;
import b.i.a.c;

/* compiled from: ExtendableSavedState */
public class b extends c {
    public static final Creator<b> CREATOR = new a();

    /* renamed from: c reason: collision with root package name */
    public final i<String, Bundle> f3184c;

    /* synthetic */ b(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtendableSavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" states=");
        sb.append(this.f3184c);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.f3184c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = (String) this.f3184c.b(i3);
            bundleArr[i3] = (Bundle) this.f3184c.d(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public b(Parcelable parcelable) {
        super(parcelable);
        this.f3184c = new i<>();
    }

    private b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3184c = new i<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f3184c.put(strArr[i2], bundleArr[i2]);
        }
    }
}
