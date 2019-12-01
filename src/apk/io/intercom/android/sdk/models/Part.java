package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.annotations.SeenState;
import io.intercom.android.sdk.blocks.BlockType;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Part implements Parcelable {
    public static final String ADMIN_IS_TYPING_STYLE = "admin_is_typing_style";
    public static final String ATTRIBUTE_COLLECTOR_STYLE = "attribute_collector";
    public static final String CHAT_MESSAGE_STYLE = "chat";
    public static final Creator<Part> CREATOR = new Creator<Part>() {
        public Part createFromParcel(Parcel parcel) {
            return new Part(parcel);
        }

        public Part[] newArray(int i2) {
            return new Part[i2];
        }
    };
    public static final String DAY_DIVIDER_STYLE = "day_divider_style";
    public static final String LEGACY_ANNOUNCEMENT_STYLE = "announcement";
    public static final String LEGACY_SMALL_ANNOUNCEMENT_STYLE = "small-announcement";
    public static final String LOADING_LAYOUT = "loading_layout_style";
    public static final String NOTE_MESSAGE_STYLE = "note";
    public static final Part NULL = new Part(new Builder());
    public static final String POST_MESSAGE_STYLE = "post";
    public static final String QUICK_REPLY_STYLE = "quick_reply";
    private final List<Attachments> attachments;
    private final List<Block> blocks;
    private final long createdAt;
    private final DeliveryOption deliveryOption;
    private boolean displayDelivered;
    private boolean entranceAnimation;
    private final EventData eventData;
    private final Form form;
    private final String id;
    private final boolean isInitialMessage;
    private MessageState messageState;
    private final String messageStyle;
    private Participant participant;
    private String participantId;
    private final boolean participantIsAdmin;
    private final ReactionReply reactionReply;
    private final List<ReplyOption> replyOptions;
    private String seenByAdmin;
    private final String summary;
    private GalleryImage uploadImage;

    public static final class Builder {
        List<io.intercom.android.sdk.models.Attachments.Builder> attachments;
        List<io.intercom.android.sdk.blocks.models.Block.Builder> body;
        long created_at;
        String delivery_option;
        io.intercom.android.sdk.models.EventData.Builder event_data;
        io.intercom.android.sdk.models.Form.Builder form;
        String id;
        boolean is_initial_message;
        String message_style;
        String participant_id;
        boolean participant_is_admin;
        io.intercom.android.sdk.models.ReactionReply.Builder reactions_reply;
        List<io.intercom.android.sdk.models.ReplyOption.Builder> reply_options;
        String seen_by_admin;
        String summary;

        public Part build() {
            return new Part(this);
        }

        public Builder withBlocks(List<io.intercom.android.sdk.blocks.models.Block.Builder> list) {
            this.body = list;
            return this;
        }

        public Builder withCreatedAt(long j2) {
            this.created_at = j2;
            return this;
        }

        public Builder withForm(io.intercom.android.sdk.models.Form.Builder builder) {
            this.form = builder;
            return this;
        }

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withParticipantIsAdmin(boolean z) {
            this.participant_is_admin = z;
            return this;
        }

        public Builder withReplyOptions(List<io.intercom.android.sdk.models.ReplyOption.Builder> list) {
            this.reply_options = list;
            return this;
        }

        public Builder withStyle(String str) {
            this.message_style = str;
            return this;
        }
    }

    public enum DeliveryOption {
        FULL,
        SUMMARY,
        BADGE
    }

    public enum MessageState {
        SENDING,
        FAILED,
        UPLOAD_FAILED,
        NORMAL
    }

    private static DeliveryOption convertDeliveryOption(String str) {
        if (str == null) {
            return DeliveryOption.SUMMARY;
        }
        try {
            return DeliveryOption.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException unused) {
            return DeliveryOption.SUMMARY;
        }
    }

    static String convertLegacyMessageStyle(String str) {
        if (LEGACY_ANNOUNCEMENT_STYLE.equals(str)) {
            return POST_MESSAGE_STYLE;
        }
        if (LEGACY_SMALL_ANNOUNCEMENT_STYLE.equals(str)) {
            return NOTE_MESSAGE_STYLE;
        }
        String str2 = ADMIN_IS_TYPING_STYLE;
        if (str2.equals(str)) {
            return str2;
        }
        String str3 = DAY_DIVIDER_STYLE;
        if (str3.equals(str)) {
            return str3;
        }
        String str4 = LOADING_LAYOUT;
        if (str4.equals(str)) {
            return str4;
        }
        String str5 = "quick_reply";
        if (str5.equals(str)) {
            return str5;
        }
        String str6 = ATTRIBUTE_COLLECTOR_STYLE;
        return str6.equals(str) ? str6 : CHAT_MESSAGE_STYLE;
    }

    private static boolean nextPartFromSameParticipant(Part part, Part part2) {
        return part.getParticipantId().equals(part2.getParticipantId());
    }

    public static boolean shouldConcatenate(Part part, Part part2) {
        if (DAY_DIVIDER_STYLE.equals(part.getMessageStyle()) || part.isLinkCard() || part.isEvent().booleanValue() || part2.isEvent().booleanValue() || part2.isQuickReplyOnly().booleanValue() || Math.abs(part2.getCreatedAt() - part.getCreatedAt()) >= TimeUnit.MINUTES.toSeconds(3) || !nextPartFromSameParticipant(part, part2) || part2.getCreatedAt() == 0) {
            return false;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Part)) {
            return false;
        }
        return this.id.equals(((Part) obj).id);
    }

    public List<Attachments> getAttachments() {
        return this.attachments;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public DeliveryOption getDeliveryOption() {
        return this.deliveryOption;
    }

    public EventData getEventData() {
        return this.eventData;
    }

    public Form getForm() {
        return this.form;
    }

    public String getId() {
        return this.id;
    }

    public Block getLinkBlock() {
        return (Block) this.blocks.get(0);
    }

    public MessageState getMessageState() {
        return this.messageState;
    }

    public String getMessageStyle() {
        return this.messageStyle;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public String getParticipantId() {
        return this.participantId;
    }

    public ReactionReply getReactionReply() {
        return this.reactionReply;
    }

    public List<ReplyOption> getReplyOptions() {
        return this.replyOptions;
    }

    public String getSeenByAdmin() {
        return this.participantIsAdmin ? SeenState.HIDE : this.seenByAdmin;
    }

    public String getSummary() {
        return this.summary;
    }

    public GalleryImage getUpload() {
        return this.uploadImage;
    }

    public boolean hasAttachments() {
        return !this.attachments.isEmpty();
    }

    public boolean hasEntranceAnimation() {
        return this.entranceAnimation;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean isAdmin() {
        return this.participantIsAdmin;
    }

    public boolean isDisplayDelivered() {
        return this.displayDelivered;
    }

    public Boolean isEvent() {
        return Boolean.valueOf(!this.eventData.getEventAsPlainText().isEmpty());
    }

    public boolean isGifOnlyPart() {
        return this.blocks.size() == 1 && !TextUtils.isEmpty(((Block) this.blocks.get(0)).getAttribution());
    }

    public boolean isInitialMessage() {
        return this.isInitialMessage;
    }

    public boolean isLinkCard() {
        if (isSingleBlockPartOfType(BlockType.LINK)) {
            if (CHAT_MESSAGE_STYLE.equals(this.messageStyle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLinkList() {
        if (isSingleBlockPartOfType(BlockType.LINKLIST)) {
            if (CHAT_MESSAGE_STYLE.equals(this.messageStyle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMessagePart() {
        if (!POST_MESSAGE_STYLE.equals(this.messageStyle)) {
            if (!NOTE_MESSAGE_STYLE.equals(this.messageStyle)) {
                if (!CHAT_MESSAGE_STYLE.equals(this.messageStyle)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public Boolean isQuickReplyOnly() {
        return Boolean.valueOf(this.replyOptions.size() > 0 && this.blocks.size() == 0);
    }

    public boolean isReply() {
        return !this.isInitialMessage;
    }

    public boolean isSendingPart() {
        return getMessageState().equals(MessageState.SENDING);
    }

    public boolean isSingleBlockPartOfType(BlockType blockType) {
        return this.blocks.size() == 1 && ((Block) this.blocks.get(0)).getType() == blockType;
    }

    public boolean isUser() {
        return !isAdmin();
    }

    public void setDisplayDelivered(boolean z) {
        this.displayDelivered = z;
    }

    public void setEntranceAnimation(boolean z) {
        this.entranceAnimation = z;
    }

    public void setMessageState(MessageState messageState2) {
        this.messageState = messageState2;
    }

    public void setParticipant(Participant participant2) {
        this.participant = participant2;
        this.participantId = participant2.getId();
    }

    public void setSeenByAdmin(String str) {
        this.seenByAdmin = str;
    }

    public void setUpload(GalleryImage galleryImage) {
        this.uploadImage = galleryImage;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.participantId);
        parcel.writeByte(this.participantIsAdmin ? (byte) 1 : 0);
        parcel.writeList(this.blocks);
        parcel.writeList(this.attachments);
        parcel.writeList(this.replyOptions);
        parcel.writeString(this.messageStyle);
        parcel.writeLong(this.createdAt);
        parcel.writeString(this.summary);
        if (ReactionReply.isNull(this.reactionReply)) {
            parcel.writeByte(0);
        } else {
            parcel.writeByte(1);
            parcel.writeValue(this.reactionReply);
        }
        parcel.writeString(this.seenByAdmin);
        parcel.writeValue(this.participant);
        parcel.writeValue(this.eventData);
        parcel.writeByte(this.isInitialMessage ? (byte) 1 : 0);
        parcel.writeString(this.deliveryOption.name());
        parcel.writeValue(this.form);
    }

    public Part() {
        this(new Builder());
    }

    private Part(Builder builder) {
        ReactionReply reactionReply2;
        String str = builder.id;
        if (str == null) {
            str = UUID.randomUUID().toString();
        }
        this.id = str;
        this.participantId = NullSafety.valueOrEmpty(builder.participant_id);
        this.participantIsAdmin = builder.participant_is_admin;
        this.summary = NullSafety.valueOrEmpty(builder.summary);
        this.createdAt = builder.created_at;
        this.messageStyle = convertLegacyMessageStyle(builder.message_style);
        this.deliveryOption = convertDeliveryOption(builder.delivery_option);
        this.blocks = new ArrayList();
        List<io.intercom.android.sdk.blocks.models.Block.Builder> list = builder.body;
        if (list != null) {
            for (io.intercom.android.sdk.blocks.models.Block.Builder build : list) {
                this.blocks.add(build.build());
            }
        }
        io.intercom.android.sdk.models.ReactionReply.Builder builder2 = builder.reactions_reply;
        if (builder2 == null) {
            reactionReply2 = ReactionReply.NULL;
        } else {
            reactionReply2 = builder2.build();
        }
        this.reactionReply = reactionReply2;
        String str2 = builder.seen_by_admin;
        if (str2 == null) {
            str2 = SeenState.HIDE;
        }
        this.seenByAdmin = str2;
        this.attachments = new ArrayList();
        List<io.intercom.android.sdk.models.Attachments.Builder> list2 = builder.attachments;
        if (list2 != null) {
            for (io.intercom.android.sdk.models.Attachments.Builder build2 : list2) {
                this.attachments.add(build2.build());
            }
        }
        io.intercom.android.sdk.models.EventData.Builder builder3 = builder.event_data;
        this.eventData = builder3 == null ? EventData.NULL : builder3.build();
        this.participant = Participant.NULL;
        this.displayDelivered = false;
        this.entranceAnimation = false;
        this.isInitialMessage = builder.is_initial_message;
        this.messageState = MessageState.NORMAL;
        this.replyOptions = new ArrayList();
        List<io.intercom.android.sdk.models.ReplyOption.Builder> list3 = builder.reply_options;
        if (list3 != null) {
            for (io.intercom.android.sdk.models.ReplyOption.Builder build3 : list3) {
                this.replyOptions.add(build3.build());
            }
        }
        io.intercom.android.sdk.models.Form.Builder builder4 = builder.form;
        this.form = builder4 == null ? Form.NULL : builder4.build();
    }

    private Part(Parcel parcel) {
        this.id = parcel.readString();
        this.participantId = parcel.readString();
        boolean z = true;
        this.participantIsAdmin = parcel.readByte() != 0;
        this.blocks = new ArrayList();
        parcel.readList(this.blocks, Block.class.getClassLoader());
        this.attachments = new ArrayList();
        parcel.readList(this.attachments, Attachments.class.getClassLoader());
        this.replyOptions = new ArrayList();
        parcel.readList(this.replyOptions, ReplyOption.class.getClassLoader());
        this.messageStyle = parcel.readString();
        this.createdAt = parcel.readLong();
        this.summary = parcel.readString();
        if (parcel.readByte() == 0) {
            this.reactionReply = ReactionReply.NULL;
        } else {
            this.reactionReply = (ReactionReply) parcel.readValue(ReactionReply.class.getClassLoader());
        }
        this.seenByAdmin = parcel.readString();
        this.participant = (Participant) parcel.readValue(Participant.class.getClassLoader());
        this.eventData = (EventData) parcel.readValue(EventData.class.getClassLoader());
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.isInitialMessage = z;
        this.deliveryOption = convertDeliveryOption(parcel.readString());
        this.form = (Form) parcel.readValue(Form.class.getClassLoader());
    }
}
