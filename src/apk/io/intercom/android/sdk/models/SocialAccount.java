package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class SocialAccount implements Parcelable {
    public static final Creator<SocialAccount> CREATOR = new Creator<SocialAccount>() {
        public SocialAccount createFromParcel(Parcel parcel) {
            return SocialAccount.create(parcel.readString(), parcel.readString());
        }

        public SocialAccount[] newArray(int i2) {
            return new SocialAccount[i2];
        }
    };
    public static final SocialAccount NULL;

    public static final class Builder {
        String profile_url;
        String provider;

        public SocialAccount build() {
            return SocialAccount.create(NullSafety.valueOrEmpty(this.provider), NullSafety.valueOrEmpty(this.profile_url));
        }
    }

    static {
        String str = "";
        NULL = create(str, str);
    }

    public static SocialAccount create(String str, String str2) {
        return new AutoValue_SocialAccount(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public abstract String getProfileUrl();

    public abstract String getProvider();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(getProvider());
        parcel.writeString(getProfileUrl());
    }
}
