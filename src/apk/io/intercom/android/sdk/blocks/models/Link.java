package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.blocks.BlockType;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Link implements Parcelable {
    public static final Creator<Link> CREATOR = new Creator<Link>() {
        public Link createFromParcel(Parcel parcel) {
            return new Link(parcel);
        }

        public Link[] newArray(int i2) {
            return new Link[i2];
        }
    };
    private final String articleId;
    private final Author author;
    private final Map<String, String> data;
    private final String description;
    private final Image image;
    private final String linkType;
    private final String siteName;
    private final String text;
    private final String title;
    private final BlockType type;
    private final String url;

    public static final class Builder {
        String articleId;
        Author author;
        Map<String, String> data;
        String description;
        Image image;
        String linkType;
        String siteName;
        String text;
        String title;
        String type;
        String url;

        public Link build() {
            return new Link(this);
        }

        public Builder withArticleId(String str) {
            this.articleId = str;
            return this;
        }

        public Builder withAuthor(Author author2) {
            this.author = author2;
            return this;
        }

        public Builder withData(Map<String, String> map) {
            this.data = map;
            return this;
        }

        public Builder withDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder withImage(Image image2) {
            this.image = image2;
            return this;
        }

        public Builder withLinkType(String str) {
            this.linkType = str;
            return this;
        }

        public Builder withSiteName(String str) {
            this.siteName = str;
            return this;
        }

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Builder withTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public static Link fromBlock(Block block) {
        if (block == null) {
            return new Link();
        }
        Builder builder = new Builder();
        builder.type = block.getType().name();
        builder.text = block.getText();
        builder.title = block.getTitle();
        builder.description = block.getDescription();
        builder.linkType = block.getLinkType();
        builder.author = block.getAuthor();
        builder.image = block.getImage();
        builder.data = block.getData();
        builder.siteName = block.getSiteName();
        builder.articleId = block.getArticleId();
        builder.url = block.getUrl();
        return new Link(builder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || Link.class != obj.getClass()) {
            return false;
        }
        Link link = (Link) obj;
        if (this.type != link.type) {
            return false;
        }
        String str = this.text;
        if (str == null ? link.text != null : !str.equals(link.text)) {
            return false;
        }
        String str2 = this.title;
        if (str2 == null ? link.title != null : !str2.equals(link.title)) {
            return false;
        }
        String str3 = this.description;
        if (str3 == null ? link.description != null : !str3.equals(link.description)) {
            return false;
        }
        String str4 = this.linkType;
        if (str4 == null ? link.linkType != null : !str4.equals(link.linkType)) {
            return false;
        }
        Author author2 = this.author;
        if (author2 == null ? link.author != null : !author2.equals(link.author)) {
            return false;
        }
        Image image2 = this.image;
        if (image2 == null ? link.image != null : !image2.equals(link.image)) {
            return false;
        }
        Map<String, String> map = this.data;
        if (map == null ? link.data != null : !map.equals(link.data)) {
            return false;
        }
        String str5 = this.siteName;
        if (str5 == null ? link.siteName != null : !str5.equals(link.siteName)) {
            return false;
        }
        String str6 = this.articleId;
        if (str6 == null ? link.articleId != null : !str6.equals(link.articleId)) {
            return false;
        }
        String str7 = this.url;
        if (str7 != null) {
            z = str7.equals(link.url);
        } else if (link.url != null) {
            z = false;
        }
        return z;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public Author getAuthor() {
        return this.author;
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public Image getImage() {
        return this.image;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public BlockType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        BlockType blockType = this.type;
        int i2 = 0;
        int hashCode = (blockType != null ? blockType.hashCode() : 0) * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.linkType;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Author author2 = this.author;
        int hashCode6 = (hashCode5 + (author2 != null ? author2.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode7 = (hashCode6 + (image2 != null ? image2.hashCode() : 0)) * 31;
        Map<String, String> map = this.data;
        int hashCode8 = (hashCode7 + (map != null ? map.hashCode() : 0)) * 31;
        String str5 = this.siteName;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.articleId;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.url;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode10 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkCard{type=");
        sb.append(this.type);
        sb.append(", text='");
        sb.append(this.text);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", linkType='");
        sb.append(this.linkType);
        sb.append('\'');
        sb.append(", author=");
        sb.append(this.author);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", siteName='");
        sb.append(this.siteName);
        sb.append('\'');
        sb.append(", articleId='");
        sb.append(this.articleId);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.type.name());
        parcel.writeString(this.text);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.linkType);
        parcel.writeString(this.siteName);
        parcel.writeString(this.articleId);
        parcel.writeString(this.url);
        parcel.writeParcelable(this.author, i2);
        parcel.writeParcelable(this.image, i2);
        parcel.writeInt(this.data.size());
        for (Entry entry : this.data.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    Link() {
        this(new Builder());
    }

    private Link(Builder builder) {
        this.type = BlockType.typeValueOf(builder.type);
        String str = builder.text;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        this.text = str;
        String str3 = builder.title;
        if (str3 == null) {
            str3 = str2;
        }
        this.title = str3;
        String str4 = builder.description;
        if (str4 == null) {
            str4 = str2;
        }
        this.description = str4;
        String str5 = builder.linkType;
        if (str5 == null) {
            str5 = str2;
        }
        this.linkType = str5;
        String str6 = builder.siteName;
        if (str6 == null) {
            str6 = str2;
        }
        this.siteName = str6;
        String str7 = builder.articleId;
        if (str7 == null) {
            str7 = str2;
        }
        this.articleId = str7;
        Author author2 = builder.author;
        if (author2 == null) {
            author2 = new Author();
        }
        this.author = author2;
        Image image2 = builder.image;
        if (image2 == null) {
            image2 = new Image();
        }
        this.image = image2;
        Map<String, String> map = builder.data;
        if (map == null) {
            map = new HashMap<>();
        }
        this.data = map;
        String str8 = builder.url;
        if (str8 == null) {
            str8 = str2;
        }
        this.url = str8;
    }

    protected Link(Parcel parcel) {
        this.type = BlockType.typeValueOf(parcel.readString());
        this.text = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.linkType = parcel.readString();
        this.siteName = parcel.readString();
        this.articleId = parcel.readString();
        this.url = parcel.readString();
        this.author = (Author) parcel.readParcelable(Author.class.getClassLoader());
        this.image = (Image) parcel.readParcelable(Image.class.getClassLoader());
        this.data = new HashMap();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.data.put(parcel.readString(), parcel.readString());
        }
    }
}
