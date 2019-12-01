package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new j();

    /* renamed from: a reason: collision with root package name */
    private final int f312a;

    /* renamed from: b reason: collision with root package name */
    private final float f313b;

    RatingCompat(int i2, float f2) {
        this.f312a = i2;
        this.f313b = f2;
    }

    public int describeContents() {
        return this.f312a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f312a);
        sb.append(" rating=");
        float f2 = this.f313b;
        if (f2 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f2);
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f312a);
        parcel.writeFloat(this.f313b);
    }
}
