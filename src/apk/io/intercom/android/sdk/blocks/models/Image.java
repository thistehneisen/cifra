package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Image implements Parcelable {
    public static final Creator<Image> CREATOR = new Creator<Image>() {
        public Image createFromParcel(Parcel parcel) {
            return new Image(parcel);
        }

        public Image[] newArray(int i2) {
            return new Image[i2];
        }
    };
    private final String alt;
    private final String attribution;
    private final int height;
    private final String previewUrl;
    private final String url;
    private final int width;

    public static final class Builder {
        String alt;
        String attribution;
        int height;
        String previewUrl;
        String url;
        int width;

        public Image build() {
            return new Image(this);
        }

        public Builder withAlt(String str) {
            this.alt = str;
            return this;
        }

        public Builder withAttribution(String str) {
            this.attribution = str;
            return this;
        }

        public Builder withHeight(int i2) {
            this.height = i2;
            return this;
        }

        public Builder withPreviewUrl(String str) {
            this.previewUrl = str;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder withWidth(int i2) {
            this.width = i2;
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
        if (obj == null || Image.class != obj.getClass()) {
            return false;
        }
        Image image = (Image) obj;
        String str = this.alt;
        if (str == null ? image.alt != null : !str.equals(image.alt)) {
            return false;
        }
        String str2 = this.previewUrl;
        if (str2 == null ? image.previewUrl != null : !str2.equals(image.previewUrl)) {
            return false;
        }
        String str3 = this.attribution;
        if (str3 == null ? image.attribution != null : !str3.equals(image.attribution)) {
            return false;
        }
        if (this.width != image.width || this.height != image.height) {
            return false;
        }
        String str4 = this.url;
        if (str4 == null ? image.url != null : !str4.equals(image.url)) {
            z = false;
        }
        return z;
    }

    public String getAlt() {
        return this.alt;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.alt;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.previewUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.attribution;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return ((((hashCode3 + i2) * 31) + this.width) * 31) + this.height;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.attribution);
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.alt);
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    Image() {
        this(new Builder());
    }

    private Image(Builder builder) {
        String str = builder.alt;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.alt = str;
        String str3 = builder.url;
        if (str3 == null) {
            str3 = str2;
        }
        this.url = str3;
        String str4 = builder.previewUrl;
        if (str4 == null) {
            str4 = str2;
        }
        this.previewUrl = str4;
        String str5 = builder.attribution;
        if (str5 == null) {
            str5 = str2;
        }
        this.attribution = str5;
        this.width = builder.width;
        this.height = builder.height;
    }

    protected Image(Parcel parcel) {
        this.attribution = parcel.readString();
        this.previewUrl = parcel.readString();
        this.alt = parcel.readString();
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
