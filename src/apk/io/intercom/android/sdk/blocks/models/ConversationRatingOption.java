package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ConversationRatingOption implements Parcelable {
    public static final Creator<ConversationRatingOption> CREATOR = new Creator<ConversationRatingOption>() {
        public ConversationRatingOption createFromParcel(Parcel parcel) {
            return new ConversationRatingOption(parcel);
        }

        public ConversationRatingOption[] newArray(int i2) {
            return new ConversationRatingOption[i2];
        }
    };
    private final String emoji;
    private final int index;
    private final String unicode;

    public static final class Builder {
        String emoji;
        Integer index;
        String unicode;

        public ConversationRatingOption build() {
            return new ConversationRatingOption(this);
        }

        public Builder withEmoji(String str) {
            this.emoji = str;
            return this;
        }

        public Builder withIndex(Integer num) {
            this.index = num;
            return this;
        }

        public Builder withUnicode(String str) {
            this.unicode = str;
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
        if (obj == null || ConversationRatingOption.class != obj.getClass()) {
            return false;
        }
        ConversationRatingOption conversationRatingOption = (ConversationRatingOption) obj;
        if (this.index != conversationRatingOption.index) {
            return false;
        }
        String str = this.emoji;
        if (str == null ? conversationRatingOption.emoji != null : !str.equals(conversationRatingOption.emoji)) {
            return false;
        }
        String str2 = this.unicode;
        if (str2 != null) {
            z = str2.equals(conversationRatingOption.unicode);
        } else if (conversationRatingOption.unicode != null) {
            z = false;
        }
        return z;
    }

    public String getEmoji() {
        return this.emoji;
    }

    public Integer getIndex() {
        return Integer.valueOf(this.index);
    }

    public String getUnicode() {
        return this.unicode;
    }

    public int hashCode() {
        int i2 = this.index * 31;
        String str = this.emoji;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.unicode;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode + i3;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.index);
        parcel.writeString(this.emoji);
        parcel.writeString(this.unicode);
    }

    private ConversationRatingOption(Builder builder) {
        Integer num = builder.index;
        this.index = num == null ? -1 : num.intValue();
        String str = builder.emoji;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.emoji = str;
        String str3 = builder.unicode;
        if (str3 == null) {
            str3 = str2;
        }
        this.unicode = str3;
    }

    protected ConversationRatingOption(Parcel parcel) {
        this.index = parcel.readInt();
        this.emoji = parcel.readString();
        this.unicode = parcel.readString();
    }
}
