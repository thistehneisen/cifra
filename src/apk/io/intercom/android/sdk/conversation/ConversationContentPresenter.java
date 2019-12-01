package io.intercom.android.sdk.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.app.C0146m.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.X;
import b.d.b;
import com.intercom.input.gallery.GalleryImage;
import e.a.a.a.a.d;
import e.a.a.a.a.k;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.annotations.SeenState;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.BlockType;
import io.intercom.android.sdk.blocks.Blocks;
import io.intercom.android.sdk.blocks.BlocksViewHolder;
import io.intercom.android.sdk.blocks.LightboxOpeningImageClickListener;
import io.intercom.android.sdk.blocks.LinkOpeningButtonClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.blocks.function.TimestampAdder;
import io.intercom.android.sdk.blocks.models.Author;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.blocks.models.BlockAttachment;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.conversation.IntercomLinkPresenter.IntercomLinkHost;
import io.intercom.android.sdk.conversation.attribute.AttributeAnimateEndListener;
import io.intercom.android.sdk.conversation.events.AdminIsTypingEvent;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.models.Attachments;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.Builder;
import io.intercom.android.sdk.models.Part.MessageState;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.models.events.FormSubmitSuccessEvent;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import io.intercom.android.sdk.models.events.ReplyEvent;
import io.intercom.android.sdk.models.events.UploadEvent;
import io.intercom.android.sdk.models.events.failure.FormSubmitFailedEvent;
import io.intercom.android.sdk.models.events.failure.NewConversationFailedEvent;
import io.intercom.android.sdk.models.events.failure.ReplyFailedEvent;
import io.intercom.android.sdk.models.events.failure.UploadFailedEvent;
import io.intercom.android.sdk.models.events.realtime.UserContentSeenByAdminEvent;
import io.intercom.android.sdk.utilities.KeyboardUtils;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.views.AdminIsTypingView;
import io.intercom.android.sdk.views.AdminIsTypingView.Listener;
import io.intercom.android.sdk.views.AttributeCollectorCardView;
import io.intercom.android.sdk.views.BaseAttributeView;
import io.intercom.android.sdk.views.IntercomLinkView;
import io.intercom.android.sdk.views.decoration.ConversationItemDecoration;
import io.intercom.android.sdk.views.holder.QuickReplyClickListener;
import io.intercom.com.bumptech.glide.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class ConversationContentPresenter implements IntercomLinkHost, QuickReplyClickListener {
    private static final String IMAGE_MIME_TYPE = "image";
    private static final long PART_DISPLAY_DELIVERED_TIMEOUT = TimeUnit.MINUTES.toMillis(1);
    /* access modifiers changed from: private */
    public final ConversationPartAdapter adapter;
    /* access modifiers changed from: private */
    public final Api api;
    private final Blocks blocks;
    private final BlocksViewHolder blocksAdminViewHolder;
    private final BlocksViewHolder blocksAnnouncementViewHolder;
    private final BlocksViewHolder blocksConversationRatingViewHolder;
    private final BlocksViewHolder blocksLinkListHolder;
    private final BlocksViewHolder blocksLinkViewHolder;
    private final BlocksViewHolder blocksPreviewViewHolder;
    private final BlocksViewHolder blocksUserViewHolder;
    private final d bus;
    private final Context context;
    private String conversationId;
    /* access modifiers changed from: private */
    public final RecyclerView conversationList;
    private final Host host;
    /* access modifiers changed from: private */
    public final IntercomLinkPresenter intercomLinkPresenter;
    private final Map<String, AdminIsTypingView> isTypingViews = new b();
    private final LinearLayoutManager layoutManager;
    private final Part loadingPart = new Builder().withStyle(Part.LOADING_LAYOUT).build();
    private final MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public final OpsMetricTracker opsMetricTracker;
    private final List<Part> parts;
    private Runnable replyDeliveredUpdater;
    final List<Part> sendingParts = new ArrayList();
    private final SoundPlayer soundPlayer;
    private final TimestampAdder timestampAdder = TimestampAdder.create();
    private final UploadingImageCache uploadingImageCache;
    private final UserIdentity userIdentity;

    interface Host {
        Conversation getConversation();

        String getConversationId();

        void onConversationCreated(Conversation conversation);
    }

    ConversationContentPresenter(Host host2, RecyclerView recyclerView, ConversationPartAdapter conversationPartAdapter, LinearLayoutManager linearLayoutManager, IntercomLinkPresenter intercomLinkPresenter2, List<Part> list, SoundPlayer soundPlayer2, Blocks blocks2, ViewHolderGenerator viewHolderGenerator, UserIdentity userIdentity2, Api api2, OpsMetricTracker opsMetricTracker2, UploadingImageCache uploadingImageCache2, Context context2, String str, MetricTracker metricTracker2, d dVar) {
        ConversationPartAdapter conversationPartAdapter2 = conversationPartAdapter;
        this.host = host2;
        this.conversationList = recyclerView;
        this.adapter = conversationPartAdapter2;
        this.layoutManager = linearLayoutManager;
        this.intercomLinkPresenter = intercomLinkPresenter2;
        this.parts = list;
        this.soundPlayer = soundPlayer2;
        this.blocks = blocks2;
        this.userIdentity = userIdentity2;
        this.api = api2;
        this.opsMetricTracker = opsMetricTracker2;
        this.uploadingImageCache = uploadingImageCache2;
        this.context = context2;
        this.conversationId = str;
        this.metricTracker = metricTracker2;
        this.bus = dVar;
        this.blocksUserViewHolder = viewHolderGenerator.getUserHolder();
        this.blocksAnnouncementViewHolder = viewHolderGenerator.getContainerCardHolder();
        this.blocksAdminViewHolder = viewHolderGenerator.getAdminHolder();
        this.blocksLinkViewHolder = viewHolderGenerator.getLinkHolder();
        this.blocksConversationRatingViewHolder = viewHolderGenerator.getConversationRatingHolder();
        this.blocksPreviewViewHolder = viewHolderGenerator.getPreviewHolder();
        this.blocksLinkListHolder = viewHolderGenerator.getLinkListHolder();
        conversationPartAdapter.setQuickReplyClickListener(this);
    }

    private Part addSendingPart(List<Block.Builder> list) {
        Part createSendingPart = createSendingPart(list);
        this.sendingParts.add(createSendingPart);
        displaySendingPart(createSendingPart);
        return createSendingPart;
    }

    static ConversationContentPresenter create(Host host2, RecyclerView recyclerView, ConversationPartAdapter conversationPartAdapter, IntercomLinkView intercomLinkView, Provider<AppConfig> provider, Api api2, List<Part> list, String str, SoundPlayer soundPlayer2, Blocks blocks2, UserIdentity userIdentity2, OpsMetricTracker opsMetricTracker2, n nVar, Activity activity) {
        Api api3 = api2;
        Host host3 = host2;
        RecyclerView recyclerView2 = recyclerView;
        ConversationPartAdapter conversationPartAdapter2 = conversationPartAdapter;
        Api api4 = api2;
        List<Part> list2 = list;
        String str2 = str;
        SoundPlayer soundPlayer3 = soundPlayer2;
        Blocks blocks3 = blocks2;
        UserIdentity userIdentity3 = userIdentity2;
        OpsMetricTracker opsMetricTracker3 = opsMetricTracker2;
        Activity activity2 = activity;
        Injector injector = Injector.get();
        LinearLayoutManager linearLayoutManager = r0;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(recyclerView.getContext());
        IntercomLinkPresenter intercomLinkPresenter2 = r0;
        String str3 = str;
        IntercomLinkPresenter intercomLinkPresenter3 = new IntercomLinkPresenter(intercomLinkView, provider, api2, str3, injector.getAppIdentity().appId(), injector.getUserIdentity().getIntercomId(), false);
        UploadingImageCache uploadingImageCache2 = r1;
        UploadingImageCache uploadingImageCache3 = new UploadingImageCache();
        ViewHolderGenerator viewHolderGenerator = r0;
        ViewHolderGenerator viewHolderGenerator2 = new ViewHolderGenerator(uploadingImageCache3, api2, provider, str3, new LightboxOpeningImageClickListener(api3), new LinkOpeningButtonClickListener(api3), nVar, injector.getGson(), injector.getBus(), injector.getMetricTracker(), activity);
        ConversationContentPresenter conversationContentPresenter = new ConversationContentPresenter(host3, recyclerView2, conversationPartAdapter2, linearLayoutManager, intercomLinkPresenter2, list2, soundPlayer3, blocks3, viewHolderGenerator, userIdentity3, api4, opsMetricTracker3, uploadingImageCache2, activity2, str2, Injector.get().getMetricTracker(), Injector.get().getBus());
        return conversationContentPresenter;
    }

    private List<Block.Builder> createBlocksForUpload(UploadEvent uploadEvent, Block block) {
        if (uploadEvent.getUpload().getContentType().contains(IMAGE_MIME_TYPE)) {
            return Collections.singletonList(block.toBuilder().withType(BlockType.IMAGE.getSerializedName()).withUrl(uploadEvent.getUpload().getPublicUrl()));
        }
        List attachments = block.getAttachments();
        if (attachments.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(block.toBuilder().withAttachments(Collections.singletonList(((BlockAttachment) attachments.get(0)).toBuilder().withSize(uploadEvent.getSize()).withId(uploadEvent.getUpload().getId()).build())).withType(BlockType.ATTACHMENTLIST.getSerializedName()));
    }

    private Part createSendingPart(List<Block.Builder> list) {
        Part build = new Builder().withCreatedAt(TimeUnit.MILLISECONDS.toSeconds(TimeProvider.SYSTEM.currentTimeMillis())).withStyle(Part.CHAT_MESSAGE_STYLE).withBlocks(list).build();
        build.setMessageState(MessageState.SENDING);
        build.setParticipant(getUserParticipant());
        build.setEntranceAnimation(true);
        return build;
    }

    private void displaySendingPart(Part part) {
        this.soundPlayer.playReplySentSound();
        this.parts.add(part);
        this.adapter.setViewForPart(part, this.blocks.createBlocks(part.getBlocks(), this.blocksPreviewViewHolder));
        this.adapter.notifyDataSetChanged();
        smoothScrollToBottom();
    }

    private void hideLoadingIndicator() {
        int indexOf = this.parts.indexOf(this.loadingPart);
        if (indexOf >= 0) {
            this.parts.remove(indexOf);
            this.adapter.notifyItemRemoved(indexOf);
        }
    }

    private void markAsFailed(int i2, String str, boolean z) {
        int positionOfPart = positionOfPart(i2, str);
        if (positionOfPart >= 0) {
            Part part = (Part) this.parts.get(positionOfPart);
            View childAt = this.adapter.getViewForPart(part).getChildAt(0);
            if (childAt instanceof UploadProgressListener) {
                ((UploadProgressListener) childAt).uploadStopped();
            }
            part.setMessageState(z ? MessageState.UPLOAD_FAILED : MessageState.FAILED);
            this.adapter.notifyDataSetChanged();
        }
    }

    private int positionOfPart(int i2, String str) {
        if (i2 < 0 || i2 >= this.parts.size()) {
            return -1;
        }
        if (((Part) this.parts.get(i2)).getId().equals(str)) {
            return i2;
        }
        return positionOfPartById(str);
    }

    private int positionOfPartById(String str) {
        for (int size = this.parts.size() - 1; size >= 0; size--) {
            if (((Part) this.parts.get(size)).getId().equals(str)) {
                return size;
            }
        }
        return -1;
    }

    private void removeSendingPartsIfNeeded() {
        Iterator it = this.sendingParts.iterator();
        while (it.hasNext()) {
            Part part = (Part) it.next();
            if (part.getUpload() == null) {
                it.remove();
            } else {
                this.parts.add(part);
            }
        }
    }

    private void retryFailedUpload(Part part) {
        UploadProgressListener uploadProgressListener;
        int positionOfPart = positionOfPart(this.parts.size() - 1, part.getId());
        if (positionOfPart >= 0) {
            uploadProgressListener = (UploadProgressListener) this.adapter.getViewForPart((Part) this.parts.get(positionOfPart)).getChildAt(0);
            uploadProgressListener.uploadStarted();
        } else {
            uploadProgressListener = new UploadProgressListener() {
                public void uploadNotice(byte b2) {
                }

                public void uploadStarted() {
                }

                public void uploadStopped() {
                }
            };
        }
        UploadProgressListener uploadProgressListener2 = uploadProgressListener;
        part.setMessageState(MessageState.SENDING);
        List<Part> list = this.parts;
        list.remove(list.indexOf(part));
        this.parts.add(part);
        this.adapter.notifyDataSetChanged();
        this.api.uploadFile(part.getUpload(), positionOfPart, part.getId(), this.uploadingImageCache, uploadProgressListener2);
    }

    private void showLoadingIndicator() {
        this.parts.add(0, this.loadingPart);
        this.adapter.notifyItemInserted(0);
    }

    private void showRetryDialog(final Part part) {
        new a(this.conversationList.getContext()).setTitle(R.string.intercom_inbox_error_state_title).setMessage(R.string.intercom_failed_delivery).setPositiveButton(R.string.intercom_retry, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ConversationContentPresenter.this.retryTapped(part);
            }
        }).show();
    }

    private void smoothScrollToBottom() {
        this.conversationList.j(this.adapter.getCount() - 1);
    }

    private void updateSendPartOpsMetric() {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.SEND_PART_TIME_TO_COMPLETE_REQUEST);
        this.opsMetricTracker.trackEvent(OpsMetricTracker.START, OpsMetricTracker.SEND_PART_TIME_TO_RENDER_RESULT);
        this.conversationList.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ConversationContentPresenter.this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.SEND_PART_TIME_TO_RENDER_RESULT);
                ViewUtils.removeGlobalLayoutListener(ConversationContentPresenter.this.conversationList, this);
            }
        });
    }

    public void addBottomPadding(int i2) {
        RecyclerView recyclerView = this.conversationList;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), this.conversationList.getPaddingTop(), this.conversationList.getPaddingRight(), this.conversationList.getPaddingBottom() + i2);
    }

    /* access modifiers changed from: 0000 */
    public void addViewForPart(Part part) {
        if (!"quick_reply".equals(part.getMessageStyle())) {
            List blocks2 = part.getBlocks();
            if (!part.getAttachments().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Attachments attachments : part.getAttachments()) {
                    arrayList.add(new BlockAttachment.Builder().withName(attachments.getName()).withUrl(attachments.getUrl()).withContentType(attachments.getContentType()).build());
                }
                blocks2.add(new Block.Builder().withType(BlockType.ATTACHMENTLIST.name()).withAttachments(arrayList).build());
            }
            if (part.getParticipant().isUserWithId(this.userIdentity.getIntercomId())) {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksUserViewHolder));
            } else {
                if (!Part.POST_MESSAGE_STYLE.equals(part.getMessageStyle())) {
                    if (!Part.NOTE_MESSAGE_STYLE.equals(part.getMessageStyle())) {
                        if (part.isLinkCard()) {
                            this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksLinkViewHolder));
                        } else if (part.isSingleBlockPartOfType(BlockType.CONVERSATIONRATING)) {
                            this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksConversationRatingViewHolder));
                        } else if (part.isSingleBlockPartOfType(BlockType.LINKLIST)) {
                            this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksLinkListHolder));
                        } else {
                            if (Part.ATTRIBUTE_COLLECTOR_STYLE.equals(part.getMessageStyle())) {
                                LinearLayout linearLayout = new LinearLayout(this.context);
                                linearLayout.setOrientation(1);
                                this.adapter.setViewForPart(part, linearLayout);
                            } else {
                                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksAdminViewHolder));
                            }
                        }
                    }
                }
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksAnnouncementViewHolder));
            }
        }
    }

    public void cleanup() {
        this.conversationList.removeCallbacks(this.replyDeliveredUpdater);
    }

    public void fetchConversation(final String str) {
        if (!str.isEmpty()) {
            this.opsMetricTracker.trackEvent(OpsMetricTracker.START, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_COMPLETE_REQUEST);
            this.conversationId = str;
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    ConversationContentPresenter.this.api.getConversation(str);
                }
            });
        }
    }

    @k
    public void formSubmitFailed(FormSubmitFailedEvent formSubmitFailedEvent) {
        int positionOfPartById = positionOfPartById(formSubmitFailedEvent.getPartId());
        if (positionOfPartById >= 0) {
            ViewGroup viewForPart = this.adapter.getViewForPart((Part) this.parts.get(positionOfPartById));
            if (viewForPart != null && viewForPart.getChildCount() > 0) {
                int childCount = viewForPart.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = viewForPart.getChildAt(i2);
                    String string = this.context.getResources().getString(R.string.intercom_something_went_wrong_try_again);
                    BaseAttributeView baseAttributeView = (BaseAttributeView) childAt;
                    if (baseAttributeView.getAttribute().getIdentifier().equals(formSubmitFailedEvent.getAttributeIdentifier())) {
                        baseAttributeView.displayEmptyState();
                        baseAttributeView.displayErrorState(string);
                        break;
                    }
                    i2++;
                }
            }
        }
    }

    @k
    public void formSubmitSuccess(FormSubmitSuccessEvent formSubmitSuccessEvent) {
        int positionOfPartById = positionOfPartById(formSubmitSuccessEvent.getPartId());
        if (positionOfPartById >= 0) {
            ViewGroup viewForPart = this.adapter.getViewForPart((Part) this.parts.get(positionOfPartById));
            if (!(viewForPart == null || viewForPart.getParent() == null)) {
                ViewParent parent = viewForPart.getParent();
                if (parent instanceof AttributeCollectorCardView) {
                    AttributeCollectorCardView attributeCollectorCardView = (AttributeCollectorCardView) parent;
                    if (attributeCollectorCardView.isExpanded()) {
                        attributeCollectorCardView.animateBack(new AttributeAnimateEndListener(formSubmitSuccessEvent.getConversation(), this.bus));
                        KeyboardUtils.hideKeyboard(attributeCollectorCardView);
                    } else {
                        this.bus.post(new ConversationEvent.Builder(formSubmitSuccessEvent.getConversation()).isAttributeUpdated(true).build());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Participant getUserParticipant() {
        String intercomId = this.userIdentity.getIntercomId();
        Participant participant = this.host.getConversation().getParticipant(intercomId);
        return participant == Participant.NULL ? new Participant.Builder().withId(intercomId).build() : participant;
    }

    public boolean isAtBottom() {
        return !this.conversationList.canScrollVertically(1);
    }

    @k
    public void newConversationFailure(NewConversationFailedEvent newConversationFailedEvent) {
        markAsFailed(newConversationFailedEvent.getPosition(), newConversationFailedEvent.getPartId(), false);
    }

    @k
    public void newConversationSuccess(NewConversationEvent newConversationEvent) {
        if (!this.parts.isEmpty()) {
            List<Part> list = this.parts;
            if (((Part) list.get(list.size() - 1)).getId().equals(newConversationEvent.getPartId())) {
                onNewConversation(newConversationEvent);
                this.host.onConversationCreated(newConversationEvent.getConversation());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009b, code lost:
        return;
     */
    public synchronized void onAdminStartedTyping(AdminIsTypingEvent adminIsTypingEvent) {
        final String adminId = adminIsTypingEvent.getAdminId();
        if (this.isTypingViews.containsKey(adminId)) {
            ((AdminIsTypingView) this.isTypingViews.get(adminId)).renewTypingAnimation();
            return;
        }
        final Part build = new Builder().withParticipantIsAdmin(true).withStyle(Part.ADMIN_IS_TYPING_STYLE).build();
        Participant participant = this.host.getConversation().getParticipant(adminId);
        if (participant == Participant.NULL) {
            participant = Participant.create(adminId, adminIsTypingEvent.getAdminName(), Participant.ADMIN_TYPE, "", Avatar.create(adminIsTypingEvent.getAdminAvatarUrl(), ""), Boolean.valueOf(false));
        }
        build.setParticipant(participant);
        build.setEntranceAnimation(true);
        boolean isAtBottom = isAtBottom();
        this.parts.add(build);
        Context context2 = this.conversationList.getContext();
        LinearLayout linearLayout = (LinearLayout) View.inflate(context2, R.layout.intercom_blocks_admin_layout, null);
        AdminIsTypingView adminIsTypingView = new AdminIsTypingView(context2);
        adminIsTypingView.setListener(new Listener() {
            public void onAdminTypingAnimationEnded(AdminIsTypingView adminIsTypingView) {
                ConversationContentPresenter.this.onAdminStoppedTyping(adminId, build.getId());
            }
        });
        linearLayout.addView(adminIsTypingView);
        this.isTypingViews.put(adminId, adminIsTypingView);
        this.adapter.setViewForPart(build, linearLayout);
        this.adapter.notifyDataSetChanged();
        if (isAtBottom) {
            smoothScrollToBottom();
        }
    }

    /* access modifiers changed from: 0000 */
    public void onAdminStoppedTyping(String str, String str2) {
        this.isTypingViews.remove(str);
        int positionOfPart = positionOfPart(this.parts.size() - 1, str2);
        if (positionOfPart >= 0) {
            this.parts.remove(positionOfPart);
            this.adapter.notifyDataSetChanged();
        }
    }

    public void onConversationFetched(ConversationEvent conversationEvent, boolean z) {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_COMPLETE_REQUEST);
        this.opsMetricTracker.trackEvent(OpsMetricTracker.START, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_RENDER_RESULT);
        Conversation response = conversationEvent.getResponse();
        this.parts.clear();
        if (z) {
            RecyclerView recyclerView = this.conversationList;
            recyclerView.startAnimation(AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.intercom_conversation_slide_in));
        }
        for (int i2 = 0; i2 < response.getParts().size(); i2++) {
            Part part = (Part) response.getParts().get(i2);
            if (i2 < response.getParts().size() - 1) {
                if ("quick_reply".equals(part.getMessageStyle())) {
                }
            }
            if (this.adapter.getViewForPart(part) == null) {
                addViewForPart(part);
            }
            this.parts.add(part);
        }
        removeSendingPartsIfNeeded();
        this.timestampAdder.addDayDividers(this.parts);
        this.adapter.notifyDataSetChanged();
        this.intercomLinkPresenter.setSolution(response.getIntercomLinkSolution());
        this.conversationList.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ConversationContentPresenter.this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_RENDER_RESULT);
                ViewUtils.removeGlobalLayoutListener(ConversationContentPresenter.this.conversationList, this);
            }
        });
    }

    public void onGlobalLayout() {
        this.intercomLinkPresenter.updateIntercomLink(this);
    }

    public void onNewConversation(NewConversationEvent newConversationEvent) {
        updateSendPartOpsMetric();
        Conversation conversation = newConversationEvent.getConversation();
        Part part = (Part) newConversationEvent.getConversation().getParts().get(0);
        this.conversationId = conversation.getId();
        List<Part> list = this.parts;
        list.remove(list.size() - 1);
        this.sendingParts.clear();
        addViewForPart(part);
        this.parts.add(part);
        this.adapter.notifyDataSetChanged();
        this.intercomLinkPresenter.setSolution(conversation.getIntercomLinkSolution());
    }

    public void onNewPartReceived() {
        for (AdminIsTypingView adminIsTypingView : this.isTypingViews.values()) {
            if (adminIsTypingView != null) {
                adminIsTypingView.cancelTypingAnimation();
            }
        }
        smoothScrollToBottom();
    }

    public void onPartClicked(Part part) {
        if (part.getMessageState() == MessageState.FAILED) {
            showRetryDialog(part);
        } else if (part.getMessageState() == MessageState.UPLOAD_FAILED) {
            retryFailedUpload(part);
        }
    }

    public void onProfileScrolled() {
        int count = this.adapter.getCount() - 1;
        this.intercomLinkPresenter.onProfileScrolled(count > 0 ? this.conversationList.getChildAt(count) : null);
    }

    public void onQuickReplyClicked(Participant participant, Part part, ReplyOption replyOption) {
        Author.Builder builder = new Author.Builder();
        builder.withFirstName(participant.getForename()).withName(participant.getName()).withAvatar(participant.getAvatar().getImageUrl());
        Block.Builder builder2 = new Block.Builder();
        builder2.withText(replyOption.text()).withAuthor(builder.build());
        ArrayList arrayList = new ArrayList();
        arrayList.add(builder2);
        Part addSendingPart = addSendingPart(arrayList);
        Part part2 = part;
        this.api.addConversationQuickReply(this.conversationId, part2, replyOption.uuid(), positionOfPart(this.parts.size() - 1, addSendingPart.getId()), addSendingPart.getId());
        this.metricTracker.clickedQuickReply(replyOption.uuid(), this.conversationId, part.getId());
    }

    public void onReplyDelivered(ReplyEvent replyEvent) {
        updateSendPartOpsMetric();
        final Part response = replyEvent.getResponse();
        int positionOfPart = positionOfPart(replyEvent.getPosition(), replyEvent.getPartId());
        if (positionOfPart >= 0 && ((Part) this.parts.get(positionOfPart)).isSendingPart()) {
            this.sendingParts.remove(this.parts.remove(positionOfPart));
        }
        if (!this.parts.contains(response)) {
            addViewForPart(response);
            response.setDisplayDelivered(true);
            this.parts.add(response);
            this.adapter.notifyDataSetChanged();
        }
        this.conversationList.removeCallbacks(this.replyDeliveredUpdater);
        this.replyDeliveredUpdater = new Runnable() {
            public void run() {
                response.setDisplayDelivered(false);
                ConversationContentPresenter.this.adapter.notifyDataSetChanged();
            }
        };
        this.conversationList.postDelayed(this.replyDeliveredUpdater, PART_DISPLAY_DELIVERED_TIMEOUT);
    }

    @k
    public void onUserContentSeenByAdmin(UserContentSeenByAdminEvent userContentSeenByAdminEvent) {
        if (userContentSeenByAdminEvent.getConversationId().equals(this.conversationId) && !this.parts.isEmpty()) {
            boolean z = false;
            for (int size = this.parts.size() - 1; size >= 0; size--) {
                Part part = (Part) this.parts.get(size);
                if (z || part.isAdmin()) {
                    part.setSeenByAdmin(SeenState.HIDE);
                } else {
                    part.setSeenByAdmin(SeenState.SEEN);
                    z = true;
                }
            }
            this.adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: 0000 */
    public void playSoundForNewAdminPart(List<Part> list) {
        for (Part part : list) {
            if (part.isAdmin()) {
                if (part.getParticipant().isBot().booleanValue()) {
                    this.soundPlayer.playOperatorReceivedSound();
                    return;
                } else {
                    this.soundPlayer.playMessageReceivedSound();
                    return;
                }
            }
        }
    }

    @k
    public void replyFailure(ReplyFailedEvent replyFailedEvent) {
        markAsFailed(replyFailedEvent.getPosition(), replyFailedEvent.getPartId(), replyFailedEvent.isUpload());
        this.soundPlayer.playReplyFailedSound();
    }

    /* access modifiers changed from: 0000 */
    public void retryTapped(Part part) {
        part.setMessageState(MessageState.SENDING);
        this.parts.remove(part);
        this.parts.add(part);
        this.adapter.notifyDataSetChanged();
        List blocks2 = part.getBlocks();
        int size = blocks2.size();
        ArrayList arrayList = new ArrayList(blocks2.size());
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Block) blocks2.get(i2)).toBuilder());
        }
        sendPart(arrayList);
    }

    public void scrollToBottom() {
        this.conversationList.i(this.adapter.getCount() - 1);
    }

    public void scrollToTop() {
        this.conversationList.i(0);
    }

    public void sendPart(List<Block.Builder> list) {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.SEND_PART_TIME_TO_PROCESS_ACTION);
        this.opsMetricTracker.trackEvent(OpsMetricTracker.START, OpsMetricTracker.SEND_PART_TIME_TO_COMPLETE_REQUEST);
        Part addSendingPart = addSendingPart(list);
        if (TextUtils.isEmpty(this.conversationId)) {
            this.api.startNewConversation(list, this.parts.size() - 1, addSendingPart.getId());
            return;
        }
        this.api.replyToConversation(this.conversationId, list, this.parts.size() - 1, addSendingPart.getId(), false);
    }

    public void setup() {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_PROCESS_ACTION);
        this.conversationList.setLayoutManager(this.layoutManager);
        this.conversationList.setAdapter(this.adapter);
        RecyclerView recyclerView = this.conversationList;
        recyclerView.a((h) new ConversationItemDecoration(recyclerView.getContext(), this.parts));
        ((X) this.conversationList.getItemAnimator()).a(false);
        this.conversationList.setNestedScrollingEnabled(true);
        this.conversationList.setVisibility(0);
        this.conversationList.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            }

            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                ConversationContentPresenter.this.intercomLinkPresenter.updateIntercomLink(ConversationContentPresenter.this);
            }
        });
        this.intercomLinkPresenter.setup(this);
    }

    public void showContentView() {
        hideLoadingIndicator();
        this.conversationList.setVisibility(0);
    }

    public void showErrorView() {
        hideLoadingIndicator();
        this.conversationList.setVisibility(8);
    }

    public void showLoadingView() {
        showLoadingIndicator();
        this.conversationList.setVisibility(0);
    }

    public void smoothScrollToTop() {
        this.conversationList.j(0);
    }

    @k
    public void uploadFailure(UploadFailedEvent uploadFailedEvent) {
        markAsFailed(uploadFailedEvent.getPosition(), uploadFailedEvent.getPartId(), true);
        this.soundPlayer.playReplyFailedSound();
    }

    public void uploadImage(List<Block.Builder> list, GalleryImage galleryImage) {
        Part addSendingPart = addSendingPart(list);
        addSendingPart.setUpload(galleryImage);
        this.api.uploadFile(galleryImage, this.parts.size() - 1, addSendingPart.getId(), this.uploadingImageCache, (UploadProgressListener) this.adapter.getViewForPart(addSendingPart).getChildAt(0));
    }

    @k
    public void uploadSuccess(UploadEvent uploadEvent) {
        String tempPartId = uploadEvent.getTempPartId();
        int positionOfPart = positionOfPart(uploadEvent.getTempPartPosition(), tempPartId);
        if (positionOfPart >= 0) {
            Part part = (Part) this.parts.get(positionOfPart);
            if (!part.getBlocks().isEmpty() && tempPartId.equals(part.getId())) {
                List createBlocksForUpload = createBlocksForUpload(uploadEvent, (Block) part.getBlocks().get(0));
                if (TextUtils.isEmpty(this.conversationId)) {
                    this.api.startNewConversation(createBlocksForUpload, this.parts.size() - 1, tempPartId);
                } else {
                    this.api.replyToConversation(this.conversationId, createBlocksForUpload, positionOfPart, part.getId(), true);
                }
            }
        }
    }
}
