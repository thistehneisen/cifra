package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.utilities.NameUtils;
import io.intercom.android.sdk.utilities.NullSafety;

public abstract class Participant implements Parcelable {
    public static final String ADMIN_TYPE = "admin";
    public static final Creator<Participant> CREATOR = new Creator<Participant>() {
        public Participant createFromParcel(Parcel parcel) {
            return Participant.create(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Avatar) parcel.readValue(Avatar.class.getClassLoader()), Boolean.valueOf(parcel.readByte() == 0));
        }

        public Participant[] newArray(int i2) {
            return new Participant[i2];
        }
    };
    public static final Participant NULL;
    static final String USER_TYPE = "user";

    public static final class Builder {
        io.intercom.android.sdk.models.Avatar.Builder avatar;
        String email;
        String id;
        Boolean is_bot;
        String name;
        String type;

        public Participant build() {
            Avatar avatar2;
            String str = this.type;
            if (str == null) {
                str = Participant.USER_TYPE;
            }
            String str2 = str;
            String valueOrEmpty = NullSafety.valueOrEmpty(this.name);
            String valueOrEmpty2 = NullSafety.valueOrEmpty(this.email);
            String initial = NameUtils.getInitial(valueOrEmpty.isEmpty() ? valueOrEmpty2 : valueOrEmpty);
            io.intercom.android.sdk.models.Avatar.Builder builder = this.avatar;
            if (builder == null) {
                avatar2 = Avatar.create("", initial);
            } else {
                avatar2 = builder.withInitials(initial).build();
            }
            return Participant.create(NullSafety.valueOrEmpty(this.id), valueOrEmpty, str2, valueOrEmpty2, avatar2, Boolean.valueOf(NullSafety.valueOrDefault(this.is_bot, false)));
        }

        public Builder withEmail(String str) {
            this.email = str;
            return this;
        }

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withIsBot(boolean z) {
            this.is_bot = Boolean.valueOf(z);
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }
    }

    static {
        String str = "";
        NULL = create("", "", "", "", Avatar.create(str, str), Boolean.valueOf(false));
    }

    public static Participant create(String str, String str2, String str3, String str4, Avatar avatar, Boolean bool) {
        AutoValue_Participant autoValue_Participant = new AutoValue_Participant(str, str2, str3, str4, avatar, bool);
        return autoValue_Participant;
    }

    public int describeContents() {
        return 0;
    }

    public abstract Avatar getAvatar();

    public abstract String getEmail();

    public String getForename() {
        return nameOrEmail().trim().split(" ")[0];
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getType();

    public boolean isAdmin() {
        return ADMIN_TYPE.equals(getType());
    }

    public abstract Boolean isBot();

    public boolean isUserWithId(String str) {
        return USER_TYPE.equals(getType()) && getId().equals(str);
    }

    /* access modifiers changed from: 0000 */
    public String nameOrEmail() {
        return getName().isEmpty() ? getEmail() : getName();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(getId());
        parcel.writeString(getName());
        parcel.writeString(getType());
        parcel.writeString(getEmail());
        parcel.writeValue(getAvatar());
        parcel.writeByte(isBot().booleanValue() ? (byte) 1 : 0);
    }
}
