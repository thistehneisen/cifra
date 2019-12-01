package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Reaction implements Parcelable {
    public static final Creator<Reaction> CREATOR = new Creator<Reaction>() {
        public Reaction createFromParcel(Parcel parcel) {
            return Reaction.create(parcel.readInt(), parcel.readString());
        }

        public Reaction[] newArray(int i2) {
            return new Reaction[i2];
        }
    };

    public static final class Builder {
        String image_url;
        int index;

        public Reaction build() {
            return Reaction.create(this.index, NullSafety.valueOrEmpty(this.image_url));
        }
    }

    public static Reaction create(int i2, String str) {
        return new AutoValue_Reaction(i2, str);
    }

    public int describeContents() {
        return 0;
    }

    public abstract String getImageUrl();

    public abstract int getIndex();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(getIndex());
        parcel.writeString(getImageUrl());
    }
}
