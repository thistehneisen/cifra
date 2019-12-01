package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class ComposerState implements Parcelable {
    public static final Creator<ComposerState> CREATOR = new Creator<ComposerState>() {
        public ComposerState createFromParcel(Parcel parcel) {
            return ComposerState.create(parcel.readByte() != 0);
        }

        public ComposerState[] newArray(int i2) {
            return new ComposerState[i2];
        }
    };
    public static final ComposerState NULL = new Builder().build();

    public static final class Builder {
        Boolean visible;

        public ComposerState build() {
            return ComposerState.create(NullSafety.valueOrDefault(this.visible, true));
        }

        public Builder withVisible(Boolean bool) {
            this.visible = bool;
            return this;
        }
    }

    static ComposerState create(boolean z) {
        return new AutoValue_ComposerState(z);
    }

    public int describeContents() {
        return 0;
    }

    public abstract boolean isVisible();

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(isVisible() ? (byte) 1 : 0);
    }
}
