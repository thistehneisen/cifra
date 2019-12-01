package io.intercom.android.sdk.blocks.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ConversationRating implements Parcelable {
    public static final Creator<ConversationRating> CREATOR = new Creator<ConversationRating>() {
        public ConversationRating createFromParcel(Parcel parcel) {
            return new ConversationRating(parcel);
        }

        public ConversationRating[] newArray(int i2) {
            return new ConversationRating[i2];
        }
    };
    private final List<ConversationRatingOption> options;
    private int ratingIndex;
    private String remark;

    ConversationRating(int i2, String str, List<ConversationRatingOption> list) {
        this.ratingIndex = i2;
        this.remark = str;
        this.options = list;
    }

    public static ConversationRating fromBlock(Block block) {
        if (block != null) {
            return new ConversationRating(block.getRatingIndex(), block.getRemark(), block.getOptions());
        }
        return new ConversationRating(-1, "", new ArrayList());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || ConversationRating.class != obj.getClass()) {
            return false;
        }
        ConversationRating conversationRating = (ConversationRating) obj;
        if (this.ratingIndex != conversationRating.ratingIndex) {
            return false;
        }
        String str = this.remark;
        if (str == null ? conversationRating.remark != null : !str.equals(conversationRating.remark)) {
            return false;
        }
        List<ConversationRatingOption> list = this.options;
        if (list != null) {
            z = list.equals(conversationRating.options);
        } else if (conversationRating.options != null) {
            z = false;
        }
        return z;
    }

    public List<ConversationRatingOption> getOptions() {
        return this.options;
    }

    public Integer getRatingIndex() {
        return Integer.valueOf(this.ratingIndex);
    }

    public String getRemark() {
        return this.remark;
    }

    public int hashCode() {
        int i2 = this.ratingIndex * 31;
        String str = this.remark;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        List<ConversationRatingOption> list = this.options;
        if (list != null) {
            i3 = list.hashCode();
        }
        return hashCode + i3;
    }

    public void setRatingIndex(int i2) {
        this.ratingIndex = i2;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.ratingIndex);
        parcel.writeString(this.remark);
        parcel.writeList(this.options);
    }

    protected ConversationRating(Parcel parcel) {
        this.ratingIndex = parcel.readInt();
        this.remark = parcel.readString();
        this.options = new ArrayList();
        parcel.readList(this.options, ConversationRatingOption.class.getClassLoader());
    }
}
