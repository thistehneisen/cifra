package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.TextView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.views.LockableScrollView;
import io.intercom.com.bumptech.glide.n;

public class ContainerCardViewHolder extends BlocksPartViewHolder {
    private Provider<AppConfig> appConfigProvider;
    ImageView arrowExpander;
    private final View fade;
    final LockableScrollView lockableScrollView;
    private final n requestManager;
    private final TextView title;
    private final int viewType;

    public ContainerCardViewHolder(View view, int i2, ConversationListener conversationListener, ClipboardManager clipboardManager, boolean z, Provider<AppConfig> provider, n nVar) {
        super(view, conversationListener, clipboardManager);
        this.viewType = i2;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.title = (TextView) view.findViewById(R.id.intercom_container_card_title);
        this.fade = view.findViewById(R.id.intercom_container_fade_view);
        this.lockableScrollView = (LockableScrollView) view.findViewById(R.id.cell_content);
        this.lockableScrollView.setScrollingEnabled(false);
        if (i2 == 3) {
            if (z) {
                this.arrowExpander = (ImageView) view.findViewById(R.id.expand_arrow);
            }
            this.lockableScrollView.setExpanded(!z);
        } else {
            this.lockableScrollView.setExpanded(false);
        }
        final View findViewById = view.findViewById(R.id.cellLayout);
        findViewById.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                findViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                ContainerCardViewHolder.this.setupViews();
                return false;
            }
        });
    }

    private boolean contentIsOverflowing() {
        if (this.lockableScrollView.getChildAt(0).getMeasuredHeight() > this.lockableScrollView.getMaxHeight()) {
            return true;
        }
        return false;
    }

    private void layoutForCollapsedNoteWithArrow() {
        ImageView imageView = this.arrowExpander;
        int i2 = 0;
        if (imageView != null) {
            imageView.setVisibility(contentIsOverflowing() ? 0 : 8);
            this.arrowExpander.setScaleY(1.0f);
        }
        View view = this.fade;
        if (!contentIsOverflowing()) {
            i2 = 4;
        }
        view.setVisibility(i2);
    }

    private void layoutForExpandedNoteWithArrow() {
        ImageView imageView = this.arrowExpander;
        if (imageView != null) {
            imageView.setVisibility(contentIsOverflowing() ? 0 : 8);
            this.arrowExpander.setScaleY(-1.0f);
        }
        this.fade.setVisibility(4);
    }

    private void layoutForExpandedNoteWithoutArrow() {
        ImageView imageView = this.arrowExpander;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.fade.setVisibility(4);
    }

    private void layoutForPost() {
        ImageView imageView = this.arrowExpander;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.fade.setVisibility(contentIsOverflowing() ? 0 : 4);
    }

    private void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.lockableScrollView.post(runnable);
        }
    }

    public void bind(Part part, ViewGroup viewGroup) {
        ViewGroup upHolderBlocks = setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        showAvatar(part.getParticipant(), this.networkAvatar, (AppConfig) this.appConfigProvider.get(), this.requestManager);
        String str = "company";
        this.title.setText(Phrase.from(this.title.getContext(), R.string.intercom_teammate_from_company).put("name", (CharSequence) part.getParticipant().getForename()).put(str, (CharSequence) ((AppConfig) this.appConfigProvider.get()).getName()).format());
        checkForEntranceAnimation(this.viewType, part, this.networkAvatar, this.cellLayout, upHolderBlocks);
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationListener.onContainerCardClicked(adapterPosition, this);
        }
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    /* access modifiers changed from: 0000 */
    public void setupViews() {
        if (this.viewType == 2) {
            layoutForPost();
        } else if (this.arrowExpander == null) {
            layoutForExpandedNoteWithoutArrow();
        } else if (this.lockableScrollView.isExpanded()) {
            layoutForExpandedNoteWithArrow();
        } else {
            layoutForCollapsedNoteWithArrow();
        }
    }

    public void toggleExpanded() {
        runOnMainThread(new Runnable() {
            public void run() {
                ImageView imageView = ContainerCardViewHolder.this.arrowExpander;
                if (imageView != null && imageView.getVisibility() == 0) {
                    ContainerCardViewHolder.this.lockableScrollView.toggleExpanded();
                    ContainerCardViewHolder.this.setupViews();
                }
            }
        });
    }
}
