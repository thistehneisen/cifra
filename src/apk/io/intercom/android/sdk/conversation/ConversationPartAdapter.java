package io.intercom.android.sdk.conversation;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.app.d;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.activities.IntercomArticleActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.BlockType;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.conversation.attribute.OnDateAttributeSetListener;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.Link;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.MessageState;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.LinkOpener;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.ListAttributeSelectorDialogBuilder;
import io.intercom.android.sdk.views.PartMetadataFormatter;
import io.intercom.android.sdk.views.holder.AttributeCollectorViewHolder;
import io.intercom.android.sdk.views.holder.ContainerCardViewHolder;
import io.intercom.android.sdk.views.holder.ConversationListener;
import io.intercom.android.sdk.views.holder.ConversationLoadingViewHolder;
import io.intercom.android.sdk.views.holder.ConversationPartViewHolder;
import io.intercom.android.sdk.views.holder.ConversationRatingViewHolder;
import io.intercom.android.sdk.views.holder.EventViewHolder;
import io.intercom.android.sdk.views.holder.LinkListViewHolder;
import io.intercom.android.sdk.views.holder.LinkViewHolder;
import io.intercom.android.sdk.views.holder.PartViewHolder;
import io.intercom.android.sdk.views.holder.QuickReplyClickListener;
import io.intercom.android.sdk.views.holder.QuickReplyViewHolder;
import io.intercom.android.sdk.views.holder.TimeStampViewHolder;
import io.intercom.com.bumptech.glide.n;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class ConversationPartAdapter extends a<x> implements ConversationListener {
    private boolean allowExpansionArrow = false;
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final ClipboardManager clipboardManager;
    private final String conversationId;
    private final Listener listener;
    private final Locale locale;
    private final MetricTracker metricTracker;
    private final List<Part> partList;
    private final PartMetadataFormatter partMetadataFormatter;
    private final Map<Part, ViewGroup> partViewMap;
    private QuickReplyClickListener quickReplyClickListener;
    private final n requestManager;
    private final Activity rootActivity;
    private Part selectedPart;
    private final TimeFormatter timeFormatter;
    private final UserIdentity userIdentity;

    interface Listener {
        void onPartClicked(Part part);

        void onPostCardClicked(Part part);
    }

    ConversationPartAdapter(List<Part> list, ClipboardManager clipboardManager2, Listener listener2, PartMetadataFormatter partMetadataFormatter2, TimeFormatter timeFormatter2, Map<Part, ViewGroup> map, Api api2, Activity activity, String str, Provider<AppConfig> provider, UserIdentity userIdentity2, n nVar, MetricTracker metricTracker2, Locale locale2) {
        this.partList = list;
        this.clipboardManager = clipboardManager2;
        this.listener = listener2;
        this.partMetadataFormatter = partMetadataFormatter2;
        this.timeFormatter = timeFormatter2;
        this.partViewMap = map;
        this.api = api2;
        this.rootActivity = activity;
        this.conversationId = str;
        this.appConfigProvider = provider;
        this.userIdentity = userIdentity2;
        this.requestManager = nVar;
        this.metricTracker = metricTracker2;
        this.locale = locale2;
    }

    public static ConversationPartAdapter create(Activity activity, List<Part> list, Listener listener2, Api api2, String str, Provider<AppConfig> provider, UserIdentity userIdentity2, TimeProvider timeProvider, ContextLocaliser contextLocaliser, n nVar, MetricTracker metricTracker2, Locale locale2) {
        Activity activity2 = activity;
        ClipboardManager clipboardManager2 = (ClipboardManager) activity2.getSystemService("clipboard");
        TimeFormatter timeFormatter2 = new TimeFormatter(contextLocaliser.createLocalisedContext(activity2), timeProvider);
        ConversationPartAdapter conversationPartAdapter = new ConversationPartAdapter(list, clipboardManager2, listener2, new PartMetadataFormatter(timeFormatter2), timeFormatter2, new HashMap(), api2, activity2, str, provider, userIdentity2, nVar, metricTracker2, locale2);
        return conversationPartAdapter;
    }

    private void openArticleActivity(Block block, Part part, View view) {
        Intent buildIntent = IntercomArticleActivity.buildIntent(this.rootActivity, block.getArticleId(), part.getId(), this.conversationId);
        if (VERSION.SDK_INT >= 16) {
            this.rootActivity.startActivity(buildIntent, d.a(this.rootActivity, view, "link_background").a());
            return;
        }
        this.rootActivity.startActivity(buildIntent);
    }

    private void startAllowingExpansionArrowIfPositionIsNotLast(int i2) {
        boolean z = this.allowExpansionArrow;
        boolean z2 = true;
        if (i2 == this.partList.size() - 1) {
            z2 = false;
        }
        this.allowExpansionArrow = z | z2;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public int getCount() {
        return getItemCount();
    }

    public int getItemCount() {
        return this.partList.size();
    }

    public int getItemViewType(int i2) {
        Part part = (Part) this.partList.get(i2);
        String messageStyle = part.getMessageStyle();
        if (part.isEvent().booleanValue()) {
            return 12;
        }
        if (Part.ADMIN_IS_TYPING_STYLE.equals(messageStyle)) {
            return 5;
        }
        if (Part.DAY_DIVIDER_STYLE.equals(messageStyle)) {
            return 6;
        }
        if (Part.LOADING_LAYOUT.equals(messageStyle)) {
            return 7;
        }
        Participant participant = part.getParticipant();
        if (!participant.isAdmin()) {
            return participant.isUserWithId(this.userIdentity.getIntercomId()) ? 0 : 4;
        }
        if (part.isLinkCard()) {
            return part.isInitialMessage() ? 8 : 9;
        } else if (part.isSingleBlockPartOfType(BlockType.CONVERSATIONRATING)) {
            return 10;
        } else {
            if (part.isSingleBlockPartOfType(BlockType.LINKLIST)) {
                return 13;
            }
            if (Part.POST_MESSAGE_STYLE.equals(messageStyle)) {
                return 2;
            }
            if (Part.NOTE_MESSAGE_STYLE.equals(messageStyle)) {
                startAllowingExpansionArrowIfPositionIsNotLast(i2);
                return 3;
            } else if (Part.ATTRIBUTE_COLLECTOR_STYLE.equals(messageStyle)) {
                return 15;
            } else {
                return "quick_reply".equals(messageStyle) ? 14 : 1;
            }
        }
    }

    public Part getPart(int i2) {
        return (Part) this.partList.get(i2);
    }

    public Part getSelectedPart() {
        return this.selectedPart;
    }

    /* access modifiers changed from: 0000 */
    public ViewGroup getViewForPart(Part part) {
        return (ViewGroup) this.partViewMap.get(part);
    }

    public void onBindViewHolder(x xVar, int i2) {
        if (xVar instanceof ConversationPartViewHolder) {
            Part part = getPart(i2);
            ViewGroup viewGroup = (ViewGroup) this.partViewMap.get(part);
            if (viewGroup == null) {
                viewGroup = new FrameLayout(xVar.itemView.getContext());
            }
            ((ConversationPartViewHolder) xVar).bind(part, viewGroup);
        }
    }

    public void onContainerCardClicked(int i2, ContainerCardViewHolder containerCardViewHolder) {
        Part part = (Part) this.partList.get(i2);
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 2) {
            this.listener.onPostCardClicked(part);
        } else if (itemViewType == 3 && this.allowExpansionArrow) {
            containerCardViewHolder.toggleExpanded();
        }
    }

    public x onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i2) {
            case 1:
            case 4:
            case 5:
                PartViewHolder partViewHolder = new PartViewHolder(from.inflate(R.layout.intercom_row_admin_part, viewGroup, false), i2, this, this.clipboardManager, this.partMetadataFormatter, this.appConfigProvider, this.requestManager, this.metricTracker);
                return partViewHolder;
            case 2:
                ContainerCardViewHolder containerCardViewHolder = new ContainerCardViewHolder(from.inflate(R.layout.intercom_row_post, viewGroup, false), i2, this, this.clipboardManager, false, this.appConfigProvider, this.requestManager);
                return containerCardViewHolder;
            case 3:
                ContainerCardViewHolder containerCardViewHolder2 = new ContainerCardViewHolder(from.inflate(R.layout.intercom_row_note, viewGroup, false), i2, this, this.clipboardManager, this.allowExpansionArrow, this.appConfigProvider, this.requestManager);
                return containerCardViewHolder2;
            case 6:
                return new TimeStampViewHolder(from.inflate(R.layout.intercom_day_divider, viewGroup, false), this.timeFormatter);
            case 7:
                return new ConversationLoadingViewHolder(from.inflate(R.layout.intercom_row_loading, viewGroup, false));
            case 8:
                LinkViewHolder linkViewHolder = new LinkViewHolder(from.inflate(R.layout.intercom_row_link, viewGroup, false), i2, this, this.clipboardManager, this.appConfigProvider, this.requestManager);
                return linkViewHolder;
            case 9:
                LinkViewHolder linkViewHolder2 = new LinkViewHolder(from.inflate(R.layout.intercom_row_link_reply, viewGroup, false), i2, this, this.clipboardManager, this.appConfigProvider, this.requestManager);
                return linkViewHolder2;
            case 10:
                return new ConversationRatingViewHolder(from.inflate(R.layout.intercom_row_conversation_rating, viewGroup, false), this, this.appConfigProvider, this.requestManager);
            case 12:
                return new EventViewHolder(from.inflate(R.layout.intercom_row_event, viewGroup, false), this.appConfigProvider, this.requestManager);
            case 13:
                return new LinkListViewHolder(from.inflate(R.layout.intercom_row_link_list, viewGroup, false), this, this.appConfigProvider, this.requestManager);
            case 14:
                QuickReplyViewHolder quickReplyViewHolder = new QuickReplyViewHolder(from.inflate(R.layout.intercom_row_quick_reply_part, viewGroup, false), i2, this, this.clipboardManager, this.partMetadataFormatter, this.appConfigProvider, this.requestManager, this.metricTracker);
                return quickReplyViewHolder;
            case 15:
                AttributeCollectorViewHolder attributeCollectorViewHolder = new AttributeCollectorViewHolder(from.inflate(R.layout.intercom_row_attribute_collector_part, viewGroup, false), this.appConfigProvider, this, this.requestManager, this.locale);
                return attributeCollectorViewHolder;
            default:
                PartViewHolder partViewHolder2 = new PartViewHolder(from.inflate(R.layout.intercom_row_user_part, viewGroup, false), i2, this, this.clipboardManager, this.partMetadataFormatter, this.appConfigProvider, this.requestManager, this.metricTracker);
                return partViewHolder2;
        }
    }

    public void onDateAttributeClicked(String str, String str2, String str3, AttributeInputListener attributeInputListener) {
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        Activity activity = this.rootActivity;
        int i5 = R.style.Intercom_DatePicker;
        OnDateAttributeSetListener onDateAttributeSetListener = new OnDateAttributeSetListener(str, str2, str3, this, attributeInputListener);
        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, i5, onDateAttributeSetListener, i2, i3, i4);
        datePickerDialog.show();
        int primaryColor = ((AppConfig) this.appConfigProvider.get()).getPrimaryColor();
        Button button = datePickerDialog.getButton(-1);
        button.setText(17039370);
        button.setTextColor(primaryColor);
        datePickerDialog.getButton(-2).setTextColor(primaryColor);
    }

    public void onLinkClicked(int i2, View view) {
        Part part = (Part) this.partList.get(i2);
        Block linkBlock = part.getLinkBlock();
        if (Link.ARTICLE_TYPE.equals(linkBlock.getLinkType())) {
            openArticleActivity(linkBlock, part, view);
        } else {
            LinkOpener.handleUrl(linkBlock.getUrl(), this.rootActivity, this.api);
        }
    }

    public void onListAttributeClicked(String str, Attribute attribute, AttributeInputListener attributeInputListener) {
        ListAttributeSelectorDialogBuilder listAttributeSelectorDialogBuilder = new ListAttributeSelectorDialogBuilder(this.rootActivity, str, attribute, this, attributeInputListener);
        listAttributeSelectorDialogBuilder.show();
    }

    public void onPartClicked(int i2, PartViewHolder partViewHolder) {
        Part part = (Part) this.partList.get(i2);
        if (part.getMessageState() == MessageState.FAILED || part.getMessageState() == MessageState.UPLOAD_FAILED) {
            this.listener.onPartClicked(part);
        } else if (i2 < getCount() - 1) {
            Part part2 = this.selectedPart;
            if (part == part2) {
                this.selectedPart = null;
                partViewHolder.setExpanded(false);
                return;
            }
            notifyItemChanged(this.partList.indexOf(part2));
            this.selectedPart = part;
            partViewHolder.setExpanded(true);
        }
    }

    public void onQuickReplyClicked(Participant participant, Part part, ReplyOption replyOption) {
        QuickReplyClickListener quickReplyClickListener2 = this.quickReplyClickListener;
        if (quickReplyClickListener2 != null) {
            quickReplyClickListener2.onQuickReplyClicked(participant, part, replyOption);
        }
    }

    public void onSubmitAttribute(String str, String str2, Object obj, String str3) {
        this.api.submitForm(this.conversationId, str, str2, obj, str3);
    }

    /* access modifiers changed from: 0000 */
    public void removeViewForPart(Part part) {
        this.partViewMap.remove(part);
    }

    public void setQuickReplyClickListener(QuickReplyClickListener quickReplyClickListener2) {
        this.quickReplyClickListener = quickReplyClickListener2;
    }

    /* access modifiers changed from: 0000 */
    public void setViewForPart(Part part, ViewGroup viewGroup) {
        this.partViewMap.put(part, viewGroup);
    }
}
