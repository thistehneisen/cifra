package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.blocks.BlockAlignment;
import io.intercom.android.sdk.blocks.BlockType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Block implements Parcelable {
    public static final Creator<Block> CREATOR = new Creator<Block>() {
        public Block createFromParcel(Parcel parcel) {
            return new Block(parcel);
        }

        public Block[] newArray(int i2) {
            return new Block[i2];
        }
    };
    private final BlockAlignment align;
    private final String articleId;
    private final List<BlockAttachment> attachments;
    private final String attribution;
    private final Author author;
    private final List<Channel> channels;
    private final Map<String, String> data;
    private final String description;
    private final String fallbackUrl;
    private final Link footerLink;
    private final int height;
    private final String id;
    private final Image image;
    private final List<String> items;
    private final String language;
    private final String linkType;
    private final String linkUrl;
    private final List<Link> links;
    private final List<ConversationRatingOption> options;
    private final String previewUrl;
    private final String provider;
    private final int ratingIndex;
    private final String remark;
    private final String siteName;
    private final String text;
    private final String thumbnailUrl;
    private final String title;
    private final String trackingUrl;
    private final BlockType type;
    private final String url;
    private final String username;
    private final int width;

    /* renamed from: io.intercom.android.sdk.blocks.models.Block$2 reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$blocks$BlockType = new int[BlockType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.PARAGRAPH.ordinal()] = 1;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.LOCALIMAGE.ordinal()] = 2;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.IMAGE.ordinal()] = 3;
            try {
                $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.LOCAL_ATTACHMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static final class Builder {
        String align;
        String articleId;
        List<BlockAttachment> attachments;
        String attribution;
        Author author;
        List<Channel> channels;
        Map<String, String> data;
        String description;
        String fallbackUrl;
        Builder footerLink;
        Integer height;
        String id;
        Image image;
        List<String> items;
        String language;
        String linkType;
        String linkUrl;
        List<Builder> links;
        List<io.intercom.android.sdk.blocks.models.ConversationRatingOption.Builder> options;
        String previewUrl;
        String provider;
        Integer ratingIndex;
        Integer rating_index;
        String remark;
        String siteName;
        String text;
        String thumbnailUrl;
        String title;
        String trackingUrl;
        String type;
        String url;
        String username;
        Integer width;

        public Block build() {
            return new Block(this);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || Builder.class != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            String str = this.type;
            if (str == null ? builder.type != null : !str.equals(builder.type)) {
                return false;
            }
            String str2 = this.text;
            if (str2 == null ? builder.text != null : !str2.equals(builder.text)) {
                return false;
            }
            String str3 = this.title;
            if (str3 == null ? builder.title != null : !str3.equals(builder.title)) {
                return false;
            }
            String str4 = this.description;
            if (str4 == null ? builder.description != null : !str4.equals(builder.description)) {
                return false;
            }
            String str5 = this.linkType;
            if (str5 == null ? builder.linkType != null : !str5.equals(builder.linkType)) {
                return false;
            }
            String str6 = this.siteName;
            if (str6 == null ? builder.siteName != null : !str6.equals(builder.siteName)) {
                return false;
            }
            String str7 = this.articleId;
            if (str7 == null ? builder.articleId != null : !str7.equals(builder.articleId)) {
                return false;
            }
            Author author2 = this.author;
            if (author2 == null ? builder.author != null : !author2.equals(builder.author)) {
                return false;
            }
            Image image2 = this.image;
            if (image2 == null ? builder.image != null : !image2.equals(builder.image)) {
                return false;
            }
            Map<String, String> map = this.data;
            if (map == null ? builder.data != null : !map.equals(builder.data)) {
                return false;
            }
            String str8 = this.language;
            if (str8 == null ? builder.language != null : !str8.equals(builder.language)) {
                return false;
            }
            String str9 = this.url;
            if (str9 == null ? builder.url != null : !str9.equals(builder.url)) {
                return false;
            }
            String str10 = this.thumbnailUrl;
            if (str10 == null ? builder.thumbnailUrl != null : !str10.equals(builder.thumbnailUrl)) {
                return false;
            }
            String str11 = this.linkUrl;
            if (str11 == null ? builder.linkUrl != null : !str11.equals(builder.linkUrl)) {
                return false;
            }
            String str12 = this.trackingUrl;
            if (str12 == null ? builder.trackingUrl != null : !str12.equals(builder.trackingUrl)) {
                return false;
            }
            String str13 = this.fallbackUrl;
            if (str13 == null ? builder.fallbackUrl != null : !str13.equals(builder.fallbackUrl)) {
                return false;
            }
            String str14 = this.username;
            if (str14 == null ? builder.username != null : !str14.equals(builder.username)) {
                return false;
            }
            String str15 = this.provider;
            if (str15 == null ? builder.provider != null : !str15.equals(builder.provider)) {
                return false;
            }
            String str16 = this.id;
            if (str16 == null ? builder.id != null : !str16.equals(builder.id)) {
                return false;
            }
            String str17 = this.align;
            if (str17 == null ? builder.align != null : !str17.equals(builder.align)) {
                return false;
            }
            Integer num = this.width;
            if (num == null ? builder.width != null : !num.equals(builder.width)) {
                return false;
            }
            Integer num2 = this.height;
            if (num2 == null ? builder.height != null : !num2.equals(builder.height)) {
                return false;
            }
            String str18 = this.previewUrl;
            if (str18 == null ? builder.previewUrl != null : !str18.equals(builder.previewUrl)) {
                return false;
            }
            String str19 = this.attribution;
            if (str19 == null ? builder.attribution != null : !str19.equals(builder.attribution)) {
                return false;
            }
            List<BlockAttachment> list = this.attachments;
            if (list == null ? builder.attachments != null : !list.equals(builder.attachments)) {
                return false;
            }
            List<String> list2 = this.items;
            if (list2 == null ? builder.items != null : !list2.equals(builder.items)) {
                return false;
            }
            List<Channel> list3 = this.channels;
            if (list3 == null ? builder.channels != null : !list3.equals(builder.channels)) {
                return false;
            }
            Integer num3 = this.rating_index;
            if (num3 == null ? builder.rating_index != null : !num3.equals(builder.rating_index)) {
                return false;
            }
            Integer num4 = this.ratingIndex;
            if (num4 == null ? builder.ratingIndex != null : !num4.equals(builder.ratingIndex)) {
                return false;
            }
            String str20 = this.remark;
            if (str20 == null ? builder.remark != null : !str20.equals(builder.remark)) {
                return false;
            }
            List<io.intercom.android.sdk.blocks.models.ConversationRatingOption.Builder> list4 = this.options;
            if (list4 == null ? builder.options != null : !list4.equals(builder.options)) {
                return false;
            }
            List<Builder> list5 = this.links;
            if (list5 == null ? builder.links != null : !list5.equals(builder.links)) {
                return false;
            }
            Builder builder2 = this.footerLink;
            if (builder2 != null) {
                z = builder2.equals(builder.footerLink);
            } else if (builder.footerLink != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            String str = this.type;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.text;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.title;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.description;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.linkType;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.siteName;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.articleId;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Author author2 = this.author;
            int hashCode8 = (hashCode7 + (author2 != null ? author2.hashCode() : 0)) * 31;
            Image image2 = this.image;
            int hashCode9 = (hashCode8 + (image2 != null ? image2.hashCode() : 0)) * 31;
            Map<String, String> map = this.data;
            int hashCode10 = (hashCode9 + (map != null ? map.hashCode() : 0)) * 31;
            String str8 = this.language;
            int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.url;
            int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.thumbnailUrl;
            int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.linkUrl;
            int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.trackingUrl;
            int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.fallbackUrl;
            int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
            String str14 = this.username;
            int hashCode17 = (hashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31;
            String str15 = this.provider;
            int hashCode18 = (hashCode17 + (str15 != null ? str15.hashCode() : 0)) * 31;
            String str16 = this.id;
            int hashCode19 = (hashCode18 + (str16 != null ? str16.hashCode() : 0)) * 31;
            String str17 = this.align;
            int hashCode20 = (hashCode19 + (str17 != null ? str17.hashCode() : 0)) * 31;
            Integer num = this.width;
            int hashCode21 = (hashCode20 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.height;
            int hashCode22 = (hashCode21 + (num2 != null ? num2.hashCode() : 0)) * 31;
            String str18 = this.previewUrl;
            int hashCode23 = (hashCode22 + (str18 != null ? str18.hashCode() : 0)) * 31;
            String str19 = this.attribution;
            int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
            List<BlockAttachment> list = this.attachments;
            int hashCode25 = (hashCode24 + (list != null ? list.hashCode() : 0)) * 31;
            List<String> list2 = this.items;
            int hashCode26 = (hashCode25 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Channel> list3 = this.channels;
            int hashCode27 = (hashCode26 + (list3 != null ? list3.hashCode() : 0)) * 31;
            Integer num3 = this.rating_index;
            int hashCode28 = (hashCode27 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.ratingIndex;
            int hashCode29 = (hashCode28 + (num4 != null ? num4.hashCode() : 0)) * 31;
            String str20 = this.remark;
            int hashCode30 = (hashCode29 + (str20 != null ? str20.hashCode() : 0)) * 31;
            List<io.intercom.android.sdk.blocks.models.ConversationRatingOption.Builder> list4 = this.options;
            int hashCode31 = (hashCode30 + (list4 != null ? list4.hashCode() : 0)) * 31;
            List<Builder> list5 = this.links;
            int hashCode32 = (hashCode31 + (list5 != null ? list5.hashCode() : 0)) * 31;
            Builder builder = this.footerLink;
            if (builder != null) {
                i2 = builder.hashCode();
            }
            return hashCode32 + i2;
        }

        public Builder withAlign(String str) {
            this.align = str;
            return this;
        }

        public Builder withArticleId(String str) {
            this.articleId = str;
            return this;
        }

        public Builder withAttachments(List<BlockAttachment> list) {
            this.attachments = list;
            return this;
        }

        public Builder withAttribution(String str) {
            this.attribution = str;
            return this;
        }

        public Builder withAuthor(Author author2) {
            this.author = author2;
            return this;
        }

        public Builder withChannels(List<Channel> list) {
            this.channels = list;
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

        public Builder withHeight(int i2) {
            this.height = Integer.valueOf(i2);
            return this;
        }

        public Builder withImage(Image image2) {
            this.image = image2;
            return this;
        }

        public Builder withItems(List<String> list) {
            this.items = list;
            return this;
        }

        public Builder withLinkType(String str) {
            this.linkType = str;
            return this;
        }

        public Builder withOptions(List<io.intercom.android.sdk.blocks.models.ConversationRatingOption.Builder> list) {
            this.options = list;
            return this;
        }

        public Builder withPreviewUrl(String str) {
            this.previewUrl = str;
            return this;
        }

        public Builder withRatingIndex(Integer num) {
            this.ratingIndex = num;
            return this;
        }

        public Builder withRemark(String str) {
            this.remark = str;
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

        public Builder withThumbnailUrl(String str) {
            this.thumbnailUrl = str;
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

        public Builder withWidth(int i2) {
            this.width = Integer.valueOf(i2);
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
        if (obj == null || Block.class != obj.getClass()) {
            return false;
        }
        Block block = (Block) obj;
        if (this.width != block.width || this.height != block.height || this.ratingIndex != block.ratingIndex) {
            return false;
        }
        List<BlockAttachment> list = this.attachments;
        if (list == null ? block.attachments != null : !list.equals(block.attachments)) {
            return false;
        }
        List<String> list2 = this.items;
        if (list2 == null ? block.items != null : !list2.equals(block.items)) {
            return false;
        }
        Map<String, String> map = this.data;
        if (map == null ? block.data != null : !map.equals(block.data)) {
            return false;
        }
        if (this.type != block.type || this.align != block.align) {
            return false;
        }
        Author author2 = this.author;
        if (author2 == null ? block.author != null : !author2.equals(block.author)) {
            return false;
        }
        Image image2 = this.image;
        if (image2 == null ? block.image != null : !image2.equals(block.image)) {
            return false;
        }
        String str = this.text;
        if (str == null ? block.text != null : !str.equals(block.text)) {
            return false;
        }
        String str2 = this.title;
        if (str2 == null ? block.title != null : !str2.equals(block.title)) {
            return false;
        }
        String str3 = this.description;
        if (str3 == null ? block.description != null : !str3.equals(block.description)) {
            return false;
        }
        String str4 = this.linkType;
        if (str4 == null ? block.linkType != null : !str4.equals(block.linkType)) {
            return false;
        }
        String str5 = this.siteName;
        if (str5 == null ? block.siteName != null : !str5.equals(block.siteName)) {
            return false;
        }
        String str6 = this.articleId;
        if (str6 == null ? block.articleId != null : !str6.equals(block.articleId)) {
            return false;
        }
        String str7 = this.language;
        if (str7 == null ? block.language != null : !str7.equals(block.language)) {
            return false;
        }
        String str8 = this.url;
        if (str8 == null ? block.url != null : !str8.equals(block.url)) {
            return false;
        }
        String str9 = this.thumbnailUrl;
        if (str9 == null ? block.thumbnailUrl != null : !str9.equals(block.thumbnailUrl)) {
            return false;
        }
        String str10 = this.previewUrl;
        if (str10 == null ? block.previewUrl != null : !str10.equals(block.previewUrl)) {
            return false;
        }
        String str11 = this.attribution;
        if (str11 == null ? block.attribution != null : !str11.equals(block.attribution)) {
            return false;
        }
        String str12 = this.linkUrl;
        if (str12 == null ? block.linkUrl != null : !str12.equals(block.linkUrl)) {
            return false;
        }
        String str13 = this.trackingUrl;
        if (str13 == null ? block.trackingUrl != null : !str13.equals(block.trackingUrl)) {
            return false;
        }
        String str14 = this.fallbackUrl;
        if (str14 == null ? block.fallbackUrl != null : !str14.equals(block.fallbackUrl)) {
            return false;
        }
        String str15 = this.username;
        if (str15 == null ? block.username != null : !str15.equals(block.username)) {
            return false;
        }
        String str16 = this.provider;
        if (str16 == null ? block.provider != null : !str16.equals(block.provider)) {
            return false;
        }
        String str17 = this.id;
        if (str17 == null ? block.id != null : !str17.equals(block.id)) {
            return false;
        }
        List<Channel> list3 = this.channels;
        if (list3 == null ? block.channels != null : !list3.equals(block.channels)) {
            return false;
        }
        String str18 = this.remark;
        if (str18 == null ? block.remark != null : !str18.equals(block.remark)) {
            return false;
        }
        List<ConversationRatingOption> list4 = this.options;
        if (list4 == null ? block.options != null : !list4.equals(block.options)) {
            return false;
        }
        List<Link> list5 = this.links;
        if (list5 == null ? block.links != null : !list5.equals(block.links)) {
            return false;
        }
        Link link = this.footerLink;
        if (link != null) {
            z = link.equals(block.footerLink);
        } else if (block.footerLink != null) {
            z = false;
        }
        return z;
    }

    public BlockAlignment getAlign() {
        return this.align;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public List<BlockAttachment> getAttachments() {
        return this.attachments;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public Author getAuthor() {
        return this.author;
    }

    public List<Channel> getChannels() {
        return this.channels;
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFallbackUrl() {
        return this.fallbackUrl;
    }

    public Link getFooterLink() {
        return this.footerLink;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public Image getImage() {
        return this.image;
    }

    public List<String> getItems() {
        return this.items;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public List<ConversationRatingOption> getOptions() {
        return this.options;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public String getProvider() {
        return this.provider;
    }

    public int getRatingIndex() {
        return this.ratingIndex;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public String getText() {
        return this.text;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrackingUrl() {
        return this.trackingUrl;
    }

    public BlockType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        List<BlockAttachment> list = this.attachments;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.items;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<String, String> map = this.data;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        BlockType blockType = this.type;
        int hashCode4 = (hashCode3 + (blockType != null ? blockType.hashCode() : 0)) * 31;
        BlockAlignment blockAlignment = this.align;
        int hashCode5 = (hashCode4 + (blockAlignment != null ? blockAlignment.hashCode() : 0)) * 31;
        Author author2 = this.author;
        int hashCode6 = (hashCode5 + (author2 != null ? author2.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode7 = (hashCode6 + (image2 != null ? image2.hashCode() : 0)) * 31;
        String str = this.text;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.linkType;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.siteName;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.articleId;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.language;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.url;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.thumbnailUrl;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.previewUrl;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.attribution;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.linkUrl;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.trackingUrl;
        int hashCode20 = (hashCode19 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.fallbackUrl;
        int hashCode21 = (hashCode20 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.username;
        int hashCode22 = (hashCode21 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.provider;
        int hashCode23 = (hashCode22 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.id;
        int hashCode24 = (((((hashCode23 + (str17 != null ? str17.hashCode() : 0)) * 31) + this.width) * 31) + this.height) * 31;
        List<Channel> list3 = this.channels;
        int hashCode25 = (((hashCode24 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.ratingIndex) * 31;
        String str18 = this.remark;
        int hashCode26 = (hashCode25 + (str18 != null ? str18.hashCode() : 0)) * 31;
        List<ConversationRatingOption> list4 = this.options;
        int hashCode27 = (hashCode26 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<Link> list5 = this.links;
        int hashCode28 = (hashCode27 + (list5 != null ? list5.hashCode() : 0)) * 31;
        Link link = this.footerLink;
        if (link != null) {
            i2 = link.hashCode();
        }
        return hashCode28 + i2;
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        int i2 = AnonymousClass2.$SwitchMap$io$intercom$android$blocks$BlockType[this.type.ordinal()];
        if (i2 == 1) {
            builder.withText(this.text).withType(this.type.getSerializedName());
        } else if (i2 == 2 || i2 == 3) {
            String str = null;
            Builder withAttribution = builder.withType(this.type.getSerializedName()).withUrl(this.url).withAttribution(this.attribution.isEmpty() ? null : this.attribution);
            if (!this.previewUrl.isEmpty()) {
                str = this.previewUrl;
            }
            withAttribution.withPreviewUrl(str).withHeight(this.height).withWidth(this.width);
        } else if (i2 == 4) {
            builder.withType(this.type.getSerializedName()).withAttachments(this.attachments);
        }
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Block{attachments=");
        sb.append(this.attachments);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", align=");
        sb.append(this.align);
        sb.append(", author=");
        sb.append(this.author);
        sb.append(", image=");
        sb.append(this.image);
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
        sb.append(", siteName='");
        sb.append(this.siteName);
        sb.append('\'');
        sb.append(", articleId='");
        sb.append(this.articleId);
        sb.append('\'');
        sb.append(", language='");
        sb.append(this.language);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", thumbnailUrl='");
        sb.append(this.thumbnailUrl);
        sb.append('\'');
        sb.append(", previewUrl='");
        sb.append(this.previewUrl);
        sb.append('\'');
        sb.append(", attribution='");
        sb.append(this.attribution);
        sb.append('\'');
        sb.append(", linkUrl='");
        sb.append(this.linkUrl);
        sb.append('\'');
        sb.append(", trackingUrl='");
        sb.append(this.trackingUrl);
        sb.append('\'');
        sb.append(", fallbackUrl='");
        sb.append(this.fallbackUrl);
        sb.append('\'');
        sb.append(", username='");
        sb.append(this.username);
        sb.append('\'');
        sb.append(", provider='");
        sb.append(this.provider);
        sb.append('\'');
        sb.append(", id='");
        sb.append(this.id);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", channels=");
        sb.append(this.channels);
        sb.append(", ratingIndex=");
        sb.append(this.ratingIndex);
        sb.append(", remark='");
        sb.append(this.remark);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.options);
        sb.append(", links=");
        sb.append(this.links);
        sb.append(", footerLink=");
        sb.append(this.footerLink);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.attachments);
        parcel.writeStringList(this.items);
        parcel.writeInt(this.data.size());
        for (Entry entry : this.data.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
        BlockType blockType = this.type;
        int i3 = -1;
        parcel.writeInt(blockType == null ? -1 : blockType.ordinal());
        BlockAlignment blockAlignment = this.align;
        if (blockAlignment != null) {
            i3 = blockAlignment.ordinal();
        }
        parcel.writeInt(i3);
        parcel.writeParcelable(this.author, i2);
        parcel.writeParcelable(this.image, i2);
        parcel.writeString(this.text);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.linkType);
        parcel.writeString(this.siteName);
        parcel.writeString(this.articleId);
        parcel.writeString(this.language);
        parcel.writeString(this.url);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.trackingUrl);
        parcel.writeString(this.fallbackUrl);
        parcel.writeString(this.username);
        parcel.writeString(this.provider);
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.attribution);
        parcel.writeString(this.id);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeTypedList(this.channels);
        parcel.writeInt(this.ratingIndex);
        parcel.writeString(this.remark);
        parcel.writeTypedList(this.options);
        parcel.writeTypedList(this.links);
        parcel.writeParcelable(this.footerLink, i2);
    }

    Block() {
        this(new Builder());
    }

    private Block(Builder builder) {
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
            map = Collections.emptyMap();
        }
        this.data = map;
        String str8 = builder.language;
        if (str8 == null) {
            str8 = str2;
        }
        this.language = str8;
        String str9 = builder.url;
        if (str9 == null) {
            str9 = str2;
        }
        this.url = str9;
        String str10 = builder.thumbnailUrl;
        if (str10 == null) {
            str10 = str2;
        }
        this.thumbnailUrl = str10;
        String str11 = builder.linkUrl;
        if (str11 == null) {
            str11 = str2;
        }
        this.linkUrl = str11;
        String str12 = builder.trackingUrl;
        if (str12 == null) {
            str12 = str2;
        }
        this.trackingUrl = str12;
        String str13 = builder.fallbackUrl;
        if (str13 == null) {
            str13 = str2;
        }
        this.fallbackUrl = str13;
        String str14 = builder.username;
        if (str14 == null) {
            str14 = str2;
        }
        this.username = str14;
        String str15 = builder.provider;
        if (str15 == null) {
            str15 = str2;
        }
        this.provider = str15;
        String str16 = builder.id;
        if (str16 == null) {
            str16 = str2;
        }
        this.id = str16;
        this.align = BlockAlignment.alignValueOf(builder.align);
        Integer num = builder.width;
        int i2 = 0;
        this.width = num == null ? 0 : num.intValue();
        Integer num2 = builder.height;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        this.height = i2;
        String str17 = builder.previewUrl;
        if (str17 == null) {
            str17 = str2;
        }
        this.previewUrl = str17;
        String str18 = builder.attribution;
        if (str18 == null) {
            str18 = str2;
        }
        this.attribution = str18;
        this.attachments = new ArrayList();
        List<BlockAttachment> list = builder.attachments;
        if (list != null) {
            for (BlockAttachment blockAttachment : list) {
                if (blockAttachment != null) {
                    this.attachments.add(blockAttachment);
                }
            }
        }
        this.channels = new ArrayList();
        List<Channel> list2 = builder.channels;
        if (list2 != null) {
            for (Channel channel : list2) {
                if (channel != null) {
                    this.channels.add(channel);
                }
            }
        }
        this.items = new ArrayList();
        List<String> list3 = builder.items;
        if (list3 != null) {
            for (String str19 : list3) {
                if (str19 != null) {
                    this.items.add(str19);
                }
            }
        }
        Integer num3 = builder.ratingIndex;
        if (num3 != null) {
            this.ratingIndex = num3.intValue();
        } else {
            Integer num4 = builder.rating_index;
            if (num4 != null) {
                this.ratingIndex = num4.intValue();
            } else {
                this.ratingIndex = -1;
            }
        }
        String str20 = builder.remark;
        if (str20 == null) {
            str20 = str2;
        }
        this.remark = str20;
        this.options = new ArrayList();
        List<io.intercom.android.sdk.blocks.models.ConversationRatingOption.Builder> list4 = builder.options;
        if (list4 != null) {
            for (io.intercom.android.sdk.blocks.models.ConversationRatingOption.Builder builder2 : list4) {
                if (builder2 != null) {
                    this.options.add(builder2.build());
                }
            }
        }
        this.links = new ArrayList();
        List<Builder> list5 = builder.links;
        if (list5 != null) {
            for (Builder builder3 : list5) {
                if (builder3 != null) {
                    this.links.add(Link.fromBlock(builder3.build()));
                }
            }
        }
        Builder builder4 = builder.footerLink;
        this.footerLink = builder4 == null ? new Link() : Link.fromBlock(builder4.build());
    }

    protected Block(Parcel parcel) {
        BlockType blockType;
        this.attachments = parcel.createTypedArrayList(BlockAttachment.CREATOR);
        this.items = parcel.createStringArrayList();
        int readInt = parcel.readInt();
        this.data = new HashMap(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.data.put(parcel.readString(), parcel.readString());
        }
        int readInt2 = parcel.readInt();
        BlockAlignment blockAlignment = null;
        if (readInt2 == -1) {
            blockType = null;
        } else {
            blockType = BlockType.values()[readInt2];
        }
        this.type = blockType;
        int readInt3 = parcel.readInt();
        if (readInt3 != -1) {
            blockAlignment = BlockAlignment.values()[readInt3];
        }
        this.align = blockAlignment;
        this.author = (Author) parcel.readParcelable(Author.class.getClassLoader());
        this.image = (Image) parcel.readParcelable(Image.class.getClassLoader());
        this.text = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.linkType = parcel.readString();
        this.siteName = parcel.readString();
        this.articleId = parcel.readString();
        this.language = parcel.readString();
        this.url = parcel.readString();
        this.thumbnailUrl = parcel.readString();
        this.linkUrl = parcel.readString();
        this.trackingUrl = parcel.readString();
        this.fallbackUrl = parcel.readString();
        this.username = parcel.readString();
        this.provider = parcel.readString();
        this.previewUrl = parcel.readString();
        this.attribution = parcel.readString();
        this.id = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.channels = parcel.createTypedArrayList(Channel.CREATOR);
        this.ratingIndex = parcel.readInt();
        this.remark = parcel.readString();
        this.options = new ArrayList();
        parcel.readList(this.options, ConversationRatingOption.class.getClassLoader());
        this.links = new ArrayList();
        parcel.readList(this.links, Link.class.getClassLoader());
        this.footerLink = (Link) parcel.readParcelable(Link.class.getClassLoader());
    }
}
