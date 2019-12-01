package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Channel implements Parcelable {
    public static final Creator<Channel> CREATOR = new Creator<Channel>() {
        public Channel createFromParcel(Parcel parcel) {
            return new Channel(parcel);
        }

        public Channel[] newArray(int i2) {
            return new Channel[i2];
        }
    };
    private final String label;
    private final String name;
    private final String value;

    public static final class Builder {
        String label;
        String name;
        String value;

        public Channel build() {
            return new Channel(this);
        }

        public Builder withLabel(String str) {
            this.label = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withValue(String str) {
            this.value = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || Channel.class != obj.getClass()) {
            return false;
        }
        Channel channel = (Channel) obj;
        String str = this.name;
        if (str == null ? channel.name != null : !str.equals(channel.name)) {
            return false;
        }
        String str2 = this.label;
        if (str2 == null ? channel.label != null : !str2.equals(channel.label)) {
            return false;
        }
        String str3 = this.value;
        if (str3 != null) {
            z = str3.equals(channel.value);
        } else if (channel.value != null) {
            z = false;
        }
        return z;
    }

    public String getLabel() {
        return this.label;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.label;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Channel{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", label='");
        sb.append(this.label);
        sb.append('\'');
        sb.append(", value='");
        sb.append(this.value);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.label);
        parcel.writeString(this.value);
    }

    Channel() {
        this(new Builder());
    }

    private Channel(Builder builder) {
        String str = builder.name;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.name = str;
        String str3 = builder.label;
        if (str3 == null) {
            str3 = str2;
        }
        this.label = str3;
        String str4 = builder.value;
        if (str4 == null) {
            str4 = str2;
        }
        this.value = str4;
    }

    protected Channel(Parcel parcel) {
        this.name = parcel.readString();
        this.label = parcel.readString();
        this.value = parcel.readString();
    }
}
