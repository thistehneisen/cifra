package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NullSafety;

public class EventParticipant implements Parcelable {
    public static final Creator<EventParticipant> CREATOR = new Creator<EventParticipant>() {
        public EventParticipant createFromParcel(Parcel parcel) {
            return new EventParticipant(parcel);
        }

        public EventParticipant[] newArray(int i2) {
            return new EventParticipant[i2];
        }
    };
    public static final EventParticipant NULL = new EventParticipant(new Builder());
    private final Avatar avatar;
    private final String id;
    private final String initial;
    private final String label;
    private final String type;

    public static final class Builder {
        io.intercom.android.sdk.models.Avatar.Builder avatar;
        String id;
        String initial;
        String label;
        String type;

        public EventParticipant build() {
            return new EventParticipant(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public String getId() {
        return this.id;
    }

    public String getInitial() {
        return this.initial;
    }

    public String getLabel() {
        return this.label;
    }

    public String getType() {
        return this.type;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.initial);
        parcel.writeString(this.label);
        parcel.writeString(this.type);
        parcel.writeValue(this.avatar);
    }

    private EventParticipant(Builder builder) {
        this.id = NullSafety.valueOrEmpty(builder.id);
        this.initial = NullSafety.valueOrEmpty(builder.initial);
        this.label = NullSafety.valueOrEmpty(builder.label);
        this.type = NullSafety.valueOrEmpty(builder.type);
        io.intercom.android.sdk.models.Avatar.Builder builder2 = builder.avatar;
        if (builder2 == null) {
            builder2 = new io.intercom.android.sdk.models.Avatar.Builder();
        }
        this.avatar = builder2.build();
    }

    protected EventParticipant(Parcel parcel) {
        this.id = parcel.readString();
        this.initial = parcel.readString();
        this.label = parcel.readString();
        this.type = parcel.readString();
        this.avatar = (Avatar) parcel.readValue(Avatar.class.getClassLoader());
    }
}
