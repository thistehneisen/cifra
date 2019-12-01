package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class ReplyOption implements Parcelable {
    public static final Creator<ReplyOption> CREATOR = new Creator<ReplyOption>() {
        public ReplyOption createFromParcel(Parcel parcel) {
            return ReplyOption.create(parcel.readString(), parcel.readString());
        }

        public ReplyOption[] newArray(int i2) {
            return new ReplyOption[i2];
        }
    };

    public static final class Builder {
        String text;
        String uuid;

        public ReplyOption build() {
            return ReplyOption.create(NullSafety.valueOrEmpty(this.text), NullSafety.valueOrEmpty(this.uuid));
        }

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Builder withUuid(String str) {
            this.uuid = str;
            return this;
        }
    }

    static ReplyOption create(String str, String str2) {
        return new AutoValue_ReplyOption(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public abstract String text();

    public abstract String uuid();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(text());
        parcel.writeString(uuid());
    }
}
