package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        public Location createFromParcel(Parcel parcel) {
            return Location.create(parcel.readString(), parcel.readString(), parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public Location[] newArray(int i2) {
            return new Location[i2];
        }
    };

    public static final class Builder {
        String city_name;
        String country_name;
        Integer timezone_offset;

        public Location build() {
            return Location.create(NullSafety.valueOrEmpty(this.city_name), NullSafety.valueOrEmpty(this.country_name), this.timezone_offset);
        }
    }

    public static Location create(String str, String str2, Integer num) {
        return new AutoValue_Location(str, str2, num);
    }

    public int describeContents() {
        return 0;
    }

    public abstract String getCityName();

    public abstract String getCountryName();

    public abstract Integer getTimezoneOffset();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(getCityName());
        parcel.writeString(getCountryName());
        Integer timezoneOffset = getTimezoneOffset();
        if (timezoneOffset == null) {
            parcel.writeByte(0);
            return;
        }
        parcel.writeByte(1);
        parcel.writeInt(timezoneOffset.intValue());
    }
}
