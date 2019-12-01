package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Author implements Parcelable {
    public static final Creator<Author> CREATOR = new Creator<Author>() {
        public Author createFromParcel(Parcel parcel) {
            return new Author(parcel);
        }

        public Author[] newArray(int i2) {
            return new Author[i2];
        }
    };
    private final String avatar;
    private final String firstName;
    private final String lastName;
    private final String name;

    public static final class Builder {
        String avatar;
        String firstName;
        String lastName;
        String name;

        public Author build() {
            return new Author(this);
        }

        public Builder withAvatar(String str) {
            this.avatar = str;
            return this;
        }

        public Builder withFirstName(String str) {
            this.firstName = str;
            return this;
        }

        public Builder withLastName(String str) {
            this.lastName = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
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
        if (obj == null || Author.class != obj.getClass()) {
            return false;
        }
        Author author = (Author) obj;
        String str = this.name;
        if (str == null ? author.name != null : !str.equals(author.name)) {
            return false;
        }
        String str2 = this.firstName;
        if (str2 == null ? author.firstName != null : !str2.equals(author.firstName)) {
            return false;
        }
        String str3 = this.lastName;
        if (str3 == null ? author.lastName != null : !str3.equals(author.lastName)) {
            return false;
        }
        String str4 = this.avatar;
        if (str4 == null ? author.avatar != null : !str4.equals(author.avatar)) {
            z = false;
        }
        return z;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.avatar;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
    }

    Author() {
        this(new Builder());
    }

    private Author(Builder builder) {
        String str = builder.name;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.name = str;
        String str3 = builder.avatar;
        if (str3 == null) {
            str3 = str2;
        }
        this.avatar = str3;
        String str4 = builder.firstName;
        if (str4 == null) {
            str4 = str2;
        }
        this.firstName = str4;
        String str5 = builder.lastName;
        if (str5 == null) {
            str5 = str2;
        }
        this.lastName = str5;
    }

    protected Author(Parcel parcel) {
        this.name = parcel.readString();
        this.avatar = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
    }
}
