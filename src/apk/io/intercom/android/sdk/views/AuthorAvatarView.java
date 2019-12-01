package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.com.bumptech.glide.n;
import java.util.List;

public class AuthorAvatarView extends FrameLayout {
    private final ActiveStatePresenter activeStatePresenter;
    private final int activeStateSize;
    private final View activeStateView;
    private final int imageViewSize;
    private final ImageView leftImageView;
    private final ImageView rightImageView;
    private final int teamAvatarPadding;
    private final ImageView topImageView;

    public AuthorAvatarView(Context context) {
        this(context, null);
    }

    private void loadDefaultDrawable(AppConfig appConfig) {
        this.leftImageView.setLayoutParams(new LayoutParams(-1, -1));
        this.leftImageView.setPadding(0, 0, 0, 0);
        setNumberOfVisibleAvatars(1);
        this.activeStateView.setVisibility(8);
        requestLayout();
        ImageView imageView = this.leftImageView;
        imageView.setImageDrawable(AvatarUtils.getDefaultDrawable(imageView.getContext(), appConfig));
    }

    private void loadThreeAvatars(Participant participant, Participant participant2, Participant participant3, AppConfig appConfig, n nVar) {
        ImageView imageView = this.leftImageView;
        int i2 = this.imageViewSize;
        imageView.setLayoutParams(new LayoutParams(i2, i2, 83));
        ImageView imageView2 = this.leftImageView;
        int i3 = this.teamAvatarPadding;
        imageView2.setPadding(i3, i3, i3, i3);
        ImageView imageView3 = this.rightImageView;
        int i4 = this.imageViewSize;
        imageView3.setLayoutParams(new LayoutParams(i4, i4, 85));
        ImageView imageView4 = this.topImageView;
        int i5 = this.imageViewSize;
        imageView4.setLayoutParams(new LayoutParams(i5, i5, 49));
        this.activeStateView.setVisibility(8);
        setNumberOfVisibleAvatars(3);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), this.leftImageView, appConfig, nVar);
        AvatarUtils.loadAvatarIntoView(participant2.getAvatar(), this.rightImageView, appConfig, nVar);
        AvatarUtils.loadAvatarIntoView(participant3.getAvatar(), this.topImageView, appConfig, nVar);
    }

    private void loadTwoAvatars(Participant participant, Participant participant2, AppConfig appConfig, n nVar) {
        ImageView imageView = this.leftImageView;
        int i2 = this.imageViewSize;
        imageView.setLayoutParams(new LayoutParams(i2, i2, 19));
        ImageView imageView2 = this.leftImageView;
        int i3 = this.teamAvatarPadding;
        imageView2.setPadding(i3, i3, i3, i3);
        ImageView imageView3 = this.rightImageView;
        int i4 = this.imageViewSize;
        imageView3.setLayoutParams(new LayoutParams(i4, i4, 21));
        setNumberOfVisibleAvatars(2);
        this.activeStateView.setVisibility(8);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), this.leftImageView, appConfig, nVar);
        AvatarUtils.loadAvatarIntoView(participant2.getAvatar(), this.rightImageView, appConfig, nVar);
    }

    private void setNumberOfVisibleAvatars(int i2) {
        int i3 = 0;
        this.leftImageView.setVisibility(i2 >= 1 ? 0 : 8);
        this.rightImageView.setVisibility(i2 >= 2 ? 0 : 8);
        ImageView imageView = this.topImageView;
        if (i2 < 3) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void loadAvatar(Avatar avatar, AppConfig appConfig, n nVar) {
        this.leftImageView.setLayoutParams(new LayoutParams(-1, -1));
        this.leftImageView.setPadding(0, 0, 0, 0);
        setNumberOfVisibleAvatars(1);
        this.activeStateView.setVisibility(8);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(avatar, this.leftImageView, appConfig, nVar);
    }

    public void loadAvatarWithActiveState(Avatar avatar, boolean z, AppConfig appConfig, n nVar) {
        this.leftImageView.setLayoutParams(new LayoutParams(-1, -1));
        this.leftImageView.setPadding(0, 0, 0, 0);
        setNumberOfVisibleAvatars(1);
        this.activeStatePresenter.presentStateDot(z, this.activeStateView, appConfig);
        this.activeStateView.setVisibility(0);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(avatar, this.leftImageView, appConfig, nVar);
    }

    public void loadAvatars(List<Participant> list, AppConfig appConfig, n nVar) {
        int size = list.size();
        if (size == 0) {
            loadDefaultDrawable(appConfig);
        } else if (size == 1) {
            loadAvatar(((Participant) list.get(0)).getAvatar(), appConfig, nVar);
        } else if (size != 2) {
            loadThreeAvatars((Participant) list.get(0), (Participant) list.get(1), (Participant) list.get(2), appConfig, nVar);
        } else {
            loadTwoAvatars((Participant) list.get(0), (Participant) list.get(1), appConfig, nVar);
        }
    }

    /* JADX INFO: finally extract failed */
    public AuthorAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activeStatePresenter = new ActiveStatePresenter();
        this.rightImageView = new ImageView(context);
        this.topImageView = new ImageView(context);
        this.leftImageView = new ImageView(context);
        this.activeStateView = new View(context);
        addView(this.rightImageView);
        addView(this.topImageView);
        addView(this.leftImageView);
        addView(this.activeStateView);
        this.leftImageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        this.rightImageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        this.topImageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        this.activeStateView.setVisibility(8);
        this.teamAvatarPadding = ScreenUtils.dpToPx(1.0f, context);
        ImageView imageView = this.leftImageView;
        int i2 = this.teamAvatarPadding;
        imageView.setPadding(i2, i2, i2, i2);
        ImageView imageView2 = this.rightImageView;
        int i3 = this.teamAvatarPadding;
        imageView2.setPadding(i3, i3, i3, i3);
        ImageView imageView3 = this.topImageView;
        int i4 = this.teamAvatarPadding;
        imageView3.setPadding(i4, i4, i4, i4);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AuthorAvatarView, 0, 0);
        try {
            this.imageViewSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AuthorAvatarView_avatarSize, 0);
            this.activeStateSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AuthorAvatarView_activeStateSize, 0);
            obtainStyledAttributes.recycle();
            View view = this.activeStateView;
            int i5 = this.activeStateSize;
            view.setLayoutParams(new LayoutParams(i5, i5, 85));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
