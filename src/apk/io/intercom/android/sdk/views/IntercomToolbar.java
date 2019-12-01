package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.com.bumptech.glide.n;
import java.io.IOException;

public class IntercomToolbar extends Toolbar implements OnTouchListener, OnClickListener {
    private static final int TITLE_FADE_DURATION_MS = 150;
    private final View activeStateView;
    private final ImageView avatar;
    private final ImageButton backButton;
    private final BackButtonCountDrawable backButtonCountDrawable;
    private final ImageView backgroundImage;
    private final ImageButton close;
    private Listener listener;
    private final TextView subtitle;
    final TextView title;

    public interface Listener {
        void onCloseClicked();

        void onInboxClicked();

        void onToolbarClicked();
    }

    public IntercomToolbar(Context context) {
        this(context, null);
    }

    public void animateBackButton() {
        ImageButton imageButton = this.backButton;
        imageButton.startAnimation(AnimationUtils.loadAnimation(imageButton.getContext(), R.anim.intercom_profile_slide_in));
    }

    public void closeWallpaperLoader(WallpaperLoader wallpaperLoader) {
        try {
            wallpaperLoader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void fadeOutTitle(int i2) {
        this.title.animate().alpha(0.0f).setDuration((long) i2).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomToolbar.this.title.setText(null);
            }
        }).start();
    }

    public void loadWallpaper(WallpaperLoader wallpaperLoader) {
        wallpaperLoader.loadWallpaperInto(this.backgroundImage);
    }

    public void onClick(View view) {
        if (this.listener != null) {
            int id = view.getId();
            if (id == R.id.intercom_toolbar_close) {
                this.listener.onCloseClicked();
            } else if (id == R.id.intercom_toolbar_inbox) {
                this.listener.onInboxClicked();
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.listener != null && motionEvent.getAction() == 1 && view.getId() == R.id.intercom_toolbar) {
            this.listener.onToolbarClicked();
        }
        return false;
    }

    public void setCloseButtonVisibility(int i2) {
        this.close.setVisibility(i2);
    }

    public void setLeftNavigationIcon(Drawable drawable) {
        this.backButton.setImageDrawable(drawable);
    }

    public void setLeftNavigationItemVisibility(int i2) {
        this.backButton.setVisibility(i2);
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.subtitle.setText(charSequence);
        if (!TextUtils.isEmpty(charSequence)) {
            this.subtitle.setAlpha(1.0f);
        }
    }

    public void setSubtitleVisibility(int i2) {
        this.subtitle.setVisibility(i2);
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            fadeOutTitle(TITLE_FADE_DURATION_MS);
            return;
        }
        this.title.setAlpha(1.0f);
        this.title.setText(charSequence);
    }

    public void setUnreadCount(Integer num) {
        this.backButtonCountDrawable.setText(num.intValue() > 0 ? Integer.toString(num.intValue()) : null);
    }

    public void setUpHelpCenterToolbar(AppConfig appConfig) {
        boolean helpCenterColorRenderDarkText = appConfig.helpCenterColorRenderDarkText();
        ColorUtils.setTextColorWhiteOrBlack(this.title, helpCenterColorRenderDarkText);
        ColorUtils.setTextColorWhiteOrBlack(this.subtitle, helpCenterColorRenderDarkText);
        ColorUtils.setImageColorWhiteOrBlack(this.close, helpCenterColorRenderDarkText);
        ColorUtils.setImageColorWhiteOrBlack(this.backButton, helpCenterColorRenderDarkText);
    }

    public void setUpNoteToolbar(Participant participant, boolean z, ActiveStatePresenter activeStatePresenter, AppConfig appConfig, n nVar) {
        this.title.setTextColor(a.a(getContext(), R.color.intercom_note_title_grey));
        this.subtitle.setTextColor(a.a(getContext(), R.color.intercom_note_grey));
        this.close.setColorFilter(a.a(getContext(), R.color.intercom_grey_500));
        this.backButton.setVisibility(8);
        this.avatar.setVisibility(0);
        this.activeStateView.setVisibility(0);
        this.title.setTextSize(14.0f);
        this.subtitle.setAlpha(1.0f);
        View findViewById = findViewById(R.id.intercom_toolbar_divider);
        findViewById.setVisibility(0);
        findViewById.setBackgroundColor(-16777216);
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), this.avatar, appConfig, nVar);
        activeStatePresenter.presentStateDot(z, this.activeStateView, appConfig);
    }

    public void setUpPostToolbar(Participant participant, boolean z, ActiveStatePresenter activeStatePresenter, AppConfig appConfig, n nVar) {
        setBackgroundColor(0);
        this.title.setTextColor(-1);
        this.close.setColorFilter(-1);
        this.backButton.setVisibility(8);
        this.avatar.setVisibility(0);
        this.activeStateView.setVisibility(0);
        this.title.setTextSize(14.0f);
        this.subtitle.setAlpha(0.7f);
        findViewById(R.id.intercom_toolbar_divider).setVisibility(0);
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), this.avatar, appConfig, nVar);
        activeStatePresenter.presentStateDot(z, this.activeStateView, appConfig);
    }

    public void updateToolbarColors(AppConfig appConfig) {
        boolean secondaryColorRenderDarkText = appConfig.secondaryColorRenderDarkText();
        ColorUtils.setTextColorWhiteOrBlack(this.title, secondaryColorRenderDarkText);
        ColorUtils.setTextColorWhiteOrBlack(this.subtitle, secondaryColorRenderDarkText);
        ColorUtils.setImageColorWhiteOrBlack(this.close, secondaryColorRenderDarkText);
        ColorUtils.setImageColorWhiteOrBlack(this.backButton, secondaryColorRenderDarkText);
    }

    public void updateToolbarSize() {
        int statusBarHeight = WindowUtils.getStatusBarHeight(getResources());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.intercom_toolbar_height);
        View findViewById = findViewById(R.id.toolbar_content_container);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + statusBarHeight, layoutParams.rightMargin, layoutParams.bottomMargin);
        findViewById.setLayoutParams(layoutParams);
        getLayoutParams().height = dimensionPixelSize + statusBarHeight;
        requestLayout();
    }

    public IntercomToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ViewGroup.inflate(context, R.layout.intercom_toolbar, this);
        inflate.setOnTouchListener(this);
        this.title = (TextView) inflate.findViewById(R.id.intercom_toolbar_title);
        this.subtitle = (TextView) inflate.findViewById(R.id.intercom_toolbar_subtitle);
        this.close = (ImageButton) inflate.findViewById(R.id.intercom_toolbar_close);
        this.backButton = (ImageButton) inflate.findViewById(R.id.intercom_toolbar_inbox);
        this.avatar = (ImageView) inflate.findViewById(R.id.intercom_toolbar_avatar);
        this.activeStateView = inflate.findViewById(R.id.intercom_toolbar_avatar_active_state);
        this.backgroundImage = (ImageView) inflate.findViewById(R.id.wallpaper_image);
        this.backButtonCountDrawable = new BackButtonCountDrawable(getContext(), null);
        this.backButton.setImageDrawable(this.backButtonCountDrawable);
        this.backButton.setOnClickListener(this);
        this.close.setOnClickListener(this);
    }
}
