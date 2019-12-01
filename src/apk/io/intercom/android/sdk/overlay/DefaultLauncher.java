package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;

class DefaultLauncher implements OnTouchListener {
    private static final int ANIMATION_DURATION_MS = 300;
    private final ImageButton badge = ((ImageButton) this.launcherRoot.findViewById(R.id.launcher_icon));
    private final TextView badgeCount = ((TextView) this.launcherRoot.findViewById(R.id.launcher_badge_count));
    final View launcherRoot;
    final Listener listener;

    public interface Listener {
        void onLauncherClicked(Context context);
    }

    public DefaultLauncher(ViewGroup viewGroup, LayoutInflater layoutInflater, Listener listener2, int i2) {
        this.listener = listener2;
        layoutInflater.inflate(R.layout.intercom_default_launcher, viewGroup, true);
        this.launcherRoot = viewGroup.findViewById(R.id.launcher_root);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.launcherRoot.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i2);
        this.launcherRoot.setLayoutParams(marginLayoutParams);
        this.launcherRoot.setOnTouchListener(this);
    }

    private void callListenerWithFadeOut() {
        this.launcherRoot.setAlpha(1.0f);
        this.launcherRoot.animate().alpha(0.0f).setDuration(50).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                DefaultLauncher defaultLauncher = DefaultLauncher.this;
                defaultLauncher.listener.onLauncherClicked(defaultLauncher.launcherRoot.getContext());
            }
        }).start();
    }

    public void fadeOffScreen(AnimatorListener animatorListener) {
        this.launcherRoot.animate().alpha(0.0f).setDuration(100).setListener(animatorListener).start();
    }

    public void fadeOnScreen() {
        this.launcherRoot.setAlpha(0.0f);
        this.launcherRoot.animate().alpha(1.0f).setDuration(100).start();
    }

    public void hideBadgeCount() {
        this.badgeCount.setVisibility(8);
    }

    public boolean isAttachedToRoot(ViewGroup viewGroup) {
        return this.launcherRoot.getParent() == viewGroup;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setScaleX(0.9f);
            view.setScaleY(0.9f);
        } else if (action == 1) {
            callListenerWithFadeOut();
        }
        return true;
    }

    public void pulseForTransformation(final AnimatorListener animatorListener) {
        this.launcherRoot.animate().scaleX(1.1f).scaleY(1.1f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animatorListener.onAnimationEnd(animator);
                DefaultLauncher.this.launcherRoot.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
            }
        }).start();
    }

    public void removeView() {
        if (this.launcherRoot.getParent() != null) {
            ((ViewGroup) this.launcherRoot.getParent()).removeView(this.launcherRoot);
        }
    }

    public void setBadgeCount(String str) {
        this.badgeCount.setVisibility(0);
        this.badgeCount.setText(str);
    }

    public void setLauncherColor(AppConfig appConfig, int i2) {
        Context context = this.badge.getContext();
        Drawable c2 = a.c(context, R.drawable.intercom_solid_circle);
        c2.setColorFilter(i2, Mode.SRC_IN);
        Drawable newDrawable = c2.getConstantState().newDrawable();
        newDrawable.setColorFilter(a.a(context, R.color.intercom_inbox_count_background), Mode.SRC_IN);
        BackgroundUtils.setBackground(this.badgeCount, newDrawable);
        BackgroundUtils.setBackground(this.badge, c2);
        ColorUtils.setImageSrcColorWhiteOrDark(this.badge, appConfig.primaryColorRenderDarkText());
    }

    public void updateBottomPadding(int i2) {
        final MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.launcherRoot.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{marginLayoutParams.bottomMargin, i2});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MarginLayoutParams marginLayoutParams = marginLayoutParams;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                DefaultLauncher.this.launcherRoot.setLayoutParams(marginLayoutParams);
            }
        });
        ofInt.start();
    }
}
