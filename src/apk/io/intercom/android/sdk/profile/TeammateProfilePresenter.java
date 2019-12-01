package io.intercom.android.sdk.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.g.a.a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.c;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Location;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.SocialAccount;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.GroupConversationTextFormatter;
import io.intercom.android.sdk.utilities.IntentUtils;
import io.intercom.android.sdk.utilities.LocationFormatter;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.android.sdk.views.ActiveStatePresenter;
import io.intercom.com.bumptech.glide.n;
import java.util.Date;
import java.util.List;

class TeammateProfilePresenter {
    private static final int FADE_DURATION_MS = 150;
    private final ActiveStatePresenter activeStatePresenter;
    private final View activeStateView;
    private final Provider<AppConfig> appConfigProvider;
    private final LinearLayout avatarHolder;
    private final Drawable avatarStroke;
    private final ImageView avatarView1;
    private final ImageView avatarView2;
    private final ImageView avatarView3;
    private final ImageView bioImageView;
    private final LinearLayout bioLayout;
    private final TextView bioView;
    private final int borderSize;
    private final ViewGroup contentView;
    private final LinearLayout groupConversationBanner;
    private final TextView groupConversationTitle;
    private final View groupSeparator;
    Location lastAdminLocation;
    private final ImageView linkedInButton;
    private final ImageView locationImageView;
    /* access modifiers changed from: private */
    public final LinearLayout locationLayout;
    final TextView locationView;
    private final ProfilePresenter profilePresenter;
    private final n requestManager;
    private final ImageView roleImageView;
    private final LinearLayout roleLayout;
    private final TextView roleView;
    private final ViewGroup rootLayout;
    private final int secondaryColor;
    private final LinearLayout socialLayout;
    private final TextView subtitleView;
    private final Runnable timeUpdate = new Runnable() {
        public void run() {
            TeammateProfilePresenter.this.locationView.removeCallbacks(this);
            CharSequence locationString = LocationFormatter.getLocationString(TeammateProfilePresenter.this.locationView.getContext(), TeammateProfilePresenter.this.lastAdminLocation, new Date());
            TeammateProfilePresenter teammateProfilePresenter = TeammateProfilePresenter.this;
            teammateProfilePresenter.setTextAndVisibility(teammateProfilePresenter.locationView, teammateProfilePresenter.locationLayout, locationString);
            LocationFormatter.postOnNextMinute(TeammateProfilePresenter.this.locationView, this, TimeProvider.SYSTEM);
        }
    };
    private final TextView titleView;
    private final TextView titleViewNameOnly;
    private final ProfileToolbarBehavior toolbarBehavior;
    private final Space topSpacer;
    private final ImageView twitterButton;
    private final ImageView wallpaperImageView;

    TeammateProfilePresenter(CoordinatorLayout coordinatorLayout, ProfilePresenter profilePresenter2, Provider<AppConfig> provider, n nVar) {
        this.profilePresenter = profilePresenter2;
        this.appConfigProvider = provider;
        this.requestManager = nVar;
        this.secondaryColor = ((AppConfig) provider.get()).getSecondaryColor();
        this.rootLayout = (ViewGroup) coordinatorLayout.findViewById(R.id.intercom_teammate_profile_container_view);
        this.rootLayout.setBackgroundColor(this.secondaryColor);
        this.contentView = (ViewGroup) this.rootLayout.findViewById(R.id.toolbar_content_container);
        this.topSpacer = (Space) this.rootLayout.findViewById(R.id.intercom_avatar_spacer);
        this.titleView = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_title);
        this.titleViewNameOnly = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_title_name_only);
        this.subtitleView = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_subtitle);
        this.roleView = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_role);
        this.locationView = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_location);
        this.bioView = (TextView) this.rootLayout.findViewById(R.id.intercom_collapsing_bio);
        this.roleLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_collapsing_role_layout);
        this.locationLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_collapsing_location_layout);
        this.bioLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_collapsing_bio_layout);
        this.roleImageView = (ImageView) this.rootLayout.findViewById(R.id.intercom_role_icon);
        this.locationImageView = (ImageView) this.rootLayout.findViewById(R.id.intercom_location_icon);
        this.bioImageView = (ImageView) this.rootLayout.findViewById(R.id.intercom_bio_icon);
        this.avatarView1 = (ImageView) this.rootLayout.findViewById(R.id.intercom_collapsing_teammate_avatar1);
        this.avatarView2 = (ImageView) this.rootLayout.findViewById(R.id.intercom_collapsing_teammate_avatar2);
        this.avatarView3 = (ImageView) this.rootLayout.findViewById(R.id.intercom_collapsing_teammate_avatar3);
        this.activeStateView = this.rootLayout.findViewById(R.id.intercom_collapsing_teammate_active_state);
        this.twitterButton = (ImageView) this.rootLayout.findViewById(R.id.twitter_button);
        this.linkedInButton = (ImageView) this.rootLayout.findViewById(R.id.linkedin_button);
        this.wallpaperImageView = (ImageView) coordinatorLayout.findViewById(R.id.teammate_wallpaper_image);
        this.socialLayout = (LinearLayout) coordinatorLayout.findViewById(R.id.social_button_layout);
        this.groupConversationBanner = (LinearLayout) coordinatorLayout.findViewById(R.id.intercom_group_conversations_banner);
        this.groupConversationTitle = (TextView) coordinatorLayout.findViewById(R.id.intercom_group_conversations_banner_title);
        this.groupSeparator = coordinatorLayout.findViewById(R.id.intercom_teammate_group_separator);
        this.avatarHolder = (LinearLayout) coordinatorLayout.findViewById(R.id.intercom_group_avatar_holder);
        this.toolbarBehavior = new TeammateProfileToolbarBehavior(this.rootLayout);
        this.activeStatePresenter = new ActiveStatePresenter();
        this.borderSize = ScreenUtils.dpToPx(2.0f, coordinatorLayout.getContext());
        this.avatarStroke = a.c(coordinatorLayout.getContext(), R.drawable.intercom_solid_circle);
        this.avatarStroke.setColorFilter(this.secondaryColor, Mode.MULTIPLY);
        this.avatarStroke.setAlpha(100);
        BackgroundUtils.setBackground(this.avatarView1, this.avatarStroke);
        BackgroundUtils.setBackground(this.avatarView2, this.avatarStroke);
        BackgroundUtils.setBackground(this.avatarView3, this.avatarStroke);
        ImageView imageView = this.avatarView1;
        int i2 = this.borderSize;
        imageView.setPadding(i2, i2, i2, i2);
        ImageView imageView2 = this.avatarView2;
        int i3 = this.borderSize;
        imageView2.setPadding(i3, i3, i3, i3);
        ImageView imageView3 = this.avatarView3;
        int i4 = this.borderSize;
        imageView3.setPadding(i4, i4, i4, i4);
        profilePresenter2.loadWallpaperInto(this.wallpaperImageView);
        updateColors(((AppConfig) provider.get()).secondaryColorRenderDarkText());
        LayoutParams layoutParams = (LayoutParams) this.contentView.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + WindowUtils.getStatusBarHeight(this.contentView.getResources()), layoutParams.rightMargin, layoutParams.bottomMargin);
        this.contentView.setLayoutParams(layoutParams);
        ViewGroup viewGroup = this.contentView;
        viewGroup.startAnimation(AnimationUtils.loadAnimation(viewGroup.getContext(), R.anim.intercom_profile_slide_in));
    }

    private void setGroupConversationParticipants(List<Participant> list, int i2) {
        if (list.size() > 0) {
            this.groupConversationBanner.setVisibility(0);
        } else {
            this.groupConversationBanner.setVisibility(8);
        }
        this.avatarHolder.removeAllViews();
        Context context = this.avatarHolder.getContext();
        int dpToPx = ScreenUtils.dpToPx(8.0f, context);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.intercom_group_conversations_banner_padding);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.intercom_teammate_avatar_size);
        int i3 = (i2 - (dimensionPixelSize * 2)) / (dimensionPixelSize2 + dpToPx);
        if (i3 > list.size()) {
            i3 = list.size();
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 != i3 - 1 || i3 >= list.size()) {
                Participant participant = (Participant) list.get(i4);
                if (participant != Participant.NULL) {
                    ImageView imageView = new ImageView(context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
                    layoutParams.setMargins(0, 0, dpToPx, 0);
                    imageView.setLayoutParams(layoutParams);
                    AvatarUtils.loadAvatarIntoView(participant.getAvatar(), imageView, (AppConfig) this.appConfigProvider.get(), this.requestManager);
                    this.avatarHolder.addView(imageView);
                }
            } else {
                TextView textView = new TextView(context);
                textView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
                textView.setTextColor(-1);
                textView.setGravity(17);
                int size = (list.size() - i3) + 1;
                StringBuilder sb = new StringBuilder();
                sb.append("+");
                sb.append(size);
                textView.setText(sb.toString());
                this.avatarHolder.addView(textView);
            }
        }
    }

    private void setSocialAccounts(final SocialAccount socialAccount, final SocialAccount socialAccount2, final Context context) {
        if (socialAccount == SocialAccount.NULL) {
            this.twitterButton.setVisibility(8);
        } else {
            this.twitterButton.setVisibility(0);
            this.twitterButton.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(socialAccount.getProfileUrl()));
                    IntentUtils.safelyOpenIntent(context, intent);
                }
            });
        }
        if (socialAccount2 == SocialAccount.NULL) {
            this.linkedInButton.setVisibility(8);
        } else {
            this.linkedInButton.setVisibility(0);
            this.linkedInButton.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(socialAccount2.getProfileUrl()));
                    IntentUtils.safelyOpenIntent(context, intent);
                }
            });
        }
        if (this.linkedInButton.getVisibility() == 8 && this.twitterButton.getVisibility() == 8) {
            this.socialLayout.setVisibility(8);
        } else {
            this.socialLayout.setVisibility(0);
        }
    }

    private void updateColors(boolean z) {
        ColorUtils.setTextColorWhiteOrBlack(this.titleView, z);
        ColorUtils.setTextColorWhiteOrBlack(this.titleViewNameOnly, z);
        ColorUtils.setTextColorWhiteOrBlack(this.bioView, z);
        ColorUtils.setTextColorWhiteOrBlack(this.roleView, z);
        ColorUtils.setTextColorWhiteOrBlack(this.locationView, z);
        ColorUtils.setTextColorWhiteOrBlack(this.groupConversationTitle, z);
        ColorUtils.setImageColorWhiteOrBlack(this.roleImageView, z);
        ColorUtils.setImageColorWhiteOrBlack(this.locationImageView, z);
        ColorUtils.setImageColorWhiteOrBlack(this.bioImageView, z);
        Context context = this.rootLayout.getContext();
        this.groupSeparator.setBackgroundColor(ColorUtils.whiteOrDarkColor(context, z));
        int whiteOrBlackColor = ColorUtils.whiteOrBlackColor(context, ((AppConfig) this.appConfigProvider.get()).secondaryColorRenderDarkText());
        this.twitterButton.setColorFilter(whiteOrBlackColor);
        this.linkedInButton.setColorFilter(whiteOrBlackColor);
        this.subtitleView.setTextColor(whiteOrBlackColor);
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
    public void setPresence(LastParticipatingAdmin lastParticipatingAdmin, List<Participant> list, CharSequence charSequence, int i2, AppBarLayout appBarLayout, ProfileState profileState, View view, View view2) {
        appBarLayout.b((c) this.toolbarBehavior);
        if (this.rootLayout.getAlpha() < 1.0f) {
            if (this.profilePresenter.isDidShowUnknown()) {
                this.rootLayout.setAlpha(1.0f);
                view.setAlpha(0.0f);
                appBarLayout.a(profileState == ProfileState.EXPANDED, true);
                this.profilePresenter.setDidShowUnknown(false);
            } else {
                this.rootLayout.animate().alpha(1.0f).setDuration(150).start();
                view.animate().alpha(0.0f).setDuration(150).start();
            }
        }
        Context context = this.rootLayout.getContext();
        this.titleView.setText(GroupConversationTextFormatter.groupConversationTitle(lastParticipatingAdmin.getFirstName(), list.size(), context));
        this.titleViewNameOnly.setText(lastParticipatingAdmin.getFirstName());
        setTeammateSubtitle(charSequence);
        int size = list.size();
        AvatarUtils.loadAvatarIntoView(lastParticipatingAdmin.getAvatar(), this.avatarView1, (AppConfig) this.appConfigProvider.get(), this.requestManager);
        if (size > 0) {
            this.avatarView2.setVisibility(0);
            AvatarUtils.loadAvatarIntoView(((Participant) list.get(size - 1)).getAvatar(), this.avatarView2, (AppConfig) this.appConfigProvider.get(), this.requestManager);
        } else {
            this.avatarView2.setVisibility(8);
        }
        if (size > 1) {
            this.avatarView3.setVisibility(0);
            AvatarUtils.loadAvatarIntoView(((Participant) list.get(size - 2)).getAvatar(), this.avatarView3, (AppConfig) this.appConfigProvider.get(), this.requestManager);
        } else {
            this.avatarView3.setVisibility(8);
        }
        this.activeStateView.setVisibility(0);
        this.activeStatePresenter.presentStateDot(lastParticipatingAdmin.isActive(), this.activeStateView, (AppConfig) this.appConfigProvider.get());
        setTextAndVisibility(this.roleView, this.roleLayout, lastParticipatingAdmin.getJobTitle());
        this.lastAdminLocation = lastParticipatingAdmin.getLocation();
        this.timeUpdate.run();
        setTextAndVisibility(this.bioView, this.bioLayout, lastParticipatingAdmin.getIntro());
        setSocialAccounts(lastParticipatingAdmin.getTwitter(), lastParticipatingAdmin.getLinkedIn(), context);
        if (i2 == 0) {
            i2 = ScreenUtils.getScreenDimensions(context).x;
        }
        setGroupConversationParticipants(list, i2);
        this.rootLayout.measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), 0);
        int measuredHeight = this.rootLayout.getMeasuredHeight();
        view2.getLayoutParams().height = measuredHeight;
        view2.requestLayout();
        this.wallpaperImageView.getLayoutParams().height = measuredHeight;
        this.rootLayout.getLayoutParams().height = context.getResources().getDimensionPixelSize(R.dimen.intercom_toolbar_height);
        this.rootLayout.requestLayout();
        this.profilePresenter.applyOffsetChangedListener(this.toolbarBehavior);
    }

    /* access modifiers changed from: 0000 */
    public void setTeammateSubtitle(CharSequence charSequence) {
        this.subtitleView.setText(charSequence);
    }

    /* access modifiers changed from: 0000 */
    public void setTextAndVisibility(TextView textView, LinearLayout linearLayout, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        textView.setText(charSequence);
        this.topSpacer.setVisibility(0);
    }

    /* access modifiers changed from: 0000 */
    public void stopUpdatingTime() {
        this.locationView.removeCallbacks(this.timeUpdate);
    }
}
