package com.touchin.vtb.viewcontrollers.success;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: SuccessState.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new C0080a();

    /* renamed from: a reason: collision with root package name */
    private final String f7736a;

    /* renamed from: b reason: collision with root package name */
    private final String f7737b;

    /* renamed from: c reason: collision with root package name */
    private final String f7738c;

    /* renamed from: com.touchin.vtb.viewcontrollers.success.a$a reason: collision with other inner class name */
    public static class C0080a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new a(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a(String str, String str2, String str3) {
        h.b(str, "title");
        h.b(str2, "subtitle");
        this.f7736a = str;
        this.f7737b = str2;
        this.f7738c = str3;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.e.b.h.a((java.lang.Object) r2.f7738c, (java.lang.Object) r3.f7738c) != false) goto L_0x0029;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (h.a((Object) this.f7736a, (Object) aVar.f7736a)) {
                    if (h.a((Object) this.f7737b, (Object) aVar.f7737b)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7736a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7737b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7738c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String n() {
        return this.f7738c;
    }

    public final String o() {
        return this.f7737b;
    }

    public final String p() {
        return this.f7736a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuccessState(title=");
        sb.append(this.f7736a);
        sb.append(", subtitle=");
        sb.append(this.f7737b);
        sb.append(", backStackNameToReturnTo=");
        sb.append(this.f7738c);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7736a);
        parcel.writeString(this.f7737b);
        parcel.writeString(this.f7738c);
    }
}
