package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Part;
import io.intercom.com.bumptech.glide.n;

public class LinkListViewHolder extends BlocksPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;
    private final n requestManager;

    public LinkListViewHolder(View view, ConversationListener conversationListener, Provider<AppConfig> provider, n nVar) {
        super(view, conversationListener, null);
        this.appConfigProvider = provider;
        this.requestManager = nVar;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        if (this.networkAvatar != null) {
            showAvatar(part.getParticipant(), this.networkAvatar, (AppConfig) this.appConfigProvider.get(), this.requestManager);
            updateAvatarMarginForCard(part);
        }
    }

    public void onClick(View view) {
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }
}
