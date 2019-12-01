package io.intercom.android.sdk.profile;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.c;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.android.sdk.views.OfficeHoursTextView;
import io.intercom.com.bumptech.glide.n;
import java.util.Arrays;
import java.util.List;

class TeamProfilePresenter {
    private final List<TextView> adminNameViews;
    private final Provider<AppConfig> appConfigProvider;
    private final LinearLayout avatarLayout;
    private final List<ImageView> avatarViews;
    private final TextView bioView;
    private final OfficeHoursTextView collapsedOfficeHours;
    private final TextView collapsedToolbarTitle;
    private final ViewGroup contentView;
    private final ProfilePresenter profilePresenter;
    private final ViewGroup rootLayout;
    private boolean shouldAddTransformHeight = true;
    private final ProfileToolbarBehavior toolbarBehavior;
    private final ImageView wallpaperImageView;

    TeamProfilePresenter(CoordinatorLayout coordinatorLayout, ProfilePresenter profilePresenter2, Provider<AppConfig> provider) {
        this.profilePresenter = profilePresenter2;
        this.rootLayout = (ViewGroup) coordinatorLayout.findViewById(R.id.intercom_team_profile);
        this.contentView = (ViewGroup) this.rootLayout.findViewById(R.id.toolbar_content_container);
        this.appConfigProvider = provider;
        this.rootLayout.setBackgroundColor(((AppConfig) provider.get()).getSecondaryColor());
        this.rootLayout.setAlpha(0.0f);
        this.collapsedToolbarTitle = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_title);
        this.collapsedOfficeHours = (OfficeHoursTextView) this.rootLayout.findViewById(R.id.intercom_collapsing_office_hours);
        this.avatarLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_team_profiles_layout);
        this.avatarViews = Arrays.asList(new ImageView[]{(ImageView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_avatar1), (ImageView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_avatar2), (ImageView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_avatar3)});
        this.adminNameViews = Arrays.asList(new TextView[]{(TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_name_1), (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_name_2), (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_name_3)});
        this.bioView = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_team_bio);
        this.toolbarBehavior = new TeamProfileToolbarBehavior(this.rootLayout);
        this.wallpaperImageView = (ImageView) this.rootLayout.findViewById(R.id.team_wallpaper_image);
        profilePresenter2.loadWallpaperInto(this.wallpaperImageView);
        updateColors(((AppConfig) provider.get()).secondaryColorRenderDarkText());
        LayoutParams layoutParams = (LayoutParams) this.contentView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + WindowUtils.getStatusBarHeight(this.contentView.getResources()), layoutParams.rightMargin, layoutParams.bottomMargin);
        this.contentView.setLayoutParams(layoutParams);
        ViewGroup viewGroup = this.contentView;
        viewGroup.startAnimation(AnimationUtils.loadAnimation(viewGroup.getContext(), R.anim.intercom_profile_slide_in));
    }

    private void setAvatar(Avatar avatar, ImageView imageView, n nVar) {
        imageView.setVisibility(0);
        AvatarUtils.loadAvatarIntoView(avatar, imageView, (AppConfig) this.appConfigProvider.get(), nVar);
    }

    private void setProfileTextView(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    private void updateColors(boolean z) {
        ColorUtils.setTextColorWhiteOrBlack(this.collapsedToolbarTitle, z);
        ColorUtils.setTextColorWhiteOrBlack(this.collapsedOfficeHours, z);
        ColorUtils.setTextColorWhiteOrBlack(this.bioView, z);
        for (TextView textColorWhiteOrBlack : this.adminNameViews) {
            ColorUtils.setTextColorWhiteOrBlack(textColorWhiteOrBlack, z);
        }
    }

    /* access modifiers changed from: 0000 */
    public ViewGroup getRootLayout() {
        return this.rootLayout;
    }

    /* access modifiers changed from: 0000 */
    public ProfileToolbarBehavior getToolbarBehavior() {
        return this.toolbarBehavior;
    }

    /* access modifiers changed from: 0000 */
    public void setPresence(TeamPresence teamPresence, int i2, AppBarLayout appBarLayout, View view, View view2, n nVar) {
        Context context = this.rootLayout.getContext();
        appBarLayout.b((c) this.toolbarBehavior);
        int i3 = 1;
        if (this.rootLayout.getAlpha() < 1.0f || this.avatarLayout.getVisibility() == 8) {
            view.setAlpha(0.0f);
            this.rootLayout.setAlpha(1.0f);
            if (this.profilePresenter.isDidShowUnknown()) {
                view2.requestLayout();
                appBarLayout.a(true, true);
                this.profilePresenter.setDidShowUnknown(false);
            }
        }
        List activeAdmins = teamPresence.getActiveAdmins();
        if (activeAdmins.isEmpty()) {
            this.avatarLayout.setVisibility(8);
        } else {
            this.avatarLayout.setVisibility(0);
            String officeHours = teamPresence.getOfficeHours();
            if (TextUtils.isEmpty(officeHours)) {
                this.collapsedOfficeHours.setText(teamPresence.getExpectedResponseDelay());
            } else {
                this.collapsedOfficeHours.setText(officeHours);
                this.collapsedOfficeHours.setOfficeHoursDrawable(ColorUtils.whiteOrBlackColor(context, ((AppConfig) this.appConfigProvider.get()).secondaryColorRenderDarkText()));
            }
            int i4 = 0;
            while (i4 < this.avatarViews.size() && i4 < activeAdmins.size()) {
                ImageView imageView = (ImageView) this.avatarViews.get(i4);
                TextView textView = (TextView) this.adminNameViews.get(i4);
                Participant participant = (Participant) activeAdmins.get(i4);
                setAvatar(participant.getAvatar(), imageView, nVar);
                imageView.setVisibility(0);
                textView.setText(participant.getForename());
                textView.setVisibility(0);
                i4++;
            }
        }
        setProfileTextView(this.bioView, ((AppConfig) this.appConfigProvider.get()).getTeamProfileBio());
        if (i2 == 0) {
            i2 = ScreenUtils.getScreenDimensions(context).x;
        }
        if (VERSION.SDK_INT >= 16) {
            i3 = this.collapsedOfficeHours.getMaxLines();
        }
        this.rootLayout.measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), 0);
        Resources resources = context.getResources();
        int measuredHeight = this.rootLayout.getMeasuredHeight();
        if (this.shouldAddTransformHeight) {
            measuredHeight += resources.getDimensionPixelSize(R.dimen.intercom_team_profile_translation_y);
            this.shouldAddTransformHeight = false;
        }
        view2.getLayoutParams().height = measuredHeight;
        this.rootLayout.getLayoutParams().height = resources.getDimensionPixelSize(R.dimen.intercom_toolbar_height);
        view2.requestLayout();
        this.collapsedOfficeHours.setMaxLines(i3);
        this.wallpaperImageView.getLayoutParams().height = measuredHeight;
        this.rootLayout.requestLayout();
        this.profilePresenter.applyOffsetChangedListener(this.toolbarBehavior);
    }

    /* access modifiers changed from: 0000 */
    public void setTeamCollapsingTitle(CharSequence charSequence) {
        this.collapsedToolbarTitle.setText(charSequence);
    }
}
