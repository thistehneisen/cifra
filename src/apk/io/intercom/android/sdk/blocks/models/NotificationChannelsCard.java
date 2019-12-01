package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.blocks.BlockType;
import java.util.ArrayList;
import java.util.List;

public class NotificationChannelsCard implements Parcelable {
    public static final Creator<NotificationChannelsCard> CREATOR = new Creator<NotificationChannelsCard>() {
        public NotificationChannelsCard createFromParcel(Parcel parcel) {
            return new NotificationChannelsCard(parcel);
        }

        public NotificationChannelsCard[] newArray(int i2) {
            return new NotificationChannelsCard[i2];
        }
    };
    private final List<Channel> channels;
    private final String text;
    private final String title;
    private final BlockType type;

    public static final class Builder {
        List<Channel> channels;
        String text;
        String title;
        String type;

        public NotificationChannelsCard build() {
            return new NotificationChannelsCard(this);
        }

        public Builder withChannels(List<Channel> list) {
            this.channels = list;
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
    }

    public static NotificationChannelsCard fromBlock(Block block) {
        if (block == null) {
            return new NotificationChannelsCard();
        }
        Builder builder = new Builder();
        builder.type = block.getType().name();
        builder.title = block.getTitle();
        builder.text = block.getText();
        builder.channels = block.getChannels();
        return new NotificationChannelsCard(builder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || NotificationChannelsCard.class != obj.getClass()) {
            return false;
        }
        NotificationChannelsCard notificationChannelsCard = (NotificationChannelsCard) obj;
        if (this.type != notificationChannelsCard.type) {
            return false;
        }
        String str = this.text;
        if (str == null ? notificationChannelsCard.text != null : !str.equals(notificationChannelsCard.text)) {
            return false;
        }
        String str2 = this.title;
        if (str2 == null ? notificationChannelsCard.title != null : !str2.equals(notificationChannelsCard.title)) {
            return false;
        }
        List<Channel> list = this.channels;
        if (list != null) {
            z = list.equals(notificationChannelsCard.channels);
        } else if (notificationChannelsCard.channels != null) {
            z = false;
        }
        return z;
    }

    public List<Channel> getChannels() {
        return this.channels;
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

    public int hashCode() {
        BlockType blockType = this.type;
        int i2 = 0;
        int hashCode = (blockType != null ? blockType.hashCode() : 0) * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Channel> list = this.channels;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NotificationChannelsCard{type=");
        sb.append(this.type);
        sb.append(", text='");
        sb.append(this.text);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", channels=");
        sb.append(this.channels);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        BlockType blockType = this.type;
        parcel.writeInt(blockType == null ? -1 : blockType.ordinal());
        parcel.writeString(this.text);
        parcel.writeString(this.title);
        parcel.writeTypedList(this.channels);
    }

    NotificationChannelsCard() {
        this(new Builder());
    }

    private NotificationChannelsCard(Builder builder) {
        String str = builder.type;
        this.type = str == null ? BlockType.NOTIFICATIONCHANNELSCARD : BlockType.typeValueOf(str);
        String str2 = builder.text;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        this.text = str2;
        String str4 = builder.title;
        if (str4 == null) {
            str4 = str3;
        }
        this.title = str4;
        List<Channel> list = builder.channels;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.channels = list;
    }

    protected NotificationChannelsCard(Parcel parcel) {
        BlockType blockType;
        int readInt = parcel.readInt();
        if (readInt == -1) {
            blockType = null;
        } else {
            blockType = BlockType.values()[readInt];
        }
        this.type = blockType;
        this.text = parcel.readString();
        this.title = parcel.readString();
        this.channels = parcel.createTypedArrayList(Channel.CREATOR);
    }
}
