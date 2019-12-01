package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.g.a.a;
import com.google.android.flexbox.FlexboxLayout;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.BlockType;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.MessageState;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.views.ExpandableLayout;
import io.intercom.android.sdk.views.PartMetadataFormatter;
import io.intercom.com.bumptech.glide.n;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PartViewHolder extends BlocksPartViewHolder {
    /* access modifiers changed from: private */
    public static final long TIMESTAMP_UPDATE_PERIOD = TimeUnit.MINUTES.toMillis(1);
    private final Provider<AppConfig> appConfigProvider;
    private final TextView attribution;
    private ViewGroup blocks;
    final TextView metaData;
    private final MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public final PartMetadataFormatter partMetadataFormatter;
    private final n requestManager;
    private final int viewType;

    public PartViewHolder(View view, int i2, ConversationListener conversationListener, ClipboardManager clipboardManager, PartMetadataFormatter partMetadataFormatter2, Provider<AppConfig> provider, n nVar, MetricTracker metricTracker2) {
        super(view, conversationListener, clipboardManager);
        this.viewType = i2;
        this.partMetadataFormatter = partMetadataFormatter2;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.metricTracker = metricTracker2;
        this.metaData = (TextView) view.findViewById(R.id.metadata);
        this.attribution = (TextView) view.findViewById(R.id.attribution);
    }

    private Drawable getBackgroundDrawable(Context context, int i2, boolean z, int i3, Part part) {
        boolean hasPreviousConcatPart = hasPreviousConcatPart(part, i3);
        if (z) {
            return a.c(context, hasPreviousConcatPart ? getMiddleDrawable(i2) : getTopDrawable(i2));
        }
        return a.c(context, hasPreviousConcatPart ? getBottomDrawable(i2) : R.drawable.intercom_bubble_background);
    }

    private int getBottomDrawable(int i2) {
        return i2 == 0 ? R.drawable.intercom_bubble_background_user_bottom : R.drawable.intercom_bubble_background_admin_bottom;
    }

    private int getMiddleDrawable(int i2) {
        return i2 == 0 ? R.drawable.intercom_bubble_background_user_middle : R.drawable.intercom_bubble_background_admin_middle;
    }

    private int getTopDrawable(int i2) {
        return i2 == 0 ? R.drawable.intercom_bubble_background_user_top : R.drawable.intercom_bubble_background_admin_top;
    }

    private boolean hasPreviousConcatPart(Part part, int i2) {
        if (i2 > 0) {
            return Part.shouldConcatenate(part, this.conversationListener.getPart(i2 - 1));
        }
        return false;
    }

    private boolean isSingleImagePart(Part part) {
        List blocks2 = part.getBlocks();
        boolean z = true;
        if (blocks2.size() != 1) {
            return false;
        }
        BlockType type = ((Block) blocks2.get(0)).getType();
        if (!(type == BlockType.LOCALIMAGE || type == BlockType.IMAGE)) {
            z = false;
        }
        return z;
    }

    private void setAdminEndMargin(Part part) {
        float f2;
        Context context = this.cellLayout.getContext();
        if (isSingleCardPart(part)) {
            f2 = context.getResources().getDimension(R.dimen.intercom_conversation_row_card_margin);
        } else {
            f2 = context.getResources().getDimension(R.dimen.intercom_conversation_row_margin);
        }
        int i2 = (int) f2;
        if (this.cellLayout.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.cellLayout.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, i2, marginLayoutParams.bottomMargin);
        }
    }

    private void setBubbleBackground(Part part, View view, int i2, boolean z, int i3) {
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        int i4 = 0;
        if (isSingleImagePart(part) || isSingleCardPart(part)) {
            this.cellLayout.setBackgroundColor(0);
            this.cellLayout.setPadding(0, 0, 0, 0);
            View view2 = view;
            paddingBottom = 0;
        } else {
            Context context = this.cellLayout.getContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.intercom_cell_horizontal_padding);
            this.cellLayout.setPadding(dimension, 0, dimension, 0);
            Drawable backgroundDrawable = getBackgroundDrawable(context, i2, z, i3, part);
            if (!part.isAdmin() && i2 != 4) {
                backgroundDrawable.setColorFilter(((AppConfig) this.appConfigProvider.get()).getPrimaryColor(), Mode.SRC_IN);
            }
            BackgroundUtils.setBackground(this.cellLayout, backgroundDrawable);
            View view3 = view;
            i4 = paddingTop;
        }
        view.setPadding(paddingLeft, i4, paddingRight, paddingBottom);
    }

    private void setupAttribution(Part part) {
        if (this.attribution != null) {
            if (shouldShowAttribution(part)) {
                CharSequence format = Phrase.from(this.metaData.getContext(), R.string.intercom_gif_attribution).put("providername", (CharSequence) ((Block) part.getBlocks().get(0)).getAttribution()).format();
                this.attribution.setVisibility(0);
                this.attribution.setText(format);
            } else {
                this.attribution.setVisibility(8);
            }
        }
    }

    private void setupHolderBackground(int i2, Part part, boolean z, n nVar, int i3) {
        setBubbleBackground(part, this.blocks, i2, z, i3);
        ImageView imageView = this.networkAvatar;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(4);
        } else if (i2 == 1 || i2 == 5 || i2 == 4) {
            showAvatar(part.getParticipant(), this.networkAvatar, (AppConfig) this.appConfigProvider.get(), nVar);
        }
    }

    private boolean shouldConcatenate(Part part, int i2) {
        if (i2 == -1) {
            return false;
        }
        int i3 = i2 + 1;
        if (i3 < this.conversationListener.getCount()) {
            return Part.shouldConcatenate(part, this.conversationListener.getPart(i3));
        }
        return false;
    }

    private boolean shouldExpand(Part part) {
        return isSelectedPart(part) || isLastPart(part) || isNextPartTyping(getAdapterPosition());
    }

    private boolean shouldShowAttribution(Part part) {
        if (!isSingleImagePart(part) || TextUtils.isEmpty(((Block) part.getBlocks().get(0)).getAttribution()) || !part.getMessageState().equals(MessageState.NORMAL)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void addReplyOptions(final Part part, final FlexboxLayout flexboxLayout) {
        if (isLastPart(part)) {
            flexboxLayout.setVisibility(0);
        } else {
            flexboxLayout.setVisibility(8);
        }
        flexboxLayout.removeAllViews();
        Context context = flexboxLayout.getContext();
        LayoutInflater from = LayoutInflater.from(context);
        List replyOptions = part.getReplyOptions();
        for (int i2 = 0; i2 < replyOptions.size(); i2++) {
            final ReplyOption replyOption = (ReplyOption) replyOptions.get(i2);
            TextView textView = (TextView) from.inflate(R.layout.intercom_quick_reply_button, null);
            textView.setText(replyOption.text());
            AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
            textView.setTextColor(ColorUtils.primaryOrDarkColor(context, appConfig));
            BackgroundUtils.setRippleButtonStroke(context, textView.getBackground(), R.id.background, appConfig.getPrimaryColor());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    flexboxLayout.setVisibility(8);
                    PartViewHolder.this.conversationListener.onQuickReplyClicked(part.getParticipant(), part, replyOption);
                }
            });
            flexboxLayout.addView(textView);
            this.metricTracker.receivedQuickReply(replyOption.uuid(), this.conversationListener.getConversationId(), part.getId());
        }
    }

    public void bind(Part part, ViewGroup viewGroup) {
        int adapterPosition = getAdapterPosition();
        boolean shouldConcatenate = shouldConcatenate(part, adapterPosition);
        this.blocks = setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        setupHolderBackground(this.viewType, part, shouldConcatenate, this.requestManager, adapterPosition);
        if (part.isAdmin()) {
            setAdminEndMargin(part);
            updateAvatarMarginForCard(part);
        }
        setupMetaData(this.viewType, part);
        setupAttribution(part);
        checkForEntranceAnimation(this.viewType, part, this.networkAvatar, this.cellLayout, this.blocks);
        ExpandableLayout expandableLayout = this.bubble;
        if (expandableLayout != null) {
            expandableLayout.setExpanded(shouldExpand(part), false);
        }
        if (isLastPart(part) && part.getReplyOptions().size() > 0) {
            LayoutInflater from = LayoutInflater.from(this.itemView.getContext());
            LinearLayout linearLayout = (LinearLayout) this.itemView.getRootView();
            FlexboxLayout flexboxLayout = (FlexboxLayout) linearLayout.findViewById(R.id.intercom_reply_options);
            if (flexboxLayout == null) {
                flexboxLayout = (FlexboxLayout) from.inflate(R.layout.intercom_quick_reply_layout, null);
                flexboxLayout.setId(R.id.intercom_reply_options);
                linearLayout.addView(flexboxLayout);
            }
            addReplyOptions(part, flexboxLayout);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isLastPart(Part part) {
        ConversationListener conversationListener = this.conversationListener;
        if (part == conversationListener.getPart(conversationListener.getCount() - 1)) {
            if (!Part.ADMIN_IS_TYPING_STYLE.equals(part.getMessageStyle())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean isNextPartTyping(int i2) {
        boolean z = false;
        if (i2 == -1) {
            return false;
        }
        int i3 = i2 + 1;
        if (i3 <= this.conversationListener.getCount() - 1) {
            if (Part.ADMIN_IS_TYPING_STYLE.equals(this.conversationListener.getPart(i3).getMessageStyle())) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean isSelectedPart(Part part) {
        return part == this.conversationListener.getSelectedPart();
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationListener.onPartClicked(adapterPosition, this);
        }
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    public void setExpanded(boolean z) {
        ExpandableLayout expandableLayout = this.bubble;
        if (expandableLayout != null) {
            expandableLayout.setExpanded(z, true);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setupMetaData(int i2, final Part part) {
        if (this.metaData != null) {
            if (i2 == 2 || i2 == 3) {
                this.metaData.setVisibility(4);
                TextView textView = this.metaData;
                textView.setHeight(ScreenUtils.dpToPx(10.0f, textView.getContext()));
            } else {
                ConversationListener conversationListener = this.conversationListener;
                boolean z = true;
                if (part != conversationListener.getPart(conversationListener.getCount() - 1)) {
                    z = false;
                }
                final Resources resources = this.metaData.getResources();
                this.metaData.setText(this.partMetadataFormatter.getMetadataString(part, z, resources));
                if (z) {
                    this.metaData.postDelayed(new Runnable() {
                        public void run() {
                            PartViewHolder partViewHolder = PartViewHolder.this;
                            partViewHolder.metaData.setText(partViewHolder.partMetadataFormatter.getMetadataString(part, true, resources));
                            PartViewHolder.this.metaData.postDelayed(this, PartViewHolder.TIMESTAMP_UPDATE_PERIOD);
                        }
                    }, TIMESTAMP_UPDATE_PERIOD);
                }
                if (MessageState.UPLOAD_FAILED == part.getMessageState()) {
                    this.metaData.setCompoundDrawablesWithIntrinsicBounds(R.drawable.intercom_message_error, 0, 0, 0);
                } else {
                    this.metaData.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
        }
    }
}
