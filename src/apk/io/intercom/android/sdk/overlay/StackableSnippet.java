package io.intercom.android.sdk.overlay;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.com.bumptech.glide.n;

class StackableSnippet extends InAppNotification implements OnTouchListener {
    private static final int BASE_ELEVATION = 18;
    private static final int BASE_MARGIN_DP = 16;
    private static final int ELEVATION_STEP = 3;
    private final Handler handler;
    private final n requestManager;

    public StackableSnippet(Context context, Conversation conversation, int i2, Handler handler2, int i3, Listener listener, Provider<AppConfig> provider, n nVar) {
        super(context, conversation, i2, i3, listener, provider);
        this.handler = handler2;
        this.requestManager = nVar;
    }

    private void animateOnScreen() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                StackableSnippet.this.overlayRoot.setVisibility(0);
                StackableSnippet stackableSnippet = StackableSnippet.this;
                stackableSnippet.overlayRoot.setY((float) stackableSnippet.screenHeight);
                StackableSnippet.this.overlayRoot.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
            }
        }, (long) (this.position * 70));
    }

    private void setViewData(int i2) {
        Context context = this.overlayRoot.getContext();
        AppConfig appConfig = (AppConfig) this.appConfigProvider.get();
        TextView textView = (TextView) this.overlayRoot.findViewById(R.id.preview_name);
        FontUtils.setRobotoMediumTypeface(textView);
        textView.setTextColor(appConfig.getPrimaryColor());
        textView.setText(getHeaderText());
        ((TextView) this.overlayRoot.findViewById(R.id.preview_summary)).setText(this.conversation.getLastPart().getSummary());
        AvatarUtils.loadAvatarIntoView(this.conversation.getLastAdmin().getAvatar(), (ImageView) this.overlayRoot.findViewById(R.id.preview_avatar), appConfig, this.requestManager);
        ((LayoutParams) this.overlayRoot.getLayoutParams()).bottomMargin = ScreenUtils.dpToPx((float) ((this.position * 8) + 16), context) + context.getResources().getDimensionPixelSize(R.dimen.intercom_bottom_padding) + i2;
        if (VERSION.SDK_INT >= 21) {
            this.overlayRoot.setElevation((float) (18 - (this.position * 3)));
        }
        this.overlayRoot.setScaleX(1.0f - (((float) this.position) * 0.05f));
        if (this.position == 0) {
            beginListeningForTouchEvents();
        }
    }

    private void setupView(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        if (this.overlayRoot == null) {
            this.overlayRoot = (LinearLayout) layoutInflater.inflate(R.layout.intercom_preview_notification, viewGroup, false);
        }
        if (!isAttached()) {
            viewGroup.addView(this.overlayRoot, 0);
        }
    }

    public void display(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z, int i2) {
        setupView(viewGroup, layoutInflater);
        setViewData(i2);
        if (z) {
            animateOnScreen();
        } else {
            this.overlayRoot.setVisibility(0);
        }
    }

    public void moveBackward(ViewGroup viewGroup, AnimatorListenerAdapter animatorListenerAdapter) {
        this.position++;
        animateToPosition(viewGroup.getContext());
    }

    /* access modifiers changed from: protected */
    public void onNotificationPressed(View view) {
        view.animate().scaleX(0.95f).scaleY(0.95f).setDuration(50).start();
    }

    /* access modifiers changed from: protected */
    public void onNotificationReleased(View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(50).start();
    }

    public void update(Conversation conversation, Runnable runnable) {
        this.conversation = conversation;
        performReplyPulse(this.overlayRoot.findViewById(R.id.notification_root), this.overlayRoot.findViewById(R.id.preview_summary), runnable);
    }

    /* access modifiers changed from: protected */
    public void updateViewDataDuringReplyPulse(int i2) {
        setViewData(i2);
    }
}
