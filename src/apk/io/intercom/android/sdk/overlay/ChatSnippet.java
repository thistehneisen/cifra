package io.intercom.android.sdk.overlay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.com.bumptech.glide.n;

class ChatSnippet extends ChatNotification {
    private TextView contentBody;
    private final n requestManager;

    public ChatSnippet(Context context, Conversation conversation, int i2, int i3, Listener listener, Provider<AppConfig> provider, n nVar) {
        super(context, conversation, i2, i3, listener, provider, nVar);
        this.requestManager = nVar;
    }

    private void setBodyText(Part part) {
        if (part.getSummary().isEmpty()) {
            this.contentBody.setText(this.localisedContext.getString(R.string.intercom_image_attached));
        } else {
            this.contentBody.setText(part.getSummary());
        }
    }

    /* access modifiers changed from: protected */
    public View getContentContainer() {
        return this.overlayRoot.findViewById(R.id.chathead_text_body);
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateChatRootView(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.intercom_preview_chat_snippet_overlay, viewGroup, false);
        this.contentBody = (TextView) layoutInflater.inflate(R.layout.intercom_preview_chat_snippet_body, viewGroup2, false);
        ((ViewGroup) viewGroup2.findViewById(R.id.chathead_text_container)).addView(this.contentBody);
        return viewGroup2;
    }

    public void update(Conversation conversation, Runnable runnable) {
        this.conversation = conversation;
        View findViewById = this.overlayRoot.findViewById(R.id.chathead_text_body);
        View findViewById2 = this.overlayRoot.findViewById(R.id.chathead_text_container);
        findViewById2.setPivotX(0.0f);
        performReplyPulse(findViewById2, findViewById, runnable);
    }

    /* access modifiers changed from: protected */
    public void updateContentContainer(Part part) {
        setBodyText(part);
    }

    /* access modifiers changed from: protected */
    public void updateViewDataDuringReplyPulse(int i2) {
        AvatarUtils.loadAvatarIntoView(this.conversation.getLastAdmin().getAvatar(), (ImageView) this.overlayRoot.findViewById(R.id.chathead_avatar), (AppConfig) this.appConfigProvider.get(), this.requestManager);
        ((TextView) this.overlayRoot.findViewById(R.id.chathead_text_header)).setText(getHeaderText());
        setBodyText(this.conversation.getLastPart());
    }
}
