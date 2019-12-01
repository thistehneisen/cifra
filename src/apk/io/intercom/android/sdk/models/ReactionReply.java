package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.commons.utilities.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class ReactionReply implements Parcelable {
    public static final Creator<ReactionReply> CREATOR = new Creator<ReactionReply>() {
        public ReactionReply createFromParcel(Parcel parcel) {
            return new ReactionReply(parcel);
        }

        public ReactionReply[] newArray(int i2) {
            return new ReactionReply[i2];
        }
    };
    public static final ReactionReply NULL = new ReactionReply(new Builder());
    private Integer reactionIndex;
    private final List<Reaction> reactionSet;

    public static class Builder {
        Integer reaction_index;
        List<io.intercom.android.sdk.models.Reaction.Builder> reaction_set;

        public ReactionReply build() {
            return new ReactionReply(this);
        }
    }

    ReactionReply(Builder builder) {
        this.reactionIndex = builder.reaction_index;
        this.reactionSet = new ArrayList(CollectionUtils.capacityFor(builder.reaction_set));
        List<io.intercom.android.sdk.models.Reaction.Builder> list = builder.reaction_set;
        if (list != null) {
            for (io.intercom.android.sdk.models.Reaction.Builder build : list) {
                this.reactionSet.add(build.build());
            }
        }
    }

    public static boolean isNull(ReactionReply reactionReply) {
        return NULL.equals(reactionReply) || reactionReply == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || ReactionReply.class != obj.getClass()) {
            return false;
        }
        ReactionReply reactionReply = (ReactionReply) obj;
        if (!this.reactionSet.equals(reactionReply.reactionSet)) {
            return false;
        }
        Integer num = this.reactionIndex;
        if (num != null) {
            z = num.equals(reactionReply.reactionIndex);
        } else if (reactionReply.reactionIndex != null) {
            z = false;
        }
        return z;
    }

    public Integer getReactionIndex() {
        return this.reactionIndex;
    }

    public List<Reaction> getReactionSet() {
        return this.reactionSet;
    }

    public int hashCode() {
        int hashCode = this.reactionSet.hashCode() * 31;
        Integer num = this.reactionIndex;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public void setReactionIndex(int i2) {
        this.reactionIndex = Integer.valueOf(i2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (this.reactionIndex == null) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeInt(this.reactionIndex.intValue());
        }
        parcel.writeList(this.reactionSet);
    }

    ReactionReply(Parcel parcel) {
        this.reactionIndex = parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt());
        this.reactionSet = new ArrayList();
        parcel.readList(this.reactionSet, Reaction.class.getClassLoader());
    }
}
