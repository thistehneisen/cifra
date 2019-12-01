package io.intercom.android.sdk.models;

import io.intercom.android.sdk.blocks.models.Author;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.commons.utilities.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Link {
    public static final String ARTICLE_TYPE = "educate.article";
    public static final String HELP_CENTER_TYPE = "educate.help_center";
    public static final String SUGGESTION_TYPE = "educate.suggestion";

    public static final class Builder {
        List<io.intercom.android.sdk.blocks.models.Block.Builder> blocks;
        io.intercom.android.sdk.models.Card.Builder card;
        long created_at;
        String id;
        io.intercom.android.sdk.models.ReactionReply.Builder reactions_reply;
        long updated_at;

        public Link build() {
            ReactionReply reactionReply;
            String str = this.id;
            if (str == null) {
                str = UUID.randomUUID().toString();
            }
            String str2 = str;
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.blocks));
            List<io.intercom.android.sdk.blocks.models.Block.Builder> list = this.blocks;
            if (list != null) {
                for (io.intercom.android.sdk.blocks.models.Block.Builder builder : list) {
                    if (builder != null) {
                        arrayList.add(builder.build());
                    }
                }
            }
            io.intercom.android.sdk.models.ReactionReply.Builder builder2 = this.reactions_reply;
            if (builder2 == null) {
                reactionReply = ReactionReply.NULL;
            } else {
                reactionReply = builder2.build();
            }
            ReactionReply reactionReply2 = reactionReply;
            io.intercom.android.sdk.models.Card.Builder builder3 = this.card;
            if (builder3 == null) {
                builder3 = new io.intercom.android.sdk.models.Card.Builder();
            }
            AutoValue_Link autoValue_Link = new AutoValue_Link(str2, builder3.build(), arrayList, reactionReply2, this.created_at, this.updated_at);
            return autoValue_Link;
        }
    }

    public Author getAuthor() {
        return getCard().getAuthor();
    }

    public abstract List<Block> getBlocks();

    public abstract Card getCard();

    public abstract long getCreatedAt();

    public String getDescription() {
        return getCard().getDescription();
    }

    public abstract String getId();

    public abstract ReactionReply getReactionReply();

    public String getText() {
        return getCard().getText();
    }

    public String getTitle() {
        return getCard().getTitle();
    }

    public String getType() {
        return getCard().getType();
    }

    public abstract long getUpdatedAt();
}
