package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.com.bumptech.glide.n;

public class LinkViewHolder extends BlocksPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;
    private final n requestManager;
    private final int viewType;

    public LinkViewHolder(View view, int i2, ConversationListener conversationListener, ClipboardManager clipboardManager, Provider<AppConfig> provider, n nVar) {
        super(view, conversationListener, clipboardManager);
        this.viewType = i2;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        if (VERSION.SDK_INT >= 21) {
            this.cellLayout.setTransitionName("link_background");
        }
    }

    public void bind(Part part, ViewGroup viewGroup) {
        ColorUtils.updateInnerBorderColor((AppConfig) this.appConfigProvider.get(), this.cellLayout);
        ViewGroup upHolderBlocks = setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        int dpToPx = ScreenUtils.dpToPx(16.0f, this.itemView.getContext());
        int dpToPx2 = ScreenUtils.dpToPx(24.0f, this.itemView.getContext());
        upHolderBlocks.setPadding(dpToPx, dpToPx2, dpToPx, dpToPx2);
        checkForEntranceAnimation(this.viewType, part, this.networkAvatar, this.cellLayout, upHolderBlocks);
        if (this.networkAvatar != null) {
            showAvatar(part.getParticipant(), this.networkAvatar, (AppConfig) this.appConfigProvider.get(), this.requestManager);
            updateAvatarMarginForCard(part);
        }
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationListener.onLinkClicked(adapterPosition, this.cellLayout);
        }
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }
}
