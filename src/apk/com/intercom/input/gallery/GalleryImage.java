package com.intercom.input.gallery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;

public class GalleryImage implements Parcelable {
    public static final Creator<GalleryImage> CREATOR = new Creator<GalleryImage>() {
        public GalleryImage createFromParcel(Parcel parcel) {
            return new GalleryImage(parcel);
        }

        public GalleryImage[] newArray(int i2) {
            return new GalleryImage[i2];
        }
    };
    private final String attribution;
    private final String fileName;
    private final int fileSize;
    private final int imageHeight;
    private final int imageWidth;
    private final String mimeType;
    private final String path;
    private final String previewPath;

    public static final class Builder {
        private String attribution;
        private String fileName;
        private int fileSize;
        private int imageHeight;
        private int imageWidth;
        private String mimeType;
        private String path;
        private String previewPath;

        private static String valueOrEmpty(String str) {
            return str == null ? "" : str;
        }

        public GalleryImage build() {
            GalleryImage galleryImage = new GalleryImage(valueOrEmpty(this.fileName), valueOrEmpty(this.mimeType), valueOrEmpty(this.path), valueOrEmpty(this.previewPath), valueOrEmpty(this.attribution), this.imageWidth, this.imageHeight, this.fileSize);
            return galleryImage;
        }

        public Builder withAttribution(String str) {
            this.attribution = str;
            return this;
        }

        public Builder withFileName(String str) {
            this.fileName = str;
            return this;
        }

        public Builder withFileSize(int i2) {
            this.fileSize = i2;
            return this;
        }

        public Builder withImageHeight(int i2) {
            this.imageHeight = i2;
            return this;
        }

        public Builder withImageWidth(int i2) {
            this.imageWidth = i2;
            return this;
        }

        public Builder withMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder withPath(String str) {
            this.path = str;
            return this;
        }

        public Builder withPreviewPath(String str) {
            this.previewPath = str;
            return this;
        }
    }

    GalleryImage(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4) {
        this.fileName = str;
        this.mimeType = str2;
        this.path = str3;
        this.previewPath = str4;
        this.attribution = str5;
        this.imageWidth = i2;
        this.imageHeight = i3;
        this.fileSize = i4;
    }

    public File buildFile() {
        return new File(this.path);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GalleryImage.class != obj.getClass()) {
            return false;
        }
        GalleryImage galleryImage = (GalleryImage) obj;
        if (this.imageWidth == galleryImage.imageWidth && this.imageHeight == galleryImage.imageHeight && this.fileSize == galleryImage.fileSize && this.fileName.equals(galleryImage.fileName) && this.mimeType.equals(galleryImage.mimeType) && this.path.equals(galleryImage.path) && this.previewPath.equals(galleryImage.previewPath)) {
            return this.attribution.equals(galleryImage.attribution);
        }
        return false;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public String getImageWidthXHeight() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.imageWidth);
        sb.append("x");
        sb.append(this.imageHeight);
        return sb.toString();
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getPath() {
        return this.path;
    }

    public String getPreviewPath() {
        return this.previewPath;
    }

    public int hashCode() {
        return (((((((((((((this.fileName.hashCode() * 31) + this.mimeType.hashCode()) * 31) + this.path.hashCode()) * 31) + this.previewPath.hashCode()) * 31) + this.attribution.hashCode()) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31) + this.fileSize;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.fileName);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.path);
        parcel.writeString(this.previewPath);
        parcel.writeString(this.attribution);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
        parcel.writeInt(this.fileSize);
    }

    protected GalleryImage(Parcel parcel) {
        this.fileName = parcel.readString();
        this.mimeType = parcel.readString();
        this.path = parcel.readString();
        this.previewPath = parcel.readString();
        this.attribution = parcel.readString();
        this.imageWidth = parcel.readInt();
        this.imageHeight = parcel.readInt();
        this.fileSize = parcel.readInt();
    }
}
