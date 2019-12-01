package io.intercom.android.sdk.blocks;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.blocks.blockInterfaces.TwitterBlock;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.blocks.models.BlockAttachment;
import io.intercom.android.sdk.blocks.models.ConversationRating;
import io.intercom.android.sdk.blocks.models.Link;
import io.intercom.android.sdk.blocks.models.LinkList;
import io.intercom.android.sdk.blocks.models.NotificationChannelsCard;
import io.intercom.android.sdk.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.Locale;

public enum BlockType {
    PARAGRAPH("paragraph") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getParagraph().addParagraph(HtmlCompat.fromHtml(block.getText()), block.getAlign(), z, z2, viewGroup);
        }
    },
    HEADING("heading") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getHeading().addHeading(HtmlCompat.fromHtml(block.getText()), block.getAlign(), z, z2, viewGroup);
        }
    },
    SUBHEADING("subheading") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getSubheading().addSubheading(HtmlCompat.fromHtml(block.getText()), block.getAlign(), z, z2, viewGroup);
        }
    },
    CODE("code") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getCode().addCode(HtmlCompat.fromHtml(block.getText()), z, z2, viewGroup);
        }
    },
    LINK("link") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getLink().addLinkBlock(Link.fromBlock(block), z, z2, viewGroup);
        }
    },
    CONVERSATIONRATING("conversationRating") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getConversationRating().addConversationRatingBlock(ConversationRating.fromBlock(block), z, z2, viewGroup);
        }
    },
    NOTIFICATIONCHANNELSCARD("notificationChannelCard") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getNotificationChannelsCard().addNotificationChannelsCardBlock(NotificationChannelsCard.fromBlock(block), z, z2, viewGroup);
        }
    },
    LINKLIST("linkList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getLinkList().addLinkListBlock(LinkList.fromBlock(block), z, z2, viewGroup);
        }
    },
    UNORDEREDLIST("unorderedList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getUnorderedList().addUnorderedList(block.getItems(), z, z2, viewGroup);
        }
    },
    ORDEREDLIST("orderedList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getOrderedList().addOrderedList(block.getItems(), z, z2, viewGroup);
        }
    },
    ATTACHMENTLIST("attachmentList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getAttachmentList().addAttachmentList(block.getAttachments(), z, z2, viewGroup);
        }
    },
    IMAGE("image") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getImage().addImage(block.getUrl(), BlockType.getUrl(block), block.getWidth(), block.getHeight(), block.getAlign(), z, z2, viewGroup);
        }
    },
    LWR("lwr") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getLwr().addLWR(block.getText(), z, z2, viewGroup);
        }
    },
    BUTTON("button") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getButton().addButton(block.getText(), BlockType.getUrl(block), block.getAlign(), z, z2, viewGroup);
        }
    },
    FACEBOOKLIKEBUTTON("facebookLikeButton") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getFacebookButton().addFacebookButton(block.getUrl(), block.getAlign(), z, z2, viewGroup);
        }
    },
    TWITTERFOLLOWBUTTON("twitterFollowButton") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            TwitterBlock twitterButton = blocksViewHolder.getTwitterButton();
            StringBuilder sb = new StringBuilder();
            sb.append("https://twitter.com/");
            sb.append(block.getUsername());
            return twitterButton.addTwitterButton(sb.toString(), block.getAlign(), z, z2, viewGroup);
        }
    },
    VIDEO("video") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getVideo().addVideo(block.getText(), VideoProvider.videoValueOf(block.getProvider()), block.getId(), z, z2, viewGroup);
        }
    },
    VIDEOFILE("videoFile") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getVideoFile().addVideoFile(block.getText(), block.getUrl(), block.getThumbnailUrl(), z, z2, viewGroup);
        }
    },
    MESSENGERCARD("messengerCard") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getMessengerCardBlock().addCard(block.getText(), block.getFallbackUrl(), z, z2, viewGroup);
        }
    },
    LOCALIMAGE("localImage") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getLocalImage().addImage(block.getUrl(), block.getWidth(), block.getHeight(), block.getAlign(), z, z2, viewGroup);
        }
    },
    LOCAL_ATTACHMENT("local_attachment") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            return blocksViewHolder.getLocalAttachment().addAttachment((BlockAttachment) block.getAttachments().get(0), z, z2, viewGroup);
        }
    },
    UNKNOWN(AttributeType.UNKNOWN) {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) {
            if (!block.getText().isEmpty() && blocksViewHolder.getParagraph() != null) {
                return BlockType.PARAGRAPH.generateViewFromBlockAndLayout(blocksViewHolder, block, viewGroup, z, z2);
            }
            throw new BlockTypeNotImplementedException();
        }
    };
    
    private final String serializedName;

    protected static String getUrl(Block block) {
        return block.getTrackingUrl().isEmpty() ? block.getLinkUrl() : block.getTrackingUrl();
    }

    public static BlockType typeValueOf(String str) {
        try {
            return valueOf(str.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException | NullPointerException unused) {
            return UNKNOWN;
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2);

    public String getSerializedName() {
        return this.serializedName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        return UNKNOWN.generateViewFromBlockAndLayout(r7, r8, r9, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        throw new io.intercom.android.sdk.blocks.BlockTypeNotImplementedException();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    public View getView(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, boolean z, boolean z2) throws BlockTypeNotImplementedException {
        return generateViewFromBlockAndLayout(blocksViewHolder, block, viewGroup, z, z2);
    }

    private BlockType(String str) {
        this.serializedName = str;
    }
}
