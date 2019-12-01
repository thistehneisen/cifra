package io.intercom.android.sdk.views.holder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.x;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.BlockType;
import io.intercom.android.sdk.blocks.models.Block;
import io.intercom.android.sdk.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker.Object;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Part.MessageState;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.views.AdminIsTypingView;
import io.intercom.android.sdk.views.ExpandableLayout;
import io.intercom.com.bumptech.glide.n;
import java.util.List;

abstract class BlocksPartViewHolder extends x implements OnClickListener, OnLongClickListener, ConversationPartViewHolder {
    final ExpandableLayout bubble;
    protected final ViewGroup cellLayout;
    private final ClipboardManager clipboardManager;
    private final String clipboardMessage;
    final ConversationListener conversationListener;
    final ImageView networkAvatar;
    private final Twig twig;

    /* renamed from: io.intercom.android.sdk.views.holder.BlocksPartViewHolder$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$blocks$BlockType = new int[BlockType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.SUBHEADING.ordinal()] = 1;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.HEADING.ordinal()] = 2;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.CODE.ordinal()] = 3;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.PARAGRAPH.ordinal()] = 4;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.LINK.ordinal()] = 5;
            $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.UNORDEREDLIST.ordinal()] = 6;
            try {
                $SwitchMap$io$intercom$android$blocks$BlockType[BlockType.ORDEREDLIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    BlocksPartViewHolder(View view, ConversationListener conversationListener2) {
        this(view, conversationListener2, null);
    }

    private static void appendLine(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(charSequence);
        }
    }

    static String getPartText(Part part) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Block block : part.getBlocks()) {
            switch (AnonymousClass1.$SwitchMap$io$intercom$android$blocks$BlockType[block.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    appendLine(spannableStringBuilder, HtmlCompat.fromHtml(block.getText()));
                    break;
                case 5:
                    appendLine(spannableStringBuilder, block.getUrl());
                    break;
                case 6:
                case 7:
                    for (String appendLine : block.getItems()) {
                        appendLine(spannableStringBuilder, appendLine);
                    }
                    break;
            }
        }
        return spannableStringBuilder.length() == 0 ? part.getSummary() : spannableStringBuilder.toString();
    }

    private void setUpRowFocusRules(View view, Part part, ExpandableLayout expandableLayout) {
        if (expandableLayout != null) {
            expandableLayout.setAlpha(1.0f);
            if (MessageState.FAILED == part.getMessageState() || MessageState.UPLOAD_FAILED == part.getMessageState()) {
                ((ViewGroup) view).setDescendantFocusability(393216);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void checkForEntranceAnimation(int i2, Part part, ImageView imageView, View view, ViewGroup viewGroup) {
        if (!part.hasEntranceAnimation()) {
            return;
        }
        if (i2 == 5) {
            part.setEntranceAnimation(false);
            imageView.setAlpha(0.0f);
            imageView.setScaleX(0.5f);
            imageView.setScaleY(0.5f);
            imageView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300).setStartDelay(100).start();
            view.setAlpha(0.0f);
            view.setScaleX(0.5f);
            view.setScaleY(0.5f);
            view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300).setStartDelay(150).start();
            ((AdminIsTypingView) viewGroup.getChildAt(0)).beginAnimation();
        } else if (MessageState.SENDING == part.getMessageState()) {
            part.setEntranceAnimation(false);
            view.setAlpha(0.0f);
            view.setTranslationY(view.getTranslationY() + 100.0f);
            view.animate().setStartDelay(100).alpha(1.0f).translationYBy(-100.0f).start();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isSingleCardPart(Part part) {
        List blocks = part.getBlocks();
        boolean z = true;
        if (blocks.size() != 1) {
            return false;
        }
        Block block = (Block) blocks.get(0);
        if (block.getType() != BlockType.MESSENGERCARD || TextUtils.isEmpty(block.getFallbackUrl())) {
            z = false;
        }
        return z;
    }

    public boolean onLongClick(View view) {
        if (this.clipboardManager == null) {
            return false;
        }
        int adapterPosition = getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        try {
            this.clipboardManager.setPrimaryClip(ClipData.newPlainText(Object.MESSAGE, getPartText(this.conversationListener.getPart(adapterPosition))));
            Toast.makeText(this.itemView.getContext(), this.clipboardMessage, 0).show();
            return true;
        } catch (Exception e2) {
            this.twig.internal(e2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public ViewGroup setUpHolderBlocks(Part part, ViewGroup viewGroup, ExpandableLayout expandableLayout, ViewGroup viewGroup2) {
        viewGroup.setVisibility(0);
        if (viewGroup2.getParent() != null) {
            ((ViewGroup) viewGroup2.getParent()).removeView(viewGroup2);
        }
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        viewGroup.addView(viewGroup2, 0);
        setUpRowFocusRules(this.itemView, part, expandableLayout);
        return viewGroup2;
    }

    /* access modifiers changed from: 0000 */
    public void showAvatar(Participant participant, ImageView imageView, AppConfig appConfig, n nVar) {
        imageView.setVisibility(0);
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), imageView, appConfig, nVar);
    }

    /* access modifiers changed from: 0000 */
    public void updateAvatarMarginForCard(Part part) {
        Resources resources = this.networkAvatar.getContext().getResources();
        int i2 = 0;
        boolean z = part.isLinkCard() || part.isLinkList() || isSingleCardPart(part);
        int dimension = z ? (int) resources.getDimension(R.dimen.intercom_card_shadow_bottom_margin) : 0;
        if (!z) {
            i2 = (int) resources.getDimension(R.dimen.intercom_conversation_row_icon_spacer);
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.networkAvatar.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, i2, dimension);
    }

    BlocksPartViewHolder(View view, ConversationListener conversationListener2, ClipboardManager clipboardManager2) {
        super(view);
        this.twig = LumberMill.getLogger();
        this.conversationListener = conversationListener2;
        this.clipboardManager = clipboardManager2;
        this.clipboardMessage = view.getContext().getString(R.string.intercom_copied_to_clipboard);
        this.networkAvatar = (ImageView) view.findViewById(R.id.avatarView);
        this.cellLayout = (ViewGroup) view.findViewById(R.id.cellLayout);
        this.bubble = (ExpandableLayout) view.findViewById(R.id.intercom_bubble);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }
}
