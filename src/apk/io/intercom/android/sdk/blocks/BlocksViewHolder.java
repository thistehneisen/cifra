package io.intercom.android.sdk.blocks;

import io.intercom.android.sdk.blocks.blockInterfaces.AttachmentListBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.ButtonBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.CodeBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.ConversationRatingBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.FacebookBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.HeadingBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.ImageBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.LightWeightReplyBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.LinkBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.LinkListBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.LocalAttachmentBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.LocalImageBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.MessengerCardBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.NotificationChannelsCardBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.OrderedListBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.ParagraphBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.SubheadingBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.TwitterBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.UnorderedListBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.VideoBlock;
import io.intercom.android.sdk.blocks.blockInterfaces.VideoFileBlock;

public class BlocksViewHolder {
    private AttachmentListBlock attachmentList;
    private ButtonBlock button;
    private CodeBlock code;
    private ConversationRatingBlock conversationRating;
    private FacebookBlock facebookButton;
    private HeadingBlock heading;
    private ImageBlock image;
    private int layout;
    private LinkBlock link;
    private LinkListBlock linkList;
    private LocalAttachmentBlock localAttachment;
    private LocalImageBlock localImage;
    private LightWeightReplyBlock lwr;
    private MessengerCardBlock messengerCardBlock;
    private NotificationChannelsCardBlock notificationChannelsCard;
    private OrderedListBlock orderedList;
    private ParagraphBlock paragraph;
    private SubheadingBlock subheading;
    private TwitterBlock twitterButton;
    private UnorderedListBlock unorderedList;
    private VideoBlock video;
    private VideoFileBlock videoFile;

    public AttachmentListBlock getAttachmentList() {
        return this.attachmentList;
    }

    public ButtonBlock getButton() {
        return this.button;
    }

    public CodeBlock getCode() {
        return this.code;
    }

    public ConversationRatingBlock getConversationRating() {
        return this.conversationRating;
    }

    public FacebookBlock getFacebookButton() {
        return this.facebookButton;
    }

    public HeadingBlock getHeading() {
        return this.heading;
    }

    public ImageBlock getImage() {
        return this.image;
    }

    public int getLayout() {
        return this.layout;
    }

    public LinkBlock getLink() {
        return this.link;
    }

    public LinkListBlock getLinkList() {
        return this.linkList;
    }

    public LocalAttachmentBlock getLocalAttachment() {
        return this.localAttachment;
    }

    public LocalImageBlock getLocalImage() {
        return this.localImage;
    }

    public LightWeightReplyBlock getLwr() {
        return this.lwr;
    }

    public MessengerCardBlock getMessengerCardBlock() {
        return this.messengerCardBlock;
    }

    public NotificationChannelsCardBlock getNotificationChannelsCard() {
        return this.notificationChannelsCard;
    }

    public OrderedListBlock getOrderedList() {
        return this.orderedList;
    }

    public ParagraphBlock getParagraph() {
        return this.paragraph;
    }

    public SubheadingBlock getSubheading() {
        return this.subheading;
    }

    public TwitterBlock getTwitterButton() {
        return this.twitterButton;
    }

    public UnorderedListBlock getUnorderedList() {
        return this.unorderedList;
    }

    public VideoBlock getVideo() {
        return this.video;
    }

    public VideoFileBlock getVideoFile() {
        return this.videoFile;
    }

    public void setAttachmentList(AttachmentListBlock attachmentListBlock) {
        this.attachmentList = attachmentListBlock;
    }

    public void setButton(ButtonBlock buttonBlock) {
        this.button = buttonBlock;
    }

    public void setCode(CodeBlock codeBlock) {
        this.code = codeBlock;
    }

    public void setConversationRating(ConversationRatingBlock conversationRatingBlock) {
        this.conversationRating = conversationRatingBlock;
    }

    public void setFacebookButton(FacebookBlock facebookBlock) {
        this.facebookButton = facebookBlock;
    }

    public void setHeading(HeadingBlock headingBlock) {
        this.heading = headingBlock;
    }

    public void setImage(ImageBlock imageBlock) {
        this.image = imageBlock;
    }

    public void setLayout(int i2) {
        this.layout = i2;
    }

    public void setLink(LinkBlock linkBlock) {
        this.link = linkBlock;
    }

    public void setLinkList(LinkListBlock linkListBlock) {
        this.linkList = linkListBlock;
    }

    public void setLocalAttachment(LocalAttachmentBlock localAttachmentBlock) {
        this.localAttachment = localAttachmentBlock;
    }

    public void setLocalImage(LocalImageBlock localImageBlock) {
        this.localImage = localImageBlock;
    }

    public void setLwr(LightWeightReplyBlock lightWeightReplyBlock) {
        this.lwr = lightWeightReplyBlock;
    }

    public void setMessengerCardBlock(MessengerCardBlock messengerCardBlock2) {
        this.messengerCardBlock = messengerCardBlock2;
    }

    public void setNotificationChannelsCard(NotificationChannelsCardBlock notificationChannelsCardBlock) {
        this.notificationChannelsCard = notificationChannelsCardBlock;
    }

    public void setOrderedList(OrderedListBlock orderedListBlock) {
        this.orderedList = orderedListBlock;
    }

    public void setParagraph(ParagraphBlock paragraphBlock) {
        this.paragraph = paragraphBlock;
    }

    public void setSubheading(SubheadingBlock subheadingBlock) {
        this.subheading = subheadingBlock;
    }

    public void setTwitterButton(TwitterBlock twitterBlock) {
        this.twitterButton = twitterBlock;
    }

    public void setUnorderedList(UnorderedListBlock unorderedListBlock) {
        this.unorderedList = unorderedListBlock;
    }

    public void setVideo(VideoBlock videoBlock) {
        this.video = videoBlock;
    }

    public void setVideoFile(VideoFileBlock videoFileBlock) {
        this.videoFile = videoFileBlock;
    }
}
