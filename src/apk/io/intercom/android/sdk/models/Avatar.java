package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Avatar implements Parcelable {
    public static final Creator<Avatar> CREATOR = new Creator<Avatar>() {
        public Avatar createFromParcel(Parcel parcel) {
            return Avatar.create(parcel.readString(), parcel.readString());
        }

        public Avatar[] newArray(int i2) {
            return new Avatar[i2];
        }
    };

    public static final class Builder {
        String image_url;
        String initials;

        public Avatar build() {
            return Avatar.create(NullSafety.valueOrEmpty(this.image_url), NullSafety.valueOrEmpty(this.initials));
        }

        /* access modifiers changed from: 0000 */
        public Builder withInitials(String str) {
            this.initials = str;
            return this;
        }
    }

    public static Avatar create(String str, String str2) {
        return new AutoValue_Avatar(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public abstract String getImageUrl();

    public abstract String getInitials();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(getImageUrl());
        parcel.writeString(getInitials());
    }
}
