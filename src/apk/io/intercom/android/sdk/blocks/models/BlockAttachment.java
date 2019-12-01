package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BlockAttachment implements Parcelable {
    public static final Creator<BlockAttachment> CREATOR = new Creator<BlockAttachment>() {
        public BlockAttachment createFromParcel(Parcel parcel) {
            return new BlockAttachment(parcel);
        }

        public BlockAttachment[] newArray(int i2) {
            return new BlockAttachment[i2];
        }
    };
    private final String contentType;
    private final int id;
    private final String name;
    private final long size;
    private final String url;

    public static final class Builder {
        String contentType;
        int id;
        String name;
        long size;
        String url;

        public BlockAttachment build() {
            return new BlockAttachment(this);
        }

        public Builder withContentType(String str) {
            this.contentType = str;
            return this;
        }

        public Builder withId(int i2) {
            this.id = i2;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withSize(long j2) {
            this.size = j2;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public BlockAttachment() {
        this(new Builder());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || BlockAttachment.class != obj.getClass()) {
            return false;
        }
        BlockAttachment blockAttachment = (BlockAttachment) obj;
        if (this.size != blockAttachment.size || this.id != blockAttachment.id) {
            return false;
        }
        String str = this.name;
        if (str == null ? blockAttachment.name != null : !str.equals(blockAttachment.name)) {
            return false;
        }
        String str2 = this.url;
        if (str2 == null ? blockAttachment.url != null : !str2.equals(blockAttachment.url)) {
            return false;
        }
        String str3 = this.contentType;
        if (str3 != null) {
            z = str3.equals(blockAttachment.contentType);
        } else if (blockAttachment.contentType != null) {
            z = false;
        }
        return z;
    }

    public String getContentType() {
        return this.contentType;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.contentType;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        long j2 = this.size;
        return ((i3 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.id;
    }

    public Builder toBuilder() {
        return new Builder().withName(this.name).withUrl(this.url).withContentType(this.contentType).withId(this.id).withSize(this.size);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.contentType);
        parcel.writeInt(this.id);
        parcel.writeLong(this.size);
    }

    public BlockAttachment(Builder builder) {
        String str = builder.name;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.name = str;
        String str3 = builder.url;
        if (str3 == null) {
            str3 = str2;
        }
        this.url = str3;
        String str4 = builder.contentType;
        if (str4 == null) {
            str4 = str2;
        }
        this.contentType = str4;
        this.id = builder.id;
        this.size = builder.size;
    }

    protected BlockAttachment(Parcel parcel) {
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.contentType = parcel.readString();
        this.id = parcel.readInt();
        this.size = parcel.readLong();
    }
}
