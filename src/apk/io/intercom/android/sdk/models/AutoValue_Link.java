package io.intercom.android.sdk.models;

import io.intercom.android.sdk.blocks.models.Block;
import java.util.List;

final class AutoValue_Link extends Link {
    private final List<Block> blocks;
    private final Card card;
    private final long createdAt;
    private final String id;
    private final ReactionReply reactionReply;
    private final long updatedAt;

    AutoValue_Link(String str, Card card2, List<Block> list, ReactionReply reactionReply2, long j2, long j3) {
        if (str != null) {
            this.id = str;
            if (card2 != null) {
                this.card = card2;
                if (list != null) {
                    this.blocks = list;
                    if (reactionReply2 != null) {
                        this.reactionReply = reactionReply2;
                        this.createdAt = j2;
                        this.updatedAt = j3;
                        return;
                    }
                    throw new NullPointerException("Null reactionReply");
                }
                throw new NullPointerException("Null blocks");
            }
            throw new NullPointerException("Null card");
        }
        throw new NullPointerException("Null id");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        if (!this.id.equals(link.getId()) || !this.card.equals(link.getCard()) || !this.blocks.equals(link.getBlocks()) || !this.reactionReply.equals(link.getReactionReply()) || this.createdAt != link.getCreatedAt() || this.updatedAt != link.getUpdatedAt()) {
            z = false;
        }
        return z;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public Card getCard() {
        return this.card;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getId() {
        return this.id;
    }

    public ReactionReply getReactionReply() {
        return this.reactionReply;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int hashCode = (((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.card.hashCode()) * 1000003) ^ this.blocks.hashCode()) * 1000003) ^ this.reactionReply.hashCode()) * 1000003;
        long j2 = this.createdAt;
        int i2 = (hashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.updatedAt;
        return i2 ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Link{id=");
        sb.append(this.id);
        sb.append(", card=");
        sb.append(this.card);
        sb.append(", blocks=");
        sb.append(this.blocks);
        sb.append(", reactionReply=");
        sb.append(this.reactionReply);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append("}");
        return sb.toString();
    }
}
