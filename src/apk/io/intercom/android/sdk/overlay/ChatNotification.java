package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.com.bumptech.glide.n;

abstract class ChatNotification extends InAppNotification {
    private static final int ANIMATION_DURATION = 170;
    private static final int GROWTH_WIDTH = 355;
    private final n requestManager;

    protected ChatNotification(Context context, Conversation conversation, int i2, int i3, Listener listener, Provider<AppConfig> provider, n nVar) {
        super(context, conversation, i2, i3, listener, provider);
        this.requestManager = nVar;
    }

    private void expandChat(ViewGroup viewGroup, AnimatorListenerAdapter animatorListenerAdapter) {
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.chathead_text_container);
        if (viewGroup2 != null) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.chathead_text_header);
            View contentContainer = getContentContainer();
            LayoutParams layoutParams = (LayoutParams) viewGroup2.getLayoutParams();
            View findViewById = viewGroup.findViewById(R.id.chat_avatar_container);
            float translationX = findViewById.getTranslationX();
            float translationY = findViewById.getTranslationY();
            ObjectAnimator.ofPropertyValuesHolder(findViewById, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.8f}), PropertyValuesHolder.ofFloat("translationX", new float[]{translationX, translationX + 100.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{translationY, translationY - 40.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.8f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.8f})}).setDuration(170).start();
            ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(170).start();
            ObjectAnimator.ofFloat(contentContainer, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(170).start();
            getWidthAnimator(viewGroup2, animatorListenerAdapter).start();
            getWidthAnimator(this.overlayRoot).start();
            getMarginAnimator(viewGroup2, layoutParams).start();
        }
    }

    private Animator getMarginAnimator(final ViewGroup viewGroup, LayoutParams layoutParams) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{layoutParams.leftMargin, 0});
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LayoutParams layoutParams = (LayoutParams) viewGroup.getLayoutParams();
                layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                viewGroup.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(170);
        return ofInt;
    }

    private Animator getWidthAnimator(ViewGroup viewGroup, final AnimatorListener animatorListener) {
        final int abs = Math.abs(viewGroup.getMeasuredWidth() - ScreenUtils.dpToPx(355.0f, viewGroup.getContext()));
        ValueAnimator widthAnimator = getWidthAnimator(viewGroup);
        widthAnimator.addUpdateListener(new AnimatorUpdateListener() {
            boolean hasSentUpdate = false;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i2 = abs;
                int i3 = 100;
                if (i2 > 0) {
                    i3 = (intValue / i2) * 100;
                }
                if (i3 > 80 && !this.hasSentUpdate) {
                    this.hasSentUpdate = true;
                    animatorListener.onAnimationEnd(null);
                }
            }
        });
        return widthAnimator;
    }

    private void performEntranceAnimation() {
        View findViewById = this.overlayRoot.findViewById(R.id.chat_avatar_container);
        final ViewGroup viewGroup = (ViewGroup) this.overlayRoot.findViewById(R.id.chat_full_body);
        viewGroup.setVisibility(4);
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(findViewById, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})}).setDuration(400);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ChatNotification.this.animateTextContainer(viewGroup);
            }
        });
        duration.start();
    }

    private void populateViewsWithData(n nVar) {
        View findViewById = this.overlayRoot.findViewById(R.id.chathead_root);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.chathead_avatar);
        TextView textView = (TextView) findViewById.findViewById(R.id.chathead_text_header);
        ColorUtils.setTextColorPrimaryOrDark(textView, (AppConfig) this.appConfigProvider.get());
        FontUtils.setRobotoMediumTypeface(textView);
        AvatarUtils.loadAvatarIntoView(this.conversation.getLastAdmin().getAvatar(), imageView, (AppConfig) this.appConfigProvider.get(), nVar);
        textView.setText(getHeaderText());
        updateContentContainer(this.conversation.getLastPart());
    }

    /* access modifiers changed from: 0000 */
    public void animateTextContainer(ViewGroup viewGroup) {
        int x = ((int) viewGroup.getX()) - 150;
        int x2 = (int) viewGroup.getX();
        viewGroup.setScaleX(0.8f);
        viewGroup.setScaleY(0.8f);
        viewGroup.setAlpha(0.8f);
        viewGroup.setX((float) x);
        viewGroup.setVisibility(0);
        viewGroup.animate().setInterpolator(new OvershootInterpolator(0.6f)).scaleX(1.0f).scaleY(1.0f).alphaBy(1.0f).translationX((float) x2).setDuration(300).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ChatNotification.this.beginListeningForTouchEvents();
            }
        }).start();
    }

    public void display(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z, int i2) {
        if (this.overlayRoot == null) {
            this.overlayRoot = inflateChatRootView(viewGroup, layoutInflater);
        }
        if (!isAttached()) {
            viewGroup.addView(this.overlayRoot, 0);
        }
        if (this.bottomPadding != i2) {
            LayoutParams layoutParams = (LayoutParams) this.overlayRoot.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin + this.overlayRoot.getResources().getDimensionPixelSize(R.dimen.intercom_bottom_padding) + i2);
            this.overlayRoot.setLayoutParams(layoutParams);
            this.bottomPadding = i2;
        }
        populateViewsWithData(this.requestManager);
        if (z) {
            performEntranceAnimation();
            return;
        }
        this.overlayRoot.setVisibility(0);
        beginListeningForTouchEvents();
    }

    /* access modifiers changed from: protected */
    public abstract View getContentContainer();

    /* access modifiers changed from: protected */
    public abstract ViewGroup inflateChatRootView(ViewGroup viewGroup, LayoutInflater layoutInflater);

    public void moveBackward(ViewGroup viewGroup, AnimatorListenerAdapter animatorListenerAdapter) {
        this.position++;
        animateToPosition(viewGroup.getContext());
        expandChat(viewGroup, animatorListenerAdapter);
    }

    /* access modifiers changed from: protected */
    public void onNotificationPressed(View view) {
        view.animate().scaleX(0.9f).scaleY(0.9f).alpha(0.9f).setDuration(50).start();
    }

    /* access modifiers changed from: protected */
    public void onNotificationReleased(View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(50).start();
    }

    /* access modifiers changed from: protected */
    public abstract void updateContentContainer(Part part);

    /* access modifiers changed from: protected */
    public abstract void updateViewDataDuringReplyPulse(int i2);

    private ValueAnimator getWidthAnimator(final ViewGroup viewGroup) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{viewGroup.getMeasuredWidth(), ScreenUtils.dpToPx(355.0f, viewGroup.getContext())});
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LayoutParams layoutParams = (LayoutParams) viewGroup.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                viewGroup.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(170);
        return ofInt;
    }
}
