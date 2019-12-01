package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EventData implements Parcelable {
    public static final Creator<EventData> CREATOR = new Creator<EventData>() {
        public EventData createFromParcel(Parcel parcel) {
            return new EventData(parcel);
        }

        public EventData[] newArray(int i2) {
            return new EventData[i2];
        }
    };
    public static final EventData NULL = new EventData(new Builder());
    private final String eventAsPlainText;
    private final EventParticipant participant;

    public static final class Builder {
        String eventAsPlainText;
        io.intercom.android.sdk.models.EventParticipant.Builder participant;

        public EventData build() {
            return new EventData(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getEventAsPlainText() {
        return this.eventAsPlainText;
    }

    public EventParticipant getParticipant() {
        return this.participant;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.participant);
        parcel.writeString(this.eventAsPlainText);
    }

    private EventData(Builder builder) {
        io.intercom.android.sdk.models.EventParticipant.Builder builder2 = builder.participant;
        this.participant = builder2 == null ? EventParticipant.NULL : builder2.build();
        String str = builder.eventAsPlainText;
        if (str == null) {
            str = "";
        }
        this.eventAsPlainText = str;
    }

    protected EventData(Parcel parcel) {
        this.participant = (EventParticipant) parcel.readValue(EventParticipant.class.getClassLoader());
        this.eventAsPlainText = parcel.readString();
    }
}
