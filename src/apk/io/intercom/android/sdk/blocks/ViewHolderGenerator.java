package io.intercom.android.sdk.blocks;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import e.a.a.a.a.d;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.messengercard.MessengerCard;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.blocks.models.BlockAttachment.Builder;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Attachments;
import io.intercom.android.sdk.models.Part;
import io.intercom.com.bumptech.glide.n;
import io.intercom.com.google.gson.o;
import java.util.ArrayList;
import java.util.List;

public class ViewHolderGenerator {
    private final Activity activity;
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final d bus;
    private final ButtonClickListener buttonClickListener;
    private final String conversationId;
    private final o gson;
    private final ImageClickListener imageListener;
    private final MetricTracker metricTracker;
    private final n requestManager;
    private final UploadingImageCache uploadingImageCache;

    public ViewHolderGenerator(UploadingImageCache uploadingImageCache2, Api api2, Provider<AppConfig> provider, String str, ImageClickListener imageClickListener, ButtonClickListener buttonClickListener2, n nVar, o oVar, d dVar, MetricTracker metricTracker2, Activity activity2) {
        this.uploadingImageCache = uploadingImageCache2;
        this.api = api2;
        this.appConfigProvider = provider;
        this.conversationId = str;
        this.imageListener = imageClickListener;
        this.buttonClickListener = buttonClickListener2;
        this.requestManager = nVar;
        this.gson = oVar;
        this.bus = dVar;
        this.metricTracker = metricTracker2;
        this.activity = activity2;
    }

    public static LinearLayout createLayoutFromBlocks(BlocksViewHolder blocksViewHolder, List<Block> list, Context context) {
        return new Blocks(context, LumberMill.getBlocksTwig()).createBlocks(list, blocksViewHolder);
    }

    public static LinearLayout createPartsLayout(BlocksViewHolder blocksViewHolder, Part part, Context context) {
        List blocks = part.getBlocks();
        if (!part.getAttachments().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Attachments attachments : part.getAttachments()) {
                arrayList.add(new Builder().withName(attachments.getName()).withUrl(attachments.getUrl()).build());
            }
            blocks.add(new Block.Builder().withType(BlockType.ATTACHMENTLIST.name()).withAttachments(arrayList).build());
        }
        return new Blocks(context, LumberMill.getBlocksTwig()).createBlocks(blocks, blocksViewHolder);
    }

    private BlocksViewHolder generateHolder(int i2, StyleType styleType) {
        BlocksViewHolder blocksViewHolder = new BlocksViewHolder();
        Button button = new Button(styleType, this.appConfigProvider, this.buttonClickListener);
        Heading heading = new Heading(styleType, this.appConfigProvider);
        ListBlock listBlock = new ListBlock(styleType, this.appConfigProvider);
        Attachment attachment = new Attachment(styleType, this.appConfigProvider);
        blocksViewHolder.setLayout(i2);
        blocksViewHolder.setParagraph(new Paragraph(styleType, this.appConfigProvider));
        blocksViewHolder.setHeading(heading);
        blocksViewHolder.setSubheading(heading);
        blocksViewHolder.setCode(new Code());
        blocksViewHolder.setUnorderedList(listBlock);
        blocksViewHolder.setOrderedList(listBlock);
        blocksViewHolder.setImage(new NetworkImage(styleType, this.uploadingImageCache, this.imageListener, this.requestManager));
        blocksViewHolder.setLocalImage(new LocalImage(styleType, this.requestManager));
        blocksViewHolder.setButton(button);
        blocksViewHolder.setAttachmentList(attachment);
        blocksViewHolder.setLocalAttachment(attachment);
        blocksViewHolder.setTwitterButton(button);
        blocksViewHolder.setFacebookButton(button);
        blocksViewHolder.setVideo(new Video(styleType, this.api, this.appConfigProvider, this.requestManager));
        blocksViewHolder.setVideoFile(new VideoFile(styleType, this.appConfigProvider, this.requestManager, this.metricTracker));
        blocksViewHolder.setLink(new LinkCard(styleType, this.appConfigProvider, this.conversationId, this.requestManager));
        blocksViewHolder.setConversationRating(new ConversationRatingCard(this.api, this.conversationId, this.appConfigProvider, this.requestManager));
        blocksViewHolder.setLinkList(new LinkListRenderer(this.api, this.appConfigProvider, this.conversationId));
        if (!styleType.equals(StyleType.CHAT_FULL)) {
            MessengerCard messengerCard = new MessengerCard(this.appConfigProvider, this.gson, this.bus, this.metricTracker, this.conversationId, styleType, this.activity);
            blocksViewHolder.setMessengerCardBlock(messengerCard);
        }
        return blocksViewHolder;
    }

    public BlocksViewHolder getAdminHolder() {
        return generateHolder(R.layout.intercom_blocks_admin_layout, StyleType.ADMIN);
    }

    public BlocksViewHolder getArticleHolder() {
        return generateHolder(R.layout.intercom_blocks_article_layout, StyleType.ARTICLE);
    }

    public BlocksViewHolder getChatFullHolder() {
        return generateHolder(R.layout.intercom_blocks_admin_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getContainerCardHolder() {
        return generateHolder(R.layout.intercom_blocks_container_card_layout, StyleType.CONTAINER_CARD);
    }

    public BlocksViewHolder getConversationRatingHolder() {
        return generateHolder(R.layout.intercom_blocks_container_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getLinkHolder() {
        return generateHolder(R.layout.intercom_blocks_container_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getLinkListHolder() {
        return generateHolder(R.layout.intercom_blocks_container_card_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getNoteHolder() {
        return generateHolder(R.layout.intercom_blocks_note_layout, StyleType.NOTE);
    }

    public BlocksViewHolder getPostHolder() {
        return generateHolder(R.layout.intercom_blocks_container_layout, StyleType.POST);
    }

    public BlocksViewHolder getPreviewHolder() {
        return generateHolder(R.layout.intercom_blocks_user_layout, StyleType.PREVIEW);
    }

    public BlocksViewHolder getUserHolder() {
        return generateHolder(R.layout.intercom_blocks_user_layout, StyleType.USER);
    }
}
