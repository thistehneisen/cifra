package io.intercom.android.sdk.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.Blocks;
import io.intercom.android.sdk.blocks.ButtonClickListener;
import io.intercom.android.sdk.blocks.ImageClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.com.bumptech.glide.n;

class ChatFull extends ChatNotification {
    private final Activity activity;
    private final MetricTracker metricTracker;
    private final n requestManager;

    private static class ChatFullButtonClickListener implements ButtonClickListener {
        private ChatFullButtonClickListener() {
        }

        public void onButtonClicked(View view, String str) {
        }

        public boolean shouldHandleClicks() {
            return false;
        }
    }

    private static class ChatFullImageClickListener implements ImageClickListener {
        private ChatFullImageClickListener() {
        }

        public void onImageClicked(String str, String str2, ImageView imageView, int i2, int i3) {
        }
    }

    ChatFull(Context context, Conversation conversation, int i2, int i3, Listener listener, MetricTracker metricTracker2, Provider<AppConfig> provider, n nVar, Activity activity2) {
        super(context, conversation, i2, i3, listener, provider, nVar);
        this.metricTracker = metricTracker2;
        this.requestManager = nVar;
        this.activity = activity2;
    }

    /* access modifiers changed from: protected */
    public View getContentContainer() {
        return ((ViewGroup) this.overlayRoot.findViewById(R.id.chathead_text_container)).getChildAt(1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateChatRootView(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.intercom_preview_chat_full_overlay, viewGroup, false);
        Blocks blocks = new Blocks(this.localisedContext, LumberMill.getBlocksTwig());
        Injector injector = Injector.get();
        Api api = injector.getApi();
        Api api2 = api;
        ViewHolderGenerator viewHolderGenerator = new ViewHolderGenerator(new UploadingImageCache(), api, this.appConfigProvider, this.conversation.getId(), new ChatFullImageClickListener(), new ChatFullButtonClickListener(), this.requestManager, injector.getGson(), injector.getBus(), this.metricTracker, this.activity);
        LinearLayout createBlocks = blocks.createBlocks(this.conversation.getLastPart().getBlocks(), viewHolderGenerator.getChatFullHolder());
        final ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.chathead_text_container);
        viewGroup3.addView(createBlocks);
        viewGroup3.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                viewGroup3.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = viewGroup3.getMeasuredHeight();
                int i2 = ((MarginLayoutParams) viewGroup3.getLayoutParams()).bottomMargin;
                Resources resources = ChatFull.this.localisedContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.intercom_chat_full_top_margin);
                if (measuredHeight < ((ChatFull.this.screenHeight - dimensionPixelSize) - i2) - resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding)) {
                    return true;
                }
                viewGroup2.findViewById(R.id.chat_overlay_overflow_fade).setVisibility(0);
                return false;
            }
        });
        api2.markConversationAsRead(this.conversation.getId());
        this.metricTracker.viewedInApp(this.conversation.getId(), this.conversation.getLastPart().getId(), 1);
        return viewGroup2;
    }

    public void update(Conversation conversation, Runnable runnable) {
    }

    /* access modifiers changed from: protected */
    public void updateContentContainer(Part part) {
    }

    /* access modifiers changed from: protected */
    public void updateViewDataDuringReplyPulse(int i2) {
    }
}
